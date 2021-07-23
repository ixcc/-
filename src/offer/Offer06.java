package offer;

import java.util.ArrayList;
import java.util.List;

public class Offer06 {

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] array = new int[list.size()];
        int length = list.size() - 1;
        for (Integer integer : list) {
            array[length] = integer;
            length--;
        }
        return array;
    }
}
