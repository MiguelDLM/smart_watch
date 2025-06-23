package okhttp3.internal.http2;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@XX({"SMAP\nHttp2Stream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n*L\n1#1,688:1\n1#2:689\n615#3,4:690\n615#3,4:694\n563#3:698\n615#3,4:699\n615#3,4:703\n563#3:707\n563#3:708\n615#3,4:709\n563#3:713\n557#3:714\n*S KotlinDebug\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream\n*L\n176#1:690,4\n255#1:694,4\n263#1:698\n274#1:699,4\n281#1:703,4\n295#1:707\n305#1:708\n491#1:709,4\n637#1:713\n657#1:714\n*E\n"})
/* loaded from: classes6.dex */
public final class Http2Stream {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;

    @OOXIXo
    private final Http2Connection connection;

    @oOoXoXO
    private ErrorCode errorCode;

    @oOoXoXO
    private IOException errorException;
    private boolean hasResponseHeaders;

    @OOXIXo
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;

    @OOXIXo
    private final StreamTimeout readTimeout;

    @OOXIXo
    private final FramingSink sink;

    @OOXIXo
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;

    @OOXIXo
    private final StreamTimeout writeTimeout;

    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    @XX({"SMAP\nHttp2Stream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n*L\n1#1,688:1\n1#2:689\n615#3,4:690\n615#3,4:694\n563#3:698\n563#3:699\n*S KotlinDebug\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSource\n*L\n407#1:690,4\n418#1:694,4\n458#1:698\n480#1:699\n*E\n"})
    /* loaded from: classes6.dex */
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;

        @oOoXoXO
        private Headers trailers;

        @OOXIXo
        private final Buffer receiveBuffer = new Buffer();

        @OOXIXo
        private final Buffer readBuffer = new Buffer();

        public FramingSource(long j, boolean z) {
            this.maxByteCount = j;
            this.finished = z;
        }

