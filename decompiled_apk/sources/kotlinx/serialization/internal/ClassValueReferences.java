package kotlinx.serialization.internal;

@IoIOOxIIo
@kotlin.jvm.internal.XX({"SMAP\nCaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ClassValueReferences\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n1#2:207\n*E\n"})
/* loaded from: classes6.dex */
public final class ClassValueReferences<T> extends ClassValue<I0oOIX<T>> {
    public final T II0xO0(@OXOo.OOXIXo Class<?> key, @OXOo.OOXIXo final Oox.oIX0oI<? extends T> factory) {
        Object obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(key, "key");
        kotlin.jvm.internal.IIX0o.x0xO0oo(factory, "factory");
        obj = get(key);
        kotlin.jvm.internal.IIX0o.oO(obj, "get(...)");
        I0oOIX i0oOIX = (I0oOIX) obj;
        T t = i0oOIX.f30623oIX0oI.get();
        if (t != null) {
            return t;
        }
        return (T) i0oOIX.oIX0oI(new Oox.oIX0oI<T>() { // from class: kotlinx.serialization.internal.ClassValueReferences$getOrSet$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public final T invoke() {
                return factory.invoke();
            }
        });
    }

    @Override // java.lang.ClassValue
    @OXOo.OOXIXo
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public I0oOIX<T> computeValue(@OXOo.OOXIXo Class<?> type) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(type, "type");
        return new I0oOIX<>();
    }
}
