package day;

public class day303 {

    public int[] array;

    public day303(int[] nums) {
        int n = nums.length;
        array = new int[n+1];
        for (int i = 0; i < n; i++) {
            array[i + 1] = array[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return array[j+1] - array[i];
//        int result = 0;
//        while (i <= j) {
//            result += array[i];
//            i++;
//        }
//        return result;
    }
}
