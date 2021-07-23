package offer;

import java.util.HashSet;
import java.util.Set;

public class Offer57 {

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2,3,9,41,46,47}, 49));
    }

    public int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int tar = nums[left] + nums[right];
            if (tar == target) {
                return new int[]{nums[left], nums[right]};
            } else if (tar > target) {
                right -- ;
            } else if (tar < target) {
                left ++;
            }
        }
        return new int[0];
    }

    public int[] twoSum3(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(target - num))
                set.add(num);
            else
                return new int[]{num, target - num};
        }
        return new int[]{};
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                array[0] = nums[i];
                if (onwSum(nums, target - nums[i]) != -1) {
                    array[1] = onwSum(nums, target - nums[i]);
                    return array;
                }
            }
        }
        return array;
    }

    public static int onwSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return nums[middle];
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return -1;
    }


}
