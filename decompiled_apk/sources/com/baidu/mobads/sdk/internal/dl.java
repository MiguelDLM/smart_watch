package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeAdPlacement;
import com.baidu.mobads.sdk.api.BaiduNativeH5AdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class dl extends bj {
    private boolean A;
    private BaiduNativeAdPlacement B;

    /* renamed from: a, reason: collision with root package name */
    a f6312a;
    private String q;
    private String r;
    private int s;
    private int t;
    private BaiduNativeH5AdView u;
    private int v;
    private int w;
    private int x;
    private BaiduNativeH5AdView.BaiduNativeH5EventListner y;
    private boolean z;

    public dl(Context context, String str, BaiduNativeH5AdView baiduNativeH5AdView) {
        super(context);
        this.v = 1;
        this.w = 1;
        this.x = 1;
        this.z = false;
        this.f6312a = null;
        this.A = false;
        this.u = baiduNativeH5AdView;
        this.r = baiduNativeH5AdView.getAdPlacement().getApId();
        this.q = str;
        this.g = baiduNativeH5AdView.getAdPlacement().getAdView();
    }

    public void a(BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.y = baiduNativeH5EventListner;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }

    public void c(boolean z) {
        this.z = z;
    }

    public void d(int i) {
        this.x = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        this.B.setWinSended(true);
    }

    public boolean f() {
        return this.z;
    }

    public boolean g() {
        return this.A;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        this.B.setClicked(true);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        this.z = true;
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdShow();
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.s = width;
        this.t = height;
    }

    public void c(int i) {
        this.w = i;
    }

    public void a(int i) {
        this.v = i;
    }

    public void a(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.B = baiduNativeAdPlacement;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, this.q);
            this.k.createProdHandler(jSONObject3);
            this.k.setAdContainer(this.g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.q);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            jSONObject.put("at", "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.s);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, "" + this.t);
            jSONObject = k.a(jSONObject, b(this.m));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        this.A = true;
        this.u.getAdPlacement().setAdResponse(b.a(iOAdEvent.getMessage()).a().get(0));
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdDataLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i, String str) {
        r();
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }
}
