
/**
 * 删除多个元素，未使用虚拟头节点
 *
 * 链表：双链表，循环双链表(dummyHead指向链表头和链表尾)、数组链表
 * */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;

    }
    public static void main(String[] args){
        int[] num = {1,2,3,4,53,3};
        ListNode head = new ListNode(num);
        System.out.println(head);

        ListNode res = new Solution().removeElements(head,4);
        System.out.println(res);
    }
}


