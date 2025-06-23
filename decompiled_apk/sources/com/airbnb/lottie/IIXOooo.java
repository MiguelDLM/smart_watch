package com.airbnb.lottie;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class IIXOooo {

    /* renamed from: I0Io, reason: collision with root package name */
    @Nullable
    public final xoIox f4767I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @Nullable
    public final LottieAnimationView f4768II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Map<String, String> f4769oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f4770oxoX;

    @VisibleForTesting
    public IIXOooo() {
        this.f4769oIX0oI = new HashMap();
        this.f4770oxoX = true;
        this.f4768II0xO0 = null;
        this.f4767I0Io = null;
    }

    public final void I0Io() {
        LottieAnimationView lottieAnimationView = this.f4768II0xO0;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        xoIox xoiox = this.f4767I0Io;
        if (xoiox != null) {
            xoiox.invalidateSelf();
        }
    }

    public final String II0xO0(String str) {
        if (this.f4770oxoX && this.f4769oIX0oI.containsKey(str)) {
            return this.f4769oIX0oI.get(str);
        }
        String oIX0oI2 = oIX0oI(str);
        if (this.f4770oxoX) {
            this.f4769oIX0oI.put(str, oIX0oI2);
        }
        return oIX0oI2;
    }

    public void Oxx0IOOO(String str, String str2) {
        this.f4769oIX0oI.put(str, str2);
        I0Io();
    }

    public void X0o0xo(String str) {
        this.f4769oIX0oI.remove(str);
        I0Io();
    }

    public void XO(boolean z) {
        this.f4770oxoX = z;
    }

    public final String oIX0oI(String str) {
        return str;
    }

    public void oxoX() {
        this.f4769oIX0oI.clear();
        I0Io();
    }

    public IIXOooo(LottieAnimationView lottieAnimationView) {
        this.f4769oIX0oI = new HashMap();
        this.f4770oxoX = true;
        this.f4768II0xO0 = lottieAnimationView;
        this.f4767I0Io = null;
    }

    public IIXOooo(xoIox xoiox) {
        this.f4769oIX0oI = new HashMap();
        this.f4770oxoX = true;
        this.f4767I0Io = xoiox;
        this.f4768II0xO0 = null;
    }
}
