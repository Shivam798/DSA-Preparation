package org.example.sliding_window;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class same_character {
    public static void main(String[] args) {
        String arr ="abccde";
        int k =1;
        System.out.println(helper(arr,k));
    }
    public static int helper(String arr,int k){
        int res= 0;
        Map<Character,Integer> map = new HashMap<>();
        int start=0;
        int maxrepeatCount=0;
        for(int end=0;end<arr.length();end++){
            Character endChar = arr.charAt(end);
            map.put(endChar,map.getOrDefault(endChar,0)+1);
            maxrepeatCount=Math.max(maxrepeatCount,map.get(endChar));
            if((end-start+1-maxrepeatCount)>k){
                Character startChar = arr.charAt(start);
                map.put(startChar,map.get(startChar)-1);
                start+=1;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }
}
