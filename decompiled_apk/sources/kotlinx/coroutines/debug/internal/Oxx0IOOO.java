package kotlinx.coroutines.debug.internal;

import OXOo.oOoXoXO;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public final class Oxx0IOOO<T> extends WeakReference<T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @XO0OX.XO
    public final int f29947oIX0oI;

    public Oxx0IOOO(T t, @oOoXoXO ReferenceQueue<T> referenceQueue) {
        super(t, referenceQueue);
        int i;
        if (t != null) {
            i = t.hashCode();
        } else {
            i = 0;
        }
        this.f29947oIX0oI = i;
    }
}
