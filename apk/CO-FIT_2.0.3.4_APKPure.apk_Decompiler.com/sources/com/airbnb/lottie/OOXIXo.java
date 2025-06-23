package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public class OOXIXo {

    /* renamed from: I0Io  reason: collision with root package name */
    public final String f800I0Io;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final int f801II0xO0;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final String f802X0o0xo;
    @Nullable

    /* renamed from: XO  reason: collision with root package name */
    public Bitmap f803XO;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final int f804oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final String f805oxoX;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public OOXIXo(int i, int i2, String str, String str2, String str3) {
        this.f804oIX0oI = i;
        this.f801II0xO0 = i2;
        this.f800I0Io = str;
        this.f805oxoX = str2;
        this.f802X0o0xo = str3;
    }

    public String I0Io() {
        return this.f805oxoX;
    }

    public void II0XooXoX(@Nullable Bitmap bitmap) {
        this.f803XO = bitmap;
    }

    public String II0xO0() {
        return this.f802X0o0xo;
    }

    public boolean Oxx0IOOO() {
        if (this.f803XO != null || (this.f805oxoX.startsWith("data:") && this.f805oxoX.indexOf("base64,") > 0)) {
            return true;
        }
        return false;
    }

    public String X0o0xo() {
        return this.f800I0Io;
    }

    public int XO() {
        return this.f804oIX0oI;
    }

    @Nullable
    public Bitmap oIX0oI() {
        return this.f803XO;
    }

    public int oxoX() {
        return this.f801II0xO0;
    }
}
