package com.huawei.openalliance.ad.download;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes10.dex */
public class DownloadTask {
    private boolean allowedMobileNetowrk;
    private long downloadedSize;
    private long fileTotalSize;
    private int pauseReason;
    private int priority;
    private int progress;
    private String sha256;
    private String url;

    @com.huawei.openalliance.ad.annotations.d
    private final byte[] lock = new byte[0];

    @com.huawei.openalliance.ad.annotations.d
    private int status = 0;

    /* loaded from: classes10.dex */
    public interface a {
        public static final int Code = 0;
        public static final int I = 2;
        public static final int V = 1;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int B() {
        int i;
        synchronized (this.lock) {
            i = this.status;
        }
        return i;
    }

    public int C() {
        return this.priority;
    }

    public String Code() {
        return this.url;
    }

    public int D() {
        return this.pauseReason;
    }

    public String F() {
        return Code();
    }

    public long I() {
        return this.fileTotalSize;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int S() {
        return this.progress;
    }

    public String V() {
        return this.sha256;
    }

    @com.huawei.openalliance.ad.annotations.b
    public long Z() {
        return this.downloadedSize;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof DownloadTask) && TextUtils.equals(F(), ((DownloadTask) obj).F())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return F() != null ? F().hashCode() : super.hashCode();
    }

    public void Code(int i) {
        synchronized (this.lock) {
            this.status = i;
        }
    }

    public void I(int i) {
        this.progress = i;
    }

    public void V(int i) {
        this.priority = i;
    }

    public void Z(int i) {
        this.pauseReason = i;
    }

    public void Code(long j) {
        this.fileTotalSize = j;
    }

    public void V(long j) {
        this.downloadedSize = j;
    }

    public void Code(String str) {
        this.url = str;
    }

    public void V(String str) {
        this.sha256 = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public void Code(boolean z) {
        this.allowedMobileNetowrk = z;
    }
}
