package net.mshome.twisted.algorithm.leecode;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 搜索二维矩阵
 *
 * @author tangjizhou
 * @since 2021/9/18
 */
public class SearchA2dMatrix {

    @Test
    public void test() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
                {70, 80, 90, 100}
        };
        Assert.assertFalse(searchMatrix1(matrix, 99));
        Assert.assertTrue(searchMatrix1(matrix, 80));
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = searchRow(matrix, target);
        if (row == -1) {
            return false;
        }
        return searchCol(matrix[row], target) != -1;
    }

    // 查询最后一个不大于目标值的行
    private int searchRow(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        int maxCol = matrix[0].length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (matrix[middle][0] == target) return middle;
            if (matrix[middle][0] < target) {
                if (matrix[middle][maxCol] >= target) return middle;
                else start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    private int searchCol(int[] row, int target) {
        int start = 0, end = row.length - 1;
        while (start <= end) {
            int middle = start + ((end - start) >> 1);
            if (row[middle] == target) {
                return middle;
            } else if (row[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int row = middle / n;
            int col = middle % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        int[] row = {1};
        Assert.assertEquals(-1, searchFirstGtTarget(row, 9));
    }

    public int searchFirstGtTarget(int[] row, int target) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (row[m] == target) {
                return m;
            } else if (row[m] < target) {
                l = m + 1;
            } else {
                if (row[m - 1] < target) return m;
                else r = m - 1;
            }
        }
        return -1;
    }

}
