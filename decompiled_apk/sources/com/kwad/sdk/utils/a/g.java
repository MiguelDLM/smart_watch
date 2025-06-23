package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class g implements c.b<Set<String>> {
    static final g aTn = new g();

    private g() {
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i = 0;
        int i2 = 0;
        for (String str : set) {
            if (str == null) {
                i += 5;
                iArr[i2] = -1;
            } else {
                int hn = b.hn(str);
                strArr[i2] = str;
                iArr[i2] = hn;
                i += b.ek(hn) + hn;
            }
            i2++;
        }
        b bVar = new b(i);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            bVar.ej(i4);
            if (i4 >= 0) {
                bVar.hm(strArr[i3]);
            }
        }
        return bVar.aSv;
    }

    private static Set<String> h(byte[] bArr, int i, int i2) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            b bVar = new b(bArr, i);
            int i4 = i + i2;
            while (true) {
                i3 = bVar.position;
                if (i3 >= i4) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.Of()));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final String Oz() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> g(byte[] bArr, int i, int i2) {
        return h(bArr, i, i2);
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] m(Set<String> set) {
        return e(set);
    }
}
