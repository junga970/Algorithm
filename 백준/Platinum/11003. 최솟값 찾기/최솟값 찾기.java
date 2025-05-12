import java.util.*;
import java.io.*;

public class Main {
  static int N, L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    // deque
    Deque<Node> deque = new LinkedList<>();

    // A(1) ~ A(N)
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      int value = Integer.parseInt(st.nextToken()); // A(i)의 Value

      // 현재 추가하려는 값보다 큰 값은 제거
      while (!deque.isEmpty() && deque.peekLast().value >= value) {
        deque.removeLast();
      }

      deque.addLast(new Node(i, value));

      // 범위를 벗어난 값 제거
      if (deque.peekFirst().index <= i - L) {
        deque.removeFirst();
      }

      bw.write(deque.getFirst().value +  " ");
    }
    bw.flush();
    bw.close();
  }
}

class Node {
  int index;
  int value;

  Node(int index, int value) {
    this.index = index;
    this.value = value;
  }
}