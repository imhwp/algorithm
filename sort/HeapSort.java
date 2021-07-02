package sort;

/**
 * 大顶堆：对于任意一个节点，其孩子节点的值均不大于该节点的值
 * 堆排序
 * 叶子节点开始的位置
 * nums.length/2
 */
public class HeapSort {
    static int[] nums = {1,3,7,6,2,5,4};
    public static void main(String[] args) {
        //建堆。整堆
        //大顶堆对应升序，小顶堆对应降序
    }

    /**
     * 建堆
     *
     */
    public static void buildHeap(int[] nums){
        for(int i=0;i<nums.length/2;i++){
            int left = i*2+1;
            int right = i*2+2;
            int maxPos = i;
            if(left<nums.length){
                if(nums[maxPos]<nums[left]){
                    maxPos=left;
                }
            }
            if(right<nums.length){
                if(nums[maxPos]<nums[right]){
                    maxPos=right;
                }
            }
            swap(maxPos,i,nums);
        }
    }

    /**
     * 整堆
     */
    public static void heapify(){

    }

    public static void swap(int a,int b,int[] nums){
        if(a==b) return;
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
