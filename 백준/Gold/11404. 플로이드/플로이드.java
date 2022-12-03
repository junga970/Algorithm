import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 999_999_999;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 도시 개수
        int m = Integer.parseInt(br.readLine());    // 버스 개수
        int[][] dist = new int[n + 1][n + 1];       // 최단 거리 배열

        for (int i = 0; i <= n; i++) {      // 최단 거리 배열 초기화
            for (int j = 0; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {   // 간선 비용 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (dist[a][b] > c) {
                dist[a][b] = c;
            }
        }
        
        // 플로이드-워셜
        for (int k = 1; k <= n ; k++) {     // 경유지 k
            for (int s = 1; s <= n; s++) {      // 출발 노드 s
                for (int e = 1; e <= n; e++) {      // 도착 노드 e
                    if (dist[s][e] > dist[s][k] + dist[k][e]) {
                        dist[s][e] = dist[s][k] + dist[k][e];
                    }
                }
            }
        }
        
        // 결과 출력
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}