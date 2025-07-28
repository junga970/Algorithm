import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int middle = a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));

        bw.write(middle + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
