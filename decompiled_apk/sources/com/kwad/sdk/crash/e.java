package com.kwad.sdk.crash;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.c;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* loaded from: classes11.dex */
public final class e {
    private com.kwad.sdk.crash.b.b aGY;
    private c aGZ;
    private long aHa;

    /* loaded from: classes11.dex */
    public static class a {
        private static final e aHb = new e(0);
    }

    public /* synthetic */ e(byte b) {
        this();
    }

    public static e If() {
        return a.aHb;
    }

    public final String[] Ig() {
        return this.aGY.It();
    }

    public final String[] Ih() {
        return this.aGY.Ih();
    }

    public final String Ii() {
        return this.aGZ.aGx.aHA;
    }

    public final int Ij() {
        return this.aGZ.aGx.aHE;
    }

    public final c Ik() {
        return this.aGZ;
    }

    public final h Il() {
        return this.aGZ.aGz;
    }

    public final long Im() {
        return SystemClock.elapsedRealtime() - this.aHa;
    }

    public final void a(@NonNull c cVar) {
        this.aGZ = cVar;
        this.aHa = SystemClock.elapsedRealtime();
        this.aGY.a(cVar.aGA, cVar.aGB);
    }

    public final void b(int i, ExceptionMessage exceptionMessage) {
        f Ib = this.aGZ.Ib();
        if (Ib != null) {
            Ib.a(i, exceptionMessage);
        }
    }

    public final String getAppId() {
        return this.aGZ.aGy.aHr;
    }

    public final Context getContext() {
        return this.aGZ.context;
    }

    public final String getSdkVersion() {
        return this.aGZ.aGx.mSdkVersion;
    }

    public final boolean isDebug() {
        return this.aGZ.Ic();
    }

    private e() {
        this.aGY = new com.kwad.sdk.crash.b.b();
        this.aGZ = new c.a().Ie();
    }
}
