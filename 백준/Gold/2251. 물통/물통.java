import java.io.*;
import java.util.*;

public class Main {
    // A : 0, B : 1, C : 2
    static int[] sizes = new int[3]; // 물통 사이즈
    static int[] sender = { 0, 0, 1, 1, 2, 2 };
    static int[] receiver = { 1, 2, 0, 2, 0, 1 };

    static boolean[][] visited = new boolean[201][201];
    static boolean[] anwser = new boolean[201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sizes[0] = Integer.parseInt(st.nextToken()); // A
        sizes[1] = Integer.parseInt(st.nextToken()); // B
        sizes[2] = Integer.parseInt(st.nextToken()); // C

        bfs();

        for (int i = 0; i < anwser.length; i++) {
            if (anwser[i])
                System.out.print(i + " ");
        }
    }

    static void bfs() {
        // 0, 0, C 로 시작
        Queue<AB> queue = new LinkedList<>();
        queue.offer(new AB(0, 0));
        visited[0][0] = true;
        anwser[sizes[2]] = true;

        while (!queue.isEmpty()) {
            AB cur = queue.poll();
            int A = cur.A;
            int B = cur.B;
            int C = sizes[2] - A - B;

            for (int i = 0; i < sender.length; i++) { // A -> B, A -> C 등 총 6가지 경우 체크
                int[] curABC = { A, B, C };
                curABC[receiver[i]] += curABC[sender[i]];
                curABC[sender[i]] = 0;
                if (curABC[receiver[i]] > sizes[receiver[i]]) { // 물통이 넘치는 경우 넘친 만큼 sender 물통으로 보내기
                    curABC[sender[i]] = curABC[receiver[i]] - sizes[receiver[i]];
                    curABC[receiver[i]] = sizes[receiver[i]];
                }

                if (!visited[curABC[0]][curABC[1]]) {
                    visited[curABC[0]][curABC[1]] = true;
                    queue.offer(new AB(curABC[0], curABC[1]));
                }

                if (curABC[0] == 0) {
                    anwser[curABC[2]] = true;
                }
            }
        }
    }
}

class AB {
    int A;
    int B;

    public AB(int A, int B) {
        this.A = A;
        this.B = B;
    }
}