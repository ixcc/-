package offerII;

/**
 *排序数组中两数之和
 */
public class Offer006 {

    /**
     * 首位指针
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] arr = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                arr[0] = left;
                arr[1] = right;
                return arr;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }else if (numbers[left] + numbers[right] < target) {
                left++;
            }
        }
        return arr;
    }
}
