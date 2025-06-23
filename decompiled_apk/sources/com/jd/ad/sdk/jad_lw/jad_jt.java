package com.jd.ad.sdk.jad_lw;

/* loaded from: classes10.dex */
public final class jad_jt implements jad_an<byte[]> {
    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public String jad_an() {
        return "ByteArrayPool";
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public int jad_bo() {
        return 1;
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public byte[] newArray(int i) {
        return new byte[i];
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_an
    public int jad_an(byte[] bArr) {
        return bArr.length;
    }
}
