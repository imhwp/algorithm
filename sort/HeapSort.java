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
        buildHeap(nums);
        for (int i = nums.length-1; i >= 1 ; i--) {
            swap(0,i,nums);
            heapify(0,i-1,nums);
        }
        for(int i:nums){
            System.out.println(i);
        }
    }

    /**
     * 建堆过程需要配合整堆
     * 建堆从最后一个非叶子节点开始，从右往左，从下往上进行。
     * 每次调整，都需要配合整堆操作。
     */
    public static void buildHeap(int[] nums){
        for (int i = nums.length/2; i >=0 ; i--) {
            heapify(i,nums.length-1,nums);
        }
    }

    /**
     * 整堆
     * 整堆操作是以当前节点开始，从上往下的传递过程
     */
    public static void heapify(int index,int end,int[] nums){
        int left = index*2+1;
        int right = index*2+2;
        int maxPos = index;
        if(left<=end && nums[left]>nums[maxPos]){
            maxPos = left;
        }
        if(right<=end && nums[right]>nums[maxPos]){
            maxPos = right;
        }
        if(maxPos!=index){
            swap(maxPos,index,nums);
            heapify(maxPos,end,nums);
        }
    }

    public static void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
