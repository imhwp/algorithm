package leetcode.链表.相交链表;

import leetcode.链表.ListNode;

public class Solution {
    public int findCrossListNode(ListNode n1,ListNode n2){
        ListNode p1 = n1;
        ListNode p2 = n2;
        while (p1!=p2){
            p1=p1==null?n2:p1.next;
            p2=p2==null?n1:p2.next;
        }
        return p1==null?-1:p1.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next=n2;
        ListNode y1 = new ListNode(11);
        ListNode y2 = new ListNode(12);
        y1.next=y2;
        ListNode n3 = new ListNode(3);
        n2.next=n3;
        y2.next=null;
        ListNode n4 = new ListNode(4);
        n3.next=n4;
        System.out.println(solution.findCrossListNode(n1, y1));
    }
}
