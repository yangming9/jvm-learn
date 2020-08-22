package com.ym.jvm.signalthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock Condition 实现线程通信
 */
public class Task {

    private final Lock lock = new ReentrantLock();

    private final Condition addCondition = lock.newCondition();
    private final Condition subCondition = lock.newCondition();

    private volatile int num = 0;
    private List<String> list = new ArrayList<>();

    public void add() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                if (list.size() == 10) {
                    addCondition.await();
                }
                num++;
                Thread.sleep(100);
                list.add("add" + num);
                System.out.println("The list size is " + list.size());
                System.out.println("The add thread is " + Thread.currentThread().getName());
                System.out.println("----------");
                subCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void sub() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                if (list.size() == 0) {
                    subCondition.await();
                }
                num--;
                Thread.sleep(100);
                list.remove(0);
                System.out.println("The list size is " + list.size());
                System.out.println("The sub thread is " + Thread.currentThread().getName());
                System.out.println("----------");
                addCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        Task task = new Task();
        new Thread(()->{
            task.add();
        }).start();
        new Thread(() -> {
            task.sub();
        }).start();
    }
}
