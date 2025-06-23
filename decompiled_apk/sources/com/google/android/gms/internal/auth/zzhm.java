package com.google.android.gms.internal.auth;

/* loaded from: classes9.dex */
final class zzhm extends zzhl {
    @Override // com.google.android.gms.internal.auth.zzhl
    public final int zza(int i, byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b < 0) {
                if (b < -32) {
                    if (i4 >= i3) {
                        return b;
                    }
                    if (b >= -62) {
                        i2 += 2;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                }
                if (b < -16) {
                    if (i4 >= i3 - 1) {
                        return zzhn.zza(bArr, i4, i3);
                    }
                    int i5 = i2 + 2;
                    byte b2 = bArr[i4];
                    if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                        i2 += 3;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                }
                if (i4 >= i3 - 2) {
                    return zzhn.zza(bArr, i4, i3);
                }
                int i6 = i2 + 2;
                byte b3 = bArr[i4];
                if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                    int i7 = i2 + 3;
                    if (bArr[i6] <= -65) {
                        i2 += 4;
                        if (bArr[i7] > -65) {
                        }
                    }
                }
                return -1;
            }
            i2 = i4;
        }
        return 0;
    }
}
