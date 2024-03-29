package two.pointer;

import java.util.Arrays;
import java.util.*;

public class three_sum {
    public static void main(String[] args) {
        int[] arr={-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> result = helper(arr);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
    public static List<List<Integer>> helper(int []arr){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int i=0;
        int n = arr.length;
        while (i<n-2){
            if(i!=0 && arr[i]==arr[i-1]){
                continue;
            }
            int j=i+1;
            int k=n-1;
            while (j<k){
                int summ = arr[j]+arr[k]+arr[i];
                if(summ==0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    res.add(temp);
                    while (j<k && arr[j]==arr[j+1]){
                        j+=1;
                    }
                    while (j<k && arr[k]==arr[k-1]){
                        k-=1;
                    }
                    j+=1;
                    k-=1;
                }else if (summ < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            i++;
        }
        return res;
    }

}
