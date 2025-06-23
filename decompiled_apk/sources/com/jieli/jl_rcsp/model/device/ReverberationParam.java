package com.jieli.jl_rcsp.model.device;

import com.jieli.jl_rcsp.util.CHexConver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class ReverberationParam {
    public static final int MASK = 1;
    private int depthValue;
    private boolean isOn;
    private int strengthValue;

    public ReverberationParam() {
    }

    public static ReverberationParam parseData(byte[] bArr) {
        if (bArr != null && bArr.length >= 5) {
            boolean z = false;
            if (bArr[0] == 1) {
                z = true;
            }
            return new ReverberationParam(z, CHexConver.bytesToInt(bArr, 1, 2), CHexConver.bytesToInt(bArr, 3, 2));
        }
        return null;
    }

    public int getDepthValue() {
        return this.depthValue;
    }

    public int getStrengthValue() {
        return this.strengthValue;
    }

    public boolean isOn() {
        return this.isOn;
    }

    public void setDepthValue(int i) {
        this.depthValue = i;
    }

    public void setOn(boolean z) {
        this.isOn = z;
    }

    public void setStrengthValue(int i) {
        this.strengthValue = i;
    }

    public byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(CHexConver.intToByte(this.isOn ? 1 : 0));
        try {
            byteArrayOutputStream.write(CHexConver.int2byte2(this.depthValue));
            byteArrayOutputStream.write(CHexConver.int2byte2(this.strengthValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        return "ReverberationParam{isOn=" + this.isOn + ", depthValue=" + this.depthValue + ", strengthValue=" + this.strengthValue + '}';
    }

    public ReverberationParam(boolean z, int i, int i2) {
        setOn(z);
        setDepthValue(i);
        setStrengthValue(i2);
    }
}
