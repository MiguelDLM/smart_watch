package com.alimm.tanx.core.ad.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.bridge.JsBridgeBean;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.TanxJsBridge;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.SharedPreferencesHelper;
import com.alimm.tanx.core.utils.SysUtils;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.alimm.tanx.core.web.WebCacheManager;
import com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst;
import com.alimm.tanx.core.web.webview.AdWebViewManager;
import com.alimm.tanx.core.web.webview.OnScrollChangedCallback;
import com.alimm.tanx.core.web.webview.TanxAdWebView;
import org.apache.log4j.spi.LocationInfo;

public abstract class tanxc_if {
    /* access modifiers changed from: private */
    public JsBridgeUtil.BaseWebInterface tanxc_byte;
    private JsBridgeUtil.AdInterface tanxc_case;
    private TanxCountDownTimer tanxc_char;
    private AdWebViewManager tanxc_do;
    private int tanxc_else = 0;
    private LinearLayout tanxc_for;
    /* access modifiers changed from: private */
    public volatile boolean tanxc_goto = false;
    /* access modifiers changed from: private */
    public TanxAdWebView tanxc_if;
    private BidInfo tanxc_int;
    /* access modifiers changed from: private */
    public boolean tanxc_long = false;
    protected TanxJsBridge tanxc_new;
    private JsBridgeUtil tanxc_this;
    private TanxAdSlot tanxc_try;
    private volatile boolean tanxc_void = false;

