package com.realsil.sdk.dfu.l;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/* loaded from: classes11.dex */
public final class h extends j {
    public int d;
    public int e;
    public boolean f;
    public int g;

    public h(int i, int i2, int i3, int i4, boolean z, int i5) {
        super(i, i2);
        this.d = i3;
        this.e = i4;
        this.f = z;
        this.g = i5;
    }

    public static h a(int i, int i2, byte[] bArr) {
        boolean z;
        short s;
        byte b;
        short s2;
        if (bArr == null || bArr.length <= 2) {
            return null;
        }
        int length = bArr.length;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        byte b2 = wrap.get();
        byte b3 = wrap.get();
        if (i == 16) {
            byte b4 = wrap.get();
            short s3 = wrap.getShort();
            if (i2 >= 4 || length < 7) {
                z = false;
                s = 0;
                b = b4;
            } else {
                z = true;
                b = b4;
                s = wrap.getShort();
            }
            s2 = s3;
        } else if (i == 20 || i == 21) {
            z = false;
            s = 0;
            b = wrap.get();
            s2 = wrap.getShort();
        } else {
            b = 0;
            s2 = 0;
            z = false;
            s = 0;
        }
        return new h(b2, b3, b, s2, z, s);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("EnableBufferCheckEvent(0x%04X) {", Integer.valueOf(this.b)));
        Locale locale = Locale.US;
        sb.append(String.format(locale, "\n\tmode=0x%02X, maxBufferCheckSize=0x%08X(%d), bufferCheckMutSizeSupported=%b)", Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.e), Boolean.valueOf(this.f)));
        if (this.f) {
            sb.append(String.format(locale, "\n\tbufferCheckMutSize=0x%08X(%d)", Integer.valueOf(this.g), Integer.valueOf(this.g)));
        }
        sb.append("\n}");
        return sb.toString();
    }

    public boolean a() {
        return this.d == 1;
    }
}
