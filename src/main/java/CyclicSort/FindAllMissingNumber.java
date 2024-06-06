package CyclicSort;

import java.util.*;

public class FindAllMissingNumber {
    public static void main(String[] args) {
        int[] num = {2, 3, 1, 8, 2, 3, 5, 1};
        int[] num2 = {2, 4, 1, 2};

        List<Integer> res = helper(num);
        System.out.println(res);
    }
    private static List<Integer> helper (int[] num){
        List<Integer> res = new ArrayList<>();
        int i=0;
        int n = num.length;
        while(i<n){
            int correctIndex = num[i]-1;
            if(num[i]<=num.length && num[correctIndex]!=num[i]){
                int temp = num[i];
                num[i]=num[correctIndex];
                num[correctIndex]=temp;
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(num));
        for(int j = 0;j<n;j++){
            if(num[j]!=j+1){
                res.add(j+1);
            }
        }
        return res;
    }
}
