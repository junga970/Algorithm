import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String expression = br.readLine();

        // 더하기 연산을 모두 진행한 후 빼기 연산을 해준다.
        // "-" 부호를 기준으로 split
        String[] str = expression.split("-");

        // 정답 구하기
        int result = mySum(str[0]); // 첫번 째 값만 할당
        for (int i = 1; i < str.length; i++) {
            result -= mySum(str[i]); // 더하기 연산 진행 후 결과 값을 빼준다.
        }

        System.out.println(result);
    }
    static int mySum(String string) {
        String[] str = string.split("\\+");
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }
        return sum;
    }
}