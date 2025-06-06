import java.util.*;
import java.io.*;

class Main {
  static int N, M, K;
  static ArrayList<Edge>[] graph;
  static PriorityQueue<Integer>[] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 데이터 초기화
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];
    distance = new PriorityQueue[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
      distance[i] = new PriorityQueue<>(Collections.reverseOrder()); // 거리 내림차순
    }

    // 간선 연결
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      graph[a].add(new Edge(b, c));
    }

    // 경로 탐색
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(1, 0));
    distance[1].offer(0);

    while(!pq.isEmpty()) {
      Edge cur = pq.poll();

      for (Edge next : graph[cur.vertex]) {
        int dist = cur.weight + next.weight;

        if (distance[next.vertex].size() < K) { // 현재 기준 K번째 최단 경로가 없을 떄
          distance[next.vertex].offer(dist);
          pq.offer(new Edge(next.vertex, dist));
        } else if (distance[next.vertex].peek() > dist) { // 현재 기준 K번째 최단 경로가 이미 있을 때
          distance[next.vertex].poll(); // 가장 큰 값 제거
          distance[next.vertex].offer(dist);
          pq.offer(new Edge(next.vertex, dist));
        }
      }
    }

    // 결과 출력
    for (int i = 1; i <= N; i++) {
      if (distance[i].size() == K) {
        bw.write(distance[i].peek() + "\n");
      } else {
        bw.write(-1 + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}

class Edge implements Comparable<Edge> {
  int vertex;
  int weight;

  public Edge(int vertex, int weight) {
    this.vertex = vertex;
    this.weight = weight;
  }

  @Override
  public int compareTo(Edge e) {
    return this.weight - e.weight;
  }
}