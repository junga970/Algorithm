import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[0]); // 반복 횟수
            String S = input[1]; // 문자열

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < S.length(); j++) {
                char ch = S.charAt(j);
                // 문자를 R번 반복
                for (int k = 0; k < R; k++) {
                    sb.append(ch);
                }
            }

            System.out.println(sb.toString());
        }
    }
}
