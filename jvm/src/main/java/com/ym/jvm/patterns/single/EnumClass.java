package com.ym.jvm.patterns.single;

public enum  EnumClass {
    INSTANCE;
    public static EnumClass getInstance(){
        return INSTANCE;
    }
}
