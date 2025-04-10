package DP.knapsack;

import java.util.Arrays;

public class canPartition {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 11, 5};       // true (can be partitioned as [1, 5, 5] and [11])
        int[] arr2 = {1, 2, 3, 5};
        int[] arr3 = {11, 48, 24};

        System.out.println(helperMemo(arr1));
    }

    private static boolean helperMemo(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
        if(sum%2!=0){
            return false;
        }else{
//            return subSetSum(arr,sum/2);
            return helperBottomUp(arr,sum/2);
        }
    }

    private static boolean subSetSum(int[] arr, int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n+1][sum+1];
        return subSetSumHelper(arr,sum,n,dp);
    }

    private static boolean subSetSumHelper(int[] arr, int sum, int n, Boolean[][] dp) {
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        if(arr[n-1]>sum){
            dp[n][sum]=subSetSumHelper(arr,sum,n-1,dp);
        }else{
            boolean include= subSetSumHelper(arr,sum-arr[n-1],n-1,dp);
            boolean exclude = subSetSumHelper(arr,sum,n-1,dp);
            dp[n][sum] = include || exclude;
        }
        return dp[n][sum];
    }

    private static boolean helperBottomUp(int[] arr, int sum){
        int n = arr.length;
        boolean[][] dp=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j){
                    //exclude
                    dp[i][j]= dp[i-1][j];
                }else{
//                    include+exclude
                    boolean include = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                    boolean exclude = dp[i-1][j];
                    dp[i][j]= include || exclude;
                }
            }
        }
        return dp[arr.length][sum];
    }

}
