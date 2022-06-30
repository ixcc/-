package day;

/**
 * 质数排序
 */
public class day1175 {

    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(100));
    }

    public static int numPrimeArrangements(int n) {
        int zhi = 0;
        for (int i = 2; i <= n; i++) {
            if (IsZhi(i)) {
                zhi++;
            }
        }
        return (int)(factorial(zhi)*factorial(n - zhi)%1000000007);
    }

    public static long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= 1000000007;
        }
        return res;
    }

    public static boolean IsZhi (int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
