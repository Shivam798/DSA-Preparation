package CyclicSort;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] num = {1, 4, 4, 3, 2};
        int[] num1 = {2, 1, 3, 3, 5, 4};
        int[] num2 = {2, 4, 1, 4, 4};
        System.out.println(helper(num));
    }
    private static int helper(int[] num){
        int i=0;
        int n= num.length;
        while(i<n){
            int correctIndex = num[i]-1;
            if(num[correctIndex]!=num[i]){
                int temp = num[i];
                num[i]=num[correctIndex];
                num[correctIndex]=temp;
            }else{
                i+=1;
            }
        }
        for(int j=0;j<n;j++){
            if(num[j]!=j+1){
                return num[j];
            }
        }
        return 0;
    }
}
