package day;

/**
 * 猜数字
 */
public class day299 {

    /**
     * 两轮遍历，数组记录数字次数
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int[] arrS = new int[10];
        int[] arrG = new int[10];
        int bulls = 0, cows = 0;
        char[] arrSe = secret.toCharArray();
        char[] arrGu = guess.toCharArray();
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            if (arrSe[i] == arrGu[i]) {
                bulls++;
            }
            arrS[arrSe[i] - '0']++;
            arrG[arrGu[i] - '0']++;
        }
        for (int i = 0; i < arrS.length; i++) {
            if (arrS[i] > 0 && arrG[i] > 0) {
                if (arrS[i] >= arrG[i]) {
                    cows += arrG[i];
                } else {
                    cows += arrS[i];
                }
            }
        }
        cows -= bulls;
        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
    }

    /**
     * 优化写法
     * @param secret
     * @param guess
     * @return
     */
    public String getHint2(String secret, String guess) {
        int a = 0, b = 0;

        int[] arr = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                // 小于0说明之前guess中出现过相同的字符
                if (arr[secret.charAt(i) - '0']++ < 0) b++;
                // 大于0说之前secret中出现过相同的字符
                if (arr[guess.charAt(i) - '0']-- > 0) b++;
            }
        }

        // 构造返回值
        return new StringBuilder().append(a).append('A').append(b).append('B').toString();
    }

}
