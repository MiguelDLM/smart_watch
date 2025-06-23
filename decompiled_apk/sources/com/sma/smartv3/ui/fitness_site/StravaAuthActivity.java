package com.sma.smartv3.ui.fitness_site;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.biz.fitness_site.strava.StravaManager;
import com.sma.smartv3.co_fit.R;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes12.dex */
public final class StravaAuthActivity extends BaseActivity {

    @OOXIXo
    private final X0IIOO wevView$delegate = XIxXXX0x0.oIX0oI(new oIX0oI<WebView>() { // from class: com.sma.smartv3.ui.fitness_site.StravaAuthActivity$wevView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WebView invoke() {
            return (WebView) StravaAuthActivity.this.findViewById(R.id.webView);
        }
    });

    private final WebView getWevView() {
        return (WebView) this.wevView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        WebSettings settings = getWevView().getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        getWevView().setWebViewClient(new WebViewClient() { // from class: com.sma.smartv3.ui.fitness_site.StravaAuthActivity$initView$2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(@OOXIXo WebView view, @OOXIXo String url) {
                Activity mContext;
                IIX0o.x0xO0oo(view, "view");
                IIX0o.x0xO0oo(url, "url");
                LogUtils.v("shouldOverrideUrlLoading -> url=" + url);
                if (OxI.IOOoXo0Ix(url, StravaManager.URL_CALLBACK, false, 2, null)) {
                    if (StringsKt__StringsKt.o00xOoIO(url, "code", false, 2, null) && StringsKt__StringsKt.o00xOoIO(url, "activity:write", false, 2, null)) {
                        LogUtils.d("authorize OK");
                        String substring = url.substring(StringsKt__StringsKt.O0O0Io00X(url, "code=", 0, false, 6, null));
                        IIX0o.oO(substring, "substring(...)");
                        String str = (String) StringsKt__StringsKt.Xxx0oXX((CharSequence) StringsKt__StringsKt.Xxx0oXX(substring, new char[]{kotlin.text.XIxXXX0x0.f29558oxoX}, false, 0, 6, null).get(0), new char[]{'='}, false, 0, 6, null).get(1);
                        StravaManager stravaManager = StravaManager.INSTANCE;
                        mContext = StravaAuthActivity.this.getMContext();
                        final StravaAuthActivity stravaAuthActivity = StravaAuthActivity.this;
                        stravaManager.getToken(mContext, str, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.fitness_site.StravaAuthActivity$initView$2$shouldOverrideUrlLoading$1
                            {
                                super(1);
                            }

                            @Override // Oox.oOoXoXO
                            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return oXIO0o0XI.f29392oIX0oI;
                            }

                            public final void invoke(boolean z) {
                                if (z) {
                                    StravaAuthActivity.this.setResult(-1);
                                }
                                StravaAuthActivity.this.finish();
                            }
                        });
                    } else {
                        StravaAuthActivity.this.finish();
                    }
                } else {
                    view.loadUrl(url);
                }
                return true;
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_webview;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((WebView) findViewById(R.id.webView)).loadUrl("https://www.strava.com/oauth/mobile/authorize?client_id=" + getString(R.string.strava_client_id) + "&redirect_uri=http://localhost/auth/callback&response_type=code&scope=activity:write");
    }
}
