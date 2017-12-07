package data.stack;

import util.P;

/**
 * Created on 2017/12/7.
 *
 * @author DuanJiaNing
 */
public class Test {

    public static void main(String[] args) {
//        Stack<Integer> stack = new LinkedStack<>();
        Stack<Integer> stack = new ArrayStack<>(Integer.class);
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        P.out(stack.size());
        P.out(stack.pop());
        P.out(stack.pop());
        P.out(stack.pop());
        P.out("size=" + stack.size());
    }

}
