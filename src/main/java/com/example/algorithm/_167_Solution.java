package com.example.algorithm;

import java.util.HashMap;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 */
public class _167_Solution {
    //主方法
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,8,11} ;
        int target = 13;
        int[] result1 = twoSum1(nums,target);
        int[] result2 = twoSum2(nums,target);
        int[] result3 = twoSum2(nums,target);
        System.out.println(result1[0]+"-->"+result1[1]);
        System.out.println(result2[0]+"-->"+result2[1]);
        System.out.println(result3[0]+"-->"+result3[1]);
    }


    //使用双指针
    public static int[] twoSum1(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            }else if(sum>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[0];
    }
    //使用哈希查找
    public static int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int x = numbers[i];
            if(map.containsKey(target-x)){
                int y = map.get(target-x);
                return new int[]{y+1,i+1};
            }
            map.put(x,i);
        }
        return new int[0];
    }
    //使用二分查找
    public static int[] twoSum3(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[0];

        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            // 线性查找 - O(n)
            // 1. 二分查找 - O(logn)
            // [i + 1, nums.length - 1] 区间二分查找 target - x
            int index = binarySearch(numbers, i + 1, numbers.length - 1, target - x);
            if (index != -1) {
                return new int[]{i + 1, index + 1};
            }
        }

        return new int[0];
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}
