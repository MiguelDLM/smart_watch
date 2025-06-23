package xoXoI;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* loaded from: classes.dex */
public class xoIox<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    @Nullable
    public T f35180I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<?, ?> f35181II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final II0xO0<T> f35182oIX0oI;

    public xoIox() {
        this.f35182oIX0oI = new II0xO0<>();
        this.f35180I0Io = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void I0Io(@Nullable x0XOIxOo.oIX0oI<?, ?> oix0oi) {
        this.f35181II0xO0 = oix0oi;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T II0xO0(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        return oIX0oI(this.f35182oIX0oI.II0XooXoX(f, f2, t, t2, f3, f4, f5));
    }

    @Nullable
    public T oIX0oI(II0xO0<T> iI0xO0) {
        return this.f35180I0Io;
    }

    public final void oxoX(@Nullable T t) {
        this.f35180I0Io = t;
        x0XOIxOo.oIX0oI<?, ?> oix0oi = this.f35181II0xO0;
        if (oix0oi != null) {
            oix0oi.OOXIXo();
        }
    }

    public xoIox(@Nullable T t) {
        this.f35182oIX0oI = new II0xO0<>();
        this.f35180I0Io = t;
    }
}
