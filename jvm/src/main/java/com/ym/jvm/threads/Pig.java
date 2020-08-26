package com.ym.jvm.threads;

import java.util.concurrent.TimeUnit;

public class Pig implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                //线程进行休眠一秒
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //打印当前执行线程信息
            System.out.println("ThreadName: "+Thread.currentThread().getName());
        }
    }
}
