package com.baidu.navisdk.comapi.trajectory;

import OXOo.OOXIXo;

/* loaded from: classes7.dex */
public final class e {
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private int s;
    private boolean t;

    /* renamed from: a, reason: collision with root package name */
    private final String f6744a = "BNTrajectoryMonitor";
    private final long b = 1800000;
    private final int u = 10;

    public e(int i) {
        c();
        this.s = i;
    }

    private final String b() {
        StringBuffer stringBuffer = new StringBuffer(this.f6744a);
        stringBuffer.append(",");
        stringBuffer.append(this.c / 1000);
        stringBuffer.append(",");
        stringBuffer.append(this.d / 1000);
        stringBuffer.append(",");
        stringBuffer.append(this.f);
        stringBuffer.append(",");
        stringBuffer.append(this.e);
        stringBuffer.append(",");
        stringBuffer.append(this.q / 1000);
        stringBuffer.append(",");
        stringBuffer.append(this.i);
        stringBuffer.append(",");
        stringBuffer.append(this.h);
        stringBuffer.append(",");
        stringBuffer.append(this.j);
        stringBuffer.append(",");
        stringBuffer.append(this.k / 1000);
        stringBuffer.append(",");
        stringBuffer.append(this.l / 1000);
        stringBuffer.append(",");
        stringBuffer.append(this.r);
        stringBuffer.append(",");
        stringBuffer.append(this.g);
        stringBuffer.append(",");
        stringBuffer.append(this.s);
        stringBuffer.append(",");
        stringBuffer.append(this.m / 1000);
        stringBuffer.append(",");
        stringBuffer.append(this.n / 1000);
        stringBuffer.append(",");
        stringBuffer.append(this.o / 1000);
        stringBuffer.append(",");
        stringBuffer.append(this.p / 1000);
        stringBuffer.append(",");
        stringBuffer.append(this.u);
        return stringBuffer.toString();
    }

    private final void c() {
        this.c = Long.MIN_VALUE;
        this.d = Long.MAX_VALUE;
        this.g = 0L;
        this.h = -1L;
        this.j = -1L;
        this.q = 1577808000000L;
        this.m = -1L;
        this.n = -1L;
        this.o = Long.MIN_VALUE;
        this.p = Long.MAX_VALUE;
        this.k = -1L;
        this.l = -1L;
        this.i = -1L;
        this.e = -1L;
        this.f = -1L;
        this.r = 0L;
        this.s = -1;
    }

    public final boolean a(@OOXIXo com.baidu.navisdk.model.datastruct.g gVar) {
        long currentTimeMillis = System.currentTimeMillis();
        this.o = Math.max(this.o, currentTimeMillis);
        this.p = Math.min(this.p, currentTimeMillis);
        if (this.m < 0) {
            this.m = currentTimeMillis;
        }
        if (this.k < 0) {
            this.k = gVar.j;
        }
        long j = gVar.j;
        this.l = j;
        this.n = currentTimeMillis;
        int a2 = a(j, currentTimeMillis);
        if (gVar.k == 1) {
            if (a2 < 0) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
                if (gVar2.d()) {
                    gVar2.e(this.f6744a, "check,invalid_time:locData.time:" + gVar.j + ",checkRet:" + a2);
                }
                if (this.h < 0) {
                    this.h = this.r;
                }
                if (this.i < 0) {
                    this.i = gVar.j;
                }
                this.j = this.r;
                this.g++;
            }
            long j2 = gVar.j;
            if (j2 > this.c) {
                this.c = j2;
                this.f = this.r;
            }
            if (j2 < this.d) {
                this.d = j2;
                this.e = this.r;
            }
            long j3 = this.r + 1;
            this.r = j3;
            if (!this.t && j3 <= this.u) {
                this.t = a2 != 0;
            }
        }
        return a2 == 0;
    }

    @OOXIXo
    public String toString() {
        return "BNTrajectoryMonitor{maxGpsTimeStamp=" + this.c + ", minGpsTimeStamp=" + this.d + ", minGpsTimeStampIndex=" + this.e + ", maxGpsTimeStampIndex=" + this.f + ", invalidGpsTimeStampCount=" + this.g + ", firstInvalidGpsTimeStampIndex=" + this.h + ", firstInvalidGpsTimeStamp=" + this.i + ", lastInvalidGpsTimeStampIndex=" + this.j + ", firstGpsTimeStamp=" + this.k + ", lastGpsTimeStamp=" + this.l + ", firstSystemCurrentTimeMillis=" + this.m + ", lastSystemCurrentTimeMillis=" + this.n + ", maxSystemCurrentTimeMillis=" + this.o + ", minSystemCurrentTimeMillis=" + this.p + ", baseTimeStamp=" + this.q + ", gpsCount=" + this.r + ", fromType=" + this.s + '}';
    }

    private final int a(long j, long j2) {
        if (j <= 0) {
            return -1;
        }
        if (j < j2 - this.b) {
            return -2;
        }
        return j < this.q ? -3 : 0;
    }

    public final void a() {
        String b = b();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.a()) {
            gVar.a(this.f6744a, "report，needReport:" + this.t + " ,data is:" + b);
        }
        if (this.t) {
            com.baidu.navisdk.skyeye.a.n().a(32, 2, "结束轨迹记录上传");
        }
    }
}
