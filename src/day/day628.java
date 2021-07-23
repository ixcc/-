package day;

import java.util.Arrays;

public class day628 {
    public static void main(String[] args) {
        System.out.println(maxNum(new int[]{-1,-2,-3,-4}));
    }

    public static int maximumProduct(int[] nums) {
        int maxNum = 0;
        Arrays.sort(nums);
        int len = nums.length-1;
        if(nums[0]<0 && nums[1]<0 && nums[len]>0 && nums[len-2]*nums[len-1]<nums[0]*nums[1]){
            maxNum = nums[0]*nums[1]*nums[len];
        }else{
            maxNum = nums[len]*nums[len-1]*nums[len-2];
        }
        return maxNum;
    }

    public static int maxNum(int[] nums){
        int maxNumFirst = Integer.MIN_VALUE,maxNumSecond = Integer.MIN_VALUE,maxNumThread = Integer.MIN_VALUE;
        int minNumFirst = Integer.MAX_VALUE,minNumSecond = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num < minNumFirst){
                //比最小的数更小
                minNumSecond = minNumFirst;
                minNumFirst = num;
            }else if(num < minNumSecond){
                //比第二小的数小
                minNumSecond = num;
            }
            if(num > maxNumFirst){
               //比最大的数大
               maxNumThread = maxNumSecond;
               maxNumSecond = maxNumFirst;
               maxNumFirst = num;
            }else if(num > maxNumSecond){
                //比第二大的数大
                maxNumThread = maxNumSecond;
                maxNumSecond = num;
            }else if(num > maxNumThread){
                maxNumThread = num;
            }
        }
        return Math.max(maxNumFirst*maxNumSecond*maxNumThread,maxNumFirst*minNumFirst*minNumSecond);
    }
}
