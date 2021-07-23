package offer;

public class Offer13 {
    public static void main(String[] args) {
        System.out.println(movingCount(3,1,0));
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return move(m,n,k,0,0,visited);
    }

    public static int move(int m, int n, int k ,int x, int y, boolean visited[][]){
        if(x<0 || x>m-1 || y<0 || y>n-1 || visited[x][y] || (x%10 + x/10 + y%10 + y/10 > k)){
            return 0;
        }
        visited[x][y] = true;
        return move(m,n,k,x+1,y,visited)+move(m,n,k,x,y+1,visited)+1;
    }
}
