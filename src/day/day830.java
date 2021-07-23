package day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day830 {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abc"));
    }


    public static List<List<Integer>> largeGroupPositions(String s) {
        ArrayList arrayList = new ArrayList();
        if(s.length()<3){
            return arrayList;
        }
        int a = 0,b = 1;
        int len = s.length();
        while (b<len){
           if(s.charAt(a) == s.charAt(b)){
               b++;
               if(b==len){
                   if(b-a>=3){
                       ArrayList<Integer> array= new ArrayList<Integer>();
                       array.add(a);
                       array.add(b-1);
                       arrayList.add(array);
                   }
               }
           } else {
               if(b-a>=3){
                   ArrayList<Integer> array= new ArrayList<Integer>();
                   array.add(a);
                   array.add(b-1);
                   arrayList.add(array);
               }
               a = b;
               b ++;
           }
        }
        return arrayList;
    }
}
