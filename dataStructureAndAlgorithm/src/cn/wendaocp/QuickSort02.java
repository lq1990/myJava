package cn.wendaocp;

import java.util.Arrays;

/**
 * @author lq
 * create 2020-01-30 17:16
 */
public class QuickSort02 {

    public static void main(String[] args) {
        char arr[] = {'a', 'n', 'a' , 'g', 'r', 'a', 'm'};
        System.out.println(Arrays.toString(arr));

        System.out.println("------");
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(char[] arr, int left, int right) {
        if (left >= right) return;

        int mid = quickSort0(arr, left, right);

        quickSort(arr, left, mid -1);
        quickSort(arr, mid+1, right);

    }

    private static int quickSort0(char[] arr, int left, int right) {
        if (left >= right) return -1;

        int i = left;
        int j = right;
        char base = arr[left];

        while (i<j) {
            while (i<j && arr[j] >= base) {
                j--;
            }
            arr[i] = arr[j];


            while (i<j && arr[i] <= base) {
                i++;
            }
            arr[j] = arr[i];
        }

        // i=j
        arr[i] = base;

        return i;
    }


}
