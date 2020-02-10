package cn.wendaocp.dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lq
 * create 2020-02-09 19:07
 */
public class MinimumTotal {

    public static void main(String[] args) {
        System.out.println(MinimumTotal.class);

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> line0 = new ArrayList<>();
        List<Integer> line1 = new ArrayList<>();
        List<Integer> line2 = new ArrayList<>();
        List<Integer> line3 = new ArrayList<>();

        line0.add(2);
        line1.add(3); line1.add(4);
        line2.add(6); line2.add(5); line2.add(7);
        line3.add(4); line3.add(1); line3.add(8); line3.add(3);

        triangle.add(line0);
        triangle.add(line1);
        triangle.add(line2);
        triangle.add(line3);

        int res = new MinimumTotal().minimumTotal(triangle);
        System.out.println(res);


    }

    public int minimumTotal(List<List<Integer>> triangle) {
        // 确定状态
        // 最优解最后一步  arr(n,i).   0<i<n-1
        // 子问题：倒数第二层 arr(n-1, i-1) or arr(n-1, i)
        // 转移方程    f(n,i) = min{ f(n-1,i-1)+arr[n][i] , f(n-1, i) + arr[n][i] },  0<i<n-1，   return 第n层第i个位置处 sum
        // f(n,i) = f(n-1,i)+arr[n][i], if i=0 || i = n-1
        // 初始、边界条件. f(0,0) = arr[0][0], 注意边界条件
        // 计算顺序

        // create f[n][n]
        if (triangle == null || triangle.size() == 0) return -1;

        int height = triangle.size();
        int[][] f = new int[height][height];

        // init
        f[0][0] = triangle.get(0).get(0);

        // calc
        for (int n=1; n<height; n++) {
            for (int i=0; i<=n; i++) {
//                System.out.println(n+", "+i);

                if (i>0 && i<n) {
                    int A = f[n-1][i-1]+triangle.get(n).get(i);
                    int B = f[n-1][i]+triangle.get(n).get(i);
                    f[n][i] = Math.min(A, B);
                }
                if (i==0) {
                    f[n][i] = f[n-1][i]+triangle.get(n).get(i);
                }
                if(i==n) {
                    f[n][i] = f[n-1][i-1]+triangle.get(n).get(i);
                }

            }
        }

        // get last line of f
        int res = Integer.MAX_VALUE;
        for (int j=0; j<height; j++) {
//            System.out.println("elem: "+f[height-1][j]);
            int elem = f[height-1][j];
            if (res > elem) {
                res = elem;
            }
        }


        // look f
        for (int i=0; i<height; i++) {
            for (int j=0; j<height; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }


        return res;
    }

}
