package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: classes11.dex */
public final class s extends p {
    private int aNQ;
    private int aNR;
    private int aNS;
    private int aNT;
    private int[] aNU;

    public s(com.kwad.sdk.pngencrypt.k kVar) {
        super("tRNS", kVar);
        this.aNU = new int[0];
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        com.kwad.sdk.pngencrypt.k kVar = this.aMq;
        if (kVar.aMx) {
            this.aNQ = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
            return;
        }
        if (kVar.aMy) {
            int length = dVar.data.length;
            this.aNU = new int[length];
            for (int i = 0; i < length; i++) {
                this.aNU[i] = dVar.data[i] & 255;
            }
            return;
        }
        this.aNR = com.kwad.sdk.pngencrypt.n.f(dVar.data, 0);
        this.aNS = com.kwad.sdk.pngencrypt.n.f(dVar.data, 2);
        this.aNT = com.kwad.sdk.pngencrypt.n.f(dVar.data, 4);
    }
}
