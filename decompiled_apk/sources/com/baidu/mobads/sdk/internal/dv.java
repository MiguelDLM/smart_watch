package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import com.huawei.openalliance.ad.constant.bn;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class dv extends bj {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6322a;
    private int q;
    private String r;
    private ScreenVideoAdListener s;
    private final String t;
    private int u;
    private int v;
    private String w;
    private String x;
    private a y;
    private RequestParameters z;

    public dv(Context context, String str, boolean z) {
        this(context, str, z, IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO);
    }

    public void a(Context context) {
        if (this.k != null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "setContext");
                hashMap.put(bn.f.o, context);
            } catch (JSONException e) {
                bv.a().a(e);
            }
            a(jSONObject, hashMap);
            this.k.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
        super.b(str, i);
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    public void f() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    public boolean g() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            return iAdInterListener.isAdReady();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    public void j(String str) {
        this.x = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.t);
            this.k.createProdHandler(jSONObject2);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put("n", "1");
            jSONObject.put("at", "10");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            Rect a2 = bb.a(this.h);
            this.u = a2.width();
            this.v = a2.height();
            if (this.h.getResources().getConfiguration().orientation == 2) {
                this.u = a2.height();
                this.v = a2.width();
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.u);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, "" + this.v);
            jSONObject.put("opt", 1);
            if (IAdInterListener.AdProdType.PRODUCT_REWARDVIDEO.equals(this.t)) {
                jSONObject.put("msa", 5285);
            }
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
            jSONObject.put("timeout", 8000);
            jSONObject.put("useSurfaceView", this.f6322a);
            jSONObject.put("downloadConfirmPolicy", this.q);
            jSONObject.put("userid", this.w);
            jSONObject.put("extra", this.x);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void s() {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    public dv(Context context, String str, boolean z, String str2) {
        super(context);
        this.q = 3;
        this.r = str;
        this.f6322a = z;
        this.t = str2;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        float floatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(floatValue);
        }
    }

    public String h() {
        a aVar = this.y;
        if (aVar != null) {
            return aVar.z();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(boolean z) {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(String str) {
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    public void a(int i) {
        this.q = i;
    }

    public void a(String str) {
        this.w = str;
    }

    public void a(ScreenVideoAdListener screenVideoAdListener) {
        this.s = screenVideoAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener == null) {
            this.l = false;
        } else {
            this.l = true;
            iAdInterListener.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        List<a> a2;
        if (iOAdEvent != null && (a2 = b.a(iOAdEvent.getMessage()).a()) != null && a2.size() > 0) {
            this.y = a2.get(0);
        }
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i, String str) {
        super.a(i, str);
        ScreenVideoAdListener screenVideoAdListener = this.s;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    public void a(boolean z, String str) {
        a(z, str, (LinkedHashMap<String, Object>) null);
    }

    public void a(boolean z, String str, LinkedHashMap<String, Object> linkedHashMap) {
        a aVar = this.y;
        if (aVar != null) {
            a(aVar.H(), z, str, linkedHashMap);
        }
    }

    public void a(RequestParameters requestParameters) {
        this.z = requestParameters;
        a(requestParameters.getExt());
    }

    public Object k(String str) {
        if (this.y == null) {
            return null;
        }
        if ("request_id".equals(str)) {
            return this.y.U();
        }
        return this.y.a(str);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        try {
            this.m = k.a(map);
        } catch (Throwable unused) {
            this.m = new HashMap<>();
        }
    }
}
