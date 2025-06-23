package com.jieli.jl_rcsp.model.device;

import java.util.Arrays;

/* loaded from: classes10.dex */
public class NfcFile {
    private NfcMsg message;
    private byte[] nfcData;

    public NfcFile(NfcMsg nfcMsg, byte[] bArr) {
        setMessage(nfcMsg);
        setNfcData(bArr);
    }

    public byte[] convertRawData() {
        int i;
        byte[] convertRawData = this.message.convertRawData();
        byte[] bArr = new byte[convertRawData.length + this.nfcData.length];
        if (convertRawData.length > 0) {
            System.arraycopy(convertRawData, 0, bArr, 0, convertRawData.length);
            i = convertRawData.length;
        } else {
            i = 0;
        }
        byte[] bArr2 = this.nfcData;
        if (bArr2.length > 0) {
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        }
        return bArr;
    }

    public NfcMsg getMessage() {
        return this.message;
    }

    public byte[] getNfcData() {
        return this.nfcData;
    }

    public void setMessage(NfcMsg nfcMsg) {
        this.message = nfcMsg;
    }

    public void setNfcData(byte[] bArr) {
        this.nfcData = bArr;
    }

    public String toString() {
        return "NfcFile{message=" + this.message + ", nfcData=" + Arrays.toString(this.nfcData) + '}';
    }
}
