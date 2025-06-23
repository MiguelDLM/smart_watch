package com.realsil.sdk.dfu.s;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes11.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f19604a;
    public byte[] b;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public List<C0917c> f19605a = new ArrayList();

        public b a(List<C0917c> list) {
            this.f19605a = list;
            return this;
        }

        public c a() {
            int size = this.f19605a.size();
            byte[] bArr = new byte[size * 34];
            int i = 0;
            for (C0917c c0917c : this.f19605a) {
                ZLogger.v(c0917c.toString());
                byte[] bArr2 = c0917c.c;
                if (bArr2 != null && bArr2.length >= 34) {
                    System.arraycopy(bArr2, 0, bArr, i, 34);
                }
                i += 34;
            }
            return new c(size, bArr);
        }
    }

    /* renamed from: com.realsil.sdk.dfu.s.c$c, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0917c {

        /* renamed from: a, reason: collision with root package name */
        public int f19606a;
        public byte[] b;
        public byte[] c;

        public C0917c(int i, byte[] bArr) {
            this.f19606a = i;
            this.b = bArr;
            byte[] bArr2 = new byte[34];
            this.c = bArr2;
            bArr2[0] = (byte) (i & 255);
            bArr2[1] = (byte) ((i >> 8) & 255);
            if (bArr.length >= 32) {
                System.arraycopy(bArr, 0, bArr2, 2, 32);
            }
        }

        public String toString() {
            return String.format("imageId=0x%04X, sha256=%s", Integer.valueOf(this.f19606a), DataConverter.bytes2Hex(this.b));
        }
    }

    public byte[] a() {
        byte[] bArr = this.b;
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 2];
        int i = this.f19604a;
        bArr2[0] = (byte) (i & 255);
        bArr2[1] = (byte) (i >> 8);
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 2, length);
        }
        return bArr2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.US;
        sb.append(String.format(locale, "\n\tnumber=%d", Integer.valueOf(this.f19604a)));
        byte[] bArr = this.b;
        if (bArr != null) {
            sb.append(String.format(locale, "\n\tsha256=(%d)%s", Integer.valueOf(bArr.length), DataConverter.bytes2Hex(this.b)));
        }
        return sb.toString();
    }

    public c(int i, byte[] bArr) {
        this.f19604a = i;
        this.b = bArr;
    }
}
