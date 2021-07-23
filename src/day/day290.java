package day;

import java.util.HashMap;
import java.util.Map;

public class day290 {
    public static boolean wordPattern(String pattern, String s) {
        String []newStr = s.split(" ");
        if(pattern.length() != newStr.length){
            return false;
        }
        Map<Character, String> dict = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(dict.containsKey(pattern.charAt(i))){
                if(!dict.get(pattern.charAt(i)).equals(newStr[i])){
                    return false;
                }
            }else{
                for (String value : dict.values()) {
                    if(value.equals(newStr[i])){
                        return false;
                    }
                }
                dict.put(pattern.charAt(i),newStr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("aaa","aa aa aa aa"));

    }
}
