import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map = new HashMap<>();
        Set<String > set = new HashSet<String>(Arrays.asList(report));

        for(String s : set) {
            String[] arr = s.split(" ");
            if (map.containsKey(arr[1])){
                map.replace(arr[1], map.get(arr[1]) + 1);
                continue;
            }
            map.put(arr[1], 1);
        }

        int[] result = new int[id_list.length];
        for(String key : map.keySet()) {
            if (map.get(key) >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (set.contains(id_list[i] + " " + key)) {
                        result[i] += 1;
                    }
                }
            }
        }
        
        return result;
    }
}