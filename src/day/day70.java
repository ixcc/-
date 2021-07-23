package day;

public class day70 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int l1 = 1, l2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = l1 + l2;
            l1 = l2;
            l2 = temp;
        }
        return l2;
    }
}
