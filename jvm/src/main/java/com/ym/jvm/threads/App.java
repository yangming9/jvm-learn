package com.ym.jvm.threads;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 参考链接地址  https://blog.csdn.net/qq_36186690/article/details/82939190
 */
public class App {
    public static void main(String[] args) throws IOException {
        //创建现成数组
        Thread[] taskArr = new Thread[10];
        //线程状态数组
        Thread.State[] threadStates = new Thread.State[10];
        //设置线程的状态
        for (int i = 0; i < 10; i++) {
            taskArr[i] = new Thread(new Pig());

            //分别设置状态
            if (i % 3 == 0) {
                taskArr[i].setPriority(Thread.NORM_PRIORITY);
            } else if (i % 3 == 1) {
                taskArr[i].setPriority(Thread.MIN_PRIORITY);
            } else if (i % 3 == 2) {
                taskArr[i].setPriority(Thread.MAX_PRIORITY);
            }
        }
        //将线程信息写入到文件中便于分析
        FileWriter fileWriter = new FileWriter("/Users/yangming/Documents/findworkprogrammer/jvm-learn/jvm/log.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        //循环遍历获取线程的信息
        for (int i = 0; i < 10; i++) {
            printWriter.println("线程 " + i + " 状态" + taskArr[i].getState());

            //将当前线程的状态保存到数组中
            threadStates[i] = taskArr[i].getState();
        }

        //启动线程
        for (int i = 0; i < 10; i++) {
            taskArr[i].start();
        }
        //在运行过程中如果线程的状态和初始状态不一样就将状态变化过程写入到文件中
        boolean finish = false;

        while (!finish) {
            for (int i = 0; i < 10; i++) {
                if (taskArr[i].getState() != threadStates[i]) {
                    printThreadMsg(printWriter, taskArr[i], threadStates[i]);
                    //将当前线程的状态保存到数组中
                    threadStates[i] = taskArr[i].getState();
                }
            }
            finish = true;
            for (int i = 0; i < 10; i++) {
                finish = finish && (taskArr[i].getState() == Thread.State.TERMINATED);
            }
        }

    }

    private static void printThreadMsg(PrintWriter printWriter, Thread thread, Thread.State state) {
        printWriter.println("******************************");
        printWriter.println("线程ID： " + thread.getId() + " 线程名称：" + thread.getName());
        printWriter.println("线程优先级： " + thread.getPriority());
        printWriter.println("线程过去状态： " + state);
        printWriter.println("线程当前状态： " + thread.getState());
        printWriter.println("*******************************");

    }
}
