package CyclicSort;

import java.util.Arrays;

public class SimpleSort {
    public static void main(String[] args) {
        int[] num =new  int[]{
                3, 1, 5, 4, 2
        };
        helper(num);
        System.out.println(Arrays.toString(num));
    }
    private static int[] helper(int[] num){
        int i =0;
        while(i<num.length){
            int correctIndex = num[i]-1;
            if(num[correctIndex]!=num[i]){
                int temp =num[i];
                num[i]=num[correctIndex];
                num[correctIndex]=temp;
            }else{
                i++;
            }
        }
        return num;
    }
}
