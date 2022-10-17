import java.util.Arrays;
import java.util.Scanner;


class Main {
    static int N;
    static int[] budgets;
    static int M;
    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 예산 array
        budgets = new int[N];
        // 얘산 합계
        for (int i = 0; i < budgets.length; i++) {
            budgets[i] = sc.nextInt();
            sum += budgets[i];
        }
        // 총 예산
        M = sc.nextInt();
        sc.close();

        Arrays.sort(budgets);
        System.out.println(BinarySearch());
    }

    static int BinarySearch() {
        if (sum <= M) {
            return budgets[N - 1];
        }

        int left = 0;
        int right = M;

        while (left <= right) {
            int cur = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < N; i++) {
                if (budgets[i] > mid) {
                    cur += mid;
                } else {
                    cur += budgets[i];
                }
            }

            if (cur > M) {
                right = mid - 1;
            } else if (cur < M) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}