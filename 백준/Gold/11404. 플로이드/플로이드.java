import java.util.*;
import java.io.*;

class Main {

    static int N, M;
    static int[][] graph;
    static int INF = 100_000_000;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 데이터 초기화
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        // 간선 초기화
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (graph[A][B] > C)
                graph[A][B] = C;
        }

        // 플로이드-워셜
        // D[S][E] = D[S][K] + D[K][S]
        for (int k = 1; k <= N; k++) { // 중간 경로 K
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (graph[s][e] > graph[s][k] + graph[k][e]) {
                        graph[s][e] = graph[s][k] + graph[k][e];
                    }
                }
            }
        }

        // 결과 출력
        for (int s = 1; s <= N; s++) {
            for (int e = 1; e <= N; e++) {
                if (graph[s][e] == INF) {
                    bw.write("0 ");
                } else {
                    bw.write(graph[s][e] + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}