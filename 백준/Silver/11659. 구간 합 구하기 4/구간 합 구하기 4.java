import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);
        
        // 수 N개
        inputArr = br.readLine().split(" ");
        int[] s = new int[n];
        s[0] = Integer.parseInt(inputArr[0]);
        for(int i = 1; i < n; i++) {
            s[i] = s[i - 1] + Integer.parseInt(inputArr[i]);
        }
        
        // 구간별 출력
        for(int i = 0; i < m; i++) {
            inputArr = br.readLine().split(" ");
            int l = Integer.parseInt(inputArr[1]) - 1;
            int f = Integer.parseInt(inputArr[0]) - 2;
            
            int result = (f < 0) ? s[l] : s[l] - s[f];
            
            System.out.println(result);
        }
    }
}