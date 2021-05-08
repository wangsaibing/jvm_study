package com.corejava.c5_gc;

//-XX:+PrintGCDetails -Xms32M -Xmx32M -XX:+UseParallelGC -XX:+PrintFlagsFinal -XX:+PrintVMOptions
//-XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:+PrintFlagsFinal -XX:+PrintVMOptions -
public class T01_HelloGC {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("-------------");

        for(int i=0; i<1000; i++) {
            System.out.println("========="+i);
            byte[] b = new byte[1024 * 1024];
            Thread.sleep(10000);
        }
        System.out.println("-------------");
    }
}
