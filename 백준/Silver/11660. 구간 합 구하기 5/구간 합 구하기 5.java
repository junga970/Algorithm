import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] ajrgs) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    /* 1. 누적합 (1차원 배열로 처리) */
    int[] arr = new int[N * N + 1];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        int index = i * N + j;
        // System.out.println(index);
        int value = Integer.parseInt(st.nextToken());
        arr[index] = arr[index - 1] + value;
      }
    }

    // delete
    // System.out.println(Arrays.toString(arr));

    /* 2. 구간 합 구하기 */
    for (int n = 0; n < M; n++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int sum = 0;
      for (int i = x1 - 1; i < x2; i++) {
        int startI = i * N + y1;
        int endI = i * N + y2;
        
        /* 행별로 구간합 구하기 */
        sum += (arr[endI] - arr[startI - 1]);
      }

      /* 결과 출력 */
      System.out.println(sum);
    }
  }
}
