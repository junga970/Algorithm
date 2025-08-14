import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int n = s.length();
        boolean isPalindrome = true;

        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        bw.write(isPalindrome ? "1\n" : "0\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
