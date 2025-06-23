package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@kotlin.jvm.internal.XX({"SMAP\n_Sets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n857#2,2:140\n847#2,2:142\n1#3:144\n*S KotlinDebug\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n*L\n28#1:140,2\n52#1:142,2\n*E\n"})
/* loaded from: classes6.dex */
public class XoI0Ixx0 extends Xo0 {
    @xx0o0O.XO
    public static final <T> Set<T> IIX0o(Set<? extends T> set, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        return xxX(set, t);
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> O0xOxO(@OXOo.OOXIXo Set<? extends T> set, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        OxI.O0X(linkedHashSet, elements);
        return linkedHashSet;
    }

    @OXOo.OOXIXo
    public static <T> Set<T> OxI(@OXOo.OOXIXo Set<? extends T> set, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(OI0.xoIox(set.size()));
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && kotlin.jvm.internal.IIX0o.Oxx0IOOO(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> X0IIOO(@OXOo.OOXIXo Set<? extends T> set, @OXOo.OOXIXo T[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        OxI.IIX0(linkedHashSet, elements);
        return linkedHashSet;
    }

    @xx0o0O.XO
    public static final <T> Set<T> XI0IXoo(Set<? extends T> set, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        return OxI(set, t);
    }

    @OXOo.OOXIXo
    public static <T> Set<T> XIxXXX0x0(@OXOo.OOXIXo Set<? extends T> set, @OXOo.OOXIXo Iterable<? extends T> elements) {
        int size;
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Integer xXOx2 = OxxIIOOXO.xXOx(elements);
        if (xXOx2 != null) {
            size = set.size() + xXOx2.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(OI0.xoIox(size));
        linkedHashSet.addAll(set);
        OxI.XIo0oOXIx(linkedHashSet, elements);
        return linkedHashSet;
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> XxX0x0xxx(@OXOo.OOXIXo Set<? extends T> set, @OXOo.OOXIXo kotlin.sequences.ooOOo0oXI<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(OI0.xoIox(set.size() * 2));
        linkedHashSet.addAll(set);
        OxI.Ioxxx(linkedHashSet, elements);
        return linkedHashSet;
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> o00(@OXOo.OOXIXo Set<? extends T> set, @OXOo.OOXIXo Iterable<? extends T> elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        Collection<?> XX0xXo2 = OxI.XX0xXo(elements);
        if (XX0xXo2.isEmpty()) {
            return CollectionsKt___CollectionsKt.XxI0(set);
        }
        if (XX0xXo2 instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!XX0xXo2.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(XX0xXo2);
        return linkedHashSet2;
    }

    @OXOo.OOXIXo
    public static final <T> Set<T> xXxxox0I(@OXOo.OOXIXo Set<? extends T> set, @OXOo.OOXIXo T[] elements) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(OI0.xoIox(set.size() + elements.length));
        linkedHashSet.addAll(set);
        OxI.xxIO(linkedHashSet, elements);
        return linkedHashSet;
    }

    @OXOo.OOXIXo
    public static <T> Set<T> xxX(@OXOo.OOXIXo Set<? extends T> set, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(OI0.xoIox(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }
}
