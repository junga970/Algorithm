import java.util.*;
import java.io.*;

class Main {

  static int N, M;
  static Edge[] edges;
  static long[] distance;

  static final long INF = Long.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 데이터 초기화
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    // - 간선 리스트 초기화
    edges = new Edge[M];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int time = Integer.parseInt(st.nextToken());

      edges[i] = new Edge(start, end, time);
    }

    // - 최단 경로 리스트 초기화
    distance = new long[N + 1];
    Arrays.fill(distance, INF);
    distance[1] = 0;

    // (N - 1)번 최단 경로 업데이트
    for (int i = 1; i < N; i++) {

      for (int j = 0; j < M; j++) {
        Edge edge = edges[j];

        if (distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.time) {
          distance[edge.end] = distance[edge.start] + edge.time;
        }
      }
    }

    // 최종 업데이트 후 업데이트가 되면 음수 싸이클이 있는 것으로 판단
    boolean cycle = false;
    for (int j = 0; j < M; j++) {
      Edge edge = edges[j];

      if (distance[edge.start] != INF && distance[edge.end] > distance[edge.start] + edge.time) {
        cycle = true;
        bw.write("-1");
        bw.flush();
        bw.close();
        return;
      }
    }

    for (int i = 2; i <= N; i++) {
      if (distance[i] == INF) {
        bw.write("-1" + "\n");
      } else {
        bw.write(distance[i] + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}

class Edge {
  int start, end, time;

  public Edge(int start, int end, int time) {
    this.start = start;
    this.end = end;
    this.time = time;
  }
}