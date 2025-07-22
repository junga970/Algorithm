import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.startsWith("push")) {
                int x = Integer.parseInt(input.split(" ")[1]);
                stack.push(x);
            } else if (input.equals("pop")) {
                bw.write(stack.isEmpty() ? "-1\n" : stack.pop() + "\n");
            } else if (input.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (input.equals("empty")) {
                bw.write(stack.isEmpty() ? "1\n" : "0\n");
            } else if (input.equals("top")) {
                bw.write(stack.isEmpty() ? "-1\n" : stack.peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
