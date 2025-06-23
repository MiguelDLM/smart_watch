package com.sifli.siflidfu;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.OX00O0xII;

/* loaded from: classes11.dex */
public class Utils {
    private static final ByteOrder order = ByteOrder.LITTLE_ENDIAN;

    public static void addIntToByteArray(int i, byte[] bArr, int i2) {
        System.arraycopy(ByteBuffer.allocate(4).order(order).putInt(i).array(), 0, bArr, i2, 4);
    }

    public static void addShortToByteArray(int i, byte[] bArr, int i2) {
        System.arraycopy(ByteBuffer.allocate(2).order(order).putShort((short) i).array(), 0, bArr, i2, 2);
    }

    public static int getIntFromByteArray(byte[] bArr, int i) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, i, bArr2, 0, 4);
        return ByteBuffer.wrap(bArr2, 0, 4).order(order).getInt();
    }

    public static int getUnsignedShortFromByteArray(byte[] bArr, int i) {
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, i, bArr2, 0, 2);
        return ByteBuffer.wrap(bArr2, 0, 2).order(order).getShort() & OX00O0xII.f29066Oxx0xo;
    }
}
