package com.realsil.sdk.dfu.l;

import com.realsil.sdk.core.utility.DataConverter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/* loaded from: classes11.dex */
public class i extends com.realsil.sdk.dfu.j.d {

    /* renamed from: a, reason: collision with root package name */
    public int f19558a;
    public int b;
    public byte c;
    public byte[] d;

    public i(int i, int i2, byte b, byte[] bArr) {
        this.f19558a = i;
        this.b = i2;
        this.c = b;
        this.d = bArr;
    }

    public byte a() {
        return this.c;
    }

    public String toString() {
        return String.format("GattDfuNormalRsp(0x%04X, 0x%04X) {", Integer.valueOf(this.f19558a), Integer.valueOf(this.b)) + String.format(Locale.US, "\n\tstatus=0x%02X, params=%s", Byte.valueOf(this.c), DataConverter.bytes2Hex(this.d)) + "\n}";
    }

    public static i a(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr == null || bArr.length < 2) {
            return null;
        }
        ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        byte b = bArr[0];
        byte b2 = bArr[1];
        byte b3 = bArr[2];
        int length = bArr.length - 3;
        if (length > 0) {
            bArr2 = new byte[length];
            System.arraycopy(bArr, 3, bArr2, 0, length);
        }
        return new i(b, b2, b3, bArr2);
    }
}
