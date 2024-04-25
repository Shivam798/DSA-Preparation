package two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumLessThanTarget {
    public static void main(String[] args) {
        int[] arr={-1, 4, 2, 1, 3};
        int tar = 5;
        System.out.println(helper(arr,tar));

    }
    public static int helper(int[] arr, int tar){
        Arrays.sort(arr);
        int count=0;
        for(int i =0;i<arr.length-2;i++){
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum<tar){
                    count+=(k-j);
                    j+=1;
                }else{
                    k-=1;
                }
            }
        }
        return count;
    }
}
