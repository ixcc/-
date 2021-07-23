package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer57II {

    public static void main(String[] args) {
        System.out.println(findContinuousSequence(9));
    }

    public static int[][] findContinuousSequence(int target) {
        // 边界值处理，目标值小于3时无可匹配数值直接返回
        if (target < 3) {
            return new int[0][];
        }
        // 定义双指针--指向目标值取值两个边界
        int left = 1, right = 2;
        // 记录两边界内数值的和
        int count = 3;
        // 定义list便于存储不确定数量的一维数组
        List<int[]> list = new ArrayList<>();
        // 循环处理
        while (left <= right && left <= target - 1) {
            // 当至少有两个数字且范围内数值之和等于目标值时
            if (right > left && count == target) {
                // 新生成一维数组记录该值
                int[] array = findCount(left, right);
                list.add(array);
                // 如右边界没超过目标值--继续寻找其他可能性
                if (right < target) {
                    right ++;
                    count += right;
                }
            } else if (count > target) {
                // 当边界值内数值之和大于目标值则数值之和减去原有左边界值，且左边界右异动一格
                count -= left;
                left++;
            } else if (count < target && right < target) {
                // 当边界值内数值之和小于目标值则右边界右异动一格，且数值之和加上新加入的右边界值
                right++;
                count += right;
            }
        }
        // 将List转为二维数组返回
        int length = list.size();
        int[][] arr = new int[length][];
        for(int i = 0; i < length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public static int[] findCount(int left, int right) {
        int length = right - left + 1;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = left;
            left++;
        }
        return array;
    }

    public int[][] findContinuousSequence2(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(s == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if(s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
