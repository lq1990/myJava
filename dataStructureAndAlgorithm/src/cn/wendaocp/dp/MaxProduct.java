package cn.wendaocp.dp;

/**
 * @author lq
 * create 2020-02-02 19:51
 */
public class MaxProduct {

    public static void main(String[] args) {

        int[] nums = {2,-1,1,1};
        int res = new MaxProduct().maxProduct(nums);
        System.out.println("max: "+res);

    }


    public int maxProduct(int[] nums) {

        if (nums.length==0) {
            return -1;
        }
        if (nums.length == 1) return nums[0];

        // 因为有正负数，构建数组
        int[][] arr = new int[nums.length][2];

        // init
        arr[0][0] = nums[0]; // min
        arr[0][1] = nums[0]; // max

        int res = arr[0][1];

        //
        for (int i=1; i<nums.length; i++) {
            // init
            arr[i][0] = nums[i]; // min
            arr[i][1] = nums[i]; // max

            int a = arr[i-1][0]*nums[i];
            int b = arr[i-1][1]*nums[i];
//            System.out.println("a: "+a);
//            System.out.println("b: "+b);

            arr[i][0] = Math.min(nums[i], a);
            arr[i][0] = Math.min(arr[i][0], b);

            arr[i][1] = Math.max(nums[i], a);
            arr[i][1] = Math.max(arr[i][1], b);


            res = Math.max(res, arr[i][1]);
        }





        // look arr
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<2; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        return res;
    }


}
