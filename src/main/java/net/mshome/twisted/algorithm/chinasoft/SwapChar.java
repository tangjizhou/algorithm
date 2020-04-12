package net.mshome.twisted.algorithm.chinasoft;

import java.util.Objects;

/**
 * 字符串s1,s2长度相等，内容只包含字符x，y，不包含其他字符，每次互相交换一个字符，
 * 求使得两个字符串相等的最小交换次数，如果无法使两个字符串相等，则返回-1
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2020/4/9
 */
public class SwapChar {

    public static void main(String[] args) {
        System.out.println(minSwap("xyxy", "yxyx"));
    }


    public static int minSwap(String s1, String s2) {
        // 长度不相等则肯定不可能相等
        if (Objects.isNull(s1) || Objects.isNull(s2) || s1.length() != s2.length()) {
            return -1;
        }

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        // s1,s2的字符对，一个取自s1Arr，一个取自s2Arr，计算相同位置有差异对字母对
        int xyPair = 0, yxPair = 0;
        for (int i = 0, length = s1Arr.length; i < length; ++i) {
            if (s1Arr[i] == s2Arr[i]) {
                continue;
            }
            if (s1Arr[i] == 'x') {
                ++xyPair;
            } else {
                ++yxPair;
            }
        }

        // 交换时，相同的对则互相交换，两两抵消。最后如果剩下一个xy或者yx对，则无法相等
        if ((xyPair + yxPair) % 2 != 0) {
            return -1;
        }
        // 如下情况有2个xy对，则互相交换一下1/4或者交换2/3，就相等了。需要交换一次。所以次数为 xyPair/2，yx情况同理可得。
        // x   x
        // y   y

        // xy 和 yx 这一种情况需要交换2次才会相等
        // 两两抵消之后，发现最后要么一个都没剩下，要么剩下xy和yx这一种情况。剩下这种情况对可能性则只可能是xy，yx字母对都是奇数
        int afterSwappedLeftPairCount = xyPair % 2 == 0 ? 0 : 1;
        return xyPair / 2 + yxPair / 2 + afterSwappedLeftPairCount * 2;
    }


}
