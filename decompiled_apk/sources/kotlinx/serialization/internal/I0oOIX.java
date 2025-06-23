package kotlinx.serialization.internal;

import java.lang.ref.SoftReference;

@kotlin.jvm.internal.XX({"SMAP\nCaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/MutableSoftReference\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n1#2:207\n*E\n"})
/* loaded from: classes6.dex */
public final class I0oOIX<T> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public volatile SoftReference<T> f30623oIX0oI = new SoftReference<>(null);

    public final synchronized T oIX0oI(@OXOo.OOXIXo Oox.oIX0oI<? extends T> factory) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(factory, "factory");
        T t = this.f30623oIX0oI.get();
        if (t != null) {
            return t;
        }
        T invoke = factory.invoke();
        this.f30623oIX0oI = new SoftReference<>(invoke);
        return invoke;
    }
}
