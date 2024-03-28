package org.example.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class fruits_into_busket {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        int k = 2;
        System.out.println(helper(arr, k));
    }

    public static int helper(int[] arr, int k) {
        int max = 0;
        int start = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int end = 0; end < arr.length; end++) {
            int num = arr[end];
            map.put(num, map.getOrDefault(num, 0) + 1);

            while (map.size() > 2) {
                map.put(arr[start], map.get(arr[start]) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start += 1;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
