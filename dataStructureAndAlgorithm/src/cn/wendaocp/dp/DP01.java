package cn.wendaocp.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * dynamic programming
 *
 * arr = [1, 2, 4, 1, 7, 8, 3]
 * 不相邻的数，和最大，返回和
 *
 * @author lq
 * create 2020-01-31 12:00
 */
public class DP01 {

    public static void main(String[] args) {
        int[] arr = {
                4,1,1,9,1
        };
        System.out.println(Arrays.toString(arr));

        long t11 = System.currentTimeMillis();
        int res1 = rec_opt(arr, arr.length-1);
        long t12 = System.currentTimeMillis();
        System.out.println(res1+", rec time: "+(t12-t11));


        long t21 = System.currentTimeMillis();
        int res2 = dp_opt(arr, arr.length-1);
        long t22 = System.currentTimeMillis();
        System.out.println(res2+", dp time: "+(t22-t21));
    }

    /**
     * recursive optimal
     *
     * 使用递归做，会有 重叠子问题，
     * 即重复计算，浪费。
     *
     * @param arr
     * @param i  OPT(i) 到第i时 的最优解
     */
    private static int rec_opt(int[] arr, int i) {
        if (i == 0) {
            return arr[0];
        } else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        } else {

            int sel = rec_opt(arr, i - 2) + arr[i];
            int nosel = rec_opt(arr, i-1);

            return Math.max(sel, nosel);
        }

    }


    /**
     * 非递归方式。
     * 1. 做一个opt数组，n规模
     *
     * 时间辅助度：O(n)
     *
     * @param arr
     * @param i  到第i位置，最优的解
     * @return
     */
    private static int dp_opt(int[] arr, int i) {

        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);

        for (int j=2; j<arr.length; j++) {
            int A = opt[j-2] + arr[j];
            int B = opt[j-1];
            opt[j] = Math.max(A, B);
        }

        return opt[i];

//        // 创建数组
//        ArrayList<Integer> opt = new ArrayList<>();
//        for (int j=0; j<arr.length; j++) {
//            opt.add(null);
//        }
//
//        opt.set(0, arr[0]);
////        opt[0] = arr[0];
//        opt.set(1, Math.max(arr[0], arr[1]));
////        opt[1] = Math.max(arr[0], arr[1]);
//
//        for (int idx=2; idx<arr.length; idx++) {
//
//            int A, B;
//            if (opt.get(idx-2) == null) {
//                opt.set(idx-2, dp_opt(arr, idx-2));
//            }
//            if (opt.get(idx-1) == null) {
//                opt.set(idx-1, dp_opt(arr, idx-1));
//            }
//
//            A = opt.get(idx-2) + arr[idx];
//            B = opt.get(idx-1);
//
//            opt.set(idx, Math.max(A, B));
//        }
//
//        // 到此，opt数组中存储了
//        return opt.get(i);



    }



}
