package interview;

import java.util.HashSet;
import java.util.Set;

/**
 * 判定字符是否唯一
 * 如果我是面试官，会考虑主要考察什么，就我的工作经验看，大多数主要是招聘工程师的，面试者如果什么问题都没有，直接写个二重循环搞定，会首先给个50分，如果能写点判断字符串是否为null的，60分。
 *
 * 直接上手什么bitset，什么位运算的，我会先问他，题目中有没有交代字符串的字符一定是26个英文字母？如果是unicode环境，你是不是要准备2^16/8个字节的空间？在实际项目中，风险可控，结果可期更重要，绝大多数时候不在乎那点时间和资源。
 *
 * 所以我期望面试者不要急于解答，我希望他先问我问题：
 *
 * 字符串的字符范围，如果我告诉他，26个小写英文字母，那可能一开头直接判断如果字符长度>26, 直接返回False，做到这一点的，80分
 * 如果我告诉他ascii字符集，然后他的代码里有边界检查，并且针对不同的范围有不同的侧重点，比如说ascii字符集，那也就是128个可能性，16个字节的位运算比较好
 * 如果我告诉他是unicode，没有字符范围，老老实实排序再判断是比较符合我对工程师的要求的，因为算法性能稳定，没有额外资源要求，一眼看出没什么不可预见的风险，100分。
 * 就是说，有些东西，没想到或者一时没想到根本不是问题，日常工作中稍微提示一下即可，但是缜密的思维对于程序员来说更重要。
 */
public class interview01 {

    /**
     * 定义一个26长的数组
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        if (astr.equals("")) {
            return true;
        }
        if (astr.length() > 26) {
            return false;
        }
        int[] arr = new int[26];
        for (char ch : astr.toCharArray()) {
            arr[ch - 'a']++;
            if (arr[ch - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * set记录非重复的内容
     * @param astr
     * @return
     */
    public boolean isUnique2(String astr) {
        if (astr.equals("")) {
            return true;
        }
         Set<Character> set = new HashSet<Character>();
         for (char c : astr.toCharArray()) {
             if (set.contains(c)) {
                 return false;
             } else {
                 set.add(c);
             }
         }
         return true;
    }
}
