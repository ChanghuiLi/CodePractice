package list;

public class ReverseKGroupList {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode preres = new ListNode(-1);
        preres.next = head;
        ListNode nexthead;
        ListNode prehead = preres;
        nexthead = head;
        while(nexthead!= null){
            int temp = k;
            while (nexthead != null && temp > 0) {
                nexthead = nexthead.next;
                temp--;
            }
            if (temp >= 1) {
                return preres.next;
            } else {
                reList(prehead,head,nexthead);
                prehead = head;
                head = nexthead;
            }
        }
        return preres.next;
    }

    public void reList(ListNode prehead, ListNode head, ListNode nexthead){
        ListNode tempnext;
        while (head.next!=nexthead) {
            tempnext = head.next;
            head.next = tempnext.next;
            tempnext.next = prehead.next;
            prehead.next = tempnext;
        }
    }
}
