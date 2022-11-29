import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 건물 수 N
        int N = Integer.parseInt(br.readLine());
        
        // 그래프 표현
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] time = new int[N + 1];        // 건물을 짓는데 걸리는 시간
        int[] indegree = new int[N + 1];    // 진입 차수 배열
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int parent = Integer.parseInt(st.nextToken());
                if (parent == -1) {
                    break;
                }
                // 그래프 연결
                graph[parent].add(i);

                // 진입 차수 업데이트
                indegree[i]++;
            }
        }

        // 정답 배열
        int[] result = new int[N + 1];

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                result[i] = time[i];
            }
        }
        
        while (!queue.isEmpty()) {
            int curN = queue.poll();
            for (int n : graph[curN]) {
                indegree[n]--;
                result[n] = Math.max(result[n], result[curN] + time[n]);

                if (indegree[n] == 0) {
                    queue.add(n);
                }
            }
        }
        
        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}