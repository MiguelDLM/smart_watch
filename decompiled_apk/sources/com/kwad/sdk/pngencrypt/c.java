package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes11.dex */
public final class c extends b {
    protected k aLs;
    protected k aLt;
    protected e aLu;
    protected int aLv = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e aLw = null;
    private long aLy = 0;
    private boolean aLz = true;
    private boolean aLA = false;
    private Set<String> aLB = new HashSet();
    private long aLC = 0;
    private long aLD = 0;
    private long aLE = 0;
    private ChunkLoadBehaviour aLG = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean aLx = false;
    private g aLF = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aLH;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            aLH = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aLH[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z) {
    }

    private int Ko() {
        return this.aLv;
    }

    private k Kt() {
        return this.aLt;
    }

    private void go(String str) {
        if (str.equals("IHDR")) {
            if (this.aLv < 0) {
                this.aLv = 0;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("PLTE")) {
            int i = this.aLv;
            if (i != 0 && i != 1) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk here " + str));
                return;
            }
            this.aLv = 2;
            return;
        }
        if (str.equals("IDAT")) {
            int i2 = this.aLv;
            if (i2 >= 0 && i2 <= 4) {
                this.aLv = 4;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        if (str.equals("IEND")) {
            if (this.aLv >= 4) {
                this.aLv = 6;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
            return;
        }
        int i3 = this.aLv;
        if (i3 <= 1) {
            this.aLv = 1;
        } else if (i3 <= 3) {
            this.aLv = 3;
        } else {
            this.aLv = 5;
        }
    }

    private static boolean gp(String str) {
        if (!com.kwad.sdk.pngencrypt.chunk.b.gs(str)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean Kj() {
        return this.aLz;
    }

    public final boolean Kp() {
        if (Ko() < 4) {
            return true;
        }
        return false;
    }

    public final j Kq() {
        DeflatedChunksSet Kl = Kl();
        if (Kl instanceof j) {
            return (j) Kl;
        }
        return null;
    }

    public final k Kr() {
        return this.aLs;
    }

    public final e Ks() {
        return this.aLu;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.Kh().ahY.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.Kh());
            k Lc = iVar.Lc();
            this.aLs = Lc;
            this.aLt = Lc;
            if (iVar.La()) {
                this.aLu = new e(this.aLt);
            }
            this.aLw = new com.kwad.sdk.pngencrypt.chunk.e(this.aLs);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.aKZ;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && gp(chunkReader.Kh().ahY)) {
            this.aLy += chunkReader.Kh().len;
        }
        if (chunkReader.aKZ != chunkReaderMode2 && !this.aLA) {
            return;
        }
        this.aLw.a(this.aLF.a(chunkReader.Kh(), Kr()), this.aLv);
    }

    public final void aH(long j) {
        this.aLC = j;
    }

    public final void aI(long j) {
        this.aLD = j;
    }

    public final void aJ(long j) {
        this.aLE = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i, int i2) {
        return super.b(bArr, i, i2);
    }

    public final void bH(boolean z) {
        this.aLz = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void c(int i, String str, long j) {
        go(str);
        super.c(i, str, j);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.aLv != 6) {
            this.aLv = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final DeflatedChunksSet gm(String str) {
        return new j(str, this.aLx, Kt(), this.aLu);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean gn(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean v(int i, String str) {
        if (super.v(i, str)) {
            return true;
        }
        if (this.aLC > 0 && i + Kk() > this.aLC) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.aLC + " offset:" + Kk() + " len=" + i));
        }
        if (this.aLB.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.gs(str)) {
            return false;
        }
        long j = this.aLD;
        if (j > 0 && i > j) {
            return true;
        }
        long j2 = this.aLE;
        if (j2 > 0 && i > j2 - this.aLy) {
            return true;
        }
        int i2 = AnonymousClass1.aLH[this.aLG.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.gu(str)) {
            return true;
        }
        return false;
    }
}
