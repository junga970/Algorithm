import java.util.*;

class Solution {
    static int[][] giftArr;
    
    public int solution(String[] friends, String[] gifts) {
        
    
        giftArr = new int[friends.length][friends.length];
        for(String gift : gifts) {
            String[] arr = gift.split(" ");
            giftArr[getIndex(friends, arr[0])][getIndex(friends, arr[1])]++;
        }
        
        // 다음달 받을 선물
        int[] result = new int[friends.length];
        
        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                // 준 선물
                int n1 = giftArr[i][j];
                // 받은 선물
                int n2 = giftArr[j][i];
                
                
                if(n1 > n2) {
                    result[i]++;
                    continue;
                } 
                
                
                if (n1 == n2) {
                    // 내 선물 지수
                    int gift1 = getGiftPoint(i);

                    // 상대 선물 지수
                    int gift2 = getGiftPoint(j);


                    if (gift1 > gift2) {
                        result[i] ++;
                    }
                }   
            }
        }
        
        int max = 0;
        for (int n : result) {
            max = Math.max(max, n);
        }
        
        
        int answer = 0;
        return max;
    }
    
    static int getGiftPoint(int idx) {
        int sum = 0;
        for(int i = 0; i < giftArr.length; i++) {
            sum += giftArr[idx][i];
        }
        
        for(int i = 0; i < giftArr.length; i++) {
            sum -= giftArr[i][idx];
        }
        
        return sum;
    }
    
    
    static int getIndex(String[] friends, String friend) {
        for(int i = 0; i < friends.length; i++) {
            if (friends[i].equals(friend)) return i;
        }
    
        return -1;
    }
}