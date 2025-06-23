package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* loaded from: classes11.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet aLI;
    protected boolean aLJ;
    protected boolean aLK;
    protected byte[] aLL;
    protected int aLM;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.aLJ = false;
        this.aLK = false;
        this.aLM = -1;
        this.aLI = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void Ki() {
        int g;
        if (this.aLK && this.aLM >= 0 && (g = n.g(this.aLL, 0)) != this.aLM) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("bad chunk sequence for fDAT chunk " + g + " expected " + this.aLM));
        }
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public final void a(int i, byte[] bArr, int i2, int i3) {
        if (this.aLK && i < 4) {
            while (i < 4 && i3 > 0) {
                this.aLL[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.aLI.c(bArr, i2, i3);
            if (this.aLJ) {
                System.arraycopy(bArr, i2, Kh().data, this.aLb, i3);
            }
        }
    }

    public final void dD(int i) {
        this.aLM = i;
    }
}
