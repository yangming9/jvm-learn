package com.ym.jvm.task;

import java.util.concurrent.Callable;

public class TestTask implements Callable {

    @Override
    public String call() throws Exception {
        String s = "test thread pool";
        System.out.println("test thread pool!");
        return s;
    }
}
