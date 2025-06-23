package com.jieli.jl_rcsp.model.parameter;

import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class SearchDevParam extends BaseParameter {
    private int op;
    private int player = 0;
    private int timeoutSec;
    private int type;
    private int way;

    /* loaded from: classes10.dex */
    public static class SearchDevResultParam extends SearchDevParam {
        private final int result;

        public SearchDevResultParam(int i) {
            this.result = i;
        }

        @Override // com.jieli.jl_rcsp.model.parameter.SearchDevParam, com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            return new byte[]{CHexConver.intToByte(this.result)};
        }

        public int getResult() {
            return this.result;
        }
    }

    public SearchDevParam() {
    }

    public int getOp() {
        return this.op;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
    public byte[] getParamData() {
        byte[] int2byte2 = CHexConver.int2byte2(this.timeoutSec);
        System.arraycopy(int2byte2, 0, r0, 2, int2byte2.length);
        byte[] bArr = {CHexConver.intToByte(this.type), CHexConver.intToByte(this.op), 0, 0, CHexConver.intToByte(this.way), CHexConver.intToByte(this.player)};
        return bArr;
    }

    public int getPlayer() {
        return this.player;
    }

    public int getTimeoutSec() {
        return this.timeoutSec;
    }

    public int getType() {
        return this.type;
    }

    public int getWay() {
        return this.way;
    }

    public SearchDevParam setOp(int i) {
        this.op = i;
        return this;
    }

    public SearchDevParam setPlayer(int i) {
        this.player = i;
        return this;
    }

    public SearchDevParam setTimeoutSec(int i) {
        this.timeoutSec = i;
        return this;
    }

    public SearchDevParam setType(int i) {
        this.type = i;
        return this;
    }

    public SearchDevParam setWay(int i) {
        this.way = i;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.BaseParameter
    public String toString() {
        return "SearchDevParam{type=" + this.type + ", op=" + this.op + ", timeoutSec=" + this.timeoutSec + "} " + super.toString();
    }

    public SearchDevParam(int i, int i2, int i3) {
        setType(i).setOp(i2).setTimeoutSec(i3);
    }
}
