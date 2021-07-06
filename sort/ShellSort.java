package sort;

/**
 * 希尔排序主要思想在于通过gap来分组，先进行组内的排序。然后将gap逐渐缩小至1
 */
public class ShellSort {
    public static void sort(int[] arr){
        for (int gap=arr.length/2;gap>0;gap/=2){
            for (int i = gap;i<arr.length;i++){
                int j=i;
                int temp = arr[j];
                if(arr[j]<arr[j-gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,7,6,2,5,4};
        sort(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
