package com.realsil.sdk.dfu.m;

/* loaded from: classes11.dex */
public class c {
    public static byte[] a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = (byte) (bArr[i] + 1);
            }
            return bArr2;
        }
        return bArr;
    }
}
