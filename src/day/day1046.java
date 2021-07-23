package day;

import java.util.Arrays;
import java.util.PriorityQueue;

public class day1046 {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{1,3}));
    }

    public static int lastStoneWeight(int[] stones) {
//        int sumStone = 0;
//        for(int i=0;i<stones.length;i++){
//            sumStone +=stones[i];
//        }
//        if(sumStone%2==0){
//            return 0;
//        }else {
//            return 1;
//        }
        int stoneLen = stones.length-1;
        //边界值处理，长度为1时
        if(stoneLen==0){
            return stones[stoneLen];
        }
        Arrays.sort(stones);
        //递归终结条件，只剩最后一个值
        if(stones[stoneLen-1]==0){
            return stones[stoneLen];
        }
        //最大和次大值之间相减
        int tempStone = stones[stoneLen]-stones[stoneLen-1];
        //相减后更改两个值的大小
        if(tempStone>0){
            stones[stoneLen] = tempStone;
        }else {
            stones[stoneLen] = 0;
        }
        stones[stoneLen-1] = 0;
        //递归求值
        return lastStoneWeight(stones);
    }

    public static int lastStoneWeights(int[] stones){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b-a);
        //放入最大堆
        for(int stone : stones){
            pq.offer(stone);
        }
        //遍历最大堆
        while (pq.size()>1){
            int a = pq.poll();
            int b = pq.poll();
            if(a > b){
                //剩余值放入最大堆
                pq.offer(a-b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
