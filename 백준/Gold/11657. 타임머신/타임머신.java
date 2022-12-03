import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 도시 개수
        int M = Integer.parseInt(st.nextToken());   // 간선 개수

        long[] dist = new long[N + 1];
        Edge[] edges = new Edge[M];     // 간선 배열
        Arrays.fill(dist, INF);         // 최단 거리 배열 초기화

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);
        }

        // 밸만-포드 알고리즘
        dist[1] = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.time) {
                    dist[edge.end] = dist[edge.start] + edge.time;
                }
            }
        }

        boolean cycle = false;
        for (int j = 0; j < M; j++) {   // 음수싸이클 확인
            Edge edge = edges[j];
            if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.time) {
                cycle = true;
            }
        }

        if (cycle) {    // 음수싸이클 있을 때
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
}