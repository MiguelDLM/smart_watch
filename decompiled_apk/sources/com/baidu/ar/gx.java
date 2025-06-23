package com.baidu.ar;

import com.baidu.ar.recg.IOnDeviceIRResult;

/* loaded from: classes7.dex */
public class gx implements IOnDeviceIRResult {
    public String arKey;
    public int arType;
    public boolean nB;
    public String nC;

    @Override // com.baidu.ar.recg.IOnDeviceIRResult
    public String getARKey() {
        return this.arKey;
    }

    @Override // com.baidu.ar.recg.IOnDeviceIRResult
    public int getARType() {
        return this.arType;
    }

    @Override // com.baidu.ar.recg.IOnDeviceIRResult
    public String getMessage() {
        return this.nC;
    }

    @Override // com.baidu.ar.recg.IOnDeviceIRResult
    public boolean isSuccess() {
        return this.nB;
    }
}
