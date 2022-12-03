import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());   // 정점 개수
        int E = Integer.parseInt(st.nextToken());   // 간선 개수

        parent = new int[V + 1];    // 부모 노드 배열
        for (int i = 0; i <= V; i++) {
            parent[i] = i;    // 자기 자신으로 초기화
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>();  // 가중치 오름차순 자동 정렬
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            queue.add(new Edge(A, B, C));
        }

        int result = 0;
        int cnt = 0;
        while (cnt < V - 1) {
            Edge edge = queue.poll();
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                result += edge.weight;
                cnt++;
            }
        }
        
        // 결과 출력
        System.out.println(result);
    }
    static void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        
        if (parent1 != parent2) {
            parent[parent2] = parent1;
        }
    }

    static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
}