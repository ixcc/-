package day;

public class day724 {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{-1,-1,-1,0,1,1}));
    }

    public static int pivotIndex(int[] nums) {
        if(nums.length<3){
            return -1;
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }
        int leftSum = 0;
        for(int j=0;j<nums.length;j++){
            sum -=nums[j];
            if(sum == leftSum){
                return j;
            }
            leftSum +=nums[j];
        }
        return -1;
    }
}
