package com.baidu.ar;

import com.baidu.ar.cloud.ICloudIRResult;

/* loaded from: classes7.dex */
public class co implements ICloudIRResult {
    public String arKey;
    public int arType;
    public boolean nB;
    public String nC;

    @Override // com.baidu.ar.cloud.ICloudIRResult
    public String getARKey() {
        return this.arKey;
    }

    @Override // com.baidu.ar.cloud.ICloudIRResult
    public int getARType() {
        return this.arType;
    }

    @Override // com.baidu.ar.cloud.ICloudIRResult
    public String getMessage() {
        return this.nC;
    }

    @Override // com.baidu.ar.cloud.ICloudIRResult
    public boolean isSuccess() {
        return this.nB;
    }
}
