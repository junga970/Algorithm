import java.util.*;
import java.io.*;

/* 2번째 제출 - 투포인터 사용 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int startN = 1;
        int endN = 1;
        int sum = 1;

        int cnt = 1; // 자기 자신 N 추가
        while (startN < N / 2 + 1) {
            if (sum < N) {
                /*
                 * 합이 N보다 작을 때
                 * 값을 늘려야 하므로 endN을 높여줌 -> sum에 endN 더하기
                 */
                endN++;
                sum += endN;
            } else if (sum > N) {
                /*
                 * 합이 N보다 클 때
                 * 값을 줄여야 하므로 startN을 높여줌 -> sum에 startN 빼기
                 */
                sum -= startN;
                startN++;
            } else { // sum = N 일때 cnt 증가
                cnt++;
                endN++;
                sum += endN;
            }
        }

        System.out.println(cnt);
    }
}

/* 1번째 제출 - 시간 초과 */
// public class Main {
// static String input = """
// 15
// """;

// public static void main(String[] args) throws IOException {
// BufferedReader br = new BufferedReader(new StringReader(input));
// // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// int N = Integer.parseInt(br.readLine());

// int cnt = 1; // N 자기 자신 추가
// int start = 1;
// int flag = (N / 2) + 1;

// while (start <= flag) {
// int sum = 0;
// for (int n = start; n <= flag; n++) {
// sum += n;
// if (sum == N) {
// cnt++;
// break;
// }
// }
// start++;
// }

// System.out.println(cnt);
// }
// }
