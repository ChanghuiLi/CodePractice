package list;

public class ReverseList {
    public ListNode ReList(ListNode head){
        if(head == null||head.next == null) return head;
        ListNode prehead = head;
        ListNode tempnext = null;
        while (head.next!=null) {
            tempnext = head.next;
            head.next = tempnext.next;
            tempnext.next = prehead;
            prehead = tempnext;
        }
        return prehead;
    }
}
