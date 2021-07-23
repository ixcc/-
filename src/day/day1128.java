package day;

public class day1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int sum = 0;
        for(int i=0;i<dominoes.length;i++){
            for(int j=i+1;j<dominoes.length;j++){
               if((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])){
                   sum++;
               }
            }
        }
        return sum;
    }

    public boolean IsEquivDominoPairs(int[][] dominoes,int[][] dominoesTwo){
        if((dominoes[0][0] == dominoesTwo[0][0] && dominoes[0][1] == dominoesTwo[0][1]) || (dominoes[0][0] == dominoesTwo[0][1] && dominoes[0][1] == dominoesTwo[0][0])){
            return true;
        }
        return false;
    }

    public int numEquivDominoPairs2(int[][] dominoes){
        int[] freq = new int[100];
        int count = 0;
        for (int[] dominoe : dominoes) {
            if (dominoe[0] > dominoe[1]) {
                int temp = dominoe[0];
                dominoe[0] = dominoe[1];
                dominoe[1] = temp;
            }

            int num = dominoe[0] * 10 + dominoe[1];
            count += freq[num];
            freq[num]++;
        }
        return count;
    }
}
