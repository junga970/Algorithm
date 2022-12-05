import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static ArrayList<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());     // 노드 개수

        // 트리 구성
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        // 조상을 찾을 때, 노드의 부모로 차근차근 올라가며 찾지 않고 2^k 단위로 올라가며 찾을 것 (2번째, 4번째, 8번째, 16번째 부모 등등)
        // ex) 노드의 16번째 부모 == 노드의 8번째 부모의 8번째 부모
        // 2^0번째 부모부터 2^k번째 부모를 배열로 나타내기 위해 k 구하기 -> (트리의 깊이 > 2^k를 만족하는 k의 최댓값)

        int maxHeight = N - 1;    // 트리 높이로 올 수 있는 최댓값
        K = 1;    //
        while (true) {
            K++;

            if (Math.pow(2, K + 1) > maxHeight) {
                break;
            }
        }

        // 부모 배열 구성
        parent = new int[K + 1][N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(1);    // 부모노드, depth 구하기

        for (int k = 1; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                parent[k][n] = parent[k - 1][parent[k - 1][n]];  
            }
        }
        
        
        int M = Integer.parseInt(br.readLine());    // 질의 개수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int LCA = getLCA(node1, node2);
            System.out.println(LCA);
        }
    }

    static int getLCA(int node1, int node2) {
        if (depth[node1] > depth[node2]) {    // 더 깊은 노드가 node2가 되게
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        for (int k = K; k >= 0; k--) {    // 두 노드 depth 맞추기
            if (Math.pow(2, k) <= depth[node2] - depth[node1]) {
                if (depth[node1] <= depth[parent[k][node2]]) {
                    node2 = parent[k][node2];
                }
            }
        }

        for (int k = K; k >= 0 ; k--) {    // 조상 찾기
            if (parent[k][node1] != parent[k][node2]) {
                node1 = parent[k][node1];
                node2 = parent[k][node2];
            }
        }
        
        int LCA = node1;
        if (node1 != node2) {
            LCA = parent[0][node1];
        }
        return LCA;
    }

    static void BFS(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        int level = 1;
        int curSize = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int next : tree[curNode]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[0][next] = curNode;
                    depth[next] = level;
                }
            }
            count++;
            if (count == curSize) {
                count = 0;
                curSize = queue.size();
                level++;
            }
        }
    }
}