package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nCipherSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CipherSource.kt\nokio/CipherSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
/* loaded from: classes6.dex */
public final class CipherSource implements Source {
    private final int blockSize;

    @OXOo.OOXIXo
    private final Buffer buffer;

    @OXOo.OOXIXo
    private final Cipher cipher;
    private boolean closed;

    /* renamed from: final, reason: not valid java name */
    private boolean f11final;

    @OXOo.OOXIXo
    private final BufferedSource source;

    public CipherSource(@OXOo.OOXIXo BufferedSource source, @OXOo.OOXIXo Cipher cipher) {
        IIX0o.x0xO0oo(source, "source");
        IIX0o.x0xO0oo(cipher, "cipher");
        this.source = source;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        this.buffer = new Buffer();
        if (blockSize > 0) {
            return;
        }
        throw new IllegalArgumentException(("Block cipher required " + cipher).toString());
    }

    private final void doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.pos);
        writableSegment$okio.limit += doFinal;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + doFinal);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    private final void refill() {
        while (this.buffer.size() == 0 && !this.f11final) {
            if (this.source.exhausted()) {
                this.f11final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() {
        Segment segment = this.source.getBuffer().head;
        IIX0o.ooOOo0oXI(segment);
        int i = segment.limit - segment.pos;
        int outputSize = this.cipher.getOutputSize(i);
        while (outputSize > 8192) {
            int i2 = this.blockSize;
            if (i <= i2) {
                this.f11final = true;
                Buffer buffer = this.buffer;
                byte[] doFinal = this.cipher.doFinal(this.source.readByteArray());
                IIX0o.oO(doFinal, "doFinal(...)");
                buffer.write(doFinal);
                return;
            }
            i -= i2;
            outputSize = this.cipher.getOutputSize(i);
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int update = this.cipher.update(segment.data, segment.pos, i, writableSegment$okio.data, writableSegment$okio.pos);
        this.source.skip(i);
        writableSegment$okio.limit += update;
        Buffer buffer2 = this.buffer;
        buffer2.setSize$okio(buffer2.size() + update);
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    @OXOo.OOXIXo
    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override // okio.Source
    public long read(@OXOo.OOXIXo Buffer sink, long j) throws IOException {
        IIX0o.x0xO0oo(sink, "sink");
        if (j >= 0) {
            if (!this.closed) {
                if (j == 0) {
                    return 0L;
                }
                refill();
                return this.buffer.read(sink, j);
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
    }

    @Override // okio.Source
    @OXOo.OOXIXo
    public Timeout timeout() {
        return this.source.timeout();
    }
}
