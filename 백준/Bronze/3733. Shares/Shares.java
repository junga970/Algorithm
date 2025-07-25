import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;

        while ((line = br.readLine()) != null) {
            String[] input = line.split(" ");
            int n = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            bw.write(s / (n + 1) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
