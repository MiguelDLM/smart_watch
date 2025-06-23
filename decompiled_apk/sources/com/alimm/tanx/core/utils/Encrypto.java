package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class Encrypto implements NotConfused {
    static {
        System.loadLibrary("encrypto");
    }

    public static native String encrypt();
}
