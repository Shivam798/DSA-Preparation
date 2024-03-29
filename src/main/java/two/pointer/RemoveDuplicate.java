package two.pointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 6, 9, 9};
        int resultSet = helper(arr);
        System.out.println(resultSet);

    }

    public static int helper(int[] arr) {
        int uniqueind=0;
        for(int i =1;i<arr.length;i++){
            if(arr[uniqueind]!=arr[i]){
                uniqueind+=1;
                arr[uniqueind]=arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        return uniqueind+1;
    }

}
