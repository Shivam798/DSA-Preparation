package two.pointer;

import java.util.ArrayList;
import java.util.List;

public class subProdWithTar {
    public static void main(String[] args) {
        int[] arr={2, 5, 3, 10};
        int tar = 30;
        List<List<Integer>> result = helper(arr,tar);
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
    public static List<List<Integer>> helper(int[] nums, int k){
        List<List<Integer>> result = new ArrayList<>();
        if (k <= 1) return result; // If k is less than or equal to 1, no subarray will satisfy the condition

        int left = 0;
        int product = 1;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            List<Integer> subarray = new ArrayList<>();

            while (product >= k && left <= right) {
                product /= nums[left++];
            }

            for (int i = right; i >= left; i--) {
                subarray.add(nums[i]);
                result.add(new ArrayList<>(subarray));
            }
        }

        return result;
    }
}
