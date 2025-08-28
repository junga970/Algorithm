import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String comp = br.readLine();  // 기준 문자열

        StringBuilder sb = new StringBuilder(comp);

        for (int i = 1; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) != line.charAt(j)) {
                    sb.setCharAt(j, '?');
                }
            }
        }

        System.out.println(sb.toString());
    }
}
