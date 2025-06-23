package com.alimm.tanx.core.ad.browser;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.alimm.tanx.core.ad.interaction.tanxc_if;
import com.alimm.tanx.core.bridge.JsBridgeBean;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.TanxJsBridge;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.LogUtils;

public class TanxBrowserContainer extends FrameLayout implements DownloadListener {
    protected TanxJsBridge tanxc_byte;
    /* access modifiers changed from: private */
    public ProgressBar tanxc_case;
    private boolean tanxc_char;
    protected Context tanxc_do;
    /* access modifiers changed from: private */
    public IAdWebViewCallback tanxc_else;
    protected String tanxc_for;
    protected WebView tanxc_if;
    protected ViewGroup tanxc_int;
    protected long tanxc_new;
    protected boolean tanxc_try;

    public TanxBrowserContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    private void tanxc_case() {
        WebSettings settings = this.tanxc_if.getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e) {
            LogUtils.e("AdSystemWebViewContainer", "initWebView: failed with exception.", (Throwable) e);
            int intCode = UtErrorCode.CRASH_ERROR.getIntCode();
            TanxBaseUt.utError(intCode, "AdSystemWebViewContainer", "initWebView: failed with exception." + LogUtils.getStackTraceMessage(e), "");
        }
        String userAgentString = settings.getUserAgentString();
        settings.setUserAgentString(userAgentString + AndroidUtils.getUserAgentSuffix() + AndroidUtils.mediaNameStr());
        StringBuilder sb = new StringBuilder();
        sb.append("initWebSettings: userAgent = ");
        sb.append(settings.getUserAgentString());
        LogUtils.d("AdSystemWebViewContainer", sb.toString());
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(false);
        settings.setNeedInitialFocus(true);
        settings.setMixedContentMode(0);
        this.tanxc_if.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                LogUtils.d("AdSystemWebViewContainer", "onPageFinished: time = " + (System.currentTimeMillis() - TanxBrowserContainer.this.tanxc_new) + "; url = " + str);
                if (TanxBrowserContainer.this.tanxc_case != null) {
                    TanxBrowserContainer.this.tanxc_case.setVisibility(8);
                }
                TanxBrowserContainer.this.tanxc_byte.injectJavascript();
                TanxBrowserContainer.this.tanxc_byte.ready();
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                LogUtils.d("AdSystemWebViewContainer", "onPageStarted: url = " + str);
                if (TanxBrowserContainer.this.tanxc_case != null) {
                    TanxBrowserContainer.this.tanxc_case.setVisibility(0);
                }
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                LogUtils.d("AdSystemWebViewContainer", "onReceivedError: errorCode = " + i + ", url = " + str2 + ", description = " + str);
                TanxBrowserContainer.this.tanxc_char();
            }

            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    LogUtils.d("AdSystemWebViewContainer", "onReceivedHttpError: code = " + webResourceResponse.getStatusCode());
                    TanxBrowserContainer tanxBrowserContainer = TanxBrowserContainer.this;
                    webResourceResponse.getStatusCode();
                    tanxBrowserContainer.tanxc_char();
                }
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                LogUtils.d("AdSystemWebViewContainer", "onReceivedSslError: handler = " + sslErrorHandler + ", error = " + sslError);
                sslErrorHandler.proceed();
            }

            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                return super.shouldInterceptRequest(webView, str);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView.getHitTestResult() != null) {
                    tanxc_if.tanxc_do(webView.getHitTestResult().getType(), TanxBrowserContainer.this.tanxc_new);
                }
                if (tanxc_if.tanxc_do(webView.getContext(), str) || super.shouldOverrideUrlLoading(webView, str)) {
                    return true;
                }
                return false;
            }
        });
        this.tanxc_if.setWebChromeClient(new WebChromeClient() {
            public void onHideCustomView() {
                TanxBrowserContainer.this.tanxc_else();
            }

            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                LogUtils.d("AdSystemWebViewContainer", "onProgressChanged: newProgress = " + i);
                if (TanxBrowserContainer.this.tanxc_case != null) {
                    TanxBrowserContainer.this.tanxc_case.setProgress(i);
                    if (i == 100) {
                        TanxBrowserContainer.this.tanxc_case.setVisibility(8);
                    }
                }
            }

            public void onReceivedTitle(WebView webView, String str) {
                TanxBrowserContainer.this.tanxc_else.onTitleLoaded(str);
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                TanxBrowserContainer.this.tanxc_do(view, customViewCallback);
            }
        });
        this.tanxc_if.setDownloadListener(this);
    }

    /* access modifiers changed from: private */
    public void tanxc_char() {
        ProgressBar progressBar = this.tanxc_case;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (!this.tanxc_char) {
            this.tanxc_char = true;
        }
    }

    /* access modifiers changed from: private */
    public void tanxc_else() {
        LogUtils.d("AdSystemWebViewContainer", "showCustomView: mDefaultWebView = " + this.tanxc_if + ", mPlayerContainer = " + this.tanxc_int);
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.setVisibility(0);
        }
        ViewGroup viewGroup = this.tanxc_int;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.tanxc_int.setVisibility(8);
        }
        IAdWebViewCallback iAdWebViewCallback = this.tanxc_else;
        if (iAdWebViewCallback != null) {
            iAdWebViewCallback.onHideCustomView();
        }
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        LogUtils.d("AdSystemWebViewContainer", "onDownloadStart: url = " + str + ", mimeType = " + str4 + ", contentLength = " + j);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        this.tanxc_do.startActivity(intent);
    }

    public boolean tanxc_byte() {
        ViewGroup viewGroup = this.tanxc_int;
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            WebView webView = this.tanxc_if;
            if (webView == null || !webView.canGoBack()) {
                return false;
            }
            this.tanxc_if.goBack();
            return true;
        }
        tanxc_else();
        return true;
    }

    public void tanxc_new() {
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void tanxc_try() {
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.removeAllViews();
            this.tanxc_if = null;
        }
    }

    public TanxBrowserContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void tanxc_for() {
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.reload();
        }
    }

    public String tanxc_if() {
        WebView webView = this.tanxc_if;
        if (webView != null) {
            return webView.getUrl();
        }
        return "";
    }

    public void tanxc_int() {
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.onPause();
        }
    }

    public TanxBrowserContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tanxc_try = false;
        this.tanxc_char = false;
        try {
            this.tanxc_do = context;
            LogUtils.d("AdSystemWebViewContainer", "AdClickWebViewContainer: mContext = " + this.tanxc_do);
            tanxc_do(this.tanxc_do);
        } catch (Exception e) {
            LogUtils.e("AdSystemWebViewContainer", e);
        }
    }

    public boolean tanxc_do(String str, JsBridgeBean jsBridgeBean, JsBridgeUtil.BaseWebInterface baseWebInterface, JsBridgeUtil.AdInterface adInterface) {
        if (TextUtils.isEmpty(str) || this.tanxc_if == null) {
            LogUtils.d("AdSystemWebViewContainer", "loadUrl: skip because url is empty.");
            return false;
        }
        tanxc_do(jsBridgeBean, baseWebInterface, adInterface);
        this.tanxc_new = System.currentTimeMillis();
        this.tanxc_for = str;
        LogUtils.d("AdSystemWebViewContainer", "loadUrl  mUrl == " + this.tanxc_for);
        this.tanxc_if.loadUrl(str);
        return true;
    }

    @TargetApi(21)
    public TanxBrowserContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.tanxc_try = false;
        this.tanxc_char = false;
        try {
            this.tanxc_do = context;
            LogUtils.d("AdSystemWebViewContainer", "AdClickWebViewContainer: mContext = " + this.tanxc_do);
            tanxc_do(this.tanxc_do);
        } catch (Exception e) {
            LogUtils.e("AdSystemWebViewContainer", e);
        }
    }

    public void tanxc_do(JsBridgeBean jsBridgeBean, JsBridgeUtil.BaseWebInterface baseWebInterface, JsBridgeUtil.AdInterface adInterface) {
        JsBridgeUtil jsBridgeUtil = new JsBridgeUtil();
        jsBridgeUtil.initJsBridge(this.tanxc_byte, jsBridgeBean, baseWebInterface, adInterface);
        jsBridgeUtil.setShowWebBar(this.tanxc_byte, false);
    }

    public boolean tanxc_do() {
        return this.tanxc_try;
    }

    public void tanxc_do(ProgressBar progressBar) {
        this.tanxc_case = progressBar;
    }

    public void tanxc_do(IAdWebViewCallback iAdWebViewCallback) {
        this.tanxc_else = iAdWebViewCallback;
    }

    private void tanxc_do(Context context) {
        try {
            WebView webView = new WebView(context);
            this.tanxc_if = webView;
            this.tanxc_byte = new TanxJsBridge(webView.getContext(), this.tanxc_if);
            this.tanxc_if.setBackgroundColor(0);
            this.tanxc_try = true;
            addView(this.tanxc_if, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout = new FrameLayout(context);
            this.tanxc_int = frameLayout;
            frameLayout.setVisibility(8);
            addView(this.tanxc_int, -1, -1);
            tanxc_case();
        } catch (Throwable th) {
            LogUtils.e("AdSystemWebViewContainer", "Create new Webview exception.", th);
            int intCode = UtErrorCode.CRASH_ERROR.getIntCode();
            TanxBaseUt.utError(intCode, "AdSystemWebViewContainer", "Create new Webview exception." + LogUtils.getStackTraceMessage(th), "");
            this.tanxc_if = null;
        }
    }

    /* access modifiers changed from: private */
    public void tanxc_do(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        LogUtils.d("AdSystemWebViewContainer", "showCustomView: view = " + view + ", callback = " + customViewCallback + ", mPlayerContainer = " + this.tanxc_int);
        WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.setVisibility(8);
        }
        if (this.tanxc_int != null) {
            if (!(view == null || view.getParent() == null)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.tanxc_int.setVisibility(0);
            this.tanxc_int.addView(view);
        }
        IAdWebViewCallback iAdWebViewCallback = this.tanxc_else;
        if (iAdWebViewCallback != null) {
            iAdWebViewCallback.onShowCustomView(view);
        }
    }
}
