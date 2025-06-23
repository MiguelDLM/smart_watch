package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class bj extends Observable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6248a = "b_f";
    public static final String b = "XAbstractProdTemplate";
    public static final String c = "error_message";
    public static final String d = "error_code";
    protected static final String e = "instanceInfo";
    protected static final String f = "showState";
    protected RelativeLayout g;
    protected Context h;
    public HashMap<String, String> m;
    public String n;
    public String o;
    protected bv i = bv.a();
    public IAdInterListener k = null;
    public boolean l = true;
    public int p = -1;
    public IOAdEventListener j = new a();

    /* loaded from: classes7.dex */
    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Object obj;
            if (iOAdEvent != null) {
                String message = iOAdEvent.getMessage();
                if (TextUtils.isEmpty(message) && (data = iOAdEvent.getData()) != null && (obj = data.get("msg")) != null && (obj instanceof String)) {
                    return (String) obj;
                }
                return message;
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            bj.a(new bm(this, iOAdEvent));
        }
    }

    public bj(Context context) {
        this.h = context;
        aa.a().a(this.h, new bk(this));
    }

    public abstract void a();

    public void a(IOAdEvent iOAdEvent) {
    }

    public void b(IOAdEvent iOAdEvent) {
    }

    public void b_() {
    }

    public void c(IOAdEvent iOAdEvent) {
    }

    public void c_() {
    }

    public void d() {
    }

    public void e(IOAdEvent iOAdEvent) {
    }

    public void f(IOAdEvent iOAdEvent) {
    }

    public void g(String str) {
    }

    public void h(IOAdEvent iOAdEvent) {
    }

    public void i(IOAdEvent iOAdEvent) {
    }

    public void j(IOAdEvent iOAdEvent) {
    }

    public void k(IOAdEvent iOAdEvent) {
    }

    public JSONObject l() {
        return new JSONObject();
    }

    public String m() {
        JSONObject k = k();
        JSONObject l = l();
        HashMap hashMap = new HashMap();
        hashMap.put("param_info", k);
        hashMap.put("ad_buss_param", l);
        a("get_request_token", (Map<String, Object>) hashMap);
        Object obj = hashMap.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void n() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.c.h, new c.a());
            this.k.addEventListener(x.I, this.j);
            this.k.addEventListener(x.K, this.j);
            this.k.addEventListener(x.M, this.j);
            this.k.addEventListener(x.N, this.j);
            this.k.addEventListener(x.X, this.j);
            this.k.addEventListener(x.s, this.j);
            this.k.addEventListener(x.Y, this.j);
            this.k.addEventListener(x.t, this.j);
            this.k.addEventListener(x.O, this.j);
            this.k.addEventListener(x.P, this.j);
            this.k.addEventListener(x.L, this.j);
            this.k.addEventListener(x.E, this.j);
            this.k.addEventListener(x.ad, this.j);
            this.k.addEventListener(x.ae, this.j);
            this.k.addEventListener(x.ab, this.j);
            this.k.addEventListener(x.W, this.j);
            this.k.addEventListener(x.af, this.j);
            this.k.addEventListener(x.ag, this.j);
            this.k.addEventListener(x.ah, this.j);
            this.k.addEventListener(x.ai, this.j);
            this.k.addEventListener(x.aj, this.j);
            this.k.addEventListener(x.ak, this.j);
            this.k.addEventListener(x.al, this.j);
            this.k.addEventListener(x.am, this.j);
            this.k.addEventListener(x.ac, this.j);
            this.k.addEventListener(x.an, this.j);
            this.k.addEventListener(x.Z, this.j);
            this.k.addEventListener(x.ao, this.j);
            this.k.addEventListener(x.ap, this.j);
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    public void q() {
    }

    public void r() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public View w() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public void a(String str, boolean z) {
    }

    public void b(String str, boolean z) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding id is empty", 2);
        }
        if (this.k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bid_id", str);
            a("load_bidding_ad", (Map<String, Object>) hashMap);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    public void d(IOAdEvent iOAdEvent) {
    }

    public void e(String str) {
    }

    public void f(String str) {
    }

    public void g(IOAdEvent iOAdEvent) {
        r();
    }

    public void h(String str) {
        this.o = str;
    }

    public void i() {
        this.k = (IAdInterListener) av.a(x.k, bu.a(this.h), (Class<?>[]) new Class[]{Context.class}, this.h);
        if (this.l) {
            return;
        }
        a();
    }

    public void j() {
        b("SDK未初始化", 1);
    }

    public JSONObject k() {
        return new JSONObject();
    }

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    public void b(boolean z) {
    }

    public void d(String str) {
    }

    public void e() {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    public void a(Activity activity) {
        if (this.k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.k.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), hashMap);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding data is empty", 2);
        }
        if (this.k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bidding_data", str);
            a("load_bidding_data", (Map<String, Object>) hashMap);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    public String i(String str) {
        IXAdContainerFactory c2;
        aa a2 = aa.a();
        if (a2 != null && (c2 = a2.c()) != null) {
            Object remoteParam = c2.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    public void b(int i) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i);
        }
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(String str, int i) {
        r();
    }

    public JSONObject b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (!map.isEmpty()) {
            try {
            } catch (Exception unused) {
                return null;
            }
        }
        return new JSONObject(map);
    }

    public void b(JSONObject jSONObject) {
        int i = this.p;
        if (i < 0 || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(f6248a, i);
        } catch (Throwable th) {
            this.i.a(th);
        }
    }

    public void a(String str, boolean z, String str2) {
        a(str, z, str2, null);
    }

    public void a(String str, boolean z, String str2, LinkedHashMap<String, Object> linkedHashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put("result", z);
            jSONObject.put("replacement", str2);
            if (linkedHashMap != null) {
                try {
                    for (Map.Entry<String, Object> entry : linkedHashMap.entrySet()) {
                        jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                } catch (Throwable th) {
                    az.f(th.getMessage());
                }
            }
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.k;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void a(int i, String str) {
        r();
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new bl(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.m = (HashMap) map;
    }

    private String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }
}
