package com.corejava.c5_gc;

import java.util.ArrayList;

// -XX:+PrintGCDetails -Xms32M -Xmx32M -XX:+UseParallelGC -XX:+PrintFlagsFinal -XX:+PrintVMOptions
public class ThreadsLock1 {
    public static void main(String[] args) {
        System.out.println("Thread Lock!");

        try {
            ArrayList<Thread> threads = new ArrayList<>();
            Thread thread1 = new Thread(new MyThread1("线程A"));
            Thread thread2 = new Thread(new MyThread1("线程B"));
            threads.add(thread1);
            threads.add(thread2);

            for (Thread thread: threads) {
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Exiting main!");
    }
}

class MyThread1 implements Runnable {
    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (;;) {
                System.out.println("Run Thread name: " + this.name);
                //Thread.sleep(10000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
