package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes11.dex */
public final class q extends t {
    public q(com.kwad.sdk.pngencrypt.k kVar) {
        super("tEXt", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        String str;
        int i = 0;
        while (true) {
            bArr = dVar.data;
            if (i >= bArr.length || bArr[i] == 0) {
                break;
            } else {
                i++;
            }
        }
        this.key = b.d(bArr, 0, i);
        int i2 = i + 1;
        byte[] bArr2 = dVar.data;
        if (i2 < bArr2.length) {
            str = b.d(bArr2, i2, bArr2.length - i2);
        } else {
            str = "";
        }
        this.aNV = str;
    }
}
