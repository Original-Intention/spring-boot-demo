package com.example.demo;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            System.out.println("Runnable： 睡觉吧!");
        }
    }
}
