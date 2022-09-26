class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] newArr1 = new String[n];
        String[] newArr2 = new String[n];
        String f = String.format("%%0%dd", n);

        for (int i = 0; i < n; i++) {
            newArr1[i] = String.format(f, Long.parseLong(Long.toBinaryString(arr1[i])));
            newArr2[i] = String.format(f, Long.parseLong(Long.toBinaryString(arr2[i])));
        }

        for (int i = 0; i < n; i++) {
            String str = "";
            
            for (int j = 0; j < n; j++) {
                if(newArr1[i].charAt(j) == '0' && newArr2[i].charAt(j) == '0') {
                    str += " ";
                }
                else {
                    str += "#";
                }
            }
            
            newArr1[i] = str;
        }
        
        return newArr1;
    }
}