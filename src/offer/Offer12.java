package offer;

public class Offer12 {
    public boolean exist(char[][] board, String word) {
        // 转换字符串为字符数组
        char [] words = word.toCharArray();
        // 初始位置任意，两层遍历二维字符数组
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfsIsExist(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfsIsExist(char[][] board, char[] word, int x, int y ,int k){
        // 终止条件--下标边界越界、字符不匹配
        if(x<0 || x>board.length-1 || y<0 || y>board[0].length || board[x][y] != word[k]){
            return false;
        }
        // 匹配完所以字符
        if(k==word.length-1){
            return true;
        }
        // 更改二维数组值 置空
        board[x][y] = '\0';
        boolean res = dfsIsExist(board,word,x+1,y,k+1) ||
                dfsIsExist(board,word,x-1,y,k+1) ||
                dfsIsExist(board,word,x,y+1,k+1) ||
                dfsIsExist(board,word,x,y-1,k+1);
        // 更改回二维数组原值
        board[x][y] = word[k];
        return res;
    }
}
