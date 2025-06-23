package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@kotlin.jvm.internal.XX({"SMAP\nGrouping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n1#1,291:1\n80#1,6:292\n53#1:298\n80#1,6:299\n80#1,6:305\n53#1:311\n80#1,6:312\n80#1,6:318\n53#1:324\n80#1,6:325\n80#1,6:331\n189#1:337\n80#1,6:338\n*S KotlinDebug\n*F\n+ 1 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n*L\n53#1:292,6\n112#1:298\n112#1:299,6\n143#1:305,6\n164#1:311\n164#1:312,6\n189#1:318,6\n211#1:324\n211#1:325,6\n239#1:331,6\n257#1:337\n257#1:338,6\n*E\n"})
/* loaded from: classes6.dex */
public class ooXIXxIX extends IIX0o {
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K, R> Map<K, R> I0Io(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx, @OXOo.OOXIXo Oox.Oxx0xo<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            ?? next = II0xO02.next();
            Object oIX0oI2 = xxX0x0xxx.oIX0oI(next);
            I00O.II0xO0 iI0xO0 = (Object) linkedHashMap.get(oIX0oI2);
            if (iI0xO0 == null && !linkedHashMap.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            linkedHashMap.put(oIX0oI2, operation.invoke(oIX0oI2, iI0xO0, next, Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M II0XooXoX(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.x0xO0oo<? super K, ? super T, ? extends R> initialValueSelector, @OXOo.OOXIXo Oox.IXxxXO<? super K, ? super R, ? super T, ? extends R> operation) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<T> II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            ?? next = II0xO02.next();
            Object oIX0oI2 = xxX0x0xxx.oIX0oI(next);
            R r = (Object) destination.get(oIX0oI2);
            if (r == null && !destination.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                r = initialValueSelector.invoke(oIX0oI2, next);
            }
            destination.put(oIX0oI2, operation.invoke(oIX0oI2, r, next));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <S, T extends S, K, M extends Map<? super K, S>> M OOXIXo(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.IXxxXO<? super K, ? super S, ? super T, ? extends S> operation) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            S s = (Object) II0xO02.next();
            Object oIX0oI2 = xxX0x0xxx.oIX0oI(s);
            I00O.II0xO0 iI0xO0 = (Object) destination.get(oIX0oI2);
            if (iI0xO0 == null && !destination.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                s = operation.invoke(oIX0oI2, iI0xO0, s);
            }
            destination.put(oIX0oI2, s);
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K, R> Map<K, R> Oxx0IOOO(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            ?? next = II0xO02.next();
            K oIX0oI2 = xxX0x0xxx.oIX0oI(next);
            I00O.II0xO0 iI0xO0 = (Object) linkedHashMap.get(oIX0oI2);
            if (iI0xO0 == null && !linkedHashMap.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                iI0xO0 = (Object) r;
            }
            linkedHashMap.put(oIX0oI2, operation.invoke(iI0xO0, next));
        }
        return linkedHashMap;
    }

    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K, M extends Map<? super K, Integer>> M X0o0xo(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx, @OXOo.OOXIXo M destination) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        Iterator<T> II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            K oIX0oI2 = xxX0x0xxx.oIX0oI(II0xO02.next());
            Object obj = destination.get(oIX0oI2);
            if (obj == null && !destination.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                obj = 0;
            }
            destination.put(oIX0oI2, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K, R> Map<K, R> XO(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx, @OXOo.OOXIXo Oox.x0xO0oo<? super K, ? super T, ? extends R> initialValueSelector, @OXOo.OOXIXo Oox.IXxxXO<? super K, ? super R, ? super T, ? extends R> operation) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            ?? next = II0xO02.next();
            Object oIX0oI2 = xxX0x0xxx.oIX0oI(next);
            R r = (Object) linkedHashMap.get(oIX0oI2);
            if (r == null && !linkedHashMap.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                r = initialValueSelector.invoke(oIX0oI2, next);
            }
            linkedHashMap.put(oIX0oI2, operation.invoke(oIX0oI2, r, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M oxoX(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx, @OXOo.OOXIXo M destination, @OXOo.OOXIXo Oox.Oxx0xo<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<T> II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            ?? next = II0xO02.next();
            Object oIX0oI2 = xxX0x0xxx.oIX0oI(next);
            I00O.II0xO0 iI0xO0 = (Object) destination.get(oIX0oI2);
            if (iI0xO0 == null && !destination.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            destination.put(oIX0oI2, operation.invoke(oIX0oI2, iI0xO0, next, Boolean.valueOf(z)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <S, T extends S, K> Map<K, S> xoIox(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx, @OXOo.OOXIXo Oox.IXxxXO<? super K, ? super S, ? super T, ? extends S> operation) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            S s = (Object) II0xO02.next();
            Object oIX0oI2 = xxX0x0xxx.oIX0oI(s);
            I00O.II0xO0 iI0xO0 = (Object) linkedHashMap.get(oIX0oI2);
            if (iI0xO0 == null && !linkedHashMap.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                s = operation.invoke(oIX0oI2, iI0xO0, s);
            }
            linkedHashMap.put(oIX0oI2, s);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @OXOo.OOXIXo
    @kotlin.oxxXoxO(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M xxIXOIIO(@OXOo.OOXIXo XxX0x0xxx<T, ? extends K> xxX0x0xxx, @OXOo.OOXIXo M destination, R r, @OXOo.OOXIXo Oox.x0xO0oo<? super R, ? super T, ? extends R> operation) {
        boolean z;
        kotlin.jvm.internal.IIX0o.x0xO0oo(xxX0x0xxx, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(destination, "destination");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        Iterator<T> II0xO02 = xxX0x0xxx.II0xO0();
        while (II0xO02.hasNext()) {
            ?? next = II0xO02.next();
            K oIX0oI2 = xxX0x0xxx.oIX0oI(next);
            I00O.II0xO0 iI0xO0 = (Object) destination.get(oIX0oI2);
            if (iI0xO0 == null && !destination.containsKey(oIX0oI2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                iI0xO0 = (Object) r;
            }
            destination.put(oIX0oI2, operation.invoke(iI0xO0, next));
        }
        return destination;
    }
}
