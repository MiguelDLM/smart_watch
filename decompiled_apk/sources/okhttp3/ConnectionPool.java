package okhttp3;

import OXOo.OOXIXo;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

/* loaded from: classes6.dex */
public final class ConnectionPool {

    @OOXIXo
    private final RealConnectionPool delegate;

    public ConnectionPool(@OOXIXo RealConnectionPool delegate) {
        IIX0o.x0xO0oo(delegate, "delegate");
        this.delegate = delegate;
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    @OOXIXo
    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i, long j, @OOXIXo TimeUnit timeUnit) {
        this(new RealConnectionPool(TaskRunner.INSTANCE, i, j, timeUnit));
        IIX0o.x0xO0oo(timeUnit, "timeUnit");
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
