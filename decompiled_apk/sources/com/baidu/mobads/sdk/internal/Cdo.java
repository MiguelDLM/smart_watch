package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.do, reason: invalid class name */
/* loaded from: classes7.dex */
public class Cdo extends bj {

    /* renamed from: a, reason: collision with root package name */
    private WebView f6315a;
    private BaiduHybridAdViewListener q;
    private IXHybridAdRenderer r;

    public Cdo(WebView webView) {
        super(webView.getContext());
        this.f6315a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.f6315a.removeJavascriptInterface("accessibility");
        this.f6315a.removeJavascriptInterface("accessibilityTraversal");
        this.f6315a.getSettings().setAllowContentAccess(false);
        this.f6315a.getSettings().setSavePassword(false);
        this.f6315a.getSettings().setAllowFileAccess(false);
    }

    public void a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.q = baiduHybridAdViewListener;
    }

    public boolean b(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        super.h(iOAdEvent);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void i() {
        IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) av.a(x.j, bu.a(this.h), (Class<?>[]) new Class[]{Context.class}, this.h);
        this.r = iXHybridAdRenderer;
        this.k = iXHybridAdRenderer;
        if (!this.l) {
            a();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        super.q();
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
        super.b(str, i);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }

    public void a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    public void a(WebView webView, int i, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i, str, str2);
        }
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.r == null) {
            this.l = false;
            return;
        }
        this.l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            this.r.createProdHandler(jSONObject3);
            n();
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            jSONObject2.put("timeout", 10000);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.r.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        this.r.setCustomerWebView(this.f6315a);
    }
}
