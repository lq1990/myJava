package cn.wendaocp.dp;

/**
 * @author lq
 * create 2020-02-05 13:54
 */
public class MaxProfit {

    public static void main(String[] args) {
        System.out.println(MaxProfit.class);

        int[] prices = {3,2,1};

        int res = new MaxProfit().maxProfit(prices);
        System.out.println(res);
    }


    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0 || len == 1) return 0;

        int j = 0;
        int cur = 0;
        int delta = 0;
        while (cur <= prices.length-1) {
            // cur是当前的基准
            System.out.println("cur: "+cur);

            for (j = cur; j<len; j++) {
                if (prices[j] < prices[cur]) {
                    break; // 剪枝

                } else {
                    int delta_tmp = prices[j] - prices[cur];
                    if (delta_tmp > delta) {
                        System.out.println(cur + " --- "+j);
                        delta = delta_tmp;
                    }

                }
            }
            cur++;
        }

        return delta;
    }

    /**
     * 错误
     * i++, j++
     * i<j && prices[i] < prices[j]
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        // find min,max
        int minVal = Integer.MAX_VALUE;
        int minIdx = 0;
        int maxVal = 0;
        int maxIdx = 0;

        for (int ii=0; ii<prices.length-1; ii++) {
            int tmp = prices[ii];
            if (tmp < minVal) {
                minVal = tmp;
                minIdx = ii;
            } else {
                maxVal = tmp;
                maxIdx = ii;
            }
        }
        System.out.println("minVal: "+minVal + ", minIdx: "+minIdx);
        System.out.println("maxVal: "+maxVal + ", maxIdx: "+maxIdx);

        int i = minIdx;
        int j = maxIdx;
        while (i<j && i<maxIdx && j>minIdx) {
            i++;
            j--;
        }

        System.out.println("--- i: "+i);
        System.out.println("--- j: "+j);

        return 0;
    }



    /**
     * 不可行
     * @param prices
     * @return
     */
    public int maxProfit0(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        // i，从前往后找i，arr[i] 最小
        int minVal = Integer.MAX_VALUE; // min price

        int i=0;
        for (int ii=0; ii<prices.length; ii++) {
            int tmp = prices[ii];

            if (tmp < minVal) {
                minVal = tmp;
                i = ii;
            }
        }
        System.out.println("i: "+i);

        int j = i;
        int maxVal = minVal;
        // j，从后往前找j，j>i && arr[j] > arr[i]
        for (int jj=prices.length-1; jj > i; jj--) {
            int tmp = prices[jj];
            if (tmp > maxVal) {
                maxVal = tmp;
                j = jj;
            }
        }
        System.out.println("j: "+j);

        if (j > i && prices[j] > prices[i]) {
            return prices[j] - prices[i];
        }



        return 0;
    }

}
