package com.google.android.exoplayer2;

import android.annotation.SuppressLint;

/* loaded from: classes9.dex */
public final /* synthetic */ class x0OxxIOxX {
    @SuppressLint({"WrongConstant"})
    public static int I0Io(int i, int i2, int i3, int i4, int i5) {
        return i | i2 | i3 | i4 | i5;
    }

    @SuppressLint({"WrongConstant"})
    public static int II0XooXoX(int i) {
        return i & 32;
    }

    public static int II0xO0(int i, int i2, int i3) {
        return I0Io(i, i2, i3, 0, 128);
    }

    @SuppressLint({"WrongConstant"})
    public static int Oxx0IOOO(int i) {
        return i & 64;
    }

    @SuppressLint({"WrongConstant"})
    public static int X0o0xo(int i) {
        return i & RendererCapabilities.MODE_SUPPORT_MASK;
    }

    @SuppressLint({"WrongConstant"})
    public static int XO(int i) {
        return i & 7;
    }

    public static int oIX0oI(int i) {
        return II0xO0(i, 0, 0);
    }

    @SuppressLint({"WrongConstant"})
    public static int oxoX(int i) {
        return i & 24;
    }
}
