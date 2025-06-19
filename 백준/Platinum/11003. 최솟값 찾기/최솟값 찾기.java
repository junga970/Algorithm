import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            // deque에서 cur보다 큰 값 제거(뒤에서부터)
            while (!deque.isEmpty() && deque.getLast().value > cur) {
                deque.removeLast();
            }

            // deque에 cur 추가
            deque.addLast(new Node(i, cur));

            // deque에서 인덱스 벗어난 값 제거
            if (deque.getFirst().idx <= i - L) {
                deque.removeFirst();
            }

            // deque 중 최소값(맨 앞에 있는 값) 출력
            int min = deque.getFirst().value;

            bw.write(min + " ");
        }

        bw.flush();
        bw.close();
    }
}

class Node {
    int idx, value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}