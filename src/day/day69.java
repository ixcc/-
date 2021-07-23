package day;

public class day69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 0, right = x/2;
        while (left <= right){
            int middle = (left + right)/2;
            if (middle * middle == x) {
                return middle;
            } else if (x / middle > middle) {
                right = middle - 1;
            } else if (x / middle < middle) {
                left = middle + 1;
            }
        }
        return left - 1;
    }
}
