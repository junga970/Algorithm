import java.util.*;
import java.io.*;

public class Main {
  /*
   * 1. 데이터 초기화
   * 2. 모든 요소 dfs 탐색(방문한 경우 패스)
   * 3. 방문하지 않은 요소를 탐색할 때마다 카운트 처리
   */

  static int N;
  static int M;

  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int graphCnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 데이터 초기화
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N + 1];
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    // 간설 연결
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      graph[node1].add(node2);
      graph[node2].add(node1);
    }

    // dfs 탐색
    for (int i = 1; i <= N; i++) {
      if (visited[i]) {
        continue;
      }

      graphCnt++;
      dfs(i);
    }

    System.out.println(graphCnt);
  }

  static void dfs(int node) {
    visited[node] = true; // 방문처리

    for (Integer nextNode : graph[node]) {
      if (!visited[nextNode]) {
        dfs(nextNode);
      }
    }
  }
}