import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 기준 배열
        int[] nums = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 합 배열
        int[] S = new int[N + 1];
        for (int i = 1; i < nums.length; i++) {
            S[i] = S[i - 1] + nums[i];
        }

        // 구간 합 출력
        int start;
        int end;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            System.out.println(S[end] - S[start - 1]);
        }
    }
}
