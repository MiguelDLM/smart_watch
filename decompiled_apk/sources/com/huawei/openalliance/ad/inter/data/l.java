package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.DefaultTemplate;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.jb;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.jp;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.beans.metadata.ContentExt;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class l extends c implements g {
    private boolean B;
    private String C;
    private ImageInfo D;
    private List<ImageInfo> L;
    private String S;

    /* renamed from: a, reason: collision with root package name */
    private VideoInfo f17395a;
    private List<String> b;
    private List<String> c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private String h;
    private NativeAdConfiguration i;

    @com.huawei.openalliance.ad.annotations.d
    private long j;
    private String k;
    private Integer l;
    private String m;
    private String n;
    private transient VideoConfiguration q;
    private MaterialClickInfo r;

    public l(AdContentData adContentData) {
        super(adContentData);
        this.B = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 0;
        this.l = Integer.valueOf(adContentData.aF());
        this.m = adContentData.aE();
    }

    private void F(Context context, Bundle bundle) {
        fb.V("INativeAd", "api adShow called.");
        jc.V(context, n(), new jb.a().Z(ay.Code(bundle)).Code(Long.valueOf(Math.min(System.currentTimeMillis() - this.j, u()))).Code(Integer.valueOf(v())).V((Integer) 7).Code(jp.Code(bundle)).B(jp.V(bundle)).I(com.huawei.openalliance.ad.utils.b.Code(context)).Code());
    }

    private void S(Context context, Bundle bundle) {
        fb.V("INativeAd", "api report adShowStart event.");
        jc.Code(context, n(), ay.Code(bundle));
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<ImageInfo> B() {
        MetaData i_;
        if (this.L == null && (i_ = i_()) != null) {
            this.L = c.Code(i_.d());
        }
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public VideoInfo C() {
        AdContentData adContentData = this.Code;
        if (adContentData == null || adContentData.t() == null) {
            return null;
        }
        if (this.f17395a == null) {
            VideoInfo videoInfo = new VideoInfo(this.Code.t());
            this.f17395a = videoInfo;
            videoInfo.Code(this.Code.H());
        }
        return this.f17395a;
    }

    public String Code() {
        MetaData i_;
        if (this.C == null && (i_ = i_()) != null) {
            this.C = ay.V(i_.Z());
        }
        return this.C;
    }

    public List<AdvertiserInfo> G() {
        if (this.Code == null || !f_()) {
            return null;
        }
        return this.Code.aL();
    }

    public void I(boolean z) {
        this.e = z;
    }

    public MaterialClickInfo K() {
        return this.r;
    }

    public MaterialClickInfo V(Bundle bundle) {
        JSONObject V = ay.V(bundle);
        int optInt = V.optInt(bb.al, -111111);
        Integer valueOf = Integer.valueOf(optInt);
        int optInt2 = V.optInt(bb.am, -111111);
        Integer valueOf2 = Integer.valueOf(optInt2);
        String optString = V.optString(bb.an, "");
        Float Code = ay.Code(V.optString(bb.ar, "-111111"), Float.valueOf(-111111.0f));
        int optInt3 = V.optInt(bb.ap, -111111);
        Integer valueOf3 = Integer.valueOf(optInt3);
        int optInt4 = V.optInt(bb.aq, -111111);
        Integer valueOf4 = Integer.valueOf(optInt4);
        int optInt5 = V.optInt(bb.ao, -111111);
        Integer valueOf5 = Integer.valueOf(optInt5);
        long optLong = V.optLong(bb.aR);
        Long valueOf6 = Long.valueOf(optLong);
        long optLong2 = V.optLong(bb.aS);
        Long valueOf7 = Long.valueOf(optLong2);
        String optString2 = V.optString(bb.aT, "");
        if (optInt == -111111) {
            valueOf = null;
        }
        if (optInt2 == -111111) {
            valueOf2 = null;
        }
        if (!ay.L(optString)) {
            optString = null;
        }
        if (Code.floatValue() == -111111.0f) {
            Code = null;
        }
        if (optInt3 == -111111) {
            valueOf3 = null;
        }
        if (optInt4 == -111111) {
            valueOf4 = null;
        }
        if (optInt5 == -111111) {
            valueOf5 = null;
        }
        if (optLong == 0) {
            valueOf6 = null;
        }
        Long l = optLong2 == 0 ? null : valueOf7;
        if (ay.Code(optString2)) {
            optString2 = null;
        }
        return new MaterialClickInfo.a().Code(valueOf).V(valueOf2).V(optString).Code(Code).I(valueOf5).Z(valueOf3).B(valueOf4).V(valueOf6).Code(l).Z(optString2).Code();
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public ImageInfo Z() {
        MetaData i_;
        List<com.huawei.openalliance.ad.beans.metadata.ImageInfo> S;
        if (this.D == null && (i_ = i_()) != null && (S = i_.S()) != null && !S.isEmpty()) {
            this.D = new ImageInfo(S.get(0));
        }
        return this.D;
    }

    public DefaultTemplate aA() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aU();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public PromoteInfo ad() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.z();
        }
        return null;
    }

    public VideoInfo af() {
        return this.f17395a;
    }

    public boolean ag() {
        return this.d;
    }

    public boolean ah() {
        return this.e;
    }

    public boolean ai() {
        return this.f;
    }

    public String aj() {
        MetaData i_ = i_();
        return i_ != null ? i_.a() : "";
    }

    public String ak() {
        return e();
    }

    public Double al() {
        return null;
    }

    public String am() {
        return null;
    }

    public String an() {
        return null;
    }

    public Bundle ao() {
        return new Bundle();
    }

    public void ap() {
    }

    public NativeAdConfiguration aq() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Map<java.lang.String, java.lang.String> ar() {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.inter.data.l.ar():java.util.Map");
    }

    public String as() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aE();
        }
        return null;
    }

    public Integer av() {
        return this.l;
    }

    public int aw() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            this.g = adContentData.J();
        }
        return this.g;
    }

    public String ax() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.ao();
        }
        return null;
    }

    public String ay() {
        return this.k;
    }

    public String az() {
        return this.n;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public boolean d_() {
        AdContentData adContentData = this.Code;
        return adContentData != null && adContentData.al() == 1;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<FeedbackInfo> e_() {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            return adContentData.aC();
        }
        return null;
    }

    public boolean f_() {
        if (this.Code != null) {
            return !ad.Code(r0.aL());
        }
        return false;
    }

    public VideoConfiguration h_() {
        return this.q;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<String> m() {
        AdContentData adContentData;
        List<String> o;
        if (this.b == null && (adContentData = this.Code) != null && (o = adContentData.o()) != null && o.size() > 0) {
            this.b = o;
        }
        return this.b;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<String> p() {
        AdContentData adContentData;
        if (this.c == null && (adContentData = this.Code) != null) {
            List<String> W = adContentData.W();
            if (!ad.Code(W) && W.size() > 0) {
                this.c = W;
            }
        }
        return this.c;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String r() {
        return this.h;
    }

    public Map<String, String> s() {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return null;
        }
        List<ImpEX> ay = adContentData.ay();
        List<ContentExt> az = this.Code.az();
        HashMap hashMap = new HashMap();
        if (!ad.Code(az)) {
            for (ContentExt contentExt : az) {
                hashMap.put(contentExt.Code(), ay.V(contentExt.V()));
            }
        }
        if (!ad.Code(ay)) {
            for (ImpEX impEX : ay) {
                hashMap.put(impEX.Code(), ay.V(impEX.V()));
            }
        }
        return hashMap;
    }

    public void B(String str) {
        this.h = str;
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.I(str);
        }
    }

    public void C(String str) {
        this.k = str;
    }

    public void Code(Context context, MaterialClickInfo materialClickInfo) {
        cj.Code(context, this.Code, materialClickInfo);
    }

    public boolean I(Context context, Bundle bundle) {
        if (context == null || !A()) {
            fb.V("INativeAd", "record click event failed.");
            return false;
        }
        Code(context, v.D, bundle);
        return true;
    }

    public void S(String str) {
        this.n = str;
    }

    public String V() {
        MetaData S;
        if (this.S == null && (S = this.Code.S()) != null) {
            this.S = ay.V(S.B());
        }
        return this.S;
    }

    public boolean Z(Context context, Bundle bundle) {
        return C(context, bundle);
    }

    private void Code(Context context, String str, Bundle bundle) {
        fb.V("INativeAd", "api report click event.");
        MaterialClickInfo V = V(bundle);
        if (V.L() == null && V.D() == null) {
            V.B(1);
        }
        jc.Code(context, n(), ay.Code(bundle), 0, 0, str, 12, com.huawei.openalliance.ad.utils.b.Code(context), V);
    }

    public boolean B(Context context, Bundle bundle) {
        if (context == null) {
            return false;
        }
        Code(true);
        com.huawei.openalliance.ad.uriaction.p Code = com.huawei.openalliance.ad.uriaction.q.Code(context, n(), ar());
        boolean Code2 = Code.Code();
        if (Code2) {
            Code(context, Code.I(), bundle);
        }
        return Code2;
    }

    public void C(boolean z) {
        this.f = z;
    }

    public void V(long j) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.Z(j);
        }
    }

    private boolean C(Context context, Bundle bundle) {
        if (context == null || !A()) {
            return false;
        }
        return B(context, bundle);
    }

    public void Code(Context context, List<String> list) {
        if (context == null || !A()) {
            return;
        }
        new com.huawei.hms.ads.h(context, this).Code(list);
    }

    public void V(Context context) {
        cj.Code(context, this.Code, (MaterialClickInfo) null);
    }

    public void Code(Bundle bundle) {
    }

    public void V(List<ImageInfo> list) {
        this.L = list;
    }

    public void Code(VideoConfiguration videoConfiguration) {
        this.q = videoConfiguration;
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.Code(videoConfiguration);
        }
    }

    public void V(boolean z) {
        this.d = z;
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.i = nativeAdConfiguration;
    }

    public boolean V(Context context, Bundle bundle) {
        if (context == null || !A()) {
            return false;
        }
        F(context, bundle);
        return true;
    }

    public void Code(MaterialClickInfo materialClickInfo) {
        if (materialClickInfo != null) {
            this.r = materialClickInfo;
        }
    }

    public void Code(VideoInfo videoInfo) {
        this.f17395a = videoInfo;
    }

    public void Code(boolean z) {
        this.B = z;
    }

    public boolean Code(Context context, Bundle bundle) {
        if (context == null || !A()) {
            return false;
        }
        this.j = System.currentTimeMillis();
        B(String.valueOf(w.Code()));
        V(this.j);
        S(context, bundle);
        return true;
    }
}
