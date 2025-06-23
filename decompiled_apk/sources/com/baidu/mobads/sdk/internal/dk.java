package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class dk extends bj {
    private a A;
    private boolean B;
    private boolean C;

    /* renamed from: a, reason: collision with root package name */
    RelativeLayout f6311a;
    public boolean q;
    public boolean r;
    private int s;
    private String t;
    private String u;
    private int v;
    private int w;
    private ExpressInterstitialListener x;
    private ExpressInterstitialAd.InterAdDownloadWindowListener y;
    private ExpressInterstitialAd.InterstitialAdDislikeListener z;

    public dk(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.s = 8000;
        this.t = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.v = 600;
        this.w = 500;
        this.B = false;
        this.f6311a = relativeLayout;
        this.u = str;
    }

    public void a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.y = interAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i, str);
        }
        super.b(str, i);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
            this.x.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z) {
        this.B = z;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
            this.x.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void d(String str) {
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        this.r = false;
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(String str) {
    }

    public boolean g() {
        return this.r;
    }

    public void h() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.t);
            jSONObject2.put("isNewInterstitial", true);
            this.k.createProdHandler(jSONObject2);
            this.k.setAdContainer(this.f6311a);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.u);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            if (cs.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("at", "10");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + bb.b(this.h));
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, "" + bb.c(this.h));
            jSONObject.put("msa", 151);
            jSONObject.put("opt", 1);
            jSONObject = k.a(jSONObject, b(this.m));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onlyLoadAd", this.q);
            jSONObject.put("isNewInterstitial", true);
            jSONObject.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, this.B);
            jSONObject.put("use_dialog_container", this.C);
            jSONObject.put("timeout", this.s);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void v() {
    }

    public a x() {
        return this.A;
    }

    public void a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.z = interstitialAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void c(IOAdEvent iOAdEvent) {
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.z;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    public void d(boolean z) {
        this.C = z;
    }

    public String f() {
        return this.t;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    public void a(int i) {
        this.s = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    public void a(ExpressInterstitialListener expressInterstitialListener) {
        this.x = expressInterstitialListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.y;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener == null) {
            this.l = false;
            return;
        }
        this.r = false;
        this.l = true;
        iAdInterListener.loadAd(k(), l());
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.v = width;
            this.w = height;
        }
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i, String str) {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i, str);
        }
        super.a(i, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.y;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        List<a> a2;
        if (iOAdEvent != null && (a2 = b.a(iOAdEvent.getMessage()).a()) != null && a2.size() > 0) {
            this.A = a2.get(0);
        }
        this.r = true;
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
    }

    public void a(boolean z, String str) {
        a(z, str, (LinkedHashMap<String, Object>) null);
    }

    public void a(boolean z, String str, LinkedHashMap<String, Object> linkedHashMap) {
        a aVar = this.A;
        if (aVar != null) {
            a(aVar.H(), z, str, linkedHashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        try {
            this.m = k.a(map);
        } catch (Throwable unused) {
            this.m = new HashMap<>();
        }
    }

    public Object a(String str) {
        if (this.A == null) {
            return null;
        }
        if ("request_id".equals(str)) {
            return this.A.U();
        }
        return this.A.a(str);
    }
}
