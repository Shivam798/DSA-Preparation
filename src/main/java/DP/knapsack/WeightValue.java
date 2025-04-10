package DP.knapsack;

import java.util.Arrays;

public class WeightValue {
    public static void main(String[] args) {
        int[] weights = {1, 3, 4, 5};
        int[] values = {10, 40, 50, 70};
        int W = 8;
        int n = weights.length;

//        System.out.println("Brute Force Result: " + knapsackBrute(weights, values, n, W));
//        System.out.println("Memoization Result: " + knapsackMemo(weights, values, n, W));
        System.out.println("Bottom-Up DP Result: " + knapsackDP(weights, values, n, W));
    }

    private static int knapsackDP(int[] weights, int[] values, int n, int w) {
        int[][] dp = new int[n+1][w+1];
        for(int i=1 ;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(weights[i-1]<=j){
                    //include
                    dp[i][j] = Math.max(values[i-1]+dp[i-1][j-weights[i-1]],dp[i-1][j]);
                }else{
                    //exclude
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }

    private static int knapsackMemo(int[] weights, int[] values, int n, int w) {
        int[][] dp = new int[n][w+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solveMemo(weights,values,n-1,w,dp);
    }

    private static int solveMemo(int[] weights, int[] values, int n, int w, int[][] dp) {
        if(n<0 || w==0) return 0;
        if(dp[n][w]!=-1) return dp[n][w];
        if(weights[n]>w){
            return dp[n][w]=solveMemo(weights,values,n-1,w,dp);
        }
        int incluse = values[n]+ solveMemo(weights,values,n-1,w-weights[n],dp);
        int exclude = solveMemo(weights,values,n-1,w,dp);
        return dp[n][w] = Math.max(incluse,exclude);
    }

    public  static int knapsackBrute(int[] weight, int[] values ,int n , int W){
        return solveBrute(weight,values,n-1,W);
    }

    private static int solveBrute(int[] weight, int[] values, int n, int w) {
        if(n<0 || w==0){
            return 0;
        }
        if(weight[n]>w){
            return solveBrute(weight,values,n-1,w);
        }
        int include = values[n]+solveBrute(weight,values,n-1,w-weight[n]);
        int exclude = solveBrute(weight,values,n-1,w);
        return Math.max(include,exclude);
    }




}
