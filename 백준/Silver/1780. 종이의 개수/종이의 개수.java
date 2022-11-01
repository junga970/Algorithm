import java.io.*;
import java.util.*;

class Main {

    static int paper1 = 0;
    static int paper2 = 0;
    static int paper3 = 0;
    static int[][] board;


    public static void main(String[] args) throws Exception {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);
        System.out.println(paper1);
        System.out.println(paper2);
        System.out.println(paper3);
    }

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (board[row][col] == -1) {
                paper1++;
            } else if (board[row][col] == 0) {
                paper2++;
            } else {
                paper3++;
            }
            return;
        }

        int newSize = size / 3;
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + newSize * 2, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + newSize * 2, newSize);
        partition(row + newSize * 2, col, newSize);
        partition(row + newSize * 2, col + newSize, newSize);
        partition(row + newSize * 2, col + newSize * 2, newSize);
    }

    public static boolean check(int row, int col, int size) {
        int num = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j <col + size; j++) {
                if (num != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}