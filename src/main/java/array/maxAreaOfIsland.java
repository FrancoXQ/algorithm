package array;

/**
 * 岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 示例 1:
 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 * @author Franco_Q
 * @date 2019/4/8 16:36
 */
public class maxAreaOfIsland {
    /**
     * 找到矩阵中值为1的点，从这个点开始搜索该点的四个方向是否有值为1的点，找值为1的点后，
     * 再从找到的点开始搜索，直到找到某一个点的四个方向都为0，结束搜索。这个过程经过1的个数就是岛屿的面积。
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 0;i<m;i++) {
            for (int j=0;i<n;j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid,i,j));
                }
            }
        }
        return max;
    }

    /**
     * 深度优化算法
     * @param grid
     * @param i
     * @param j
     * @return
     */
    static int[] dx={-1,0,1,0};
    static int[] dy={0,-1,0,1};
    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int step = 1;
        grid[i][j] = 0;
        int x = 0,y=0;
        for(int k=0;k<4;k++){
            x=i+dx[k];
            y=j+dy[k];
            if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1) {
                step+=dfs(grid,x,y);
            }
        }
        return step;
    }
}
