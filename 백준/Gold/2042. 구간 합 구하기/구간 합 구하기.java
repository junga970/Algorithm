import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 데이터 개수
        int M = Integer.parseInt(st.nextToken());   // 데이터 변경 횟수
        int K = Integer.parseInt(st.nextToken());   // 구간 합을 구하는 횟수

        // 세그먼트 트리 배열
        int treeHeight = 0;
        int tmp = 1;
        while (true) {    // 트리 높이 구하기
            tmp *= 2;
            treeHeight++;

            if (tmp >= N) {
                break;
            }
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize];
        int leafNodeStartIndex = (int) Math.pow(2, treeHeight);
        for (int i = leafNodeStartIndex; i < leafNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        // 리프노드를 통해 부모노드 채우기
        int index = treeSize - 1;
        while (index != 1) {
            tree[index / 2] += tree[index];
            index--;
        }

        // 결과 출력
        // 세 개의 정수 a, b, c가 주어질 때
        // a가 1인 경우 b번째 수를 c로 바꾸고, 2인 경우 b번째 수부터 c번째 수까지의 합을 구한다.
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(leafNodeStartIndex + b - 1, c);
            } else {
                sum(leafNodeStartIndex + b - 1, leafNodeStartIndex + (int)c - 1);
            }
        }
    }

    private static void update(int index, long value) {
        long diff = value - tree[index];
        while (index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }

    private static void sum(int startIndex, int endIndex) {
        long result = 0;
        while (startIndex <= endIndex) {
            if (startIndex % 2 == 1) {
                result += tree[startIndex];
                startIndex++;
            }

            if (endIndex % 2 == 0) {
                result += tree[endIndex];
                endIndex--;
            }

            startIndex /= 2;
            endIndex /= 2;
        }
        System.out.println(result);
    }
}