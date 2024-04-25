package two.pointer;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class DutchFalg {
    public static void main(String[] args) {
        int[] arr= {1, 0, 2, 1, 0};
        helper(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void helper(int [] arr){
        int low=0;
        int high=arr.length-1;
        int i=0;
        while(i<=high){
            if(arr[i]==0){
                int temp =arr[i];
                arr[i]=arr[low];
                arr[low]=temp;
                low+=1;
                i++;
            }else if(arr[i]==2){
                int temp = arr[high];
                arr[high]=arr[i];
                arr[i]=temp;
                high-=1;
            }else{
                i++;
            }

        }
    }

}
