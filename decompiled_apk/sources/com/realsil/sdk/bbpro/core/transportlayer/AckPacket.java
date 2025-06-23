package com.realsil.sdk.bbpro.core.transportlayer;

import java.util.Locale;

/* loaded from: classes11.dex */
public class AckPacket {
    public static final byte ACK_STATUS_BUSY = 4;
    public static final byte ACK_STATUS_COMPLETE = 0;
    public static final byte ACK_STATUS_DISALLOW = 1;
    public static final byte ACK_STATUS_PARAMETERS_ERROR = 3;
    public static final byte ACK_STATUS_PROCESS_FAIL = 5;
    public static final byte ACK_STATUS_UNKNOWN_COMMAND = 2;
    public static final byte CMD_SET_STATUS_GATT = 17;
    public static final byte CMD_SET_STATUS_GATT_ERROR = 18;
    public static final byte CMD_SET_STATUS_MUSIC_REQ = 8;
    public static final byte CMD_SET_STATUS_ONE_WRITE_EXTEND = 6;
    public static final byte CMD_SET_STATUS_SCENARIO_ERROR = 10;
    public static final byte CMD_SET_STATUS_TTS_REQ = 7;
    public static final byte CMD_SET_STATUS_VERSION_INCOMPATIBLE = 9;

    /* renamed from: a, reason: collision with root package name */
    public short f19463a = 0;
    public byte b = 0;

    public static AckPacket builder(byte[] bArr) {
        AckPacket ackPacket = new AckPacket();
        if (ackPacket.parse(bArr)) {
            return ackPacket;
        }
        return null;
    }

    public static byte[] encode(short s, byte b) {
        return new byte[]{0, 0, (byte) (s & 255), (byte) ((s >> 8) & 255), b};
    }

    public byte getStatus() {
        return this.b;
    }

    public short getToAckId() {
        return this.f19463a;
    }

    public boolean parse(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return false;
        }
        this.f19463a = (short) (((bArr[0] & 255) | (bArr[1] << 8)) & 65535);
        this.b = (byte) (bArr[2] & 255);
        return true;
    }

    public String toString() {
        return "ACK {" + String.format(Locale.US, "\n\topcode=0x%04X, status=0x%02X", Short.valueOf(this.f19463a), Byte.valueOf(this.b)) + "\n}";
    }
}
