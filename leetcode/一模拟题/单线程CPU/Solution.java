package leetcode.一模拟题.单线程CPU;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给你一个二维数组 tasks ，用于表示 n​​​​​​ 项从 0 到 n - 1 编号的任务。其中 tasks[i] = [enqueueTimei, processingTimei] 意味着第 i​​​​​​​​​​ 项任务将会于 enqueueTimei 时进入任务队列，需要 processingTimei 的时长完成执行。

 * 如果 CPU 空闲，且任务队列中没有需要执行的任务，则 CPU 保持空闲状态。
 * 如果 CPU 空闲，但任务队列中有需要执行的任务，则 CPU 将会选择 执行时间最短 的任务开始执行。如果多个任务具有同样的最短执行时间，则选择下标最小的任务开始执行。
 * 一旦某项任务开始执行，CPU 在 执行完整个任务 前都不会停止。
 * CPU 可以在完成一项任务后，立即开始执行一项新任务。
 */
public class Solution {
    public int[] getOrder(int[][] tasks) {
        //维持一个当前执行总时间 runtime
        //tasks按照时间先后升序排序
        //优先队列实现小顶堆 用于存储当前可执行的任务，按照任务时间排序，如果任务时间相同，按照序号升序
        for(int i=0;i<tasks.length;i++){
            tasks[i]=new int[]{tasks[i][0],tasks[i][1],i};
        }
        Arrays.sort(tasks,(x,y)->(x[0]-y[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y)->{
            if(x[1]==y[1]){
                return x[2]-y[2];
            }
            return x[1]-y[1];
        });
        int[] res = new int[tasks.length];
        int[] arr=tasks[0];
        int currentTime = arr[0];
        queue.offer(arr);
        int index=0;
        for(int i=1;i<tasks.length;i++){
            int[] cur = tasks[i];
            while (currentTime<cur[0]){
                if(queue.isEmpty()){
                    currentTime=cur[0];
                    break;
                }
                int[] poll = queue.poll();
                res[index++]= poll[2];
                currentTime+=poll[1];
            }
            queue.offer(cur);
        }
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            res[index++]= poll[2];
        }
        return res;
    }
}
