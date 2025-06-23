package com.tenmeter.smlibrary.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.utils.Utils;
import com.tenmeter.smlibrary.widget.SmWebView;

/* loaded from: classes13.dex */
public class SMWebViewActivity extends Activity {
    private TextView mTitle;
    private String mUrl;
    private SmWebView mWebView;

    /* loaded from: classes13.dex */
    public class webViewClient extends WebViewClient {
        public webViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private void initData() {
    }

    private void initView() {
        SmWebView smWebView = (SmWebView) findViewById(R.id.swv);
        this.mWebView = smWebView;
        smWebView.requestFocus(130);
        this.mWebView.setWebViewClient(new webViewClient());
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(2);
        settings.setDomStorageEnabled(true);
        settings.setGeolocationEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setBlockNetworkImage(false);
        settings.setSavePassword(true);
        settings.setSupportZoom(true);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSupportMultipleWindows(true);
        this.mWebView.addJavascriptInterface(this, "wjsb");
        int i = Build.VERSION.SDK_INT;
        if (i > 21) {
            this.mWebView.getSettings().setMixedContentMode(0);
        }
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.tenmeter.smlibrary.activity.SMWebViewActivity.1
            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                FrameLayout frameLayout = new FrameLayout(SMWebViewActivity.this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                return frameLayout;
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                callback.invoke(str, true, false);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
            }
        });
        if (i > 21) {
            this.mWebView.getSettings().setMixedContentMode(0);
        }
        this.mWebView.getSettings().setBlockNetworkImage(false);
        if (SMGameClient.getInstance().getUserInfo() != null) {
            this.mWebView.loadUrl(this.mUrl + "?userid=" + SMGameClient.getInstance().getUserInfo().getUid() + "&token=" + SMGameClient.getInstance().getUserInfo().getUserToken());
            return;
        }
        this.mWebView.loadUrl(this.mUrl);
    }

    private void registerListener() {
    }

    @JavascriptInterface
    public void jsCloseGame() {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            Utils.relaunchApp(this, true);
        }
        if (getIntent().getExtras().getString("url") != null) {
            this.mUrl = getIntent().getExtras().getString("url");
        } else {
            Toast.makeText(this, "game不能为null", 1).show();
            finish();
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_sm_webview);
        Utils.setDarkStatusWhite(this, true);
        initView();
        registerListener();
        initData();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
