package org.example.sliding_window;
import java.util.*;

public class No_repeat_char {
    public static void main(String[] args) {
        String s= "abccde";
        int k = 2;
        System.out.println(helper(s,k));
    }

    private static int helper(String s, int k) {
        int res = 0;
        int start=0;
        Map<Character,Integer> map = new HashMap<>();
        for (int end=0;end<s.length();end++){
            Character c = s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(start,map.get(c)+1);
            }
            map.put(c,end);
            res=Math.max(res,end-start+1);
        }
        return res;
    }

}
