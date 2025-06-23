package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;

@kotlin.jvm.internal.XX({"SMAP\nCaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ConcurrentHashMapParametrizedCache\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Caching.kt\nkotlinx/serialization/internal/ParametrizedCacheEntry\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,206:1\n72#2,2:207\n72#2,2:216\n1#3:209\n1#3:219\n199#4:210\n200#4:215\n201#4:218\n1549#5:211\n1620#5,3:212\n*S KotlinDebug\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ConcurrentHashMapParametrizedCache\n*L\n145#1:207,2\n146#1:216,2\n145#1:209\n146#1:219\n146#1:210\n146#1:215\n146#1:218\n146#1:211\n146#1:212,3\n*E\n"})
/* loaded from: classes6.dex */
public final class OxI<T> implements XX0xXo<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ConcurrentHashMap<Class<?>, xxIO<T>> f30660II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<kotlin.reflect.oxoX<Object>, List<? extends kotlin.reflect.Oxx0xo>, kotlinx.serialization.Oxx0IOOO<T>> f30661oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public OxI(@OXOo.OOXIXo Oox.x0xO0oo<? super kotlin.reflect.oxoX<Object>, ? super List<? extends kotlin.reflect.Oxx0xo>, ? extends kotlinx.serialization.Oxx0IOOO<T>> compute) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(compute, "compute");
        this.f30661oIX0oI = compute;
        this.f30660II0xO0 = new ConcurrentHashMap<>();
    }

    @Override // kotlinx.serialization.internal.XX0xXo
    @OXOo.OOXIXo
    public Object oIX0oI(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> key, @OXOo.OOXIXo List<? extends kotlin.reflect.Oxx0xo> types) {
        Object m287constructorimpl;
        xxIO<T> putIfAbsent;
        kotlin.jvm.internal.IIX0o.x0xO0oo(key, "key");
        kotlin.jvm.internal.IIX0o.x0xO0oo(types, "types");
        ConcurrentHashMap<Class<?>, xxIO<T>> concurrentHashMap = this.f30660II0xO0;
        Class<?> X0o0xo2 = XO0OX.II0xO0.X0o0xo(key);
        xxIO<T> xxio = concurrentHashMap.get(X0o0xo2);
        if (xxio == null && (putIfAbsent = concurrentHashMap.putIfAbsent(X0o0xo2, (xxio = new xxIO<>()))) != null) {
            xxio = putIfAbsent;
        }
        xxIO<T> xxio2 = xxio;
        List<? extends kotlin.reflect.Oxx0xo> list = types;
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new I0oOoX((kotlin.reflect.Oxx0xo) it.next()));
        }
        ConcurrentHashMap oIX0oI2 = xxIO.oIX0oI(xxio2);
        Object obj = oIX0oI2.get(arrayList);
        if (obj == null) {
            try {
                Result.oIX0oI oix0oi = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(this.f30661oIX0oI.invoke(key, types));
            } catch (Throwable th) {
                Result.oIX0oI oix0oi2 = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th));
            }
            Result m286boximpl = Result.m286boximpl(m287constructorimpl);
            Object putIfAbsent2 = oIX0oI2.putIfAbsent(arrayList, m286boximpl);
            if (putIfAbsent2 == null) {
                obj = m286boximpl;
            } else {
                obj = putIfAbsent2;
            }
        }
        kotlin.jvm.internal.IIX0o.oO(obj, "getOrPut(...)");
        return ((Result) obj).m296unboximpl();
    }
}
