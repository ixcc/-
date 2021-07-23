package offer;

public class Offer16 {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    public static double myPow(double x, int n) {
        if(n == 0){
           return 1;
        }
        if(n>0){
            return newPow(x,n);
        }
       return newPow(1/x,-n);
    }

    public static double newPow(double x, int n){
        if(n == 0){
            return 1;
        }
        double r = newPow(x,n/2) ;
        if((n & 1) == 0 ){
            //偶数次幂
            return r*r;
        }else {
            //奇数次幂
            return r*r*x;
        }
    }

    public double myPow2(double x,int n){
        if(n == 0){
            return 1;
        }
        if(n<0){
          return 1/x * myPow2(1/x,-n-1);
        }
        return (n % 2 ) == 0 ? myPow2(x*x,n/2) : x * myPow2(x*x,n/2);
    }

    public double myPow3(double x,int n){
        double res = 0;
        for(int i=n;i!=0;i=i/2,x=x*x){
            if(i%2 != 0){
                //奇数
                res *= x;
            }
        }
        return n<0 ? 1/res : res;
    }
}
