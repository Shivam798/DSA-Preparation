package two.pointer;

public class CompareStringwithBackSlash {
    public static void main(String[] args) {
            String s1 = "xywrrmp";
        String s2 = "xywrrmu#p";
        System.out.println(comapre(s1,s2));
    }
    public static boolean comapre(String s1,String s2){
        s1=builderString(s1);
        s2=builderString(s2);
        return s1.equals(s2);
    }
    public static String builderString(String s){
        StringBuilder str= new StringBuilder();
        int backslack =0;
        for(int i =s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if('#' == c){
                backslack++;
            }
            else{
                if(backslack>0){
                    backslack--;
                }else{
                    str.append(c);

                }
            }
        }
        return str.toString();
    }
}
