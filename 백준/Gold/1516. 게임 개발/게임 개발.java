import java.util.*;
import java.io.*;

class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] times;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        /* 1. data 초기화 */
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        times = new int[N + 1];
        indegree = new int[N + 1];

        // graph 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;    // 시간 저장

            int pre;
            while((pre = Integer.parseInt(st.nextToken())) != -1) {
                graph[pre].add(i);   // 간선 연결
                indegree[i]++;       // pre의 진입 차수 카운트
            }
        }

        int[] result = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) { // 진입차수가 0일 경우 바로 지을 수 있는 건물
                queue.offer(i);
                result[i] = times[i];
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next : graph[cur]) {
                result[next] = Math.max(result[next], times[next] + result[cur]);
                
                if (--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}