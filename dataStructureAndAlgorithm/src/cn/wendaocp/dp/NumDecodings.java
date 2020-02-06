package cn.wendaocp.dp;

import com.sun.media.sound.SoftTuning;

/**
 * @author lq
 * create 2020-02-05 17:21
 */
public class NumDecodings {
    public static void main(String[] args) {

        System.out.println(NumDecodings.class);

        String s = "120";

        int res = new NumDecodings().numDecodings(s);
        System.out.println(res);


        int val = 200;
        System.out.println(val % 10);


    }

    /**
     * do not work
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        if(s.length() == 0) return 0;
        if(s.length() == 1 && Integer.parseInt(s) > 0) return 1;
        if(Integer.parseInt(s) < 1) {
            return 0;
        }

        // f(n) = f(n-1) + f(n-2), if 11 <= s[-2] <= 26
        // f(n) = f(n-2)  , else if s[-1] == 0
        // f(n) = f(n-1)  , else

        // create 1-dim f10 >= s[-2]
        int[] f = new int[s.length()];

        // init
        f[0] = 1;
        int tmp = Integer.parseInt(s.substring(0,2));
        if (tmp <= 26 && tmp != 10) {
            f[1] = 2;
        } else {
            f[1] = 1;
        }

        // calc
        for(int i=2; i<s.length(); i++) {
            tmp = Integer.parseInt(s.substring(i-1,i+1));
            if( tmp >= 11 && tmp <= 26 && tmp != 20) {
                f[i] = f[i-1] + f[i-2];
                System.out.println("pos 1");
            } else if(Integer.parseInt(s.substring(i,i+1)) == 0) {
                f[i] = f[i-2];
                System.out.println("pos 2");
            }
            else {
                f[i] = f[i-1];
                System.out.println("pos 3");
            }
        }

        return f[s.length()-1];
    }

}
