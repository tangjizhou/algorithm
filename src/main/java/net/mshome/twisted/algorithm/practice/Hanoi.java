package net.mshome.twisted.algorithm.practice;

import org.junit.Test;

/**
 * 汉诺塔问题
 *
 * <pre>
 *       |          |       |
 *      -|-         |       |
 *     --|--        |       |
 *    ---|---       |       |
 *   ----|----      |       |
 * -------------    |       |
 * </pre>
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2020/1/13
 */
public class Hanoi {

    @Test
    public void hanoi() {
        move1(1024, "left", "middle", "right");

    }


    public void move1(int n, String left, String middle, String right) {
        if (n == 1) {
            System.out.println(left + "-->" + right);
            return;
        }

        move1(n - 1, left, right, middle);
        System.out.println(left + "-->" + right);
        move1(n - 1, middle, left, right);

    }

    public void move2(int n, String left, String middle, String right) {
        if (n == 1) {
            System.out.println(left + "-->" + right);
            return;
        }

        move2(n - 1, left, right, middle);
        System.out.println(left + "-->" + right);
        move2(n - 1, middle, left, right);

    }


}
