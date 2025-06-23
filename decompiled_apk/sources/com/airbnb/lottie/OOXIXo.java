package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public class OOXIXo {

    /* renamed from: I0Io, reason: collision with root package name */
    public final String f4794I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f4795II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final String f4796X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @Nullable
    public Bitmap f4797XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f4798oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final String f4799oxoX;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public OOXIXo(int i, int i2, String str, String str2, String str3) {
        this.f4798oIX0oI = i;
        this.f4795II0xO0 = i2;
        this.f4794I0Io = str;
        this.f4799oxoX = str2;
        this.f4796X0o0xo = str3;
    }

    public String I0Io() {
        return this.f4799oxoX;
    }

    public void II0XooXoX(@Nullable Bitmap bitmap) {
        this.f4797XO = bitmap;
    }

    public String II0xO0() {
        return this.f4796X0o0xo;
    }

    public boolean Oxx0IOOO() {
        if (this.f4797XO == null && (!this.f4799oxoX.startsWith("data:") || this.f4799oxoX.indexOf("base64,") <= 0)) {
            return false;
        }
        return true;
    }

    public String X0o0xo() {
        return this.f4794I0Io;
    }

    public int XO() {
        return this.f4798oIX0oI;
    }

    @Nullable
    public Bitmap oIX0oI() {
        return this.f4797XO;
    }

    public int oxoX() {
        return this.f4795II0xO0;
    }
}
