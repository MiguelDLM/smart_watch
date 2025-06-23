package com.sma.smartv3.ui.fitness_site;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import com.sma.smartv3.biz.fitness_site.fitbit.FitbitManager;
import com.sma.smartv3.co_fit.R;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes12.dex */
public final class FitbitAuthActivity extends BaseActivity {

    @OOXIXo
    private final X0IIOO wevView$delegate = XIxXXX0x0.oIX0oI(new oIX0oI<WebView>() { // from class: com.sma.smartv3.ui.fitness_site.FitbitAuthActivity$wevView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WebView invoke() {
            return (WebView) FitbitAuthActivity.this.findViewById(R.id.webView);
        }
    });

    @OOXIXo
    private String verifier = "";

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
        settings.setUserAgentString("Chrome Mobile");
        getWevView().setWebViewClient(new WebViewClient() { // from class: com.sma.smartv3.ui.fitness_site.FitbitAuthActivity$initView$2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(@OOXIXo WebView view, @OOXIXo String url) {
                Activity mContext;
                String str;
                IIX0o.x0xO0oo(view, "view");
                IIX0o.x0xO0oo(url, "url");
                LogUtils.v("shouldOverrideUrlLoading -> url=" + url);
                if (OxI.IOOoXo0Ix(url, "argomtechselect", false, 2, null) && StringsKt__StringsKt.o00xOoIO(url, "code", false, 2, null)) {
                    LogUtils.d("authorize OK");
                    String substring = url.substring(StringsKt__StringsKt.O0O0Io00X(url, "code=", 0, false, 6, null));
                    IIX0o.oO(substring, "substring(...)");
                    String str2 = (String) StringsKt__StringsKt.Xxx0oXX((CharSequence) StringsKt__StringsKt.Xxx0oXX(substring, new char[]{kotlin.text.XIxXXX0x0.f29558oxoX}, false, 0, 6, null).get(0), new char[]{'='}, false, 0, 6, null).get(1);
                    FitbitManager fitbitManager = FitbitManager.INSTANCE;
                    mContext = FitbitAuthActivity.this.getMContext();
                    str = FitbitAuthActivity.this.verifier;
                    final FitbitAuthActivity fitbitAuthActivity = FitbitAuthActivity.this;
                    fitbitManager.getToken(mContext, str2, str, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.fitness_site.FitbitAuthActivity$initView$2$shouldOverrideUrlLoading$1
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
                                FitbitAuthActivity.this.setResult(-1);
                            }
                            FitbitAuthActivity.this.finish();
                        }
                    });
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
    @RequiresApi(26)
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 11);
        IIX0o.oO(encodeToString, "encodeToString(...)");
        this.verifier = encodeToString;
        Charset forName = Charset.forName("US-ASCII");
        IIX0o.oO(forName, "forName(...)");
        byte[] bytes = encodeToString.getBytes(forName);
        IIX0o.oO(bytes, "getBytes(...)");
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        messageDigest.update(bytes, 0, bytes.length);
        String encodeToString2 = Base64.encodeToString(messageDigest.digest(), 11);
        IIX0o.oO(encodeToString2, "encodeToString(...)");
        ((WebView) findViewById(R.id.webView)).loadUrl("https://www.fitbit.com/oauth2/authorize?client_id=" + getString(R.string.fitbit_client_id) + "&code_challenge=" + encodeToString2 + "&code_challenge_method=S256&response_type=code&scope=activity%20heartrate%20location%20nutrition%20oxygen_saturation%20profile%20respiratory_rate%20settings%20sleep%20social%20temperature%20weight");
    }
}
