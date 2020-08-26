package stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    // 初始化方法
    public MinStack() {
        stack = new Stack<Integer>();
    }

    public int getMin() {
        return min;
    }
    public void push(int x) {
        if (x < min) {
            min = x;
            push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int temp = stack.pop();
        if(temp == min){
            min = stack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }
}
