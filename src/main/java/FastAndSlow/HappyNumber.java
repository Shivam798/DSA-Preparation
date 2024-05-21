package FastAndSlow;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int num = 23;
        Set<Integer> set = new HashSet<>();
        System.out.println(isHappyNumber1(num,set));
        System.out.println(isHappyNumber(num));
        System.out.println(isHappyNumberSAndF(num));
    }

    //    O(N) time and O(1) space
    private static boolean isHappyNumberSAndF(int num) {
        int slow =num;
        int fast = getNextNumber(num);
        while (fast!=1 && slow!=fast){
            slow=getNextNumber(slow);
            fast=getNextNumber(getNextNumber(fast));
        }
        return fast==1;
    }

    //    O(N) time and O(N) space
    private static boolean isHappyNumber1(int num ,Set<Integer> set) {
        if(set.contains(num)){
            return false;
        }
        if(num==1){
            return true;
        }
        set.add(num);
        String s= String.valueOf(num);
        int summ=0;
        for(int i =0;i<s.length();i++){
            Integer d = s.charAt(i)-'0';
            int sqr =  d*d;
            summ+=sqr;
        }
        return isHappyNumber1(summ,set);

    }

    //    O(N) time and O(N) space another better writing way
    private static boolean isHappyNumber(int num){
        Set<Integer> set = new HashSet<>();
        while(num!=1 && !set.contains(num) ){
            set.add(num);
            num=getNextNumber(num);
        }
        return num==1;
    }

    private static int getNextNumber(int num) {
        int sum=0;
        while(num>0){
            int dig=num%10;
            sum+=(dig*dig);
            num/=10;
        }
        return sum;
    }

}
