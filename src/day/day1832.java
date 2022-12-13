package day;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断句子是否为全字母
 */
public class day1832 {

    /**
     * 哈希表
     * @param sentence
     * @return
     */
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
            if (set.size() == 26) {
                return true;
            }
        }
        return set.size() == 26 ? true : false;
    }
}
