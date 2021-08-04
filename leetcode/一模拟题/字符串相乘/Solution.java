package leetcode.一模拟题.字符串相乘;

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        int[] arr = new int[num1.length()+num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for(int i=0;i<arr.length-1;i++){
            //i既是数组下标，也是两个字符串下标之和
            for(int j=0;j<=i;j++){
                int index1=j;
                int index2=i-j;
                if(index1<num1.length() && index2<num2.length()){
                    int res = (num1.charAt(index1)-'0')*(num2.charAt(index2)-'0')+arr[i];
                    arr[i] = res%10;
                    arr[i+1] += res/10;
                }
            }
        }
        int index=arr.length-1;
        while (arr[index]==0){
            index--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=index;i>=0;i--){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}

