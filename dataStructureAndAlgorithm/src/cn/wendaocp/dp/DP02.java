package cn.wendaocp.dp;

import sun.util.locale.StringTokenIterator;

import javax.swing.text.StyledEditorKit;
import java.util.Arrays;

/**
 *
 * arr = {3, 34, 4, 12, 5, 2}  元素都是正整数
 *
 * S = 9;
 *
 * 当arr中有数相加=S 时，则返回true
 *
 * @author lq
 * create 2020-01-31 13:17
 */
public class DP02 {

    public static void main(String[] args) {
        int[] arr = {
                3, 34, 4, 12, 5, 2,
                3, 34, 4, 12, 5, 2,
                3, 34, 4, 12, 5, 2,
                3, 34, 4, 12, 5, 2
        };
        int S = 90;
        System.out.println(Arrays.toString(arr));

        System.out.println("time: "+System.currentTimeMillis());
        boolean res = rec_subset(arr, arr.length - 1, S);
        System.out.println("time: "+System.currentTimeMillis());
        System.out.println(res);

        System.out.println("----------");

        boolean res2 = dp_subset(arr, S);
        System.out.println("time: "+System.currentTimeMillis());
        System.out.println(res2);


    }

    /**
     *
     * @param arr
     * @param i arr的前i个数字
     * @param s
     */
    private static boolean rec_subset(int[] arr, int i, int s) {
        // 先写出口条件
        if (s==0) {
            return true;
        } else if (i==0) {
            return arr[0] == s;
        } else if (arr[i] > s) {
            return rec_subset(arr, i-1, s);
        } else {

            // sel
            boolean A = rec_subset(arr, i-1, s-arr[i]);
            // not sel
            boolean B = rec_subset(arr, i-1, s);

            return A || B;
        }

    }

    /**
     * 不用递归。
     *
     * 创建 二维数组，
     * row: i
     * col: s
     *
     * @param arr
     * @param S
     * @return
     */
    private static boolean dp_subset(int[] arr, int S) {
        // 构建二维数组
        boolean[][] subset = new boolean[arr.length][S+1]; // 默认值false
        for (int row=0; row<arr.length; row++) {
            subset[row][0] = true;
        }
        subset[0][arr[0]] = true;


//        for (int row=0; row<arr.length; row++) {
//            for (int col=0; col<s+1; col++) {
//                System.out.print(subset[row][col]+" ");
//            }
//            System.out.println();
//        }

        for (int i=1; i<arr.length; i++) {
            for (int s=1; s<S+1; s++ ) {
                if (arr[i] > s) {
                    subset[i][s] = subset[i-1][s];
                } else {
                    boolean A = subset[i-1][s - arr[i]];
                    boolean B = subset[i-1][s];
                    subset[i][s] = A || B;
                }

            }
        }

//        for (int row=0; row<arr.length; row++) {
//            for (int col=0; col<S+1; col++) {
//                System.out.print(subset[row][col]+" ");
//            }
//            System.out.println();
//        }

        return subset[arr.length-1][S]; // 返回二维数组中 右下角位置数
    }

}
