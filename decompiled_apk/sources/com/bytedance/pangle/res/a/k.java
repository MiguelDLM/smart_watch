package com.bytedance.pangle.res.a;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes8.dex */
public final class k {
    public static int a(g gVar) {
        return (int) gVar.f10608a.a().b();
    }

    private static byte[] a(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static int a(byte[] bArr, int i, int i2, h hVar) {
        if (i < 2130706432) {
            return i;
        }
        int a2 = hVar.a(i);
        byte[] a3 = a(a2);
        bArr[i2] = a3[0];
        bArr[i2 + 1] = a3[1];
        bArr[i2 + 2] = a3[2];
        bArr[i2 + 3] = a3[3];
        return a2;
    }

    public static void a(byte[] bArr, h hVar) {
        b bVar = new b(bArr, hVar);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        bVar.a();
        bVar.c = new g(new i(new e(byteArrayInputStream)));
        do {
        } while (bVar.b() != 1);
    }

    public static void a(int i, byte[] bArr, int[] iArr, int i2, HashMap<Integer, Integer> hashMap) {
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[(i4 * 5) + 1];
            if (hashMap.containsKey(Integer.valueOf(i5))) {
                if (i3 == -1) {
                    i3 = i4;
                }
                int i6 = (i4 * 20) + i;
                hashMap2.put(Integer.valueOf(i4), Arrays.copyOfRange(bArr, i6, i6 + 20));
                Integer num = hashMap.get(Integer.valueOf(i5));
                num.intValue();
                hashMap3.put(num, Integer.valueOf(i4));
            }
        }
        ArrayList arrayList = new ArrayList(hashMap3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            Integer num2 = (Integer) hashMap3.get((Integer) it.next());
            num2.intValue();
            byte[] bArr2 = (byte[]) hashMap2.get(num2);
            System.arraycopy(bArr2, 0, bArr, ((i7 + i3) * 20) + i, bArr2.length);
            i7++;
        }
    }
}
