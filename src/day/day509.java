package day;

public class day509 {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int n) {
        if(n<2){
            return n;
        }
        int a = 0,b = 1,c;
        for(int i=0;i<n-1;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return b;
    }

    public static int fib2(int n) {
        if(n<2){
            return n;
        }
       int [] array = new int[n+1];
       array[0] = 0;
       array[1] = 1;
       for(int i=2;i<=n;i++){
           array[i] = array[i-1]+array[i-2];
       }
       return array[n];
    }

    public static int fib3(int n) {
        if(n==0){
            return 0;
        }else if(n<=2){
            return 1;
        }else {
            return fib3(n-1)+fib3(n-2);
        }
    }
}
