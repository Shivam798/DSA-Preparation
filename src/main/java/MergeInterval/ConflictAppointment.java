package MergeInterval;

import java.util.Arrays;

public class ConflictAppointment {
    public static void main(String[] args) {
        int[][] input = {{1,4},{2,5},{6,7}};
        int[][] input2 = {{6,7},{2,4},{8,12}};
        System.out.println(helper(input));
    }
    private static boolean helper(int[][] input){
        Arrays.sort(input,(a,b)->a[0]-b[0]);
        int[] currInterval = input[0];
        int currend = currInterval[1];
        int currstart = currInterval[0];
        for(int i = 1; i < input.length; i++){
            int start = input[i][0];
            int end = input[i][1];
            // Check if there is a conflict
            if(currend>start){
                return false;
            }
            //Update the currend
            currend=end;
        }
        return true;
    }
}
