package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer56II {

    public int singleNumber(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count += num;
        }
        Map<Integer,Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num,true);
            }
        }
        int sum = 0;
        for (Map.Entry<Integer,Boolean> entry : map.entrySet()) {
            Integer key = entry.getKey();
            sum += key;
        }
        return (3*sum - count) / 2;
    }
    public int singleNumber2(int[] nums) {
         Map<Integer,Integer> map=new HashMap<>();
         for(int num:nums){
             map.put(num,map.getOrDefault(num,0)+1);
         }
         for(Map.Entry<Integer,Integer> entry:map.entrySet()){
             if(entry.getValue()==1){
                 return entry.getKey();
             }
         }
         return -1;
    }
}
