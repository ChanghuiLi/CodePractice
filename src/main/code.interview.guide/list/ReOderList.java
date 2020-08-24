package list;

public class ReOderList {
    public void reorderList(ListNode head) {
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode fast = head;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newnode = slow.next;
        slow.next = null;
        ListNode reversenext = reList(newnode);
        mergelist(prehead,reversenext);
    }

    private void mergelist(ListNode prehead, ListNode reversenext) {
        ListNode thead = prehead.next;
        while (thead != null && reversenext !=null){
            prehead.next = thead;
            thead = thead.next;
            prehead.next = reversenext;
            reversenext = reversenext.next;
        }
        if(reversenext == null && thead != null){
            prehead.next = thead;
        }
    }

    public ListNode reList(ListNode lhead){
        if(lhead == null||lhead.next == null) return lhead;
        ListNode prehead = lhead;
        ListNode tempnext = null;
        while (lhead.next!=null) {
            tempnext = lhead.next;
            lhead.next = tempnext.next;
            tempnext.next = prehead;
            prehead = tempnext;
        }
        return prehead;
    }
}
