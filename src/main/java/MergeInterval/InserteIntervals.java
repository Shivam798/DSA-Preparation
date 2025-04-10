package MergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InserteIntervals {
    public static void main(String[] args) {
        int[][] input = {{2,3},{5,6}};
        int[] interval = {1,4};
        int[][] res = helper(input,interval);
        for(int[] inter :res)
            System.out.println(Arrays.toString(inter));
    }
    private static int[][] helper(int[][] intervals,int[] interval){
        List<int[]> merge = new ArrayList<>();
        int start = interval[0];
        int end = interval[1];
        int i=0;

        //Added all the intervals which are smaller than new interval
        while(i<intervals.length && intervals[i][1]<start){
            merge.add(intervals[i]);
            i++;
        }
        //overlapping intervals
        while(i< intervals.length && intervals[i][0]<=end){
            start = Math.min(start,intervals[i][0]);
            end= Math.max(end,intervals[i][1]);
            i++;
        }
        merge.add(new int[]{start,end});
        //
        while(i<intervals.length){
            merge.add(intervals[i]);
            i++;
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
