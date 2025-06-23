package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* loaded from: classes11.dex */
public final class r extends p {
    private int aNN;
    private int aNO;
    private int aNP;
    private int hour;
    private int min;
    private int year;

    public r(com.kwad.sdk.pngencrypt.k kVar) {
        super("tIME", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len == 7) {
            this.year = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            this.aNN = com.kwad.sdk.pngencrypt.n.e(dVar.data, 2);
            this.aNO = com.kwad.sdk.pngencrypt.n.e(dVar.data, 3);
            this.hour = com.kwad.sdk.pngencrypt.n.e(dVar.data, 4);
            this.min = com.kwad.sdk.pngencrypt.n.e(dVar.data, 5);
            this.aNP = com.kwad.sdk.pngencrypt.n.e(dVar.data, 6);
            return;
        }
        throw new PngjException("bad chunk " + dVar);
    }
}
