import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] alphabet = new int[26];
        for (int i = 0; i < 26; i++) alphabet[i] = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (alphabet[ch - 'a'] == -1) alphabet[ch - 'a'] = i;
        }

        for (int i = 0; i < 26; i++) {
            bw.write(alphabet[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
