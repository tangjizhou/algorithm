package net.mshome.twisted.algorithm.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/rotting-oranges/
 * 腐烂的橘子
 *
 * @author tangjizhou
 * @since 2021/7/21
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        int totalOrange = 0;
        final int maxRow = grid.length;
        final int maxCol = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == 1) ++totalOrange;
                if (grid[row][col] == 2) queue.add(new int[]{row, col});
            }
        }
        if (totalOrange == 0) {
            return 0;
        }
        int duration = 0;
        int[] xMove = {1, -1, 0, 0};
        int[] yMove = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final int[] point = queue.poll();
                for (int direction = 0; direction < 4; direction++) {
                    final int x = point[0] + xMove[direction];
                    final int y = point[1] + yMove[direction];
                    if (x >= 0 && x < maxRow && y >= 0 && y < maxCol && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        --totalOrange;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            ++duration;
            if (totalOrange == 0) return duration;
        }
        return -1;
    }

}