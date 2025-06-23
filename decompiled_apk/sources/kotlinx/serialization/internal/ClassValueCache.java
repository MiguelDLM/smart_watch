package kotlinx.serialization.internal;

@kotlin.jvm.internal.XX({"SMAP\nCaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ClassValueCache\n+ 2 Caching.kt\nkotlinx/serialization/internal/ClassValueReferences\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n80#2,3:207\n85#2:211\n1#3:210\n*S KotlinDebug\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ClassValueCache\n*L\n52#1:207,3\n52#1:211\n52#1:210\n*E\n"})
/* loaded from: classes6.dex */
public final class ClassValueCache<T> implements O0X<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ClassValueReferences<ooOOo0oXI<T>> f30612II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<T>> f30613oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueCache(@OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.reflect.oxoX<?>, ? extends kotlinx.serialization.Oxx0IOOO<T>> compute) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(compute, "compute");
        this.f30613oIX0oI = compute;
        this.f30612II0xO0 = new ClassValueReferences<>();
    }

    @OXOo.OOXIXo
    public final Oox.oOoXoXO<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<T>> II0xO0() {
        return this.f30613oIX0oI;
    }

    @Override // kotlinx.serialization.internal.O0X
    @OXOo.oOoXoXO
    public kotlinx.serialization.Oxx0IOOO<T> oIX0oI(@OXOo.OOXIXo final kotlin.reflect.oxoX<Object> key) {
        Object obj;
        kotlin.jvm.internal.IIX0o.x0xO0oo(key, "key");
        obj = this.f30612II0xO0.get(XO0OX.II0xO0.X0o0xo(key));
        kotlin.jvm.internal.IIX0o.oO(obj, "get(...)");
        I0oOIX i0oOIX = (I0oOIX) obj;
        T t = i0oOIX.f30623oIX0oI.get();
        if (t == null) {
            t = (T) i0oOIX.oIX0oI(new Oox.oIX0oI<T>() { // from class: kotlinx.serialization.internal.ClassValueCache$get$$inlined$getOrSet$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public final T invoke() {
                    return (T) new ooOOo0oXI(ClassValueCache.this.II0xO0().invoke(key));
                }
            });
        }
        return t.f30738oIX0oI;
    }
}
