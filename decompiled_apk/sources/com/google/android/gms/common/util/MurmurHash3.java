package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.collection.ScatterMapKt;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes9.dex */
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int murmurhash3_x86_32(@NonNull byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = i;
        while (true) {
            i4 = (i2 & (-4)) + i;
            if (i5 >= i4) {
                break;
            }
            int i6 = ((bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | (bArr[i5 + 3] << 24)) * ScatterMapKt.MurmurHashC1;
            int i7 = i3 ^ (((i6 >>> 17) | (i6 << 15)) * 461845907);
            i3 = (((i7 >>> 19) | (i7 << 13)) * 5) - 430675100;
            i5 += 4;
        }
        int i8 = i2 & 3;
        int i9 = 0;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    i9 = (bArr[i4 + 2] & 255) << 16;
                }
                int i10 = i3 ^ i2;
                int i11 = (i10 ^ (i10 >>> 16)) * (-2048144789);
                int i12 = (i11 ^ (i11 >>> 13)) * (-1028477387);
                return i12 ^ (i12 >>> 16);
            }
            i9 |= (bArr[i4 + 1] & 255) << 8;
        }
        int i13 = ((bArr[i4] & 255) | i9) * ScatterMapKt.MurmurHashC1;
        i3 ^= ((i13 >>> 17) | (i13 << 15)) * 461845907;
        int i102 = i3 ^ i2;
        int i112 = (i102 ^ (i102 >>> 16)) * (-2048144789);
        int i122 = (i112 ^ (i112 >>> 13)) * (-1028477387);
        return i122 ^ (i122 >>> 16);
    }
}
