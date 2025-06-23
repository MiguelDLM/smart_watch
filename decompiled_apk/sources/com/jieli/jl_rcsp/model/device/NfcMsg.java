package com.jieli.jl_rcsp.model.device;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class NfcMsg {
    public static final int LIMIT_NFC_FILE_NAME = 6;
    public static final int LIMIT_NICKNAME = 24;
    private short crc16;
    private int devHandler;
    private short id;
    private String nfcFileName;
    private int nfcHeadLen;
    private byte[] nfcID;
    private String nickname;
    private byte[] reserve;
    private long updateTime;

    public static NfcMsg parseNfcMsg(byte[] bArr) {
        String str;
        String str2 = null;
        if (bArr == null || bArr.length < 44) {
            return null;
        }
        int bytesToInt = CHexConver.bytesToInt(bArr, 42, 2);
        JL_Log.e("NfcMsg", "parseNfcMsg", "nfcHeadLen = " + bytesToInt + ", data.len = " + bArr.length);
        if (bArr.length != bytesToInt + 44) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.BIG_ENDIAN);
        short s = wrap.getShort();
        byte[] bArr2 = new byte[2];
        wrap.get(bArr2);
        int i = wrap.getInt();
        long intToTime = RcspUtil.intToTime(wrap.getInt());
        byte[] bArr3 = new byte[6];
        wrap.get(bArr3);
        try {
            str = new String(bArr3);
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        byte[] bArr4 = new byte[24];
        wrap.get(bArr4);
        try {
            str2 = new String(bArr4).trim();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        short s2 = wrap.getShort();
        short s3 = 0;
        byte[] bArr5 = new byte[0];
        if (s2 > 2) {
            s3 = wrap.getShort();
            bArr5 = new byte[s2 - 2];
            wrap.get(bArr5);
        }
        return new NfcMsg().setId(s).setReserve(bArr2).setDevHandler(i).setUpdateTime(intToTime).setNfcFileName(str).setNickname(str2).setNfcHeadLen(s2).setCrc16(s3).setNfcID(bArr5);
    }

    public byte[] convertRawData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(CHexConver.shortToBigBytes(this.id));
            if (this.reserve == null) {
                this.reserve = new byte[2];
            }
            byteArrayOutputStream.write(this.reserve);
            byteArrayOutputStream.write(CHexConver.intToBigBytes(this.devHandler));
            byteArrayOutputStream.write(CHexConver.intToBigBytes(RcspUtil.time2Int(this.updateTime)));
            String str = this.nfcFileName;
            if (str != null) {
                byte[] bArr = new byte[6];
                byte[] bytes = str.getBytes();
                System.arraycopy(bytes, 0, bArr, 0, Math.min(24, bytes.length));
                byteArrayOutputStream.write(bArr);
            }
            String str2 = this.nickname;
            if (str2 != null) {
                byte[] bArr2 = new byte[24];
                byte[] bytes2 = str2.getBytes();
                System.arraycopy(bytes2, 0, bArr2, 0, Math.min(24, bytes2.length));
                byteArrayOutputStream.write(bArr2);
            }
            if (this.nfcHeadLen == 0) {
                this.nfcHeadLen = this.nfcID.length + 2;
            }
            byteArrayOutputStream.write(CHexConver.int2byte2(this.nfcHeadLen));
            byteArrayOutputStream.write(CHexConver.shortToBigBytes(this.crc16));
            byteArrayOutputStream.write(this.nfcID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public short getCrc16() {
        return this.crc16;
    }

    public int getDevHandler() {
        return this.devHandler;
    }

    public short getId() {
        return this.id;
    }

    public String getNfcFileName() {
        return this.nfcFileName;
    }

    public int getNfcHeadLen() {
        return this.nfcHeadLen;
    }

    public byte[] getNfcID() {
        return this.nfcID;
    }

    public String getNickname() {
        return this.nickname;
    }

    public byte[] getReserve() {
        return this.reserve;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public NfcMsg setCrc16(short s) {
        this.crc16 = s;
        return this;
    }

    public NfcMsg setDevHandler(int i) {
        this.devHandler = i;
        return this;
    }

    public NfcMsg setId(short s) {
        this.id = s;
        return this;
    }

    public NfcMsg setNfcFileName(String str) {
        this.nfcFileName = str;
        return this;
    }

    public NfcMsg setNfcHeadLen(int i) {
        this.nfcHeadLen = i;
        return this;
    }

    public NfcMsg setNfcID(byte[] bArr) {
        this.nfcID = bArr;
        return this;
    }

    public NfcMsg setNickname(String str) {
        this.nickname = str;
        return this;
    }

    public NfcMsg setReserve(byte[] bArr) {
        this.reserve = bArr;
        return this;
    }

    public NfcMsg setUpdateTime(long j) {
        this.updateTime = j;
        return this;
    }

    public String toString() {
        return "NfcMsg{id=" + ((int) this.id) + ", reserve=" + Arrays.toString(this.reserve) + ", devHandler=" + this.devHandler + ", updateTime=" + this.updateTime + ", nfcFileName='" + this.nfcFileName + "', nickname='" + this.nickname + "', nfcHeadLen=" + this.nfcHeadLen + ", crc16=" + ((int) this.crc16) + ", nfcID=" + Arrays.toString(this.nfcID) + '}';
    }
}
