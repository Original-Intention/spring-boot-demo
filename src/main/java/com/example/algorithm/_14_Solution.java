package com.example.algorithm;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class _14_Solution {
    //主方法
    public static void main(String[] args) {
        String []  strs = {"abcdefg","abcd","abcdf"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String [] strs) {
        if(strs==null||strs.length==0) return "";
        String result = strs[0];
        for(String s : strs){
            while(!s.startsWith(result)){
                if(result.length()==0) return "";
                //每次去掉一位后再比较
                result = result.substring(0,result.length()-1);
            }
        }
        return result;
    }
}
