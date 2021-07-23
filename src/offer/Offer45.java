package offer;

import java.util.Arrays;

public class Offer45 {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{10, 2}));
    }
    public static String minNumber(int[] nums) {
        int[] arr = new int[10];
        String str = "";
        for (int i = 0; i < nums.length; i++) {
           char[] temp = Integer.toString(nums[i]).toCharArray();
           for (int j = 0; j < temp.length; j++) {
              arr[temp[j] - '0']++;
           }
        }
        boolean first = true;
        int index = 1;
        while (index <= 9) {
            if (first) {
                // 填首位
                if (arr[index] != 0) {
                    str += Integer.toString(index);
                    arr[index]--;
                    first = false;
                    index = 0;
                } else {
                    index++;
                }
            } else {
                // 从小到大排
                if (arr[index] != 0) {
                    str += Integer.toString(index);
                    arr[index]--;
                } else {
                    index++;
                }
            }

        }
        return str;
    }

    public String minNumber2(int[] nums) {
        StringBuilder str = new StringBuilder();
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        for (String s : strs) {
            str.append(s);
        }
        return str.toString();
    }
}
