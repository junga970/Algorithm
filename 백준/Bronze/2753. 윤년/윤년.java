import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int year = Integer.parseInt(br.readLine().trim());
        
        boolean isLeap = false;

        if (year % 4 == 0 && year % 100 != 0) {
            isLeap = true;
        } else if (year % 400 == 0) {
            isLeap = true;
        }
        
        bw.write(isLeap ? "1" : "0");
        
        bw.flush();
        bw.close();
    }
}
