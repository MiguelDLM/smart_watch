package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.oOoXoXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nNavType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$StringArrayType$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1212:1\n11065#2:1213\n11400#2,3:1214\n*S KotlinDebug\n*F\n+ 1 NavType.kt\nandroidx/navigation/NavType$Companion$StringArrayType$1\n*L\n885#1:1213\n885#1:1214,3\n*E\n"})
public final class NavType$Companion$StringArrayType$1 extends CollectionNavType<String[]> {
    public NavType$Companion$StringArrayType$1() {
        super(true);
    }

    public String[] emptyCollection() {
        return new String[0];
    }

    public String getName() {
        return "string[]";
    }

    public String[] get(Bundle bundle, String str) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        return (String[]) bundle.get(str);
    }

    public void put(Bundle bundle, String str, String[] strArr) {
        IIX0o.x0xO0oo(bundle, "bundle");
        IIX0o.x0xO0oo(str, "key");
        bundle.putStringArray(str, strArr);
    }

    public List<String> serializeAsValues(String[] strArr) {
        if (strArr == null) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String encode : strArr) {
            arrayList.add(Uri.encode(encode));
        }
        return arrayList;
    }

    public boolean valueEquals(String[] strArr, String[] strArr2) {
        return oOoXoXO.Oxx0IOOO(strArr, strArr2);
    }

    public String[] parseValue(String str) {
        IIX0o.x0xO0oo(str, "value");
        return new String[]{str};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = (java.lang.String[]) kotlin.collections.ooOOo0oXI.O0xO0(r3, parseValue(r2));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] parseValue(java.lang.String r2, java.lang.String[] r3) {
        /*
            r1 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            if (r3 == 0) goto L_0x0013
            java.lang.String[] r0 = r1.parseValue((java.lang.String) r2)
            java.lang.Object[] r3 = kotlin.collections.ooOOo0oXI.O0xO0(r3, r0)
            java.lang.String[] r3 = (java.lang.String[]) r3
            if (r3 != 0) goto L_0x0017
        L_0x0013:
            java.lang.String[] r3 = r1.parseValue((java.lang.String) r2)
        L_0x0017:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType$Companion$StringArrayType$1.parseValue(java.lang.String, java.lang.String[]):java.lang.String[]");
    }
}
