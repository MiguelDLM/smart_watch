package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.inter.data.AdContentData;

@DataKeep
/* loaded from: classes10.dex */
public class AnalysisEventReport {
    private AdContentData adData;
    private String analysisType;
    private int apiVer;
    private String contentId;
    private long duration;
    private int errorCode;
    private long expireTime;
    private int extra;
    private String extraStr1;
    private String extraStr2;
    private String extraStr3;
    private String extraStr4;
    private String extraStr5;
    private long extraTime1;
    private String slotId;
    private String templateId;
    private String url;

    public String B() {
        return this.analysisType;
    }

    public long C() {
        return this.expireTime;
    }

    public String Code() {
        return this.url;
    }

    public String D() {
        return this.extraStr3;
    }

    public String F() {
        return this.extraStr2;
    }

    public int I() {
        return this.extra;
    }

    public String L() {
        return this.extraStr4;
    }

    public String S() {
        return this.extraStr1;
    }

    public int V() {
        return this.errorCode;
    }

    public AdContentData Z() {
        return this.adData;
    }

    public String a() {
        return this.extraStr5;
    }

    public long b() {
        return this.duration;
    }

    public long c() {
        return this.extraTime1;
    }

    public String d() {
        return this.contentId;
    }

    public String e() {
        return this.templateId;
    }

    public String f() {
        return this.slotId;
    }

    public int g() {
        return this.apiVer;
    }

    public void B(String str) {
        this.extraStr3 = str;
    }

    public void C(String str) {
        this.extraStr4 = str;
    }

    public void Code(int i) {
        this.errorCode = i;
    }

    public void D(String str) {
        this.templateId = str;
    }

    public void F(String str) {
        this.contentId = str;
    }

    public void I(int i) {
        this.apiVer = i;
    }

    public void L(String str) {
        this.slotId = str;
    }

    public void S(String str) {
        this.extraStr5 = str;
    }

    public void V(int i) {
        this.extra = i;
    }

    public void Z(String str) {
        this.extraStr2 = str;
    }

    public void Code(long j) {
        this.expireTime = j;
    }

    public void I(long j) {
        this.extraTime1 = j;
    }

    public void V(long j) {
        this.duration = j;
    }

    public void Code(AdContentData adContentData) {
        this.adData = adContentData;
    }

    public void I(String str) {
        this.extraStr1 = str;
    }

    public void V(String str) {
        this.analysisType = str;
    }

    public void Code(String str) {
        this.url = str;
    }
}
