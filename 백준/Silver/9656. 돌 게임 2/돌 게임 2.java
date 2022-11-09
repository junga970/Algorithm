import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);

        if (N % 2 == 0) {
            System.out.println("SK");
            return;
        }
        System.out.println("CY");
    }   
}