package net.mshome.twisted.algorithm.huawei.online;

import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * 输出描述:
 * 输出合并后的键值对（多行）
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/4/12
 */
public class MergeRecordsByIndex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = Integer.parseInt(scanner.nextLine());
            String indexValue = "";
            TreeMap<Integer, Long> treeMap = new TreeMap<>();

            for (int i = 0; i < number; i++) {
                indexValue = scanner.nextLine();
                String[] parts = indexValue.split("\\s+");
                int key = Integer.parseInt(parts[0]);
                long currentValue = Integer.parseInt(parts[1]);
                long value = Optional.ofNullable(treeMap.get(key)).map(v -> v + currentValue).orElse(currentValue);
                treeMap.put(key, value);
            }

            treeMap.keySet().forEach(k -> {
                System.out.print(k);
                System.out.print(" ");
                System.out.println(treeMap.get(k));
            });
        }
    }


}
