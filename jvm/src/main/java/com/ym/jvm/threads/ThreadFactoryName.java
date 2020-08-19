package com.ym.jvm.threads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryName implements ThreadFactory {

    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    public ThreadFactoryName() {
        this("test-pool-");
    }

    private ThreadFactoryName(String name) {
        SecurityManager securityManager = System.getSecurityManager();
        group = securityManager != null ? securityManager.getThreadGroup():Thread.currentThread().getThreadGroup();
        this.namePrefix = name+POOL_NUMBER.getAndIncrement();//此时namePrefix就是 name+第几个用这个工厂创建线程池的
    }

    @Override
    public Thread newThread(Runnable r) {
        //此时线程的名字就是namePrefix + -thread- + 这个线程池中第几个执行的线程
        Thread thread = new Thread(group, r, namePrefix + "-thread-" + threadNumber.getAndIncrement(), 0);
        if (thread.isDaemon()){
            thread.setDaemon(false);
        }
        if (thread.getPriority() != Thread.NORM_PRIORITY){
            thread.setPriority(Thread.NORM_PRIORITY);
        }
        return thread;
    }
}
