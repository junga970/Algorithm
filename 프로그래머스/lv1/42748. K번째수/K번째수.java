import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            answer[i] = result(array, commands[i]);
        }
        return answer;
    }

    int result(int[] array, int[] command) {
        int[] arr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
        Arrays.sort(arr);

        return arr[command[2] - 1];
    }
}