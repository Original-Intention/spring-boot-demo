package com.example.algorithm;

import java.util.HashMap;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值 target的那两个整数，并返回它们的数组下标。
 */
public class _1_Solution {

    //主方法
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,8,11} ;
        int target = 13;
        int[] result1 = twoSumFor(nums,target);
        int[] result2 = twoSumHash(nums,target);
        System.out.println(result1[0]+"-->"+result1[1]);
        System.out.println(result2[0]+"-->"+result2[1]);
    }

    //暴力解法：双重循环，时间复杂度：O(n^2),控件复杂度 O(1)
    public static int[] twoSumFor(int[] nums, int target) {
        int [] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }

    //优化查询，哈希查找，时间复杂度：O(n)，空间复杂度：O(n)
    public static int[] twoSumHash(int[] nums, int target) {
        //空间复杂度：O(n)
        HashMap<Integer,Integer> map = new HashMap<>();
        //初始化Map的值
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            //哈希查找时间复杂度为O(1)
            if(map.containsKey(target-x)){
                int j = map.get(target - x);
                return new int[]{j,i};
            }
            map.put(x,i);
        }
        return new int[0];
    }
}
