package list;
/** 链表合并
 *
 * */
public class ReviewmergeTwoList {
    public ListNode mergelist(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode prehead = new ListNode(-1);
        ListNode curr = prehead;
        while (l1!= null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        return prehead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergelist(lists[0],lists[1]);
        int mid = lists.length/2;
        ListNode[] list1 = new ListNode[mid];
        for(int i = 0; i < mid; i++){
            list1[i] = lists[i];
        }
        ListNode[] list2 = new ListNode[lists.length-mid];
        for(int j = mid,i = 0; j < lists.length; j++,i++){
            list2[i] = lists[j];
        }
        return mergelist(mergeKLists(list1),mergeKLists(list2));
    }
}
