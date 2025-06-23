package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public abstract class II0xO0<T> implements II0XooXoX<T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final AtomicReference<II0xO0<T>> f32683oIX0oI = new AtomicReference<>();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final AtomicReference<T> f32682II0xO0 = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.II0XooXoX
    public final T get() throws ConcurrentException {
        while (true) {
            T t = this.f32682II0xO0.get();
            if (t == null) {
                if (androidx.lifecycle.Oxx0IOOO.oIX0oI(this.f32683oIX0oI, null, this)) {
                    this.f32682II0xO0.set(oIX0oI());
                }
            } else {
                return t;
            }
        }
    }

    public abstract T oIX0oI() throws ConcurrentException;
}
