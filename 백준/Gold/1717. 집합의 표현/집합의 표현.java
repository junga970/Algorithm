import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 원소 개수
        int n = Integer.parseInt(st.nextToken());
        // 연산 개수
        int m = Integer.parseInt(st.nextToken());

        // 원소 배열
        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        // 연산
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int system = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (system == 0) {
                arr[find(b)] = find(a);
            } else {
                String result = find(a) == find(b) ? "YES" : "NO";
                System.out.println(result);
            }
        }
    }

    // 부모 노드 찾기
    static int find(int a) {
        int n = arr[a];

        if(n == a) {
            return a;
        } else {
            arr[a] = find(n);
            return arr[a];
        }
    }
}