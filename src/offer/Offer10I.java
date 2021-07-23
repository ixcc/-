package offer;

public class Offer10I {
//    public static int numWay = 0;

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

    public static int numWays(int n) {
        int a=1,b=1,sum = 0;
        for(int i=0;i<n;i++){
            sum=(a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

//    public static int numWays(int n) {
//        int[] menWay = new int[101];
//        menWay[0] = 1;
//        menWay[1] = 1;
//        return ways(menWay,n);
//    }

//    public static int numWays(int n) {
//        if(n==0||n==1){
//            return 1;
//        }else if(n==2){
//            return n;
//        }
//        return (numWays(n-1)+numWays(n-2))%1000000007;
//    }

    public static int ways(int[] menWay,int n){
        if (menWay[n]!=0){
            return menWay[n];
        }
        menWay[n]  = (ways(menWay,n-1)+ways(menWay,n-2))%1000000007;
        return menWay[n];
    }
}
