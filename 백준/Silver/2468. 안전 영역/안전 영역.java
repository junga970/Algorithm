import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /* 1. input data 정리 */
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        Set<Integer> set = new HashSet<>(); // 시뮬레이션 돌려볼 물 높이
        set.add(0); // 비가 안올 때
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(arr[j]);
                board[i][j] = num;
                set.add(num);
            }
        }

        // 영역 개수 리스트
        ArrayList<Integer> result = new ArrayList<>();

        /* 물 높이별로 안전 영역 구하기 */
        for(Integer rain : set) {
            int area = 0; // 영역 개수 초기화
            visited = new boolean[N][N]; // visited 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] > rain && !visited[i][j]) {
                        area++;
                        bfs(i, j, rain); // 인접 영역 방문 처리
                    }
                }
            }
            result.add(area);
        }

        // 결과 출력
        int max = Collections.max(result);
        System.out.println(max);
    }    
    
    static void bfs(int x, int y, int rain) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true; // 방문 처리

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int cx = cur[0] + dx[i];
                int cy = cur[1] + dy[i];
                if(isValid(cx, cy) && !visited[cx][cy] && board[cx][cy] > rain) {
                    visited[cx][cy] = true; // 방문 처리
                    queue.add(new int[]{cx, cy});
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
