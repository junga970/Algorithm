import java.util.*;
import java.io.*;

class Main {
    
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 데이터 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M + 1];
        for (int i = N; i <= M; i++) {
            arr[i] = i;
        }

        // 소수가 아닌 경우 0으로 값 변환
        for (int i = 2; i <= Math.sqrt(M); i++) {
            for (int j = i * 2; j <= M; j += i) {
                arr[j] = 0;
            }
        }

        arr[1] = 0;
        for (int i = N; i <= M; i++) {
            if (arr[i] != 0) {
                bw.write(arr[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
