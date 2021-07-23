package day;

import java.util.Arrays;

public class day455 {
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int childrenNum = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=0;i<s.length;i++){
            if(s[i]>=g[childrenNum]){
                childrenNum++;
                if(childrenNum==g.length){
                    return childrenNum;
                }
            }
        }
        return childrenNum;
    }
}