    /* access modifiers changed from: private */
    public void tanxc_byte() {
        try {
            LogUtils.d("BaseWebViewUtil", "cancelTimerDog  loadingError :" + this.tanxc_long + " startTimerSwitch:" + this.tanxc_goto);
            TanxCountDownTimer tanxCountDownTimer = this.tanxc_char;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.tanxc_char = null;
            }
            this.tanxc_goto = false;
        } catch (Exception e) {
            LogUtils.e("timerCancel", e);
        }
    }

    private boolean tanxc_case() {
        BidInfo bidInfo = this.tanxc_int;
        if (bidInfo == null || bidInfo.getTemplateConf() == null || this.tanxc_int.getTemplateConf().getWebStartTime2Long() == null || this.tanxc_int.getTemplateConf().getWebEndTime2Long() == null) {
            return true;
        }
        if (this.tanxc_int.getTemplateConf().getWebStartTime2Long().longValue() > System.currentTimeMillis() || this.tanxc_int.getTemplateConf().getWebEndTime2Long().longValue() < System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ int tanxc_new(tanxc_if tanxc_if2) {
        int i = tanxc_if2.tanxc_else;
        tanxc_if2.tanxc_else = i + 1;
        return i;
    }

    private void tanxc_try() {
        LogUtils.d("BaseWebViewUtil", "startTimerDog - startSwitch:" + this.tanxc_goto);
        try {
            if (!this.tanxc_goto) {
                BaseWebViewUtil$4 baseWebViewUtil$4 = new BaseWebViewUtil$4(this, 5000, 1000);
                this.tanxc_char = baseWebViewUtil$4;
                if (this.tanxc_else <= 5) {
                    baseWebViewUtil$4.start();
                    this.tanxc_goto = true;
                    return;
                }
                LogUtils.d("BaseWebViewUtil", "startTimer不在启动：nowTryLoadCount:" + this.tanxc_else);
            }
        } catch (Exception e) {
            LogUtils.e("BaseWebViewUtil", "startTimer", (Throwable) e);
        }
    }

    public abstract boolean tanxc_do();

    private void tanxc_for(final WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(webView.getSettings().getUserAgentString() + AndroidUtils.getUserAgentSuffix());
        webView.setOverScrollMode(2);
        webView.setWebChromeClient(new WebChromeClient() {
            @Nullable
            public Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return super.onJsAlert(webView, str, str2, jsResult);
            }

            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                LogUtils.d("BaseWebViewUtil", "onProgressChanged:" + i);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            public void onLoadResource(WebView webView, String str) {
                LogUtils.d("BaseWebViewUtil", "onLoadResource");
                super.onLoadResource(webView, str);
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                LogUtils.d("BaseWebViewUtil", "onPageFinished");
                if (tanxc_if.this.tanxc_byte != null) {
                    tanxc_if.this.tanxc_byte.webDrawStatus(!tanxc_if.this.tanxc_long);
                }
                if (!tanxc_if.this.tanxc_long) {
                    tanxc_if.this.tanxc_byte();
                    tanxc_if.this.tanxc_if.setVisibility(0);
                }
                tanxc_if.this.tanxc_new.injectJavascript();
                tanxc_if.this.tanxc_new.ready();
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                LogUtils.d("BaseWebViewUtil", "onPageStarted");
            }

            @RequiresApi(api = 23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                LogUtils.d("BaseWebViewUtil", "onReceivedError:" + webResourceError.getErrorCode());
                tanxc_if.this.tanxc_do(webView, webResourceRequest, webResourceError.getErrorCode(), webResourceError.getDescription().toString());
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                tanxc_if.this.tanxc_do(webView, webResourceRequest, webResourceResponse.getStatusCode(), "");
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                LogUtils.d("BaseWebViewUtil", "onReceivedHttpError:" + webResourceResponse.getStatusCode());
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (SharedPreferencesHelper.getInstance().getHttpsBoolean()) {
                    sslErrorHandler.proceed();
                    return;
                }
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                sslErrorHandler.cancel();
            }

            @TargetApi(21)
            @Nullable
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                LogUtils.d("BaseWebViewUtil", "shouldInterceptRequest");
                return WebViewCacheInterceptorInst.getInstance().interceptRequest(webResourceRequest);
            }

            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                LogUtils.d("BaseWebViewUtil", "shouldOverrideUrlLoading");
                WebViewCacheInterceptorInst.getInstance().loadUrl(webView, webResourceRequest.getUrl().toString());
                return true;
            }

            @Nullable
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                LogUtils.d("BaseWebViewUtil", "shouldInterceptRequest2");
                return WebViewCacheInterceptorInst.getInstance().interceptRequest(str);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                LogUtils.d("BaseWebViewUtil", "shouldOverrideUrlLoading2");
                WebViewCacheInterceptorInst.getInstance().loadUrl(webView, str);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012e, code lost:
        r3 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012f, code lost:
        switch(r3) {
            case 0: goto L_0x0150;
            case 1: goto L_0x0149;
            case 2: goto L_0x0149;
            case 3: goto L_0x0149;
            case 4: goto L_0x0149;
            case 5: goto L_0x013e;
            case 6: goto L_0x0133;
            case 7: goto L_0x0133;
            default: goto L_0x0132;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0133, code lost:
        r2 = r7.tanxc_int.getTemplateConf().getWebUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013e, code lost:
        r2 = r7.tanxc_int.getTemplateConf().getRenderUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0149, code lost:
        r2 = r7.tanxc_int.getClickThroughUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0150, code lost:
        r2 = r2 + "?pidStyleId=" + r7.tanxc_int.getTemplateConf().getPidStyleId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tanxc_new() {
        /*
            r7 = this;
            java.lang.String r0 = "BaseWebViewUtil"
            java.lang.String r1 = "load"
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0019 }
            r1 = 0
            r7.tanxc_long = r1     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.webview.TanxAdWebView r2 = r7.tanxc_if     // Catch:{ Exception -> 0x0019 }
            boolean r2 = tanxc_if((android.webkit.WebView) r2)     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x001c
            java.lang.String r1 = "webView已经回收，无法load，终止！！！！"
            com.alimm.tanx.core.utils.LogUtils.e((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0019 }
            return
        L_0x0019:
            r1 = move-exception
            goto L_0x01ff
        L_0x001c:
            com.alimm.tanx.core.utils.SharedPreferencesHelper r2 = com.alimm.tanx.core.utils.SharedPreferencesHelper.getInstance()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = "RewardUrl"
            java.lang.String r2 = r2.getString(r3)     // Catch:{ Exception -> 0x0019 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0019 }
            r4 = -1
            r5 = 1
            if (r3 != 0) goto L_0x00a8
            com.alimm.tanx.core.config.TanxConfig r3 = com.alimm.tanx.core.TanxCoreSdk.getConfig()     // Catch:{ Exception -> 0x0019 }
            boolean r3 = r3.isDebugMode()     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x00a8
            boolean r3 = com.alimm.tanx.core.utils.SysUtils.isValidUrl(r2)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x00a0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0019 }
            r1.<init>()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = "load testUrl:"
            r1.append(r3)     // Catch:{ Exception -> 0x0019 }
            r1.append(r2)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0019 }
            r7.tanxc_try()     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst r1 = com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance()     // Catch:{ Exception -> 0x0019 }
            r1.enableForce(r5)     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst r1 = com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance()     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.webview.TanxAdWebView r3 = r7.tanxc_if     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = r7.tanxc_do((java.lang.String) r2)     // Catch:{ Exception -> 0x0019 }
            r1.loadUrl((android.webkit.WebView) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.webview.TanxAdWebView r1 = r7.tanxc_if     // Catch:{ Exception -> 0x0019 }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x0019 }
            if (r1 != 0) goto L_0x00a7
            android.view.View r1 = new android.view.View     // Catch:{ Exception -> 0x0019 }
            android.widget.LinearLayout r2 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            android.content.Context r2 = r2.getContext()     // Catch:{ Exception -> 0x0019 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0019 }
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams     // Catch:{ Exception -> 0x0019 }
            android.widget.LinearLayout r3 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0019 }
            int r3 = r7.tanxc_do((android.content.Context) r3)     // Catch:{ Exception -> 0x0019 }
            r2.<init>(r5, r3)     // Catch:{ Exception -> 0x0019 }
            r1.setLayoutParams(r2)     // Catch:{ Exception -> 0x0019 }
            android.widget.LinearLayout r2 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            r2.addView(r1)     // Catch:{ Exception -> 0x0019 }
            android.widget.LinearLayout r1 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.webview.TanxAdWebView r2 = r7.tanxc_if     // Catch:{ Exception -> 0x0019 }
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams     // Catch:{ Exception -> 0x0019 }
            r3.<init>(r4, r4)     // Catch:{ Exception -> 0x0019 }
            r1.addView(r2, r3)     // Catch:{ Exception -> 0x0019 }
            goto L_0x00a7
        L_0x00a0:
            com.alimm.tanx.core.bridge.JsBridgeUtil$BaseWebInterface r2 = r7.tanxc_byte     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x00a7
            r2.webDrawStatus(r1)     // Catch:{ Exception -> 0x0019 }
        L_0x00a7:
            return
        L_0x00a8:
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r7.tanxc_int     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x0217
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x0217
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r7.tanxc_int     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = r2.getRenderUrl()     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ad.bean.BidInfo r3 = r7.tanxc_int     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ad.bean.TemplateConfig r3 = r3.getTemplateConf()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = r3.getPidStyleId()     // Catch:{ Exception -> 0x0019 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0019 }
            if (r3 != 0) goto L_0x016f
            com.alimm.tanx.core.ad.bean.BidInfo r3 = r7.tanxc_int     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ad.bean.TemplateConfig r3 = r3.getTemplateConf()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = r3.getPidStyleId()     // Catch:{ Exception -> 0x0019 }
            int r6 = r3.hashCode()     // Catch:{ Exception -> 0x0019 }
            switch(r6) {
                case 1448635041: goto L_0x0124;
                case 1448635042: goto L_0x011a;
                case 1448635075: goto L_0x0110;
                case 1448635076: goto L_0x0106;
                case 1448635077: goto L_0x00fc;
                case 1448635101: goto L_0x00f2;
                case 1448635103: goto L_0x00e8;
                case 1448636000: goto L_0x00de;
                default: goto L_0x00dd;
            }     // Catch:{ Exception -> 0x0019 }
        L_0x00dd:
            goto L_0x012e
        L_0x00de:
            java.lang.String r6 = "100100"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x012e
            r3 = 6
            goto L_0x012f
        L_0x00e8:
            java.lang.String r6 = "100022"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x012e
            r3 = 4
            goto L_0x012f
        L_0x00f2:
            java.lang.String r6 = "100020"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x012e
            r3 = 7
            goto L_0x012f
        L_0x00fc:
            java.lang.String r6 = "100017"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x012e
            r3 = 2
            goto L_0x012f
        L_0x0106:
            java.lang.String r6 = "100016"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x012e
            r3 = 3
            goto L_0x012f
        L_0x0110:
            java.lang.String r6 = "100015"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x012e
            r3 = 5
            goto L_0x012f
        L_0x011a:
            java.lang.String r6 = "100003"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x012e
            r3 = 1
            goto L_0x012f
        L_0x0124:
            java.lang.String r6 = "100002"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x012e
            r3 = 0
            goto L_0x012f
        L_0x012e:
            r3 = -1
        L_0x012f:
            switch(r3) {
                case 0: goto L_0x0150;
                case 1: goto L_0x0149;
                case 2: goto L_0x0149;
                case 3: goto L_0x0149;
                case 4: goto L_0x0149;
                case 5: goto L_0x013e;
                case 6: goto L_0x0133;
                case 7: goto L_0x0133;
                default: goto L_0x0132;
            }     // Catch:{ Exception -> 0x0019 }
        L_0x0132:
            goto L_0x0174
        L_0x0133:
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r7.tanxc_int     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = r2.getWebUrl()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0174
        L_0x013e:
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r7.tanxc_int     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = r2.getRenderUrl()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0174
        L_0x0149:
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r7.tanxc_int     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = r2.getClickThroughUrl()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0174
        L_0x0150:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0019 }
            r3.<init>()     // Catch:{ Exception -> 0x0019 }
            r3.append(r2)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = "?pidStyleId="
            r3.append(r2)     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ad.bean.BidInfo r2 = r7.tanxc_int     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.ad.bean.TemplateConfig r2 = r2.getTemplateConf()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = r2.getPidStyleId()     // Catch:{ Exception -> 0x0019 }
            r3.append(r2)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0174
        L_0x016f:
            java.lang.String r3 = "load()  getPidStyleId == null "
            com.alimm.tanx.core.utils.LogUtils.e((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0019 }
        L_0x0174:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0019 }
            r3.<init>()     // Catch:{ Exception -> 0x0019 }
            java.lang.String r6 = "load h5:"
            r3.append(r6)     // Catch:{ Exception -> 0x0019 }
            r3.append(r2)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.utils.LogUtils.d((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ Exception -> 0x0019 }
            boolean r3 = com.alimm.tanx.core.utils.SysUtils.isValidUrl(r2)     // Catch:{ Exception -> 0x0019 }
            r6 = 8
            if (r3 == 0) goto L_0x01f2
            java.lang.String r1 = "\\\\"
            java.lang.String r3 = ""
            java.lang.String r1 = r2.replaceAll(r1, r3)     // Catch:{ Exception -> 0x0019 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x01a4
            android.widget.LinearLayout r1 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x0019 }
            return
        L_0x01a4:
            r7.tanxc_try()     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst r2 = com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance()     // Catch:{ Exception -> 0x0019 }
            r2.enableForce(r5)     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst r2 = com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance()     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.webview.TanxAdWebView r3 = r7.tanxc_if     // Catch:{ Exception -> 0x0019 }
            java.lang.String r1 = r7.tanxc_do((java.lang.String) r1)     // Catch:{ Exception -> 0x0019 }
            r2.loadUrl((android.webkit.WebView) r3, (java.lang.String) r1)     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.webview.TanxAdWebView r1 = r7.tanxc_if     // Catch:{ Exception -> 0x0019 }
            android.view.ViewParent r1 = r1.getParent()     // Catch:{ Exception -> 0x0019 }
            if (r1 != 0) goto L_0x0217
            android.view.View r1 = new android.view.View     // Catch:{ Exception -> 0x0019 }
            android.widget.LinearLayout r2 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            android.content.Context r2 = r2.getContext()     // Catch:{ Exception -> 0x0019 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0019 }
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams     // Catch:{ Exception -> 0x0019 }
            android.widget.LinearLayout r3 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0019 }
            int r3 = r7.tanxc_do((android.content.Context) r3)     // Catch:{ Exception -> 0x0019 }
            r2.<init>(r5, r3)     // Catch:{ Exception -> 0x0019 }
            r1.setLayoutParams(r2)     // Catch:{ Exception -> 0x0019 }
            android.widget.LinearLayout r2 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            r2.addView(r1)     // Catch:{ Exception -> 0x0019 }
            android.widget.LinearLayout r1 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.web.webview.TanxAdWebView r2 = r7.tanxc_if     // Catch:{ Exception -> 0x0019 }
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams     // Catch:{ Exception -> 0x0019 }
            r3.<init>(r4, r4)     // Catch:{ Exception -> 0x0019 }
            r1.addView(r2, r3)     // Catch:{ Exception -> 0x0019 }
            goto L_0x0217
        L_0x01f2:
            android.widget.LinearLayout r2 = r7.tanxc_for     // Catch:{ Exception -> 0x0019 }
            r2.setVisibility(r6)     // Catch:{ Exception -> 0x0019 }
            com.alimm.tanx.core.bridge.JsBridgeUtil$BaseWebInterface r2 = r7.tanxc_byte     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x0217
            r2.webDrawStatus(r1)     // Catch:{ Exception -> 0x0019 }
            goto L_0x0217
        L_0x01ff:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "load()   "
            r2.append(r3)
            java.lang.String r1 = com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(r1)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.alimm.tanx.core.utils.LogUtils.e((java.lang.String) r0, (java.lang.String) r1)
        L_0x0217:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.base.tanxc_if.tanxc_new():void");
    }

    public void tanxc_if() {
        tanxc_byte();
        AdWebViewManager adWebViewManager = this.tanxc_do;
        if (adWebViewManager != null) {
            adWebViewManager.destroy();
        }
    }

    public void tanxc_int() {
        if (this.tanxc_long) {
            tanxc_new();
        }
    }

    public void tanxc_do(LinearLayout linearLayout, boolean z, BidInfo bidInfo, TanxAdSlot tanxAdSlot, JsBridgeUtil.BaseWebInterface baseWebInterface, JsBridgeUtil.AdInterface adInterface) {
        LogUtils.d("BaseWebViewUtil", "init");
        this.tanxc_for = linearLayout;
        this.tanxc_int = bidInfo;
        this.tanxc_byte = baseWebInterface;
        this.tanxc_case = adInterface;
        this.tanxc_try = tanxAdSlot;
        this.tanxc_this = new JsBridgeUtil();
        if (tanxc_case()) {
            AdWebViewManager adWebView = WebCacheManager.getInstance().getAdWebView();
            this.tanxc_do = adWebView;
            TanxAdWebView webView = adWebView.getWebView(linearLayout.getContext());
            this.tanxc_if = webView;
            tanxc_do(webView, z);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean tanxc_if(android.webkit.WebView r3) {
        /*
            r0 = 1
            if (r3 == 0) goto L_0x0043
            android.content.Context r1 = r3.getContext()     // Catch:{ Exception -> 0x0027 }
            boolean r1 = r1 instanceof android.content.MutableContextWrapper     // Catch:{ Exception -> 0x0027 }
            r2 = 0
            if (r1 == 0) goto L_0x0029
            android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0027 }
            android.content.MutableContextWrapper r3 = (android.content.MutableContextWrapper) r3     // Catch:{ Exception -> 0x0027 }
            android.content.Context r1 = r3.getBaseContext()     // Catch:{ Exception -> 0x0027 }
            boolean r1 = r1 instanceof android.app.Activity     // Catch:{ Exception -> 0x0027 }
            if (r1 == 0) goto L_0x0043
            android.content.Context r3 = r3.getBaseContext()     // Catch:{ Exception -> 0x0027 }
            android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ Exception -> 0x0027 }
            boolean r3 = r3.isDestroyed()     // Catch:{ Exception -> 0x0027 }
            if (r3 != 0) goto L_0x0043
            return r2
        L_0x0027:
            r3 = move-exception
            goto L_0x003e
        L_0x0029:
            android.content.Context r1 = r3.getContext()     // Catch:{ Exception -> 0x0027 }
            boolean r1 = r1 instanceof android.app.Activity     // Catch:{ Exception -> 0x0027 }
            if (r1 == 0) goto L_0x0043
            android.content.Context r3 = r3.getContext()     // Catch:{ Exception -> 0x0027 }
            android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ Exception -> 0x0027 }
            boolean r3 = r3.isDestroyed()     // Catch:{ Exception -> 0x0027 }
            if (r3 != 0) goto L_0x0043
            return r2
        L_0x003e:
            java.lang.String r1 = "BaseWebViewUtil"
            com.alimm.tanx.core.utils.LogUtils.e((java.lang.String) r1, (java.lang.Exception) r3)
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.ad.base.tanxc_if.tanxc_if(android.webkit.WebView):boolean");
    }

    public void tanxc_for() {
        TanxCountDownTimer tanxCountDownTimer = this.tanxc_char;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.cancel();
            this.tanxc_char = null;
        }
    }

    private void tanxc_do(TanxAdWebView tanxAdWebView, boolean z) {
        tanxAdWebView.setWebClickable(z);
        tanxAdWebView.setBackgroundColor(0);
        tanxAdWebView.setOnScrollChangedCallback(new OnScrollChangedCallback() {
            public void onScroll(int i, int i2) {
                try {
                    if (tanxc_if.this.tanxc_byte != null && (tanxc_if.this.tanxc_byte instanceof RewardWebViewUtil.RewardInterface)) {
                        ((RewardWebViewUtil.RewardInterface) tanxc_if.this.tanxc_byte).onScroll(i, i2);
                    }
                } catch (Exception e) {
                    LogUtils.e(e);
                }
            }
        });
        tanxc_do((WebView) tanxAdWebView);
        tanxc_for((WebView) tanxAdWebView);
        tanxc_new();
    }

    public void tanxc_do(WebView webView) {
        this.tanxc_new = new TanxJsBridge(this.tanxc_if.getContext(), this.tanxc_if);
        if (this.tanxc_this != null) {
            this.tanxc_this.initJsBridge(this.tanxc_new, new JsBridgeBean(this.tanxc_int, this.tanxc_try), this.tanxc_byte, this.tanxc_case);
            return;
        }
        LogUtils.d("BaseWebViewUtil", "initJsBridge，jsBridgeUtil为空终止注册");
    }

    public void tanxc_do(boolean z) {
        JsBridgeUtil jsBridgeUtil = this.tanxc_this;
        if (jsBridgeUtil != null) {
            jsBridgeUtil.setShowWebBar(this.tanxc_new, z);
        } else {
            LogUtils.d("BaseWebViewUtil", "setJsBridgeShowWebBar，jsBridgeUtil为空终止注册");
        }
    }

    /* access modifiers changed from: private */
    public void tanxc_do(WebView webView, WebResourceRequest webResourceRequest, int i, String str) {
        try {
            String uri = webResourceRequest.getUrl().toString();
            LogUtils.d("BaseWebViewUtil", "loadError URL:" + uri);
            if (SysUtils.checkUrlSuffixAndValid(uri)) {
                this.tanxc_long = true;
                webView.setVisibility(8);
            }
            LogUtils.e("BaseWebViewUtil", "loadError errorCode:" + i + " errorMsg:" + str + " url:" + uri);
        } catch (Exception e) {
            LogUtils.e("BaseWebViewUtil", "loadError:", (Throwable) e);
        }
    }

    private int tanxc_do(Context context) {
        if (!tanxc_do() || context == null) {
            return 0;
        }
        return SysUtils.getStatusBarHeight2WebView(context);
    }

    private String tanxc_do(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains(LocationInfo.NA)) {
            return (str + "&sdkVersion=" + SdkConstant.getSdkVersion()).trim();
        }
        return (str + "?sdkVersion=" + SdkConstant.getSdkVersion()).trim();
    }
}
