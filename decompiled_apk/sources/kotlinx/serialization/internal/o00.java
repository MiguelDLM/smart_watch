package kotlinx.serialization.internal;

import java.util.concurrent.ConcurrentHashMap;

@kotlin.jvm.internal.XX({"SMAP\nCaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ConcurrentHashMapCache\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n72#2,2:207\n1#3:209\n*S KotlinDebug\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ConcurrentHashMapCache\n*L\n133#1:207,2\n133#1:209\n*E\n"})
/* loaded from: classes6.dex */
public final class o00<T> implements O0X<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ConcurrentHashMap<Class<?>, ooOOo0oXI<T>> f30723II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.oOoXoXO<kotlin.reflect.oxoX<?>, kotlinx.serialization.Oxx0IOOO<T>> f30724oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public o00(@OXOo.OOXIXo Oox.oOoXoXO<? super kotlin.reflect.oxoX<?>, ? extends kotlinx.serialization.Oxx0IOOO<T>> compute) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(compute, "compute");
        this.f30724oIX0oI = compute;
        this.f30723II0xO0 = new ConcurrentHashMap<>();
    }

    @Override // kotlinx.serialization.internal.O0X
    @OXOo.oOoXoXO
    public kotlinx.serialization.Oxx0IOOO<T> oIX0oI(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> key) {
        ooOOo0oXI<T> putIfAbsent;
        kotlin.jvm.internal.IIX0o.x0xO0oo(key, "key");
        ConcurrentHashMap<Class<?>, ooOOo0oXI<T>> concurrentHashMap = this.f30723II0xO0;
        Class<?> X0o0xo2 = XO0OX.II0xO0.X0o0xo(key);
        ooOOo0oXI<T> ooooo0oxi = concurrentHashMap.get(X0o0xo2);
        if (ooooo0oxi == null && (putIfAbsent = concurrentHashMap.putIfAbsent(X0o0xo2, (ooooo0oxi = new ooOOo0oXI<>(this.f30724oIX0oI.invoke(key))))) != null) {
            ooooo0oxi = putIfAbsent;
        }
        return ooooo0oxi.f30738oIX0oI;
    }
}
