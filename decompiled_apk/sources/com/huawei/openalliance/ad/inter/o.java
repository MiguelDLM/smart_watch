package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.cy;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.iy;
import com.huawei.openalliance.ad.beans.inner.PlacementAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.Video;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.ah;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ad;
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
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class o {
    private com.huawei.openalliance.ad.inter.listeners.p B;
    private int C;
    private boolean D;
    private int F;
    private Context I;
    private boolean L;
    private String S;
    private b V;
    private final String[] Z;

    /* renamed from: a, reason: collision with root package name */
    private RequestOptions f17399a;
    private Location b;
    private String c;
    private long d;
    private long e;
    private long f;
    private int g;
    private String h;
    private String i;
    private Set<String> j;
    private Integer k;
    private String l;

    /* loaded from: classes10.dex */
    public static final class a {
        private int B;
        private boolean C;
        private Context Code;
        private Location D;
        private RequestOptions F;
        private int I = 4;
        private Integer L;
        private boolean S;
        private String[] V;
        private String Z;

        /* renamed from: a, reason: collision with root package name */
        private String f17400a;

        public a(Context context) {
            this.Code = context.getApplicationContext();
        }

        public int B() {
            return this.B;
        }

        public boolean C() {
            return this.C;
        }

        public Context F() {
            return this.Code;
        }

        public int I() {
            return this.I;
        }

        public boolean S() {
            return this.S;
        }

        public a Code(int i) {
            this.I = i;
            return this;
        }

        public a V(boolean z) {
            this.S = z;
            return this;
        }

        public String Z() {
            return this.Z;
        }

        public a Code(Location location) {
            this.D = location;
            return this;
        }

        public String[] V() {
            String[] strArr = this.V;
            return strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : new String[0];
        }

        public a Code(RequestOptions requestOptions) {
            this.F = requestOptions;
            return this;
        }

        public a Code(Integer num) {
            this.L = num;
            return this;
        }

        public a Code(String str) {
            this.Z = str;
            return this;
        }

        public a Code(boolean z) {
            this.C = z;
            return this;
        }

        public a Code(String[] strArr) {
            if (strArr != null) {
                this.V = (String[]) Arrays.copyOf(strArr, strArr.length);
            } else {
                this.V = null;
            }
            return this;
        }

        public o Code() {
            return new o(this);
        }
    }

    /* loaded from: classes10.dex */
    public enum b {
        IDLE,
        LOADING
    }

    private o(a aVar) {
        this.V = b.IDLE;
        if (!w.Code(aVar.Code)) {
            this.Z = new String[0];
            return;
        }
        this.I = aVar.F();
        String[] V = aVar.V();
        if (ad.Code(V)) {
            this.Z = new String[0];
        } else {
            String[] strArr = new String[V.length];
            this.Z = strArr;
            System.arraycopy(V, 0, strArr, 0, V.length);
        }
        this.C = aVar.I();
        this.S = aVar.Z();
        this.F = aVar.B();
        this.D = aVar.C();
        this.L = aVar.S();
        this.b = aVar.D;
        this.f17399a = aVar.F;
        this.k = aVar.L;
        this.l = aVar.f17400a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(final int i) {
        fb.V("PlacementAdLoader", "onAdFailed, errorCode:" + i);
        if (this.B != null) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.o.4
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.inter.listeners.p pVar = o.this.B;
                    o.this.e = System.currentTimeMillis();
                    if (pVar != null) {
                        pVar.I(i);
                    }
                    cy.Code(o.this.I, i, o.this.c, 60, null, o.this.d, o.this.e, o.this.f);
                }
            });
        }
    }

    private boolean Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            fb.I("PlacementAdLoader", "extra info is not json string");
            return false;
        }
    }

    public void I(String str) {
        this.i = str;
    }

    public void V(int i) {
        this.g = i;
    }

    public void V(String str) {
        this.h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(AdSlotParam.a aVar, PlacementAdReqParam placementAdReqParam) {
        iy.Code(this.I, "reqPlaceAd", aVar.S(), aa.V(placementAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.o.2
            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                o oVar;
                int code;
                o.this.f = System.currentTimeMillis();
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
                                    if (o.this.c == null) {
                                        o.this.c = adContentData.M();
                                    }
                                    arrayList.add(new n(adContentData));
                                }
                                hashMap.put(str2, arrayList);
                            }
                        }
                        if (!ai.Code(hashMap)) {
                            o.this.Code(hashMap);
                            o.this.V = b.IDLE;
                        }
                    }
                    oVar = o.this;
                } else {
                    oVar = o.this;
                    code = callResult.getCode();
                }
                oVar.I(code);
                o.this.V = b.IDLE;
            }
        }, String.class);
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.p pVar) {
        this.B = pVar;
        Code(false, 300, 1);
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.p pVar, int i) {
        Code(pVar, i, 0);
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.p pVar, int i, int i2) {
        this.B = pVar;
        Code(false, i, i2);
    }

    public void Code(String str) {
        this.l = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<com.huawei.openalliance.ad.inter.data.h>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map == null ? 0 : map.size());
        fb.V("PlacementAdLoader", sb.toString());
        if (this.B != null) {
            bf.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.o.3
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.inter.listeners.p pVar = o.this.B;
                    o.this.e = System.currentTimeMillis();
                    if (pVar != null) {
                        pVar.Code(map);
                    }
                    cy.Code(o.this.I, 200, o.this.c, 60, map, o.this.d, o.this.e, o.this.f);
                }
            });
        }
    }

    public void Code(Set<String> set) {
        this.j = set;
    }

    private void Code(boolean z, int i, int i2) {
        this.d = w.Code();
        fb.V("PlacementAdLoader", "loadAds");
        if (!w.Code(this.I)) {
            fb.I("PlacementAdLoader", "api level too low");
            I(1001);
            return;
        }
        if (!Z(this.S)) {
            fb.I("PlacementAdLoader", "extra info is invalid");
            I(ah.Y);
            return;
        }
        b bVar = b.LOADING;
        if (bVar == this.V) {
            fb.V("PlacementAdLoader", "waiting for request finish");
            I(ah.W);
            return;
        }
        String[] strArr = this.Z;
        if (strArr == null || strArr.length == 0) {
            fb.I("PlacementAdLoader", "empty ad ids");
            I(ah.X);
            return;
        }
        if (i <= 0) {
            fb.I("PlacementAdLoader", "invalid totalDuration.");
            I(ah.Y);
            return;
        }
        if (i2 < 0) {
            fb.I("PlacementAdLoader", "invalid maxCount");
            I(ah.Y);
            return;
        }
        this.V = bVar;
        af.Code(this.I, this.f17399a);
        Video video = new Video(this.F);
        final AdSlotParam.a aVar = new AdSlotParam.a();
        aVar.Code(Arrays.asList(this.Z)).V(this.C).Code(Boolean.valueOf(z)).Code(1).I(com.huawei.openalliance.ad.utils.d.Z(this.I)).Z(com.huawei.openalliance.ad.utils.d.B(this.I)).Code(this.D).Code(com.huawei.hms.ads.utils.c.Code(this.f17399a)).Code(this.b).B(i2).D(i).C(this.l).Code(video);
        Integer num = this.k;
        if (num != null) {
            aVar.S(num);
        }
        final PlacementAdReqParam placementAdReqParam = new PlacementAdReqParam();
        placementAdReqParam.Code(this.S);
        placementAdReqParam.Code(this.L);
        placementAdReqParam.Code(this.d);
        com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.openalliance.ad.inter.o.1
            @Override // java.lang.Runnable
            public void run() {
                o.this.Code(aVar, placementAdReqParam);
            }
        });
    }
}
