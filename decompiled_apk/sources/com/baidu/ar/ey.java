package com.baidu.ar;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes7.dex */
class ey implements ev {
    private byte[] mData;

    @Override // com.baidu.ar.ev
    public void a(Charset charset) {
    }

    @Override // com.baidu.ar.ev
    public InputStream[] dI() {
        byte[] bArr = this.mData;
        return (bArr == null || bArr.length <= 0) ? new InputStream[0] : new InputStream[]{new ByteArrayInputStream(this.mData)};
    }

    @Override // com.baidu.ar.ev
    public String getContentType() {
        return null;
    }

    @Override // com.baidu.ar.ev
    public int getSize() {
        byte[] bArr = this.mData;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }
}
