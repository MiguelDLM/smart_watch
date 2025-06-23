package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Ref;

@kotlin.jvm.internal.XX({"SMAP\nGroupingJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n+ 2 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n143#2:53\n80#2,4:54\n85#2:59\n1#3:58\n1855#4,2:60\n*S KotlinDebug\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n*L\n22#1:53\n22#1:54,4\n22#1:59\n48#1:60,2\n*E\n"})
/* loaded from: classes6.dex */
public class IIX0o {
    @xx0o0O.XO
    @kotlin.o0
    public static final <K, V, R> Map<K, R> II0xO0(Map<K, V> map, Oox.oOoXoXO<? super Map.Entry<? extends K, ? extends V>, ? extends R> f) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(map, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(f, "f");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kotlin.jvm.internal.IIX0o.x0XOIxOo(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            kotlin.jvm.internal.XoX.ooOOo0oXI(entry).setValue(f.invoke(entry));
        }
        return kotlin.jvm.internal.XoX.OOXIXo(map);
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K> Map<K, Integer> oIX0oI(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            K oIX0oI2 = xxX0x0xxx.oIX0oI(II0xO02.next());
            Object obj = linkedHashMap.get(oIX0oI2);
            if (obj == null && !linkedHashMap.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                obj = new Ref.IntRef();
            }
            Ref.IntRef intRef = (Ref.IntRef) obj;
            intRef.element++;
            linkedHashMap.put(oIX0oI2, intRef);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            kotlin.jvm.internal.IIX0o.x0XOIxOo(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            kotlin.jvm.internal.XoX.ooOOo0oXI(entry).setValue(Integer.valueOf(((Ref.IntRef) entry.getValue()).element));
        }
        return kotlin.jvm.internal.XoX.OOXIXo(linkedHashMap);
    }
}
