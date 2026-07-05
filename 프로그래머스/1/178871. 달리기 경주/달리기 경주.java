import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        String[] answer = new String[n];
        // 순위
        Map<String, Integer> rank = new HashMap<>();

        // 기본 순위 할당
        for(int i = 0; i < n; i++) rank.put(players[i], i);

        // 순위 변경 호명
        for(String call : callings) {
            // prev = 이전 순위, cur = 바뀔 순위
            int prev = rank.get(call), cur = prev - 1;
            // curPlayer = 바뀔 순위에 위치해있던 선수
            String curPlayer = players[cur];

            // swap 처리
            players[prev] = curPlayer;
            players[cur] = call;
            rank.put(curPlayer, prev);
            rank.put(call, cur);
        }
        // 결과 할당
        for(var entry : rank.entrySet()) {
            answer[entry.getValue()] = entry.getKey();
        };
        return answer;
    }
}
