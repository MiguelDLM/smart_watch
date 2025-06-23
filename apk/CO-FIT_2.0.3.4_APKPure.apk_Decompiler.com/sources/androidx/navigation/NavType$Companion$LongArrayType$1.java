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

@XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$LongArrayType$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1212:1\n1549#2:1213\n1620#2,3:1214\n*S KotlinDebug\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$LongArrayType$1\n*L\n533#1:1213\n533#1:1214,3\n*E\n"})
public final class NavType$Companion$LongArrayType$1 extends CollectionNavType<long[]> {
    public NavType$Companion$LongArrayType$1() {
        super(true);
    }

    public long[] emptyCollection() {
        return new long[0];
    }

    public String getName() {
        return "long[]";
    }

    public long[] get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        return (long[]) bundle.get(str);
    }

    public void put(Bundle bundle, String str, long[] jArr) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putLongArray(str, jArr);
    }

    public List<String> serializeAsValues(long[] jArr) {
        List<Long> OoxIx;
        if (jArr == null || (OoxIx = ArraysKt___ArraysKt.OoxIx(jArr)) == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Iterable<Number> iterable = OoxIx;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        for (Number longValue : iterable) {
            arrayList.add(String.valueOf(longValue.longValue()));
        }
        return arrayList;
    }

    public boolean valueEquals(long[] jArr, long[] jArr2) {
        Long[] lArr = null;
        Long[] xOI02 = jArr != null ? ooOOo0oXI.xOI0(jArr) : null;
        if (jArr2 != null) {
            lArr = ooOOo0oXI.xOI0(jArr2);
        }
        return oOoXoXO.Oxx0IOOO(xOI02, lArr);
    }

    public long[] parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return new long[]{NavType.LongType.parseValue(str).longValue()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = kotlin.collections.ooOOo0oXI.xX0ox(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long[] parseValue(java.lang.String r2, long[] r3) {
        /*
            r1 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            if (r3 == 0) goto L_0x0011
            long[] r0 = r1.parseValue((java.lang.String) r2)
            long[] r3 = kotlin.collections.ooOOo0oXI.xX0ox(r3, r0)
            if (r3 != 0) goto L_0x0015
        L_0x0011:
            long[] r3 = r1.parseValue((java.lang.String) r2)
        L_0x0015:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$LongArrayType$1.parseValue(java.lang.String, long[]):long[]");
    }
}
