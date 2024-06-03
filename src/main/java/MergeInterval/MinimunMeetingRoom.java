package MergeInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimunMeetingRoom {
    public static void main(String[] args) {
        int[][] input = {{4,5},{2,3},{2,4},{3,5}};
        int res= helper1(input);
        System.out.println(res);
    }

//  Two array list method
    private static int helper (int [][] input){
        if(input.length==0 || input==null){
            return 0;
        }
        int n = input.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0;i<n;i++){
            start[i]=input[i][0];
            end[i]=input[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endPointer =0;
        int room=0;
        for(int i =0 ;i<n;i++){
            if(start[i]<end[endPointer]){
                room+=1;
            }
            else {
                endPointer+=1;
            }
        }
        return room;


    }

    private static int helper1 (int [][] input){
        if(input.length==0 || input==null){
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Arrays.sort(input,(a,b)->a[0]-b[0]);
        heap.add(input[0][1]);
        for (int i = 1; i < input.length; i++) {
            int start = input[i][0];
            int end = input[i][1];
            if(heap.peek()<=start){
                heap.poll();
            }
            heap.add(end);
        }
        return heap.size();

    }
}
