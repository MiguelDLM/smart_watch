package com.realsil.sdk.bbpro.core.transportlayer;

import com.realsil.sdk.core.logger.ZLogger;
import com.realsil.sdk.core.utility.DataConverter;

/* loaded from: classes11.dex */
public class TransportLayerPacket {
    public static final int HEADER_LENGTH = 4;
    public static final byte SYNC_WORD = -86;

    /* renamed from: a, reason: collision with root package name */
    public byte f19474a = 0;
    public int b = 0;
    public byte[] c = null;
    public short d = -1;
    public byte[] e = null;

    public static TransportLayerPacket builderPacket(byte[] bArr) {
        TransportLayerPacket transportLayerPacket = new TransportLayerPacket();
        if (transportLayerPacket.parse(bArr)) {
            return transportLayerPacket;
        }
        return null;
    }

    public static byte[] encode(int i, short s, byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        byte[] bArr2 = new byte[length + 2];
        bArr2[0] = (byte) (s & 255);
        bArr2[1] = (byte) ((s >> 8) & 255);
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 2, length);
        }
        return encode(i, bArr2);
    }

    public static byte[] encodePayload(short s, byte[] bArr) {
        int i;
        if (bArr != null) {
            i = bArr.length;
        } else {
            i = 0;
        }
        byte[] bArr2 = new byte[i + 2];
        bArr2[0] = (byte) (s & 255);
        bArr2[1] = (byte) ((s >> 8) & 255);
        if (i > 0) {
            System.arraycopy(bArr, 0, bArr2, 2, i);
        }
        return bArr2;
    }

    public short getOpcode() {
        return this.d;
    }

    public int getPacketLength() {
        return this.b + 4;
    }

    public byte[] getParameters() {
        return this.e;
    }

    public byte[] getPayload() {
        return this.c;
    }

    public byte getSeqNum() {
        return this.f19474a;
    }

    public boolean isAckPkt() {
        if (this.d == 0) {
            return true;
        }
        return false;
    }

    public boolean parse(byte[] bArr) {
        if (bArr != null && bArr.length >= 4) {
            byte b = bArr[0];
            this.f19474a = bArr[1];
            int i = ((bArr[3] << 8) | (bArr[2] & 255)) & 65535;
            this.b = i;
            if (b != -86) {
                ZLogger.w(String.format("LT_SYNCWORD_ERROR: %s", DataConverter.bytes2Hex(bArr)));
                return false;
            }
            if (i < 2) {
                ZLogger.w(String.format("LT_PAYLOAD_OPCODE_LENGTH_ERROR: %s", DataConverter.bytes2Hex(bArr)));
                return false;
            }
            if (bArr.length < i + 4) {
                ZLogger.w(String.format("LT_PAYLOAD_LENGTH_ERROR: %s", DataConverter.bytes2Hex(bArr)));
                return false;
            }
            byte[] bArr2 = new byte[i];
            this.c = bArr2;
            System.arraycopy(bArr, 4, bArr2, 0, i);
            byte[] bArr3 = this.c;
            this.d = (short) (((bArr3[0] & 255) | (bArr3[1] << 8)) & 65535);
            int i2 = this.b - 2;
            byte[] bArr4 = new byte[i2];
            this.e = bArr4;
            System.arraycopy(bArr, 6, bArr4, 0, i2);
            return true;
        }
        ZLogger.w("LT_LENGTH_ERROR");
        return false;
    }

    public AckPacket toAckPacket() {
        return AckPacket.builder(this.e);
    }

    public static byte[] encode(int i, byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        byte[] bArr2 = new byte[length + 4];
        bArr2[0] = SYNC_WORD;
        bArr2[1] = (byte) i;
        bArr2[2] = (byte) (length & 255);
        bArr2[3] = (byte) ((length >> 8) & 255);
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 4, length);
        }
        return bArr2;
    }
}
