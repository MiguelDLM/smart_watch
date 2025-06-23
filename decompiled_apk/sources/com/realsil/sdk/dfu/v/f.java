package com.realsil.sdk.dfu.v;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/* loaded from: classes11.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public short f19638a = 1541;
    public byte b;
    public int c;
    public int d;

    public f(byte b, int i, int i2) {
        this.b = b;
        this.c = i;
        this.d = i2;
    }

    public static f a(byte[] bArr) {
        int i;
        int i2 = 0;
        if (bArr != null && bArr.length >= 1) {
            int length = bArr.length;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            byte b = bArr[0];
            if (length >= 3) {
                i = (((short) (wrap.get(2) & 255)) << 8) | ((short) (wrap.get(1) & 255));
            } else {
                i = 0;
            }
            if (length >= 4) {
                i2 = (((short) (wrap.get(4) & 255)) << 8) | ((short) (wrap.get(3) & 255));
            }
            return new f(b, i, i2);
        }
        return new f((byte) 2, 0, 0);
    }

    public String toString() {
        return String.format("EnableBufferCheckRsp(0x%04X) {", Short.valueOf(this.f19638a)) + String.format(Locale.US, "\n\tstatus=0x%02X,maxBufferSize=0x%04X(%d), bufferCheckMtuSize=0x%04X(%d)", Byte.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.d)) + "\n}";
    }
}
