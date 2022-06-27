package day;

/**
 * 最长特殊序列ii
 */
public class day522 {

    /**
     * 两层遍历，匹配是否有相等的子序列
     * @param strs
     * @return
     */
    public int findLUSlength(String[] strs) {
        int len = strs.length;
        int ans = -1;
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (i != j && isEqaul(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isEqaul(String s, String j) {
        int ps = 0, pj = 0;
        while (ps < s.length() && pj < j.length()) {
            if (s.charAt(ps) == j.charAt(pj)) {
                ps++;
            }
            pj++;
        }
        return ps == s.length();
    }
}
