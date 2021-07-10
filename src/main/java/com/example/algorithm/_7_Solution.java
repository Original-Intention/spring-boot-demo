package com.example.algorithm;

import java.util.HashMap;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class _7_Solution {

    //主方法
    public static void main(String[] args) {
        int num = 2147483639;
        int result = reverse(num);
        System.out.println(result);
    }

    public static int reverse(int x) {
        int result = 0;
        while(x!=0){
            int temp = x%10;
            //判断临界值
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10){
                return 0;
            }
            result = result*10+temp;
            x = x/10;
        }
        return result;
    }
}
