package com.example.algorithm;


/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 */

public class _11_Solution {
    //主方法
    public static void main(String[] args) {
        int[] num = {4,1,3,5,8,9,20,1,3,2};
        System.out.println(maxArea(num));
    }

    //使用双指针，当左边数<右边数是，则向右移动左指针，反之则向左移动又指针
    public static int maxArea(int[] height) {
        //当数组长度为0或1，面积均为0
        if (height.length<=1) return 0;
        int left=0,right=height.length-1,sum = 0;
        while(left < right){
            int mid = Math.min(height[left],height[right])*(right-left);
            sum = Math.max(sum,mid);
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return sum;
    }
}
