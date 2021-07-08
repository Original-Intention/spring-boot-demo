package com.example.algorithm;


/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

public class _2_Solution {
    //主方法
    public static void main(String[] args) {
        int[] nums1 = {8,3,9} ;
        int[] nums2 = {5,7,} ;
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
        ListNode result = addTwoNumbers(l1,l2);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode mid = result;
        //初始化进位
        int carry = 0;
        while(l1!=null||l2!=null){
            //假设l1和l2的长度一样进行循环，短的在前面补0
            int x = (l1==null)?0:l1.val;
            int y = (l2==null)?0:l2.val;
            int sum = x+y+carry;
            //进位
            carry = sum/10;
            //余数
            sum = sum%10;
            ListNode next = new ListNode(sum);
            mid.next = next;
            mid = mid.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        //若最后进位还为1，则需要在最后面补1
        if(carry==1){
            mid.next = new ListNode(1);
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
