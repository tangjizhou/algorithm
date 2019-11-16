package net.mshome.twisted.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 插入排序：
 * 当前数，依次和前面第进行比较，如果更小，则将前面第数字后挪一位，即表示让出位置
 * 继续和空位前面第数字进行比较，和步骤一类似，直到空位前面第数字更小，则此空位可插入当前数字
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/11/15
 */
public class InsertSort {

    @Test
    public void test() {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 1, 4, 6, 9, 22, 45, 65, 87};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 直接插入排序，每一个元素都进行比较
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            int pre = i - 1;
            while (pre >= 0 && current < arr[pre]) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = current;
        }
    }

    // 折半插入排序
    public void bInsertSort(int[] arr) {

    }

}
