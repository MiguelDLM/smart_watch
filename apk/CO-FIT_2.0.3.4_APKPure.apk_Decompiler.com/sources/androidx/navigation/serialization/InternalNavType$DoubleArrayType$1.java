package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.CollectionNavType;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.oOoXoXO;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavTypeConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$DoubleArrayType$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,577:1\n1549#2:578\n1620#2,3:579\n*S KotlinDebug\n*F\n+ 1 NavTypeConverter.kt\nandroidx/navigation/serialization/InternalNavType$DoubleArrayType$1\n*L\n435#1:578\n435#1:579,3\n*E\n"})
public final class InternalNavType$DoubleArrayType$1 extends CollectionNavType<double[]> {
    public InternalNavType$DoubleArrayType$1() {
        super(true);
    }

    public double[] emptyCollection() {
        return new double[0];
    }

    public String getName() {
        return "double[]";
    }

    public double[] get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        return (double[]) bundle.get(str);
    }

    public void put(Bundle bundle, String str, double[] dArr) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putDoubleArray(str, dArr);
    }

    public List<String> serializeAsValues(double[] dArr) {
        List<Double> OXIIooO0;
        if (dArr == null || (OXIIooO0 = ArraysKt___ArraysKt.OXIIooO0(dArr)) == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Iterable<Number> iterable = OXIIooO0;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        for (Number doubleValue : iterable) {
            arrayList.add(String.valueOf(doubleValue.doubleValue()));
        }
        return arrayList;
    }

    public boolean valueEquals(double[] dArr, double[] dArr2) {
        Double[] dArr3 = null;
        Double[] OIII0O2 = dArr != null ? ooOOo0oXI.OIII0O(dArr) : null;
        if (dArr2 != null) {
            dArr3 = ooOOo0oXI.OIII0O(dArr2);
        }
        return oOoXoXO.Oxx0IOOO(OIII0O2, dArr3);
    }

    public double[] parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return new double[]{InternalNavType.INSTANCE.getDoubleType().parseValue(str).doubleValue()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = kotlin.collections.ooOOo0oXI.OoIXo(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double[] parseValue(java.lang.String r2, double[] r3) {
        /*
            r1 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            if (r3 == 0) goto L_0x0011
            double[] r0 = r1.parseValue((java.lang.String) r2)
            double[] r3 = kotlin.collections.ooOOo0oXI.OoIXo(r3, r0)
            if (r3 != 0) goto L_0x0015
        L_0x0011:
            double[] r3 = r1.parseValue((java.lang.String) r2)
        L_0x0015:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.serialization.InternalNavType$DoubleArrayType$1.parseValue(java.lang.String, double[]):double[]");
    }
}
