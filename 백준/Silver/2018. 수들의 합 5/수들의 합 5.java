import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 데이터 초기화 */
        int N = Integer.parseInt(br.readLine());
        int result = 1;  // N 추가(자기자신)

        /* 투 포인터 */
        int start = 1;
        int end = 1;
        int sum = 1;
        
        while(start < N / 2 + 1) {
            if (sum > N) {  // 합이 N보다 크면 앞쪽을 빼줌
                sum -= start++;
            
            } else if(sum < N) {  // 합이 N보다 작으면 뒷쪽을 더해줌
                sum += ++end;

            } else {  // 합과 N이 같은 경우
                result++;
                sum += ++end;

            } 
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}