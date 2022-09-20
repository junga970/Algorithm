class Solution {
    public String solution(String s, int n) {
        char[] charArr = s.toCharArray();

        String str = "";
        for (char c : charArr) {
            // 공백
            if(c == ' ') {
                str += c;
                continue;
            }

            int intC = (int)c;
            // 대문자
            if (intC <= 90) {
                int ascii = (intC + n - 65) % 26 + 65;
                str += String.valueOf((char)ascii);
            }
            // 소문자
            else if (intC <= 122) {
                int ascii = (intC + n - 97) % 26 + 97;
                str += String.valueOf((char)ascii);
            }
        }
        
        return str;
    }
}