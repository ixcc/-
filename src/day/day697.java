package day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day697 {
    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }

    public static int findShortestSubArray(int[] nums) {
//        int[] array = new int[50000];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
            map.put(nums[i], count + 1);
//            map.put(nums[i],map.get(nums[i])+1);
//            array[nums[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        int maxNum = 1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer mapKey = entry.getKey();
            Integer mapValue = entry.getValue();
            if (mapValue > maxNum) {
                maxNum = mapValue;
                list.clear();
                list.add(mapKey);
            } else if (mapValue == maxNum) {
                list.add(mapKey);
            }
        }
//        for (int i = 0; i < map.size(); i++) {
//            if (map.get(i) > maxNum) {
//                maxNum = map.get(i);
//                list.clear();
//                list.add(i);
//            } else if (map.get(i) == maxNum) {
//                list.add(i);
//            }
//        }
        int len = Integer.MAX_VALUE;
        while (list.size() != 0) {
            int num = list.get(0);
            int first = 0, second = 0;
            boolean flag = true;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num && flag) {
                    first = i;
                    second = i;
                    flag = false;
                } else if (nums[i] == num) {
                    second = i;
                }
            }
            int tempLen = second - first + 1;
            if (tempLen < len) {
                len = tempLen;
            }
            list.remove(list.get(0));
        }
        return len;
    }

    public int findShortestSubArray2(int[] nums) {
        int[] array = new int[50000];
         for (int i = 0; i < nums.length; i++) {
             array[nums[i]]++;
         }
         List<Integer> list = new ArrayList<>();
         int maxNum = 1;
         for (int i = 0; i < array.length; i++) {
             if (array[i] > maxNum) {
                 maxNum = array[i];
                 list.clear();
                 list.add(i);
             } else if (array[i] == maxNum) {
                 list.add(i);
             }
         }
         int len = Integer.MAX_VALUE;
         while (list.size() != 0) {
             int num = list.get(0);
             int first = 0, second = 0;
             boolean flag = true;
             for (int i = 0; i < nums.length; i++) {
                 int temp = nums[i];
                 if (temp == num && flag) {
                     first = i;
                     second = i;
                     flag = false;
                 } else if (temp == num) {
                     second = i;
                 }
             }
             int tempLen = second - first + 1;
             if (tempLen < len) {
                 len = tempLen;
             }
             list.remove(list.get(0));
         }
         return len;
    }

    public int findShortestSubArray3(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++; // 次数加一
                map.get(nums[i])[2] = i; // 末次位置更改
            } else {
                map.put(nums[i], new int[]{1, i, i}); // 出现次数，首次位置，末次位置
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer,int[]> entry : map.entrySet()) {
            if (entry.getValue()[0] > maxNum) { // 出现更频繁数字
                maxNum = entry.getValue()[0]; // 更改最大频次
                minLen = entry.getValue()[2] - entry.getValue()[1] + 1; // 更新最小长度
            } else if (entry.getValue()[0] == maxNum) { // 出现频次相同数字
                if (entry.getValue()[2] - entry.getValue()[1] + 1 < minLen) { // 比较出现位置长度
                    minLen = entry.getValue()[2] - entry.getValue()[1] + 1; // 更新最小长度
                }
            }
        }
        return minLen;
    }
}
