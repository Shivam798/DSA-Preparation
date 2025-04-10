package DP.knapsack;

import java.util.Arrays;

class isSubsetSumClass {

    static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Initialize base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // 0 sum is always possible
        }

        // Fill the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; // exclude current
                } else {
                    // include or exclude
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {11, 48, 24};
        int sum = 83;
        System.out.println(isSubsetSum(arr, sum)); // true
    }

    static boolean isSubsetSumMemo(int[] arr, int sum) {
        int n = arr.length;
        int[][] memo = new int[n + 1][sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return isSubsetSumRec(arr, n, sum, memo);
    }

    static boolean isSubsetSumRec(int[] arr, int n, int sum, int[][] memo) {

        // If the sum is zero, we found a subset
        if (sum == 0) {
            return true;
        }

        // If no elements are left
        if (n <= 0) {
            return false;
        }

        // If the value is already computed, return it
        if (memo[n][sum] != -1) {
            return memo[n][sum] == 1;
        }

        // If the last element is greater than the sum,
        // ignore it
        if (arr[n - 1] > sum) {
            memo[n][sum] = isSubsetSumRec(arr, n - 1, sum, memo)
                    ? 1 : 0;
        }
        else {

            // Include or exclude the last element directly
            memo[n][sum] = (isSubsetSumRec(arr, n - 1, sum, memo)
                    || isSubsetSumRec(arr, n - 1, sum - arr[n - 1], memo))
                    ? 1 : 0;
        }

        return memo[n][sum] == 1;
    }

}
