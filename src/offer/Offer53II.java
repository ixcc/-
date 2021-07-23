package offer;

public class Offer53II {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0}));
    }

    public static int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] != m) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
