package stack;

import java.util.Stack;
/**
 *  用递归的方式返回栈的最底下的元素。
 * */
public class ReviewReverseStack {
    public int reverse(Stack<Integer> s) {
        int res = s.pop();
        if(s.isEmpty()){
            return res;
        } else {
            int element = reverse(s);
            s.push(element);
            return s.peek();
        }

    }
}
