package cn.wendaocp.str;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lq
 * create 2020-02-17 11:06
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "abc";

        System.out.println(str.charAt(10));

//        System.out.println(str.length());
//
//        System.out.println(str.charAt(1));
//
//        System.out.println(str.contains("d"));
//
//        System.out.println(str.substring(0,1));
//
//        System.out.println(str.contains("q"));
//
//        Set<Character> set = new HashSet<>();
//        set.add('a');
//        System.out.println(set.size());
//
//        set.remove('a');
//        System.out.println(set);




    }

    public int lengthOfLongestSubstring0(String s) {
        if(null == s) return 0;
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        Set<Character> set = new HashSet<>();

        int res = 1;
        int left = 0;
        int right = 0;

        while(left<s.length() && right < s.length()) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }

        }

        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        if(null == s) return 0;
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        // 2 pointers
        int maxLen = 1;
        int left, right;
        left = 0;
        right = 0;
        String tmpStr = "";
        while(left <= s.length()-1) {

            tmpStr = s.substring(left, left+1);
            right = left+1;
            while(right <= s.length()-1) {
                if(!tmpStr.contains(String.valueOf(s.charAt(right)))) {
                    tmpStr = s.substring(left, right+1);
                    right++;
                    maxLen = Math.max(maxLen, tmpStr.length());
                } else {
                    break;
                }
            }

            left++;
        }

        return maxLen;
    }

}
