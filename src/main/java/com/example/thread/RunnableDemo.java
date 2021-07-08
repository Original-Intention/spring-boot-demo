package com.example.thread;

public class RunnableDemo implements Runnable{


    public static void main(String[] args) {

        Thread th = new Thread(()->{
            for(int i=0;i<30;i++){
                System.out.println("Thread ：打游戏! --> "+ i);
            }
        });
        th.start();
        for(int i=0;i<30;i++){
            if(i>15){
                try {
                    th.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Main ：睡觉! --> "+ i);
        }

    }

    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            System.out.println("Main： 睡觉吧!");
        }
    }
}
