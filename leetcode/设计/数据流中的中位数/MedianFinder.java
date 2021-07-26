package leetcode.设计.数据流中的中位数;

public class MedianFinder {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        };
    }
    /** initialize your data structure here. */
    int size;
    Node head;
    public MedianFinder() {
        int size=0;
        head=new Node(-1);
    }

    public void addNum(int num) {
        Node prev=head.next;
        Node node = new Node(num);
        size++;
        if(prev==null || node.val<prev.val){
            node.next = prev;
            head.next = node;
            return;
        }
        while(prev!=null && prev.val<=node.val){
            if(prev.next!=null && prev.next.val>node.val){
                //当前值介于prev和next之间，开始插入
                node.next=prev.next;
                prev.next=node;
                return;
            }else if(prev.next==null){
                //如果prev节点之后没有节点，则插入到尾部
                prev.next=node;
                return;
            }
            prev=prev.next;
        }
    }

    public double findMedian() {
        if(size%2==0){
            //链表长度为偶数，取中间两个数求平均
            int i=size/2;
            Node prev=head;
            while (i>0){
                prev = prev.next;
                i--;
            }
            return (double) (prev.val+prev.next.val)/2.0;
        }else{
            //链表长度为奇数，取中间数
            int i=size/2+1;
            Node prev=head;
            while (i>0){
                prev=prev.next;
                i--;
            }
            return prev.val;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(2);
        medianFinder.addNum(2);
        //medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
    }
}
