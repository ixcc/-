package day;

public class day643 {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double temp = sum;
        for (int j = k; j < nums.length; j++) {
            temp = temp + (nums[j] - nums[j-k]);
            if (temp >= sum) {
                sum = temp;
            }
        }
        return sum/k;
    }
}
