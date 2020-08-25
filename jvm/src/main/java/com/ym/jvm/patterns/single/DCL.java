package com.ym.jvm.patterns.single;

public class DCL {
    private DCL() {//单例模式的精髓
    }
    private static volatile DCL INSTANCE;
    public static DCL getInstance(){
        if (INSTANCE == null){
            synchronized (DCL.class){
                if (INSTANCE == null){
                    INSTANCE = new DCL();
                }
            }
        }
        return INSTANCE;
    }
}
