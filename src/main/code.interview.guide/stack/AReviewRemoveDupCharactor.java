package stack;

import java.util.Stack;

public class AReviewRemoveDupCharactor {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack= new Stack<Character>();
        for(int i = 0;i < s.length(); i++){
            if (stack.contains(s.charAt(i))) {
                continue;
            }
            // 如果stack中没有这个元素，且新字符串中还有和栈顶元素一致的，就把栈顶元素弹出。
            while (!stack.isEmpty()&&stack.peek()>s.charAt(i)&&s.indexOf(stack.peek(),i)!=-1) {
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        char[] reschar = new char[stack.size()];
        for(int i = 0;i<reschar.length;i++){
            reschar[i] = stack.get(i);
        }
        return new String(reschar);
    }
}
