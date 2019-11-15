package net.mshome.twisted.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡算法
 *
 * @author tangjizhouchn@foxmail.com
 * @date 2019/10/28
 */

public class Bubble {

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 6, 9, 0, 2, 4, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private static void bubbleSort(int[] arr) {
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
