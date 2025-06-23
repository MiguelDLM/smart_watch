package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.data.SearchInfo;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes10.dex */
public class j implements q {
    private static final String Code = "AdRequestMediator";
    private String B;
    private String C;
    private String D;
    private String F;
    private int I;
    private App L;
    private boolean S;
    private final HashSet<String> V = new HashSet<>();
    private Location Z;

    /* renamed from: a, reason: collision with root package name */
    private RequestOptions.Builder f17308a;
    private List<Integer> b;
    private String c;
    private SearchInfo d;
    private boolean e;

    @Override // com.huawei.hms.ads.q
    public Location B() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.q
    public RequestOptions C() {
        RequestOptions.Builder builder = this.f17308a;
        if (builder != null) {
            return builder.build();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.q
    public String Code() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.q
    public String D() {
        return this.D;
    }

    @Override // com.huawei.hms.ads.q
    public String F() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.q
    public int I() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.q
    public List<Integer> L() {
        return this.b;
    }

    @Override // com.huawei.hms.ads.q
    public void S(Integer num) {
        if (num != null && num.intValue() != 0 && 1 != num.intValue()) {
            fb.Z(Code, "Invalid value passed to setSupportFa: " + num);
            return;
        }
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        if (num == null) {
            this.f17308a.setSupportFa(null);
        } else {
            this.f17308a.setSupportFa(Boolean.valueOf(num.intValue() == 1));
        }
    }

    @Override // com.huawei.hms.ads.q
    public String V() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.q
    public Set<String> Z() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.q
    public String a() {
        return this.c;
    }

    @Override // com.huawei.hms.ads.q
    public BiddingParam b(String str) {
        if (C() == null) {
            return null;
        }
        return C().Code(str);
    }

    @Override // com.huawei.hms.ads.q
    public void B(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f17308a == null) {
                this.f17308a = new RequestOptions.Builder();
            }
            this.f17308a.setThirdNonPersonalizedAd(num);
        } else {
            fb.Z(Code, "Invalid value passed to setThirdNonPersonalizedAd: " + num);
        }
    }

    @Override // com.huawei.hms.ads.q
    public void C(Integer num) {
        if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
            if (this.f17308a == null) {
                this.f17308a = new RequestOptions.Builder();
            }
            this.f17308a.setTagForUnderAgeOfPromise(num);
        } else {
            fb.V(Code, "Invalid value setTagForUnderAgeOfPromise: " + num);
        }
    }

    @Override // com.huawei.hms.ads.q
    public void Code(int i) {
        this.I = i;
    }

    @Override // com.huawei.hms.ads.q
    public void D(String str) {
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setSearchTerm(str);
    }

    @Override // com.huawei.hms.ads.q
    public void F(Integer num) {
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setTMax(num);
    }

    @Override // com.huawei.hms.ads.q
    public void I(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f17308a == null) {
                this.f17308a = new RequestOptions.Builder();
            }
            this.f17308a.setIsQueryUseEnabled(num);
        } else {
            fb.Z(Code, "Invalid value passed to setIsQueryUseEnabled: " + num);
        }
    }

    @Override // com.huawei.hms.ads.q
    public void L(String str) {
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setConsent(str);
    }

    @Override // com.huawei.hms.ads.q
    public void S(String str) {
        if (str == null || "".equals(str)) {
            return;
        }
        if ("W".equals(str) || ContentClassification.AD_CONTENT_CLASSIFICATION_PI.equals(str) || ContentClassification.AD_CONTENT_CLASSIFICATION_J.equals(str) || "A".equals(str)) {
            if (this.f17308a == null) {
                this.f17308a = new RequestOptions.Builder();
            }
            this.f17308a.setAdContentClassification(str);
        } else {
            fb.V(Code, "Invalid value  setAdContentClassification: " + str);
        }
    }

    @Override // com.huawei.hms.ads.q
    public void V(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f17308a == null) {
                this.f17308a = new RequestOptions.Builder();
            }
            this.f17308a.setNonPersonalizedAd(num);
        } else {
            fb.Z(Code, "Invalid value passed to setNonPersonalizedAd: " + num);
        }
    }

    @Override // com.huawei.hms.ads.q
    public void Z(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f17308a == null) {
                this.f17308a = new RequestOptions.Builder();
            }
            this.f17308a.setHwNonPersonalizedAd(num);
        } else {
            fb.Z(Code, "Invalid value passed to setHwNonPersonalizedAd: " + num);
        }
    }

    @Override // com.huawei.hms.ads.q
    public void a(String str) {
        this.c = str;
    }

    @Override // com.huawei.hms.ads.q
    public boolean b() {
        return this.e;
    }

    @Override // com.huawei.hms.ads.q
    public void B(String str) {
        if (TextUtils.isEmpty(str)) {
            fb.V(Code, "Invalid value passed to setAppLang");
            return;
        }
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setAppLang(str);
    }

    @Override // com.huawei.hms.ads.q
    public void C(String str) {
        if (TextUtils.isEmpty(str)) {
            fb.V(Code, "Invalid value passed to setAppCountry");
            return;
        }
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setAppCountry(str);
    }

    @Override // com.huawei.hms.ads.q
    public void Code(Location location) {
        this.Z = location;
    }

    @Override // com.huawei.hms.ads.q
    public void F(String str) {
        this.F = str;
    }

    @Override // com.huawei.hms.ads.q
    public void I(String str) {
        this.B = str;
    }

    @Override // com.huawei.hms.ads.q
    public boolean S() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.q
    public void V(String str) {
        this.D = str;
    }

    @Override // com.huawei.hms.ads.q
    public void Z(String str) {
        this.C = str;
    }

    @Override // com.huawei.hms.ads.q
    public void Code(App app) {
        if (app == null) {
            fb.V(Code, "Invalid appInfo");
            return;
        }
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setApp(app);
    }

    @Override // com.huawei.hms.ads.q
    public void I(boolean z) {
        this.e = z;
    }

    @Override // com.huawei.hms.ads.q
    public void V(Map<String, BiddingParam> map) {
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setBiddingParamMap(map);
    }

    @Override // com.huawei.hms.ads.q
    public void Code(SearchInfo searchInfo) {
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setSearchInfo(searchInfo);
    }

    @Override // com.huawei.hms.ads.q
    public void V(boolean z) {
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setRequestLocation(Boolean.valueOf(z));
    }

    @Override // com.huawei.hms.ads.q
    public void Code(Integer num) {
        if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
            if (this.f17308a == null) {
                this.f17308a = new RequestOptions.Builder();
            }
            this.f17308a.setTagForChildProtection(num);
        } else {
            fb.V(Code, "Invalid value setTagForChildProtection: " + num);
        }
    }

    @Override // com.huawei.hms.ads.q
    public void Code(String str) {
        this.V.add(str);
    }

    @Override // com.huawei.hms.ads.q
    public void Code(String str, BiddingParam biddingParam) {
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.addBiddingParamMap(str, biddingParam);
    }

    @Override // com.huawei.hms.ads.q
    public void Code(List<Integer> list) {
        this.b = list;
    }

    @Override // com.huawei.hms.ads.q
    public void Code(Map<String, Bundle> map) {
        if (this.f17308a == null) {
            this.f17308a = new RequestOptions.Builder();
        }
        this.f17308a.setExtras(map);
    }

    @Override // com.huawei.hms.ads.q
    public void Code(boolean z) {
        this.S = z;
    }

    @Override // com.huawei.hms.ads.q
    public boolean Code(Context context) {
        return false;
    }
}
