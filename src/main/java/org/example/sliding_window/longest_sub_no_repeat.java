package org.example.sliding_window;


import java.util.*;

public class longest_sub_no_repeat {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(helper3(str));
    }

    private static int helper(String str){
        int max=0;
        int start=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int end=0;end<str.length();end++){
            Character c= str.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.size() == end-start+1){
                max=Math.max(max,end-start+1);
            } else if (map.size() < end-start+1)
                //We always shrink the window when the window size is not matching with the map size .
                //That's mean there are repeating characters in the window
                {
                while(map.size() < end-start+1){
                    Character s= str.charAt(start);
                    map.put(s,map.get(s)-1);
                    if(map.get(s)==0)map.remove(s);
                    start+=1;
                }
            }
        }
        return max;
    }

    private static int helper2(String str){
        int max=0;
        Map<Character,Integer> map = new HashMap<>();
        int start=0;
        for(int end=0;end<str.length();end++){
            Character c = str.charAt(end);
//            When key is repeated checking for index and
//            put start at the next character to the repeated number
            if(map.containsKey(c) && map.get(c)>=start){
                start=map.get(c)+1;
            }
            map.put(c,end);
            max=Math.max(max,end-start+1);
        }
        return max;
    }
    private static int helper3(String s){
        int start =0;
        int len=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int end =0;end<s.length();end++){
            Character endChar = s.charAt(end);
            if(map.containsKey(endChar)){
                start = Math.max(map.get(endChar)+1,start);
            }
            map.put(endChar,end);
            len = Math.max(len,end-start+1);
        }
        return  len;
    }
}
