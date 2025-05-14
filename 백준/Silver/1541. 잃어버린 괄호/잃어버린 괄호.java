import java.util.*;
import java.io.*;

/* 
 * '+' 연산을 먼저하고 '-' 연산 진행하기
 * 
 * 1. '-'로 분리
 * 2. 분리된 값을 모두 더해줌
 * 3. 모두 더한 상태에서 '-' 연산
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
    String str = br.readLine();

    // * 1. '-'로 분리
    String[] arr = str.split("\\-");

    ArrayList<Integer> intArr = new ArrayList<>();
    for (String str1 : arr) {
      // * 2. 분리된 값을 모두 더해줌
      int sum = 0;
      for (String str2 : str1.split("\\+")) {
        sum += Integer.parseInt(str2);
      }

      intArr.add(sum);
    }
    // * 3. 모두 더한 상태에서 '-' 연산
    int result = intArr.get(0);
    for (int i = 1; i < intArr.size(); i++) {
      result -= intArr.get(i);
    }

    System.out.println(result);
  }
}