package com.ym.jvm.threads;

import java.util.concurrent.*;

/**
 * 线程池的四个淘汰策略分别是：
 * 1.AbortPolicy  线程池最大处理能力已经满了  不会执行后面的任务 抛出异常，丢掉任务
 * 2.CallerRunsPolicy   利用当前正在执行的主线程执行这个任务
 * 3.DiscardPolicy 线程池中的阻塞队列满时，直接丢弃任务  不会抛出异常
 * 4.DiscardOldestPolicy  尝试和之前的线程进行竞争，不会抛出异常
 */
public class ThreadUtils {
    public static ThreadPoolExecutor getThreads(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4,
                8,
                5,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                new ThreadFactoryName(),
                new ThreadPoolExecutor.AbortPolicy());
        return executor;
    }
}
