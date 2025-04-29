import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 초기화
        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {   
                if (arr[j] == '1') board[i][j] = 1;
            }
        }


        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {   
                if (board[i][j] == 1 && !visited[i][j]) {
                    result.add(dfs(i, j));
                }
            }
        }

        // 오름차순 정렬
        result.sort((a, b) -> a - b);

        // 1. 크기 출력
        System.out.println(result.size()); 
        // 2. 단지수 출력
        result.stream().forEach(System.out::println);
    }

    static int dfs(int x, int y) {
        int area = 1;
        visited[x][y] = true; // 방문 처리

        for (int i = 0; i < dx.length; i++) { // 상하좌우
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(isValid(cx, cy) && board[cx][cy] == 1 && !visited[cx][cy]) { // 방문 안 한 곳
                area += dfs(cx, cy);
                visited[x][y] = true; // 방문 처리
            }
        } 

        return area;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
