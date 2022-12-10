import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, Q;
        long[] F = new long[21];
        int[] S = new int[21];
        boolean[] visited = new boolean[21];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Q = Integer.parseInt(st.nextToken());
        F[0] = 1;
        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        if (Q == 1) {    // 소문제1
            long K = Long.parseLong(st.nextToken());
            for (int i = 1; i <= N; i++) {    // 해당 자리 번호
                for (int j = 1, cnt = 1; j <= N; j++) {    // j: 자리에 해당하는 수, cnt: 순서를 체크할 변수
                    if (visited[j]) {    // 이미 사용한 숫자는 재사용 불가
                        continue;
                    }

                    if (K <= F[N - i] * cnt) {    // 찾으려는 순서 <= 해당 자리 순열 수 * cnt
                        S[i] = j;                     // 해당 자리에 맞는 수 저장
                        K -= F[N - i] * (cnt - 1);    // 다음 자릿수를 찾기 위해 K를 업데이트
                        visited[j] = true;            // 사용한 숫자 처리
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= N; i++) {    // 소문제1 결과 출력
                System.out.print(S[i] + " ");
            }
        } else {    // 소문제2
            long K = 1;
            for (int i = 1; i <= N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < S[i]; j++) {
                    if (!visited[j]) {    // 미사용 숫자 체크
                        cnt++;
                    }
                }
                K += F[N - i] * cnt;    // 현재 자릿수에 대한 경우의 수 * 미사용 숫자 개수
                visited[S[i]] = true;
            }  
            System.out.println(K);    // 소문제2 결과 출력
        }
    }
}