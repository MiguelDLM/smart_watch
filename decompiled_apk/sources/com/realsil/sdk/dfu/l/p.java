package com.realsil.sdk.dfu.l;

import com.realsil.sdk.core.utility.DataConverter;
import java.util.Locale;

/* loaded from: classes11.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public int f19569a;
    public byte[] b;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f19570a;
        public byte[] b;

        public b(int i) {
            this.f19570a = i;
        }

        public b a(byte[] bArr) {
            this.b = bArr;
            return this;
        }

        public p a() {
            return new p(this.f19570a, this.b);
        }
    }

    public byte[] a() {
        byte[] bArr = new byte[17];
        bArr[0] = b();
        byte[] bArr2 = this.b;
        if (bArr2 != null && bArr2.length >= 16) {
            System.arraycopy(bArr2, 0, bArr, 1, 16);
        }
        return bArr;
    }

    public byte b() {
        return (byte) 1;
    }

    public String toString() {
        return String.format("StartDfuCmd(0x%02X) {", Byte.valueOf(b())) + String.format(Locale.US, "\n\tparams=%s", DataConverter.bytes2Hex(this.b)) + "\n}";
    }

    public p(int i, byte[] bArr) {
        this.f19569a = i;
        this.b = bArr;
    }
}
