package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import com.huawei.hms.ads.App;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.iy;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.beans.inner.NativeAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.l;
import com.huawei.openalliance.ad.inter.listeners.j;
import com.huawei.openalliance.ad.inter.listeners.n;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.af;
import com.huawei.openalliance.ad.utils.bf;
import com.huawei.openalliance.ad.utils.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes10.dex */
public class m implements i {
    private static final String V = "m";
    private String A;
    private a B;
    private final String[] C;
    boolean Code;
    private String D;
    private DelayInfo E;
    private j F;
    private List<String> I;
    private boolean L;
    private n S;
    private com.huawei.openalliance.ad.inter.listeners.e Z;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17398a;
    private boolean b;
    private boolean c;
    private String d;
    private Context e;
    private int f;
    private RequestOptions g;
    private Location h;
    private Integer i;
    private int j;
    private String k;
    private String l;
    private Set<String> m;
    private int n;
    private Integer o;
    private Integer p;
    private Integer q;
    private NativeAdConfiguration r;
    private String s;
    private long t;
    private long u;
    private long v;
    private String w;
    private App x;
    private List<Integer> y;
    private Integer z;

    /* loaded from: classes10.dex */
    public enum a {
        IDLE,
        LOADING
    }

    public m(Context context, String[] strArr, int i) {
        this(context, strArr, false);
        this.f = i;
    }

    public m(Context context, String[] strArr, int i, List<String> list) {
        this(context, strArr, false);
        this.f = i;
        this.I = list;
    }

    public void B(Integer num) {
        this.z = num;
        this.E.I(num);
    }

    public void C(String str) {
        fb.V(V, "setJssdkVersion: %s", str);
        this.d = str;
    }

    public void I(int i) {
        this.f = i;
    }

