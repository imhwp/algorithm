package leetcode.深度优先搜索.机器人运动范围;

class Solution {
    int k,m,n;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        this.m=m;
        this.n=n;
        this.k=k;
        return recur(0,0);

    }

    public int recur(int i,int j){
        if(i>=m || j>=n || visited[i][j] || bitSum(i)+bitSum(j)>k) return 0;
        visited[i][j]=true;
        return 1+recur(i+1,j)+recur(i,j+1);
    }

    public int bitSum(int i){
        int res = 0;
        while(i!=0){
            res+=(i%10);
            i/=10;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
    }
}