package com.ym.jvm.sorts;

public class Test {

    public static void main(String[] args) {
        new Test().start();
    }

    public void start() {
        new Thread(new TaskA()).start();
        new Thread(new TaskB()).start();
    }

    private final Object lock = new Object();
    private boolean finished;

    private class TaskA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("线程 A 拿到锁了，开始工作");
                while (!finished) {
                    try {
                        System.out.println("线程 A 释放了锁，进入等待状态");
                        lock.wait();
                        System.out.println("线程 A 收到信号，继续工作");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("线程 A 释放了锁");
        }
    }

    private class TaskB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("线程 B 拿到了锁，开始工作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-----------------------");
                System.out.println("线程 B 发信号了，完成工作");
                finished = true;
                lock.notify();
            }
            System.out.println("线程 B 释放了锁");
        }
    }

//    public static void main(String[] args) {
//        int[] singles = {1, 3, 4, 2, 6, 1, 3, 6, 2, 8, 4};
//        System.out.println(singleNumber(singles));
//    }
//
//    public static int singleNumber(int[] nums) {
//        /**本题可使用异或的方法解决
//         1.任何数与零异或都为其本身
//         2.相同的两个数异或为0
//         3.异或运算满足交换律与结合律
//         */
//        int single = 0;
//        //将数组中的所有元素进行异或运算，结果便为只出现一次的元素
//        for (int i = 0;i<nums.length;i++) {
//            single ^= nums[i];
//
//        }
//        return single;
//    }


}
