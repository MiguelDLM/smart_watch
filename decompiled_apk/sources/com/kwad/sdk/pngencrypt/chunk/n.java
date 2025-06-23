package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes11.dex */
public final class n extends k {
    private String aNJ;
    private int aNK;
    private int[] aNL;

    public n(com.kwad.sdk.pngencrypt.k kVar) {
        super("sPLT", kVar);
    }

    public final String Le() {
        return this.aNJ;
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        byte[] bArr;
        int i;
        int f;
        int f2;
        int f3;
        int f4;
        int i2;
        int i3 = 0;
        while (true) {
            bArr = dVar.data;
            if (i3 < bArr.length) {
                if (bArr[i3] == 0) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 > 0 && i3 <= bArr.length - 2) {
            this.aNJ = b.d(bArr, 0, i3);
            int e = com.kwad.sdk.pngencrypt.n.e(dVar.data, i3 + 1);
            this.aNK = e;
            int i4 = i3 + 2;
            int length = dVar.data.length - i4;
            if (e == 8) {
                i = 6;
            } else {
                i = 10;
            }
            int i5 = length / i;
            this.aNL = new int[i5 * 5];
            int i6 = i4;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                if (this.aNK == 8) {
                    f = com.kwad.sdk.pngencrypt.n.e(dVar.data, i6);
                    f2 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i6 + 1);
                    int i9 = i6 + 3;
                    f3 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i6 + 2);
                    i2 = i6 + 4;
                    f4 = com.kwad.sdk.pngencrypt.n.e(dVar.data, i9);
                } else {
                    f = com.kwad.sdk.pngencrypt.n.f(dVar.data, i6);
                    f2 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i6 + 2);
                    f3 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i6 + 4);
                    f4 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i6 + 6);
                    i2 = i6 + 8;
                }
                int f5 = com.kwad.sdk.pngencrypt.n.f(dVar.data, i2);
                i6 = i2 + 2;
                int[] iArr = this.aNL;
                iArr[i7] = f;
                iArr[i7 + 1] = f2;
                iArr[i7 + 2] = f3;
                int i10 = i7 + 4;
                iArr[i7 + 3] = f4;
                i7 += 5;
                iArr[i10] = f5;
            }
            return;
        }
        throw new PngjException("bad sPLT chunk: no separator found");
    }
}
