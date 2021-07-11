package com.example.algorithm;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？(二分查找)
 */
public class _4_Solution {

    //主方法
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int[] news = new int[nums1.length+nums2.length];
        int i=0,j=0,n=0;
        while(i<nums1.length&&j< nums2.length){
            if(nums1[i]<=nums2[j]){
                news[n++] = nums1[i++];
            }else{
                news[n++] = nums2[j++];
            }
        }
        if(i==nums1.length){
            for(int x=j;x< nums2.length;x++){
                news[n++] = nums2[x];
            }
        }else{
            for(int x=i;x< nums1.length;x++){
                news[n++] = nums1[x];
            }
        }
        if(news.length>0&&news.length%2==0){
            result = (news[news.length/2-1]+news[news.length/2])/2.0;
        }else if (news.length%2==1){
            result = news[(news.length+1)/2-1];
        }
        return result;
    }
}
