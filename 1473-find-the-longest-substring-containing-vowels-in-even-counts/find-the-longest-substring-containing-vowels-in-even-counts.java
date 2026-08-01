import java.util.*;

class Solution {
    public int findTheLongestSubstring(String s) {
       HashMap< Integer, Integer > map = new HashMap<>();
       map.put(0,-1);
       int xor  =0;
       int n = s.length();
       int ans = 0;
       for( int i=0; i<n ;i++ ){
        char ch = s.charAt(i);
         if (ch == 'a') xor ^= 1;
        else if (ch == 'e') xor ^= 2;
        else if (ch == 'i') xor ^= 4;
        else if (ch == 'o') xor ^= 8;
        else if (ch == 'u') xor ^= 16;
        if( map.containsKey(xor)){
            ans = Math.max(ans,i-map.get(xor));
        }else{
            map.put(xor,i);
        }
       } 
       return ans;
    }
}