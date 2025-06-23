package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdEntryResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.constant.bn;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class dm extends bj {
    private f.a A;
    private BaiduNativeManager.ExpressAdListener B;
    private BaiduNativeManager.EntryAdListener C;
    private f.b D;
    private int E;

    /* renamed from: a, reason: collision with root package name */
    private List<NativeResponse> f6313a;
    private List<ExpressResponse> q;
    private List<EntryResponse> r;
    private int s;
    private boolean t;
    private String u;
    private String v;
    private int w;
    private int x;
    private RequestParameters y;
    private boolean z;

    public dm(Context context, String str, String str2, boolean z, int i) {
        super(context);
        this.z = false;
        this.E = 0;
        this.v = str;
        this.u = str2;
        this.t = z;
        this.s = i;
        this.w = 600;
        this.x = 500;
    }

    public void a(f.a aVar) {
        this.A = aVar;
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z) {
        this.z = z;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.f6313a != null) {
            while (i < this.f6313a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.a(xAdNativeResponse);
                }
                i++;
            }
            return;
        }
        if (this.B != null && !TextUtils.isEmpty(message) && this.q != null) {
            while (i < this.q.size()) {
                bs bsVar = (bs) this.q.get(i);
                if (TextUtils.equals(message, bsVar.a())) {
                    bsVar.c();
                }
                i++;
            }
            return;
        }
        if (this.C == null || TextUtils.isEmpty(message) || this.r == null) {
            return;
        }
        while (i < this.r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onADExposed();
            }
            i++;
        }
    }

    public String f() {
        return this.u;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        for (int i = 0; i < this.q.size(); i++) {
            bs bsVar = (bs) this.q.get(i);
            if (TextUtils.equals(bsVar.a(), str)) {
                bsVar.a(bsVar);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.f6313a != null) {
            while (i < this.f6313a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.b(xAdNativeResponse);
                }
                i++;
            }
            return;
        }
        if (this.B != null && !TextUtils.isEmpty(message) && this.q != null) {
            while (i < this.q.size()) {
                bs bsVar = (bs) this.q.get(i);
                if (TextUtils.equals(message, bsVar.a())) {
                    bsVar.b();
                }
                i++;
            }
            return;
        }
        if (this.C == null || TextUtils.isEmpty(message) || this.r == null) {
            return;
        }
        while (i < this.r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdClick();
            }
            i++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B != null && iOAdEvent != null && this.q != null && (data = iOAdEvent.getData()) != null) {
            String str = (String) data.get("uniqueId");
            View view = (View) data.get("expressView");
            int intValue = ((Integer) data.get("viewWidth")).intValue();
            int intValue2 = ((Integer) data.get("viewHeight")).intValue();
            for (int i = 0; i < this.q.size(); i++) {
                bs bsVar = (bs) this.q.get(i);
                if (TextUtils.equals(bsVar.a(), str)) {
                    bsVar.a(view, intValue, intValue2);
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B != null && iOAdEvent != null && this.q != null && (data = iOAdEvent.getData()) != null) {
            String str = (String) data.get("uniqueId");
            View view = (View) data.get("expressView");
            int intValue = ((Integer) data.get("error_code")).intValue();
            String str2 = (String) data.get("error_message");
            for (int i = 0; i < this.q.size(); i++) {
                bs bsVar = (bs) this.q.get(i);
                if (TextUtils.equals(bsVar.a(), str)) {
                    bsVar.a(view, str2, intValue);
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f6313a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i = 0; i < this.f6313a.size(); i++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                if (TextUtils.equals(bn.b.C, str2)) {
                    xAdNativeResponse.onShakeViewDismiss();
                } else if (TextUtils.equals("coupon_float_dismiss", str2)) {
                    xAdNativeResponse.onCouponFloatDismiss();
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject l() {
        int aPPConfirmPolicy;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.s);
            jSONObject.put("isCacheVideo", this.t);
            jSONObject.put("cacheVideoOnlyWifi", this.z);
            RequestParameters requestParameters = this.y;
            if (requestParameters == null) {
                aPPConfirmPolicy = 1;
            } else {
                aPPConfirmPolicy = requestParameters.getAPPConfirmPolicy();
            }
            jSONObject.put("appConfirmPolicy", aPPConfirmPolicy);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0076, code lost:
    
        if (com.baidu.mobads.sdk.internal.bw.a(r16.h, r9) != false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00aa  */
    @Override // com.baidu.mobads.sdk.internal.bj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dm.q():void");
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.B = expressAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        String str;
        if (this.B == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str2 = (String) data.get("uniqueId");
        String str3 = (String) data.get("type");
        for (int i = 0; i < this.q.size(); i++) {
            bs bsVar = (bs) this.q.get(i);
            if (TextUtils.equals(bsVar.a(), str2)) {
                if (TextUtils.equals(bn.b.V, str3)) {
                    bsVar.d();
                } else if (TextUtils.equals("click", str3)) {
                    Object obj = data.get("reason");
                    if (obj instanceof String) {
                        str = (String) obj;
                    } else {
                        str = "";
                    }
                    bsVar.a(str);
                } else if (TextUtils.equals("close", str3)) {
                    bsVar.e();
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i = 0;
        if (this.A != null && data != null && this.f6313a != null) {
            String str = (String) data.get("instanceInfo");
            while (i < this.f6313a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.A.a(xAdNativeResponse, Integer.parseInt((String) data.get("showState")));
                }
                i++;
            }
            return;
        }
        if (this.C == null || data == null || this.r == null) {
            return;
        }
        String str2 = (String) data.get("instanceInfo");
        while (i < this.r.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i);
            if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get("showState")));
            }
            i++;
        }
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.C = entryAdListener;
    }

    public void a(f.b bVar) {
        this.D = bVar;
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
    public void b(IOAdEvent iOAdEvent) {
        if (this.D == null || iOAdEvent == null || this.f6313a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i = 0; i < this.f6313a.size(); i++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.D.a(xAdNativeResponse);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f6313a != null) {
            for (int i = 0; i < this.f6313a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && this.q != null) {
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                bs bsVar = (bs) this.q.get(i2);
                if (TextUtils.equals(str, bsVar.a())) {
                    bsVar.f();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.r == null) {
            return;
        }
        for (int i3 = 0; i3 < this.r.size(); i3++) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i3);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    public RequestParameters g() {
        return this.y;
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.w = width;
            this.x = height;
        }
        this.y = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.u);
            this.k.createProdHandler(jSONObject2);
            this.k.setAdContainer(this.g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.u);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.v);
            if (cs.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            if ("video".equals(this.u)) {
                jSONObject.put("at", "10");
                jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.w);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, "" + this.x);
            jSONObject.put("msa", 143);
            jSONObject = k.a(jSONObject, b(this.m));
            jSONObject.put("opt", this.E);
            if (this.E == 0) {
                jSONObject.put("optn", 1);
            }
            b(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.b(i, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNativeFail(i, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i, str);
        }
    }

    public void a(int i) {
        this.E = i;
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.H());
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get(TtmlNode.RUBY_CONTAINER);
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(String str) {
        if (!TextUtils.isEmpty(str) && this.f6313a != null) {
            for (int i = 0; i < this.f6313a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bs bsVar = (bs) this.q.get(i2);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.g();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(String str) {
        if (!TextUtils.isEmpty(str) && this.f6313a != null) {
            for (int i = 0; i < this.f6313a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADFunctionClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bs bsVar = (bs) this.q.get(i2);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.h();
            }
        }
    }

    public String h() {
        return this.v;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f6313a != null) {
            for (int i = 0; i < this.f6313a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bs bsVar = (bs) this.q.get(i2);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.b(z);
            }
        }
    }

    public void c(Map<String, String> map) {
        try {
            HashMap<String, String> a2 = k.a(map);
            if (this.m == null) {
                this.m = new HashMap<>();
            }
            if (a2.isEmpty()) {
                return;
            }
            for (String str : a2.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = a2.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.m.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.H());
            hashMap.put(TtmlNode.RUBY_CONTAINER, viewGroup);
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, hashMap);
    }

    public boolean a(View view, a aVar, int i) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put(ViewHierarchyConstants.VIEW_KEY, view);
            hashMap.put("code", Integer.valueOf(i));
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i, String str) {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.a(i, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNoAd(i, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f6313a != null) {
            for (int i = 0; i < this.f6313a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f6313a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bs bsVar = (bs) this.q.get(i2);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.a(z);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        HashMap<String, String> hashMap2 = new HashMap<>();
        int i = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (hashMap.containsKey(str)) {
                String str2 = (String) hashMap.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i) < 150) {
                    hashMap2.put(str, str2);
                    i = length;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (String str3 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length2 = i + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.m = hashMap2;
    }
}
