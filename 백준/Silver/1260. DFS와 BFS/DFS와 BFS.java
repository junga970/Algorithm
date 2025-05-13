import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        // dfs
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // bfs
        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        for (int v : graph[vertex]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        
        while (!queue.isEmpty()) {
            int curV = queue.poll();
            System.out.print(curV + " ");
            
            for (int v : graph[curV]) {
                if(!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}