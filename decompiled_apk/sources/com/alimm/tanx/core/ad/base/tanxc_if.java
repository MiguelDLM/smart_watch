package com.alimm.tanx.core.ad.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.bridge.JsBridgeBean;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.TanxJsBridge;
import com.alimm.tanx.core.constant.AdConstants;
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

/* loaded from: classes.dex */
public abstract class tanxc_if {
    private JsBridgeUtil.BaseWebInterface tanxc_byte;
    private JsBridgeUtil.AdInterface tanxc_case;
    private TanxCountDownTimer tanxc_char;
    private AdWebViewManager tanxc_do;
    private LinearLayout tanxc_for;
    private TanxAdWebView tanxc_if;
    private BidInfo tanxc_int;
    protected TanxJsBridge tanxc_new;
    private JsBridgeUtil tanxc_this;
    private TanxAdSlot tanxc_try;
    private int tanxc_else = 0;
    private volatile boolean tanxc_goto = false;
    private boolean tanxc_long = false;
    private volatile boolean tanxc_void = false;

    /* JADX INFO: Access modifiers changed from: private */
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
        if (this.tanxc_int.getTemplateConf().getWebStartTime2Long().longValue() <= System.currentTimeMillis() && this.tanxc_int.getTemplateConf().getWebEndTime2Long().longValue() >= System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ int tanxc_new(tanxc_if tanxc_ifVar) {
        int i = tanxc_ifVar.tanxc_else;
        tanxc_ifVar.tanxc_else = i + 1;
        return i;
    }

    private void tanxc_try() {
        LogUtils.d("BaseWebViewUtil", "startTimerDog - startSwitch:" + this.tanxc_goto);
        try {
            if (this.tanxc_goto) {
                return;
            }
            final long j = 5000;
            final long j2 = 1000;
            TanxCountDownTimer tanxCountDownTimer = new TanxCountDownTimer(j, j2) { // from class: com.alimm.tanx.core.ad.base.BaseWebViewUtil$4
                @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                public void onFinish() {
                    LogUtils.d("BaseWebViewUtil", "startTimer - onFinish");
                    tanxc_if.this.tanxc_goto = false;
                    tanxc_if.tanxc_new(tanxc_if.this);
                    tanxc_if.this.tanxc_new();
                }

                @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                public void onTick(long j3) {
                    LogUtils.d("BaseWebViewUtil", "startTimer" + Math.round(((float) j3) / 1000.0f) + "");
                }
            };
            this.tanxc_char = tanxCountDownTimer;
            if (this.tanxc_else <= 5) {
                tanxCountDownTimer.start();
                this.tanxc_goto = true;
            } else {
                LogUtils.d("BaseWebViewUtil", "startTimer不在启动：nowTryLoadCount:" + this.tanxc_else);
            }
        } catch (Exception e) {
            LogUtils.e("BaseWebViewUtil", "startTimer", e);
        }
    }

    public abstract boolean tanxc_do();

    private void tanxc_for(final WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setUserAgentString(webView.getSettings().getUserAgentString() + AndroidUtils.getUserAgentSuffix());
        webView.setOverScrollMode(2);
        webView.setWebChromeClient(new WebChromeClient() { // from class: com.alimm.tanx.core.ad.base.tanxc_if.2
            @Override // android.webkit.WebChromeClient
            @Nullable
            public Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                return super.onJsAlert(webView2, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i) {
                super.onProgressChanged(webView2, i);
                LogUtils.d("BaseWebViewUtil", "onProgressChanged:" + i);
            }
        });
        webView.setWebViewClient(new WebViewClient() { // from class: com.alimm.tanx.core.ad.base.tanxc_if.3
            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView2, String str) {
                LogUtils.d("BaseWebViewUtil", "onLoadResource");
                super.onLoadResource(webView2, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
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

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                LogUtils.d("BaseWebViewUtil", "onPageStarted");
            }

            @Override // android.webkit.WebViewClient
            @RequiresApi(api = 23)
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                int errorCode;
                int errorCode2;
                CharSequence description;
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedError:");
                errorCode = webResourceError.getErrorCode();
                sb.append(errorCode);
                LogUtils.d("BaseWebViewUtil", sb.toString());
                errorCode2 = webResourceError.getErrorCode();
                description = webResourceError.getDescription();
                tanxc_if.this.tanxc_do(webView2, webResourceRequest, errorCode2, description.toString());
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                tanxc_if.this.tanxc_do(webView2, webResourceRequest, webResourceResponse.getStatusCode(), "");
                super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                LogUtils.d("BaseWebViewUtil", "onReceivedHttpError:" + webResourceResponse.getStatusCode());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (SharedPreferencesHelper.getInstance().getHttpsBoolean()) {
                    sslErrorHandler.proceed();
                } else {
                    super.onReceivedSslError(webView2, sslErrorHandler, sslError);
                    sslErrorHandler.cancel();
                }
            }

            @Override // android.webkit.WebViewClient
            @Nullable
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView webView2, WebResourceRequest webResourceRequest) {
                LogUtils.d("BaseWebViewUtil", "shouldInterceptRequest");
                return WebViewCacheInterceptorInst.getInstance().interceptRequest(webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                LogUtils.d("BaseWebViewUtil", "shouldOverrideUrlLoading");
                WebViewCacheInterceptorInst.getInstance().loadUrl(webView, webResourceRequest.getUrl().toString());
                return true;
            }

            @Override // android.webkit.WebViewClient
            @Nullable
            public WebResourceResponse shouldInterceptRequest(WebView webView2, String str) {
                LogUtils.d("BaseWebViewUtil", "shouldInterceptRequest2");
                return WebViewCacheInterceptorInst.getInstance().interceptRequest(str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                LogUtils.d("BaseWebViewUtil", "shouldOverrideUrlLoading2");
                WebViewCacheInterceptorInst.getInstance().loadUrl(webView, str);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_new() {
        char c;
        try {
            LogUtils.d("BaseWebViewUtil", "load");
            this.tanxc_long = false;
            if (tanxc_if(this.tanxc_if)) {
                LogUtils.e("BaseWebViewUtil", "webView已经回收，无法load，终止！！！！");
                return;
            }
            String string = SharedPreferencesHelper.getInstance().getString(SharedPreferencesHelper.REWARD_URL);
            if (!TextUtils.isEmpty(string) && TanxCoreSdk.getConfig().isDebugMode()) {
                if (SysUtils.isValidUrl(string)) {
                    LogUtils.d("BaseWebViewUtil", "load testUrl:" + string);
                    tanxc_try();
                    WebViewCacheInterceptorInst.getInstance().enableForce(true);
                    WebViewCacheInterceptorInst.getInstance().loadUrl(this.tanxc_if, tanxc_do(string));
                    if (this.tanxc_if.getParent() == null) {
                        View view = new View(this.tanxc_for.getContext());
                        view.setLayoutParams(new ViewGroup.LayoutParams(1, tanxc_do(this.tanxc_for.getContext())));
                        this.tanxc_for.addView(view);
                        this.tanxc_for.addView(this.tanxc_if, new ViewGroup.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                JsBridgeUtil.BaseWebInterface baseWebInterface = this.tanxc_byte;
                if (baseWebInterface != null) {
                    baseWebInterface.webDrawStatus(false);
                    return;
                }
                return;
            }
            BidInfo bidInfo = this.tanxc_int;
            if (bidInfo == null || bidInfo.getTemplateConf() == null) {
                return;
            }
            String renderUrl = this.tanxc_int.getTemplateConf().getRenderUrl();
            if (TextUtils.isEmpty(this.tanxc_int.getTemplateConf().getPidStyleId())) {
                LogUtils.e("BaseWebViewUtil", "load()  getPidStyleId == null ");
            } else {
                String pidStyleId = this.tanxc_int.getTemplateConf().getPidStyleId();
                switch (pidStyleId.hashCode()) {
                    case 1448635041:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_REWARD_VIDEO_ID)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635042:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_REWARD_ID)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635075:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_TABLE_SCREEN_ID)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635076:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_ORDER_REWARD_ID)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635077:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_NEW_REWARD_ID)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635101:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_SPLASH_WEB_ID)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635103:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_OPEN_TAO_BAO_REWARD_ID)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448636000:
                        if (pidStyleId.equals(AdConstants.PID_STYLE_FEED_NATIVE_WEB_ID)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        renderUrl = renderUrl + "?pidStyleId=" + this.tanxc_int.getTemplateConf().getPidStyleId();
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        renderUrl = this.tanxc_int.getClickThroughUrl();
                        break;
                    case 5:
                        renderUrl = this.tanxc_int.getTemplateConf().getRenderUrl();
                        break;
                    case 6:
                    case 7:
                        renderUrl = this.tanxc_int.getTemplateConf().getWebUrl();
                        break;
                }
            }
            LogUtils.d("BaseWebViewUtil", "load h5:" + renderUrl);
            if (SysUtils.isValidUrl(renderUrl)) {
                String replaceAll = renderUrl.replaceAll("\\\\", "");
                if (TextUtils.isEmpty(replaceAll)) {
                    this.tanxc_for.setVisibility(8);
                    return;
                }
                tanxc_try();
                WebViewCacheInterceptorInst.getInstance().enableForce(true);
                WebViewCacheInterceptorInst.getInstance().loadUrl(this.tanxc_if, tanxc_do(replaceAll));
                if (this.tanxc_if.getParent() == null) {
                    View view2 = new View(this.tanxc_for.getContext());
                    view2.setLayoutParams(new ViewGroup.LayoutParams(1, tanxc_do(this.tanxc_for.getContext())));
                    this.tanxc_for.addView(view2);
                    this.tanxc_for.addView(this.tanxc_if, new ViewGroup.LayoutParams(-1, -1));
                    return;
                }
                return;
            }
            this.tanxc_for.setVisibility(8);
            JsBridgeUtil.BaseWebInterface baseWebInterface2 = this.tanxc_byte;
            if (baseWebInterface2 != null) {
                baseWebInterface2.webDrawStatus(false);
            }
        } catch (Exception e) {
            LogUtils.e("BaseWebViewUtil", "load()   " + LogUtils.getStackTraceMessage(e));
        }
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

    public static boolean tanxc_if(WebView webView) {
        if (webView != null) {
            try {
                if (webView.getContext() instanceof MutableContextWrapper) {
                    MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) webView.getContext();
                    if ((mutableContextWrapper.getBaseContext() instanceof Activity) && !((Activity) mutableContextWrapper.getBaseContext()).isDestroyed()) {
                        return false;
                    }
                } else if ((webView.getContext() instanceof Activity) && !((Activity) webView.getContext()).isDestroyed()) {
                    return false;
                }
            } catch (Exception e) {
                LogUtils.e("BaseWebViewUtil", e);
            }
        }
        return true;
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
        tanxAdWebView.setOnScrollChangedCallback(new OnScrollChangedCallback() { // from class: com.alimm.tanx.core.ad.base.tanxc_if.1
            @Override // com.alimm.tanx.core.web.webview.OnScrollChangedCallback
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
        tanxc_do(tanxAdWebView);
        tanxc_for(tanxAdWebView);
        tanxc_new();
    }

    public void tanxc_do(WebView webView) {
        this.tanxc_new = new TanxJsBridge(this.tanxc_if.getContext(), this.tanxc_if);
        if (this.tanxc_this != null) {
            this.tanxc_this.initJsBridge(this.tanxc_new, new JsBridgeBean(this.tanxc_int, this.tanxc_try), this.tanxc_byte, this.tanxc_case);
        } else {
            LogUtils.d("BaseWebViewUtil", "initJsBridge，jsBridgeUtil为空终止注册");
        }
    }

    public void tanxc_do(boolean z) {
        JsBridgeUtil jsBridgeUtil = this.tanxc_this;
        if (jsBridgeUtil != null) {
            jsBridgeUtil.setShowWebBar(this.tanxc_new, z);
        } else {
            LogUtils.d("BaseWebViewUtil", "setJsBridgeShowWebBar，jsBridgeUtil为空终止注册");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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
            LogUtils.e("BaseWebViewUtil", "loadError:", e);
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