        private final void updateConnectionFlowControl(long j) {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(j);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                IIX0o.x0XOIxOo(http2Stream, "null cannot be cast to non-null type java.lang.Object");
                http2Stream.notifyAll();
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        @OOXIXo
        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        @OOXIXo
        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        @oOoXoXO
        public final Headers getTrailers() {
            return this.trailers;
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x00c1, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long read(@OXOo.OOXIXo okio.Buffer r18, long r19) throws java.io.IOException {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                r2 = r19
                java.lang.String r4 = "sink"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r0, r4)
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto Lcc
            L11:
                okhttp3.internal.http2.Http2Stream r6 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r6)
                okhttp3.internal.http2.Http2Stream$StreamTimeout r7 = r6.getReadTimeout$okhttp()     // Catch: java.lang.Throwable -> Lb8
                r7.enter()     // Catch: java.lang.Throwable -> Lb8
                okhttp3.internal.http2.ErrorCode r7 = r6.getErrorCode$okhttp()     // Catch: java.lang.Throwable -> L38
                if (r7 == 0) goto L3b
                boolean r7 = r1.finished     // Catch: java.lang.Throwable -> L38
                if (r7 != 0) goto L3b
                java.io.IOException r7 = r6.getErrorException$okhttp()     // Catch: java.lang.Throwable -> L38
                if (r7 != 0) goto L3c
                okhttp3.internal.http2.StreamResetException r7 = new okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L38
                okhttp3.internal.http2.ErrorCode r8 = r6.getErrorCode$okhttp()     // Catch: java.lang.Throwable -> L38
                kotlin.jvm.internal.IIX0o.ooOOo0oXI(r8)     // Catch: java.lang.Throwable -> L38
                r7.<init>(r8)     // Catch: java.lang.Throwable -> L38
                goto L3c
            L38:
                r0 = move-exception
                goto Lc2
            L3b:
                r7 = 0
            L3c:
                boolean r8 = r1.closed     // Catch: java.lang.Throwable -> L38
                if (r8 != 0) goto Lba
                okio.Buffer r8 = r1.readBuffer     // Catch: java.lang.Throwable -> L38
                long r8 = r8.size()     // Catch: java.lang.Throwable -> L38
                r10 = -1
                r12 = 0
                int r13 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r13 <= 0) goto L94
                okio.Buffer r8 = r1.readBuffer     // Catch: java.lang.Throwable -> L38
                long r13 = r8.size()     // Catch: java.lang.Throwable -> L38
                long r13 = java.lang.Math.min(r2, r13)     // Catch: java.lang.Throwable -> L38
                long r8 = r8.read(r0, r13)     // Catch: java.lang.Throwable -> L38
                long r13 = r6.getReadBytesTotal()     // Catch: java.lang.Throwable -> L38
                long r13 = r13 + r8
                r6.setReadBytesTotal$okhttp(r13)     // Catch: java.lang.Throwable -> L38
                long r13 = r6.getReadBytesTotal()     // Catch: java.lang.Throwable -> L38
                long r15 = r6.getReadBytesAcknowledged()     // Catch: java.lang.Throwable -> L38
                long r13 = r13 - r15
                if (r7 != 0) goto L9f
                okhttp3.internal.http2.Http2Connection r15 = r6.getConnection()     // Catch: java.lang.Throwable -> L38
                okhttp3.internal.http2.Settings r15 = r15.getOkHttpSettings()     // Catch: java.lang.Throwable -> L38
                int r15 = r15.getInitialWindowSize()     // Catch: java.lang.Throwable -> L38
                int r15 = r15 / 2
                long r4 = (long) r15     // Catch: java.lang.Throwable -> L38
                int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
                if (r15 < 0) goto L9f
                okhttp3.internal.http2.Http2Connection r4 = r6.getConnection()     // Catch: java.lang.Throwable -> L38
                int r5 = r6.getId()     // Catch: java.lang.Throwable -> L38
                r4.writeWindowUpdateLater$okhttp(r5, r13)     // Catch: java.lang.Throwable -> L38
                long r4 = r6.getReadBytesTotal()     // Catch: java.lang.Throwable -> L38
                r6.setReadBytesAcknowledged$okhttp(r4)     // Catch: java.lang.Throwable -> L38
                goto L9f
            L94:
                boolean r4 = r1.finished     // Catch: java.lang.Throwable -> L38
                if (r4 != 0) goto L9e
                if (r7 != 0) goto L9e
                r6.waitForIo$okhttp()     // Catch: java.lang.Throwable -> L38
                r12 = 1
            L9e:
                r8 = r10
            L9f:
                okhttp3.internal.http2.Http2Stream$StreamTimeout r4 = r6.getReadTimeout$okhttp()     // Catch: java.lang.Throwable -> Lb8
                r4.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> Lb8
                kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f29392oIX0oI     // Catch: java.lang.Throwable -> Lb8
                monitor-exit(r6)
                if (r12 == 0) goto Laf
                r4 = 0
                goto L11
            Laf:
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 == 0) goto Lb4
                return r8
            Lb4:
                if (r7 != 0) goto Lb7
                return r10
            Lb7:
                throw r7
            Lb8:
                r0 = move-exception
                goto Lca
            Lba:
                java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L38
                java.lang.String r2 = "stream closed"
                r0.<init>(r2)     // Catch: java.lang.Throwable -> L38
                throw r0     // Catch: java.lang.Throwable -> L38
            Lc2:
                okhttp3.internal.http2.Http2Stream$StreamTimeout r2 = r6.getReadTimeout$okhttp()     // Catch: java.lang.Throwable -> Lb8
                r2.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> Lb8
                throw r0     // Catch: java.lang.Throwable -> Lb8
            Lca:
                monitor-exit(r6)
                throw r0
            Lcc:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r4 = "byteCount < 0: "
                r0.append(r4)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSource.read(okio.Buffer, long):long");
        }

        public final void receive$okhttp(@OOXIXo BufferedSource source, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            IIX0o.x0xO0oo(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            long j2 = j;
            while (j2 > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = false;
                    if (this.readBuffer.size() + j2 > this.maxByteCount) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                }
                if (z3) {
                    source.skip(j2);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    source.skip(j2);
                    return;
                }
                long read = source.read(this.receiveBuffer, j2);
                if (read != -1) {
                    j2 -= read;
                    Http2Stream http2Stream2 = Http2Stream.this;
                    synchronized (http2Stream2) {
                        try {
                            if (this.closed) {
                                this.receiveBuffer.clear();
                            } else {
                                if (this.readBuffer.size() == 0) {
                                    z2 = true;
                                }
                                this.readBuffer.writeAll(this.receiveBuffer);
                                if (z2) {
                                    IIX0o.x0XOIxOo(http2Stream2, "null cannot be cast to non-null type java.lang.Object");
                                    http2Stream2.notifyAll();
                                }
                            }
                        } finally {
                        }
                    }
                } else {
                    throw new EOFException();
                }
            }
            updateConnectionFlowControl(j);
        }

        public final void setClosed$okhttp(boolean z) {
            this.closed = z;
        }

        public final void setFinished$okhttp(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(@oOoXoXO Headers headers) {
            this.trailers = headers;
        }

        @Override // okio.Source
        @OOXIXo
        public Timeout timeout() {
            return Http2Stream.this.getReadTimeout$okhttp();
        }
    }

    /* loaded from: classes6.dex */
    public final class StreamTimeout extends AsyncTimeout {
        public StreamTimeout() {
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (!exit()) {
            } else {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        @OOXIXo
        public IOException newTimeoutException(@oOoXoXO IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i, @OOXIXo Http2Connection connection, boolean z, boolean z2, @oOoXoXO Headers headers) {
        IIX0o.x0xO0oo(connection, "connection");
        this.id = i;
        this.connection = connection;
        this.writeBytesMaximum = connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(connection.getOkHttpSettings().getInitialWindowSize(), z2);
        this.sink = new FramingSink(z);
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (headers != null) {
            if (!isLocallyInitiated()) {
                arrayDeque.add(headers);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (isLocallyInitiated()) {
        } else {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            if (this.source.getFinished$okhttp() && this.sink.getFinished()) {
                return false;
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void addBytesToWriteWindow(long j) {
        this.writeBytesMaximum += j;
        if (j > 0) {
            IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z;
        boolean isOpen;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            try {
                if (this.source.getFinished$okhttp() || !this.source.getClosed$okhttp() || (!this.sink.getFinished() && !this.sink.getClosed())) {
                    z = false;
                    isOpen = isOpen();
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                }
                z = true;
                isOpen = isOpen();
                oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            close(ErrorCode.CANCEL, null);
        } else if (!isOpen) {
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (!this.sink.getClosed()) {
            if (!this.sink.getFinished()) {
                if (this.errorCode != null) {
                    IOException iOException = this.errorException;
                    if (iOException == null) {
                        ErrorCode errorCode = this.errorCode;
                        IIX0o.ooOOo0oXI(errorCode);
                        throw new StreamResetException(errorCode);
                    }
                    throw iOException;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public final void close(@OOXIXo ErrorCode rstStatusCode, @oOoXoXO IOException iOException) throws IOException {
        IIX0o.x0xO0oo(rstStatusCode, "rstStatusCode");
        if (!closeInternal(rstStatusCode, iOException)) {
            return;
        }
        this.connection.writeSynReset$okhttp(this.id, rstStatusCode);
    }

    public final void closeLater(@OOXIXo ErrorCode errorCode) {
        IIX0o.x0xO0oo(errorCode, "errorCode");
        if (!closeInternal(errorCode, null)) {
            return;
        }
        this.connection.writeSynResetLater$okhttp(this.id, errorCode);
    }

    public final void enqueueTrailers(@OOXIXo Headers trailers) {
        IIX0o.x0xO0oo(trailers, "trailers");
        synchronized (this) {
            if (!this.sink.getFinished()) {
                if (trailers.size() != 0) {
                    this.sink.setTrailers(trailers);
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                } else {
                    throw new IllegalArgumentException("trailers.size() == 0");
                }
            } else {
                throw new IllegalStateException("already finished");
            }
        }
    }

    @OOXIXo
    public final Http2Connection getConnection() {
        return this.connection;
    }

    @oOoXoXO
    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    @oOoXoXO
    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @OOXIXo
    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    @OOXIXo
    public final Sink getSink() {
        synchronized (this) {
            try {
                if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.sink;
    }

    @OOXIXo
    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    @OOXIXo
    public final Source getSource() {
        return this.source;
    }

    @OOXIXo
    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @OOXIXo
    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        boolean z;
        if ((this.id & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (this.connection.getClient$okhttp() == z) {
            return true;
        }
        return false;
    }

    public final synchronized boolean isOpen() {
        try {
            if (this.errorCode != null) {
                return false;
            }
            if (!this.source.getFinished$okhttp()) {
                if (this.source.getClosed$okhttp()) {
                }
                return true;
            }
            if (this.sink.getFinished() || this.sink.getClosed()) {
                if (this.hasResponseHeaders) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @OOXIXo
    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(@OOXIXo BufferedSource source, int i) throws IOException {
        IIX0o.x0xO0oo(source, "source");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        this.source.receive$okhttp(source, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: all -> 0x0046, TryCatch #0 {all -> 0x0046, blocks: (B:10:0x0038, B:14:0x0040, B:16:0x0051, B:17:0x0056, B:24:0x0048), top: B:9:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void receiveHeaders(@OXOo.OOXIXo okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L37
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L10
            goto L37
        L10:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L37:
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L46
            r1 = 1
            if (r0 == 0) goto L48
            if (r4 != 0) goto L40
            goto L48
        L40:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch: java.lang.Throwable -> L46
            r0.setTrailers(r3)     // Catch: java.lang.Throwable -> L46
            goto L4f
        L46:
            r3 = move-exception
            goto L6f
        L48:
            r2.hasResponseHeaders = r1     // Catch: java.lang.Throwable -> L46
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L46
            r0.add(r3)     // Catch: java.lang.Throwable -> L46
        L4f:
            if (r4 == 0) goto L56
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.source     // Catch: java.lang.Throwable -> L46
            r3.setFinished$okhttp(r1)     // Catch: java.lang.Throwable -> L46
        L56:
            boolean r3 = r2.isOpen()     // Catch: java.lang.Throwable -> L46
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.Object"
            kotlin.jvm.internal.IIX0o.x0XOIxOo(r2, r4)     // Catch: java.lang.Throwable -> L46
            r2.notifyAll()     // Catch: java.lang.Throwable -> L46
            kotlin.oXIO0o0XI r4 = kotlin.oXIO0o0XI.f29392oIX0oI     // Catch: java.lang.Throwable -> L46
            monitor-exit(r2)
            if (r3 != 0) goto L6e
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.id
            r3.removeStream$okhttp(r4)
        L6e:
            return
        L6f:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public final synchronized void receiveRstStream(@OOXIXo ErrorCode errorCode) {
        IIX0o.x0xO0oo(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void setErrorCode$okhttp(@oOoXoXO ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(@oOoXoXO IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long j) {
        this.readBytesAcknowledged = j;
    }

    public final void setReadBytesTotal$okhttp(long j) {
        this.readBytesTotal = j;
    }

    public final void setWriteBytesMaximum$okhttp(long j) {
        this.writeBytesMaximum = j;
    }

    public final void setWriteBytesTotal$okhttp(long j) {
        this.writeBytesTotal = j;
    }

    @OOXIXo
    public final synchronized Headers takeHeaders() throws IOException {
        Headers removeFirst;
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo$okhttp();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!this.headersQueue.isEmpty()) {
            removeFirst = this.headersQueue.removeFirst();
            IIX0o.oO(removeFirst, "headersQueue.removeFirst()");
        } else {
            IOException iOException = this.errorException;
            if (iOException == null) {
                ErrorCode errorCode = this.errorCode;
                IIX0o.ooOOo0oXI(errorCode);
                throw new StreamResetException(errorCode);
            }
            throw iOException;
        }
        return removeFirst;
    }

    @OOXIXo
    public final synchronized Headers trailers() throws IOException {
        Headers trailers;
        if (this.source.getFinished$okhttp() && this.source.getReceiveBuffer().exhausted() && this.source.getReadBuffer().exhausted()) {
            trailers = this.source.getTrailers();
            if (trailers == null) {
                trailers = Util.EMPTY_HEADERS;
            }
        } else {
            if (this.errorCode != null) {
                IOException iOException = this.errorException;
                if (iOException == null) {
                    ErrorCode errorCode = this.errorCode;
                    IIX0o.ooOOo0oXI(errorCode);
                    throw new StreamResetException(errorCode);
                }
                throw iOException;
            }
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return trailers;
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            IIX0o.x0XOIxOo(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(@OOXIXo List<Header> responseHeaders, boolean z, boolean z2) throws IOException {
        boolean z3;
        IIX0o.x0xO0oo(responseHeaders, "responseHeaders");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z3 = true;
            try {
                this.hasResponseHeaders = true;
                if (z) {
                    this.sink.setFinished(true);
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
            synchronized (this.connection) {
                if (this.connection.getWriteBytesTotal() < this.connection.getWriteBytesMaximum()) {
                    z3 = false;
                }
            }
            z2 = z3;
        }
        this.connection.writeHeaders$okhttp(this.id, z, responseHeaders);
        if (z2) {
            this.connection.flush();
        }
    }

    @OOXIXo
    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    @XX({"SMAP\nHttp2Stream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSink\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,688:1\n615#2,4:689\n615#2,4:693\n615#2,4:697\n*S KotlinDebug\n*F\n+ 1 Http2Stream.kt\nokhttp3/internal/http2/Http2Stream$FramingSink\n*L\n528#1:689,4\n573#1:693,4\n589#1:697,4\n*E\n"})
    /* loaded from: classes6.dex */
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;

        @OOXIXo
        private final Buffer sendBuffer;

        @oOoXoXO
        private Headers trailers;

        public FramingSink(boolean z) {
            this.finished = z;
            this.sendBuffer = new Buffer();
        }

        private final void emitFrame(boolean z) throws IOException {
            long min;
            boolean z2;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                try {
                    http2Stream.getWriteTimeout$okhttp().enter();
                    while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !this.finished && !this.closed && http2Stream.getErrorCode$okhttp() == null) {
                        try {
                            http2Stream.waitForIo$okhttp();
                        } finally {
                            http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                        }
                    }
                    http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                    http2Stream.checkOutNotClosed$okhttp();
                    min = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.size());
                    http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                    if (z && min == this.sendBuffer.size()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z2, this.sendBuffer, min);
            } finally {
                http2Stream = Http2Stream.this;
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            boolean z;
            boolean z2;
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                if (this.closed) {
                    return;
                }
                if (http2Stream2.getErrorCode$okhttp() == null) {
                    z = true;
                } else {
                    z = false;
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                if (!Http2Stream.this.getSink$okhttp().finished) {
                    if (this.sendBuffer.size() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (this.trailers != null) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        IIX0o.ooOOo0oXI(headers);
                        connection.writeHeaders$okhttp(id, z, Util.toHeaderList(headers));
                    } else if (z2) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else if (z) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                    oXIO0o0XI oxio0o0xi2 = oXIO0o0XI.f29392oIX0oI;
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                http2Stream2.checkOutNotClosed$okhttp();
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        @oOoXoXO
        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        public final void setFinished(boolean z) {
            this.finished = z;
        }

        public final void setTrailers(@oOoXoXO Headers headers) {
            this.trailers = headers;
        }

        @Override // okio.Sink
        @OOXIXo
        public Timeout timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // okio.Sink
        public void write(@OOXIXo Buffer source, long j) throws IOException {
            IIX0o.x0xO0oo(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + http2Stream);
            }
            this.sendBuffer.write(source, j);
            while (this.sendBuffer.size() >= 16384) {
                emitFrame(false);
            }
        }

        public /* synthetic */ FramingSink(Http2Stream http2Stream, boolean z, int i, IIXOooo iIXOooo) {
            this((i & 1) != 0 ? false : z);
        }
    }
}
