package net.mshome.twisted.algorithm.leecode;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 * 岛屿的最大面积
 *
 * @author tangjizhou
 * @since 2021/7/18
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        final int row = grid.length;
        final int col = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, calc(grid, i, j, 0));
            }
        }
        return max;
    }

    private int calc(int[][] grid, int row, int col, int max) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol || grid[row][col] != 1) return max;
        int[] xMove = {1, -1, 0, 0};
        int[] yMove = {0, 0, -1, 1};
        ++max;
        grid[row][col] = 2;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, calc(grid, row + xMove[i], col + yMove[i], max));
        }
        return max;
    }

}
