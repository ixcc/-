package offer;

public class Offer14I {

    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
    }

    public static int cuttingRope(int n) {
        int cutNum = 0;
        if (n <= 3){
            return n-1;
        }
        int treeSum = n/3;
        int yuNum = n%3;
        if(yuNum == 0){
            cutNum = (int)Math.pow(3,treeSum);
        }else if(yuNum == 1){
            cutNum = (int)Math.pow(3,treeSum-1)*4;
        }else if(yuNum == 2){
            cutNum = (int)Math.pow(3,treeSum)*2;
        }
        return cutNum;
    }
}
