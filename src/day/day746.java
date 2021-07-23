package day;

import java.util.Arrays;

public class day746 {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));

    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }


//    public static int minCostClimbingStairs(int[] cost) {
//        if(cost.length==2){
//            return Math.min(cost[1],cost[0]);
//        }
//        int minNumber = 0;
////        int leng = cost.length;
//        while (cost.length>2){
//            if (cost[1]<cost[0]+cost[2]){
//                // 走两步
//                minNumber+=cost[1];
//                cost = arraySub(cost,2,cost.length);
//            }else {
//                // 走一步
//                minNumber+=cost[0];
//                cost = arraySub(cost,1,cost.length);
//            }
//        }
//        if(cost.length==2){
//            return minNumber+Math.min(cost[1],cost[0]);
//        }
//        return minNumber;
//    }

    public static int[] arraySub(int[] data,int start,int end){
        int[] C=new int[end-start];//新建数组C长度为start-end
        int j=0;
        for(int i=start;i<end;i++){
            C[j]=data[i];
            j++;
        }
        return C;//返回截取数组的地址
    }
}
