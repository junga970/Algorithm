import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line;
        while (!(line = br.readLine()).equals("0")) {
            long result = solution(line);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    static long solution(String line) {
        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        long[] heights = new long[N + 1];
        
        for(int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        heights[N] = 0;

        Stack<Integer> stack = new Stack<>();
        
        long maxArea = 0;
        for (int cur = 0; cur <= N; cur++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[cur]) {
                int top = stack.pop();
                long height = heights[top];
                int width = stack.isEmpty() ? cur : cur - stack.peek() - 1;
                long area = height * (long)width;
                maxArea = Math.max(maxArea, area);
            }
            
            stack.push(cur);
        }

        return maxArea;
    }
}