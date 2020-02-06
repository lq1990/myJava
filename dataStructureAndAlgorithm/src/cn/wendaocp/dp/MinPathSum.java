package cn.wendaocp.dp;

/**
 * @author lq
 * create 2020-02-03 12:50
 */
public class MinPathSum {

    public static void main(String[] args) {
        String s = "abc";
        

        System.out.println(MinPathSum.class);

        int m = 3;
        int n = 3;
        int[][] grid = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("---");
        int res = new MinPathSum().minPathSum(grid);
        System.out.println(res);


    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m==0 || n==0) return 0;

        // 2-dim arr
        int[][] f = new int[m][n];

        // init
        f[0][0] = grid[0][0];
        for (int i=1; i<m; i++) {
            f[i][0] = grid[i][0] + f[i-1][0];
        }
        for (int j=1; j<n; j++) {
            f[0][j] = grid[0][j] + f[0][j-1];
        }

        // calc
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                f[i][j] = Math.min(f[i-1][j]+grid[i][j], f[i][j-1]+grid[i][j]);
            }
        }


        // lood f
        System.out.println("f: ");
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(f[i][j]+" ");
            }
            System.out.println();
        }


        return f[m-1][n-1];
    }



}
