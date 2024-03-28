package two.pointer;

import java.util.Arrays;

public class twoSum {
    public static void main(String[] args) {
        int [] arr = {0, 5, 2, 11};
        int sum=10;
        System.out.println(Arrays.toString(helper(arr,sum)));
    }
    public static int[] helper(int[] arr,int sum){
        int start =0;
        int end=arr.length-1;
        while(start<end){
            int total=arr[start]+arr[end];
            if(total==sum){
                return new int[]{start,end};
            } else if (total>sum) {
                end-=1;
            }else{
                start+=1;
            }
        }
        return new int[]{};
    }
}
