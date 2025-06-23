package com.realsil.sdk.dfu.s;

import com.realsil.sdk.core.logger.ZLogger;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f19603a;
    public String b;

    public b(int i, String str) {
        this.f19603a = i;
        this.b = str;
    }

    public static b a(byte[] bArr) {
        String str;
        if (bArr != null && bArr.length >= 2) {
            int i = (((short) (bArr[1] & 255)) << 8) | ((short) (bArr[0] & 255));
            int length = bArr.length - 2;
            if (length > 0) {
                byte[] b = b(Arrays.copyOfRange(bArr, 2, length));
                try {
                    str = new String(b, 0, b.length, "ascii");
                } catch (UnsupportedEncodingException e) {
                    ZLogger.w(e.toString());
                }
                return new b(i, str);
            }
            str = "";
            return new b(i, str);
        }
        return null;
    }

    public static byte[] b(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            if (b == 0 || b == -1) {
                break;
            }
            i++;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }
}
