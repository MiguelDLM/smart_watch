package com.baidu.navisdk.util.statistic;

import android.os.SystemClock;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class b extends com.baidu.navisdk.comapi.statistics.f implements com.baidu.navisdk.module.statistics.b {
    private static b n;
    public HashMap<String, Object> j;
    private long k;
    private long l;
    private long m;

    private b(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
        this.j = null;
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
    }

    public static synchronized b o() {
        b bVar;
        synchronized (b.class) {
            try {
                if (n == null) {
                    synchronized (b.class) {
                        try {
                            if (n == null) {
                                n = new b(com.baidu.navisdk.comapi.statistics.b.f());
                            }
                        } finally {
                        }
                    }
                }
                bVar = n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        if (this.j == null) {
            this.j = new HashMap<>();
        }
        this.k = SystemClock.elapsedRealtime() - this.l;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-CommuteStatItem", "onEvent,mDurationMs=" + this.k);
        }
        b("moss_real_time", (this.k / 1000) + "");
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-CommuteStatItem", "onEvent,mDistanceMeter=" + this.m);
        }
        b("moss_real_dis", this.m + "");
        super.b(i);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50020";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-CommuteStatItem";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void l() {
        super.l();
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
    }

    public void n() {
        this.l = SystemClock.elapsedRealtime();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("Statistics-CommuteStatItem", "startStat,mStartTimeMs=" + this.l);
        }
    }
}
