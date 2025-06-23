package com.jieli.jl_rcsp.model.response;

import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class FirmwareUpdateBlockResponse extends CommonResponse {
    private byte[] firmwareUpdateBlockData;

    public byte[] getFirmwareUpdateBlockData() {
        return this.firmwareUpdateBlockData;
    }

    public FirmwareUpdateBlockResponse setFirmwareUpdateBlockData(byte[] bArr) {
        this.firmwareUpdateBlockData = bArr;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.base.CommonResponse
    public String toString() {
        return "FirmwareUpdateBlockResponse{firmwareUpdateBlockData=" + CHexConver.byte2HexStr(this.firmwareUpdateBlockData) + '}';
    }
}
