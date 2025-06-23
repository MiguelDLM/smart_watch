package com.jieli.jl_bt_ota.model.parameter;

import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class FirmwareUpdateBlockResponseParam extends FirmwareUpdateBlockParam {
    private byte[] blockData;

    public FirmwareUpdateBlockResponseParam(byte[] bArr) {
        this.blockData = bArr;
    }

    public byte[] getBlockData() {
        return this.blockData;
    }

    @Override // com.jieli.jl_bt_ota.model.parameter.FirmwareUpdateBlockParam, com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        return this.blockData;
    }

    public void setBlockData(byte[] bArr) {
        this.blockData = bArr;
    }

    @Override // com.jieli.jl_bt_ota.model.parameter.FirmwareUpdateBlockParam, com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        return "FirmwareUpdateBlockResponseParam{blockData=" + CHexConver.byte2HexStr(this.blockData) + '}';
    }
}
