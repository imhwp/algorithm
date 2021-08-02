package leetcode.链表.链表加法;

import leetcode.链表.ListNode;


/**
 * 1.链表高位在后，低位在前，两个链表相加
 * 2.链表高位在前，低位在后，两个链表相加,先反转链表，然后相加完成
 */
public class Solution {
    public static ListNode add(ListNode n1, ListNode n2){
        if(n1==null) return n2;
        if(n2==null) return n1;
        ListNode dummy = new ListNode(-1);
        int pos = 0;
        ListNode p = dummy;
        while (n1!=null || n2!=null){
           int v1 = n1==null?0:n1.val;
           int v2 = n2==null?0:n2.val;
           int sum = v1 + v2 + pos;
           if(sum>9){
              pos = sum/10;
              sum%=10;
           }else{
               pos = 0;
           }
           p.next = new ListNode(sum);
           p=p.next;
           n1=n1==null?null:n1.next;
           n2=n2==null?null:n2.next;
        }
        if(pos>0){
            p.next = new ListNode(pos);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(1);
        n1.next=n2;
        ListNode n3 = new ListNode(5);
        n2.next=n3;
        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(4);
        m1.next=m2;
        m2.next=m3;
        ListNode add = add(n1, m1);
        while (add!=null){
            System.out.println(add.val);
            add=add.next;
        }
    }
}
