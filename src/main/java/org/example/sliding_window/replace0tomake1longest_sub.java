package org.example.sliding_window;

public class replace0tomake1longest_sub {
    public static void main(String[] args) {
        int[] arr ={0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        int k = 3;
        System.out.println(helper(arr,k));
    }
    public static int helper(int [] arr, int k){
        int res=0;
        int start=0;
        int maxoneCount=0;
        for(int end=0;end<arr.length;end++){
            if(arr[end]==1){
                maxoneCount+=1;
            }
            if(end-start+1-maxoneCount>k){
                if(arr[start]==1){
                    maxoneCount-=1;
                }
                start+=1;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }
}
