package org.example.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class FindAvg {
    public static void main(String[] args) {
        int[] arr= {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k =5;
        System.out.println(helper2(arr,k));
    }
//    Normal way
//    O(N*K)
    public static List<Double> helper1 (int[] arr,int k){
        List<Double> res = new ArrayList<>();
        for(int i =0;i< arr.length-k+1;i++){
            int sum=0;
            for(int j=i;j<i+k;j++){
                sum+=arr[j];
            }
            res.add((double)sum/k);
        }
        return res;
    }
//    Sliding window
//    O(N)
    public static List<Double> helper2(int[] arr, int k){
        List<Double> res = new ArrayList<>();
        int start= 0;
        int sum=0;
        for(int end=0; end<arr.length;end++){
            sum+=arr[end];
            if(end>=k-1){
                res.add((double)sum/k);
                sum-=arr[start];
                start+=1;
            }
        }
        return res;
    }
}

