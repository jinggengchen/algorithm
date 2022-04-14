package LeetCode.回溯;

public class LC_695_岛屿的最大面积 {
    public static void main(String[] args) {
//        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int[][] grid = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int area = 0;
        int cur = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    cur = dfs(grid, i, j);
                    area = Math.max(cur, area);
                }
            }
        }
        return area;

    }
    public static int dfs (int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            int num = 1;
            num += dfs(grid, i + 1, j);
            num += dfs(grid, i - 1 , j);
            num += dfs(grid, i , j - 1);
            num += dfs(grid, i , j + 1);
            return num;
        }
        return 0;
    }
}
