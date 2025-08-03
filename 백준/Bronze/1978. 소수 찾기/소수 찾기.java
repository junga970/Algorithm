import java.io.*;

public class Main {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            if (isPrime(num)) count++;
        }

        System.out.println(count);
    }
}
