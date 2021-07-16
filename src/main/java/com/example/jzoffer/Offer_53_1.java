package com.example.jzoffer;


/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 */
public class Offer_53_1 {

    //主方法
    public static void main(String[] args) {
        int[] nums = {1,3,3,5,7,8,11} ;
        int target = 3;
        int result = search(nums,target);
        System.out.println(result);
        int result1 = search1(nums,target);
        System.out.println(result1);
    }

    //暴力解法
    public static int search(int[] nums, int target) {
        int result = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) result++;
        }
        return result;
    }

    //二分查找，查找最左边value=target的索引与最右边的索引
    public static int search1(int[] nums, int target) {
        return getIndex(nums,target+1)-getIndex(nums,target);
    }

    public static int getIndex(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }
    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
