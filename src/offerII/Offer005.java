package offerII;

/**
 * 单词的最大长度
 */
public class Offer005 {

    /**
     * 将字母替换成掩码，&比较是否为0判断字母是否重复
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] word = new int[len];
        for (int i = 0; i < len; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
                word[i] |= 1 << (w.charAt(j) - 'a');
            }
        }
        int maxNum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((word[i] & word[j]) == 0) {
                    // 没有重复字母
                    maxNum = Math.max(maxNum, words[i].length() * words[j].length());
                }
            }
        }
        return maxNum;
    }
}
