package com.realsil.sdk.dfu.v;

import com.realsil.sdk.core.utility.DataConverter;
import java.util.Locale;

/* loaded from: classes11.dex */
public class r extends com.realsil.sdk.dfu.j.c {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f19643a;
    public byte b;

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f19644a;
        public byte b = 0;

        public b a(byte[] bArr) {
            this.f19644a = bArr;
            return this;
        }

        public b a(byte b) {
            this.b = b;
            return this;
        }

        public r a() {
            return new r(this.f19644a, this.b);
        }
    }

    @Override // com.realsil.sdk.dfu.j.c
    public byte[] a() {
        byte[] bArr = new byte[16];
        byte[] bArr2 = this.f19643a;
        if (bArr2 != null && bArr2.length >= 12) {
            System.arraycopy(bArr2, 0, bArr, 0, 12);
        }
        bArr[12] = this.b;
        return bArr;
    }

    @Override // com.realsil.sdk.dfu.j.c
    public short b() {
        return (short) 1538;
    }

    public String toString() {
        return String.format("StartDfuReq(0x%04X) {", Short.valueOf(b())) + String.format(Locale.US, "\n\tmode=0x%02X, imageHeader=%s", Byte.valueOf(this.b), DataConverter.bytes2Hex(this.f19643a)) + "\n}";
    }

    public r(byte[] bArr, byte b2) {
        this.f19643a = bArr;
        this.b = b2;
    }
}
