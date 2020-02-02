package cn.wendaocp.dp;

import javafx.scene.input.TouchEvent;
import org.omg.CORBA.INTERNAL;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashMap;

/**
 * dp
 * @author lq
 * create 2020-02-01 13:28
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {2,5};
        int amount = 20;

        int res = new Solution().coinChange(coins, amount);
        System.out.println(res);
    }

}

class Solution {

    private int MAX_VAL = Integer.MAX_VALUE/2;

    public int coinChange0(int[] coins, int amount) {
        // 构建一维数组
        HashMap<Integer, Integer> fun = new HashMap<>(); // key: 目前金额， value：数量
        // init
        fun.put(0, 0);

        int tmp;
        // calc
        for (int am=1; am<=amount; am++) {

            int tmp_min = MAX_VAL;
            // 遍历每个coins
            for (int j=0; j<coins.length; j++) {

                if (am < coins[j]) continue;

                Integer g = fun.get(am - coins[j]);

                tmp = g == null ? MAX_VAL : g;
                tmp_min = Math.min(tmp + 1, tmp_min);

            }
            fun.put(am, tmp_min);

        }

//        System.out.println("遍历fun： ");
//        for (int k : fun.keySet()) {
//            System.out.println(k+" : "+fun.get(k));
//        }
//        System.out.println("---");


        int res = fun.get(amount);
        if (res == MAX_VAL) return -1;
        return (int) res;
    }

    /**
     *
     * @param A coins
     * @param M 金钱数额
     * @return
     */
    public int coinChange(int[] A, int M) {
        int[] f = new int[M+1];
        int n = A.length;

        // init
        f[0] = 0;

        int i,j;
        for (i=1; i<=M; ++i) {
            f[i] = Integer.MAX_VALUE;

            for (j=0; j<n; ++j) {
                if (i>=A[j] && f[i-A[j]] != Integer.MAX_VALUE) { // i>=A[j] 使得只对f的index为正数时
                    f[i] = Math.min(f[i-A[j]]+1, f[i]);
                }
            }
        }

        System.out.println("---");
        for (int i1 : f) {
            System.out.println(i1);
        }
        System.out.println("---");

        if (f[M] == Integer.MAX_VALUE) {
            f[M] = -1;
        }

        return f[M];

    }

}













