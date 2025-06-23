package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public abstract class oIX0oI<T> implements II0XooXoX<T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final AtomicReference<T> f32707oIX0oI = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.II0XooXoX
    public T get() throws ConcurrentException {
        T t = this.f32707oIX0oI.get();
        if (t == null) {
            T oIX0oI2 = oIX0oI();
            if (!androidx.lifecycle.Oxx0IOOO.oIX0oI(this.f32707oIX0oI, null, oIX0oI2)) {
                return this.f32707oIX0oI.get();
            }
            return oIX0oI2;
        }
        return t;
    }

    public abstract T oIX0oI() throws ConcurrentException;
}
