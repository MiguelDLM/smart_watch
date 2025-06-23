package com.bestmafen.androidbase;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSimpleWebViewActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleWebViewActivity.kt\ncom/bestmafen/androidbase/SimpleWebViewActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1#2:53\n*E\n"})
/* loaded from: classes8.dex */
public final class SimpleWebViewActivity extends BaseActivity {

    @OOXIXo
    private final X0IIOO webView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WebView>() { // from class: com.bestmafen.androidbase.SimpleWebViewActivity$webView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WebView invoke() {
            return (WebView) SimpleWebViewActivity.this.findViewById(R.id.webView);
        }
    });

    /* loaded from: classes8.dex */
    public static final class oIX0oI extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@OOXIXo WebView view, @OOXIXo String url) {
            IIX0o.x0xO0oo(view, "view");
            IIX0o.x0xO0oo(url, "url");
            LogUtils.v("shouldOverrideUrlLoading -> url=" + url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    private final WebView getWebView() {
        return (WebView) this.webView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        WebSettings settings = getWebView().getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setUserAgentString("Chrome Mobile");
        getWebView().setWebViewClient(new oIX0oI());
        String mArg0 = getMArg0();
        if (mArg0 != null) {
            getWebView().loadUrl(mArg0);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_simple_webview;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getWebView().destroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @oOoXoXO KeyEvent keyEvent) {
        if (getWebView().canGoBack() && i == 4) {
            getWebView().goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
