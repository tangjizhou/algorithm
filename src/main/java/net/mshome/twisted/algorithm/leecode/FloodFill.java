package net.mshome.twisted.algorithm.leecode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 * 图像渲染
 *
 * @author tangjizhou
 * @since 2021/7/17
 */
public class FloodFill {

    @Test
    public void test() {
        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        floodFill(image, 1, 1, 1);
        for (int[] ints : image) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int originalColor = image[sr][sc];
        int[][] visited = new int[image.length][image[0].length];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                visit(poll, queue, visited, image, originalColor);
                image[poll[0]][poll[1]] = newColor;
                visited[poll[0]][poll[1]] = 1;
            }
        }
        return image;
    }

    private void visit(int[] point, Queue<int[]> queue, int[][] visited, int[][] image, int originalColor) {
        int maxCol = image.length;
        int maxRow = image[0].length;
        int x = point[0], y = point[1];
        if (visited[x][y] == 1) return;


        if (y != 0 && visited[x][y - 1] == 0 && image[x][y - 1] == originalColor) {
            queue.add(new int[]{x, y - 1});
        }
        if (y != maxRow - 1 && visited[x][y + 1] == 0 && image[x][y + 1] == originalColor) {
            queue.add(new int[]{x, y + 1});
        }
        if (x != 0 && visited[x - 1][y] == 0 && image[x - 1][y] == originalColor) {
            queue.add(new int[]{x - 1, y});
        }
        if (x != maxCol - 1 && visited[x + 1][y] == 0 && image[x + 1][y] == originalColor) {
            queue.add(new int[]{x + 1, y});
        }
    }

}
