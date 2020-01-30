package cn.wendaocp;

import java.awt.geom.QuadCurve2D;
import java.util.Arrays;

/**
 * @author lq
 * create 2020-01-30 16:07
 */
public class QuickSort {

    public static void main(String[] args) {
        System.out.println("--- quick sort ---");

        int[] nums = new int[]{2,5,2,7,1,9, 0, 11};

        System.out.println(Arrays.toString(nums));

        System.out.println("--- result ---");
        quicksort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));




    }

    /**
     * 使用递归，自己调用自己
     *  勿忘：设置终止条件
     *
     * @param arr
     * @param left
     * @param right
     */
    static void quicksort(int[] arr, int left, int right) {
        if (left >= right) return;

        Integer mid = quicksort0(arr, left, right);

        quicksort(arr, left, mid-1);
        quicksort(arr, mid+1, right);

    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @return base所在的索引
     */
    public static Integer quicksort0(int[] arr, int left, int right) {
        // 进行判断
        if (left > right) return null;

        // 定义变量保存基准数
        int base = arr[left];

        // 定义变量i j，指向最左 右边
        int i = left;
        int j = right;

        // 当ij不相遇
        while (i < j) {
            // 先由j，从右到左，检索比base小的
            while (arr[j] >= base && i<j) {
                j--;
            }
            // 此时，j索引位置的 数值比base小
            arr[i] = arr[j];

            // 左到右 移动i
            while (arr[i] <= base && i<j) {
                i++;
            }
            // 此时，i索引位置 数值比base大
            arr[j] = arr[i];
        }

//        System.out.println("i: "+i+", j: "+j);

        // 此时 i=j
        arr[j] = base;

        return i;
    }


}
