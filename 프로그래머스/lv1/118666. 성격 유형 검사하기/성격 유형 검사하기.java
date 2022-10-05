import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] type = {"R", "T", "C", "F", "J", "M", "A", "N"};
        HashMap<String, Integer> hm = new HashMap<>();

        for (String s : type) {
            hm.put(s, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            String type1 = survey[i].substring(0, 1);
            String type2 = survey[i].substring(1, 2);

            switch (choices[i]) {
                case 1:
                    hm.put(type1, hm.get(type1).intValue() + 3);
                    break;
                case 2:
                    hm.put(type1, hm.get(type1).intValue() + 2);
                    break;
                case 3:
                    hm.put(type1, hm.get(type1).intValue() + 1);
                    break;
                case 5:
                    hm.put(type2, hm.get(type2).intValue() + 1);
                    break;
                case 6:
                    hm.put(type2, hm.get(type2).intValue() + 2);
                    break;
                case 7:
                    hm.put(type2, hm.get(type2).intValue() + 3);
                    break;
                default:
            }
        }


        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < type.length; i += 2) {
            int type1 = hm.get(type[i]);
            int type2 = hm.get(type[i + 1]);

            if (type1 < type2) {
                result.append(type[i + 1]);
            } else {
                result.append(type[i]);
            }
        }

        return result.toString();
    }
}