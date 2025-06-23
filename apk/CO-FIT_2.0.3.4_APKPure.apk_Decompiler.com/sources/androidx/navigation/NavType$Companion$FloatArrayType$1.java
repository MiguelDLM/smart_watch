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

@XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$FloatArrayType$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1212:1\n1549#2:1213\n1620#2,3:1214\n*S KotlinDebug\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$FloatArrayType$1\n*L\n640#1:1213\n640#1:1214,3\n*E\n"})
public final class NavType$Companion$FloatArrayType$1 extends CollectionNavType<float[]> {
    public NavType$Companion$FloatArrayType$1() {
        super(true);
    }

    public float[] emptyCollection() {
        return new float[0];
    }

    public String getName() {
        return "float[]";
    }

    public float[] get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        return (float[]) bundle.get(str);
    }

    public void put(Bundle bundle, String str, float[] fArr) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putFloatArray(str, fArr);
    }

    public List<String> serializeAsValues(float[] fArr) {
        List<Float> X00OO00x;
        if (fArr == null || (X00OO00x = ArraysKt___ArraysKt.X00OO00x(fArr)) == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        Iterable<Number> iterable = X00OO00x;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(iterable, 10));
        for (Number floatValue : iterable) {
            arrayList.add(String.valueOf(floatValue.floatValue()));
        }
        return arrayList;
    }

    public boolean valueEquals(float[] fArr, float[] fArr2) {
        Float[] fArr3 = null;
        Float[] Xxx0oXX2 = fArr != null ? ooOOo0oXI.Xxx0oXX(fArr) : null;
        if (fArr2 != null) {
            fArr3 = ooOOo0oXI.Xxx0oXX(fArr2);
        }
        return oOoXoXO.Oxx0IOOO(Xxx0oXX2, fArr3);
    }

    public float[] parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return new float[]{NavType.FloatType.parseValue(str).floatValue()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = kotlin.collections.ooOOo0oXI.O0O0Io00X(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float[] parseValue(java.lang.String r2, float[] r3) {
        /*
            r1 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            if (r3 == 0) goto L_0x0011
            float[] r0 = r1.parseValue((java.lang.String) r2)
            float[] r3 = kotlin.collections.ooOOo0oXI.O0O0Io00X(r3, r0)
            if (r3 != 0) goto L_0x0015
        L_0x0011:
            float[] r3 = r1.parseValue((java.lang.String) r2)
        L_0x0015:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$FloatArrayType$1.parseValue(java.lang.String, float[]):float[]");
    }
}
