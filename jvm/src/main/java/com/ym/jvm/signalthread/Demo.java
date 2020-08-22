package com.ym.jvm.signalthread;

import com.ym.jvm.threads.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * synchronized  wait notify 实现线程通信
 */
public class Demo {

    private final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(() -> {
            for (int i = 0;i<10;i++){
                synchronized (demo.list){
                    System.out.println("*****");
                    if (demo.list.size()%2==1){
                        try {
                            demo.list.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    demo.list.add(i);
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(demo.list);
                    demo.list.notify();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0;i<10;i++){
                synchronized (demo.list){
                    if (demo.list.size()%2==0){
                        try {
                            demo.list.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    demo.list.add(i);
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(demo.list);
                    demo.list.notify();
                }
            }
        }).start();
    }

}
