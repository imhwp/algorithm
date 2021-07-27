package leetcode.树状数组.数组中的逆序对;

public class Solution {
    int[] tempArr;
    int res;
    public int reversePairs(int[] arr){
        //考虑归并排序
        this.tempArr=new int[arr.length];
        mergeSort(arr,0,arr.length-1);
        return res;
    }

    public void mergeSort(int[] arr,int left,int right){
        if(left>=right) return;
        int mid = left + (right-left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);

    }

    public void merge(int[] arr,int left,int mid,int right){
        //left 到 mid 是有序的
        //mid+1 到 right 是有序的
        // 1 3 5 -- 2 4 6
        int i1=left;
        int i2=mid+1;
        int tempIndex=left;
        while (i1<=mid && i2<=right){
            if(arr[i1]>arr[i2]){
                res+=(mid-i1+1);
                tempArr[tempIndex]=arr[i2];

                i2++;
            }else{
                tempArr[tempIndex]=arr[i1];
                i1++;
            }
            tempIndex++;
        }

        while (i1<=mid){
            tempArr[tempIndex]=arr[i1];
            i1++;
            tempIndex++;
        }

        while (i2<=right){
            tempArr[tempIndex]=arr[i2];
            i2++;
            tempIndex++;
        }

        while (left<=right){
            arr[left]=tempArr[left];
            left++;
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = {7,5,6,4};
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(arr));
    }
}
