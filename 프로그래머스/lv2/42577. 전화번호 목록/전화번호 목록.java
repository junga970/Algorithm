import java.util.Arrays;


class Solution {
     public boolean solution(String[] phone_book) {
         Arrays.sort(phone_book);

         for (int i = 0; i < phone_book.length - 1; i++) {
             if(phone_book[i + 1].startsWith(phone_book[i])) {
                 return false;
             }
             
         }
         return true;
     }
    
    
    
//      <효율성에서 실패한 코드2>    
//     public boolean solution(String[] phone_book) {
//         Arrays.sort(phone_book, (s1, s2) -> s1.length() - s2.length());
        
//         for (int i = 0; i < phone_book.length - 1; i++) {
//             for (int j = i + 1; j < phone_book.length; j++) {
//                 if(phone_book[j].startsWith(phone_book[i])) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
        
    
    
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