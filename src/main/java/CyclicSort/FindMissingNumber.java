package CyclicSort;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] num ={8, 3, 5, 2, 4, 6, 0, 1};
        System.out.println(helper(num));
    }
    private static int helper(int [] num){
        int res=0;
        int i =0;
        while(i<num.length){
            //since the range start with 0 we are using this expression for currect index
            int correctIndex = num[i];
            //if the range starts from 1 we use num[i]-1
            if(num[i]<num.length && num[correctIndex]!=num[i]){
                int temp = num[i];
                num[i]=num[correctIndex];
                num[correctIndex]=temp;
            }else{
                i++;
            }

        }
        for(int j=0;j<num.length;j++){
            if(num[j]!=j){
                return j;
            }
        }
        return res;
    }

}
