package com.jieli.jl_rcsp.model.data;

import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CryptoUtil;

/* loaded from: classes10.dex */
public class SendParams extends DataParams {
    private final byte[] data;

    public SendParams(int i, int i2, int i3, int i4, byte[] bArr) {
        super(1, i, i2, i3, i4);
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    public short getDataCrc() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return (short) 0;
        }
        return CryptoUtil.CRC16(bArr, (short) 0);
    }

    public int getDataLen() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    @Override // com.jieli.jl_rcsp.model.data.DataParams
    public String toString() {
        return "SendParams{data=" + CHexConver.bytesToStr(this.data) + ", dataType=" + getDataType() + ", version=" + getVersion() + ", sendLimit=" + getSendLimit() + ", receiveLimit=" + getReceiveLimit() + '}';
    }
}
