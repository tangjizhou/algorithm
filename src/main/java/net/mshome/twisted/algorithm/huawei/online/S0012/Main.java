package net.mshome.twisted.algorithm.huawei.online.S0012;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 题目描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * <p>
 * 输入：
 * <p>
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * <p>
 * 坐标之间以;分隔。
 * <p>
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * <p>
 * 下面是一个简单的例子 如：
 * <p>
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * <p>
 * 处理过程：
 * <p>
 * 起点（0,0）
 * <p>
 * +   A10   =  （-10,0）
 * <p>
 * +   S20   =  (-10,-20)
 * <p>
 * +   W10  =  (-10,-10)
 * <p>
 * +   D30  =  (20,-10)
 * <p>
 * +   x    =  无效
 * <p>
 * +   A1A   =  无效
 * <p>
 * +   B10A11   =  无效
 * <p>
 * +  一个空 不影响
 * <p>
 * +   A10  =  (10,-10)
 * <p>
 * <p>
 * <p>
 * 结果 （10， -10）
 * <p>
 * 输入描述:
 * 一行字符串
 * 输出描述:
 * 最终坐标，以,分隔
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/12/6
 */
public class Main {

    private static final Pattern regex = Pattern.compile("[ADWS]{1}[1-9]{1}[0-9]{0,1}");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            Integer[] point = {0, 0};
            String[] parts = input.split(";");
            for (String part : parts) {
                if (part.trim().isEmpty()) {
                    // System.out.println("一个空 不影响");
                    continue;
                }

                if (!regex.matcher(part).matches()) {
                    // System.out.println(part + " = 无效");
                    continue;
                }

                String direction = part.substring(0, 1);
                int step = Integer.parseInt(part.substring(1));
                switch (direction) {
                    case "A":
                        point[0] -= step;
                        break;
                    case "D":
                        point[0] += step;
                        break;
                    case "W":
                        point[1] += step;
                        break;
                    case "S":
                        point[1] -= step;
                        break;
                }

                // System.out.println(part + " = (" + point[0] + "," + point[1] + ")");
            }
            System.out.println(point[0] + "," + point[1]);

        }
    }

}
