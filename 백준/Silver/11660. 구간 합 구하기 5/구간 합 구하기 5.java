import java.io.*;
import java.util.*;

/* 2번째 풀이 */
public class Main {
  public static void main(String[] ajrgs) throws IOException {
    // String input = """
    //     4 3
    //     1 2 3 4
    //     2 3 4 5
    //     3 4 5 6
    //     4 5 6 7
    //     2 2 3 4
    //     3 4 3 4
    //     1 1 4 4
    //     """;

    // String input = """
    // 2 4
    // 1 2
    // 3 4
    // 1 1 1 1
    // 1 2 1 2
    // 2 1 2 1
    // 2 2 2 2
    // """;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // delete
    // BufferedReader br = new BufferedReader(new StringReader(input));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    /* 1. 2차원 배열 누적합 */
    int[][] board = new int[N + 1][N + 1];

    // 원본 배열
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 1행, 1열 누적합 구하기
    for (int i = 2; i <= N; i++) {
      board[1][i] += board[1][i - 1];
    }
    for (int i = 2; i <= N; i++) {
      board[i][1] += board[i - 1][1];
    }

    // 1행, 1열 제외 나머지 누적합 구하기
    for (int i = 2; i <= N; i++) {
      for (int j = 2; j <= N; j++) {
        // 현재 노드 값 + (현재 노드의 위값 + 왼쪽값 - 좌측상단 대각선값)
        board[i][j] += (board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1]);
      }
    }

    // delete
    // for (int i = 0; i <= N; i++) {
    //   for (int j = 0; j <= N; j++) {
    //     System.out.print(board[i][j] + " ");
    //   }
    //   System.out.println();
    // }

    /* 2. 각 구간합 출력 */
    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken()); // 2
      int y1 = Integer.parseInt(st.nextToken()); // 2
      int x2 = Integer.parseInt(st.nextToken()); // 3
      int y2 = Integer.parseInt(st.nextToken()); // 4

      int endSum = board[x2][y2];
      int rowSum = board[x1 - 1][y2];
      int colSum = board[x2][y1 - 1];
      int startSum = board[x1 - 1][y1 - 1];

      int result = endSum - rowSum - colSum + startSum;
      System.out.println(result);
    }
  }
}

/* 1번째 풀이 */
// public class Main {
// public static void main(String[] ajrgs) throws IOException {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

// StringTokenizer st = new StringTokenizer(br.readLine());
// int N = Integer.parseInt(st.nextToken());
// int M = Integer.parseInt(st.nextToken());

// /* 1. 누적합 (1차원 배열로 처리) */
// int[] arr = new int[N * N + 1];
// for (int i = 0; i < N; i++) {
// st = new StringTokenizer(br.readLine());
// for (int j = 1; j <= N; j++) {
// int index = i * N + j;

// int value = Integer.parseInt(st.nextToken());
// arr[index] = arr[index - 1] + value;
// }
// }

// /* 2. 구간 합 구하기 */
// for (int n = 0; n < M; n++) {
// st = new StringTokenizer(br.readLine());
// int x1 = Integer.parseInt(st.nextToken());
// int y1 = Integer.parseInt(st.nextToken());
// int x2 = Integer.parseInt(st.nextToken());
// int y2 = Integer.parseInt(st.nextToken());

// int sum = 0;
// for (int i = x1 - 1; i < x2; i++) {
// int startI = i * N + y1;
// int endI = i * N + y2;

// /* 행별로 구간합 구하기 */
// sum += (arr[endI] - arr[startI - 1]);
// }

// /* 결과 출력 */
// System.out.println(sum);
// }
// }
// }
