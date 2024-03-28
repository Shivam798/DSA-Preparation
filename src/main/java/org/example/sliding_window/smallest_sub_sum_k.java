package org.example.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class smallest_sub_sum_k {

    public static void main(String[] args) {
        int[] arr= {3, 4, 1, 1, 6};
        int k=8;
        System.out.println(helper(arr,k));
    }
    public static int helper (int[] arr,int k){
        int start =0;
        int sum=0;
        int minlen=Integer.MAX_VALUE;
        for(int end = 0 ;end<arr.length;end++){
            sum+=arr[end];
            while(sum>=k){
                minlen=Math.min(end-start+1,minlen);
                sum-=arr[start];
                start+=1;
            }
        }
        return (minlen==Integer.MAX_VALUE)?0:minlen;
    }

}
