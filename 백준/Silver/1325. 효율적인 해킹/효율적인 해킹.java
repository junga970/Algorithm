import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[][] visited; // node에서 i로 갈 수 있는지

    /*
     * 1. 데이터 초기화(grpah, visited)
     * 2. node별로 bfs 탐색
     * 2-1. 노드별로 해킹할 수 있는 컴퓨터를 visited에 check
     * 2-2. 이미 체크한 노드(현재 노드 이전 노드들)가 탐색되는 경우 queue에 넣지 않고 visited를 통해 해킹컴퓨터를 체크함
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /* 1. 데이터 초기화 */
        // graph 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        // visited 초기화
        visited = new boolean[N + 1][N + 1];

        /* 2. 노드별로 BFS 탐색 */
        int max = 0;
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int cnt = bfs(i);
            result[i] = cnt;
            max = Math.max(max, cnt);
        }

        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        int cnt = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[node][cur]) continue;
            visited[node][cur] = true; // 방문 처리
            cnt++; // 카운트 증가

            for (int next : graph[cur]) {
                if (visited[node][next]) {
                    // 이미 방문한 노드면 넘어감(양방향 그래프일 때)
                    continue;
                }

                if (next <= node) {
                    // 현재 node보다 작은 next는 이미 해킹할 수 있는 컴퓨터 목록을 가지고 있음
                    for (int i = 1; i <= N; i++) {
                        if (visited[next][i] && !visited[node][i]) { // node -> next -> i 간접 경로를 통해 정보를 얻음
                            visited[node][i] = true;
                            cnt++;
                        }
                    }
                } else {
                    queue.offer(next);
                }
            }
        }
        return cnt;
    }
}
