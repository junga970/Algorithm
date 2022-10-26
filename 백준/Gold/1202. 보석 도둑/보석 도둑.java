import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<int[]> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new int[] {M, V});
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        jewels.sort((x, y) -> x[0] - y[0]);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int i = 0, j = 0; i < bags.length; i++) {
            while (j < jewels.size() && bags[i] >= jewels.get(j)[0]) {
                pq.add(jewels.get(j++)[1]);
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        System.out.println(sum);
    }
}