import java.io.*;
import java.util.*;

public class Main {
    static int K, V, E;
    static ArrayList<Integer>[] graph;
    static int[] vSet; // 각 정점이 집합 1에 속하는지 2에 속하는지 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 1. 데이터 초기화 */
        K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            vSet = new int[V + 1];

            // 그래프 초기화
            for (int v = 1; v <= V; v++) {
                graph[v] = new ArrayList<>();
            }
            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            /* 2. bfs를 통해 이분 그래프인지 탐색 
             * 이어진 그래프가 2개 이상인 경우를 생각해서 for문으로 탐색(ex 1-2-3, 4-5-6)
            */
            String result = "YES";
            for (int v = 1; v < V; v++) {
                if (vSet[v] == 0 && !bfs(v)) {
                    result = "NO";
                    break;
                }
            }
            

            /* 3. 결과 출력 */
            System.out.println(result);
        }
    }

    static boolean bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        // 첫 정점 집합 1로 시작
        vSet[node] = 1;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curSet = vSet[cur];

            for (int next : graph[cur]) {
                // 집합이 정해지지 않은 경우
                if (vSet[next] == 0) {
                    vSet[next] = (curSet == 1) ? 2 : 1;
                    queue.offer(next);
                    continue;
                }

                // 어어진 정점이 같은 집합인 경우 이분 그래프가 아님
                if (vSet[cur] == vSet[next]) {
                    return false;
                }
            }
        }

        return true;
    }
}