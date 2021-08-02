package leetcode.链表.判断链表是否有环;

import leetcode.链表.ListNode;

public class Solution {

    public static int hasCicle(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while (slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                //节点相遇
                break;
            }
        }
        ListNode p1 = node;
        while (p1!=null && slow!=null){
            if(p1==slow){
                return p1.val;
            }
            p1=p1.next;
            slow=slow.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        //n5.next = n2;  //构造一个带环的链表,去除此句表示不带环
        System.out.println(hasCicle(n1));

    }
}
