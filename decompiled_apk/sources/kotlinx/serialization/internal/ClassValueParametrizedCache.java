package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;

@kotlin.jvm.internal.XX({"SMAP\nCaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ClassValueParametrizedCache\n+ 2 Caching.kt\nkotlinx/serialization/internal/ClassValueReferences\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Caching.kt\nkotlinx/serialization/internal/ParametrizedCacheEntry\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n*L\n1#1,206:1\n80#2,3:207\n85#2:211\n1#3:210\n1#3:221\n199#4:212\n200#4:217\n201#4:220\n1549#5:213\n1620#5,3:214\n72#6,2:218\n*S KotlinDebug\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ClassValueParametrizedCache\n*L\n119#1:207,3\n119#1:211\n119#1:210\n120#1:221\n120#1:212\n120#1:217\n120#1:220\n120#1:213\n120#1:214,3\n120#1:218,2\n*E\n"})
/* loaded from: classes6.dex */
public final class ClassValueParametrizedCache<T> implements XX0xXo<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final ClassValueReferences<xxIO<T>> f30614II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Oox.x0xO0oo<kotlin.reflect.oxoX<Object>, List<? extends kotlin.reflect.Oxx0xo>, kotlinx.serialization.Oxx0IOOO<T>> f30615oIX0oI;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueParametrizedCache(@OXOo.OOXIXo Oox.x0xO0oo<? super kotlin.reflect.oxoX<Object>, ? super List<? extends kotlin.reflect.Oxx0xo>, ? extends kotlinx.serialization.Oxx0IOOO<T>> compute) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(compute, "compute");
        this.f30615oIX0oI = compute;
        this.f30614II0xO0 = new ClassValueReferences<>();
    }

    @Override // kotlinx.serialization.internal.XX0xXo
    @OXOo.OOXIXo
    public Object oIX0oI(@OXOo.OOXIXo kotlin.reflect.oxoX<Object> key, @OXOo.OOXIXo List<? extends kotlin.reflect.Oxx0xo> types) {
        Object obj;
        Object m287constructorimpl;
        kotlin.jvm.internal.IIX0o.x0xO0oo(key, "key");
        kotlin.jvm.internal.IIX0o.x0xO0oo(types, "types");
        obj = this.f30614II0xO0.get(XO0OX.II0xO0.X0o0xo(key));
        kotlin.jvm.internal.IIX0o.oO(obj, "get(...)");
        I0oOIX i0oOIX = (I0oOIX) obj;
        T t = i0oOIX.f30623oIX0oI.get();
        if (t == null) {
            t = (T) i0oOIX.oIX0oI(new Oox.oIX0oI<T>() { // from class: kotlinx.serialization.internal.ClassValueParametrizedCache$get-gIAlu-s$$inlined$getOrSet$1
                @Override // Oox.oIX0oI
                public final T invoke() {
                    return (T) new xxIO();
                }
            });
        }
        xxIO xxio = t;
        List<? extends kotlin.reflect.Oxx0xo> list = types;
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new I0oOoX((kotlin.reflect.Oxx0xo) it.next()));
        }
        ConcurrentHashMap oIX0oI2 = xxIO.oIX0oI(xxio);
        Object obj2 = oIX0oI2.get(arrayList);
        if (obj2 == null) {
            try {
                Result.oIX0oI oix0oi = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(this.f30615oIX0oI.invoke(key, types));
            } catch (Throwable th) {
                Result.oIX0oI oix0oi2 = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th));
            }
            Result m286boximpl = Result.m286boximpl(m287constructorimpl);
            Object putIfAbsent = oIX0oI2.putIfAbsent(arrayList, m286boximpl);
            if (putIfAbsent == null) {
                obj2 = m286boximpl;
            } else {
                obj2 = putIfAbsent;
            }
        }
        kotlin.jvm.internal.IIX0o.oO(obj2, "getOrPut(...)");
        return ((Result) obj2).m296unboximpl();
    }
}
