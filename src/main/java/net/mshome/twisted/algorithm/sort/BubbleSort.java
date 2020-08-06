package net.mshome.twisted.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡算法：
 * <p>
 * 1、取第i个数，和第i+1个数进行比较，如果大于则交换，如果小于等于则不交换
 * 2、指针加1，第i+1个数为第i个数，重复步骤1
 * 3、每一趟下来可保证排序好一个数
 * 4、由于第一趟排好一个数，第二趟排好二个数，所以第i趟只需要比较到第 n-i 个数即可，即倒数第（i+1）个数
 * <p>
 * 冒泡排序是一种稳定的排序算法
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/10/28
 */

public class BubbleSort {

    @Test
    public void test() {
        int[] arr = {1, 3, 7, 6, 9, 0, 2, 4, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private void bubbleSort(int[] arr) {
        boolean isSwapped = false;
        for (int i = arr.length; i > 0; --i) {
            for (int j = 0; j < i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }


}
