package offer;

public class Offer10 {
    public static void main(String[] args) {
        System.out.println(fib(44));
    }

//    public static int fib(int n) {
//        if(n==0){
//            return 0;
//        }else if(n==1 || n==2){
//            return 1;
//        }else {
//            return fib(n-1)+fib(n-2);
//        }
//    }

    public static int fib(int n) {
        if(n<2){
            return n;
        }
        int num1 = 0;
        int num2 = 1;
        int sum = 0;
        while (n>=2){
            sum = (num1+num2)%1000000007;
            num1 = num2;
            num2 = sum;
            n--;
        }
        return sum;
    }
}
