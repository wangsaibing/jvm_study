package com.corejava.c5_gc;

import java.util.ArrayList;
import java.util.List;

// -XX:+PrintGCDetails -Xms32M -Xmx32M -XX:+UseParallelGC -XX:+PrintFlagsFinal -XX:+PrintVMOptions
public class ThreadsLock {
    public static void main(String[] args) {
        System.out.println("Thread Lock!");

        ArrayList<Thread> threads = new ArrayList<>();
        threads.add(new MyThread("线程A"));
        threads.add(new MyThread("线程B"));
        for (Thread thread: threads) {
            thread.start();
        }

        System.out.println("Exiting main!");
    }
}

class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Run " + i + ", Thread name: " + this.name);
                //Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
