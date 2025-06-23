package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.LogFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpClientConnection;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.Contract;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.annotation.ThreadingBehavior;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionOperator;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ManagedClientConnection;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing.HttpRoute;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.scheme.SchemeRegistry;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Asserts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Contract(threading = ThreadingBehavior.SAFE)
@Deprecated
/* loaded from: classes10.dex */
public class BasicClientConnectionManager implements ClientConnectionManager {
    private static final AtomicLong COUNTER = new AtomicLong();
    public static final String MISUSE_MESSAGE = "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    private ManagedClientConnectionImpl conn;
    private final ClientConnectionOperator connOperator;
    private final Log log;
    private HttpPoolEntry poolEntry;
    private final SchemeRegistry schemeRegistry;
    private volatile boolean shutdown;

    public BasicClientConnectionManager(SchemeRegistry schemeRegistry) {
        this.log = LogFactory.getLog(getClass());
        Args.notNull(schemeRegistry, "Scheme registry");
        this.schemeRegistry = schemeRegistry;
        this.connOperator = createConnectionOperator(schemeRegistry);
    }

    private void assertNotShutdown() {
        Asserts.check(!this.shutdown, "Connection manager has been shut down");
    }

    private void shutdownConnection(HttpClientConnection httpClientConnection) {
        try {
            httpClientConnection.shutdown();
        } catch (IOException e) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("I/O exception shutting down connection", e);
            }
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        synchronized (this) {
            try {
                assertNotShutdown();
                long currentTimeMillis = System.currentTimeMillis();
                HttpPoolEntry httpPoolEntry = this.poolEntry;
                if (httpPoolEntry != null && httpPoolEntry.isExpired(currentTimeMillis)) {
                    this.poolEntry.close();
                    this.poolEntry.getTracker().reset();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionManager
    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        synchronized (this) {
            try {
                assertNotShutdown();
                long millis = timeUnit.toMillis(j);
                if (millis < 0) {
                    millis = 0;
                }
                long currentTimeMillis = System.currentTimeMillis() - millis;
                HttpPoolEntry httpPoolEntry = this.poolEntry;
                if (httpPoolEntry != null && httpPoolEntry.getUpdated() <= currentTimeMillis) {
                    this.poolEntry.close();
                    this.poolEntry.getTracker().reset();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry) {
        return new DefaultClientConnectionOperator(schemeRegistry);
    }

    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public ManagedClientConnection getConnection(HttpRoute httpRoute, Object obj) {
        boolean z;
        ManagedClientConnectionImpl managedClientConnectionImpl;
        Args.notNull(httpRoute, "Route");
        synchronized (this) {
            try {
                assertNotShutdown();
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Get connection for route " + httpRoute);
                }
                if (this.conn == null) {
                    z = true;
                } else {
                    z = false;
                }
                Asserts.check(z, MISUSE_MESSAGE);
                HttpPoolEntry httpPoolEntry = this.poolEntry;
                if (httpPoolEntry != null && !httpPoolEntry.getPlannedRoute().equals(httpRoute)) {
                    this.poolEntry.close();
                    this.poolEntry = null;
                }
                if (this.poolEntry == null) {
                    this.poolEntry = new HttpPoolEntry(this.log, Long.toString(COUNTER.getAndIncrement()), httpRoute, this.connOperator.createConnection(), 0L, TimeUnit.MILLISECONDS);
                }
                if (this.poolEntry.isExpired(System.currentTimeMillis())) {
                    this.poolEntry.close();
                    this.poolEntry.getTracker().reset();
                }
                managedClientConnectionImpl = new ManagedClientConnectionImpl(this, this.connOperator, this.poolEntry);
                this.conn = managedClientConnectionImpl;
            } catch (Throwable th) {
                throw th;
            }
        }
        return managedClientConnectionImpl;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection managedClientConnection, long j, TimeUnit timeUnit) {
        boolean z;
        TimeUnit timeUnit2;
        String str;
        Args.check(managedClientConnection instanceof ManagedClientConnectionImpl, "Connection class mismatch, connection not obtained from this manager");
        ManagedClientConnectionImpl managedClientConnectionImpl = (ManagedClientConnectionImpl) managedClientConnection;
        synchronized (managedClientConnectionImpl) {
            try {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Releasing connection " + managedClientConnection);
                }
                if (managedClientConnectionImpl.getPoolEntry() == null) {
                    return;
                }
                if (managedClientConnectionImpl.getManager() == this) {
                    z = true;
                } else {
                    z = false;
                }
                Asserts.check(z, "Connection not obtained from this manager");
                synchronized (this) {
                    if (this.shutdown) {
                        shutdownConnection(managedClientConnectionImpl);
                        return;
                    }
                    try {
                        if (managedClientConnectionImpl.isOpen() && !managedClientConnectionImpl.isMarkedReusable()) {
                            shutdownConnection(managedClientConnectionImpl);
                        }
                        if (managedClientConnectionImpl.isMarkedReusable()) {
                            HttpPoolEntry httpPoolEntry = this.poolEntry;
                            if (timeUnit != null) {
                                timeUnit2 = timeUnit;
                            } else {
                                timeUnit2 = TimeUnit.MILLISECONDS;
                            }
                            httpPoolEntry.updateExpiry(j, timeUnit2);
                            if (this.log.isDebugEnabled()) {
                                if (j > 0) {
                                    str = "for " + j + " " + timeUnit;
                                } else {
                                    str = "indefinitely";
                                }
                                this.log.debug("Connection can be kept alive " + str);
                            }
                        }
                        managedClientConnectionImpl.detach();
                        this.conn = null;
                        if (this.poolEntry.isClosed()) {
                            this.poolEntry = null;
                        }
                    } catch (Throwable th) {
                        managedClientConnectionImpl.detach();
                        this.conn = null;
                        if (this.poolEntry.isClosed()) {
                            this.poolEntry = null;
                        }
                        throw th;
                    }
                }
            } finally {
            }
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionManager
    public final ClientConnectionRequest requestConnection(final HttpRoute httpRoute, final Object obj) {
        return new ClientConnectionRequest() { // from class: com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.conn.BasicClientConnectionManager.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionRequest
            public void abortRequest() {
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionRequest
            public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) {
                return BasicClientConnectionManager.this.getConnection(httpRoute, obj);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.ClientConnectionManager
    public void shutdown() {
        synchronized (this) {
            try {
                this.shutdown = true;
                try {
                    HttpPoolEntry httpPoolEntry = this.poolEntry;
                    if (httpPoolEntry != null) {
                        httpPoolEntry.close();
                    }
                } finally {
                    this.poolEntry = null;
                    this.conn = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public BasicClientConnectionManager() {
        this(SchemeRegistryFactory.createDefault());
    }
}
