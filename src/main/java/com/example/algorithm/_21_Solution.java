package com.example.algorithm;


/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */


public class _21_Solution {
    //主方法
    public static void main(String[] args) {
        int[] nums1 = {2,3,9} ;
        int[] nums2 = {2,5,7,9} ;
        ListNode l1 = new ListNode(1);
        ListNode mid1 = l1;
        ListNode l2 = new ListNode(1);
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
        while(l1!=null&&l2!=null){
            if(l1.val< l2.val){
                mid.next = l1;
                l1 = l1.next;
            }else{
                mid.next = l2;
                l2 = l2.next;
            }
            mid = mid.next;
        }
        mid.next = (l1==null)?l2:l1;
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
