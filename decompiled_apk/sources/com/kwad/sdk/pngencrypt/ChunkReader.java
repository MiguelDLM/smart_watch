package com.kwad.sdk.pngencrypt;

/* loaded from: classes11.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode aKZ;
    private final com.kwad.sdk.pngencrypt.chunk.d aLa;
    private boolean aLd;
    protected int aLb = 0;
    private int aLc = 0;
    protected ErrorBehaviour aLe = ErrorBehaviour.STRICT;

    /* loaded from: classes11.dex */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        boolean z;
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.aKZ = chunkReaderMode;
        if (chunkReaderMode == ChunkReaderMode.BUFFER) {
            z = true;
        } else {
            z = false;
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, z);
        this.aLa = dVar;
        dVar.aK(j);
        this.aLd = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d Kh() {
        return this.aLa;
    }

    public abstract void Ki();

    public abstract void a(int i, byte[] bArr, int i2, int i3);

    @Override // com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("negative length??"));
        }
        if (this.aLb == 0 && this.aLc == 0 && this.aLd) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.aLa;
            dVar.f(dVar.aNh, 0, 4);
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.aLa;
        int i4 = dVar2.len - this.aLb;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.aLc == 0) {
            if (this.aLd && this.aKZ != ChunkReaderMode.BUFFER && i4 > 0) {
                dVar2.f(bArr, i, i4);
            }
            ChunkReaderMode chunkReaderMode = this.aKZ;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.aLa.data;
                if (bArr2 != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, bArr2, this.aLb, i4);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.aLb, bArr, i, i4);
            }
            this.aLb += i4;
            i += i4;
            i2 -= i4;
        }
        int i5 = this.aLb;
        com.kwad.sdk.pngencrypt.chunk.d dVar3 = this.aLa;
        if (i5 == dVar3.len) {
            int i6 = this.aLc;
            int i7 = 4 - i6;
            if (i7 <= i2) {
                i2 = i7;
            }
            if (i2 > 0) {
                byte[] bArr3 = dVar3.aNj;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i, bArr3, i6, i2);
                }
                int i8 = this.aLc + i2;
                this.aLc = i8;
                if (i8 == 4) {
                    if (this.aLd) {
                        if (this.aKZ == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar4 = this.aLa;
                            dVar4.f(dVar4.data, 0, dVar4.len);
                        }
                        com.kwad.sdk.pngencrypt.chunk.d dVar5 = this.aLa;
                        if (this.aLe == ErrorBehaviour.STRICT) {
                            z = true;
                        }
                        dVar5.bI(z);
                    }
                    Ki();
                }
            }
            i3 = i2;
        }
        if (i4 <= 0 && i3 <= 0) {
            return -1;
        }
        return i4 + i3;
    }

    public final void bG(boolean z) {
        this.aLd = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aLa;
        if (dVar == null) {
            if (chunkReader.aLa != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.aLa)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.aLa;
        if (dVar == null) {
            hashCode = 0;
        } else {
            hashCode = dVar.hashCode();
        }
        return hashCode + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        if (this.aLc == 4) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.aLa.toString();
    }
}
