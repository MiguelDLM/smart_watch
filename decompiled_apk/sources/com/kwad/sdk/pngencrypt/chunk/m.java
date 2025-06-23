package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes11.dex */
public final class m extends p {
    private int aNH;
    private int[] aNI;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.aNH = 0;
    }

    private void dW(int i) {
        this.aNH = i;
        if (i > 0 && i <= 256) {
            int[] iArr = this.aNI;
            if (iArr == null || iArr.length != i) {
                this.aNI = new int[i];
                return;
            }
            return;
        }
        throw new PngjException("invalid pallette - nentries=" + this.aNH);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        dW(dVar.len / 3);
        int i = 0;
        for (int i2 = 0; i2 < this.aNH; i2++) {
            byte[] bArr = dVar.data;
            int i3 = bArr[i] & 255;
            int i4 = i + 2;
            int i5 = bArr[i + 1] & 255;
            i += 3;
            a(i2, i3, i5, bArr[i4] & 255);
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        this.aNI[i] = (i2 << 16) | (i3 << 8) | i4;
    }
}
