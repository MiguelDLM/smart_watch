package com.baidu.mshield.core;

import java.util.Random;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f6376a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] a() {
        try {
            char[] charArray = f6376a.toCharArray();
            char[] cArr = new char[16];
            for (int i = 0; i < 16; i++) {
                cArr[i] = charArray[new Random().nextInt(62)];
            }
            return new String(cArr).getBytes();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return new byte[0];
        }
    }
}
