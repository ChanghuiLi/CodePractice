package list;

public class swapListNode {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode preres = new ListNode(0);
        preres.next = head;
        ListNode prehead = preres;
        while (head != null && head.next != null) {
            swapListNode(prehead,head);
            prehead = head;
            head = head.next;
        }
        return preres.next;
    }

    /** 交换head和head.next两个节点。
     * @param head 表示head节点;
     * @param prehead 表示head之前的节点；
     * */
    private void swapListNode(ListNode prehead, ListNode head) {
        ListNode temp = head.next;
        head.next = temp.next;
        prehead.next = temp;
        temp.next = head;
    }
}
