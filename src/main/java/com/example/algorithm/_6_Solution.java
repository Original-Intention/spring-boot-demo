package com.example.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * a   e   i   m
 * b d f h j l n
 * c   g   k
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 */
public class _6_Solution {

    //主方法
    public static void main(String[] args) {
        String s = "abcdefghijklmn";
        int numRows = 3;
        String result = convert(s,numRows);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        //若只有一行则返回s
        if(numRows==1) return s;
        StringBuffer result = new StringBuffer();
        //建立集合代表行数
        List<StringBuffer> list = new ArrayList<StringBuffer>();
        for(int i=0;i<Math.min(numRows,s.length());i++){
            list.add(new StringBuffer());
        }
        int curRow = 0,flag=-1;
        //遍历字符串，并走倒N字形，从上到下
        for(char c : s.toCharArray()){
            list.get(curRow).append(c);
            if(curRow==0||curRow==numRows-1){
                flag = -flag;
            }
            curRow+=flag;
        }
        //最后拼接字符
        for(StringBuffer str : list){
            result.append(str);
        }
        return result.toString();
    }
}
