class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;

        for(int[] size : sizes) {
            int longNum = size[0] > size[1] ? size[0] : size[1];
            int shortNum = size[0] > size[1] ? size[1] : size[0];

            if (w < longNum) {
                w = longNum;
            } 
            
            if (h < shortNum) {
                h = shortNum;
            }
        }
        
        return w * h;
    }
}