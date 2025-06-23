package org.apache.commons.lang3.concurrent;

/* loaded from: classes6.dex */
public abstract class oOoXoXO<T> implements II0XooXoX<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final Object f32712II0xO0 = new Object();

    /* renamed from: oIX0oI, reason: collision with root package name */
    public volatile T f32713oIX0oI = (T) f32712II0xO0;

    @Override // org.apache.commons.lang3.concurrent.II0XooXoX
    public T get() throws ConcurrentException {
        T t = this.f32713oIX0oI;
        Object obj = f32712II0xO0;
        if (t == obj) {
            synchronized (this) {
                try {
                    t = this.f32713oIX0oI;
                    if (t == obj) {
                        t = oIX0oI();
                        this.f32713oIX0oI = t;
                    }
                } finally {
                }
            }
        }
        return t;
    }

    public abstract T oIX0oI() throws ConcurrentException;
}
