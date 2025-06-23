package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.cj;
import com.huawei.hms.ads.et;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.ja;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.am;
import com.huawei.openalliance.ad.utils.ay;
import java.util.Map;

/* loaded from: classes10.dex */
public class j extends p {
    private static final String V = "InnerWebAction";
    private final boolean C;
    protected et Code;
    private boolean S;

    public j(Context context, AdContentData adContentData, boolean z) {
        super(context, adContentData);
        this.Code = new et();
        this.S = false;
        this.C = z;
    }

    public void Code(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Object obj;
        Object orDefault;
        Object orDefault2;
        Object orDefault3;
        Object orDefault4;
        Object orDefault5;
        Object orDefault6;
        Object orDefault7;
        Object orDefault8;
        fb.Code(V, "buildLinkedAdConfig");
        if (map == null || map.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            orDefault = map.getOrDefault(bb.p, String.valueOf(0));
            str = (String) orDefault;
            orDefault2 = map.getOrDefault(bb.m, String.valueOf(0));
            str2 = (String) orDefault2;
            orDefault3 = map.getOrDefault(bb.s, "false");
            str3 = (String) orDefault3;
            orDefault4 = map.getOrDefault(bb.q, null);
            str4 = (String) orDefault4;
            orDefault5 = map.getOrDefault(bb.r, "n");
            str5 = (String) orDefault5;
            orDefault6 = map.getOrDefault(bb.aO, null);
            str6 = (String) orDefault6;
            orDefault7 = map.getOrDefault(bb.aP, null);
            str7 = (String) orDefault7;
            orDefault8 = map.getOrDefault(bb.aQ, null);
            str8 = (String) orDefault8;
            obj = map.getOrDefault(bb.aV, "false");
        } else {
            str = map.get(bb.p);
            str2 = map.get(bb.m);
            str3 = map.get(bb.s);
            str4 = map.get(bb.q);
            str5 = map.get(bb.r);
            str6 = map.get(bb.aO);
            str7 = map.get(bb.aP);
            str8 = map.get(bb.aQ);
            obj = map.get(bb.aV);
        }
        String str9 = (String) obj;
        Integer F = ay.F(str);
        if (F != null) {
            this.Code.V(F.intValue());
        } else {
            this.Code.V(0);
        }
        this.Code.I(str2);
        Integer F2 = ay.F(str4);
        if (F2 != null) {
            this.Code.Code(F2.intValue());
            fb.V(V, "set progress from native view " + F2);
        } else {
            this.Code.Code(0);
        }
        if (!TextUtils.isEmpty(str9)) {
            this.Code.Code(str9);
        }
        this.Code.V(str5);
        this.Code.Code("true".equals(str3));
        this.Code.B(str6);
        this.Code.C(str7);
        this.Code.Z(str8);
        String str10 = map.containsKey(bb.n) ? map.get(bb.n) : null;
        String str11 = map.containsKey(bb.o) ? map.get(bb.o) : "true";
        if (str10 != null) {
            this.Code.Code(new VideoConfiguration.Builder().setAutoPlayNetwork(ay.Code(str10, 0)).setStartMuted(Boolean.getBoolean(str11)).build());
        }
    }

    public j(Context context, AdContentData adContentData, boolean z, Map<String, String> map) {
        super(context, adContentData);
        this.Code = new et();
        this.S = false;
        this.C = z;
        Code(map);
    }

    public void Code(boolean z) {
        this.S = z;
    }

    @Override // com.huawei.openalliance.ad.uriaction.p
    public boolean Code() {
        if (this.Z == null) {
            return V();
        }
        fb.V(V, "handle inner web action");
        this.Z.I(this.C);
        fb.V(V, "needAppDownload: %s", Boolean.valueOf(this.C));
        return TextUtils.isEmpty(this.Z.i()) ? V() : Code(this.Z);
    }

    private boolean Code(AdContentData adContentData) {
        if (!ja.Code(this.Z.v()) && !am.Z(this.I)) {
            return V();
        }
        Code("web");
        cj.Code(this.I, adContentData, this.Code, this.S);
        return true;
    }
}
