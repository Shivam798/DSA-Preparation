package MergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input = {{1,3},{8,10},{2,6},{15,18}};
        int[][] res = merge(input);
        for(int[] interval:res){
            System.out.println(Arrays.toString(interval));
        }
    }
    private static int[][] merge(int[][] intervals){
        if(intervals.length==0 || intervals==null){
            return new int[0][];
        }

        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);

        List<int[]> merge= new ArrayList<>();
        int[] currentInterval = intervals[0];
        merge.add(currentInterval);
        for(int[] interval:intervals){
            int current_end =currentInterval[1];
            int next_start = interval[0];
            int next_end = interval[1];
            if(current_end>=next_start){
                currentInterval[1]=Math.max(current_end,next_end);
            }
            else{
                currentInterval=interval;
                merge.add(currentInterval);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
