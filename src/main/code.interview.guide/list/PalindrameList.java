package list;

import java.util.Stack;
/**
 * 或者使用快慢指针来做。
 * */
public class PalindrameList {
    public boolean isPalindrome(ListNode head) {
        if (head == null||head.next == null) return true;
        Stack<Integer> stack = new Stack<Integer>();
        int listLength = 1;
        ListNode search = head;
        while (search.next != null) {
            search = search.next;
        }
        int stackSave = listLength/2;
        while (stackSave > 0){
            stack.push(head.val);
            head = head.next;
            stackSave--;
        }
        if (listLength % 2 == 1) {
            head = head.next;
        }
        while (head != null&&!stack.isEmpty()) {
            if (head.val == stack.pop()) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
