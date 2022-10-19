import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long start = times[0];
        long end = (long)times[times.length - 1] * (long)n;
        long mid = 0;
        long answer = Long.MAX_VALUE;

        while (start <= end) {
            mid = (start + end) / 2;

            long sum = 0;
            for(int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return answer;
    }
}
