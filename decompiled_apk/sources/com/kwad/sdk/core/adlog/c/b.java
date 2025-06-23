package com.kwad.sdk.core.adlog.c;

import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.utils.ac;

/* loaded from: classes11.dex */
public final class b {
    private final a arx = new a();

    public final a Ca() {
        return this.arx;
    }

    public final b ao(long j) {
        this.arx.vA = j;
        return this;
    }

    public final b b(a.C0845a c0845a) {
        this.arx.Li = c0845a;
        return this;
    }

    public final b cK(int i) {
        this.arx.kl = i;
        return this;
    }

    public final b cL(int i) {
        this.arx.aqQ = i;
        return this;
    }

    public final b cM(int i) {
        this.arx.aqR = i;
        return this;
    }

    public final b cN(int i) {
        this.arx.downloadSource = i;
        return this;
    }

    public final b cO(int i) {
        this.arx.are = i;
        return this;
    }

    public final b cP(int i) {
        this.arx.arh = i;
        return this;
    }

    public final b cQ(int i) {
        this.arx.ari = i;
        return this;
    }

    public final b cR(int i) {
        this.arx.aqW = i;
        return this;
    }

    public final b cS(int i) {
        this.arx.aro = i;
        return this;
    }

    public final b cT(int i) {
        this.arx.ars = i;
        return this;
    }

    public final b cU(int i) {
        this.arx.cD(i);
        return this;
    }

    public final b cV(int i) {
        this.arx.aru = i;
        return this;
    }

    public final b cW(int i) {
        this.arx.Lk = i;
        return this;
    }

    public final b cX(int i) {
        this.arx.arv = i;
        return this;
    }

    public final b cY(int i) {
        this.arx.Lj = i;
        return this;
    }

    public final b dm(String str) {
        this.arx.Lh = str;
        return this;
    }

    public final b dn(String str) {
        this.arx.arf = str;
        return this;
    }

    /* renamed from: do, reason: not valid java name */
    public final b m274do(String str) {
        this.arx.arg = str;
        return this;
    }

    public final b dp(String str) {
        this.arx.arq = str;
        return this;
    }

    public final b f(ac.a aVar) {
        this.arx.kn = aVar;
        return this;
    }

    public final b l(double d) {
        this.arx.ko = d;
        return this;
    }

    public final b v(int i, int i2) {
        this.arx.aqS = i + "," + i2;
        return this;
    }

    public final b b(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.f.a<AdTrackLog> aVar) {
        a aVar2 = this.arx;
        if (aVar2.Li == null) {
            aVar2.Li = new a.C0845a();
        }
        this.arx.Li.a(adTemplate, str, str2, aVar);
        return this;
    }
}
