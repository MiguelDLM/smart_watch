package com.jieli.jl_bt_ota.model.base;

import com.jieli.jl_bt_ota.interfaces.command.IParamBase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class BaseParameter implements IParamBase {
    private byte[] paramData;
    private int xmOpCode = -1;

    @Override // com.jieli.jl_bt_ota.interfaces.command.IParamBase
    public byte[] getParamData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = this.xmOpCode;
        if (i != -1) {
            byteArrayOutputStream.write(i);
        }
        byte[] bArr = this.paramData;
        if (bArr != null && bArr.length > 0) {
            try {
                byteArrayOutputStream.write(bArr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getXmOpCode() {
        return this.xmOpCode;
    }

    public BaseParameter setParamData(byte[] bArr) {
        this.paramData = bArr;
        return this;
    }

    public BaseParameter setXmOpCode(int i) {
        this.xmOpCode = i;
        return this;
    }

    public String toString() {
        return "BaseParameter{xmOpCode=" + this.xmOpCode + '}';
    }
}
