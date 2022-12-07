import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int count = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        nQueen(0);
        System.out.println(count);
    }
    
    static void nQueen(int depth) {
        // 모든 원소를 다 채운 상태면 count 증가 및 return
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 재귀호출
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }
    
    static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할 경우
            if (arr[col] == arr[i]) {
                return false;
            } 
            // 대각선상에 놓여있는 경우
            else if (Math.abs(col -i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}