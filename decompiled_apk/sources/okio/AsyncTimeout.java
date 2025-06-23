package okio;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.xxX;
import kotlin.o0;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public class AsyncTimeout extends Timeout {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @OXOo.OOXIXo
    private static final Condition condition;

    @OXOo.oOoXoXO
    private static AsyncTimeout head;

    @OXOo.OOXIXo
    private static final ReentrantLock lock;
    private boolean inQueue;

    @OXOo.oOoXoXO
    private AsyncTimeout next;
    private long timeoutAt;

    @XX({"SMAP\nAsyncTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncTimeout.kt\nokio/AsyncTimeout$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,331:1\n1#2:332\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
            ReentrantLock lock = AsyncTimeout.Companion.getLock();
            lock.lock();
            try {
                if (asyncTimeout.inQueue) {
                    asyncTimeout.inQueue = false;
                    for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                        if (asyncTimeout2.next == asyncTimeout) {
                            asyncTimeout2.next = asyncTimeout.next;
                            asyncTimeout.next = null;
                            return false;
                        }
                    }
                    lock.unlock();
                    return true;
                }
                return false;
            } finally {
                lock.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void scheduleTimeout(AsyncTimeout asyncTimeout, long j, boolean z) {
            ReentrantLock lock = AsyncTimeout.Companion.getLock();
            lock.lock();
            try {
                if (!asyncTimeout.inQueue) {
                    asyncTimeout.inQueue = true;
                    if (AsyncTimeout.head == null) {
                        AsyncTimeout.head = new AsyncTimeout();
                        new Watchdog().start();
                    }
                    long nanoTime = System.nanoTime();
                    if (j != 0 && z) {
                        asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
                    } else if (j != 0) {
                        asyncTimeout.timeoutAt = j + nanoTime;
                    } else if (z) {
                        asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                    } else {
                        throw new AssertionError();
                    }
                    long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
                    AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
                    IIX0o.ooOOo0oXI(asyncTimeout2);
                    while (asyncTimeout2.next != null) {
                        AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                        IIX0o.ooOOo0oXI(asyncTimeout3);
                        if (remainingNanos < asyncTimeout3.remainingNanos(nanoTime)) {
                            break;
                        }
                        asyncTimeout2 = asyncTimeout2.next;
                        IIX0o.ooOOo0oXI(asyncTimeout2);
                    }
                    asyncTimeout.next = asyncTimeout2.next;
                    asyncTimeout2.next = asyncTimeout;
                    if (asyncTimeout2 == AsyncTimeout.head) {
                        AsyncTimeout.Companion.getCondition().signal();
                    }
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    lock.unlock();
                    return;
                }
                throw new IllegalStateException("Unbalanced enter/exit");
            } catch (Throwable th) {
                lock.unlock();
                throw th;
            }
        }

        @OXOo.oOoXoXO
        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            IIX0o.ooOOo0oXI(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 != null) {
                long remainingNanos = asyncTimeout2.remainingNanos(System.nanoTime());
                if (remainingNanos <= 0) {
                    AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                    IIX0o.ooOOo0oXI(asyncTimeout3);
                    asyncTimeout3.next = asyncTimeout2.next;
                    asyncTimeout2.next = null;
                    return asyncTimeout2;
                }
                getCondition().await(remainingNanos, TimeUnit.NANOSECONDS);
                return null;
            }
            long nanoTime = System.nanoTime();
            getCondition().await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            IIX0o.ooOOo0oXI(asyncTimeout4);
            if (asyncTimeout4.next == null && System.nanoTime() - nanoTime >= AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                return AsyncTimeout.head;
            }
            return null;
        }

        @OXOo.OOXIXo
        public final Condition getCondition() {
            return AsyncTimeout.condition;
        }

        @OXOo.OOXIXo
        public final ReentrantLock getLock() {
            return AsyncTimeout.lock;
        }

        private Companion() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock lock;
            AsyncTimeout awaitTimeout$okio;
            while (true) {
                try {
                    Companion companion = AsyncTimeout.Companion;
                    lock = companion.getLock();
                    lock.lock();
                    try {
                        awaitTimeout$okio = companion.awaitTimeout$okio();
                    } finally {
                        lock.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (awaitTimeout$okio == AsyncTimeout.head) {
                    AsyncTimeout.head = null;
                    return;
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                lock.unlock();
                if (awaitTimeout$okio != null) {
                    awaitTimeout$okio.timedOut();
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        IIX0o.oO(newCondition, "newCondition(...)");
        condition = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    @OXOo.OOXIXo
    @o0
    public final IOException access$newTimeoutException(@OXOo.oOoXoXO IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            Companion.scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        return Companion.cancelScheduledTimeout(this);
    }

    @OXOo.OOXIXo
    public IOException newTimeoutException(@OXOo.oOoXoXO IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @OXOo.OOXIXo
    public final Sink sink(@OXOo.OOXIXo final Sink sink) {
        IIX0o.x0xO0oo(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout$sink$1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.close();
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.flush();
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @OXOo.OOXIXo
            public String toString() {
                return "AsyncTimeout.sink(" + sink + HexStringBuilder.COMMENT_END_CHAR;
            }

            @Override // okio.Sink
            public void write(@OXOo.OOXIXo Buffer source, long j) {
                IIX0o.x0xO0oo(source, "source");
                SegmentedByteString.checkOffsetAndCount(source.size(), 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        Segment segment = source.head;
                        IIX0o.ooOOo0oXI(segment);
                        while (true) {
                            if (j2 >= 65536) {
                                break;
                            }
                            j2 += segment.limit - segment.pos;
                            if (j2 >= j) {
                                j2 = j;
                                break;
                            } else {
                                segment = segment.next;
                                IIX0o.ooOOo0oXI(segment);
                            }
                        }
                        AsyncTimeout asyncTimeout = AsyncTimeout.this;
                        Sink sink2 = sink;
                        asyncTimeout.enter();
                        try {
                            sink2.write(source, j2);
                            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                            if (!asyncTimeout.exit()) {
                                j -= j2;
                            } else {
                                throw asyncTimeout.access$newTimeoutException(null);
                            }
                        } catch (IOException e) {
                            if (!asyncTimeout.exit()) {
                                throw e;
                            }
                            throw asyncTimeout.access$newTimeoutException(e);
                        } finally {
                            asyncTimeout.exit();
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // okio.Sink
            @OXOo.OOXIXo
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    @OXOo.OOXIXo
    public final Source source(@OXOo.OOXIXo final Source source) {
        IIX0o.x0xO0oo(source, "source");
        return new Source() { // from class: okio.AsyncTimeout$source$1
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    source2.close();
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public long read(@OXOo.OOXIXo Buffer sink, long j) {
                IIX0o.x0xO0oo(sink, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    long read = source2.read(sink, j);
                    if (!asyncTimeout.exit()) {
                        return read;
                    }
                    throw asyncTimeout.access$newTimeoutException(null);
                } catch (IOException e) {
                    if (!asyncTimeout.exit()) {
                        throw e;
                    }
                    throw asyncTimeout.access$newTimeoutException(e);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @OXOo.OOXIXo
            public String toString() {
                return "AsyncTimeout.source(" + source + HexStringBuilder.COMMENT_END_CHAR;
            }

            @Override // okio.Source
            @OXOo.OOXIXo
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(@OXOo.OOXIXo Oox.oIX0oI<? extends T> block) {
        IIX0o.x0xO0oo(block, "block");
        enter();
        try {
            try {
                T invoke = block.invoke();
                xxX.oxoX(1);
                if (!exit()) {
                    xxX.I0Io(1);
                    return invoke;
                }
                throw access$newTimeoutException(null);
            } catch (IOException e) {
                if (!exit()) {
                    throw e;
                }
                throw access$newTimeoutException(e);
            }
        } catch (Throwable th) {
            xxX.oxoX(1);
            exit();
            xxX.I0Io(1);
            throw th;
        }
    }
}
