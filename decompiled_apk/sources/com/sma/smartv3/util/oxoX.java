package com.sma.smartv3.util;

import com.blankj.utilcode.util.LogUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes12.dex */
public final class oxoX {
    public static /* synthetic */ byte[] II0xO0(String str, byte[] bArr, int i, int i2, int i3, boolean z, int i4, Object obj) {
        int i5;
        int i6;
        boolean z2;
        if ((i4 & 8) != 0) {
            i5 = 16;
        } else {
            i5 = i2;
        }
        if ((i4 & 16) != 0) {
            i6 = 70;
        } else {
            i6 = i3;
        }
        if ((i4 & 32) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        return oIX0oI(str, bArr, i, i5, i6, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Iterable, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    @OXOo.OOXIXo
    public static final byte[] oIX0oI(@OXOo.OOXIXo String fileFormat, @OXOo.OOXIXo byte[] data, int i, int i2, int i3, boolean z) {
        byte b;
        int i4;
        kotlin.jvm.internal.IIX0o.x0xO0oo(fileFormat, "fileFormat");
        kotlin.jvm.internal.IIX0o.x0xO0oo(data, "data");
        if (kotlin.jvm.internal.IIX0o.Oxx0IOOO(fileFormat, "bmp")) {
            if (i3 == 0) {
                b = 0;
            } else {
                b = data[10];
            }
            LogUtils.d("headerInfoSize " + ((int) b));
            List<Byte> o0X0 = ArraysKt___ArraysKt.o0X0(data, data.length - b);
            int i5 = (((i2 * i) + 31) / 32) * 4;
            ?? arrayList = new ArrayList();
            if (i % 2 == 0) {
                i4 = 0;
            } else {
                i4 = 2;
            }
            int size = o0X0.size() / i5;
            for (int i6 = 0; i6 < size; i6++) {
                int i7 = i5 - i4;
                byte[] bArr = new byte[i7];
                for (int i8 = 0; i8 < i7; i8++) {
                    bArr[i8] = o0X0.get((i6 * i5) + i8).byteValue();
                }
                arrayList.add(bArr);
            }
            if (z) {
                arrayList = CollectionsKt___CollectionsKt.OOoOoO0o(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            int size2 = arrayList.size();
            for (int i9 = 0; i9 < size2; i9++) {
                for (int i10 = 0; i10 < ((byte[]) arrayList.get(i9)).length; i10 += 2) {
                    arrayList2.add(Byte.valueOf(((byte[]) arrayList.get(i9))[i10 + 1]));
                    arrayList2.add(Byte.valueOf(((byte[]) arrayList.get(i9))[i10]));
                }
            }
            int size3 = arrayList2.size();
            byte[] bArr2 = new byte[size3];
            for (int i11 = 0; i11 < size3; i11++) {
                Object obj = arrayList2.get(i11);
                kotlin.jvm.internal.IIX0o.oO(obj, "get(...)");
                bArr2[i11] = ((Number) obj).byteValue();
            }
            return bArr2;
        }
        return data;
    }
}
