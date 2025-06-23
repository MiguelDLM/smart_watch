package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ae extends bj {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6219a = 17;
    private static final String q = "javascript:";
    private int A;
    private boolean B;
    private String C;
    private int r;
    private int s;
    private int[] t;
    private boolean u;
    private int v;
    private HashMap<String, Object> w;
    private NativeCPUManager.CPUAdListener x;
    private NativeCPUManager y;
    private int z;

    public ae(Context context) {
        super(context);
        this.z = 5;
        this.A = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                ao.a(((Integer) obj).intValue());
                ao.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                ao.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                ao.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                ao.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    private String j(String str) {
        IXAdContainerFactory c;
        aa a2 = aa.a();
        if (a2 != null && (c = a2.c()) != null) {
            Object remoteParam = c.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ao.b();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    public void f() {
        ao.a(this.z);
        ao.b(this.A);
        ao.a(new aj(this));
    }

    public Activity g() {
        return ao.c();
    }

    public boolean h() {
        return ao.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
        super.b(str, i);
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.x = cPUAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void d(IOAdEvent iOAdEvent) {
        try {
            if (this.x == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            this.x.onLpCustomEventCallBack(hashMap, new ah(this, hashMap.get(TTDownloadField.TT_ACTIVITY)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ae(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.z = 5;
        this.A = 60;
        this.o = str;
        this.y = nativeCPUManager;
    }

    public void a(int i, int i2, int[] iArr, boolean z, HashMap<String, Object> hashMap) {
        this.s = i;
        this.r = i2;
        this.t = iArr;
        this.u = z;
        this.w = hashMap;
        this.B = ao.f();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_CPU);
            this.k.createProdHandler(jSONObject3);
            n();
            this.k.addEventListener("Update_fbReader_Setting", new af(this));
            this.k.addEventListener("closeInterstitialAd", new ag(this));
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_CPU);
            jSONObject.put("appsid", this.o);
            jSONObject.put("pageIndex", this.s);
            jSONObject.put("pageSize", this.r);
            jSONObject.put("channels", this.t);
            jSONObject.put("showAd", this.u);
            jSONObject.put("openActivitylink", this.C);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            jSONObject2.put("timeout", this.v);
            HashMap<String, Object> hashMap = this.w;
            if (hashMap == null || hashMap.isEmpty()) {
                az.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            jSONObject2 = k.a(this.w);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.B);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get(RequestParameters.POSITION);
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.x;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    public void a(int i) {
        this.v = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        if (this.x != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) iOAdEvent.getData().get("cpuAdList")).iterator();
            while (it.hasNext()) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.h, it.next(), this.w);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.x.onAdLoaded(arrayList);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i, String str) {
        super.a(i, str);
        NativeCPUManager.CPUAdListener cPUAdListener = this.x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    public void a(WebView webView, JSONObject jSONObject) {
        bj.a(new ai(this, jSONObject, webView));
    }

    public void a(String str) {
        this.C = str;
    }
}
