package net.mshome.twisted.algorithm.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/01-matrix/
 * 01 矩阵
 *
 * @author tangjizhou
 * @since 2021/7/20
 */
public class Matrix01 {




    public int[][] updateMatrix(int[][] mat) {
        final int maxRow = mat.length;
        final int maxCol = mat[0].length;
        int[][] matrix = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                matrix[row][col] = minMatrix(mat, row, col);
            }
        }
        return matrix;
    }

    private int minMatrix(int[][] mat, int row, int col) {
        if (mat[row][col] == 0) return 0;
        int[] xMove = {1, -1, 0, 0};
        int[] yMove = {0, 0, -1, 1};
        int[][] walked = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        int step = 0;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                final int[] point = queue.poll();
                walked[point[0]][point[1]] = 1;
                if (mat[point[0]][point[1]] == 0) return step;
                for (int j = 0; j < 4; j++) {
                    final int newX = point[0] + xMove[j];
                    final int newY = point[1] + yMove[j];
                    if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length && walked[newX][newY] == 0) {
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            ++step;
        }
        return step;
    }

}
