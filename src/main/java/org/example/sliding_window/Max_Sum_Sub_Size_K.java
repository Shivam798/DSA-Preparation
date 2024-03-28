package org.example.sliding_window;

import java.util.List;

public class Max_Sum_Sub_Size_K {
    public static void main(String[] args) {
        int[] arr= {2, 3, 4, 1, 5};
        int k=2;
        System.out.println(helper(arr,k));
    }
    public static int helper(int[] arr, int k){
        int maxSum = 0;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);

                windowSum -= arr[windowStart];

                windowStart++;
            }
        }
        return maxSum;
    }
}
