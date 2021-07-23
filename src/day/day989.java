package day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day989 {
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9},1));
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> array = new ArrayList<Integer>();
        int addTo = 0;
        int len = A.length-1;
        while (len >=0 || K != 0){
            if(K == 0){
                if(A[len]+addTo>=10){
                    array.add(A[len]+addTo-10);
                    addTo = 1;
                }else {
                    array.add(A[len]+addTo);
                    addTo = 0;
                }
                len--;
                continue;
            }
            int yu = K%10;
            if(len < 0){
                if(yu+addTo>=10){
                    array.add(yu+addTo-10);
                    addTo = 1;
                }else {
                    array.add(yu+addTo);
                    addTo=0;
                }
                K = K/10;
                continue;
            }
            if(yu+A[len]+addTo>=10){
                array.add((yu+A[len]+addTo)-10);
                addTo = 1;
            }else {
                array.add(yu+A[len]+addTo);
                addTo = 0;
            }
            len --;
            K = K/10;
        }
        if(addTo == 1){
            array.add(addTo);
        }
        List<Integer> arr = new ArrayList<Integer>();
        for(int i=array.size()-1;i>=0;i--){
            arr.add(array.get(i));
        }
        return arr;
    }

    public List<Integer> addToArrayForm2(int[] A,int K){
        List<Integer> array = new ArrayList<Integer>();
        int len = A.length-1;
        for(int i=len;i>=0;i--){
            int sum = A[i] + K%10;
            K = K/10;
            if(sum >=10){
                sum = sum-10;
                K++;
            }
            array.add(sum);
        }
        for(;K>0;K=K/10){
            array.add(K%10);
        }
        Collections.reverse(array);
        return array;
    }
}
