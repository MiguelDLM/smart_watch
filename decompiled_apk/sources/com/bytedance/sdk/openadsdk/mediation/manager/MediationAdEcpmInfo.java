package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class MediationAdEcpmInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f10889a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private Map<String, String> p;

    public MediationAdEcpmInfo() {
        this.p = new HashMap();
    }

    public String getAbTestId() {
        return this.n;
    }

    public String getChannel() {
        return this.l;
    }

    public Map<String, String> getCustomData() {
        return this.p;
    }

    public String getCustomSdkName() {
        return this.b;
    }

    public String getEcpm() {
        return this.e;
    }

    public String getErrorMsg() {
        return this.g;
    }

    public String getLevelTag() {
        return this.d;
    }

    public int getReqBiddingType() {
        return this.f;
    }

    public String getRequestId() {
        return this.h;
    }

    public String getRitType() {
        return this.i;
    }

    public String getScenarioId() {
        return this.o;
    }

    public String getSdkName() {
        return this.f10889a;
    }

    public String getSegmentId() {
        return this.k;
    }

    public String getSlotId() {
        return this.c;
    }

    public String getSubChannel() {
        return this.m;
    }

    public String getSubRitType() {
        return this.j;
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.p = hashMap;
        this.f10889a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = i;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
        this.m = str12;
        this.n = str13;
        this.o = str14;
        if (map != null) {
            this.p = map;
        } else {
            hashMap.clear();
        }
    }
}
