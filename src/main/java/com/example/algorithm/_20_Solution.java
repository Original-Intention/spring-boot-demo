package com.example.algorithm;

import java.util.Stack;

/**
 * 20、有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
 */
public class _20_Solution {

    public static void main(String[] args) {
        String s = "({[()]})";
        System.out.println(isValid(s))  ;
    }


    //使用栈的数据结构，满足“先入后出，后入先出”
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty()||c!=stack.pop()){
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

}
