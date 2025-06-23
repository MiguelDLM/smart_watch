package com.octopus.ad.internal;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.octopus.ad.R;
import com.octopus.ad.internal.view.BannerAdViewImpl;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class c {

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public oOoXoXO f18635Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public final com.octopus.ad.internal.oIX0oI f18637XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public ScheduledExecutorService f18638oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f18634II0xO0 = -1;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f18639oxoX = -1;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public long f18636X0o0xo = -1;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public EnumC0890c f18633II0XooXoX = EnumC0890c.STOPPED;

    /* renamed from: I0Io, reason: collision with root package name */
    public final I0Io f18632I0Io = new I0Io(this);

    /* loaded from: classes11.dex */
    public static class I0Io extends Handler {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final c f18640oIX0oI;

        public I0Io(c cVar) {
            super(Looper.getMainLooper());
            this.f18640oIX0oI = cVar;
        }

        @Override // android.os.Handler
        @SuppressLint({"NewApi"})
        public synchronized void handleMessage(Message message) {
            try {
                c cVar = this.f18640oIX0oI;
                if (cVar != null && cVar.f18637XO.oxoX()) {
                    if (cVar.f18639oxoX != -1) {
                        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.new_ad_since, Math.max(0, (int) (System.currentTimeMillis() - cVar.f18639oxoX))));
                    }
                    cVar.f18639oxoX = System.currentTimeMillis();
                    switch (oIX0oI.f18643II0xO0[cVar.f18637XO.getMediaType().ordinal()]) {
                        case 1:
                        case 2:
                            cVar.f18635Oxx0IOOO = new X0o0xo((BannerAdViewImpl) cVar.f18637XO);
                            break;
                        case 3:
                        case 4:
                            cVar.f18635Oxx0IOOO = new X0o0xo((InterstitialAdViewImpl) cVar.f18637XO);
                            break;
                        case 5:
                            cVar.f18635Oxx0IOOO = new xXoOI00O.oxoX((xXoOI00O.I0Io) cVar.f18637XO);
                            break;
                        case 6:
                            cVar.f18635Oxx0IOOO = new OOXIXo();
                            break;
                    }
                    cVar.f18635Oxx0IOOO.a();
                }
            } finally {
            }
        }
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements Runnable {
        public II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.handler_message_pass));
            c.this.f18632I0Io.sendEmptyMessage(0);
        }

        public /* synthetic */ II0xO0(c cVar, oIX0oI oix0oi) {
            this();
        }
    }

    /* renamed from: com.octopus.ad.internal.c$c, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public enum EnumC0890c {
        STOPPED,
        SINGLE_REQUEST,
        AUTO_REFRESH
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f18643II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f18644oIX0oI;

        static {
            int[] iArr = new int[l.values().length];
            f18643II0xO0 = iArr;
            try {
                iArr[l.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18643II0xO0[l.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18643II0xO0[l.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18643II0xO0[l.REWARDVIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18643II0xO0[l.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18643II0xO0[l.PREFETCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[EnumC0890c.values().length];
            f18644oIX0oI = iArr2;
            try {
                iArr2[EnumC0890c.STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18644oIX0oI[EnumC0890c.SINGLE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f18644oIX0oI[EnumC0890c.AUTO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public c(com.octopus.ad.internal.oIX0oI oix0oi) {
        this.f18637XO = oix0oi;
    }

    public final void OOXIXo() {
        if (this.f18638oIX0oI == null) {
            this.f18638oIX0oI = Executors.newScheduledThreadPool(4);
        }
    }

    public void Oxx0IOOO() {
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.start));
        OOXIXo();
        int i = oIX0oI.f18644oIX0oI[this.f18633II0XooXoX.ordinal()];
        oIX0oI oix0oi = null;
        long j = 0;
        if (i != 1) {
            if (i == 2) {
                com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.fetcher_start_single));
                this.f18638oIX0oI.schedule(new II0xO0(this, oix0oi), 0L, TimeUnit.SECONDS);
                return;
            }
            return;
        }
        if (this.f18634II0xO0 <= 0) {
            com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.fetcher_start_single));
            this.f18638oIX0oI.schedule(new II0xO0(this, oix0oi), 0L, TimeUnit.SECONDS);
            this.f18633II0XooXoX = EnumC0890c.SINGLE_REQUEST;
            return;
        }
        com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.fetcher_start_auto));
        int i2 = this.f18634II0xO0;
        long j2 = this.f18636X0o0xo;
        if (j2 != -1) {
            long j3 = this.f18639oxoX;
            if (j3 != -1) {
                long j4 = i2;
                j = Math.min(j4, Math.max(0L, j4 - (j2 - j3)));
            }
        }
        long j5 = j;
        com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.oO(R.string.request_delayed_by_x_ms, j5));
        this.f18638oIX0oI.scheduleAtFixedRate(new II0xO0(this, oix0oi), j5, i2, TimeUnit.MILLISECONDS);
        this.f18633II0XooXoX = EnumC0890c.AUTO_REFRESH;
    }

    public void X0o0xo(int i) {
        boolean z;
        if (this.f18634II0xO0 != i) {
            z = true;
        } else {
            z = false;
        }
        this.f18634II0xO0 = i;
        if (z && !this.f18633II0XooXoX.equals(EnumC0890c.STOPPED)) {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "AdFetcher refresh mPeriod changed to " + this.f18634II0xO0);
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Resetting AdFetcher");
            oxoX();
            Oxx0IOOO();
        }
    }

    public final void oOoXoXO() {
        ScheduledExecutorService scheduledExecutorService = this.f18638oIX0oI;
        if (scheduledExecutorService == null) {
            return;
        }
        scheduledExecutorService.shutdownNow();
        try {
            this.f18638oIX0oI.awaitTermination(this.f18634II0xO0, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            this.f18638oIX0oI = null;
            throw th;
        }
        this.f18638oIX0oI = null;
    }

    public void oxoX() {
        oOoXoXO oooxoxo = this.f18635Oxx0IOOO;
        if (oooxoxo != null) {
            oooxoxo.II0xO0();
            this.f18635Oxx0IOOO = null;
        }
        oOoXoXO();
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.stop));
        this.f18636X0o0xo = System.currentTimeMillis();
        this.f18633II0XooXoX = EnumC0890c.STOPPED;
    }

    public void xxIXOIIO() {
        this.f18639oxoX = -1L;
        this.f18636X0o0xo = -1L;
    }
}