    public m(Context context, String[] strArr, boolean z) {
        this.B = a.IDLE;
        this.c = false;
        this.f = 3;
        this.E = new DelayInfo();
        if (!w.Code(context)) {
            this.C = new String[0];
            return;
        }
        this.e = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.C = new String[0];
        } else {
            String[] strArr2 = new String[strArr.length];
            this.C = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        this.L = z;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void I(Integer num) {
        this.q = num;
    }

    public void V(int i) {
        this.n = i;
    }

    public void Z(Integer num) {
        this.i = num;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void I(String str) {
        this.l = str;
    }

    public void V(final int i, final boolean z) {
        String str = V;
        fb.V(str, "onAdFailed, errorCode:" + i);
        final long currentTimeMillis = System.currentTimeMillis();
        this.E.j().D(currentTimeMillis);
        if (!this.Code) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.m.5
                @Override // java.lang.Runnable
                public void run() {
                    n nVar = m.this.S;
                    m.this.u = System.currentTimeMillis();
                    m.this.E.j().V(m.this.u);
                    long j = m.this.u - currentTimeMillis;
                    m.this.E.D(j);
                    fb.V(m.V, "onAdFailed main thread switch: %s ms", Long.valueOf(j));
                    if (nVar != null) {
                        nVar.Code(i);
                    }
                    j jVar = m.this.F;
                    if (jVar != null) {
                        jVar.Code(i, z);
                    }
                    cy.Code(m.this.e, i, m.this.w, m.this.f, null, m.this.u - m.this.t, m.this.E);
                }
            });
            return;
        }
        fb.V(str, "onAdFailed thread");
        n nVar = this.S;
        if (nVar != null) {
            nVar.Code(i);
        }
        j jVar = this.F;
        if (jVar != null) {
            jVar.Code(i, z);
        }
        cy.Code(this.e, i, this.w, this.f, null, this.t, currentTimeMillis, this.v);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Z(String str) {
        this.A = str;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(int i) {
        this.j = i;
    }

    public void I(boolean z) {
        this.Code = z;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void V(Integer num) {
        this.p = num;
    }

    public void Z(boolean z) {
        fb.V(V, "setSupportTptAd: %s", Boolean.valueOf(z));
        this.c = z;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(int i, String str, boolean z) {
        this.t = System.currentTimeMillis();
        this.E.j().Code(this.t);
        String str2 = V;
        fb.V(str2, "loadAds");
        if (!w.Code(this.e)) {
            V(1001, true);
            return;
        }
        a aVar = a.LOADING;
        if (aVar == this.B) {
            fb.V(str2, "waiting for request finish");
            V(701, true);
            return;
        }
        String[] strArr = this.C;
        if (strArr == null || strArr.length == 0) {
            fb.I(str2, "empty ad ids");
            V(702, true);
            return;
        }
        if (this.x != null && !w.I(this.e)) {
            fb.I(str2, "hms ver not support set appInfo.");
            V(706, true);
            return;
        }
        af.Code(this.e, this.g);
        this.B = aVar;
        final AdSlotParam.a aVar2 = new AdSlotParam.a();
        aVar2.Code(Arrays.asList(this.C)).V(i).Code(str).Code(1).I(com.huawei.openalliance.ad.utils.d.Z(this.e)).Z(com.huawei.openalliance.ad.utils.d.B(this.e)).Code(z).Code(com.huawei.hms.ads.utils.c.Code(this.g)).Code(this.h).C(this.f).S(this.j).V(this.k).B(this.n).Code(this.m).I(this.l).Code(this.o).Code(this.x).C(this.i).Z(this.s).V(this.y).C(this.A).Z(this.c);
        Integer num = this.p;
        if (num != null && this.q != null) {
            aVar2.V(num);
            aVar2.I(this.q);
        }
        Integer num2 = this.z;
        if (num2 != null) {
            aVar2.S(num2);
        }
        if (this.r != null) {
            aVar2.V(!r11.isReturnUrlsForImages());
            aVar2.I(this.r.isRequestMultiImages());
        }
        String str3 = this.d;
        if (str3 != null) {
            aVar2.S(str3);
        }
        final NativeAdReqParam nativeAdReqParam = new NativeAdReqParam();
        nativeAdReqParam.Code(this.D);
        nativeAdReqParam.V(this.f17398a);
        nativeAdReqParam.Code(this.L);
        nativeAdReqParam.I(this.b);
        nativeAdReqParam.Code(this.I);
        nativeAdReqParam.Code(this.t);
        final long currentTimeMillis = System.currentTimeMillis();
        com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.m.1
            @Override // java.lang.Runnable
            public void run() {
                m.this.E.Z(System.currentTimeMillis() - currentTimeMillis);
                m.this.Code(aVar2, nativeAdReqParam);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void V(String str) {
        this.k = str;
    }

    public void Code(int i, boolean z) {
        Code(i, (String) null, z);
    }

    public void V(boolean z) {
        this.b = z;
    }

    public void Code(Location location) {
        this.h = location;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(RequestOptions requestOptions) {
        this.g = requestOptions;
        App app = requestOptions.getApp();
        if (app != null) {
            this.x = app;
        }
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.r = nativeAdConfiguration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdSlotParam.a aVar, NativeAdReqParam nativeAdReqParam) {
        iy.Code(this.e.getApplicationContext(), "reqNativeAd", aVar.S(), aa.V(nativeAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.m.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                m.this.v = System.currentTimeMillis();
                m.this.E.j().c(m.this.v);
                boolean z = false;
                if (callResult.getCode() == 200) {
                    Map map = (Map) aa.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                    if (map == null || map.size() <= 0) {
                        m.this.V(204, true);
                    } else {
                        HashMap hashMap = new HashMap(map.size());
                        boolean z2 = false;
                        for (Map.Entry entry : map.entrySet()) {
                            String str2 = (String) entry.getKey();
                            List<AdContentData> list = (List) entry.getValue();
                            if (list != null) {
                                ArrayList arrayList = new ArrayList(list.size());
                                for (AdContentData adContentData : list) {
                                    if (m.this.w == null) {
                                        m.this.w = adContentData.M();
                                    }
                                    if (com.huawei.openalliance.ad.utils.c.Code(m.this.e, adContentData.aU(), adContentData.L(), adContentData.Z())) {
                                        fb.Code(m.V, "set creativeType to %s", 99);
                                        adContentData.a(99);
                                    }
                                    l lVar = new l(adContentData);
                                    lVar.Code(m.this.r);
                                    arrayList.add(lVar);
                                    if (!z2) {
                                        z2 = adContentData.af();
                                    }
                                }
                                hashMap.put(str2, arrayList);
                            }
                        }
                        m.this.Code(hashMap, z2);
                        z = z2;
                    }
                } else if (callResult.getCode() == 602) {
                    List<String> list2 = (List) aa.V(callResult.getMsg(), List.class, new Class[0]);
                    if (m.this.Z != null && list2 != null) {
                        fb.Code(m.V, "InValidContentIdsGot: %s", list2.toString());
                        m.this.Z.Code(list2);
                    }
                } else {
                    z = Boolean.valueOf(callResult.getMsg()).booleanValue();
                    if (-10 != callResult.getCode()) {
                        m.this.V(callResult.getCode(), z);
                    }
                }
                if (z) {
                    m.this.B = a.IDLE;
                }
            }
        }, String.class);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(com.huawei.openalliance.ad.inter.listeners.e eVar) {
        this.Z = eVar;
    }

    public void Code(j jVar) {
        this.F = jVar;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(n nVar) {
        this.S = nVar;
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(Integer num) {
        this.o = num;
    }

    public void Code(String str) {
        this.D = str;
    }

    public void Code(List<Integer> list) {
        this.y = list;
    }

    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map, final boolean z) {
        String str = V;
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map != null ? Integer.valueOf(map.size()) : null);
        sb.append(", listener:");
        sb.append(this.S);
        sb.append(" innerlistener: ");
        sb.append(this.F);
        fb.V(str, sb.toString());
        final long currentTimeMillis = System.currentTimeMillis();
        this.E.j().D(currentTimeMillis);
        if (!this.Code) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.m.3
                @Override // java.lang.Runnable
                public void run() {
                    n nVar = m.this.S;
                    m.this.u = System.currentTimeMillis();
                    m.this.E.j().V(m.this.u);
                    long j = m.this.u - currentTimeMillis;
                    m.this.E.D(j);
                    fb.V(m.V, "onAdsLoaded main thread switch: %s ms", Long.valueOf(j));
                    if (nVar != null) {
                        nVar.Code(map);
                    }
                    j jVar = m.this.F;
                    if (jVar != null) {
                        jVar.Code(map, z);
                    }
                    cy.Code(m.this.e, 200, m.this.w, m.this.f, map, m.this.u - m.this.t, m.this.E);
                }
            });
            return;
        }
        this.E.L(currentTimeMillis);
        fb.V(str, "onAdsLoaded thread");
        n nVar = this.S;
        if (nVar != null) {
            nVar.Code(map);
        }
        j jVar = this.F;
        if (jVar != null) {
            jVar.Code(map, z);
        }
        cy.Code(this.e, 200, this.w, this.f, map, this.t, currentTimeMillis, this.v);
    }

    @Override // com.huawei.openalliance.ad.inter.i
    public void Code(Set<String> set) {
        this.m = set;
    }

    public void Code(boolean z) {
        this.f17398a = z;
    }
}
