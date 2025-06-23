package com.jieli.jl_bt_ota.model.parameter;

import com.jieli.jl_bt_ota.model.base.BaseParameter;
import com.jieli.jl_bt_ota.util.CHexConver;

/* loaded from: classes10.dex */
public class CustomParam extends BaseParameter {
    private byte[] data;

    public CustomParam(byte[] bArr) {
        this.data = bArr;
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter, com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return new byte[0];
        }
        return bArr;
    }

    public void setData(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        this.data = bArr;
    }

    @Override // com.jieli.jl_bt_ota.model.base.BaseParameter
    public String toString() {
        return "CustomParam{data=" + CHexConver.byte2HexStr(this.data) + '}';
    }

    public CustomParam() {
    }
}
