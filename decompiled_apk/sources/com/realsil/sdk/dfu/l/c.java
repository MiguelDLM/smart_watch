package com.realsil.sdk.dfu.l;

import com.realsil.sdk.core.utility.DataConverter;
import java.util.Locale;

/* loaded from: classes11.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f19552a;
    public byte b;
    public byte[] c;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f19553a;
        public byte b;
        public byte[] c;

        public b a(byte b) {
            this.b = b;
            return this;
        }

        public b a(byte[] bArr) {
            this.c = bArr;
            return this;
        }

        public c a() {
            return new c(this.f19553a, this.b, this.c);
        }
    }

    public byte[] a() {
        int i;
        byte[] bArr = this.c;
        if (bArr != null) {
            i = bArr.length;
        } else {
            i = 0;
        }
        byte[] bArr2 = new byte[i + 1];
        bArr2[0] = b();
        if (i > 0) {
            System.arraycopy(this.c, 0, bArr2, 1, i);
        }
        return bArr2;
    }

    public byte b() {
        return this.b;
    }

    public String toString() {
        return String.format("BleDfuCmd(0x%02X) {", Byte.valueOf(b())) + String.format(Locale.US, "\n\tparams=%s", DataConverter.bytes2Hex(this.c)) + "\n}";
    }

    public c(int i, byte b2, byte[] bArr) {
        this.f19552a = i;
        this.b = b2;
        this.c = bArr;
    }
}
