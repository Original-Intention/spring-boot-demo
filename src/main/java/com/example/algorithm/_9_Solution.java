package com.example.algorithm;


/**
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */

public class _9_Solution {
    //主方法
    public static void main(String[] args) {
        int num = 134565432;
        System.out.println(isPalindrome(num));
    }

    //由于进行每次除10，时间复杂度为O(logn)，空间复杂度为O(1)
    public static boolean isPalindrome(int x) {
        //当x小于0，或者最后一位为0，则不是回文数
        if(x<0||(x%10==0&&x>0)) return false;
        int re = 0;
        //反转一半与前一半进行比较，相同则为回文
        while(x>re){
            re = re*10+x%10;
            x/=10;
        }
        return (x==re||x==re/10);
    }
}
