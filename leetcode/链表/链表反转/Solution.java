package leetcode.链表.链表反转;

import leetcode.链表.ListNode;

public class Solution {

    public ListNode reverse(ListNode head){
        if(head==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head.next!=null){
            //记录并释放next节点
            ListNode next = head.next;
            head.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next=n2;
        ListNode n3 = new ListNode(3);
        n2.next=n3;
        ListNode n4 = new ListNode(4);
        n3.next=n4;
        Solution solution = new Solution();
        ListNode reverse = solution.reverse(n1);
        while (reverse!=null){
            System.out.println(reverse.val);
            reverse=reverse.next;
        }
    }
}
