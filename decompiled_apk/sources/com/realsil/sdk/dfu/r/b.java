package com.realsil.sdk.dfu.r;

import com.realsil.sdk.core.utility.DataConverter;
import java.util.Locale;

/* loaded from: classes11.dex */
public class b extends com.realsil.sdk.dfu.j.c {

    /* renamed from: a, reason: collision with root package name */
    public int f19595a;
    public byte[] b;

    @Override // com.realsil.sdk.dfu.j.c
    public byte[] a() {
        int length = this.b.length;
        byte[] bArr = new byte[length + 2];
        bArr[0] = (byte) (b() & 255);
        bArr[1] = (byte) (this.f19595a & 255);
        if (length > 0) {
            System.arraycopy(this.b, 0, bArr, 2, length);
        }
        return bArr;
    }

    @Override // com.realsil.sdk.dfu.j.c
    public short b() {
        return (short) 18;
    }

    public String toString() {
        return String.format("CheckPubKeyHashReq(0x%04X) {", Short.valueOf(b())) + String.format(Locale.US, "\n\tnumber=%d, keys=%s", Integer.valueOf(this.f19595a), DataConverter.bytes2Hex(this.b)) + "\n}";
    }

    /* renamed from: com.realsil.sdk.dfu.r.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0915b {

        /* renamed from: a, reason: collision with root package name */
        public int f19596a;
        public byte[] b;

        public C0915b a(int i, byte[] bArr) {
            this.f19596a = i;
            this.b = bArr;
            return this;
        }

        public b a() {
            return new b(this.f19596a, this.b);
        }
    }

    public b(int i, byte[] bArr) {
        this.f19595a = i;
        this.b = bArr;
    }
}
