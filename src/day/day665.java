package day;

public class day665 {

    public boolean checkPossibility(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {
                if ((i > 0 && nums[i-1] > nums[i+1]) && (i<nums.length-2 && nums[i] > nums[i+2])) {
                    return false;
                }
                flag ++;
            }
        }
        return flag <= 1 ? true : false;
    }
}
