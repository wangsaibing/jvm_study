package com.corejava.test_volatile;


public class TestVolatileVolatile {
    public static void main(String[] args) {
        ThreadDemo3 threadDemo = new ThreadDemo3();
        Thread thread = new Thread(threadDemo);
        thread.start();

        int i = 0;
        while (true) {
            if (threadDemo.isFlag()) {
                System.out.println("主线程读取到的flag = " + threadDemo.isFlag());
                break;
            } else {
                System.out.println("主线程读取到的flag = " + threadDemo.isFlag() + "; 第" + i + "次读取");
            }
            i++;
        }

    }
}

class ThreadDemo3 implements Runnable {
    public volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("ThreadDemo线程修改后的flag = " + isFlag());
    }

    public boolean isFlag() {
        return this.flag;
    }
}

