package oI;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.octopus.ad.AdActivity;
import com.octopus.ad.R;
import com.octopus.ad.internal.video.AdVideoView;
import com.octopus.ad.internal.view.AdWebView;
import com.octopus.ad.internal.view.InterstitialAdViewImpl;
import com.octopus.ad.internal.view.X0o0xo;
import com.octopus.ad.internal.xoIox;
import x0.I0oOoX;

/* loaded from: classes11.dex */
public class II0xO0 implements AdActivity.I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public com.octopus.ad.internal.view.I0Io f31314I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public AdWebView f31315II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public long f31316X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public InterstitialAdViewImpl f31317XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Activity f31318oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public FrameLayout f31319oxoX;

    public II0xO0(Activity activity) {
        this.f31318oIX0oI = activity;
    }

    public final void I0Io() {
        if (this.f31318oIX0oI != null) {
            InterstitialAdViewImpl interstitialAdViewImpl = this.f31317XO;
            if (interstitialAdViewImpl != null && interstitialAdViewImpl.getAdDispatcher() != null) {
                this.f31317XO.getAdDispatcher().a();
            }
            this.f31318oIX0oI.finish();
        }
    }

    public void II0xO0() {
        com.octopus.ad.internal.view.I0Io realDisplayable;
        com.octopus.ad.internal.view.I0Io i0Io;
        AdWebView adWebView = this.f31315II0xO0;
        if (adWebView != null && (realDisplayable = adWebView.getRealDisplayable()) != (i0Io = this.f31314I0Io)) {
            this.f31319oxoX.removeView(i0Io.getView());
            if (realDisplayable instanceof AdVideoView) {
                this.f31319oxoX.addView(realDisplayable.getView(), new ViewGroup.LayoutParams(-1, -1));
            } else {
                this.f31319oxoX.addView(realDisplayable.getView(), new ViewGroup.LayoutParams(-1, -1));
            }
            this.f31314I0Io = realDisplayable;
            realDisplayable.II0xO0();
        }
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void a() {
        InterstitialAdViewImpl interstitialAdViewImpl = InterstitialAdViewImpl.f19001O0IxXx;
        if (interstitialAdViewImpl != null && interstitialAdViewImpl.getAdQueue() != null) {
            X0o0xo peek = InterstitialAdViewImpl.f19001O0IxXx.getAdQueue().peek();
            if (peek != null && peek.c() != null && (peek.c() instanceof AdWebView)) {
                WindowManager.LayoutParams attributes = this.f31318oIX0oI.getWindow().getAttributes();
                attributes.width = -1;
                attributes.height = -1;
                this.f31318oIX0oI.getWindow().setAttributes(attributes);
                AdWebView adWebView = (AdWebView) peek.c();
                adWebView.getSettings().setLoadsImagesAutomatically(true);
                if (adWebView.OI0()) {
                    this.f31318oIX0oI.setTheme(R.style.OctopusDialogStyle);
                } else {
                    this.f31318oIX0oI.setTheme(R.style.OctopusDialogStyleTran);
                }
                if (adWebView.XX()) {
                    this.f31318oIX0oI.setTheme(R.style.OctopusTheme_Transparent);
                    this.f31318oIX0oI.requestWindowFeature(1);
                    this.f31318oIX0oI.getWindow().setFlags(1024, 1024);
                }
                this.f31319oxoX = new FrameLayout(this.f31318oIX0oI);
                this.f31319oxoX.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                this.f31318oIX0oI.setContentView(this.f31319oxoX);
                this.f31316X0o0xo = this.f31318oIX0oI.getIntent().getLongExtra("TIME", System.currentTimeMillis());
                oIX0oI(InterstitialAdViewImpl.f19001O0IxXx);
                return;
            }
            this.f31318oIX0oI.finish();
            return;
        }
        this.f31318oIX0oI.finish();
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void b() {
        AdWebView adWebView = this.f31315II0xO0;
        if (adWebView != null) {
            AdVideoView adVideoView = adWebView.f18932oI0IIXIo;
            if (adVideoView != null) {
                adVideoView.onResume();
            }
            InterstitialAdViewImpl interstitialAdViewImpl = this.f31317XO;
            if (interstitialAdViewImpl != null) {
                interstitialAdViewImpl.XO();
            }
        }
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void c() {
        AdWebView adWebView = this.f31315II0xO0;
        if (adWebView != null) {
            AdVideoView adVideoView = adWebView.f18932oI0IIXIo;
            if (adVideoView != null) {
                adVideoView.onPause();
            }
            InterstitialAdViewImpl interstitialAdViewImpl = this.f31317XO;
            if (interstitialAdViewImpl != null) {
                interstitialAdViewImpl.xxIXOIIO();
            }
        }
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void d() {
        AdWebView adWebView = this.f31315II0xO0;
        if (adWebView != null) {
            I0oOoX.O0xOxO(adWebView);
            this.f31315II0xO0.destroy();
            AdVideoView adVideoView = this.f31315II0xO0.f18932oI0IIXIo;
            if (adVideoView != null) {
                adVideoView.destroy();
            }
        }
        InterstitialAdViewImpl interstitialAdViewImpl = this.f31317XO;
        if (interstitialAdViewImpl != null) {
            interstitialAdViewImpl.setAdImplementation(null);
            this.f31317XO.oIX0oI();
        }
        this.f31318oIX0oI.finish();
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void e() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f31317XO;
        if (interstitialAdViewImpl != null && interstitialAdViewImpl.getAdDispatcher() != null && !this.f31317XO.OOXIxO0() && this.f31318oIX0oI != null) {
            this.f31317XO.getAdDispatcher().a();
            this.f31318oIX0oI.finish();
        }
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void g() {
        InterstitialAdViewImpl interstitialAdViewImpl = this.f31317XO;
        if (interstitialAdViewImpl != null && interstitialAdViewImpl.XXXI()) {
            I0Io();
        }
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public WebView h() {
        return this.f31315II0xO0;
    }

    public final void oIX0oI(InterstitialAdViewImpl interstitialAdViewImpl) {
        int i;
        int creativeWidth;
        float creativeHeight;
        float f;
        this.f31317XO = interstitialAdViewImpl;
        if (interstitialAdViewImpl == null) {
            return;
        }
        interstitialAdViewImpl.setAdImplementation(this);
        this.f31319oxoX.setBackgroundColor(this.f31317XO.getBackgroundColor());
        this.f31319oxoX.removeAllViews();
        if (this.f31317XO.getParent() != null) {
            ((ViewGroup) this.f31317XO.getParent()).removeAllViews();
        }
        X0o0xo poll = this.f31317XO.getAdQueue().poll();
        while (poll != null && (this.f31316X0o0xo - poll.a() > xoIox.f19058ooXIXxIX || this.f31316X0o0xo - poll.a() < 0)) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.too_old));
            poll = this.f31317XO.getAdQueue().poll();
        }
        if (poll != null && (poll.c() instanceof AdWebView)) {
            AdWebView adWebView = (AdWebView) poll.c();
            this.f31315II0xO0 = adWebView;
            if (adWebView.getContext() instanceof MutableContextWrapper) {
                ((MutableContextWrapper) this.f31315II0xO0.getContext()).setBaseContext(this.f31318oIX0oI);
                AdVideoView adVideoView = this.f31315II0xO0.f18932oI0IIXIo;
                if (adVideoView != null) {
                    ((MutableContextWrapper) adVideoView.getContext()).setBaseContext(this.f31318oIX0oI);
                }
            }
            if ((this.f31315II0xO0.getCreativeWidth() != 1 || this.f31315II0xO0.getCreativeHeight() != 1) && this.f31318oIX0oI.getResources().getConfiguration().orientation != 2) {
                try {
                    i = this.f31317XO.getAdParameters().XO().getApplicationInfo().targetSdkVersion;
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 0;
                }
                if (i > 26 && Build.VERSION.SDK_INT == 26) {
                    Log.d("octopus", "Only fullscreen activities can request orientation");
                } else {
                    AdActivity.I0Io(this.f31318oIX0oI, this.f31315II0xO0.getOrientation());
                }
            }
            this.f31314I0Io = this.f31315II0xO0.getRealDisplayable();
            if (this.f31317XO.OOXIxO0()) {
                this.f31319oxoX.addView(this.f31315II0xO0.getRealDisplayable().getView(), new FrameLayout.LayoutParams(-1, -1, 17));
            } else {
                if (this.f31318oIX0oI.getRequestedOrientation() == 0) {
                    creativeWidth = (int) (this.f31315II0xO0.getCreativeHeight() * xoIox.oIX0oI().f19070Oxx0xo);
                    creativeHeight = this.f31315II0xO0.getCreativeWidth();
                    f = xoIox.oIX0oI().f19075oI0IIXIo;
                } else {
                    creativeWidth = (int) (this.f31315II0xO0.getCreativeWidth() * xoIox.oIX0oI().f19070Oxx0xo);
                    creativeHeight = this.f31315II0xO0.getCreativeHeight();
                    f = xoIox.oIX0oI().f19075oI0IIXIo;
                }
                int i2 = (int) (creativeHeight * f);
                if (creativeWidth > I0oOoX.Oxx0xo(this.f31315II0xO0.getContext()) || creativeWidth <= 0) {
                    creativeWidth = I0oOoX.Oxx0xo(this.f31315II0xO0.getContext());
                }
                if (i2 > I0oOoX.oO(this.f31315II0xO0.getContext()) || i2 <= 0) {
                    i2 = I0oOoX.oO(this.f31315II0xO0.getContext());
                }
                this.f31319oxoX.addView(this.f31315II0xO0.getRealDisplayable().getView(), new FrameLayout.LayoutParams(creativeWidth, i2, 17));
            }
            this.f31314I0Io.II0xO0();
        }
    }

    @Override // com.octopus.ad.AdActivity.I0Io
    public void f() {
    }
}
