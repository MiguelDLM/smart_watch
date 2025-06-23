package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.CollectionNavType;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavTypeConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$DoubleListType$1\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,577:1\n37#2,2:578\n37#2,2:580\n1549#3:582\n1620#3,3:583\n*S KotlinDebug\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$DoubleListType$1\n*L\n460#1:578,2\n461#1:580,2\n466#1:582\n466#1:583,3\n*E\n"})
public final class InternalNavType$DoubleListType$1 extends CollectionNavType<List<? extends Double>> {
    public InternalNavType$DoubleListType$1() {
        super(true);
    }

    public String getName() {
        return "List<Double>";
    }

    public List<Double> emptyCollection() {
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    public List<Double> get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        Object obj = bundle.get(str);
        double[] dArr = obj instanceof double[] ? (double[]) obj : null;
        if (dArr != null) {
            return ArraysKt___ArraysKt.OXIIooO0(dArr);
        }
        return null;
    }

    public void put(Bundle bundle, String str, List<Double> list) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putDoubleArray(str, list != null ? CollectionsKt___CollectionsKt.XxOOoxOO(list) : null);
    }

    public List<String> serializeAsValues(List<Double> list) {
        if (list == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Iterable<Number> iterable = list;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        for (Number doubleValue : iterable) {
            arrayList.add(String.valueOf(doubleValue.doubleValue()));
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean valueEquals(java.util.List<java.lang.Double> r4, java.util.List<java.lang.Double> r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L_0x000f
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Double[] r2 = new java.lang.Double[r1]
            java.lang.Object[] r4 = r4.toArray(r2)
            java.lang.Double[] r4 = (java.lang.Double[]) r4
            goto L_0x0010
        L_0x000f:
            r4 = r0
        L_0x0010:
            if (r5 == 0) goto L_0x001d
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Double[] r0 = new java.lang.Double[r1]
            java.lang.Object[] r5 = r5.toArray(r0)
            r0 = r5
            java.lang.Double[] r0 = (java.lang.Double[]) r0
        L_0x001d:
            boolean r4 = kotlin.collections.oOoXoXO.Oxx0IOOO(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.serialization.InternalNavType$DoubleListType$1.valueEquals(java.util.List, java.util.List):boolean");
    }

    public List<Double> parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return oI0IIXIo.OOXIXo(InternalNavType.INSTANCE.getDoubleType().parseValue(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.o0xIIX0(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Double> parseValue(java.lang.String r2, java.util.List<java.lang.Double> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            if (r3 == 0) goto L_0x0015
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r0 = r1.parseValue((java.lang.String) r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r3 = kotlin.collections.CollectionsKt___CollectionsKt.o0xIIX0(r3, r0)
            if (r3 != 0) goto L_0x0019
        L_0x0015:
            java.util.List r3 = r1.parseValue((java.lang.String) r2)
        L_0x0019:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.serialization.InternalNavType$DoubleListType$1.parseValue(java.lang.String, java.util.List):java.util.List");
    }
}
