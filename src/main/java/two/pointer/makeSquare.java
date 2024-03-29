package two.pointer;

import java.util.Arrays;

public class makeSquare {
    public static void main(String[] args) {
        int[] arr={-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(helper(arr)));
    }
    public static int[] helper(int[] arr){
        int n = arr.length;
        int [] res = new int[n];
        int left=0,right=n-1;
        int index=n-1;
        while(left<=right){
            int leftsqr=arr[left]*arr[left];
            int rightsqr = arr[right]*arr[right];
            if(leftsqr>rightsqr){
                res[index]=leftsqr;
                left+=1;
            }else{
                res[index]=rightsqr;
                right-=1;
            }
            index-=1;
        }
        return res;
    }
}

