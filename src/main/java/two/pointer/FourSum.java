package two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int [] arr ={2,0,-1,1,-2,2};
        int tar = 2;
        List<List<Integer>> result = helper(arr,tar);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
    public static List<List<Integer>> helper(int []arr,int tar){
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n-3;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }

            for(int j= i+1;j<n-2;j++){
                if(j>i+1 && arr[j]==arr[j-1]){
                    continue;
                }
                int k=j+1;
                int l=n-1;
                while (k<l){
                    int summ= arr[i]+arr[j]+arr[k]+arr[l];
                    if(summ==tar){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        res.add(temp);
                        k+=1;
                        l-=1;
                        while(k<l && arr[k]==arr[k+1]){
                            k+=1;
                        }
                        while(k<l && arr[l]==arr[l-1]){
                            l-=1;
                        }

                    }else if(summ<tar){
                        k+=1;
                    }else{
                        l-=1;
                    }
                }
            }

        }
        return res;
    }
}
