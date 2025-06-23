package com.alimm.tanx.core.utils;

public class Encrypto implements NotConfused {
    static {
        System.loadLibrary("encrypto");
    }

    public static native String encrypt();
}
