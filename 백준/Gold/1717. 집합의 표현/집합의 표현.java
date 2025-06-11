import java.util.*;
import java.io.*;

class Main {
  
    static int N;
    static int M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 데이터 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (q == 0) {
                // union: 대표 노드끼리 연결
                union(a, b);
            } else {
                // find: 대표 노드 찾기 및 업데이트
                int parentA = find(a);
                int parentB = find(b);

                if (parentA == parentB) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        
        bw.flush();
        bw.close();
    }

    // union: 대표 노드끼리 연결
    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentB] = parentA;
        }
    }

    // find: 대표 노드 찾기 및 업데이트
    static int find(int n) {
        // 종료 조건 n == parent[n]
        if (n == parent[n]) return n;

        return parent[n] = find(parent[n]);
    }
}
