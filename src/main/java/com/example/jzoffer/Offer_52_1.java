package com.example.jzoffer;


import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 */
public class Offer_52_1 {
    //主方法
    public static void main(String[] args) {
        int[] nums1 = {8,6} ;
        int[] nums2 = {8,5,7,9} ;
        ListNode l1 = new ListNode(4);
        ListNode mid1 = l1;
        ListNode l2 = new ListNode(7);
        ListNode mid2 = l2;
        for(int i : nums1){
            mid1.next = new ListNode(i);
            mid1 = mid1.next;
        }
        for(int i : nums2){
            mid2.next = new ListNode(i);
            mid2 = mid2.next;
        }
        ListNode result = getIntersectionNode(l1,l2);
        System.out.println(result);
        result = getIntersectionNode1(l1,l2);
        System.out.println(result);
    }

    //哈希集合的思路，先将A和B任意一个放入HashSet中，在用contains判断是否存在
    //时间复杂度：O(m+n)，空间复杂度：O(n)，
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode temp = headA;
        while(temp!=null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp!=null){
            if(set.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //双指针,用双指针将A+8循环一遍，有相同的就返回
    //时间复杂度：O(m+n)，空间复杂度：O(1)，
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1!=temp2){
            temp1 = temp1==null?headB:temp1.next;
            temp2 = temp2==null?headA:temp2.next;
        }
        return temp1;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
