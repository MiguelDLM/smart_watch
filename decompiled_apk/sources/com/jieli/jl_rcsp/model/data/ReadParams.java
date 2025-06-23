package com.jieli.jl_rcsp.model.data;

/* loaded from: classes10.dex */
public class ReadParams extends DataParams {
    private final short crc;
    private final int dataLen;

    public ReadParams(int i, int i2, int i3, int i4, int i5, short s) {
        super(0, i, i2, i3, i4);
        this.dataLen = i5;
        this.crc = s;
    }

    public short getCrc() {
        return this.crc;
    }

    public int getDataLen() {
        return this.dataLen;
    }

    @Override // com.jieli.jl_rcsp.model.data.DataParams
    public String toString() {
        return "ReadParams{dataLen=" + this.dataLen + ", crc=" + ((int) this.crc) + ", dataType=" + getDataType() + ", version=" + getVersion() + ", sendLimit=" + getSendLimit() + ", receiveLimit=" + getReceiveLimit() + "} ";
    }
}
