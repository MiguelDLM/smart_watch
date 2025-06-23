package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;

@kotlin.jvm.internal.XX({"SMAP\nCaching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ParametrizedCacheEntry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n1549#2:207\n1620#2,3:208\n72#3,2:211\n1#4:213\n1#4:214\n*S KotlinDebug\n*F\n+ 1 Caching.kt\nkotlinx/serialization/internal/ParametrizedCacheEntry\n*L\n199#1:207\n199#1:208,3\n200#1:211,2\n200#1:214\n*E\n"})
/* loaded from: classes6.dex */
public final class xxIO<T> {

    /* renamed from: oIX0oI */
    @OXOo.OOXIXo
    public final ConcurrentHashMap<List<I0oOoX>, Result<kotlinx.serialization.Oxx0IOOO<T>>> f30771oIX0oI = new ConcurrentHashMap<>();

    public static final /* synthetic */ ConcurrentHashMap oIX0oI(xxIO xxio) {
        return xxio.f30771oIX0oI;
    }

    @OXOo.OOXIXo
    public final Object II0xO0(@OXOo.OOXIXo List<? extends kotlin.reflect.Oxx0xo> types, @OXOo.OOXIXo Oox.oIX0oI<? extends kotlinx.serialization.Oxx0IOOO<T>> producer) {
        Object m287constructorimpl;
        kotlin.jvm.internal.IIX0o.x0xO0oo(types, "types");
        kotlin.jvm.internal.IIX0o.x0xO0oo(producer, "producer");
        List<? extends kotlin.reflect.Oxx0xo> list = types;
        ArrayList arrayList = new ArrayList(kotlin.collections.OxxIIOOXO.xo0x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new I0oOoX((kotlin.reflect.Oxx0xo) it.next()));
        }
        ConcurrentHashMap concurrentHashMap = this.f30771oIX0oI;
        Object obj = concurrentHashMap.get(arrayList);
        if (obj == null) {
            try {
                Result.oIX0oI oix0oi = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(producer.invoke());
            } catch (Throwable th) {
                Result.oIX0oI oix0oi2 = Result.Companion;
                m287constructorimpl = Result.m287constructorimpl(kotlin.I0oOoX.oIX0oI(th));
            }
            Result m286boximpl = Result.m286boximpl(m287constructorimpl);
            Object putIfAbsent = concurrentHashMap.putIfAbsent(arrayList, m286boximpl);
            if (putIfAbsent == null) {
                obj = m286boximpl;
            } else {
                obj = putIfAbsent;
            }
        }
        kotlin.jvm.internal.IIX0o.oO(obj, "getOrPut(...)");
        return ((Result) obj).m296unboximpl();
    }
}
