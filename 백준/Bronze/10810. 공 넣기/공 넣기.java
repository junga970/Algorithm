import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int iStart = Integer.parseInt(st.nextToken());
            int jEnd = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            for (int k = iStart; k <= jEnd; k++) {
                arr[k] = val;
            }
        }
        for (int i = 1; i <= n; i++) {
            bw.write(arr[i] + (i == n ? "\n" : " "));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
