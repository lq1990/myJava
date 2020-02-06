package cn.wendaocp.dp;

/**
 * @author lq
 * create 2020-02-04 13:01
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "abcda";

        String palndrome = longestPalindrome(s);
        System.out.println(palndrome);


    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return s;
        if (s.length() == 1) return s;

        int n = s.length();

        String res = "";
        String res_tmp = "";
        // 遍历s的每个元素，再左右扩展 判断是否是回文。O(n^2)
        for (int i=0; i<n; i++) {
            res_tmp = findPalndrome(s, i);
            if(res_tmp.length() > res.length() ) {
                res = res_tmp;
            }
        }

        return res;
    }


    public static String findPalndrome(String s, int i) {
        String res = s.charAt(i)+"";
        String res_tmp = "";

        // odd. eg. aba
        int ll = i;
        int rr = i;
        while(ll >= 0 && rr <= s.length()-1 ) {
            if(s.charAt(ll) == s.charAt(rr) ) {
                res_tmp = s.substring(ll, rr+1);
//                System.out.println("res_tmp1: "+res_tmp);

                if(res_tmp.length() > res.length() ) {
                    res = res_tmp;
                }
//                System.out.println("res1: "+res);

                ll--;
                rr++;
            } else {
                break;
            }


        }

        // even. eg. abba
        ll = i;
        rr = i+1;
        while(ll >= 0 && rr <= s.length()-1 ) {
            if(s.charAt(ll) == s.charAt(rr)) {
                res_tmp = s.substring(ll, rr+1);
                if(res_tmp.length() > res.length() ) {
                    res = res_tmp;
                }

                ll--;
                rr++;
            } else {
                break;
            }


        }



        return res;
    }


}
