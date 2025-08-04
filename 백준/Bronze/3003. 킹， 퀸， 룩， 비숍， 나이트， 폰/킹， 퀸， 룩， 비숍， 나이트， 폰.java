import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);
        int k = Integer.parseInt(input[3]);
        int q = Integer.parseInt(input[4]);
        int p = Integer.parseInt(input[5]);

        bw.write((1 - w) + " " + (1 - b) + " " + (2 - r) + " " + (2 - k) + " " + (2 - q) + " " + (8 - p) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
