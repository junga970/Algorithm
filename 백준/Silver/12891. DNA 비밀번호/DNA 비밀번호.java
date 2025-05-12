import java.io.*;
import java.util.*;

/*
 * 1. 데이터 초기화
 * 2. 슬라이딩 윈도우를 이용해 순차적으로 조건에 해당하는지 확인
 */
public class Main {
  static int S, P;
  static int[] checkArr = new int[4]; // A, C, G, T 조건 개수
  static int[] curArr = new int[4]; // 현재 상태(A, C, G, T 개수)
  static int checkCount; // A, C, G, T 중 몇개가 조건을 충족하는지
  static int resultCount;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    char[] dnaArr = br.readLine().toCharArray();

    // checkArr 초기화
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      checkArr[i] = Integer.parseInt(st.nextToken());
      if (checkArr[i] == 0) {
        checkCount++;
      }
    }

    // curArr 초기화
    for (int i = 0; i < P; i++) {
      add(dnaArr[i]);
    }

    if (checkCount == 4) {
      resultCount++;
    }

    // 슬라이딩 윈도우
    for (int i = 0; i < S - P; i++) {
      int j = i + P;

      char pre = dnaArr[i];
      char next = dnaArr[j];
      remove(pre);
      add(next);

      if (checkCount == 4) {
        resultCount++;
      }
    }

    System.out.println(resultCount);
  }

  public static void add(char c) {
    switch (c) {
      case 'A':
        curArr[0]++;
        if (curArr[0] == checkArr[0]) {
          checkCount++;
        }
        break;
      case 'C':
        curArr[1]++;
        if (curArr[1] == checkArr[1]) {
          checkCount++;
        }
        break;
      case 'G':
        curArr[2]++;
        if (curArr[2] == checkArr[2]) {
          checkCount++;
        }
        break;
      case 'T':
        curArr[3]++;
        if (curArr[3] == checkArr[3]) {
          checkCount++;
        }
        break;
    }
  }

  public static void remove(char c) {
    switch (c) {
      case 'A':
        if (curArr[0] == checkArr[0]) {
          checkCount--;
        }
        curArr[0]--;
        break;
      case 'C':
        if (curArr[1] == checkArr[1]) {
          checkCount--;
        }
        curArr[1]--;
        break;
      case 'G':
        if (curArr[2] == checkArr[2]) {
          checkCount--;
        }
        curArr[2]--;
        break;
      case 'T':
        if (curArr[3] == checkArr[3]) {
          checkCount--;
        }
        curArr[3]--;
        break;
    }
  }
}
