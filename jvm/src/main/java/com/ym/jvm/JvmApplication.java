package com.ym.jvm;

import com.ym.jvm.task.TestTask;
import com.ym.jvm.threads.ThreadUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class JvmApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(JvmApplication.class, args);
        //测试线程池任务执行
        ThreadPoolExecutor executor = ThreadUtils.getThreads();
        Future<?> future = executor.submit(new TestTask());
        future.get();
        int n = 345;
        int length = (n + "").length();
        String str = n + "";
        ArrayList<Character> list = new ArrayList<>();
        list.add(str.charAt(length - 1));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
			stringBuilder.append(list.get(i));
        }

    }


}
