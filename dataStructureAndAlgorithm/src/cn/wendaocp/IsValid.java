package cn.wendaocp;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author lq
 * create 2020-01-30 12:53
 */
public class IsValid {
    public static void main(String[] args) {

        String s = "()(){[]}}";

        boolean valid = isValid(s);
        System.out.println(valid);


    }


    public static boolean isValid(String s) {

        // stack
        ArrayList<Character> stack = new ArrayList<>();

        // 遍历s， 只能 左括号 可以入栈
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                // 左括号入栈
                stack.add(ch);

                System.out.println("ch: "+ch);

            } else {
                // 右括号
                if (stack.size() == 0) {
                    System.out.println("pos 1");
                    return false;
                }

                char out = stack.remove(stack.size() - 1);

                if (ch == ')' && out == '('  ||  ch == ']' && out == '['  ||  ch == '}' && out == '{' ) {
                    continue;
                } else {
                    return false;
                }

            }

        }

        // 遍历s之后，若stack还有元素，则代表有多余的 左括号
        if (stack.size() > 0) {
            System.out.println("pos 4");

            return false;
        } else {
            return true;
        }

    }


}
