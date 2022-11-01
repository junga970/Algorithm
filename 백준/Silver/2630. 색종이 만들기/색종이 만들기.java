import java.io.*;
import java.util.*;

class Main {

    static int white = 0;
    static int blue = 0;
    static int[][] board;
    
    
    public static void main(String[] args) throws Exception {
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
        System.out.println(white);
        System.out.println(blue);
    }

    public static void partition(int row, int col, int size) {
        if(check(row, col, size)) {
            if(board[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        partition(row, col, newSize);                 // 좌측 상단
        partition(row + newSize, col, newSize);  // 우측 상단
        partition(row, col + newSize, newSize);                 // 좌측 하단
        partition(row + newSize, col + newSize, newSize);  // 우측 하단
    }

    public static boolean check(int row, int col, int size){
        int color = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}

