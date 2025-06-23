package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: classes11.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] aLf;
    private final int aLg;
    private byte[] aLh;
    private int aLi;
    protected boolean aLj;
    protected boolean aLk;
    private int aLl;
    private long aLm;
    private DeflatedChunksSet aLn;
    private ChunkReader aLo;
    private long aLp;
    private ErrorBehaviour aLq;
    protected boolean closed;

    public b() {
        this(n.KL());
    }

    private static String Km() {
        return "IHDR";
    }

    private static String Kn() {
        return "IEND";
    }

    private ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void Ki() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void a(int i2, byte[] bArr, int i3, int i4) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("should never happen"));
            }
        };
    }

    private static void h(byte[] bArr) {
        if (!Arrays.equals(bArr, n.KL())) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
        }
    }

    public boolean Kj() {
        return true;
    }

    public final long Kk() {
        return this.aLm;
    }

    public final DeflatedChunksSet Kl() {
        return this.aLn;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen. Bad length: " + i2));
        }
        if (this.aLj) {
            ChunkReader chunkReader = this.aLo;
            if (chunkReader != null && !chunkReader.isDone()) {
                int b = this.aLo.b(bArr, i, i2);
                if (b < 0) {
                    return -1;
                }
                this.aLm += b;
                return b;
            }
            int i3 = this.aLi;
            int i4 = 8 - i3;
            if (i4 <= i2) {
                i2 = i4;
            }
            System.arraycopy(bArr, i, this.aLh, i3, i2);
            int i5 = this.aLi + i2;
            this.aLi = i5;
            this.aLm += i2;
            if (i5 == 8) {
                this.aLl++;
                c(n.g(this.aLh, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aLh, 4), this.aLm - 8);
                this.aLi = 0;
            }
        } else {
            int i6 = this.aLg;
            int i7 = this.aLi;
            int i8 = i6 - i7;
            if (i8 <= i2) {
                i2 = i8;
            }
            System.arraycopy(bArr, i, this.aLh, i7, i2);
            int i9 = this.aLi + i2;
            this.aLi = i9;
            if (i9 == this.aLg) {
                h(this.aLh);
                this.aLi = 0;
                this.aLj = true;
            }
            this.aLm += i2;
        }
        return i2;
    }

    public void c(int i, String str, long j) {
        boolean z;
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.aNg.matcher(str).matches()) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk len: " + i));
        }
        if (str.equals("IDAT")) {
            this.aLp += i;
        }
        boolean Kj = Kj();
        boolean v = v(i, str);
        boolean gn = gn(str);
        DeflatedChunksSet deflatedChunksSet = this.aLn;
        if (deflatedChunksSet != null && !deflatedChunksSet.isClosed()) {
            z = this.aLn.gq(str);
        } else {
            z = false;
        }
        if (gn && !v) {
            if (!z) {
                DeflatedChunksSet deflatedChunksSet2 = this.aLn;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.aLn = gm(str);
            }
            this.aLo = new d(i, str, Kj, j, this.aLn) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void Ki() {
                    super.Ki();
                    b.this.a(this);
                }
            };
        } else {
            this.aLo = a(str, i, j, v);
        }
        ChunkReader chunkReader = this.aLo;
        if (chunkReader != null && !Kj) {
            chunkReader.bG(false);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aLn;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    public abstract DeflatedChunksSet gm(String str);

    public boolean gn(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aLk;
    }

    public boolean v(int i, String str) {
        return false;
    }

    private b(byte[] bArr) {
        this.aLh = new byte[8];
        this.aLi = 0;
        this.aLj = false;
        this.aLk = false;
        this.closed = false;
        this.aLl = 0;
        this.aLm = 0L;
        this.aLq = ErrorBehaviour.STRICT;
        this.aLf = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.aLg = length;
        this.aLj = length <= 0;
    }

    public void a(ChunkReader chunkReader) {
        if (this.aLl == 1 && !Km().equals(chunkReader.Kh().ahY)) {
            String str = "Bad first chunk: " + chunkReader.Kh().ahY + " expected: " + Km();
            if (this.aLq.c < ErrorBehaviour.SUPER_LENIENT.c) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", str);
            }
        }
        Kn();
        if (chunkReader.Kh().ahY.equals(Kn())) {
            this.aLk = true;
            close();
        }
    }
}
