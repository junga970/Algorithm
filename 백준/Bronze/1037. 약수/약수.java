import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] divisors = new int[n];
        for (int i = 0; i < n; i++) {
            divisors[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = divisors[0];
        int max = divisors[0];
        for (int i = 1; i < n; i++) {
            if (divisors[i] < min) min = divisors[i];
            if (divisors[i] > max) max = divisors[i];
        }

        System.out.println(min * max);
    }
}
