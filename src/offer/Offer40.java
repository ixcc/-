package offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Offer40 {

    public static void main(String[] args) {
        System.out.println(getLeastNumbers(new int[]{3,2,1} , 2) );
    }

    /**
     * 快速排序方式
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0) {
            return arr;
        }
        return quickSort(arr, k, 0, arr.length-1);
    }

    public int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l;
        int j = r;
        while (i < j) {
            // 最右边的值比目标值arr[l]都大
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            // 最左边的值都比目标值小
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            // 找到左右需要互换的值
            swap(arr, i, j);
        }
        // 交换哨兵值
        swap(arr, i, l);
        // 前k小的数值小于找到的i--递归左子数组执行哨兵划分
        if (i > k) {
            return quickSort(arr, k, l, i-1);
        }
        // 前k小的数值大于找到的i--递归右子数组执行哨兵划分
        if (i < k) {
            return quickSort(arr, k, i+1, r);
        }
        // 等于k时--截取数组前K个数字大小
        return Arrays.copyOf(arr, k);
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 大根堆方式
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] array = new int[k];
        // 边界值判断，k为0时
        if (k == 0) {
            return array;
        }
        // 大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0 ; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll(); // 取出堆顶元素
                queue.offer(arr[i]); // 重新放入新元素
            }
        }
        for (int i = 0; i < k; i++) {
            array[i] = queue.poll();
        }
        return array;
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = arr[i];
        }
        Arrays.sort(array);
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < array[k-1]) {
                sortArr(array,arr[i]);
            }
        }
        return array;
    }

    public static int[] sortArr(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int middle = 0;
        int index = 0;
        while (left <= right) {
            middle = (right - left)/2;
//            if (array[middle] <= target && array[middle + 1] > target) {
//                index = middle + 1;
//                break;
//            }
            if (array[middle] > target) {
                right = middle - 1;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                index = middle ;
                break;
            }
        }
        for (int i = array.length; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = target;
        return array;
    }
}
