import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 인접 행렬
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }

        // k번째 최단경로를 구하기 위한 우선순위 큐 배열 -> 자동 정렬
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            // 내림 차순으로 정렬되야함
            distQueue[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        // 다익스트라 알고리즘
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        distQueue[1].add(0);

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.node;
            int cost = edge.cost;

            for (int adjNode = 1; adjNode <= n; adjNode++) {
                if (graph[node][adjNode] != 0) {            // 인접 노드 탐색
                    if (distQueue[adjNode].size() < k) {    // size가 k보다 작을 땐 바로 추가
                        distQueue[adjNode].add(cost + graph[node][adjNode]);
                        pq.add(new Edge(adjNode, cost + graph[node][adjNode]));
                    } else if (distQueue[adjNode].peek() > cost + graph[node][adjNode]) {
                        // size가 k 이고, 우선순위 큐의 max 값 보다 작을 때만 추가 -> max 값 삭제
                        distQueue[adjNode].poll();
                        distQueue[adjNode].add(cost + graph[node][adjNode]);
                        pq.add(new Edge(adjNode, cost + graph[node][adjNode]));
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= n; i++) {
            if (distQueue[i].size() == k) {
                System.out.println(distQueue[i].peek());
            } else {
                System.out.println(-1);
            }
        }
    }
}