package org.example.sliding_window;

import java.lang.reflect.Array;
import java.util.Arrays;

public class permutation_string {
    public static void main(String[] args) {
        String s1="oidbcaf";
        String s2="abc";
        System.out.println(helper(s1,s2));
    }
    public static boolean helper(String s1, String s2 ){
        if (s2.length() > s1.length())
            return false;

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Build the frequency map for s1
        for (char c : s1.toCharArray())
            s1Map[c - 'a']++;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s2.length(); windowEnd++) {
            // Expand the window by adding the character at s2[windowEnd]
            char endChar = s2.charAt(windowEnd);
            s2Map[endChar - 'a']++;

            // Shrink the window if it exceeds the size of s1
            while (windowEnd - windowStart + 1 > s1.length()) {
                char startChar = s2.charAt(windowStart);
                s2Map[startChar - 'a']--;
                windowStart++;
            }

            // Check if the current window matches the frequency map of s1
            if (Arrays.equals(s1Map, s2Map))
                return true;
        }

        return false;
    }
}
