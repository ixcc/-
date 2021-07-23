package day;

public class day387 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar(""));
    }

    public static int firstUniqChar(String s) {
//        if(s.length()<2){
//            return s.length()-1;
//        }
        int index = -1;
        String str = s;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
//                if(i==s.length()-1){
//                    return i;
//                }
                if(i==j && j != s.length()-1){
                    continue;
                }
                if(str.charAt(i) == s.charAt(j) && i != j){
                    break;
                }
                if(j==s.length()-1){
                    return i;
                }
            }
        }
        return index;
    }
}
