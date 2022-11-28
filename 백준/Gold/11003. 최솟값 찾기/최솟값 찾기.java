import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Node node = new Node(i, Integer.parseInt(st.nextToken()));

            // 뒤에서부터 현재 node값 보다 큰 node들 삭제 (정렬)
            while (!deque.isEmpty() && deque.getLast().value >= node.value) {
                deque.removeLast();
            }

            // 현재 node 추가
            deque.addLast(node);

            // 범위를 넘지 않도록 앞에서부터 삭제
            while (!deque.isEmpty() && node.idx - deque.getFirst().idx >= L ) {
                deque.removeFirst();
            }

            // deque의 맨 앞에있는 값이 결국 최솟값 
            bw.write(deque.getFirst().value +  " ");
        }
        bw.flush();
        bw.close();
    }
}
