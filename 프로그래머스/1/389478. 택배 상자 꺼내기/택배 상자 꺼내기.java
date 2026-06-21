class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int evenBox = n / w;
        int leftBox = n % w;
        int boxIndex = num % w == 0 ? w : num % w;
        int row = 0;
        while (num > row * w) {
            row++;
        }
        System.out.println(evenBox + " " + leftBox + " " + row + " " + num);
        if ((evenBox % 2 != 0 && row % 2 == 0)  // 쌓는 상자, 해당 상자 같은 방향
        || (evenBox % 2 == 0 && row % 2 != 0)) { 
            if (leftBox >= boxIndex) {
                answer = evenBox - row + 2;
            } else {
                answer = evenBox - row + 1;
            }
        } else {
            if (leftBox + boxIndex <= w) {       // 쌓는 상자, 해당 상자 다른 방향
                answer = evenBox - row + 1;
            } else {
                answer = evenBox - row + 2;
            }
        }
        return answer;
    }
}