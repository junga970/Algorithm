import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(input[i]);
            sum += num * num;
        }

        bw.write((sum % 10) + "\n");
        bw.flush();
        bw.close();
    }
}
