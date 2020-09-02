package microsoft;

public class MergeKLists {
    public ListNode mergekList(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        int start = 0;
        int end = lists.length-1;
        return mergeStartAndEnd(lists,start,end);
    }

    private ListNode mergeStartAndEnd(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;
        int mid = (start + end) / 2;
        return mergeTwoLists(mergeStartAndEnd(lists,start,mid),mergeStartAndEnd(lists,mid+1,end));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    public ListNode mergerTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode prehead = new ListNode(-1);
        ListNode curr = prehead;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if (l1 == null) {
            curr.next = l2;
        } else if (l2 == null) {
            curr.next = l1;
        }
        return prehead.next;
    }

}
