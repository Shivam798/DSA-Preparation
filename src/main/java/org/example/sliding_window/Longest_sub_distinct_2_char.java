package org.example.sliding_window;

import java.util.*;

public class Longest_sub_distinct_2_char {
    public static void main(String[] args) {
        String str = "ccaabbb";
        System.out.println(helper(str));
    }

    private static int helper(String str) {
        int max=0;
        int start=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int end=0;end<str.length();end++){
            Character c = str.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            while (map.size()>2){
                Character s = str.charAt(start);
                map.put(s,map.get(s)-1);
                if(map.get(s)==0){
                    map.remove(s);
                }
                start+=1;
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}
