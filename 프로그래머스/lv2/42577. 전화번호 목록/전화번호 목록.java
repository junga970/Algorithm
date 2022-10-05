import java.util.Arrays;


class Solution {
     public boolean solution(String[] phone_book) {
         // [119, 1195524421, 97674223]
         Arrays.sort(phone_book);
         
         // startsWith(): 대상문자열이 비교문자열로 시작하면 true 반환, 아니면 false
         for (int i = 0; i < phone_book.length - 1; i++) {
             if(phone_book[i + 1].startsWith(phone_book[i])) {
                 return false;
             }
             
         }
         return true;
     }
    
    
    
//      <효율성에서 실패한 코드>
//      public boolean solution(String[] phone_book) {
//         Arrays.sort(phone_book, (s1, s2) -> s1.length() - s2.length());

//         for (int i = 0; i < phone_book.length - 1; i++) {
//             for (int j = i + 1; j < phone_book.length; j++) {
//                 if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
}