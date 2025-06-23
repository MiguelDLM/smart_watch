package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class StartLargeFileTransferParam extends BaseParameter {
    public short crc16;
    public byte[] hash;
    public int size;

    public StartLargeFileTransferParam(byte[] bArr, int i, short s) {
        this.hash = bArr;
        this.size = i;
        this.crc16 = s;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte[] bArr = new byte[this.hash.length + 6];
        System.arraycopy(CHexConver.intToBigBytes(this.size), 0, bArr, 0, 4);
        System.arraycopy(CHexConver.shortToBigBytes(this.crc16), 0, bArr, 4, 2);
        byte[] bArr2 = this.hash;
        System.arraycopy(bArr2, 0, bArr, 6, bArr2.length);
        return bArr;
    }

    public int getSize() {
        return this.size;
    }

    public StartLargeFileTransferParam setSize(int i) {
        this.size = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "StartLargeFileTransferParam{, hash='" + CHexConver.byte2HexStr(this.hash) + "', size=" + this.size + ", crc16=" + ((int) this.crc16) + "}\n" + super.toString();
    }
}
