package com.corejava.test_volatile;

import java.util.concurrent.atomic.AtomicInteger;

public class TestIcon1 {
    public static void main(String[] args){
        AtomicDemo1 atomicDemo = new AtomicDemo1();
        for (int x = 0;x < 10; x++){
            new Thread(atomicDemo).start();
        }
    }
}

class AtomicDemo1 implements Runnable{
    //private int i = 0;
    AtomicInteger i = new AtomicInteger();
    public int getI(){
        return i.getAndIncrement();
    }
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-------" + getI());
    }
}