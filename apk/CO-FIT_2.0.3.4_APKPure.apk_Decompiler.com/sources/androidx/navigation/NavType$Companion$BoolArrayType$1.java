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

@XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$BoolArrayType$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1212:1\n1549#2:1213\n1620#2,3:1214\n*S KotlinDebug\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$BoolArrayType$1\n*L\n758#1:1213\n758#1:1214,3\n*E\n"})
public final class NavType$Companion$BoolArrayType$1 extends CollectionNavType<boolean[]> {
    public NavType$Companion$BoolArrayType$1() {
        super(true);
    }

    public boolean[] emptyCollection() {
        return new boolean[0];
    }

    public String getName() {
        return "boolean[]";
    }

    public boolean[] get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        return (boolean[]) bundle.get(str);
    }

    public void put(Bundle bundle, String str, boolean[] zArr) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putBooleanArray(str, zArr);
    }

    public List<String> serializeAsValues(boolean[] zArr) {
        List<Boolean> XIX0oOXXO;
        if (zArr == null || (XIX0oOXXO = ArraysKt___ArraysKt.XIX0oOXXO(zArr)) == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Iterable<Boolean> iterable = XIX0oOXXO;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        for (Boolean booleanValue : iterable) {
            arrayList.add(String.valueOf(booleanValue.booleanValue()));
        }
        return arrayList;
    }

    public boolean valueEquals(boolean[] zArr, boolean[] zArr2) {
        Boolean[] boolArr = null;
        Boolean[] xXIX0Xo2 = zArr != null ? ooOOo0oXI.xXIX0Xo(zArr) : null;
        if (zArr2 != null) {
            boolArr = ooOOo0oXI.xXIX0Xo(zArr2);
        }
        return oOoXoXO.Oxx0IOOO(xXIX0Xo2, boolArr);
    }

    public boolean[] parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return new boolean[]{NavType.BoolType.parseValue(str).booleanValue()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = kotlin.collections.ooOOo0oXI.IIIxO(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean[] parseValue(java.lang.String r2, boolean[] r3) {
        /*
            r1 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            if (r3 == 0) goto L_0x0011
            boolean[] r0 = r1.parseValue((java.lang.String) r2)
            boolean[] r3 = kotlin.collections.ooOOo0oXI.IIIxO(r3, r0)
            if (r3 != 0) goto L_0x0015
        L_0x0011:
            boolean[] r3 = r1.parseValue((java.lang.String) r2)
        L_0x0015:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$BoolArrayType$1.parseValue(java.lang.String, boolean[]):boolean[]");
    }
}
