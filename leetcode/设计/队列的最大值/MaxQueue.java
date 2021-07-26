package leetcode.设计.队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)
 * 分析：
 * 队列都是先进先出
 * 设计两个队列 a,b
 * a主要实现队列的入队和出队
 * b主要负责维护最大值
 * 当元素x入队b时，先判断x与b中队尾元素大小，如果大于则弹出队尾元素，然后放入该元素再放入队尾元素
 */
public class MaxQueue {
    Queue<Integer> queue = new LinkedList();
    Deque<Integer> deque = new LinkedList();
    Stack<Integer> stack = new Stack();
    public MaxQueue() {

    }

    public int max_value() {
        if(deque.isEmpty()) return -1;
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast()<value){
            stack.push(deque.pollLast());
        }
        deque.offerLast(value);
        while (!stack.isEmpty()){
            deque.offerLast(stack.pop());
        }
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        int val = queue.poll();
        while (!deque.isEmpty() && deque.peekFirst()!=val){
            stack.push(deque.poll());
        }
        deque.poll();
        while (!stack.isEmpty()){
            deque.offerFirst(stack.pop());
        }
        return val;

    }
}
