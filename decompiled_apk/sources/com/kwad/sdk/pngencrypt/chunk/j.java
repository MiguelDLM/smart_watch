package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes11.dex */
public final class j extends t {
    private boolean aNB;
    private String aNC;
    private String aND;

    public j(com.kwad.sdk.pngencrypt.k kVar) {
        super("iTXt", kVar);
        this.aNB = false;
        this.aNC = "";
        this.aND = "";
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        boolean z;
        int[] iArr = new int[3];
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = dVar.data;
            if (i >= bArr.length) {
                break;
            }
            if (bArr[i] == 0) {
                iArr[i2] = i;
                i2++;
                if (i2 == 1) {
                    i += 2;
                }
                if (i2 == 3) {
                    break;
                }
            }
            i++;
        }
        if (i2 != 3) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk"));
        }
        this.key = b.d(dVar.data, 0, iArr[0]);
        int i3 = iArr[0];
        byte[] bArr2 = dVar.data;
        if (bArr2[i3 + 1] == 0) {
            z = false;
        } else {
            z = true;
        }
        this.aNB = z;
        int i4 = i3 + 2;
        if (z && bArr2[i4] != 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad formed PngChunkITXT chunk - bad compression method "));
        }
        this.aNC = b.d(dVar.data, i4, iArr[1] - i4);
        byte[] bArr3 = dVar.data;
        int i5 = iArr[1];
        this.aND = b.e(bArr3, i5 + 1, (iArr[2] - i5) - 1);
        int i6 = iArr[2] + 1;
        if (this.aNB) {
            byte[] bArr4 = dVar.data;
            this.aNV = b.j(b.b(bArr4, i6, bArr4.length - i6, false));
        } else {
            byte[] bArr5 = dVar.data;
            this.aNV = b.e(bArr5, i6, bArr5.length - i6);
        }
    }
}
