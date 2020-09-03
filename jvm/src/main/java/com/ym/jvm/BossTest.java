package com.ym.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BossTest {
    List getFast(){

        List result;

        Queue<List> queue = new LinkedBlockingQueue<>();

        new Thread(() -> {
            queue.offer(a());
        }).start();

        new Thread(() -> {
            queue.offer(b());
        }).start();

        new Thread(() -> {
            queue.offer(c());
        }).start();


         result = queue.poll();

        return result;
    }

    List a(){
        return new ArrayList();
    }
    List b(){
        return new ArrayList();
    }
    List c(){
        return new ArrayList();
    }



//    score 成绩表
//
//    id 主键
//    class_id 班级
//    name  学生名
//    course 课程
//    score 分数
//    test_date8 测试的日期
//
//1. 查询班级A的 某一天考试中 各科成绩最好学生名、课程、和成绩
//
//
//    语文 章三 100
//    语文 里斯 100
//    数学 章三 100
//    数学 里斯 100
//
//
//    查询字段：
//
//    select s.course,s.name,s.score from score s inner join
//    (select course,max(score) score from score where class_id = "A" and test_date8 = ? group by course) a
//    on s.score = a.score and s.course = a.course and class_id = "A" and test_date8 = ?



}
