import java.util.*;
import java.io.*;

class Main {
  static int V, E, K;
  static ArrayList<Edge>[] graph;
  static int[] distance;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(br.readLine());

    // 그래프, 거리배열 초기화
    distance = new int[V + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);

    graph = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    // 그래프 간선 연결
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph[u].add(new Edge(v, w));
    }

    // 최단 거리 구하기(K로부터)
    distance[K] = 0;
    PriorityQueue<Edge> queue = new PriorityQueue<>();
    queue.offer(new Edge(K, 0));

    while (!queue.isEmpty()) {
      Edge cur = queue.poll();

      for (Edge next : graph[cur.node]) {
        int newDist = distance[cur.node] + next.weight;
        if (distance[next.node] > newDist) {
          distance[next.node] = newDist;
          queue.offer(new Edge(next.node, newDist));
        }
      }
    }

    // 결과 출력
    for (int i = 1; i <= V; i++) {
      if (distance[i] == Integer.MAX_VALUE) {
        bw.write("INF" + "\n");
      } else {
        bw.write(distance[i] + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}

class Edge implements Comparable<Edge> {
  int node;
  int weight;

  public Edge(int node, int weight) {
    this.node = node;
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge e) {
    return this.weight - e.weight;
  }
}

// import java.util.*;
// import java.io.*;

// class Main {
// static String input = """
// 5 6
// 1
// 5 1 1
// 1 2 2
// 1 3 3
// 2 3 4
// 2 4 5
// 3 4 6
// """;

// static int V, E, K;
// static ArrayList<Edge>[] graph;
// static int[] distance;
// public static void main(String[] args) throws IOException {

// // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// BufferedReader br = new BufferedReader(new StringReader(input));
// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

// StringTokenizer st = new StringTokenizer(br.readLine());
// V = Integer.parseInt(st.nextToken());
// E = Integer.parseInt(st.nextToken());
// K = Integer.parseInt(br.readLine());

// // 그래프, 거리배열 초기화
// distance = new int[V + 1];
// Arrays.fill(distance, Integer.MAX_VALUE);

// graph = new ArrayList[V + 1];
// for (int i = 1; i <= V; i++) {
// graph[i] = new ArrayList<>();
// }

// // 그래프 간선 연결
// for (int i = 0; i < E; i++) {
// st = new StringTokenizer(br.readLine());
// int u = Integer.parseInt(st.nextToken());
// int v = Integer.parseInt(st.nextToken());
// int w = Integer.parseInt(st.nextToken());

// graph[u].add(new Edge(v, w));
// }

// // 최단 거리 구하기(K로부터)
// distance[K] = 0;
// Queue<Integer> queue = new LinkedList<>();
// queue.offer(K);

// System.out.println("K + " + K);
// while(!queue.isEmpty()) {
// int cur = queue.poll();
// int curDist = distance[cur];

// for (Edge nextEdge : graph[cur]) {
// if (distance[nextEdge.node] > curDist + nextEdge.weight) {
// distance[nextEdge.node] = curDist + nextEdge.weight;
// queue.offer(nextEdge.node);
// }
// }
// }

// // 결과 출력
// for (int i = 1; i <= V; i++) {
// if (distance[i] == Integer.MAX_VALUE) {
// bw.write("INF" + "\n");
// } else {
// bw.write(distance[i] + "\n");
// }
// }

// bw.flush();
// bw.close();
// }
// }

// class Edge {
// int node;
// int weight;

// public Edge (int node, int weight) {
// this.node = node;
// this.weight = weight;
// }
// }