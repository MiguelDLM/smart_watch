package com.realsil.sdk.dfu.l;

import com.realsil.sdk.core.utility.DataConverter;
import java.util.Locale;

/* loaded from: classes11.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f19560a;
    public byte[] b;
    public byte[] c;
    public byte[] d;

    public byte[] a() {
        byte[] bArr = new byte[17];
        bArr[0] = 14;
        byte[] bArr2 = this.b;
        if (bArr2 != null && bArr2.length >= 16) {
            System.arraycopy(bArr2, 0, bArr, 1, 16);
        }
        return bArr;
    }

    public byte b() {
        return (byte) 14;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("HandshakeCmd(0x%04X) {", Byte.valueOf(b())));
        Locale locale = Locale.US;
        sb.append(String.format(locale, "\n\torigin=%s", DataConverter.bytes2Hex(this.b)));
        sb.append(String.format(locale, "\n\ttarget=%s", DataConverter.bytes2Hex(this.d)));
        sb.append("\n}");
        return sb.toString();
    }

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f19561a;
        public byte[] b;
        public byte[] c;
        public byte[] d;

        public b a(byte[] bArr, byte[] bArr2) {
            this.f19561a = bArr;
            this.b = bArr2;
            return this;
        }

        public b b(byte[] bArr, byte[] bArr2) {
            this.c = bArr;
            this.d = bArr2;
            return this;
        }

        public k a() {
            return new k(this.f19561a, this.b, this.c, this.d);
        }
    }

    public k(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.f19560a = bArr;
        this.b = bArr2;
        this.c = bArr3;
        this.d = bArr4;
    }
}
