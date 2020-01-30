package cn.wendaocp;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.math.BigInteger;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

/**
 * @author lq
 * create 2020-01-28 12:54
 */
public class Demo {

    public static void main0(String[] args) {
        System.out.println(10.0 % 3);
    }

    public static void main(String[] args) {
//        int[] nums = new int[4];
//        nums[0] = 3;
//        nums[1] = 2;
//        nums[2] = 4;
//        nums[3] = 13;
//
//        int[] res = twoSum(nums, 6);
//        System.out.println(Arrays.toString(res));

        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(1);
//        l1.next.next.next = new ListNode(1);
//        l1.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next= new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(1);
//        l2.next.next.next = new ListNode(1);
//        l2.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next.next.next.next = new ListNode(1);
//        l2.next.next.next.next.next.next.next.next.next.next = new ListNode(1);

        ListNode res = addTwoNumbers(l1, l2);

        System.out.println("result: ");
        ListNode cur = res;
        while (cur != null) {
            System.out.print(cur.val+ " ");
            cur = cur.next;
        }

    }

    /**
     * OK
     *
     * 对链表进行操作，
     * 先创建一个比 最长listnode的长度+1 长度的链条
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode resNode = start;

        ListNode cur_l1 = l1;
        ListNode cur_l2 = l2;

        int size = 1;
        while(cur_l1 != null || cur_l2 != null) {
            start.next = new ListNode(0);

            start = start.next;

            if (cur_l1 != null) {
                cur_l1 = cur_l1.next;
            }
            if (cur_l2 != null) {
                cur_l2 = cur_l2.next;
            }

            size += 1;
        }

        System.out.println("size0:" + size);


//        start = resNode;
//        while (start != null) {
//            System.out.println("start.val: " + start.val);
//            start = start.next;
//        }


        // 开始对链条上数字进行相加
        cur_l1 = l1;
        cur_l2 = l2;
        start = resNode;
        while(cur_l1 != null || cur_l2 != null) {
            int tmp1 = 0;
            int tmp2 = 0;

            if (cur_l1 != null) {
                tmp1 = cur_l1.val;
                cur_l1 = cur_l1.next;
            }
            if (cur_l2 != null) {
                tmp2 = cur_l2.val;
                cur_l2 = cur_l2.next;
            }

            // 加，赋值到res
            int sum = tmp1 + tmp2;
            int mod = sum % 10;
            int div = (int)(sum / 10);

//            System.out.println("mod: "+mod);
//            System.out.println("div: "+div);

            start.val += mod;
            start.next.val += div;

            // start.val 可能>=10
            int tmp = start.val;
            if (tmp >= 10) {
                start.val = tmp % 10;
                start.next.val += (int)(tmp/10);
            }

            // update start
            start = start.next;
        }

        // 当 size > 1 时，清除最右边的为0的node
//        size = 0;
        ListNode cur = resNode;
//        while (cur != null) {
//            size += 1;
//            cur = cur.next;
//        }
//
//        System.out.println("size:" +size);

        if (size > 1) {
            cur = resNode;
            for(int i=1; i<size-1; i++) {
                cur = cur.next;
            }
            // 此时 cur是倒数第二个
            if (cur.next.val == 0) {
                cur.next = null;
            }
        }


        return resNode;

    }


    /**
     * 对链表进行操作
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        // 输出链表
        ListNode curNode = new ListNode(0);

        ListNode resNode = curNode;

        ListNode cur_l1 = l1;
        ListNode cur_l2 = l2;

        while (cur_l1 != null || cur_l2 != null) {
            int tmp1 = 0; // 记录当前l1的值
            int tmp2 = 0; // 记录当前l2的值

            if (cur_l1 != null) {
                tmp1 = cur_l1.val;
                cur_l1 = cur_l1.next;
            }
            if (cur_l2 != null) {
                tmp2 = cur_l2.val;
                cur_l2 = cur_l2.next;
            }

            System.out.println("tmp1: "+tmp1);
            System.out.println("tmp2: "+tmp2);

            int mod = (tmp1 + tmp2) % 10; // 将余数 赋值到 当前node
            int div = (int)((tmp1 + tmp2) / 10); // 将商赋给下一个node

            System.out.println("--- mod: "+mod );
            System.out.println("--- div: "+div);

            curNode.val += mod;

            int tmp = curNode.val;
            if (tmp >= 10) {
                curNode.val = tmp % 10;
                curNode.next = new ListNode((int)(tmp / 10));
            }

            if (div < 10) {
                curNode.next = new ListNode(div);
            } else {
                curNode.next = new ListNode(div % 10);
                curNode.next.next = new ListNode(div / 10);
            }


            curNode = curNode.next;
        }

//        // 清除resNode链条最后一个是0 的node
//        // cout resNode元素数目
//        ListNode cur = resNode;
//        int size = 0;
//        while (cur != null) {
//            size += 1;
//            cur = cur.next;
//        }
//        System.out.println("size: "+size);
//
//
//        int count = 0;
//        cur = resNode;
//        for (int i=1; i < size; i++) {
//            cur = cur.next;
//        }
//        cur.next = null;


//        ListNode cur = resNode;
//        while (cur.next.next != null) {
//            cur = cur.next;
//            System.out.println("cur.val: " +cur.val);
//        }
//
//        // while之后，cur就是最后一个元素
//        if (cur.val == 0) {
//            cur.next = null;
//            System.out.println("fianl, cur.val: "+cur.val);
//        }

//        ListNode cur = resNode;
//        while(cur.next != null) {
//            cur = cur.next;
//        }
//
//        // 此时cur是最后一个node
//        if(cur.val == 0) {
//
//        }

        // 先count链条上几个元素，若只有1个，不用裁剪0，若有多个元素，则裁剪最后一个是0的node
        ListNode cur = resNode;
        int size = 0;
        while (cur != null) {
            size += 1;
            cur = cur.next;
        }
        System.out.println("size: "+size);

        if (size > 1) {

            cur = resNode;
            while(cur.next != null) {
                cur = cur.next;
            }

    //         此时cur是最后一个node
            if(cur.val == 0) {
                cur = resNode;

                for(int i=1; i<size-1; i++) {
                    cur = cur.next;
                }
                cur.next = null;
            }

        }


        return resNode;
    }

    /**
     * 使用 BigInteger，
     * 但leetcode不让用
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        BigInteger val1 = new BigInteger("0");
        BigInteger val2 = new BigInteger("0");

        BigInteger tmp1 = new BigInteger("1");
        while(l1 != null) {
//            val1 += l1.val * tmp1;
//            tmp1 *= 10;
//            l1 = l1.next;
            val1 = val1.add(tmp1.multiply(new BigInteger(l1.val+"")));
            tmp1 = tmp1.multiply(new BigInteger("10"));
            l1 = l1.next;
        }

        BigInteger tmp2 = new BigInteger("1");
        while(l2 != null) {
//            System.out.print(l2.val + " ");
//            val2 += l2.val * tmp2;
//            tmp2 *= 10;
//            l2 = l2.next;
            val2 = val2.add(tmp2.multiply(new BigInteger(l2.val+"")));
            tmp2 = tmp2.multiply(new BigInteger("10"));
            l2 = l2.next;
        }

        System.out.println("val1:" +val1);
        System.out.println("val2:" +val2);

        BigInteger sum = val1.add(val2); // 两数和

        System.out.println("sum:" +sum);


        ListNode start = new ListNode(sum.mod(new BigInteger("10")).intValue()); // 取余，作为链表的第一个元素
        ListNode resNode = start;
        sum = sum.divide(new BigInteger("10"));

        while (sum.compareTo(new BigInteger("1")) != -1) {
//            double mod = sum % 10;
            int mod = sum.mod(new BigInteger("10")).intValue();
            System.out.println("mod: "+mod);

            start.next = new ListNode(mod);
//            sum = sum/10;
            sum = sum.divide(new BigInteger("10"));
            System.out.println("sum: "+sum.intValue());
            start = start.next;
        }

        return resNode;
    }


    public static void demo1() {
        int total = 0;
        int end = 100;

        // for
//        for (int i=0; i<= end; i++) {
//            total += i;
//        }

        //
        total = (1+end) * end /2;

        System.out.println(total);

    }

    /**
     * 两个for，暴力
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum0(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] res = new int[2];

        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        return null;
    }


    /**
     * 找9-x = target
     * 借助哈希表, key=数组值， value=数组元素索引
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            mp.put(nums[i], i);
        }

        int[] res = new int[2];
        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            Integer idx = mp.get(diff);

            if (idx != null && i != idx) {
                res[0] = i;
                res[1] = idx;
                return res;
            }
        }

        return null;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
