package com.ym.jvm.patterns.single;

public class Lazy {
    private Lazy() {
    }
    private static Lazy INSTANCE;
    public static synchronized Lazy getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Lazy();
        }
        return INSTANCE;
    }
}
