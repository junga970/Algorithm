import java.io.*;
import java.util.*;

public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 정수 배열 A
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 검색할 수의 개수 M
        int M = Integer.parseInt(br.readLine());

        // 검색할 수의 배열 B
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 후 이진탐색
        Arrays.sort(A);
        for (int i = 0; i < M; i++) {
            binarySearch(B[i]);
        }
    }

    private static void binarySearch(int n) {
        int start = 0;
        int end = A.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            int curN = A[mid];

            if (curN == n) {
                System.out.println(1); // 탐색 성공 1 출력
                return;
            } else if (curN < n) {
                start = mid + 1;
                mid = (start + end) / 2;
            } else {
                end = mid - 1;
                mid = (start + end) / 2;
            }
        }
        System.out.println(0); // 탐색 실패 0 출력
    }
}
