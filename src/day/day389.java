package day;

public class day389 {
    public static void main(String[] args) {
        findTheDifference("abcd","abcde");
    }

    public static char findTheDifference(String s, String t) {
        char[] array = new char[26];
        char[] arrayTwo = new char[26];
        char find = 0;
        for(int i=0;i<s.length();i++){
            array[s.charAt(i)-97]++;
        }
        for(int j=0;j<t.length();j++){
            arrayTwo[t.charAt(j)-97]++;
        }
        for(int k=0;k<26;k++){
            if(array[k]!=arrayTwo[k]){
                find = (char) (k+97);
                return find;
            }
        }
        return find;
    }
}
