package com.airbnb.lottie;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

public class IIXOooo {
    @Nullable

    /* renamed from: I0Io  reason: collision with root package name */
    public final xoIox f773I0Io;
    @Nullable

    /* renamed from: II0xO0  reason: collision with root package name */
    public final LottieAnimationView f774II0xO0;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final Map<String, String> f775oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public boolean f776oxoX;

    @VisibleForTesting
    public IIXOooo() {
        this.f775oIX0oI = new HashMap();
        this.f776oxoX = true;
        this.f774II0xO0 = null;
        this.f773I0Io = null;
    }

    public final void I0Io() {
        LottieAnimationView lottieAnimationView = this.f774II0xO0;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        xoIox xoiox = this.f773I0Io;
        if (xoiox != null) {
            xoiox.invalidateSelf();
        }
    }

    public final String II0xO0(String str) {
        if (this.f776oxoX && this.f775oIX0oI.containsKey(str)) {
            return this.f775oIX0oI.get(str);
        }
        String oIX0oI2 = oIX0oI(str);
        if (this.f776oxoX) {
            this.f775oIX0oI.put(str, oIX0oI2);
        }
        return oIX0oI2;
    }

    public void Oxx0IOOO(String str, String str2) {
        this.f775oIX0oI.put(str, str2);
        I0Io();
    }

    public void X0o0xo(String str) {
        this.f775oIX0oI.remove(str);
        I0Io();
    }

    public void XO(boolean z) {
        this.f776oxoX = z;
    }

    public final String oIX0oI(String str) {
        return str;
    }

    public void oxoX() {
        this.f775oIX0oI.clear();
        I0Io();
    }

    public IIXOooo(LottieAnimationView lottieAnimationView) {
        this.f775oIX0oI = new HashMap();
        this.f776oxoX = true;
        this.f774II0xO0 = lottieAnimationView;
        this.f773I0Io = null;
    }

    public IIXOooo(xoIox xoiox) {
        this.f775oIX0oI = new HashMap();
        this.f776oxoX = true;
        this.f773I0Io = xoiox;
        this.f774II0xO0 = null;
    }
}
