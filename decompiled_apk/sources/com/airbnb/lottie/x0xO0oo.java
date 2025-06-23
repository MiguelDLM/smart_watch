package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class x0xO0oo<V> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @Nullable
    public final Throwable f5069II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @Nullable
    public final V f5070oIX0oI;

    public x0xO0oo(V v) {
        this.f5070oIX0oI = v;
        this.f5069II0xO0 = null;
    }

    @Nullable
    public V II0xO0() {
        return this.f5070oIX0oI;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0xO0oo)) {
            return false;
        }
        x0xO0oo x0xo0oo = (x0xO0oo) obj;
        if (II0xO0() != null && II0xO0().equals(x0xo0oo.II0xO0())) {
            return true;
        }
        if (oIX0oI() == null || x0xo0oo.oIX0oI() == null) {
            return false;
        }
        return oIX0oI().toString().equals(oIX0oI().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{II0xO0(), oIX0oI()});
    }

    @Nullable
    public Throwable oIX0oI() {
        return this.f5069II0xO0;
    }

    public x0xO0oo(Throwable th) {
        this.f5069II0xO0 = th;
        this.f5070oIX0oI = null;
    }
}
