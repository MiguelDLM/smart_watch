package com.garmin.fit;

import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes9.dex */
public class ooOx {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final XI0oooXX f14969II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Oxx f14970oIX0oI;

    public ooOx(XI0oooXX xI0oooXX, Oxx oxx) {
        this.f14969II0xO0 = xI0oooXX;
        this.f14970oIX0oI = oxx;
    }

    public short I0Io() {
        Short OO02 = this.f14970oIX0oI.OO0();
        if (OO02 == null) {
            return (short) 255;
        }
        return OO02.shortValue();
    }

    public long II0xO0() {
        Long oXIoO2 = this.f14969II0xO0.oXIoO();
        if (oXIoO2 == null) {
            return 65535L;
        }
        return oXIoO2.longValue();
    }

    public UUID oIX0oI() {
        Byte[] OX2 = this.f14969II0xO0.OX();
        if (OX2 != null && OX2.length == 16) {
            byte[] bArr = new byte[OX2.length];
            for (byte b = 0; b < OX2.length; b = (byte) (b + 1)) {
                Byte b2 = OX2[b];
                if (b2 != null) {
                    bArr[b] = b2.byteValue();
                } else {
                    bArr[b] = -1;
                }
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            return new UUID(wrap.getLong(), wrap.getLong());
        }
        return null;
    }
}
