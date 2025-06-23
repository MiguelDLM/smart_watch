package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nPipe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipe.kt\nokio/Pipe\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Timeout.kt\nokio/Timeout\n*L\n1#1,257:1\n1#2:258\n268#3,26:259\n*S KotlinDebug\n*F\n+ 1 Pipe.kt\nokio/Pipe\n*L\n217#1:259,26\n*E\n"})
/* loaded from: classes6.dex */
public final class Pipe {

    @OXOo.OOXIXo
    private final Buffer buffer = new Buffer();
    private boolean canceled;

    @OXOo.OOXIXo
    private final Condition condition;

    @OXOo.oOoXoXO
    private Sink foldedSink;

    @OXOo.OOXIXo
    private final ReentrantLock lock;
    private final long maxBufferSize;

    @OXOo.OOXIXo
    private final Sink sink;
    private boolean sinkClosed;

    @OXOo.OOXIXo
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j) {
        this.maxBufferSize = j;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        IIX0o.oO(newCondition, "newCondition(...)");
        this.condition = newCondition;
        if (j >= 1) {
            this.sink = new Sink() { // from class: okio.Pipe$sink$1

                @OXOo.OOXIXo
                private final Timeout timeout = new Timeout();

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    ReentrantLock lock = Pipe.this.getLock();
                    Pipe pipe = Pipe.this;
                    lock.lock();
                    try {
                        if (pipe.getSinkClosed$okio()) {
                            lock.unlock();
                            return;
                        }
                        Sink foldedSink$okio = pipe.getFoldedSink$okio();
                        if (foldedSink$okio == null) {
                            if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            pipe.setSinkClosed$okio(true);
                            pipe.getCondition().signalAll();
                            foldedSink$okio = null;
                        }
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                        lock.unlock();
                        if (foldedSink$okio != null) {
                            Pipe pipe2 = Pipe.this;
                            Timeout timeout = foldedSink$okio.timeout();
                            Timeout timeout2 = pipe2.sink().timeout();
                            long timeoutNanos = timeout.timeoutNanos();
                            long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            timeout.timeout(minTimeout, timeUnit);
                            if (timeout.hasDeadline()) {
                                long deadlineNanoTime = timeout.deadlineNanoTime();
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                                }
                                try {
                                    foldedSink$okio.close();
                                    timeout.timeout(timeoutNanos, timeUnit);
                                    if (timeout2.hasDeadline()) {
                                        timeout.deadlineNanoTime(deadlineNanoTime);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.hasDeadline()) {
                                        timeout.deadlineNanoTime(deadlineNanoTime);
                                    }
                                    throw th;
                                }
                            }
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            } catch (Throwable th2) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        lock.unlock();
                        throw th3;
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    ReentrantLock lock = Pipe.this.getLock();
                    Pipe pipe = Pipe.this;
                    lock.lock();
                    try {
                        if (!pipe.getSinkClosed$okio()) {
                            if (!pipe.getCanceled$okio()) {
                                Sink foldedSink$okio = pipe.getFoldedSink$okio();
                                if (foldedSink$okio == null) {
                                    if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0) {
                                        throw new IOException("source is closed");
                                    }
                                    foldedSink$okio = null;
                                }
                                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                                lock.unlock();
                                if (foldedSink$okio != null) {
                                    Pipe pipe2 = Pipe.this;
                                    Timeout timeout = foldedSink$okio.timeout();
                                    Timeout timeout2 = pipe2.sink().timeout();
                                    long timeoutNanos = timeout.timeoutNanos();
                                    long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
                                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                                    timeout.timeout(minTimeout, timeUnit);
                                    if (timeout.hasDeadline()) {
                                        long deadlineNanoTime = timeout.deadlineNanoTime();
                                        if (timeout2.hasDeadline()) {
                                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                                        }
                                        try {
                                            foldedSink$okio.flush();
                                            timeout.timeout(timeoutNanos, timeUnit);
                                            if (timeout2.hasDeadline()) {
                                                timeout.deadlineNanoTime(deadlineNanoTime);
                                                return;
                                            }
                                            return;
                                        } catch (Throwable th) {
                                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                            if (timeout2.hasDeadline()) {
                                                timeout.deadlineNanoTime(deadlineNanoTime);
                                            }
                                            throw th;
                                        }
                                    }
                                    if (timeout2.hasDeadline()) {
                                        timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                    }
                                    try {
                                        foldedSink$okio.flush();
                                        timeout.timeout(timeoutNanos, timeUnit);
                                        if (timeout2.hasDeadline()) {
                                            timeout.clearDeadline();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                        if (timeout2.hasDeadline()) {
                                            timeout.clearDeadline();
                                        }
                                        throw th2;
                                    }
                                }
                                return;
                            }
                            throw new IOException("canceled");
                        }
                        throw new IllegalStateException("closed");
                    } catch (Throwable th3) {
                        lock.unlock();
                        throw th3;
                    }
                }

                @Override // okio.Sink
                @OXOo.OOXIXo
                public Timeout timeout() {
                    return this.timeout;
                }

                /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
                
                    r1 = kotlin.oXIO0o0XI.f29392oIX0oI;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
                
                    r0.unlock();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
                
                    if (r2 == null) goto L57;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:37:0x007f, code lost:
                
                    r0 = r12.this$0;
                    r1 = r2.timeout();
                    r0 = r0.sink().timeout();
                    r3 = r1.timeoutNanos();
                    r5 = okio.Timeout.Companion.minTimeout(r0.timeoutNanos(), r1.timeoutNanos());
                    r7 = java.util.concurrent.TimeUnit.NANOSECONDS;
                    r1.timeout(r5, r7);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
                
                    if (r1.hasDeadline() == false) goto L45;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:39:0x00aa, code lost:
                
                    r5 = r1.deadlineNanoTime();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
                
                    if (r0.hasDeadline() == false) goto L66;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:41:0x00b4, code lost:
                
                    r1.deadlineNanoTime(java.lang.Math.min(r1.deadlineNanoTime(), r0.deadlineNanoTime()));
                 */
                /* JADX WARN: Code restructure failed: missing block: B:43:0x00c3, code lost:
                
                    r2.write(r13, r14);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:44:0x00c6, code lost:
                
                    r1.timeout(r3, r7);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:45:0x00cd, code lost:
                
                    if (r0.hasDeadline() == false) goto L78;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:46:0x00cf, code lost:
                
                    r1.deadlineNanoTime(r5);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:50:0x00d3, code lost:
                
                    r13 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:51:0x00d4, code lost:
                
                    r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:52:0x00dd, code lost:
                
                    if (r0.hasDeadline() != false) goto L43;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:53:0x00df, code lost:
                
                    r1.deadlineNanoTime(r5);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
                
                    throw r13;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:56:0x00e7, code lost:
                
                    if (r0.hasDeadline() == false) goto L64;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:57:0x00e9, code lost:
                
                    r1.deadlineNanoTime(r0.deadlineNanoTime());
                 */
                /* JADX WARN: Code restructure failed: missing block: B:59:0x00f0, code lost:
                
                    r2.write(r13, r14);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:60:0x00f3, code lost:
                
                    r1.timeout(r3, r7);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:61:0x00fa, code lost:
                
                    if (r0.hasDeadline() == false) goto L80;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:62:0x00fc, code lost:
                
                    r1.clearDeadline();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:66:0x0100, code lost:
                
                    r13 = move-exception;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:67:0x0101, code lost:
                
                    r1.timeout(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:68:0x010a, code lost:
                
                    if (r0.hasDeadline() != false) goto L55;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:69:0x010c, code lost:
                
                    r1.clearDeadline();
                 */
                /* JADX WARN: Code restructure failed: missing block: B:70:0x010f, code lost:
                
                    throw r13;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:71:0x0110, code lost:
                
                    return;
                 */
                @Override // okio.Sink
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void write(@OXOo.OOXIXo okio.Buffer r13, long r14) {
                    /*
                        Method dump skipped, instructions count: 291
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.write(okio.Buffer, long):void");
                }
            };
            this.source = new Source() { // from class: okio.Pipe$source$1

                @OXOo.OOXIXo
                private final Timeout timeout = new Timeout();

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    ReentrantLock lock = Pipe.this.getLock();
                    Pipe pipe = Pipe.this;
                    lock.lock();
                    try {
                        pipe.setSourceClosed$okio(true);
                        pipe.getCondition().signalAll();
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    } finally {
                        lock.unlock();
                    }
                }

                @Override // okio.Source
                public long read(@OXOo.OOXIXo Buffer sink, long j2) {
                    IIX0o.x0xO0oo(sink, "sink");
                    ReentrantLock lock = Pipe.this.getLock();
                    Pipe pipe = Pipe.this;
                    lock.lock();
                    try {
                        if (!pipe.getSourceClosed$okio()) {
                            if (!pipe.getCanceled$okio()) {
                                while (pipe.getBuffer$okio().size() == 0) {
                                    if (pipe.getSinkClosed$okio()) {
                                        lock.unlock();
                                        return -1L;
                                    }
                                    this.timeout.awaitSignal(pipe.getCondition());
                                    if (pipe.getCanceled$okio()) {
                                        throw new IOException("canceled");
                                    }
                                }
                                long read = pipe.getBuffer$okio().read(sink, j2);
                                pipe.getCondition().signalAll();
                                lock.unlock();
                                return read;
                            }
                            throw new IOException("canceled");
                        }
                        throw new IllegalStateException("closed");
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                }

                @Override // okio.Source
                @OXOo.OOXIXo
                public Timeout timeout() {
                    return this.timeout;
                }
            };
        } else {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j).toString());
        }
    }

    private final void forward(Sink sink, Oox.oOoXoXO<? super Sink, oXIO0o0XI> oooxoxo) {
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                oooxoxo.invoke(sink);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                xxX.oxoX(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                xxX.I0Io(1);
                return;
            } catch (Throwable th) {
                xxX.oxoX(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                xxX.I0Io(1);
                throw th;
            }
        }
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
        }
        try {
            oooxoxo.invoke(sink);
            oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
            xxX.oxoX(1);
            timeout.timeout(timeoutNanos, timeUnit);
            if (timeout2.hasDeadline()) {
                timeout.clearDeadline();
            }
            xxX.I0Io(1);
        } catch (Throwable th2) {
            xxX.oxoX(1);
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.clearDeadline();
            }
            xxX.I0Io(1);
            throw th2;
        }
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "sink", imports = {}))
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "-deprecated_sink")
    /* renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m456deprecated_sink() {
        return this.sink;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.XX(expression = "source", imports = {}))
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "-deprecated_source")
    /* renamed from: -deprecated_source, reason: not valid java name */
    public final Source m457deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void fold(@OXOo.OOXIXo Sink sink) throws IOException {
        IIX0o.x0xO0oo(sink, "sink");
        while (true) {
            this.lock.lock();
            try {
                if (this.foldedSink == null) {
                    if (!this.canceled) {
                        if (this.buffer.exhausted()) {
                            this.sourceClosed = true;
                            this.foldedSink = sink;
                            return;
                        }
                        boolean z = this.sinkClosed;
                        Buffer buffer = new Buffer();
                        Buffer buffer2 = this.buffer;
                        buffer.write(buffer2, buffer2.size());
                        this.condition.signalAll();
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                        try {
                            sink.write(buffer, buffer.size());
                            if (z) {
                                sink.close();
                            } else {
                                sink.flush();
                            }
                        } catch (Throwable th) {
                            this.lock.lock();
                            try {
                                this.sourceClosed = true;
                                this.condition.signalAll();
                                oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                                throw th;
                            } finally {
                            }
                        }
                    } else {
                        this.foldedSink = sink;
                        throw new IOException("canceled");
                    }
                } else {
                    throw new IllegalStateException("sink already folded");
                }
            } finally {
            }
        }
    }

    @OXOo.OOXIXo
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    @OXOo.OOXIXo
    public final Condition getCondition() {
        return this.condition;
    }

    @OXOo.oOoXoXO
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    @OXOo.OOXIXo
    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z) {
        this.canceled = z;
    }

    public final void setFoldedSink$okio(@OXOo.oOoXoXO Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "sink")
    public final Sink sink() {
        return this.sink;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "source")
    public final Source source() {
        return this.source;
    }
}
