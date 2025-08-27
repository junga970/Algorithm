import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        // 탐색 시작점을 최적화: N – (자릿수 × 9)까지 내려가면 충분
        int len = String.valueOf(N).length();
        int start = Math.max(1, N - len * 9);

        for (int i = start; i < N; i++) {
            int sum = i, tmp = i;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum == N) {
                result = i;
                break;
            }
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
    }
}
