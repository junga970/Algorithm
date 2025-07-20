import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int prize;

        if (a == b && b == c) prize = 10000 + a * 1000;
        else if (a == b || a == c) prize = 1000 + a * 100;
        else if (b == c) prize = 1000 + b * 100;
        else prize = Math.max(a, Math.max(b, c)) * 100;

        bw.write(prize + "\n");
        bw.flush();
        bw.close();
    }
}
