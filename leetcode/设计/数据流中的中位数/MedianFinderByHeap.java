package leetcode.设计.数据流中的中位数;

import java.util.PriorityQueue;

/**
 * 采用优先队列(大顶堆、小顶堆实现)
 */
public class MedianFinderByHeap {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinderByHeap() {
        this.minHeap = new PriorityQueue<>();//小顶堆，存较大的一半数
        this.maxHeap = new PriorityQueue<>((x,y)->(y-x));//大顶堆，存较小的一半数
    }

    public void addNum(int num) {
        //当两个队列大小相同时，优先放到大顶堆中
        //当大顶堆比小顶堆大时，优先放到小顶堆中
        if(minHeap.size()==maxHeap.size()){
            if(minHeap.peek()<num){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }else{
            if(maxHeap.peek()>num){
                maxHeap.offer(num);
                num=maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }

    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return (double)(minHeap.peek()+maxHeap.peek())/2.0;
        }
        return (double)maxHeap.peek();
    }
}
