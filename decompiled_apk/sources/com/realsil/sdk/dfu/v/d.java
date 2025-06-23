package com.realsil.sdk.dfu.v;

import com.realsil.sdk.core.utility.DataConverter;
import java.util.Locale;

/* loaded from: classes11.dex */
public class d extends com.realsil.sdk.dfu.j.c {

    /* renamed from: a, reason: collision with root package name */
    public int f19634a;
    public byte[] b;

    @Override // com.realsil.sdk.dfu.j.c
    public byte[] a() {
        byte[] bArr = this.b;
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 2];
        int i = this.f19634a;
        bArr2[0] = (byte) (i & 255);
        bArr2[1] = (byte) (i >> 8);
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 2, length);
        }
        return bArr2;
    }

    @Override // com.realsil.sdk.dfu.j.c
    public short b() {
        return (short) 1555;
    }

    public String toString() {
        return String.format("CheckPubKeyHashReq(0x%04X) {", Short.valueOf(b())) + String.format(Locale.US, "\n\tnumber=%d, keys=%s", Integer.valueOf(this.f19634a), DataConverter.bytes2Hex(this.b)) + "\n}";
    }

    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f19635a;
        public byte[] b;

        public b a(int i, byte[] bArr) {
            this.f19635a = i;
            this.b = bArr;
            return this;
        }

        public d a() {
            return new d(this.f19635a, this.b);
        }
    }

    public d(int i, byte[] bArr) {
        this.f19634a = i;
        this.b = bArr;
    }
}
