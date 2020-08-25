package com.ym.jvm.patterns.single;

public class InnerClassHolder {
    private InnerClassHolder() {
    }
    private static class InnerClassHold{
        private static final InnerClassHolder INSTANCE = new InnerClassHolder();
    }
    public static InnerClassHolder getInstance(){
        return InnerClassHold.INSTANCE;
    }
}
