package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.iy;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.q;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.af;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes10.dex */
public class p {
    private q B;
    private RequestOptions C;
    private String D;
    private int F;
    private final String[] I;
    private String L;
    private Location S;
    private Context V;
    private a Z = a.IDLE;

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f17401a;
    private String b;
    private long c;
    private long d;
    private long e;
    private App f;
    private Integer g;
    private String h;

    /* loaded from: classes10.dex */
    public enum a {
        IDLE,
        LOADING
    }

    public p(Context context, String[] strArr) {
        if (!w.Code(context)) {
            this.I = new String[0];
            return;
        }
        this.V = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.I = new String[0];
            return;
        }
        String[] strArr2 = new String[strArr.length];
        this.I = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
    }

    public void I(String str) {
        this.L = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(final int i) {
        fb.V("RewardAdLoader", "onAdFailed, errorCode:" + i);
        if (this.B == null) {
            return;
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.p.3
            @Override // java.lang.Runnable
            public void run() {
                q qVar = p.this.B;
                p.this.d = System.currentTimeMillis();
                if (qVar != null) {
                    qVar.Code(i);
                }
                cy.Code(p.this.V, i, p.this.b, 7, null, p.this.c, p.this.d, p.this.e);
            }
        });
    }

    public void V(String str) {
        this.D = str;
    }

    public void Code(int i) {
        this.F = i;
    }

    public void Code(int i, boolean z) {
        this.c = w.Code();
        fb.V("RewardAdLoader", "loadAds");
        if (!w.Code(this.V)) {
            V(1001);
            return;
        }
        a aVar = a.LOADING;
        if (aVar == this.Z) {
            fb.V("RewardAdLoader", "waiting for request finish");
            V(901);
            return;
        }
        String[] strArr = this.I;
        if (strArr == null || strArr.length == 0) {
            fb.I("RewardAdLoader", "empty ad ids");
            V(902);
            return;
        }
        if (this.f != null && !w.I(this.V)) {
            fb.I("RewardAdLoader", "hms ver not support set appInfo.");
            V(706);
            return;
        }
        af.Code(this.V, this.C);
        this.Z = aVar;
        AdSlotParam.a aVar2 = new AdSlotParam.a();
        aVar2.Code(Arrays.asList(this.I)).V(i).Code(1).I(com.huawei.openalliance.ad.utils.d.Z(this.V)).Z(com.huawei.openalliance.ad.utils.d.B(this.V)).Code(this.S).Code(com.huawei.hms.ads.utils.c.Code(this.C)).Code(z).S(this.F).V(this.D).Code(this.f17401a).Code(this.f).I(this.L).C(this.h);
        Integer num = this.g;
        if (num != null) {
            aVar2.S(num);
        }
        BaseAdReqParam baseAdReqParam = new BaseAdReqParam();
        baseAdReqParam.Code(this.c);
        iy.Code(this.V, "reqRewardAd", aVar2.S(), aa.V(baseAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.p.1
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                p pVar;
                int code;
                p.this.e = System.currentTimeMillis();
                if (callResult.getCode() == 200) {
                    Map map = (Map) aa.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                    code = 204;
                    if (map != null && map.size() > 0) {
                        HashMap hashMap = new HashMap(map.size());
                        for (Map.Entry entry : map.entrySet()) {
                            String str2 = (String) entry.getKey();
                            List<AdContentData> list = (List) entry.getValue();
                            if (list != null) {
                                ArrayList arrayList = new ArrayList(list.size());
                                for (AdContentData adContentData : list) {
                                    if (p.this.b == null) {
                                        p.this.b = adContentData.M();
                                    }
                                    arrayList.add(new com.huawei.openalliance.ad.inter.data.q(adContentData));
                                }
                                hashMap.put(str2, arrayList);
                            }
                        }
                        if (!ai.Code(hashMap)) {
                            p.this.Code(hashMap);
                            p.this.Z = a.IDLE;
                        }
                    }
                    pVar = p.this;
                } else {
                    pVar = p.this;
                    code = callResult.getCode();
                }
                pVar.V(code);
                p.this.Z = a.IDLE;
            }
        }, String.class);
    }

    public void Code(Location location) {
        this.S = location;
    }

    public void Code(RequestOptions requestOptions) {
        this.C = requestOptions;
        App app = requestOptions.getApp();
        if (app != null) {
            this.f = app;
        }
    }

    public void Code(q qVar) {
        this.B = qVar;
    }

    public void Code(Integer num) {
        this.g = num;
    }

    public void Code(String str) {
        this.h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.i>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map != null ? Integer.valueOf(map.size()) : null);
        sb.append(", listener:");
        sb.append(this.B);
        fb.V("RewardAdLoader", sb.toString());
        if (this.B == null) {
            return;
        }
        bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.p.2
            @Override // java.lang.Runnable
            public void run() {
                q qVar = p.this.B;
                p.this.d = System.currentTimeMillis();
                if (qVar != null) {
                    qVar.Code(map);
                }
                cy.Code(p.this.V, 200, p.this.b, 7, map, p.this.c, p.this.d, p.this.e);
            }
        });
    }

    public void Code(Set<String> set) {
        this.f17401a = set;
    }
}
