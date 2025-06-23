package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes11.dex */
public final class l extends p {
    private long aNE;
    private long aNF;
    private int aNG;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 9) {
            long g = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
            this.aNE = g;
            if (g < 0) {
                this.aNE = g + 4294967296L;
            }
            long g2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
            this.aNF = g2;
            if (g2 < 0) {
                this.aNF = g2 + 4294967296L;
            }
            this.aNG = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
            return;
        }
        throw new PngjException("bad chunk length " + dVar);
    }
}
