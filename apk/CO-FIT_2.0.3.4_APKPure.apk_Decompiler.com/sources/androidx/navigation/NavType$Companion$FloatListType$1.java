package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.oI0IIXIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$FloatListType$1\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1212:1\n37#2,2:1213\n37#2,2:1215\n1549#3:1217\n1620#3,3:1218\n*S KotlinDebug\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$FloatListType$1\n*L\n674#1:1213,2\n675#1:1215,2\n680#1:1217\n680#1:1218,3\n*E\n"})
public final class NavType$Companion$FloatListType$1 extends CollectionNavType<List<? extends Float>> {
    public NavType$Companion$FloatListType$1() {
        super(true);
    }

    public String getName() {
        return "List<Float>";
    }

    public List<Float> emptyCollection() {
        return CollectionsKt__CollectionsKt.ooXIXxIX();
    }

    public List<Float> get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        float[] fArr = (float[]) bundle.get(str);
        if (fArr != null) {
            return ArraysKt___ArraysKt.X00OO00x(fArr);
        }
        return null;
    }

    public void put(Bundle bundle, String str, List<Float> list) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putFloatArray(str, list != null ? CollectionsKt___CollectionsKt.xXO0oXX(list) : null);
    }

    public List<String> serializeAsValues(List<Float> list) {
        if (list == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Iterable<Number> iterable = list;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        for (Number floatValue : iterable) {
            arrayList.add(String.valueOf(floatValue.floatValue()));
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r5v2, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean valueEquals(java.util.List<java.lang.Float> r4, java.util.List<java.lang.Float> r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L_0x000f
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Float[] r2 = new java.lang.Float[r1]
            java.lang.Object[] r4 = r4.toArray(r2)
            java.lang.Float[] r4 = (java.lang.Float[]) r4
            goto L_0x0010
        L_0x000f:
            r4 = r0
        L_0x0010:
            if (r5 == 0) goto L_0x001d
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Float[] r0 = new java.lang.Float[r1]
            java.lang.Object[] r5 = r5.toArray(r0)
            r0 = r5
            java.lang.Float[] r0 = (java.lang.Float[]) r0
        L_0x001d:
            boolean r4 = kotlin.collections.oOoXoXO.Oxx0IOOO(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$FloatListType$1.valueEquals(java.util.List, java.util.List):boolean");
    }

    public List<Float> parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return oI0IIXIo.OOXIXo(NavType.FloatType.parseValue(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = kotlin.collections.CollectionsKt___CollectionsKt.o0xIIX0(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.Float> parseValue(java.lang.String r2, java.util.List<java.lang.Float> r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$FloatListType$1.parseValue(java.lang.String, java.util.List):java.util.List");
    }
}
