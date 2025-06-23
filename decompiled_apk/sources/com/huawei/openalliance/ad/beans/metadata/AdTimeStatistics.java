package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

@DataKeep
/* loaded from: classes10.dex */
public class AdTimeStatistics implements Serializable {
    private static final long serialVersionUID = 5562197861234973073L;
    long adInfoPrepEndTS;
    long adLoadEndTS;
    long adLoadStartTS;
    long adNetReqEndTS;
    long adNetReqStartTS;
    long adPhyReqEndTS;
    long adPhyReqStartTS;
    long adRspParseEndTS;
    long adRspParseStartTS;
    long kitSdkIPCEndTS;
    long kitSdkIPCStartTS;
    long sdkKitIPCEndTS;
    long sdkKitIPCStartTS;
    long splashAdDownloadTS;
    long splashAdMaterialLoadedTS;

    public long B() {
        return this.adPhyReqEndTS;
    }

    public long C() {
        return this.adNetReqStartTS;
    }

    public long Code() {
        return this.adLoadStartTS;
    }

    public long D() {
        return this.adRspParseEndTS;
    }

    public long F() {
        return this.adRspParseStartTS;
    }

    public long I() {
        return this.adInfoPrepEndTS;
    }

    public long L() {
        return this.sdkKitIPCStartTS;
    }

    public long S() {
        return this.adNetReqEndTS;
    }

    public long V() {
        return this.adLoadEndTS;
    }

    public long Z() {
        return this.adPhyReqStartTS;
    }

    public long a() {
        return this.sdkKitIPCEndTS;
    }

    public long b() {
        return this.kitSdkIPCStartTS;
    }

    public long c() {
        return this.kitSdkIPCEndTS;
    }

    public long d() {
        return this.splashAdDownloadTS;
    }

    public long e() {
        return this.splashAdMaterialLoadedTS;
    }

    public void B(long j) {
        this.adPhyReqEndTS = j;
    }

    public void C(long j) {
        this.adNetReqStartTS = j;
    }

    public void Code(long j) {
        this.adLoadStartTS = j;
    }

    public void D(long j) {
        this.adRspParseEndTS = j;
    }

    public void F(long j) {
        this.adRspParseStartTS = j;
    }

    public void I(long j) {
        this.adInfoPrepEndTS = j;
    }

    public void L(long j) {
        this.sdkKitIPCStartTS = j;
    }

    public void S(long j) {
        this.adNetReqEndTS = j;
    }

    public void V(long j) {
        this.adLoadEndTS = j;
    }

    public void Z(long j) {
        this.adPhyReqStartTS = j;
    }

    public void a(long j) {
        this.sdkKitIPCEndTS = j;
    }

    public void b(long j) {
        this.kitSdkIPCStartTS = j;
    }

    public void c(long j) {
        this.kitSdkIPCEndTS = j;
    }

    public void d(long j) {
        this.splashAdDownloadTS = j;
    }

    public void e(long j) {
        this.splashAdMaterialLoadedTS = j;
    }
}
