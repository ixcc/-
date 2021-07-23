package day;

import java.util.ArrayList;
import java.util.List;

public class day1018 {
    public static void main(String[] args) {
        System.out.println(prefixesDivBy5(new int[]{0,1,1}));
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        ArrayList<Boolean> array = new ArrayList<>();
        int temp = 0;
        for(int i=0;i<A.length;i++){
            temp = ((temp<<1)+A[i])%5 ;
            array.add(temp == 0);
        }
        return array;
    }
}
