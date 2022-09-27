package day;

import java.util.HashMap;
import java.util.Map;

public class day0102 {

    public static void main(String[] args) {
        System.out.println(CheckPermutation("asvnpzurz", "urzsapzvn"));
    }

    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char temp = s2.charAt(i);
            if (map.containsKey(temp) && map.get(temp) >0) {
                map.put(temp, map.get(temp) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

}
