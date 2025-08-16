import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0, current = 0;
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            current += Integer.parseInt(input[1]) - Integer.parseInt(input[0]);
            max = Math.max(max, current);
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
