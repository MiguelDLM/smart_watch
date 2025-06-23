package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes10.dex */
public class FirmwareUpdateBlockParam extends BaseParameter {
    private int nextUpdateBlockLen;
    private int nextUpdateBlockOffsetAddr;

    public FirmwareUpdateBlockParam() {
    }

    public int getNextUpdateBlockLen() {
        return this.nextUpdateBlockLen;
    }

    public int getNextUpdateBlockOffsetAddr() {
        return this.nextUpdateBlockOffsetAddr;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(CHexConver.intToBigBytes(this.nextUpdateBlockOffsetAddr));
        allocate.put(CHexConver.int2byte2(this.nextUpdateBlockLen));
        return allocate.array();
    }

    public FirmwareUpdateBlockParam setNextUpdateBlockLen(int i) {
        this.nextUpdateBlockLen = i;
        return this;
    }

    public FirmwareUpdateBlockParam setNextUpdateBlockOffsetAddr(int i) {
        this.nextUpdateBlockOffsetAddr = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "FirmwareUpdateBlockParam{nextUpdateBlockOffsetAddr=" + this.nextUpdateBlockOffsetAddr + ", nextUpdateBlockLen=" + this.nextUpdateBlockLen + '}';
    }

    public FirmwareUpdateBlockParam(int i, int i2) {
        setNextUpdateBlockOffsetAddr(i).setNextUpdateBlockLen(i2);
    }
}
