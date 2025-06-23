package com.sma.smartv3.ui.me;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.biz.OrderManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.permission.PermissionHelper;

/* loaded from: classes11.dex */
public class WebViewActivity extends BaseActivity {
    private boolean isAllowDirectBack;
    private boolean isUseWebViewTitle;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO webView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<WebView>() { // from class: com.sma.smartv3.ui.me.WebViewActivity$webView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final WebView invoke() {
            return (WebView) WebViewActivity.this.findViewById(R.id.webView);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO titleCenter$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.WebViewActivity$titleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) WebViewActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private String orderType = "";

    @Keep
    /* loaded from: classes11.dex */
    public static final class payStatusData {

        @OXOo.OOXIXo
        private final String result;

        /* JADX WARN: Multi-variable type inference failed */
        public payStatusData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ payStatusData copy$default(payStatusData paystatusdata, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paystatusdata.result;
            }
            return paystatusdata.copy(str);
        }

        @OXOo.OOXIXo
        public final String component1() {
            return this.result;
        }

        @OXOo.OOXIXo
        public final payStatusData copy(@OXOo.OOXIXo String result) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
            return new payStatusData(result);
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof payStatusData) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.result, ((payStatusData) obj).result);
        }

        @OXOo.OOXIXo
        public final String getResult() {
            return this.result;
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        @OXOo.OOXIXo
        public String toString() {
            return "payStatusData(result=" + this.result + HexStringBuilder.COMMENT_END_CHAR;
        }

        public payStatusData(@OXOo.OOXIXo String result) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(result, "result");
            this.result = result;
        }

        public /* synthetic */ payStatusData(String str, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
            this((i & 1) != 0 ? "" : str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reviseWebViewTitle$lambda$2(WebViewActivity this$0, String title) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(title, "$title");
        this$0.getTitleCenter().setText(title);
    }

    @OXOo.OOXIXo
    public final String getOrderType() {
        return this.orderType;
    }

    public final TextView getTitleCenter() {
        return (TextView) this.titleCenter$delegate.getValue();
    }

    public final WebView getWebView() {
        return (WebView) this.webView$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void initView() {
        int mArg1 = getMArg1();
        if (mArg1 != -1) {
            if (mArg1 != 0) {
                if (mArg1 != 1) {
                    if (mArg1 != 3) {
                        this.isUseWebViewTitle = true;
                    } else {
                        getTitleCenter().setText(R.string.guide_chain_breakage);
                    }
                } else {
                    getTitleCenter().setText(R.string.user_agreement);
                }
            } else {
                getTitleCenter().setText(R.string.help_guide);
            }
        } else {
            getTitleCenter().setText(R.string.privacy_policy);
        }
        WebSettings settings = getWebView().getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        if (getMArg1() != 2) {
            settings.setUserAgentString("Chrome Mobile");
        }
        settings.setCacheMode(2);
        getWebView().setWebViewClient(new WebViewClient() { // from class: com.sma.smartv3.ui.me.WebViewActivity$initView$2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(@OXOo.oOoXoXO WebView webView, @OXOo.oOoXoXO String str) {
                super.onPageFinished(webView, str);
                if (WebViewActivity.this.isUseWebViewTitle() && webView != null) {
                    LogUtils.v(" view.title -> =" + webView.getTitle());
                    LogUtils.v(" view.url -> =" + str);
                    kotlinx.coroutines.xoIox.XO(LifecycleOwnerKt.getLifecycleScope(WebViewActivity.this), null, null, new WebViewActivity$initView$2$onPageFinished$1(WebViewActivity.this, webView, null), 3, null);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(@OXOo.OOXIXo WebView view, @OXOo.OOXIXo String url) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
                kotlin.jvm.internal.IIX0o.x0xO0oo(url, "url");
                LogUtils.v("shouldOverrideUrlLoading -> url=" + url);
                if (!kotlin.text.OxI.IOOoXo0Ix(url, "wexin://", false, 2, null) && !kotlin.text.OxI.IOOoXo0Ix(url, "alipays://", false, 2, null) && !kotlin.text.OxI.IOOoXo0Ix(url, "mqqapi://", false, 2, null)) {
                    if (!kotlin.text.OxI.IOOoXo0Ix(url, "https://www.codingiot.net/cofit/?code=", false, 2, null) && !kotlin.text.OxI.IOOoXo0Ix(url, "https://www.codingiot.net/smarttimepro/?code=", false, 2, null)) {
                        if (kotlin.text.OxI.IOOoXo0Ix(url, "https://api.whatsapp.com", false, 2, null)) {
                            WebViewActivity webViewActivity = WebViewActivity.this;
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(Uri.parse(url));
                            webViewActivity.startActivity(intent);
                            return true;
                        }
                        return super.shouldOverrideUrlLoading(view, url);
                    }
                    WebViewActivity webViewActivity2 = WebViewActivity.this;
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(kotlin.text.OxI.IIOIX(url, "https", "apphttps", false, 4, null)));
                    webViewActivity2.startActivity(intent2);
                    WebViewActivity.this.finish();
                    return true;
                }
                try {
                    WebViewActivity webViewActivity3 = WebViewActivity.this;
                    Intent intent3 = new Intent();
                    intent3.setAction("android.intent.action.VIEW");
                    intent3.setData(Uri.parse(url));
                    webViewActivity3.startActivity(intent3);
                } catch (Exception unused) {
                    ToastUtils.showLong(WebViewActivity.this.getString(R.string.pay_error_tip), new Object[0]);
                }
                return true;
            }
        });
        String mArg0 = getMArg0();
        if (mArg0 != null) {
            LogUtils.d("webView url " + mArg0);
            if (kotlin.text.OxI.IOOoXo0Ix(mArg0, "http://openapi.baidu.com/oauth/2.0/authorize", false, 2, null)) {
                getWebView().clearCache(true);
                getWebView().clearHistory();
                CookieManager.getInstance().removeAllCookies(null);
                CookieManager.getInstance().flush();
            }
            getWebView().loadUrl(mArg0);
            try {
                Uri parse = Uri.parse(kotlin.text.OxI.IIOIX(mArg0, OoOoXO0.xoXoI.f2669XO, "", false, 4, null));
                String queryParameter = parse.getQueryParameter("orderType");
                if (queryParameter == null) {
                    queryParameter = "";
                } else {
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(queryParameter);
                }
                this.orderType = queryParameter;
                String queryParameter2 = parse.getQueryParameter("identity");
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("webView orderType = " + this.orderType + " , pid = " + queryParameter2);
            } catch (Exception e) {
                OI0.oIX0oI.f1507oIX0oI.oIX0oI("webView orderType = " + this.orderType + " , e = " + e);
            }
        }
        getWebView().addJavascriptInterface(this, "android");
    }

    public final boolean isAllowDirectBack() {
        return this.isAllowDirectBack;
    }

    public final boolean isUseWebViewTitle() {
        return this.isUseWebViewTitle;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_main_webview;
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getWebView().destroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @OXOo.oOoXoXO KeyEvent keyEvent) {
        if (getWebView().canGoBack() && i == 4 && !this.isAllowDirectBack) {
            getWebView().goBack();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (getWebView().canGoBack() && !this.isAllowDirectBack) {
            getWebView().goBack();
        } else {
            finish();
        }
    }

    @JavascriptInterface
    public final void payStatusCallBackFall() {
        LogUtils.d("webView payStatusCallBackFall");
        if (!OrderManager.f20130oIX0oI.ooXIXxIX()) {
            finish();
        }
    }

    @JavascriptInterface
    public final void payStatusCallBackSuccess() {
        LogUtils.d("webView payStatusCallBackSuccess");
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.x0xO0oo.f24583O0, null, 2, null);
        if (!OrderManager.f20130oIX0oI.ooXIXxIX()) {
            finish();
        }
    }

    @JavascriptInterface
    public final void prizeInfoSubmit() {
        LogUtils.d("webView prizeInfoSubmit ");
        finish();
    }

    @JavascriptInterface
    public final void returnAllowDirectBack() {
        this.isAllowDirectBack = true;
    }

    @JavascriptInterface
    public final void reviseWebViewTitle(@OXOo.OOXIXo final String title) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(title, "title");
        LogUtils.d("webView reviseWebViewTitle webView.title = " + title);
        runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.me.oXoXxOo
            @Override // java.lang.Runnable
            public final void run() {
                WebViewActivity.reviseWebViewTitle$lambda$2(WebViewActivity.this, title);
            }
        });
    }

    public final void setAllowDirectBack(boolean z) {
        this.isAllowDirectBack = z;
    }

    public final void setOrderType(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.orderType = str;
    }

    public final void setUseWebViewTitle(boolean z) {
        this.isUseWebViewTitle = z;
    }

    @JavascriptInterface
    public final void toPermissionsSettings() {
        LogUtils.d("webView toPermissionsSettings");
        PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
        Application app = Utils.getApp();
        kotlin.jvm.internal.IIX0o.oO(app, "getApp(...)");
        permissionHelper.XIxXXX0x0(app);
    }

    @JavascriptInterface
    public final void toSettings() {
        LogUtils.d("webView toSettings");
        startActivity(new Intent("android.settings.SETTINGS"));
    }
}
