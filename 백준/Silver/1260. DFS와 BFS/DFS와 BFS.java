import java.util.*;
import java.io.*;

public class Main {
  static int N, M, V;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    // 그래프 초기화
    graph = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    // 간선 연결
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      graph[node1].add(node2);
      graph[node2].add(node1);
    }

    // 정렬
    for (int i = 1; i <= N; i++) {
      Collections.sort(graph[i]);
    }

    // dfs
    visited = new boolean[N + 1];
    dfs(V);

    System.out.print('\n');

    // bfs
    visited = new boolean[N + 1];
    bfs(V);
  }

  static void dfs(int node) {
    System.out.print(node + " ");

    visited[node] = true;
    for (Integer next : graph[node]) {
      if (visited[next]) {
        continue;
      }

      dfs(next);
    }
  }

  static void bfs(int node) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(node);
    visited[node] = true;

    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      System.out.print(cur + " ");

      for (Integer next : graph[cur]) {
        if (visited[next]) {
          continue;
        }
        queue.offer(next);
        visited[next] = true;
      }
    }
  }
}