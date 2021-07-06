package sort;

import java.util.Arrays;

/**
 * 归并排序是时间稳定的排序，nlog(n)的平均时间复杂度
 * 主要思想是分治思想，可以全局创建一个临时数组，避免了在递归过程中频繁创建临时数组
 */
public class MergeSort {
    static int[] nums = {1,3,7,6,2,5,4};
    public static void sort(int left,int right,int[] arr,int[] temp){
        if(left>=right) return;
        int mid = left + (right-left)/2;
        sort(left,mid,arr,temp);
        sort(mid+1,right,arr,temp);
        merge(left,mid,right,arr,temp);
    }

    public static void merge(int left,int mid,int right,int[] arr,int[] temp){
        int i=0;
        int leftIndex=left;
        int rightIndex=mid+1;
        while (leftIndex<=mid && rightIndex<=right){
            if(arr[leftIndex]<arr[rightIndex]){
                temp[i] = arr[leftIndex];
                leftIndex++;
            }else{
                temp[i] = arr[rightIndex];
                rightIndex++;
            }
            i++;
        }
        while (leftIndex<=mid){
            temp[i] = arr[leftIndex];
            leftIndex++;
            i++;
        }
        while (rightIndex<=right){
            temp[i] = arr[rightIndex];
            rightIndex++;
            i++;
        }
        i=0;
        for(int j=left;j<=right;j++){
            arr[j] = temp[i];
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,7,6,2,5,4};
        int[] temp = new int[nums.length];
        sort(0,nums.length-1,nums,temp);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
