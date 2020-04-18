package net.mshome.twisted.algorithm.huawei.online;

import java.util.*;

/**
 * 题目描述
 * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，
 * 本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
 * 详细说明：
 * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，友情提醒，整数除法要当心；
 * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
 * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 4.输出的算式格式为4张牌通过+ - * /
 * 四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
 * 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24
 * 6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
 * <p>
 * 输入描述:
 * 输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
 * 输出描述:
 * 如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 示例1
 * 输入
 * <p>
 * 复制
 * A A A A
 * 输出
 * <p>
 * 复制
 * NONE
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/4/12
 */
public class CalcTo24Point {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] operators = new int[]{1, 2, 3, 4}; // + - x /
        // while (scanner.hasNext()) {
        // String input = scanner.nextLine();
        int[] factors = new int[]{1, 2, 3, 4};
        int[] currentOps = new int[]{1, 1, 1}; // 先用加法
        int[] result = new int[4];
        result[0] = factors[0]; // result[0] = a

        for (int j = 1; j < 4; j++) {
            int factor1 = result[j - 1];
            if (factor1 == -9999) {
                continue;
            }
            int factor2 = factors[j];

            // result[j + 1] = calc(factor1, factor2, operator);

            for (int i = 0; i < 4; i++) {
                int operator = operators[i];
                if (i == 3 && factor1 % factor2 != 0) {
                    result[j + 1] = -9999;
                    continue;
                }
            }


            System.out.println(Arrays.toString(result));
        }
        // }
    }

    public static int calc(int f1, int f2, int op) {
        switch (op) {
            case 1:
                return f1 + f2;
            case 2:
                return f1 - f2;
            case 3:
                return f1 * f2;
            case 4:
                return f1 % f2 == 0 ? f1 / f2 : -9999;
            default:
                return -9999;
        }
    }

}
