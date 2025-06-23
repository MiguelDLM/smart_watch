package com.bluetrum.fota.manager;

import androidx.annotation.NonNull;
import com.bluetrum.fota.log.Logger;
import com.realsil.sdk.bbpro.core.transportlayer.TransportLayerPacket;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes8.dex */
final class OtaCommandGenerator {
    public static final byte CMD_GET_INFO = -111;
    public static final byte CMD_GET_INFO_TLV = -110;
    public static final byte CMD_GET_INFO_TYPE_CAPABILITIES = 3;
    public static final byte CMD_GET_INFO_TYPE_CHANNEL = 6;
    public static final byte CMD_GET_INFO_TYPE_STATUS = 4;
    public static final byte CMD_GET_INFO_TYPE_UPDATE = 2;
    public static final byte CMD_GET_INFO_TYPE_VERSION = 1;
    public static final byte CMD_NOTIFY_STATUS = -112;
    private static final byte[] CMD_OTA_IDENTIFICATION = {-52, TransportLayerPacket.SYNC_WORD, 85, -18, 18, 25, -28};
    public static final byte CMD_OTA_INFO = -96;
    public static final byte CMD_SEND_DATA = 32;
    public static final int INFO_CAPABILITIES_TWS = 1;
    public static final byte INFO_CHANNEL_LEFT = 1;
    public static final byte INFO_CHANNEL_RIGHT = 0;
    public static final int INFO_STATUS_TWS_CONNECTED = 1;
    public static final byte STATE_CONTINUE = -2;
    public static final byte STATE_DONE = -1;
    public static final byte STATE_OK = 0;
    public static final byte STATE_PAUSE = -3;
    public static final byte STATE_TWS_DISCONNECTED = Byte.MIN_VALUE;
    private static final String TAG = "OtaCommandGenerator";
    private byte seqNum = 0;

    private byte[] generateCmdGetInfoData(byte b, String str) {
        byte[] bytes = str.getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 2);
        allocate.put(b);
        allocate.put((byte) bytes.length);
        allocate.put(bytes);
        return allocate.array();
    }

    public byte[] cmdDataGetInfoChannel() {
        return generateCmdGetInfoData((byte) 6);
    }

    public byte[] cmdDataGetInfoStatus() {
        return generateCmdGetInfoData((byte) 4);
    }

    public byte[] cmdDataGetInfoTWS() {
        return generateCmdGetInfoData((byte) 3);
    }

    public byte[] cmdDataGetInfoUpdate(int i, byte[] bArr) {
        ByteBuffer order = ByteBuffer.allocate(6).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort((short) i);
        if (bArr != null) {
            order.put(bArr, 0, 4);
        } else {
            order.putInt(-1);
        }
        return generateCmdGetInfoData((byte) 2, order.array());
    }

    public byte[] cmdDataGetInfoVersion() {
        return generateCmdGetInfoData((byte) 1);
    }

    public byte[] cmdGetAllInfo() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(-110);
        byte b = this.seqNum;
        this.seqNum = (byte) (b + 1);
        byteArrayOutputStream.write(b);
        try {
            byteArrayOutputStream.write(cmdDataGetInfoVersion());
            byteArrayOutputStream.write(cmdDataGetInfoTWS());
            byteArrayOutputStream.write(cmdDataGetInfoStatus());
            byteArrayOutputStream.write(cmdDataGetInfoChannel());
        } catch (Exception e) {
            Logger.e(TAG, "Failed to generate Command", e);
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] cmdGetInfoUpdate(int i, @NonNull byte[] bArr) {
        ByteBuffer order = ByteBuffer.allocate(9).order(ByteOrder.LITTLE_ENDIAN);
        order.put(CMD_GET_INFO);
        byte b = this.seqNum;
        this.seqNum = (byte) (b + 1);
        order.put(b);
        order.put((byte) 2);
        order.putShort((short) i);
        order.put(bArr, 0, 4);
        return order.array();
    }

    public byte[] cmdGetInfoVersion() {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.put(CMD_GET_INFO);
        byte b = this.seqNum;
        this.seqNum = (byte) (b + 1);
        allocate.put(b);
        allocate.put((byte) 1);
        return allocate.array();
    }

    public byte[] cmdOtaIdentification() {
        return CMD_OTA_IDENTIFICATION;
    }

    public byte[] cmdSendDataHeader() {
        ByteBuffer order = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
        order.put((byte) 32);
        byte b = this.seqNum;
        this.seqNum = (byte) (b + 1);
        order.put(b);
        return order.array();
    }

    public byte[] cmdStartSendHeader(int i, int i2) {
        ByteBuffer order = ByteBuffer.allocate(10).order(ByteOrder.LITTLE_ENDIAN);
        order.put(CMD_OTA_INFO);
        byte b = this.seqNum;
        this.seqNum = (byte) (b + 1);
        order.put(b);
        order.putInt(i);
        order.putInt(i2);
        return order.array();
    }

    public void reset() {
        Logger.d(TAG, "Reset CommandGenerator");
        this.seqNum = (byte) 0;
    }

    private byte[] generateCmdGetInfoData(byte b, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 2);
        allocate.put(b);
        allocate.put((byte) bArr.length);
        allocate.put(bArr);
        return allocate.array();
    }

    private byte[] generateCmdGetInfoData(byte b, int i) {
        ByteBuffer order = ByteBuffer.allocate(6).order(ByteOrder.LITTLE_ENDIAN);
        order.put(b);
        order.put((byte) 4);
        order.putInt(i);
        return order.array();
    }

    private byte[] generateCmdGetInfoData(byte b, short s) {
        ByteBuffer order = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        order.put(b);
        order.put((byte) 2);
        order.putShort(s);
        return order.array();
    }

    private byte[] generateCmdGetInfoData(byte b, byte b2) {
        ByteBuffer allocate = ByteBuffer.allocate(3);
        allocate.put(b);
        allocate.put((byte) 1);
        allocate.put(b2);
        return allocate.array();
    }

    private byte[] generateCmdGetInfoData(byte b) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.put(b);
        allocate.put((byte) 0);
        return allocate.array();
    }
}
