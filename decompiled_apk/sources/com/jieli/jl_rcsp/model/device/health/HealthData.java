package com.jieli.jl_rcsp.model.device.health;

import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class HealthData {
    public byte[] data;
    public byte subMask;
    public int type;
    public int version;

    public HealthData(int i, byte b, byte[] bArr, int i2) {
        this.type = i;
        this.subMask = b;
        this.data = bArr;
        this.version = i2;
    }

    public String toString() {
        return "healthData : type=" + this.type + ", subMask=" + ((int) this.subMask) + ",version=" + this.version + ", data=" + CHexConver.byte2HexStr(this.data);
    }
}
