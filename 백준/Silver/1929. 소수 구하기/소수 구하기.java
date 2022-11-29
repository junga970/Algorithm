import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 0 ~ N 배열
        int[] nums = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            nums[i] = i;
        }

        // 에라토스테네스의 체, 소수 판별
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (nums[i] == 0) {
                continue;
            }

            // 배수 지우기(0으로 초기화)
            for (int j = i * 2; j <= N ; j += i) {
                nums[j] = 0;
            }
        }

        // 결과 출력
        for (int i = M; i <= N ; i++) {
            if (nums[i] != 0) {
                System.out.println(i);
            }
        }
    }
}