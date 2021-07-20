package com.example.algorithm;

import java.util.Arrays;

/**
 * 1877. 数组中最大数对和的最小值
 *
 * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
 *     比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
 * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
 *     nums 中每个元素 恰好 在 一个 数对中，且最大数对和 的值 最小 。
 * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
 */

public class _1877_Solution {
    //主方法
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7,9} ;
        int result1 = countPairs(nums);
        System.out.println(result1);
    }
    public static int countPairs(int[] nums) {
        //第一步对数组进行排序
        Arrays.sort(nums);
        //第二步，用最大+最小=最大数对和的最小值
        int i=0,j=nums.length-1,result=0;
        while(i<j){
            result = Math.max(result,nums[i]+nums[j]);
            i++;
            j--;
        }
        return result;
    }
}
