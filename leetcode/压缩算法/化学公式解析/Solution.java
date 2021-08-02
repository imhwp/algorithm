package leetcode.压缩算法.化学公式解析;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：K4[ON(SO3)2]2
 * 输出：K4N2O14S4
 */
public class Solution {
    public String method1(String str){
        String s = dfs(str, 0);
        Map<String, Integer> count = count(s);
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry entry:count.entrySet()){
            stringBuilder.append(entry.getKey());
            stringBuilder.append(entry.getValue());
        }
        return stringBuilder.toString();

    }


    public String dfs(String str,int l){
        StringBuilder res = new StringBuilder();
        while (l<str.length()){
            String temp = "";
            if(str.charAt(l)=='[' || str.charAt(l)=='('){
                //递归到下一层继续处理
                temp = dfs(str,l+1);//返回的化学式中没有方括号、圆括号
            }else if(str.charAt(l)==']' || str.charAt(l)==')'){
                //遇到方括弧，开始结算
                int count=0;
                l++;
                while (l<str.length()){
                    if(str.charAt(l)>='0' || str.charAt(l)<='9'){
                        count=count*10+(str.charAt(l)-'0');
                        l++;
                    }else{
                        break;
                    }
                }
                //while循环结束以后，得到了对应的数字
                while (count>0){
                    res.append(temp);
                    count--;
                }
            }else{
                res.append(str.charAt(l));
            }
            l++;
        }
        return res.toString();
    }

    public Map<String,Integer> count(String str){
        Map<String,Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        int i=0;
        String word = "";
        int mul = 0;
        while (i<chars.length){
            if(chars[i]>='A' && chars[i]<='Z'){
                //新的分子开始，上一个分子需要完成计数
                if(!"".equals(word)){
                    int num = map.getOrDefault(word, 0);
                    mul=mul==0?1:mul;
                    map.put(word,mul+num);
                    mul=0;//状态恢复
                    word="";//状态恢复
                }
            }else if(chars[i]>='a' && chars[i]<='z'){
                word = word + chars[i];
            }else{
                //剩下是数字的情况，对数字进行累计
                mul = mul*10 + chars[i]-'0';
            }
            i++;
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "K4[ON(SO3)2]2";
        Solution solution = new Solution();
        System.out.println(solution.method1(s));
    }
}
