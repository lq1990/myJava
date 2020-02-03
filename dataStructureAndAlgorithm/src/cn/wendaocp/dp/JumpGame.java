package cn.wendaocp.dp;

import java.util.Arrays;

/**
 * @author lq
 * create 2020-02-02 13:27
 */
public class JumpGame {

    public static void main(String[] args) {

        int[] nums = {2,0};

        boolean res = new JumpGame().canJump(nums);
        System.out.println(res);

    }

    /**
     * 二维数组
     * @param nums
     * @return
     */
    public boolean canJump0(int[] nums) {

        if (nums.length==0 || nums[0]<=0) return false;

        // 1. 构建二维数组 arr(cur,target)=true|false   从cur步到target步 是否可以到
        boolean[][] arr = new boolean[nums.length-1][nums.length];

        // init
//        for (int i=0; i<nums[0]; ++i) {
//            arr[0][i] = true;
//        }

        // calc
        for (int row=0; row<nums.length-1; row++) {
            for (int col=row; col<nums.length; col++) {

                if (row==0 && col<=nums[0]) {
                    arr[row][col] = true; // init
                    arr[col][col] = true;

                } else {
                    for (int i=row; i<=nums[row]; i++) {
                        arr[row][i] = true;
                        arr[i][i] = true;
                    }

                }

            }
        }


        // look inside
        for (int i=0; i<nums.length-1;i++) {
            for (int j=0; j<nums.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        return false;
    }


    /**
     * 一维数组
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {

        if (nums.length == 0 ) return false;
        if (nums.length == 1) return true;

        // create arr
        boolean[] arr = new boolean[nums.length];

        // init
        for (int i=0; i<=nums[0]; i++) {
            if (i<nums.length) {
                arr[i] = true;
            }
        }

        // calc
        for (int i=1; i<nums.length; i++) {
            if (arr[i]) {
                // 当此步可到达时
                int val = nums[i];
//                System.out.println("val: "+val);
                if (val > nums.length - i) {
                    val = nums.length - i;
                }

                for (int j=val; j>=1; j--) {
                    if (i+j < nums.length-1) {
                        arr[i+j] = true;
                    }
                    if (i+j == nums.length-1)
                        return true;

                }

            }
        }

//        System.out.println(Arrays.toString(arr));


        return arr[nums.length-1];
    }

    public boolean canJump(int[] A) {
        int n = A.length;
        boolean[] f = new boolean[n];

        f[0] = true; // init

        for (int j=1; j<n; ++j) {
            f[j] = false;

            // prev stone i
            // last jump is from i to j
            for (int i=0; i<j; ++i) {
                if (f[i] && i+A[i] >=j ) {
                    f[j] = true;
                    break;
                }
            }
        }

        return f[n-1];
    }

}

















