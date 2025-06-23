package com.jieli.jl_bt_ota.model.base;

import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class AttrBean {
    private byte[] attrData;
    private byte type;

    public byte[] getAttrData() {
        return this.attrData;
    }

    public byte[] getData() {
        byte[] bArr = this.attrData;
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 2];
        bArr2[0] = (byte) (length + 1);
        bArr2[1] = this.type;
        System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        return bArr2;
    }

    public byte getType() {
        return this.type;
    }

    public AttrBean setAttrData(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        this.attrData = bArr;
        return this;
    }

    public AttrBean setType(byte b) {
        this.type = b;
        return this;
    }

    public String toString() {
        return "AttrBean{type=" + ((int) this.type) + ", attrData=" + CHexConver.byte2HexStr(this.attrData) + '}';
    }
}
