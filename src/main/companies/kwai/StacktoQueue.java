package kwai;

import java.util.Stack;

public class StacktoQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;
    public StacktoQueue(){
        stackIn = new Stack<Integer>();
        stackOut = new Stack<Integer>();
    }
    public void push(int x) {
        stackIn.push(x);
    }
    public int pop() {
        if (stackOut.isEmpty()){
            if (stackIn.isEmpty()) {
                return -1;
            } else {
                while (!stackIn.isEmpty()) {
                    stackOut.push(stackIn.pop());
                }
                return stackOut.pop();
            }
        } else {
            return stackOut.pop();
        }
    }
    public int peek() {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
        if (!stackOut.isEmpty()) {
            return -1;
        } else {
            return stackOut.peek();
        }
    }
    public boolean empty() {
        if (stackOut.isEmpty() && stackIn.isEmpty()) {
            return true;
        }
        return false;
    }
}
