package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class cu extends bj {

    /* renamed from: a, reason: collision with root package name */
    private RelativeLayout f6295a;
    private String q;
    private boolean r;
    private AdViewListener s;
    private int t;
    private int u;
    private AdView v;
    private RequestParameters w;

    public cu(AdView adView, Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        this.v = adView;
        this.f6295a = relativeLayout;
        this.q = str;
        this.r = z;
    }

    public void a(int i) {
        this.t = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdFailed(str);
        }
    }

    public void c(int i) {
        this.u = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdClose(new JSONObject());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdClick(new JSONObject());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdSwitch();
            this.s.onAdShow(new JSONObject());
        }
    }

    public void a(AdViewListener adViewListener) {
        this.s = adViewListener;
    }

    public void a(RequestParameters requestParameters) {
        this.w = requestParameters;
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "banner");
            this.k.createProdHandler(jSONObject3);
            this.k.setAdContainer(this.f6295a);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "banner");
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.q);
            jSONObject.put("at", "2");
            jSONObject.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
            jSONObject.put("AP", this.r);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.t);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, "" + this.u);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            RequestParameters requestParameters = this.w;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            jSONObject2 = b(this.m);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        AdViewListener adViewListener = this.s;
        if (adViewListener != null) {
            adViewListener.onAdReady(this.v);
        }
    }
}
