package offerII;

/**
 * 只出现一次的数字
 */
public class Offer004 {
    public int singleNumber(int[] nums) {
        int[] binarySum = new int[32];
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i & 1);
            }
            binarySum[i] = sum;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (binarySum[i] % 3 != 0) {
                res += 1 << i;
            }
        }
        return res;
    }
}
