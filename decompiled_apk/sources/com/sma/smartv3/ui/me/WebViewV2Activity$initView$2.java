package com.sma.smartv3.ui.me;

import android.webkit.WebView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.blankj.utilcode.util.LogUtils;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes11.dex */
public final class WebViewV2Activity$initView$2 extends x0xO.I0Io {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final /* synthetic */ WebViewV2Activity f23474II0xO0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewV2Activity$initView$2(WebViewV2Activity webViewV2Activity, BridgeWebView bridgeWebView) {
        super(bridgeWebView);
        this.f23474II0xO0 = webViewV2Activity;
    }

    public static final void II0xO0(WebViewV2Activity this$0, String str, x0xO.oxoX oxox) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        LogUtils.d("webView shareLog " + str);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(str);
        boolean o00xOoIO2 = StringsKt__StringsKt.o00xOoIO(str, "true", false, 2, null);
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(oxox);
        this$0.shareLog(o00xOoIO2, oxox);
    }

    @Override // x0xO.I0Io, android.webkit.WebViewClient
    public void onPageFinished(@OXOo.oOoXoXO WebView webView, @OXOo.oOoXoXO String str) {
        BridgeWebView webView2;
        super.onPageFinished(webView, str);
        webView2 = this.f23474II0xO0.getWebView();
        final WebViewV2Activity webViewV2Activity = this.f23474II0xO0;
        webView2.oOoXoXO("shareLog", new x0xO.oIX0oI() { // from class: com.sma.smartv3.ui.me.OOxOOxIO
            @Override // x0xO.oIX0oI
            public final void oIX0oI(String str2, x0xO.oxoX oxox) {
                WebViewV2Activity$initView$2.II0xO0(WebViewV2Activity.this, str2, oxox);
            }
        });
        if (this.f23474II0xO0.isUseWebViewTitle() && webView != null) {
            LogUtils.v(" view.title -> =" + webView.getTitle());
            LogUtils.v(" view.url -> =" + str);
            kotlinx.coroutines.xoIox.XO(LifecycleOwnerKt.getLifecycleScope(this.f23474II0xO0), null, null, new WebViewV2Activity$initView$2$onPageFinished$2(this.f23474II0xO0, webView, null), 3, null);
        }
    }

    @Override // x0xO.I0Io, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(@OXOo.OOXIXo WebView view, @OXOo.OOXIXo String url) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        kotlin.jvm.internal.IIX0o.x0xO0oo(url, "url");
        return super.shouldOverrideUrlLoading(view, url);
    }
}
