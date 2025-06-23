package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class dw extends bj {
    private static int G;
    private static dw M;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private SplashAdListener H;
    private SplashAd.OnFinishListener I;
    private SplashAd.SplashFocusAdListener J;
    private SplashAd.SplashCardAdListener K;
    private RequestParameters L;
    private a N;
    private SplashAd.SplashAdDownloadDialogListener O;
    private HashMap<String, String> P;

    /* renamed from: a, reason: collision with root package name */
    protected int f6323a;
    protected int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    private RelativeLayout v;
    private String w;
    private int x;
    private int y;
    private int z;

    public dw(Context context, String str, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context);
        this.F = 60;
        this.f6323a = 67;
        this.q = ViewCompat.MEASURED_STATE_MASK;
        this.s = false;
        this.t = false;
        this.u = false;
        this.w = str;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.A = i4;
        this.B = z;
        this.C = z2;
        this.D = z4;
        this.E = z3;
    }

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context = this.h;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.h.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context2 = this.h;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
    }

    public static void e(int i) {
        G = i;
    }

    private String k(String str) {
        if (this.L == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.L.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th) {
            this.i.d(bj.b, th);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b_();
    }

    public void c(int i) {
        this.q = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c_();
    }

    public void d(int i) {
        this.F = i;
    }

    public void f() {
        IAdInterListener iAdInterListener;
        if (this.r || (iAdInterListener = this.k) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.v);
        this.k.showAd();
    }

    public boolean g() {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("event_type", "splash_focus_card_enable");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_enable");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e) {
            bv.a().c(e);
            return false;
        } catch (Throwable th) {
            bv.a().c(th);
            return false;
        }
    }

    public a h() {
        return this.N;
    }

    public Object j(String str) {
        if (this.N != null) {
            if ("request_id".equals(str)) {
                return this.N.U();
            }
            return this.N.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.A);
            jSONObject.put("splashTipStyle", this.z);
            jSONObject.put("bitmapDisplayMode", G);
            jSONObject.put("countDownNew", "true");
            jSONObject.put("Display_Down_Info", "" + this.B);
            jSONObject.put("popDialogIfDl", "" + this.C);
            jSONObject.put("limitRegionClick", "" + this.D);
            jSONObject.put("displayClickButton", "" + this.E);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.r);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.F);
            jSONObject.put("twistLogoHeightDp", this.f6323a);
            jSONObject.put("twistBgColor", this.q);
            RequestParameters requestParameters = this.L;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            return k.a(jSONObject, b(this.m));
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdPresent();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdIconShow();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void t() {
        SplashAd.OnFinishListener onFinishListener = this.I;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.I = null;
        } else {
            Context context = this.h;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        this.h = null;
        this.v = null;
        super.t();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener != null && (splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            splashAdDownloadDialogListener.onADPrivacyLpClose();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void v() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener != null && (splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            splashAdDownloadDialogListener.onADFunctionLpClose();
        }
    }

    public void a(RelativeLayout relativeLayout) {
        this.v = relativeLayout;
    }

    public void c(Map<String, String> map) {
        try {
            this.P = k.a(map);
        } catch (Throwable unused) {
            this.P = new HashMap<>();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdExposed();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        this.s = true;
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClick();
        }
    }

    public void a(int i) {
        this.f6323a = i;
    }

    public void a(SplashAdListener splashAdListener) {
        this.H = splashAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpShow();
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.J = splashFocusAdListener;
        this.t = false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        String str = "1";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.k.createProdHandler(jSONObject2);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.w);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put("at", "26");
            jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.x);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, "" + this.y);
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            String k = k(SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(k)) {
                if (!Boolean.parseBoolean(k)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            jSONObject = k.a(jSONObject, b(this.P));
            b(jSONObject);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void a(SplashAd.SplashCardAdListener splashCardAdListener) {
        this.K = splashCardAdListener;
        this.t = false;
    }

    public boolean b(Activity activity) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            this.k.removeAllListeners();
            this.k.addEventListener(x.N, this.j);
            this.k.addEventListener(x.I, this.j);
            this.k.addEventListener(x.X, this.j);
            this.H = null;
            jSONObject.putOpt("event_type", "splash_focus_card");
            hashMap.put("splash_focus_activity", activity);
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_show");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e) {
            bv.a().c(e);
            return false;
        } catch (Throwable th) {
            bv.a().c(th);
            return false;
        }
    }

    public void a(RequestParameters requestParameters) {
        this.L = requestParameters;
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        if (this.t) {
            return;
        }
        this.t = true;
        Map<String, Object> data = iOAdEvent.getData();
        if (this.J != null && data != null && data.containsKey("splash_close_reason")) {
            this.J.onAdClose();
            return;
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClose();
            return;
        }
        super.g(iOAdEvent);
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener == null) {
            this.l = false;
            return;
        }
        this.l = true;
        if (!this.r) {
            iAdInterListener.setAdContainer(this.v);
        }
        this.k.loadAd(k(), l());
    }

    public void a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        try {
            if (!this.s && intent != null && this.k != null && !this.u && (this.h instanceof Activity)) {
                this.I = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                try {
                    jSONObject.putOpt("event_type", "splash_focus_start_activity");
                    hashMap.put("splash_focus_user_intent", intent);
                } catch (JSONException e) {
                    bv.a().a(e);
                }
                this.k.removeAllListeners();
                this.k.addEventListener(x.aa, this.j);
                this.k.addEventListener(x.N, this.j);
                this.k.addEventListener(x.I, this.j);
                this.k.addEventListener(x.X, this.j);
                this.k.addEventListener(x.Y, this.j);
                a(jSONObject, hashMap);
                this.H = null;
                M = this;
                be.a().a(new dx(this), 3L, TimeUnit.SECONDS);
                return;
            }
            b(intent, onFinishListener);
        } catch (Throwable th) {
            th.printStackTrace();
            b(intent, onFinishListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(String str) {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdSkip();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
        this.u = true;
        if (this.H != null) {
            a(i + "==" + str);
            this.H.onAdFailed(str);
        }
        super.b(str, i);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        dw dwVar = M;
        if (dwVar != null) {
            dwVar.a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    try {
                        jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                        jSONObject2.putOpt("splash_focus_params", jSONObject);
                        hashMap.put("splash_focus_activity", activity);
                        M.a(jSONObject2, hashMap);
                    } catch (Throwable th) {
                        bv.a().c(th);
                    }
                } catch (JSONException e) {
                    bv.a().c(e);
                }
                M = null;
            } catch (Throwable th2) {
                M = null;
                throw th2;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        List<a> a2;
        if (iOAdEvent != null && (a2 = b.a(iOAdEvent.getMessage()).a()) != null && a2.size() > 0) {
            this.N = a2.get(0);
        }
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i, String str) {
        this.u = true;
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.a(i, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.O = splashAdDownloadDialogListener;
    }

    public void a(boolean z, String str) {
        a(z, str, (LinkedHashMap<String, Object>) null);
    }

    public void a(boolean z, String str, LinkedHashMap<String, Object> linkedHashMap) {
        a aVar = this.N;
        if (aVar != null) {
            a(aVar.H(), z, str, linkedHashMap);
        }
    }

    public void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (JSONException e) {
                bv.a().a(e);
            }
            a(jSONObject, hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
