package cn.wendaocp;

/**
 * @author lq
 * create 2020-01-30 14:03
 */
public class IsAnagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        boolean res = isAnagram(s, t);
        System.out.println(res);
    }

    public static boolean isAnagram(String s, String t) {
        // 对两者进行排序

        if (s.length() != t.length()) return false;

        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();

        quickSort(chars_s, 0, s.length()-1);
        quickSort(chars_t, 0, t.length()-1);

        for (int i=0; i<chars_s.length; i++) {
            if (chars_s[i] != chars_t[i]) return false;
        }

        return true;
    }



    private static void quickSort(char[] arr, int left, int right) {
        if (left >= right) return;

        int mid = quickSort0(arr, left, right);

        quickSort(arr, left, mid-1);
        quickSort(arr, mid+1, right);

    }

    private static int quickSort0(char[] arr, int left, int right) {
        if (left >= right) return -1;

        int i=left;
        int j=right;
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

        arr[i] = base;

        return i;
    }

}
