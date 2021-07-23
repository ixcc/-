package offer;

public class Offer51 {

    int[] num, temp;
    public int reversePairs(int[] nums) {
        this.num = nums;
        this.temp = new int[nums.length];
        return reverseNums(0, nums.length - 1);
    }

    public int reverseNums(int left, int right){
        // 边界处理
        if (left >= right) {
            return 0;
        }
        // 分治
        int middle = (left + right) / 2;
        int res = reverseNums(left, middle) + reverseNums(middle + 1, right);
        // 合并
        int i = left, j = middle + 1;
        for (int k = left; k <= right; k++) {
            temp[k] = num[k];
        }
        for (int k = left; k <= right; k++) {
            if (i == middle + 1) {
                // 左子数组全部处理完--即只需要放入右子数组数据
                num[k] = temp[j++];
            } else if (j == right + 1 || temp[i] <= temp[j] ) {
                // 右子数组全部处理完or左子数组元素小于右子数组元素--即放入左子数组元素即可
                num[k] = temp[i++];
            } else {
                // 左子数组比右子数组大--即添加逆序数量为m - i + 1
                num[k] = temp[j++];
                res += middle - i + 1;
            }
        }
        return res;
    }
}
