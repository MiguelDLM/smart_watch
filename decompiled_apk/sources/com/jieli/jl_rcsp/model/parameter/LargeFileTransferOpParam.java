package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class LargeFileTransferOpParam extends BaseParameter {
    private short buffer;
    private int offset;
    private byte op;

    public LargeFileTransferOpParam(byte b, short s, int i) {
        this.buffer = s;
        this.offset = i;
        this.op = b;
    }

    public short getBuffer() {
        return this.buffer;
    }

    public int getOffset() {
        return this.offset;
    }

    public byte getOp() {
        return this.op;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte[] bArr = new byte[7];
        bArr[0] = this.op;
        System.arraycopy(CHexConver.shortToBigBytes(this.buffer), 0, bArr, 1, 2);
        System.arraycopy(CHexConver.intToBigBytes(this.offset), 0, bArr, 3, 4);
        return bArr;
    }

    public void setBuffer(short s) {
        this.buffer = s;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setOp(byte b) {
        this.op = b;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "LargeFileTransferOpParam{buffer=" + ((int) this.buffer) + ", offset=" + this.offset + ", op=" + ((int) this.op) + '}';
    }
}
