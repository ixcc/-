package offer;

public class Offer14II {
    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }

    public static int cuttingRope(int n) {
        if(n<=3){
            return n-1;
        }
        int mode = 1000000007;
        long res = 1;
        while (n>4){
            res = res*3;
            res = res%mode;
            n = n-3;
        }
        return (int)(res*n%mode);
    }
}
