package com.realsil.sdk.dfu.v;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/* loaded from: classes11.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public short f19641a = 1543;
    public byte b;
    public int c;
    public int d;
    public int e;

    public k(byte b, int i, int i2, int i3) {
        this.b = b;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public static k a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = bArr.length;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return new k(bArr[0], length >= 5 ? wrap.getInt(1) : 0, length >= 9 ? wrap.getInt(5) : 0, length >= 11 ? wrap.getShort(9) : (short) 0);
    }

    public byte b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }

    public String toString() {
        return String.format("GeTargetImageInfoRsp(0x%04X) {", Short.valueOf(this.f19641a)) + String.format(Locale.US, "\n\tstatus=0x%02X,imageVersion=0x%08X, updateOffset=0x%08X(%d),bufferCheckOffset=0x%08X(%d)", Byte.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.e)) + "\n}";
    }

    public int a() {
        return this.e;
    }
}
