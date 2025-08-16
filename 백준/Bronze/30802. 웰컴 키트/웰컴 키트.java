import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = new int[6];
        for (int i = 0; i < 6; i++) size[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int tshirtBundles = 0;
        
        for (int i = 0; i < 6; i++) {
            tshirtBundles += (size[i] + T - 1) / T;
        }
        int penBundles = N / P;
        int penSingles = N % P;
        
        System.out.println(tshirtBundles);
        System.out.println(penBundles + " " + penSingles);
    }
}
