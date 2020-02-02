package cn.wendaocp.dp;

/**
 * @author lq
 * create 2020-02-01 19:03
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(UniquePaths.class);

        int m = 70;
        int n = 30;

        System.out.println(System.currentTimeMillis());
        int res = new UniquePaths().uniquePaths(m, n);
        System.out.println(System.currentTimeMillis());
        System.out.println(res);

    }


    public int uniquePaths(int m, int n) {

        if (m<=0 || n<=0) return -1;

        // 1. 构建二维数组
        int[][] arr = new int[m][n];

        // init & boundary cond
        // arr[0,0]=1, arr[:,-1]=0, arr[-1,:]=0
        for (int i=0; i<m; i++) {
            arr[i][0] = 1;
        }
        for (int j=0; j<n; j++) {
            arr[0][j] = 1;
        }

        // calc
        for (int row=1; row<m; row++) {
            for (int col=1; col<n; col++) {

                arr[row][col] = arr[row-1][col] + arr[row][col-1];

            }
        }


        return arr[m-1][n-1];
    }

}

