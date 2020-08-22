package list;

public class addList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode s1 = l1;
        ListNode s2 = l2;
        int temp = 0;
        while (s1.next != null && s2.next != null) {
            temp = s1.val + s2.val + temp;
            s1.val = temp % 10;
            temp = temp / 10;
            s1 = s1.next;
            s2 = s2.next;
        }
        temp = s1.val + s2.val + temp;
        s1.val = temp % 10;
        temp = temp / 10;
        if (s1.next == null) {
            s1.next = s2.next;
            while (s1.next != null) {
                s1 = s1.next;
                temp = s1.val + temp;
                s1.val = temp % 10;
                temp = temp / 10;
            }
        } else {
            while (s1.next != null) {
                s1 = s1.next;
                temp = s1.val + temp;
                s1.val = temp % 10;
                temp = temp / 10;
            }
        }
        if (temp != 0) {
            ListNode t = new ListNode(temp);
            s1.next = t;
        }
        return l1;
    }
}
