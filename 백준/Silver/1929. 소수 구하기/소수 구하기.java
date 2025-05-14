import java.util.*;
import java.io.*;

public class Main {
  static int M;
  static int N;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    /* 데이터 초기화 */
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    arr = new int[N + 1];
    for (int i = 2; i <= N; i++) {
      arr[i] = i;
    }

    /* 소수가 아닌 수 삭제 (0으로 처리) */
    for (int i = 2; i <= Math.sqrt(N); i++) { // N의 제곱근까지만 처리
      if (arr[i] == 0) {
        continue;
      }
      for (int j = i * 2; j <= N; j += i) {
        arr[j] = 0;
      }
    }

    for (int i = M; i <= N; i++) {
      if (arr[i] != 0) {
        bw.write(i + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}