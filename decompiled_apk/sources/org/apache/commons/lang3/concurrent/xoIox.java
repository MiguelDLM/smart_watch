package org.apache.commons.lang3.concurrent;

import java.util.Objects;

/* loaded from: classes6.dex */
public class xoIox<T> implements II0XooXoX<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f32733II0xO0 = "ConstantInitializer@%d [ object = %s ]";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final T f32734oIX0oI;

    public xoIox(T t) {
        this.f32734oIX0oI = t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xoIox)) {
            return false;
        }
        return Objects.equals(oIX0oI(), ((xoIox) obj).oIX0oI());
    }

    @Override // org.apache.commons.lang3.concurrent.II0XooXoX
    public T get() throws ConcurrentException {
        return oIX0oI();
    }

    public int hashCode() {
        if (oIX0oI() != null) {
            return oIX0oI().hashCode();
        }
        return 0;
    }

    public final T oIX0oI() {
        return this.f32734oIX0oI;
    }

    public String toString() {
        return String.format(f32733II0xO0, Integer.valueOf(System.identityHashCode(this)), String.valueOf(oIX0oI()));
    }
}
