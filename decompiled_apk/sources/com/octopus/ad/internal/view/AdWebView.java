package com.octopus.ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.octopus.ad.AdActivity;
import com.octopus.ad.R;
import com.octopus.ad.internal.i;
import com.octopus.ad.internal.l;
import com.octopus.ad.internal.video.AdVideoView;
import com.octopus.ad.internal.view.AdViewImpl;
import com.octopus.ad.internal.view.f;
import com.octopus.ad.internal.view.xxIXOIIO;
import com.octopus.ad.internal.xoIox;
import com.octopus.ad.model.e;
import fi.iki.elonen.NanoHTTPD;
import java.util.HashMap;
import java.util.regex.Matcher;
import oOoIIO0.xoXoI;
import x0.I0oOoX;
import x0.ooXIXxIX;
import x0.oxXx0IX;
import x0.x0o;
import x0.xI;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public class AdWebView extends WebView implements com.octopus.ad.internal.view.I0Io {

    /* renamed from: I0oOoX, reason: collision with root package name */
    public boolean f18907I0oOoX;

    /* renamed from: IIX0o, reason: collision with root package name */
    public boolean f18908IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public f f18909IIXOooo;

    /* renamed from: IO, reason: collision with root package name */
    public int f18910IO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public x0OxxIOxX.oIX0oI f18911IXxxXO;

    /* renamed from: Io, reason: collision with root package name */
    public boolean f18912Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public String f18913IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public boolean f18914O0xOxO;

    /* renamed from: OI0, reason: collision with root package name */
    public boolean f18915OI0;

    /* renamed from: Oo, reason: collision with root package name */
    public AdViewImpl f18916Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public boolean f18917OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public GestureDetector f18918Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f18919OxxIIOOXO;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public int f18920X00IoxXI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f18921X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public int f18922XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public int f18923XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public boolean f18924XO;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public boolean f18925XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public boolean f18926XX;

    /* renamed from: XoX, reason: collision with root package name */
    public int f18927XoX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public boolean f18928Xx000oIo;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public int f18929XxX0x0xxx;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f18930o0;

    /* renamed from: o00, reason: collision with root package name */
    public int f18931o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public AdVideoView f18932oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public boolean f18933oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public ProgressDialog f18934oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f18935oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public Handler f18936ooXIXxIX;

    /* renamed from: oxXx0IX, reason: collision with root package name */
    public int f18937oxXx0IX;

    /* renamed from: oxxXoxO, reason: collision with root package name */
    public com.octopus.ad.internal.view.xxIXOIIO f18938oxxXoxO;

    /* renamed from: x0o, reason: collision with root package name */
    public boolean f18939x0o;

    /* renamed from: xI, reason: collision with root package name */
    public boolean f18940xI;

    /* renamed from: xII, reason: collision with root package name */
    public int f18941xII;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public boolean f18942xXxxox0I;

    /* renamed from: xo0x, reason: collision with root package name */
    public final Runnable f18943xo0x;

    /* renamed from: xoXoI, reason: collision with root package name */
    public int f18944xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public int f18945xxX;

    /* loaded from: classes11.dex */
    public class I0Io implements DialogInterface.OnCancelListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ WebView f18947XO;

        public I0Io(WebView webView) {
            this.f18947XO = webView;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f18947XO.stopLoading();
        }
    }

    /* loaded from: classes11.dex */
    public interface II0XooXoX {
        void a();
    }

    /* loaded from: classes11.dex */
    public class II0xO0 extends ooXIXxIX {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ String f18948I0Io;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public II0xO0(boolean z, String str) {
            super(z);
            this.f18948I0Io = str;
        }

        @Override // x0.ooXIXxIX
        public void II0XooXoX(xI xIVar) {
            if (xIVar.X0o0xo()) {
                AdWebView.this.loadDataWithBaseURL(xoIox.oIX0oI().IXxxXO(), AdWebView.this.xXxxox0I(AdWebView.this.xxX(AdWebView.this.OxI(xIVar.oxoX()))), NanoHTTPD.MIME_HTML, "UTF-8", null);
                AdWebView.this.xI();
            }
        }

        @Override // x0.ooXIXxIX
        public String Oxx0IOOO() {
            return this.f18948I0Io;
        }
    }

    /* loaded from: classes11.dex */
    public class Oxx0IOOO extends WebViewClient {
        public Oxx0IOOO() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (str.startsWith("http")) {
                try {
                    WebView.HitTestResult hitTestResult = AdWebView.this.getHitTestResult();
                    if (hitTestResult != null && hitTestResult.getExtra() != null) {
                        if (hitTestResult.getExtra().equals(str)) {
                            int type = hitTestResult.getType();
                            if (type == 1 || type == 6 || type == 7 || type == 8) {
                                AdWebView.this.oI0IIXIo(str);
                                webView.stopLoading();
                                AdWebView.this.IIXOooo();
                            }
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            AdWebView adWebView = AdWebView.this;
            l lVar = adWebView.f18911IXxxXO.f33935xo0x;
            if (lVar != l.SPLASH && lVar != l.BANNER) {
                if (lVar == l.INTERSTITIAL) {
                    adWebView.f18916Oo.O00XxXI(adWebView);
                }
            } else {
                adWebView.II0xO0();
            }
            if (!AdWebView.this.f18914O0xOxO) {
                webView.evaluateJavascript("javascript:window.mraid.util.pageFinished()", null);
                if (AdWebView.this.f18919OxxIIOOXO) {
                    f fVar = AdWebView.this.f18909IIXOooo;
                    AdWebView adWebView2 = AdWebView.this;
                    fVar.xxIXOIIO(adWebView2, adWebView2.f18913IoOoX);
                    AdWebView.this.xII();
                }
                AdWebView.this.f18914O0xOxO = true;
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.x0XOIxOo(R.string.webview_received_error, i, str, str2));
            AdViewImpl adViewImpl = AdWebView.this.f18916Oo;
            if (adViewImpl != null && adViewImpl.getAdDispatcher() != null) {
                AdWebView.this.f18916Oo.getAdDispatcher().a(2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AdWebView.this.oOXoIIIo();
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18697XO, com.octopus.ad.internal.utilities.oIX0oI.ooOOo0oXI(R.string.webclient_error, sslError.getPrimaryError(), sslError.toString()));
            AdViewImpl adViewImpl = AdWebView.this.f18916Oo;
            if (adViewImpl != null && adViewImpl.getAdDispatcher() != null) {
                AdWebView.this.f18916Oo.getAdDispatcher().a(2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            AdViewImpl adViewImpl;
            com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Loading URL: " + str);
            o0IXXIx.II0XooXoX.oIX0oI("octopus", "Loading:::::::::::::::::::::::" + str);
            if (str.startsWith(x0xO.II0xO0.f34059xoIox)) {
                return false;
            }
            if (str.startsWith("mraid://")) {
                com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18689OOXIXo, str);
                if (AdWebView.this.f18919OxxIIOOXO) {
                    AdWebView.this.f18909IIXOooo.OOXIXo(str, AdWebView.this.f18928Xx000oIo);
                } else {
                    String host = Uri.parse(str).getHost();
                    if (host != null && host.equals("enable")) {
                        AdWebView.this.xI();
                    } else if (host != null && host.equals("open")) {
                        AdWebView.this.f18909IIXOooo.OOXIXo(str, AdWebView.this.f18928Xx000oIo);
                    }
                }
                return true;
            }
            if (str.startsWith("Octopus://")) {
                try {
                    String host2 = Uri.parse(str).getHost();
                    if (!TextUtils.isEmpty(host2) && !"ClosePage".equals(host2)) {
                        AdWebView adWebView = AdWebView.this;
                        if (adWebView.f18911IXxxXO != null && (adViewImpl = adWebView.f18916Oo) != null && adViewImpl.getAdParameters() != null) {
                            AdWebView adWebView2 = AdWebView.this;
                            adWebView2.f18911IXxxXO.XoX(adWebView2, adWebView2.f18937oxXx0IX);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.octopus.ad.internal.view.Oxx0IOOO.oxoX(AdWebView.this, str);
                return true;
            }
            AdWebView.this.oI0IIXIo(str);
            AdWebView.this.IIXOooo();
            return true;
        }

        public /* synthetic */ Oxx0IOOO(AdWebView adWebView, oIX0oI oix0oi) {
            this();
        }
    }

    /* loaded from: classes11.dex */
    public class X0o0xo implements II0XooXoX {

        /* renamed from: I0Io, reason: collision with root package name */
        public final /* synthetic */ AdActivity.b f18951I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public final /* synthetic */ boolean f18952II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ f f18953oIX0oI;

        public X0o0xo(f fVar, boolean z, AdActivity.b bVar) {
            this.f18953oIX0oI = fVar;
            this.f18952II0xO0 = z;
            this.f18951I0Io = bVar;
        }

        @Override // com.octopus.ad.internal.view.AdWebView.II0XooXoX
        public void a() {
            f fVar = this.f18953oIX0oI;
            if (fVar != null && fVar.Oo() != null) {
                AdWebView.this.xxIXOIIO(this.f18953oIX0oI.Oo(), this.f18952II0xO0, this.f18951I0Io);
                AdViewImpl.setMRAIDFullscreenListener(null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class XO implements Runnable {
        public XO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AdWebView.this.f18940xI) {
                return;
            }
            AdWebView.this.IIX0o();
            AdWebView.this.f18936ooXIXxIX.postDelayed(this, 1000L);
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements xxIXOIIO.oIX0oI {
        public oIX0oI() {
        }

        @Override // com.octopus.ad.internal.view.xxIXOIIO.oIX0oI
        public void a(View view) {
            if (AdWebView.this.f18907I0oOoX) {
                AdWebView.this.f18937oxXx0IX = 12;
            }
            AdWebView adWebView = AdWebView.this;
            adWebView.IO(adWebView.f18937oxXx0IX);
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX implements Runnable {

        /* loaded from: classes11.dex */
        public class oIX0oI implements xoXoI {
            public oIX0oI() {
            }

            @Override // oOoIIO0.xoXoI
            public void a(boolean z) {
                AdViewImpl adViewImpl = AdWebView.this.f18916Oo;
                if (adViewImpl != null && adViewImpl.getAdDispatcher() != null) {
                    AdWebView.this.f18916Oo.getAdDispatcher().a(z);
                }
            }
        }

        public oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdWebView adWebView = AdWebView.this;
            x0OxxIOxX.oIX0oI oix0oi = adWebView.f18911IXxxXO;
            if (oix0oi != null) {
                oix0oi.XX0(adWebView, new oIX0oI());
            }
        }
    }

    /* loaded from: classes11.dex */
    public class xxIXOIIO extends WebView {

        /* loaded from: classes11.dex */
        public class oIX0oI extends WebViewClient {

            /* renamed from: II0xO0, reason: collision with root package name */
            public final /* synthetic */ AdWebView f18961II0xO0;

            /* renamed from: oIX0oI, reason: collision with root package name */
            public boolean f18962oIX0oI = false;

            public oIX0oI(AdWebView adWebView) {
                this.f18961II0xO0 = adWebView;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18702oOoXoXO, "Opening URL: " + str);
                I0oOoX.O0xOxO(xxIXOIIO.this);
                if (AdWebView.this.f18934oo != null && AdWebView.this.f18934oo.isShowing()) {
                    AdWebView.this.f18934oo.dismiss();
                }
                if (this.f18962oIX0oI) {
                    this.f18962oIX0oI = false;
                    xxIXOIIO.this.destroy();
                    AdWebView.this.oxXx0IX();
                } else {
                    xxIXOIIO.this.setVisibility(0);
                    xxIXOIIO xxixoiio = xxIXOIIO.this;
                    AdWebView.this.xoIox(xxixoiio);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18702oOoXoXO, "Redirecting to URL: " + str);
                boolean X00IoxXI2 = AdWebView.this.X00IoxXI(str);
                this.f18962oIX0oI = X00IoxXI2;
                if (X00IoxXI2 && AdWebView.this.f18934oo != null && AdWebView.this.f18934oo.isShowing()) {
                    AdWebView.this.f18934oo.dismiss();
                }
                return this.f18962oIX0oI;
            }
        }

        @SuppressLint({"SetJavaScriptEnabled"})
        public xxIXOIIO(Context context) {
            super(new MutableContextWrapper(context));
            oxXx0IX.XO(this);
            setWebViewClient(new oIX0oI(AdWebView.this));
        }
    }

    public AdWebView(AdViewImpl adViewImpl) {
        super(new MutableContextWrapper(adViewImpl.getContext()));
        this.f18924XO = false;
        this.f18911IXxxXO = null;
        this.f18932oI0IIXIo = null;
        this.f18917OxI = false;
        this.f18942xXxxox0I = false;
        this.f18908IIX0o = false;
        this.f18936ooXIXxIX = new Handler();
        this.f18940xI = false;
        this.f18933oOXoIIIo = false;
        this.f18928Xx000oIo = false;
        this.f18941xII = -1;
        this.f18939x0o = false;
        this.f18925XOxIOxOx = false;
        this.f18915OI0 = false;
        this.f18912Io = false;
        this.f18930o0 = false;
        this.f18926XX = false;
        this.f18907I0oOoX = false;
        this.f18927XoX = 0;
        this.f18937oxXx0IX = 0;
        this.f18943xo0x = new XO();
        setBackgroundColor(0);
        this.f18916Oo = adViewImpl;
        this.f18913IoOoX = f.f19012Oxx0xo[f.b.STARTING_DEFAULT.ordinal()];
        XO();
        Oxx0xo();
        setVisibility(4);
        this.f18916Oo.setAdWebView(this);
    }

    private void Oxx0IOOO(int i, int i2) {
        if (i == 0 && i2 == 0) {
            oxXx0IX.X0o0xo(this);
            this.f18908IIX0o = true;
            if (this.f18919OxxIIOOXO && this.f18914O0xOxO) {
                xII();
            }
        } else {
            oxXx0IX.oxoX(this);
            this.f18908IIX0o = false;
            oxxXoxO();
        }
        f fVar = this.f18909IIXOooo;
        if (fVar != null) {
            fVar.oO();
        }
    }

    private void setCreativeHeight(int i) {
        this.f18945xxX = i;
    }

    private void setCreativeWidth(int i) {
        this.f18923XIxXXX0x0 = i;
    }

    private void x0XOIxOo(HashMap hashMap) {
        if (!hashMap.isEmpty() && hashMap.containsKey(x0OxxIOxX.oIX0oI.f33875x0xO)) {
            this.f18919OxxIIOOXO = ((Boolean) hashMap.get(x0OxxIOxX.oIX0oI.f33875x0xO)).booleanValue();
        }
    }

    public boolean I0Io() {
        return this.f18926XX;
    }

    public boolean I0X0x0oIo(int i) {
        return XX0(this.f18941xII + i);
    }

    public void II0XooXoX(int i, int i2, boolean z, f fVar, boolean z2, AdActivity.b bVar) {
        X0o0xo x0o0xo;
        int i3 = i;
        int i4 = i2;
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        if (!this.f18909IIXOooo.f19026oxoX) {
            this.f18944xoXoI = layoutParams.width;
            this.f18931o00 = layoutParams.height;
        }
        if (i4 == -1 && i3 == -1 && this.f18916Oo != null) {
            this.f18917OxI = true;
        }
        if (i4 != -1) {
            i4 = (int) ((i4 * r3.density) + 0.5d);
        }
        int i5 = i4;
        if (i3 != -1) {
            i3 = (int) ((i3 * r3.density) + 0.5d);
        }
        int i6 = i3;
        layoutParams.height = i5;
        layoutParams.width = i6;
        layoutParams.gravity = 17;
        if (this.f18917OxI) {
            x0o0xo = new X0o0xo(fVar, z2, bVar);
        } else {
            x0o0xo = null;
        }
        X0o0xo x0o0xo2 = x0o0xo;
        AdViewImpl adViewImpl = this.f18916Oo;
        if (adViewImpl != null) {
            adViewImpl.IIXOooo(i6, i5, z, fVar, x0o0xo2);
            this.f18916Oo.IoOoo();
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public void II0xO0() {
        if (this.f18916Oo != null) {
            setVisibility(0);
            this.f18916Oo.xxOXOOoIX(this);
            this.f18916Oo.oo(this);
            if (l.BANNER.equals(this.f18916Oo.getMediaType())) {
                AdViewImpl adViewImpl = this.f18916Oo;
                adViewImpl.xXoOI00O(adViewImpl);
            }
            if (XoI0Ixx0()) {
                if (this.f18916Oo.getMediaType() == l.INTERSTITIAL) {
                    this.f18916Oo.IoOoX(getShowSkipBtnTime(), getAutoCloseTime(), this);
                } else {
                    this.f18916Oo.O00XxXI(this);
                }
            }
            if (this.f18916Oo.getAdDispatcher() != null && this.f18916Oo.getMediaType() == l.INTERSTITIAL) {
                oX();
            }
        }
    }

    public void IIX0o() {
        if (!(getContextFromMutableContext() instanceof Activity)) {
            return;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        boolean z = false;
        int i = iArr[0];
        int width = getWidth() + i;
        int i2 = iArr[1];
        int height = getHeight() + i2;
        int[] IXxxXO2 = I0oOoX.IXxxXO((Activity) getContextFromMutableContext());
        if (width > 0 && i < IXxxXO2[0] && height > 0 && i2 < IXxxXO2[1]) {
            z = true;
        }
        this.f18942xXxxox0I = z;
        f fVar = this.f18909IIXOooo;
        if (fVar != null) {
            fVar.oO();
            this.f18909IIXOooo.X0o0xo(i, i2, getWidth(), getHeight());
            this.f18909IIXOooo.oxoX(getContext().getResources().getConfiguration().orientation);
        }
    }

    public void IIXOooo() {
        AdViewImpl adViewImpl = this.f18916Oo;
        if (adViewImpl != null) {
            adViewImpl.IoOoo();
        }
    }

    public void IO(int i) {
        ViewGroup splashParent;
        AdViewImpl adViewImpl = this.f18916Oo;
        if (adViewImpl != null && adViewImpl.getAdDispatcher() != null) {
            this.f18927XoX++;
            if (!this.f18907I0oOoX) {
                this.f18916Oo.getAdDispatcher().c();
            }
            this.f18911IXxxXO.XI0oooXX(this.f18916Oo.getOpensNativeBrowser());
            if (this.f18916Oo.getSplashParent() == null) {
                splashParent = this;
            } else {
                splashParent = this.f18916Oo.getSplashParent();
            }
            this.f18911IXxxXO.XoX(splashParent, i);
        }
    }

    public boolean Io() {
        return this.f18933oOXoIIIo;
    }

    public final boolean IoOoX(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            this.f18916Oo.getContext().startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.opening_url_failed, str));
            if (this.f18919OxxIIOOXO) {
                Toast.makeText(this.f18916Oo.getContext(), R.string.action_cant_be_completed, 0).show();
            }
            return false;
        }
    }

    public void O0xOxO() {
        AdViewImpl adViewImpl = this.f18916Oo;
        if (adViewImpl != null) {
            adViewImpl.xXOx();
        }
    }

    public boolean OI0() {
        return this.f18912Io;
    }

    public final void OOXIXo(FrameLayout.LayoutParams layoutParams) {
        AdViewImpl adViewImpl = this.f18916Oo;
        if (adViewImpl instanceof BannerAdViewImpl) {
            if (((BannerAdViewImpl) adViewImpl).getResizeAdToFitContainer()) {
                setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                return;
            } else {
                setLayoutParams(layoutParams);
                return;
            }
        }
        setLayoutParams(layoutParams);
    }

    public final String OxI(String str) {
        if (!x0o.II0XooXoX(str)) {
            str.trim();
            if (!str.startsWith("<html>")) {
                return "<html><body style='padding:0;margin:0;'>" + str + "</body></html>";
            }
            return str;
        }
        return str;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void Oxx0xo() {
        this.f18909IIXOooo = new f(this);
        setWebChromeClient(new com.octopus.ad.internal.view.II0XooXoX(this));
        setWebViewClient(new Oxx0IOOO(this, null));
    }

    public final boolean X00IoxXI(String str) {
        String oIX0oI2 = o0IXXIx.I0Io.oIX0oI("aHR0cDovL2Fib3V0OmJsYW5r");
        if (!str.contains("://play.google.com") && (str.startsWith("http") || str.startsWith(oIX0oI2))) {
            return false;
        }
        com.octopus.ad.internal.utilities.oIX0oI.IIXOooo(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.opening_app_store));
        return IoOoX(str);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void XO() {
        xoIox.oIX0oI().oOoXoXO(getSettings().getUserAgentString());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setEnableSmoothTransition(true);
        getSettings().setLightTouchEnabled(false);
        getSettings().setPluginState(WebSettings.PluginState.ON);
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setSavePassword(false);
        getSettings().setSupportZoom(false);
        getSettings().setUseWideViewPort(false);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().setMixedContentMode(0);
        WebView.setWebContentsDebuggingEnabled(false);
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        CookieManager cookieManager = CookieManager.getInstance();
        if (cookieManager != null) {
            cookieManager.setAcceptThirdPartyCookies(this, true);
        } else {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Failed to set Webview to accept 3rd party cookie");
        }
        setHorizontalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        if (this.f18915OI0) {
            setBackgroundColor(0);
        }
        setScrollBarStyle(0);
    }

    public boolean XOxIOxOx() {
        return this.f18939x0o;
    }

    public boolean XX() {
        return this.f18915OI0;
    }

    public boolean XX0(int i) {
        int creativeHeight;
        int creativeWidth;
        x0OxxIOxX.oIX0oI oix0oi = this.f18911IXxxXO;
        if (oix0oi != null && this.f18941xII != i) {
            if (!oix0oi.XxX0x0xxx().isEmpty() && this.f18911IXxxXO.XxX0x0xxx().size() > i) {
                Pair<i, String> pair = this.f18911IXxxXO.XxX0x0xxx().get(i);
                if (x0o.II0XooXoX((String) pair.second)) {
                    oOXoIIIo();
                    return false;
                }
                if (pair.first == i.VIDEO) {
                    if (this.f18932oI0IIXIo == null) {
                        this.f18932oI0IIXIo = new AdVideoView(this);
                    }
                    this.f18932oI0IIXIo.x0o(this, (String) pair.second);
                    this.f18930o0 = true;
                    String oIX0oI2 = o0IXXIx.I0Io.oIX0oI("aHR0cDovL2Fib3V0OmJsYW5r");
                    if (!TextUtils.isEmpty(oIX0oI2)) {
                        loadUrl(oIX0oI2);
                    }
                } else {
                    com.octopus.ad.internal.utilities.oIX0oI.ooXIXxIX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.webview_loading, (String) pair.second));
                    x0XOIxOo(this.f18911IXxxXO.xXxxox0I());
                    String xXxxox0I2 = xXxxox0I(xxX(OxI((String) pair.second)));
                    float oI0IIXIo2 = xoIox.oIX0oI().oI0IIXIo();
                    float OxxIIOOXO2 = xoIox.oIX0oI().OxxIIOOXO();
                    float IIXOooo2 = xoIox.oIX0oI().IIXOooo();
                    if (getCreativeWidth() == -1 && getCreativeHeight() == -1) {
                        creativeWidth = -1;
                        creativeHeight = -1;
                    } else {
                        creativeHeight = (int) ((getCreativeHeight() * IIXOooo2) + 0.5f);
                        creativeWidth = (int) ((getCreativeWidth() * IIXOooo2) + 0.5f);
                    }
                    if (getCreativeLeft() == 0 && getCreativeTop() == 0) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 17);
                        l lVar = this.f18911IXxxXO.f33935xo0x;
                        if (lVar == l.SPLASH) {
                            setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                        } else if (lVar == l.BANNER) {
                            OOXIXo(new FrameLayout.LayoutParams(-2, -1, 17));
                        } else {
                            OOXIXo(layoutParams);
                        }
                    } else {
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(creativeWidth, creativeHeight, 8388659);
                        layoutParams2.setMargins((int) ((getCreativeLeft() * oI0IIXIo2) + 0.5f), (int) ((getCreativeTop() * OxxIIOOXO2) + 0.5f), 0, 0);
                        if (this.f18911IXxxXO.f33935xo0x == l.SPLASH) {
                            setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                        } else {
                            OOXIXo(layoutParams2);
                        }
                    }
                    loadDataWithBaseURL(xoIox.oIX0oI().IXxxXO(), xXxxox0I2, NanoHTTPD.MIME_HTML, "UTF-8", null);
                    this.f18930o0 = false;
                }
                this.f18941xII = i;
                return true;
            }
            oOXoIIIo();
        }
        return false;
    }

    public void Xo0(int i, int i2, int i3, int i4, f.a aVar, boolean z) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getLayoutParams());
        f fVar = this.f18909IIXOooo;
        if (!fVar.f19026oxoX) {
            this.f18944xoXoI = layoutParams.width;
            this.f18931o00 = layoutParams.height;
        }
        float f = displayMetrics.density;
        int i5 = (int) ((i2 * f) + 0.5d);
        int i6 = (int) ((i * f) + 0.5d);
        layoutParams.height = i5;
        layoutParams.width = i6;
        layoutParams.gravity = 17;
        AdViewImpl adViewImpl = this.f18916Oo;
        if (adViewImpl != null) {
            adViewImpl.oI0IIXIo(i6, i5, i3, i4, aVar, z, fVar);
        }
        AdViewImpl adViewImpl2 = this.f18916Oo;
        if (adViewImpl2 != null) {
            adViewImpl2.IoOoo();
        }
        setLayoutParams(layoutParams);
    }

    public boolean XoI0Ixx0() {
        if (this.f18911IXxxXO.XIxXXX0x0() == e.a.ADP_IVIDEO) {
            if (this.f18911IXxxXO.XxX0x0xxx().get(this.f18941xII).first != i.VIDEO) {
                return false;
            }
        } else if (this.f18941xII != 0) {
            return false;
        }
        return true;
    }

    public void XxX0x0xxx() {
        AdViewImpl adViewImpl = this.f18916Oo;
        if (adViewImpl != null) {
            adViewImpl.OxxIIOOXO(this.f18944xoXoI, this.f18931o00, this.f18909IIXOooo);
        }
    }

    @Override // android.webkit.WebView, com.octopus.ad.internal.view.I0Io
    public void destroy() {
        if (this.f18916Oo.getMediaType() != l.SPLASH) {
            setVisibility(4);
            removeAllViews();
            I0oOoX.O0xOxO(this);
        }
        super.destroy();
        oxxXoxO();
    }

    public HashMap<String, Object> getAdExtras() {
        x0OxxIOxX.oIX0oI oix0oi = this.f18911IXxxXO;
        if (oix0oi == null) {
            return null;
        }
        return oix0oi.xXxxox0I();
    }

    public int getAutoCloseTime() {
        return this.f18910IO;
    }

    public Context getContextFromMutableContext() {
        if (getContext() instanceof MutableContextWrapper) {
            return ((MutableContextWrapper) getContext()).getBaseContext();
        }
        return getContext();
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public int getCreativeHeight() {
        return this.f18945xxX;
    }

    public int getCreativeLeft() {
        return this.f18921X0IIOO;
    }

    public int getCreativeTop() {
        return this.f18922XI0IXoo;
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public int getCreativeWidth() {
        return this.f18923XIxXXX0x0;
    }

    public f getMRAIDImplementation() {
        return this.f18909IIXOooo;
    }

    public int getOrientation() {
        return this.f18935oo0xXOI0I;
    }

    public com.octopus.ad.internal.view.I0Io getRealDisplayable() {
        AdVideoView adVideoView;
        if (this.f18930o0 && (adVideoView = this.f18932oI0IIXIo) != null) {
            return adVideoView;
        }
        return this;
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public int getRefreshInterval() {
        return this.f18929XxX0x0xxx;
    }

    public int getShowSkipBtnTime() {
        return this.f18920X00IoxXI;
    }

    public boolean getUserInteraction() {
        return this.f18928Xx000oIo;
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public View getView() {
        return this;
    }

    public boolean o0() {
        return this.f18925XOxIOxOx;
    }

    public void oI0IIXIo(String str) {
        if (!this.f18916Oo.getOpensNativeBrowser()) {
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.opening_inapp));
            if (X00IoxXI(str)) {
                return;
            }
            try {
                if (this.f18916Oo.getLoadsInBackground()) {
                    xxIXOIIO xxixoiio = new xxIXOIIO(getContext());
                    xxixoiio.loadUrl(str);
                    xxixoiio.setVisibility(8);
                    this.f18916Oo.addView(xxixoiio);
                    if (this.f18916Oo.getShowLoadingIndicator()) {
                        ProgressDialog progressDialog = new ProgressDialog(getContextFromMutableContext());
                        this.f18934oo = progressDialog;
                        progressDialog.setCancelable(true);
                        this.f18934oo.setOnCancelListener(new I0Io(xxixoiio));
                        this.f18934oo.setMessage(getContext().getResources().getString(R.string.loading));
                        this.f18934oo.setProgressStyle(0);
                        this.f18934oo.show();
                    }
                } else {
                    WebView webView = new WebView(new MutableContextWrapper(getContext()));
                    oxXx0IX.XO(webView);
                    webView.loadUrl(str);
                    xoIox(webView);
                }
                return;
            } catch (Exception e) {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Exception initializing the redirect webview: " + e.getMessage());
                return;
            }
        }
        com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.xxIXOIIO(R.string.opening_native));
        IoOoX(str);
        oxXx0IX();
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public boolean oIX0oI() {
        return this.f18924XO;
    }

    public final void oOXoIIIo() {
        this.f18924XO = true;
    }

    public void oX() {
        Handler handler = this.f18936ooXIXxIX;
        if (handler != null) {
            handler.postDelayed(new oxoX(), 50L);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IIX0o();
    }

    @Override // com.octopus.ad.internal.view.I0Io
    public void onDestroy() {
        destroy();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ProgressDialog progressDialog = this.f18934oo;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f18934oo.dismiss();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.webkit.WebView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.octopus.ad.internal.view.xxIXOIIO xxixoiio = this.f18938oxxXoxO;
        if (xxixoiio != null) {
            return xxixoiio.onTouch(this, motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        Oxx0IOOO(getWindowVisibility(), i);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        Oxx0IOOO(i, getVisibility());
    }

    public boolean oo() {
        if (this.f18942xXxxox0I && this.f18908IIX0o) {
            return true;
        }
        return false;
    }

    public void ooOOo0oXI(String str) {
        new II0xO0(false, str).XO();
    }

    public final void oxXx0IX() {
        AdViewImpl adViewImpl = this.f18916Oo;
        if (adViewImpl != null && (adViewImpl instanceof InterstitialAdViewImpl)) {
            ((InterstitialAdViewImpl) adViewImpl).OO0x0xX();
        }
    }

    public final void oxxXoxO() {
        this.f18940xI = true;
        this.f18936ooXIXxIX.removeCallbacks(this.f18943xo0x);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(0, 0);
    }

    public void setCreativeLeft(int i) {
        this.f18921X0IIOO = i;
    }

    public void setCreativeTop(int i) {
        this.f18922XI0IXoo = i;
    }

    public void setMRAIDUseCustomClose(boolean z) {
        this.f18933oOXoIIIo = z;
    }

    public void setOpt(int i) {
        this.f18937oxXx0IX = i;
    }

    public void setRefreshInterval(int i) {
        this.f18929XxX0x0xxx = i;
    }

    public void xI() {
        if (this.f18919OxxIIOOXO) {
            return;
        }
        this.f18919OxxIIOOXO = true;
        if (this.f18914O0xOxO) {
            this.f18909IIXOooo.xxIXOIIO(this, this.f18913IoOoX);
            xII();
        }
    }

    public final void xII() {
        if (!this.f18908IIX0o) {
            return;
        }
        this.f18940xI = false;
        this.f18936ooXIXxIX.removeCallbacks(this.f18943xo0x);
        this.f18936ooXIXxIX.post(this.f18943xo0x);
    }

    public void xXOx(x0OxxIOxX.oIX0oI oix0oi) {
        int i;
        if (oix0oi == null) {
            return;
        }
        this.f18911IXxxXO = oix0oi;
        setCreativeHeight(oix0oi.xI());
        setCreativeWidth(oix0oi.oxxXoxO());
        setCreativeLeft(oix0oi.oo());
        setCreativeTop(oix0oi.o0());
        setRefreshInterval(oix0oi.x0o());
        if (oix0oi.I0oOIX()) {
            this.f18920X00IoxXI = oix0oi.Xx000oIo();
        } else {
            this.f18920X00IoxXI = -1;
        }
        if (oix0oi.oOXoIIIo() != 0) {
            this.f18910IO = oix0oi.oOXoIIIo();
        } else {
            this.f18910IO = -1;
        }
        if (this.f18920X00IoxXI == -1 && this.f18910IO == -1 && oix0oi.XIxXXX0x0() != e.a.ADP_IVIDEO) {
            this.f18920X00IoxXI = 0;
        } else {
            int i2 = this.f18920X00IoxXI;
            if (i2 != -1 && (i = this.f18910IO) != -1 && i2 > i) {
                this.f18920X00IoxXI = i;
            }
        }
        this.f18939x0o = oix0oi.oX();
        this.f18925XOxIOxOx = oix0oi.xoxXI();
        this.f18915OI0 = oix0oi.XoI0Ixx0();
        this.f18912Io = oix0oi.Xo0();
        this.f18935oo0xXOI0I = oix0oi.XI0IXoo();
        this.f18926XX = oix0oi.IoOoo();
        this.f18941xII = -1;
        boolean IIxOXoOo02 = AdViewImpl.IIxOXoOo0(oix0oi);
        this.f18907I0oOoX = IIxOXoOo02;
        this.f18938oxxXoxO = new com.octopus.ad.internal.view.xxIXOIIO(IIxOXoOo02, new oIX0oI());
        setInitialScale((int) ((xoIox.oIX0oI().IIXOooo() * 100.0f) + 0.5f));
        XX0(0);
    }

    public final String xXxxox0I(String str) {
        if (!x0o.II0XooXoX(str)) {
            return str.replaceFirst("<head>", Matcher.quoteReplacement(new StringBuilder("<head><link rel=\"icon\" href=\"data:;base64,=\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,user-scalable=no\"/>").toString()));
        }
        return str;
    }

    public final void xoIox(WebView webView) {
        Class<AdActivity> oIX0oI2 = AdActivity.oIX0oI();
        Intent intent = new Intent(this.f18916Oo.getContext(), oIX0oI2);
        intent.setFlags(268435456);
        intent.putExtra("ACTIVITY_TYPE", "BROWSER");
        oI.oIX0oI.f31320I0Io.add(webView);
        if (this.f18916Oo.getBrowserStyle() != null) {
            String str = "" + super.hashCode();
            intent.putExtra("bridgeid", str);
            AdViewImpl.oo0xXOI0I.f18881oIX0oI.add(new Pair<>(str, this.f18916Oo.getBrowserStyle()));
        }
        try {
            this.f18916Oo.getContext().startActivity(intent);
            oxXx0IX();
        } catch (ActivityNotFoundException unused) {
            com.octopus.ad.internal.utilities.oIX0oI.oo0xXOI0I(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, com.octopus.ad.internal.utilities.oIX0oI.x0xO0oo(R.string.adactivity_missing, oIX0oI2.getName()));
            oI.oIX0oI.f31320I0Io.remove();
        }
    }

    public void xoXoI(String str) {
        evaluateJavascript(str, null);
    }

    public void xxIXOIIO(Activity activity, boolean z, AdActivity.b bVar) {
        AdActivity.b bVar2 = AdActivity.b.none;
        if (bVar != bVar2) {
            AdActivity.oxoX(activity, bVar);
        }
        if (z) {
            AdActivity.X0o0xo(activity);
        } else if (bVar == bVar2) {
            AdActivity.II0xO0(activity);
        }
    }

    public final String xxX(String str) {
        if (!x0o.II0XooXoX(str)) {
            Resources resources = getResources();
            StringBuilder sb = new StringBuilder("<html><head><script>");
            if (resources != null && x0o.oIX0oI(sb, x0o.f33785II0xO0) && x0o.oIX0oI(sb, x0o.f33786oIX0oI) && x0o.oIX0oI(sb, x0o.f33784I0Io)) {
                sb.append("</script></head>");
                return str.replaceFirst("<html>", Matcher.quoteReplacement(sb.toString()));
            }
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18685II0xO0, "Error reading SDK's raw resources.");
            return str;
        }
        return str;
    }
}
