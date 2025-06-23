package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client;

import XIXIX.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.BackoffManager;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.routing.HttpRoute;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.pool.ConnPoolControl;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.Args;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class AIMDBackoffManager implements BackoffManager {
    private double backoffFactor;
    private int cap;
    private final Clock clock;
    private final ConnPoolControl<HttpRoute> connPerRoute;
    private long coolDown;
    private final Map<HttpRoute, Long> lastRouteBackoffs;
    private final Map<HttpRoute, Long> lastRouteProbes;

    public AIMDBackoffManager(ConnPoolControl<HttpRoute> connPoolControl) {
        this(connPoolControl, new SystemClock());
    }

    private int getBackedOffPoolSize(int i) {
        if (i <= 1) {
            return 1;
        }
        return (int) Math.floor(this.backoffFactor * i);
    }

    private Long getLastUpdate(Map<HttpRoute, Long> map, HttpRoute httpRoute) {
        Long l = map.get(httpRoute);
        if (l == null) {
            return 0L;
        }
        return l;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.BackoffManager
    public void backOff(HttpRoute httpRoute) {
        synchronized (this.connPerRoute) {
            try {
                int maxPerRoute = this.connPerRoute.getMaxPerRoute(httpRoute);
                Long lastUpdate = getLastUpdate(this.lastRouteBackoffs, httpRoute);
                long currentTime = this.clock.getCurrentTime();
                if (currentTime - lastUpdate.longValue() < this.coolDown) {
                    return;
                }
                this.connPerRoute.setMaxPerRoute(httpRoute, getBackedOffPoolSize(maxPerRoute));
                this.lastRouteBackoffs.put(httpRoute, Long.valueOf(currentTime));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.BackoffManager
    public void probe(HttpRoute httpRoute) {
        synchronized (this.connPerRoute) {
            try {
                int maxPerRoute = this.connPerRoute.getMaxPerRoute(httpRoute);
                int i = this.cap;
                if (maxPerRoute < i) {
                    i = maxPerRoute + 1;
                }
                Long lastUpdate = getLastUpdate(this.lastRouteProbes, httpRoute);
                Long lastUpdate2 = getLastUpdate(this.lastRouteBackoffs, httpRoute);
                long currentTime = this.clock.getCurrentTime();
                if (currentTime - lastUpdate.longValue() >= this.coolDown && currentTime - lastUpdate2.longValue() >= this.coolDown) {
                    this.connPerRoute.setMaxPerRoute(httpRoute, i);
                    this.lastRouteProbes.put(httpRoute, Long.valueOf(currentTime));
                }
            } finally {
            }
        }
    }

    public void setBackoffFactor(double d) {
        boolean z;
        if (d > OOXIXo.f3760XO && d < 1.0d) {
            z = true;
        } else {
            z = false;
        }
        Args.check(z, "Backoff factor must be 0.0 < f < 1.0");
        this.backoffFactor = d;
    }

    public void setCooldownMillis(long j) {
        Args.positive(this.coolDown, "Cool down");
        this.coolDown = j;
    }

    public void setPerHostConnectionCap(int i) {
        Args.positive(i, "Per host connection cap");
        this.cap = i;
    }

    public AIMDBackoffManager(ConnPoolControl<HttpRoute> connPoolControl, Clock clock) {
        this.coolDown = 5000L;
        this.backoffFactor = 0.5d;
        this.cap = 2;
        this.clock = clock;
        this.connPerRoute = connPoolControl;
        this.lastRouteProbes = new HashMap();
        this.lastRouteBackoffs = new HashMap();
    }
}
