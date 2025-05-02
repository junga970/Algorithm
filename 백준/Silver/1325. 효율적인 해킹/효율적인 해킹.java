import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int N, M, max;
    static int [] counts;
    static boolean [][] visited;
    static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = 0;
        visited = new boolean[N + 1][N + 1];
        adjList = new ArrayList<>();
        counts = new int[N + 1];
        for (int i=0;i<=N;i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(b).add(a);
        }

        StringBuilder sb = new StringBuilder();

        for (int i=1;i<=N;i++) {
            bfs(i);
        }

        for (int i=1;i<=N;i++) {
            if (counts[i] == max) {
                sb.append(i).append(' ');
            }
        }

        bw.write(sb.substring(0, sb.length()-1));
        bw.close();
        br.close();
    }

    private static void bfs(int node) {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(node);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (visited[node][cur]) continue;
            visited[node][cur] = true;
            counts[node]++;

            for (int next : adjList.get(cur)) {
                if (visited[node][next]) continue;

                if (next > node) {
                    q.offer(next);
                } else {
                    for (int i=1;i<=N;i++) {
                        if (visited[node][i]) continue;
                        if (visited[next][i]) {
                            visited[node][i] = true;
                            counts[node]++;
                        }
                    }
                }
            }
        }

        max = Math.max(max, counts[node]);
    }
}