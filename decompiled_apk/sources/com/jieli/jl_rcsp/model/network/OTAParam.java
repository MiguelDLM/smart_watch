package com.jieli.jl_rcsp.model.network;

/* loaded from: classes10.dex */
public class OTAParam {
    private byte[] otaData;
    private String otaFilePath;

    public OTAParam(byte[] bArr) {
        this(null, bArr);
    }

    public byte[] getOtaData() {
        return this.otaData;
    }

    public String getOtaFilePath() {
        return this.otaFilePath;
    }

    public OTAParam setOtaData(byte[] bArr) {
        this.otaData = bArr;
        return this;
    }

    public OTAParam setOtaFilePath(String str) {
        this.otaFilePath = str;
        return this;
    }

    public String toString() {
        int length;
        StringBuilder sb = new StringBuilder();
        sb.append("OTAParam{otaFilePath='");
        sb.append(this.otaFilePath);
        sb.append('\'');
        sb.append(", otaData=");
        byte[] bArr = this.otaData;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        sb.append(length);
        sb.append('}');
        return sb.toString();
    }

    public OTAParam(String str) {
        this(str, null);
    }

    public OTAParam(String str, byte[] bArr) {
        this.otaFilePath = str;
        this.otaData = bArr;
    }
}
