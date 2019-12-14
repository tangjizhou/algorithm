package net.mshome.twisted.algorithm.huawei.online.S0011;

import java.util.Scanner;

/**
 * 题目描述
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 * 设第 currentPrice 件物品的价格为 v[currentPrice] ，重要度为 w[currentPrice] ，共选中了 k 件物品，编号依次为 currentPrice 1 ， currentPrice 2 ，……， currentPrice k ，则所求的总和为：
 * v[currentPrice 1 ]*w[currentPrice 1 ]+v[currentPrice 2 ]*w[currentPrice 2 ]+ … +v[currentPrice k ]*w[currentPrice k ] 。（其中 * 为乘号）
 * 请你帮助王强设计一个满足要求的购物单。
 * <p>
 * <p>
 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * <p>
 * 从第 2 行到第 m+1 行，第 currentPrice 行给出了编号为 currentPrice-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * <p>
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * <p>
 * <p>
 * 输出描述:
 * 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 * 示例1
 * 输入
 * <p>
 * 复制
 * 1000 5 800 2 0 400 5 1 300 5 1 400 3 0 500 2 0
 * 输出
 * <p>
 * 复制
 * 2200
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/6
 */
public class Main {
    // todo 带限制条件带背包问题，没有撸出来。。

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int totalPrice = Integer.parseInt(line.split(" ")[0]); // 总钱数
        int goodsNumber = Integer.parseInt(line.split(" ")[1]); // 总个数

        int[] price = new int[goodsNumber]; // 价格
        int[] value = new int[goodsNumber]; // 价值
        int[] main = new int[goodsNumber]; // 主附

        for (int currentGoods = 0; currentGoods < goodsNumber; currentGoods++) {
            line = scanner.nextLine();
            String[] values = line.split(" ");
            price[currentGoods] = Integer.parseInt(values[0]);
            value[currentGoods] = Integer.parseInt(values[1]);
            main[currentGoods] = Integer.parseInt(values[2]);
        }


        // dp[0][0...n-1] 为0表示最小价值
        int[][] dp = new int[goodsNumber + 1][totalPrice + 1];


        int[][] selected = new int[totalPrice + 1][goodsNumber + 1];
        for (int currentGoods = 1; currentGoods <= goodsNumber; currentGoods++) { // 对于第i件物品，取或者不取
            int numberIndex = currentGoods - 1;
            for (int currentPrice = 1; currentPrice <= totalPrice; currentPrice++) {

                int currentMax = dp[currentGoods - 1][currentPrice]; // 当前最大价值
                dp[currentGoods][currentPrice] = dp[currentGoods - 1][currentPrice];

                if (main[numberIndex] == 0) { // 主
                    if (price[numberIndex] <= currentPrice) {
                        int ifSelectedValue = dp[currentGoods - 1][currentPrice - price[numberIndex]] + value[numberIndex];
                        if (ifSelectedValue > currentMax) {
                            // 将前面的选择放入当前价格的最佳选择中
                            System.arraycopy(selected[currentPrice - price[numberIndex]], 0, selected[currentPrice], 0, currentGoods);
                            selected[currentPrice][currentGoods] = 1;
                        } else {
                            selected[currentPrice][currentGoods] = 0;
                        }
                        dp[currentGoods][currentPrice] = Math.max(currentMax, ifSelectedValue);
                    } else {
                        selected[currentPrice][currentGoods] = 0;
                    }
                    continue;

                }

                int mainNo = main[numberIndex];

                // 附件，需要购买主件
                if (main[numberIndex] > 0) {
                    // 如果已经买了主件,直接买当前附件，和主件一样
                    if (selected[currentPrice][mainNo] != 0) {
                        if (price[numberIndex] <= currentPrice) {
                            int ifSelectedValue = dp[currentGoods - 1][currentPrice - price[numberIndex]] + value[numberIndex];
                            if (ifSelectedValue > currentMax) {
                                // 将前面的选择放入当前价格的最佳选择中
                                System.arraycopy(selected[currentPrice - price[numberIndex]], 0, selected[currentPrice], 0, currentGoods);
                                selected[currentPrice][currentGoods] = 1;
                            } else {
                                selected[currentPrice][currentGoods] = 0;
                            }
                            dp[currentGoods][currentPrice] = Math.max(currentMax, ifSelectedValue);
                        }
                    } else {
                        // 没有买主件，则都需要买
                        if (price[numberIndex] + price[mainNo] <= currentPrice) {
                            int ifSelectedValue = dp[currentGoods - 1][currentPrice - price[numberIndex] - price[mainNo]] + value[numberIndex] + value[mainNo - 1];
                            if (currentMax < ifSelectedValue) { // 如果选了更大
                                dp[currentGoods][currentPrice] = ifSelectedValue;
                                // selected[numberIndex] = 1;
                                // selected[mainNo] = 1;
                            } else { // 否则这么多钱的最大价值还是不选的时候的价值
                                dp[currentGoods][currentPrice] = currentMax;
                            }
                        }


                    }
                }


            }

        }
        System.out.println(dp[goodsNumber][totalPrice]);
        print(dp);
        System.out.println("-------");
        print(selected);


    }

    private static void print(int[][] dp) {
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }


    }

}
