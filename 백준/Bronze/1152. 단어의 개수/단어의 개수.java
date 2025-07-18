import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine().trim();
        if (line.isEmpty()) bw.write("0\n");
        else bw.write(line.split("\\s+").length + "\n");

        bw.flush();
        bw.close();
    }
}
