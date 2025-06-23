package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class DelDevFileParam extends BaseParameter {
    private final int cluster;
    private final int devHandle;
    private final boolean last;
    private final byte type;

    public DelDevFileParam(int i, byte b, int i2, boolean z) {
        this.devHandle = i;
        this.type = b;
        this.cluster = i2;
        this.last = z;
    }

    public int getCluster() {
        return this.cluster;
    }

    public int getDevHandle() {
        return this.devHandle;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte[] bArr = new byte[10];
        bArr[0] = this.last ? (byte) 1 : (byte) 0;
        System.arraycopy(CHexConver.intToBigBytes(this.devHandle), 0, bArr, 1, 4);
        bArr[5] = this.type;
        System.arraycopy(CHexConver.intToBigBytes(this.cluster), 0, bArr, 6, 4);
        return bArr;
    }

    public byte getType() {
        return this.type;
    }

    public boolean isLast() {
        return this.last;
    }
}
