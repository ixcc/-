package offer;

public class Offer64 {

    int res;
    public int sumNums(int n) {
        Boolean flag = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    public int sumNums2(int n) {
        Boolean x = n > 1 && (n += sumNums2(n - 1)) > 0;
        return n;
    }
}
