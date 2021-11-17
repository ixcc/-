package day;

/**
 * 搜索旋转排序数组
 */
public class day33 {

    /**
     * 二分法，判断前半部分有序或者后半部分有序-再次二分
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int n = nums.length - 1;
        int l  = 0, r = n;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[l] <= nums[mid]) {
                //  左半边有序
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 右边有序
                if (nums[mid] < target && target <= nums[n]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;

                }
            }
        }
        return -1;
    }
}
