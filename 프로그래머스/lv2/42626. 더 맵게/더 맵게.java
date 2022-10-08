import java.util.PriorityQueue;


class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : scoville) {
            pq.offer(n);
        }

        int cnt = 0;
        while (pq.size() > 1) {
            int scoville1 = pq.poll();
            if (scoville1 >= K) {
                return cnt;
            }
            int scoville2 = pq.poll();
            int scoville3 = scoville1 + (scoville2 * 2);
            pq.offer(scoville3);
            
            cnt++;
        }
        
        if(pq.poll() >= K) {
            return 1;
        }
        
        return -1;
    }
}