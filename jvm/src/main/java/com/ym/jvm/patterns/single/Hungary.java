package com.ym.jvm.patterns.single;

public class Hungary {
    private Hungary() {
    }
    private static final Hungary INSTANCE = new Hungary();
    public static Hungary getInstance(){
        return INSTANCE;
    }
}
