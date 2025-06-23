package okio;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;

    @OXOo.OOXIXo
    private final Condition condition;

    @OXOo.OOXIXo
    private final ReentrantLock lock;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j) {
        this.allocatedUntil = j;
        this.waitByteCount = 8192L;
        this.maxByteCount = 262144L;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        IIX0o.oO(newCondition, "newCondition(...)");
        this.condition = newCondition;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j, long j2, long j3, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = throttler.waitByteCount;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            j3 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j, j4, j3);
    }

    private final long bytesToNanos(long j) {
        return (j * C.NANOS_PER_SECOND) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j) {
        return (j * this.bytesPerSecond) / C.NANOS_PER_SECOND;
    }

    public final long byteCountOrWaitNanos$okio(long j, long j2) {
        if (this.bytesPerSecond == 0) {
            return j2;
        }
        long max = Math.max(this.allocatedUntil - j, 0L);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j2) {
            this.allocatedUntil = j + max + bytesToNanos(j2);
            return j2;
        }
        long j3 = this.waitByteCount;
        if (nanosToBytes >= j3) {
            this.allocatedUntil = j + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j3, j2);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos == 0) {
            this.allocatedUntil = j + bytesToNanos(this.maxByteCount);
            return min;
        }
        return -bytesToNanos;
    }

    @XO0OX.xoIox
    public final void bytesPerSecond(long j) {
        bytesPerSecond$default(this, j, 0L, 0L, 6, null);
    }

    @OXOo.OOXIXo
    public final Condition getCondition() {
        return this.condition;
    }

    @OXOo.OOXIXo
    public final ReentrantLock getLock() {
        return this.lock;
    }

    @OXOo.OOXIXo
    public final Sink sink(@OXOo.OOXIXo final Sink sink) {
        IIX0o.x0xO0oo(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler$sink$1
            @Override // okio.ForwardingSink, okio.Sink
            public void write(@OXOo.OOXIXo Buffer source, long j) throws IOException {
                IIX0o.x0xO0oo(source, "source");
                while (j > 0) {
                    try {
                        long take$okio = this.take$okio(j);
                        super.write(source, take$okio);
                        j -= take$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    @OXOo.OOXIXo
    public final Source source(@OXOo.OOXIXo final Source source) {
        IIX0o.x0xO0oo(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler$source$1
            @Override // okio.ForwardingSource, okio.Source
            public long read(@OXOo.OOXIXo Buffer sink, long j) {
                IIX0o.x0xO0oo(sink, "sink");
                try {
                    return super.read(sink, this.take$okio(j));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long j) {
        if (j > 0) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (true) {
                try {
                    long byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j);
                    if (byteCountOrWaitNanos$okio >= 0) {
                        return byteCountOrWaitNanos$okio;
                    }
                    this.condition.awaitNanos(-byteCountOrWaitNanos$okio);
                } finally {
                    reentrantLock.unlock();
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @XO0OX.xoIox
    public final void bytesPerSecond(long j, long j2) {
        bytesPerSecond$default(this, j, j2, 0L, 4, null);
    }

    @XO0OX.xoIox
    public final void bytesPerSecond(long j, long j2, long j3) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (j < 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (j2 <= 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (j3 >= j2) {
                this.bytesPerSecond = j;
                this.waitByteCount = j2;
                this.maxByteCount = j3;
                this.condition.signalAll();
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.");
        } finally {
            reentrantLock.unlock();
        }
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
