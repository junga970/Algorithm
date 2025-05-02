
import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int M;
  static int K;
  static int X;
  static int[] result; // 노드별 최단 거리
  static boolean[] visited;
  static List<ArrayList<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    result = new int[N + 1];
    visited = new boolean[N + 1];

    /* 1. 인접 리스트 구현 */
    for (int i = 0; i <= N; i++) { // 초기화
      graph.add(new ArrayList<Integer>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      ArrayList<Integer> el = graph.get(node1);
      el.add(node2);
    }

    /* 2. bfs */
    bfs(X);
      
    /* 결과 출력 */
    boolean flag = false;
    for (int i = 1; i < result.length; i++) {
      if (result[i] == K) {
        System.out.println(i);
        flag = true;
      }
    }
      
    if (!flag) System.out.println(-1);
  };

  static void bfs(int startNode) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(startNode);
    visited[startNode] = true;

    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      ArrayList<Integer> nodes = graph.get(cur);
      for (Integer node : nodes) {
        if (!visited[node]) {
          visited[node] = true; // 방문처리
          result[node] = result[cur] + 1;
          queue.offer(node);
        }
      }
    }
  }
}
