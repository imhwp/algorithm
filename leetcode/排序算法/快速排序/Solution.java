package leetcode.排序算法.快速排序;

public class Solution {
    static int k;
    static int res;
    public static void main(String[] args) {
        int[] arr = {3,2,5,4,1,6};
        k=4;
        quickSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
        System.out.println("------");
        System.out.println(res);
    }

    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            System.out.println("left="+left+",right="+right);
            res=arr[left];
            return;
        }
        int l=left;
        int r=right;
        int temp=arr[left];
        while (l<r){
            while (l<r && arr[r]<=temp){
                r--;
            }
            arr[l]=arr[r];
            while (l<r && arr[l]>=temp){
                l++;
            }
            arr[r]=arr[l];
        }
        arr[l]=temp;
        if(l+1==k) {
            res=temp;
            return;
        }
        if(l+1>k){
            quickSort(arr,left,l-1);
        }else{
            quickSort(arr,l+1,right);
        }


    }
}
