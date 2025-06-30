import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int year = Integer.parseInt(br.readLine());
        int buddhistYear = year - 543;

        bw.write(String.valueOf(buddhistYear));
        bw.flush();
        bw.close();
    }
}
