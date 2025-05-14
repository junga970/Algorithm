import java.util.*;
import java.io.*;

public class Main {
  static int N, M;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    /* 데이터 초기화 */
    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    /* 정렬 */
    Arrays.sort(arr);

    /* 요소별 이진탐색 */
    for (int i = 0; i < M; i++) {
      int X = Integer.parseInt(st.nextToken());
      int result = search(X);

      /* 결과 출력 */
      System.out.println(result);
    }

  }

  static int search(int target) {
    int result = 0;

    // X 찾기
    int start = 0;
    int end = N - 1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (target == arr[mid]) {
        result = 1;
        break;
      } else if (target < arr[mid]) { // mid값이 target 보다 작을 때 "왼쪽 영역" 탐색 준비
        end = mid - 1;
      } else { // mid값이 target 보다 클 때 "오른쪽 영역" 탐색 준비
        start = mid + 1;
      }
    }

    return result;
  }

}