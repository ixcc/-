package day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 */
public class day912 {

    /**
     * 调用库函数
     * @param nums
     * @return
     */
    public int[] sortArrayOne(int[] nums) {
         Arrays.sort(nums);
         return nums;
    }

    /**
     * 冒泡排序 -- 超时
     * @param nums
     * @return
     */
    public int[] sortArrayTwo(int[] nums) {
         for (int i = 0; i < nums.length; i++) {
             for (int j = i; j < nums.length; j++) {
                 if (nums[i] > nums[j]) {
                     int temp = nums[j];
                     nums[j] = nums[i];
                     nums[i] = temp;
                 }
             }
         }
         return nums;
    }

    /**
     * 队列优先排序--大根堆
     * @param nums
     * @return
     */
    public int[] sortArrayThree(int[] nums) {
         PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
             public int compare(Integer a, Integer b){
                 return a.compareTo(b);
             }
         });
         for (int i = 0; i < nums.length; i++) {
             queue.add(nums[i]);
         }
         int[] newArr = new int[nums.length];
         for (int j = 0; j < nums.length; j++) {
             newArr[j] = queue.poll();
         }
         return newArr;
    }

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        quarkSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void quarkSort (int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quarkSort(arr, low, index - 1);
            quarkSort(arr, index + 1, high);
        }
    }

    public int getIndex (int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
