package com.example.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class _3_Solution {

    //主方法
    public static void main(String[] args) {
        String s = "abcabcd";
        int result = lengthOfLongestSubstring1(s);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        String str = new String();
        int result = 0;
        for(char c : s.toCharArray()){
            if(str.indexOf(c)>=0){
                result = (str.length()>result)?str.length():result;
                str = str+c;
                str = str.substring(str.indexOf(c)+1);
            }else{
                str = str+c;
                result = (str.length()>result)?str.length():result;
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring1(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int result = 0;
        for(int start=0,end=0;end<s.length();end++){
            if(map.containsKey(s.charAt(end))){
                //若有重复的字符，则将起始指针向后移动1位将重复字符排除在外
                start = Math.max(map.get(s.charAt(end))+1,start);
            }
            result = Math.max(end-start+1,result);
            map.put(s.charAt(end),end);
        }
        return result;
    }
}
