package com.octopus.ad.internal;

import android.util.Log;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.R;
import com.octopus.ad.internal.view.AdViewImpl;
import com.octopus.ad.internal.view.AdWebView;
import com.octopus.ad.internal.view.BannerAdViewImpl;
import java.lang.ref.SoftReference;
import java.util.concurrent.RejectedExecutionException;
import x0OxxIOxX.II0xO0;

/* loaded from: classes11.dex */
public class X0o0xo extends oOoXoXO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final SoftReference<AdViewImpl> f18613I0Io;

    /* renamed from: oxoX, reason: collision with root package name */
    public x0OxxIOxX.II0xO0 f18614oxoX;

    /* loaded from: classes11.dex */
    public class II0xO0 implements x0OxxIOxX.I0Io {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ x0OxxIOxX.oIX0oI f18615I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ AdWebView f18616II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ AdViewImpl f18617oIX0oI;

        public II0xO0(AdViewImpl adViewImpl, AdWebView adWebView, x0OxxIOxX.oIX0oI oix0oi) {
            this.f18617oIX0oI = adViewImpl;
            this.f18616II0xO0 = adWebView;
            this.f18615I0Io = oix0oi;
        }

        @Override // x0OxxIOxX.I0Io
        public l a() {
            return this.f18617oIX0oI.getMediaType();
        }

        @Override // x0OxxIOxX.I0Io
        public com.octopus.ad.internal.view.I0Io b() {
            if (this.f18617oIX0oI.getMediaType() != l.INTERSTITIAL && this.f18617oIX0oI.getMediaType() != l.REWARDVIDEO) {
                return this.f18616II0xO0.getRealDisplayable();
            }
            return this.f18616II0xO0;
        }

        @Override // x0OxxIOxX.I0Io
        public NativeAdResponse c() {
            return null;
        }

        @Override // x0OxxIOxX.I0Io
        public String d() {
            return this.f18615I0Io.OxI();
        }

        @Override // x0OxxIOxX.I0Io
        public int e() {
            return this.f18615I0Io.xII();
        }

        @Override // x0OxxIOxX.I0Io
        public String f() {
            return this.f18615I0Io.OI0();
        }

        @Override // x0OxxIOxX.I0Io
        public String g() {
            return this.f18615I0Io.O0xOxO();
        }

        @Override // x0OxxIOxX.I0Io
        public long h() {
            return this.f18615I0Io.XX();
        }

        @Override // x0OxxIOxX.I0Io
        public void i() {
            this.f18616II0xO0.destroy();
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ AdViewImpl f18620Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ x0OxxIOxX.oIX0oI f18621XO;

        public oIX0oI(x0OxxIOxX.oIX0oI oix0oi, AdViewImpl adViewImpl) {
            this.f18621XO = oix0oi;
            this.f18620Oo = adViewImpl;
        }

        @Override // java.lang.Runnable
        public void run() {
            x0OxxIOxX.oIX0oI oix0oi = this.f18621XO;
            if (oix0oi != null && oix0oi.IXxxXO()) {
                Log.d("octopus", "getMediaType:" + this.f18620Oo.getMediaType());
                if (this.f18620Oo.getMediaType().equals(l.BANNER)) {
                    ((BannerAdViewImpl) this.f18620Oo).Oxx();
                }
                Log.d("octopus", "handleStandardAds");
                X0o0xo.this.XO(this.f18620Oo, this.f18621XO);
                return;
            }
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.response_no_ads));
            this.f18620Oo.getAdDispatcher().a(oOoIIO0.I0Io.f32017XO);
        }
    }

    public X0o0xo(AdViewImpl adViewImpl) {
        this.f18613I0Io = new SoftReference<>(adViewImpl);
    }

    public II0xO0.C1145II0xO0 II0XooXoX() {
        if (this.f18613I0Io.get() != null) {
            return this.f18613I0Io.get().getAdRequest();
        }
        return null;
    }

    @Override // com.octopus.ad.internal.oOoXoXO
    public void II0xO0() {
        x0OxxIOxX.II0xO0 iI0xO0 = this.f18614oxoX;
        if (iI0xO0 != null) {
            iI0xO0.cancel(true);
            this.f18614oxoX = null;
        }
    }

    public void Oxx0IOOO(x0OxxIOxX.I0Io i0Io) {
        oxoX();
        AdViewImpl adViewImpl = this.f18613I0Io.get();
        if (adViewImpl != null) {
            adViewImpl.getAdDispatcher().oIX0oI(i0Io);
        } else {
            i0Io.i();
        }
    }

    public final void XO(AdViewImpl adViewImpl, x0OxxIOxX.oIX0oI oix0oi) {
        float f;
        try {
            boolean z = false;
            adViewImpl.getAdParameters().X0o0xo(false);
            AdWebView adWebView = new AdWebView(adViewImpl);
            adWebView.xXOx(oix0oi);
            if (oix0oi.X0IIOO() != null && oix0oi.X0IIOO().IIXOooo() != null) {
                if (oix0oi.oxxXoxO() > 0) {
                    f = oix0oi.oxxXoxO() / 640.0f;
                } else {
                    f = 1.0f;
                }
                adViewImpl.oxXx0IX(oix0oi.X0IIOO().IIXOooo(), f);
                z = true;
            }
            adViewImpl.XoX(z, oix0oi.Io(), oix0oi.IoOoX(), oix0oi.oxxXoxO());
            if (adViewImpl.getMediaType().equals(l.BANNER)) {
                adViewImpl.xI();
                BannerAdViewImpl bannerAdViewImpl = (BannerAdViewImpl) adViewImpl;
                if (bannerAdViewImpl.getExpandsToFitScreenWidth()) {
                    bannerAdViewImpl.XXXI(oix0oi.oxxXoxO(), oix0oi.xI(), adWebView);
                }
            }
            adViewImpl.f18782Oxx0xo = oix0oi;
            Oxx0IOOO(new II0xO0(adViewImpl, adWebView, oix0oi));
        } catch (Exception e) {
            Log.d("octopus", "========Exception=========:" + e);
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Exception initializing the view: " + e.getMessage());
            a(80001);
        }
    }

    @Override // com.octopus.ad.internal.oxoX
    public void a() {
        if (II0XooXoX() == null) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Before execute request manager, you should set ad request!");
            return;
        }
        this.f18614oxoX = new x0OxxIOxX.II0xO0(II0XooXoX());
        I0Io();
        try {
            this.f18614oxoX.Oxx0IOOO(this);
            this.f18614oxoX.executeOnExecutor(o0IXXIx.xoIox.II0xO0().I0Io(), new Void[0]);
            AdViewImpl adViewImpl = this.f18613I0Io.get();
            if (adViewImpl != null) {
                adViewImpl.getAdDispatcher().d();
            }
        } catch (IllegalStateException e) {
            Log.d("octopus", "ignored:" + e.getMessage());
        } catch (RejectedExecutionException e2) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Concurrent Thread Exception while firing new ad request: " + e2.getMessage());
        }
    }

    @Override // com.octopus.ad.internal.oxoX
    public I0Io b() {
        AdViewImpl adViewImpl = this.f18613I0Io.get();
        if (adViewImpl != null) {
            return adViewImpl.getAdParameters();
        }
        return null;
    }

    @Override // com.octopus.ad.internal.oxoX
    public void oIX0oI(x0OxxIOxX.oIX0oI oix0oi) {
        AdViewImpl adViewImpl = this.f18613I0Io.get();
        if (adViewImpl != null) {
            adViewImpl.getMyHandler().post(new oIX0oI(oix0oi, adViewImpl));
        }
    }

    @Override // com.octopus.ad.internal.oxoX
    public void a(int i) {
        oxoX();
        AdViewImpl adViewImpl = this.f18613I0Io.get();
        if (adViewImpl != null) {
            adViewImpl.getAdDispatcher().a(i);
        }
    }
}
