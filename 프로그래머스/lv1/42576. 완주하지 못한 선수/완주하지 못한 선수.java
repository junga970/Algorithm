import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();

        for (String s : participant) {
            if (hm.containsKey(s)) {
                hm.put(s, hm.get(s) + 1);
            } else { hm.put(s, 1); }
        }


        for (String c : completion) {
            hm.put(c, hm.get(c) - 1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) > 0) {
                return key;
            }
        }

        return "";
    }
}