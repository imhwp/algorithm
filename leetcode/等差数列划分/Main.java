package leetcode.等差数列划分;

public class Main {
    public static int solution(int[] nums){
        int[] arr = new int[nums.length-1];
        for(int i=1;i<nums.length;i++){
            arr[i-1] = nums[i]-nums[i-1];
            System.out.print(arr[i-1]+",");
        }
        //滑动窗口统计最大的连续区间由于要求3个，所以至少是arr中2个连续值
        int res = 0;
        int left = 0;
        int right= left+1;
        while (right<arr.length){
            if(arr[right]==arr[left]){
                right++;
            }else{
                //否则的话，计算区间长度
                int count = right-left+1;//这会算出该区间数据的数量
                if(count>=3){
                    res+=((count-1)*(count-2)/2);
                }
                left=right;
                right=left+1;
            }
        }
        if(arr[left]==arr[arr.length-1]){
            int count = right-left+1;//这会算出该区间数据的数量
            if(count>=3){
                res+=((count-1)*(count-2)/2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,8,9,10};
        System.out.println(solution(A));
    }
}
