import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        String numString = br.readLine();
        
        int sum = 0;
        for(int i = 0; i < cnt; i++) {
            sum += Integer.parseInt(String.valueOf(numString.charAt(i)));
        }
        
        System.out.println(sum);
    }
}