package com.example.algorithm;

public class _1711_Solution {
    //主方法
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9} ;
        int result1 = countPairs(nums);
        System.out.println(result1);
    }
    public static int countPairs(int[] deliciousness) {
        int result = 0;
        for(int i=0;i<deliciousness.length;i++){
            for(int j=i+1;j<deliciousness.length;j++){
                if((deliciousness[i]+deliciousness[j])%2==0){
                    result++;
                }
            }
        }
        return result;
    }
}
