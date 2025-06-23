package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;

@DataKeep
/* loaded from: classes10.dex */
public class ApiStatisticsReq {
    private String additionId;
    private String apiName;
    private String contentId;
    private long costTime;
    private DelayInfo delayInfo;
    private String isLimitTracking;
    private String oaid;
    private String params;
    private String requestId;
    private int result;
    private int resultCode;
    private String service;
    private long callTime = System.currentTimeMillis();
    private int adType = -1;

    public long B() {
        return this.callTime;
    }

    public long C() {
        return this.costTime;
    }

    public String Code() {
        return this.service;
    }

    public String D() {
        return this.oaid;
    }

    public String F() {
        return this.additionId;
    }

    public int I() {
        return this.result;
    }

    public String L() {
        return this.isLimitTracking;
    }

    public String S() {
        return this.params;
    }

    public String V() {
        return this.apiName;
    }

    public int Z() {
        return this.resultCode;
    }

    public String a() {
        return this.requestId;
    }

    public int b() {
        return this.adType;
    }

    public String c() {
        return this.contentId;
    }

    public DelayInfo d() {
        return this.delayInfo;
    }

    public void B(String str) {
        this.oaid = str;
    }

    public void C(String str) {
        this.isLimitTracking = str;
    }

    public void Code(int i) {
        this.result = i;
    }

    public void F(String str) {
        this.contentId = str;
    }

    public void I(int i) {
        this.adType = i;
    }

    public void S(String str) {
        this.requestId = str;
    }

    public void V(int i) {
        this.resultCode = i;
    }

    public void Z(String str) {
        this.additionId = str;
    }

    public void Code(long j) {
        this.callTime = j;
    }

    public void I(String str) {
        this.params = str;
    }

    public void V(long j) {
        this.costTime = j;
    }

    public void Code(DelayInfo delayInfo) {
        this.delayInfo = delayInfo;
    }

    public void V(String str) {
        this.apiName = str;
    }

    public void Code(String str) {
        this.service = str;
    }
}
