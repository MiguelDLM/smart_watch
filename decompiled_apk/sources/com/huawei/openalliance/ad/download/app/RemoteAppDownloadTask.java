package com.huawei.openalliance.ad.download.app;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AppInfo;

@DataKeep
/* loaded from: classes10.dex */
public class RemoteAppDownloadTask {
    private int apiVer;
    private String contentId;
    private String curInstallWay;
    private long downloadedSize;
    private long fileTotalSize;
    private String nextInstallWays;
    private int pauseReason;
    private int progress;
    private String sha256;
    private String slotId;
    private int status;
    private String templateId;
    private String url;

    public long B() {
        return this.fileTotalSize;
    }

    public String C() {
        return this.sha256;
    }

    public AppDownloadTask Code(AppInfo appInfo) {
        if (appInfo == null) {
            return null;
        }
        if (TextUtils.isEmpty(appInfo.x())) {
            appInfo.c(this.nextInstallWays);
        }
        AppDownloadTask Code = new AppDownloadTask.a().Code(appInfo).Code();
        if (!TextUtils.isEmpty(this.curInstallWay)) {
            Code.L(this.curInstallWay);
        }
        Code.C(this.contentId);
        Code.I(this.progress);
        Code.Code(this.status);
        Code.V(this.downloadedSize);
        Code.Code(this.fileTotalSize);
        Code.Code(this.url);
        Code.V(this.sha256);
        Code.Z(this.slotId);
        Code.Z(this.pauseReason);
        Code.b(this.templateId);
        Code.C(this.apiVer);
        return Code;
    }

    public int D() {
        return this.pauseReason;
    }

    public long F() {
        return this.downloadedSize;
    }

    public int I() {
        return this.status;
    }

    public String L() {
        return this.curInstallWay;
    }

    public String S() {
        return this.url;
    }

    public String V() {
        return this.contentId;
    }

    public int Z() {
        return this.progress;
    }

    public String Code() {
        return this.slotId;
    }

    public void I(int i) {
        this.pauseReason = i;
    }

    public void V(int i) {
        this.progress = i;
    }

    public void Z(String str) {
        this.url = str;
    }

    public void Code(int i) {
        this.status = i;
    }

    public void I(String str) {
        this.sha256 = str;
    }

    public void V(long j) {
        this.downloadedSize = j;
    }

    public void Code(long j) {
        this.fileTotalSize = j;
    }

    public void V(String str) {
        this.contentId = str;
    }

    public void Code(String str) {
        this.slotId = str;
    }
}
