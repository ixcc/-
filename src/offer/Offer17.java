package offer;

public class Offer17 {
    public static void main(String[] args) {
        System.out.println(printNumbers(1));
    }

    public static int[] printNumbers(int n) {
        double sum = Math.pow(10,n);
        int[] arr = new int[(int)sum*9];
        for(int i=0;i<arr.length;i++){
            arr[i] = i+1;
        }
        return arr;
    }

    StringBuilder res;
    int n,start,nine=0;
    char[] num,loop={'0','1','2','3','4','5','6','7','8','9'};
    public String printNumber(int n){
        this.n = n;
        res = new StringBuilder();//数字字符串集
        num = new char[n];//字符列表
        start = n-1;//取值位去零
        dfs(0); //递归
        res.deleteCharAt(res.length()-1); //删除多余末尾逗号
        return res.toString();
    }

    public void dfs(int x){
        //判断终止条件，遍历完所以位
        if(x==n){
            String temp = String.valueOf(num).substring(start);
            if(!temp.equals("0")){
                res.append(temp+",");//追加进字符串中
            }
            res.append(String.valueOf(num)+",");
            //取零值多一位
            if(n-start==nine){
                start --;
            }
            return ;
        }
        //遍历'0'-'9'
        for(char i : loop){
            if(i=='9'){
                nine++;
            }
            num[x] = i;//固定x位是i
            dfs(x+1);//遍历x+1位
        }
        nine--;
    }
}
