package com.realsil.sdk.bbpro.core.protocol;

/* loaded from: classes11.dex */
public class CommandContract {
    public static final short CMD_ACK = 0;
    public static final short CMD_DSP_GET_PARAM = 515;
    public static final short CMD_GET_CFG_SETTINGS = 23;
    public static final short CMD_GET_LANGUAGE = 21;
    public static final short CMD_GET_LE_ADDR = 261;
    public static final short CMD_GET_PACKAGE_ID = 783;
    public static final short CMD_GET_STATUS = 24;
    public static final short CMD_INFO_REQ = 12;
    public static final short CMD_LE_GET_ADDR = 261;
    public static final short CMD_MMI = 4;
    public static final short CMD_SET_CONFIGURATION = 18;
    public static final short CMD_SET_LANGUAGE = 22;
    public static final short CMD_TONE_GEN = 8;
    public static final int HEADER_LENGTH = 4;
    public static final byte PARAM_TYPE_CAPABILITY = 1;
    public static final byte PARAM_TYPE_CMD_SET_VERSION = 0;

    public static byte[] buildPacket(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & 255)};
    }

    public static byte[] builderCmdMmiPacket(byte b) {
        return new byte[]{4, 0, 0, b};
    }

    public static byte[] prepareSetConfigurationPacket(byte b, String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[length + 4];
        bArr[0] = 18;
        bArr[1] = 0;
        bArr[2] = b;
        bArr[3] = (byte) length;
        System.arraycopy(bytes, 0, bArr, 4, length);
        return bArr;
    }

    public static byte[] reqCmdInfo(byte b) {
        return new byte[]{12, 0, b};
    }

    public static byte[] buildPacket(short s, byte b) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & 255), b};
    }

    public static byte[] buildPacket(short s, byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        byte[] bArr2 = new byte[length + 2];
        bArr2[0] = (byte) (s & 255);
        bArr2[1] = (byte) ((s >> 8) & 255);
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 2, length);
        }
        return bArr2;
    }
}
