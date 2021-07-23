package offer;

public class Offer53I {

    public int search(int[] nums, int target) {
        int count = 0;
        int left = 0, right = nums.length - 1;
        int middle = (right + left) /2;
        while (left <= right) {
            if (nums[middle] == target) {
                count ++;
                left = middle;
                right = middle;
                while ((left >= 0 && nums[left] == target) ||(right <= nums.length - 1 && nums[right] == target)) {
                    if (nums[left] >= 0 && nums[left] == target) {
                        count ++;
                        left --;
                    }
                    if (nums[right] <= nums.length - 1 && nums[right] == target) {
                        count ++;
                        right ++;
                    }
                }
                return count;
            } else {
                if (nums[middle] < target) {
                    left = middle;
                } else {
                    right = middle;
                }
                middle = (right + left) /2;
            }
        }
        return count;
    }

    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] <= target) {
                i = middle + 1;
            } else  if (nums[middle] > target) {
                j = middle - 1;
            }
        }
        right = i;
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] >= target) {
                j = middle - 1;
            } else if (nums[middle] < target) {
                i = middle + 1;
            }
        }
        left = j;
        return right - left - 1;
    }
}
