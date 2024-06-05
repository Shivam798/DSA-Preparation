package MergeInterval;

import java.util.*;

public class MaximumCpuLoad {
    public static  void main(String[] args) {
        int[][] jobs = new int[][]{
                {1, 4, 3},
                {2, 5, 4},
                {7, 9, 6}
        };
        System.out.println(helper(jobs));
    }

    private static int helper(int[][] jobs) {
        int maxLoad=0;
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]);
        List<int[]> previous = new ArrayList<>();
        previous.add(jobs[0]);
        for(int i =1;i< jobs.length;i++){
            int[] current= jobs[i];
            int[] pre = previous.get(previous.size()-1);
            if(current[0]<pre[1]){
                previous.set(previous.size()-1,new int[]{
                        pre[0],
                        Math.max(current[1],pre[1]),
                        current[2]+pre[2]
                });
            }else{
                previous.add(current);
            }
        }
        for(int[] interval:previous){
            maxLoad=Math.max(maxLoad,interval[2]);
        }


        return maxLoad;
    }
}
