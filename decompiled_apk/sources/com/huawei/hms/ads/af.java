package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public abstract class af extends ag {
    private static final int B = -111111;
    private static final String Z = "JsbBaseAdRequest";

    public af(String str) {
        super(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.huawei.hms.ads.data.SearchInfo Code(org.json.JSONObject r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L82
            java.lang.String r1 = "searchQry"
            java.lang.String r1 = r12.optString(r1)
            java.lang.String r2 = "searchKwsType"
            java.lang.String r2 = r12.optString(r2)
            java.lang.String r3 = "searchKwsKW"
            java.lang.String r3 = r12.optString(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L65
            java.lang.String r5 = ","
            java.lang.String[] r3 = r3.split(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            r7 = 0
            if (r6 != 0) goto L3a
            java.lang.String[] r5 = r2.split(r5)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L38
            goto L3b
        L38:
            int r2 = r5.length
            goto L3c
        L3a:
            r5 = r0
        L3b:
            r2 = 0
        L3c:
            r6 = 0
        L3d:
            int r8 = r3.length
            if (r6 >= r8) goto L65
            r8 = r3[r6]
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L62
            com.huawei.hms.ads.data.Keyword r8 = new com.huawei.hms.ads.data.Keyword
            int r9 = r6 + 1
            if (r2 < r9) goto L59
            r9 = r5[r6]
            int r9 = com.huawei.openalliance.ad.utils.ay.Code(r9, r7)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto L5a
        L59:
            r9 = r0
        L5a:
            r10 = r3[r6]
            r8.<init>(r9, r10)
            r4.add(r8)
        L62:
            int r6 = r6 + 1
            goto L3d
        L65:
            java.lang.String r2 = "searchChnl"
            java.lang.String r12 = r12.optString(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L7d
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L7d
            boolean r2 = android.text.TextUtils.isEmpty(r12)
            if (r2 != 0) goto L82
        L7d:
            com.huawei.hms.ads.data.SearchInfo r0 = new com.huawei.hms.ads.data.SearchInfo
            r0.<init>(r1, r4, r12)
        L82:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.af.Code(org.json.JSONObject):com.huawei.hms.ads.data.SearchInfo");
    }

    private Map<String, Bundle> D(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = (Map) com.huawei.openalliance.ad.utils.aa.V(str, Map.class, Map.class);
        fb.Code(Z, "extras: %s", str);
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                Bundle bundle = new Bundle();
                String str2 = (String) entry.getKey();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    if (entry2 != null) {
                        bundle.putString((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                hashMap.put(str2, bundle);
            }
        }
        return hashMap;
    }

    private App V(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("name");
        String optString2 = jSONObject.optString("version");
        String optString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.z);
        if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new App(optString3, optString, optString2);
    }

    public abstract void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);

    public Location I(String str) {
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("location");
        if (optJSONObject == null) {
            return null;
        }
        String optString = optJSONObject.optString("latitude");
        String optString2 = optJSONObject.optString("longitude");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || !Pattern.matches(com.huawei.openalliance.ad.constant.x.ca, optString) || !Pattern.matches(com.huawei.openalliance.ad.constant.x.ca, optString2)) {
            return null;
        }
        Location location = new Location("");
        location.setLatitude(new BigDecimal(optString).doubleValue());
        location.setLongitude(new BigDecimal(optString2).doubleValue());
        return location;
    }

    public String Z(String str) {
        return str;
    }

    @Override // com.huawei.hms.ads.ag, com.huawei.hms.ads.ad
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.hms.ads.af.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    af.this.Code(context, str, remoteCallResultCallback);
                } catch (Throwable th) {
                    fb.Code(5, af.Z, "executeInNetworkThread exception", th);
                    ag.Code(remoteCallResultCallback, af.this.Code, -1, th.getClass().getSimpleName() + ":" + th.getMessage(), true);
                }
            }
        });
    }

    private void Code(Context context, String str, RequestOptions.Builder builder, AdParam.Builder builder2) {
        Integer num;
        int i;
        Integer num2;
        int i2;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject = new JSONObject(str);
        int optInt = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.n, -111111);
        Integer valueOf = Integer.valueOf(optInt);
        int optInt2 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.o, -111111);
        Integer valueOf2 = Integer.valueOf(optInt2);
        int optInt3 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.j, -111111);
        Integer valueOf3 = Integer.valueOf(optInt3);
        int optInt4 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.k, -111111);
        Integer valueOf4 = Integer.valueOf(optInt4);
        int optInt5 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.l, -111111);
        Integer valueOf5 = Integer.valueOf(optInt5);
        int optInt6 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.m, -111111);
        Integer valueOf6 = Integer.valueOf(optInt6);
        String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.p);
        boolean optBoolean = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.aw.G, true);
        Boolean valueOf7 = Boolean.valueOf(optBoolean);
        boolean optBoolean2 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.aw.H, true);
        int optInt7 = jSONObject.optInt(com.huawei.openalliance.ad.constant.aw.J, 0);
        boolean optBoolean3 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.aw.K, false);
        String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.P);
        String optString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.x);
        String optString4 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.N);
        String optString5 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.O);
        int optInt8 = jSONObject.optInt("brand", -111111);
        String optString6 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.t);
        String optString7 = jSONObject.optString(com.huawei.openalliance.ad.constant.aw.W);
        Map<String, Bundle> D = D(jSONObject.optString("extras"));
        App V = V(jSONObject.optJSONObject("app"));
        Location I = I(str);
        SearchInfo Code = Code(jSONObject.optJSONObject(com.huawei.openalliance.ad.constant.aw.aD));
        if (builder != null) {
            if (-111111 != optInt) {
                builder.setTagForChildProtection(valueOf);
            }
            if (-111111 != optInt2) {
                builder.setTagForUnderAgeOfPromise(valueOf2);
            }
            if (!TextUtils.isEmpty(optString)) {
                builder.setAdContentClassification(optString);
            }
            if (-111111 != optInt4) {
                builder.setIsQueryUseEnabled(valueOf4);
            }
            if (-111111 != optInt3) {
                builder.setNonPersonalizedAd(valueOf3);
            }
            i2 = optInt5;
            num2 = valueOf5;
            if (-111111 != i2) {
                builder.setHwNonPersonalizedAd(num2);
            }
            i = optInt6;
            if (-111111 != i) {
                num = valueOf6;
                builder.setThirdNonPersonalizedAd(num);
            } else {
                num = valueOf6;
            }
            if (!TextUtils.isEmpty(optString2)) {
                builder.setConsent(optString2);
            }
            if (TextUtils.isEmpty(optString3)) {
                str2 = optString2;
            } else {
                str2 = optString2;
                builder.setSearchTerm(optString3);
            }
            builder.setRequestLocation(valueOf7);
            if (V != null) {
                builder.setApp(V);
            }
            if (TextUtils.isEmpty(optString4)) {
                str4 = optString4;
            } else {
                str4 = optString4;
                builder.setAppLang(str4);
            }
            optString4 = str4;
            str3 = optString5;
            if (!TextUtils.isEmpty(optString5)) {
                builder.setAppCountry(str3);
            }
            if (D != null) {
                builder.setExtras(D);
            }
            if (Code != null) {
                builder.setSearchInfo(Code);
            }
        } else {
            num = valueOf6;
            i = optInt6;
            num2 = valueOf5;
            i2 = optInt5;
            str2 = optString2;
            str3 = optString5;
        }
        if (builder2 != null) {
            if (-111111 != optInt) {
                builder2.setTagForChildProtection(valueOf);
            }
            if (-111111 != optInt2) {
                builder2.setTagForUnderAgeOfPromise(valueOf2);
            }
            if (!TextUtils.isEmpty(optString)) {
                builder2.setAdContentClassification(optString);
            }
            if (-111111 != optInt3) {
                builder2.setNonPersonalizedAd(valueOf3);
            }
            if (-111111 != i2) {
                builder2.setHwNonPersonalizedAd(num2);
            }
            if (-111111 != i) {
                builder2.setThirdNonPersonalizedAd(num);
            }
            if (!TextUtils.isEmpty(str2)) {
                builder2.setConsent(str2);
            }
            if (!TextUtils.isEmpty(optString3)) {
                builder2.setSearchTerm(optString3);
            }
            builder2.setRequestLocation(optBoolean);
            if (V != null) {
                builder2.setAppInfo(V);
            }
            if (!TextUtils.isEmpty(optString4)) {
                builder2.setAppLang(optString4);
            }
            if (!TextUtils.isEmpty(str3)) {
                builder2.setAppCountry(str3);
            }
            if (!TextUtils.isEmpty(optString7)) {
                builder2.setContentBundle(Z(optString7));
            }
            if (I != null) {
                builder2.setLocation(I);
            }
            if (Code != null) {
                builder2.setSearchInfo(Code);
            }
        }
        if (-111111 != optInt8) {
            HiAd.getInstance(context).setBrand(optInt8);
        }
        HiAd.getInstance(context).setAppInstalledNotify(optBoolean2);
        if (optInt7 != 0) {
            HiAd.getInstance(context).setAppActivateStyle(optInt7);
        }
        HiAd.getInstance(context).setAppAutoOpenForbidden(optBoolean3);
        if (TextUtils.isEmpty(optString6)) {
            return;
        }
        HiAd.getInstance(context).setCountryCode(optString6);
    }

    public AdParam I(Context context, String str) {
        AdParam.Builder builder = new AdParam.Builder();
        Code(context, str, (RequestOptions.Builder) null, builder);
        return builder.build();
    }

    public RequestOptions V(Context context, String str) {
        RequestOptions.Builder builder = new RequestOptions.Builder();
        Code(context, str, builder, (AdParam.Builder) null);
        return builder.build();
    }
}
