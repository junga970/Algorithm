import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int white = 0;
    static int blue = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                 int num = Integer.parseInt(st.nextToken());
                 board[i][j] = num;
            }
        }
        //===============================
        //입력값 저장

        partition(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void partition(int row, int col, int size) {
        if(colorCheck(row, col, size)){	
            if(board[row][col] == 0){	
                white++;
            }else{
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        partition(row, col, newSize);                   //좌측상단
        partition(row, col+newSize, newSize);           //좌측하단
        partition(row+newSize, col, newSize);           //우측상단
        partition(row+newSize, col+newSize, newSize); 	//우측하단
    }

    private static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

}