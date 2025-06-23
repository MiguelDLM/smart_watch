package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.oOoXoXO;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$IntArrayType$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1212:1\n1549#2:1213\n1620#2,3:1214\n*S KotlinDebug\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$IntArrayType$1\n*L\n414#1:1213\n414#1:1214,3\n*E\n"})
public final class NavType$Companion$IntArrayType$1 extends CollectionNavType<int[]> {
    public NavType$Companion$IntArrayType$1() {
        super(true);
    }

    public int[] emptyCollection() {
        return new int[0];
    }

    public String getName() {
        return "integer[]";
    }

    public int[] get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        return (int[]) bundle.get(str);
    }

    public void put(Bundle bundle, String str, int[] iArr) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putIntArray(str, iArr);
    }

    public List<String> serializeAsValues(int[] iArr) {
        List<Integer> XXX0;
        if (iArr == null || (XXX0 = ArraysKt___ArraysKt.XXX0(iArr)) == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Iterable<Number> iterable = XXX0;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        for (Number intValue : iterable) {
            arrayList.add(String.valueOf(intValue.intValue()));
        }
        return arrayList;
    }

    public boolean valueEquals(int[] iArr, int[] iArr2) {
        Integer[] numArr = null;
        Integer[] XXoO0oX2 = iArr != null ? ooOOo0oXI.XXoO0oX(iArr) : null;
        if (iArr2 != null) {
            numArr = ooOOo0oXI.XXoO0oX(iArr2);
        }
        return oOoXoXO.Oxx0IOOO(XXoO0oX2, numArr);
    }

    public int[] parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return new int[]{NavType.IntType.parseValue(str).intValue()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = kotlin.collections.ooOOo0oXI.oIXoXx0(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int[] parseValue(java.lang.String r2, int[] r3) {
        /*
            r1 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            if (r3 == 0) goto L_0x0011
            int[] r0 = r1.parseValue((java.lang.String) r2)
            int[] r3 = kotlin.collections.ooOOo0oXI.oIXoXx0(r3, r0)
            if (r3 != 0) goto L_0x0015
        L_0x0011:
            int[] r3 = r1.parseValue((java.lang.String) r2)
        L_0x0015:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$IntArrayType$1.parseValue(java.lang.String, int[]):int[]");
    }
}
