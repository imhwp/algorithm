package sort;

public class QuickSort {
    // 快速排序
    //先找到分割点，然后通过将数组划分为两部分，分别递归排序,退出条件是左指针大于等于右指针
    static int[] nums = {1,3,7,6,2,5,4};
    public static void main(String[] args) {
        sort(0,nums.length-1);
        for(int i:nums){
            System.out.print(i);
            System.out.print(",");
        }

    }

    public static void  sort(int left,int right){
        if(left>=right) return;
        int low = left;
        int high = right;
        int temp = nums[left];
        while (left<right){
            while (nums[right]>temp && right>left){
                right--;
            }
            nums[left]=nums[right];
            while (nums[left]<temp && left<right){
                left++;
            }
            nums[right] =  nums[left];
        }
        nums[left] = temp;
        sort(low,left-1);
        sort(left+1,high);
    }
}
