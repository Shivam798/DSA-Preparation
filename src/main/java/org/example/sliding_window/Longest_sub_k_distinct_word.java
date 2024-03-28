package org.example.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Longest_sub_k_distinct_word {
    public static void main(String[] args) {
        String str = "araaci";
        int k = 2;
        System.out.println(helper(str, k));
    }

    public static int helper(String str, int k) {
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            Character character = str.charAt(end);
            map.put(character, map.getOrDefault(character, 0) + 1);

            while (map.size() > k) {
                Character startstr = str.charAt(start);
                map.put(startstr, map.get(startstr) - 1);
                if (map.get(startstr) == 0) {
                    map.remove(startstr);
                }
                start += 1;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}

