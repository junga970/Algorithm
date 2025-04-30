import java.util.*;
import java.io.*;

/* 두번째 제출 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    /* 1. 누적합의 나머지 구하기 */
    long[] arr = new long[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      arr[i] += arr[i - 1];
    }
      
    for (int i = 1; i <= N; i++) {
      arr[i] %= M; // 누적합을 M으로 나눈 나머지 저장
    }

    /* 2. 경우의 수 */
    long[] C = new long[M + 1]; // 나머지별 카운트 배열
    for (int i = 1; i <= N; i++) {
      C[(int) arr[i]]++;
    }

    long cnt = C[0]; // 구간이 1일 때 나머지가 0인 요소 미리 추가
    for (int n = 0; n <= M; n++) {
      // nC2: n개 중 2개를 뽑는 경우의 수 -> n(n-1) * 2
      cnt += C[n] * (C[n] - 1) / 2;
    }

    /* 3. 결과 출력 */
    System.out.println(cnt);
  }
}

/* 첫번째 제출 - 시간 초과 */
// public class Main {
// public static void main(String[] args) throws IOException{
// String input = """
// 5 3
// 1 2 3 1 2
// """;

// // delete
// BufferedReader br = new BufferedReader(new StringReader(input));
// // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// StringTokenizer st = new StringTokenizer(br.readLine());
// int N = Integer.parseInt(st.nextToken());
// int M = Integer.parseInt(st.nextToken());

// /* 1. 누적합 구하기 */
// int arr[] = new int[N + 1];
// st = new StringTokenizer(br.readLine());
// for(int i = 1; i <= N; i++) {
// arr[i] = Integer.parseInt(st.nextToken());
// arr[i] += arr[i - 1];
// }

// /* 2. 1 ~ N 개의 구간별로 확인 */
// int cnt = 0;
// for(int n = 1; n <= N; n++) {
// for(int i = n; i <= N; i++) {
// int prefixSum = arr[i] - arr[i - n];
// if (prefixSum % M == 0) cnt++;
// }
// }

// /* 3. 결과 출력 */
// System.out.println(cnt);
// }
// }
