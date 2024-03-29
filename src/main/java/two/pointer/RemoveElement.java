package two.pointer;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr={3, 2, 3, 6, 3, 10, 9, 3};
        int tar = 3;
        System.out.println(helper(arr,tar));
    }
    public static int helper(int [] arr, int tar){
        int l=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=tar){
                arr[l]=arr[i];
                l+=1;
            }
        }
        System.out.println(Arrays.toString(arr));
        return l;
    }
}
