package leetcode.堆.前K小问题;

import java.util.PriorityQueue;

/**
 * 前K小问题，可以使用大顶堆(优先队列表示）
 */
public class Solution {
    public static int[] findTopK(int[] arr,int k){
        if(arr.length<k) return null;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y)->(y-x));
        for(int i=0;i<arr.length;i++){
            if(maxHeap.size()<k){
                maxHeap.offer(arr[i]);
            }else{
                if(maxHeap.peek()>arr[i]){
                    //堆顶元素出队
                    maxHeap.poll();
                    maxHeap.offer(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,6,3,7,0,9};
        int[] topK = findTopK(arr, 4);
        for(int i:topK){
            System.out.println(i);
        }
    }
}
