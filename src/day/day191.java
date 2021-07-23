package day;

public class day191 {

    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n-1;
            ret++;
        }
        return ret;
    }

    public int hammingWeight2(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
