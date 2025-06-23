package com.baidu.ar.obr;

/* loaded from: classes7.dex */
public class OBRConfig {
    private boolean isLogEnable;
    private String mBaseUrl;
    private String mDirectory;
    private long mMaxSize;

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public String getDirectory() {
        return this.mDirectory;
    }

    public long getMaxSize() {
        return this.mMaxSize;
    }

    public boolean isLogEnable() {
        return this.isLogEnable;
    }

    public void setBaseUrl(String str) {
        this.mBaseUrl = str;
    }

    public void setDirectory(String str) {
        this.mDirectory = str;
    }

    public void setLogEnable(boolean z) {
        this.isLogEnable = z;
    }

    public void setMaxSize(long j) {
        this.mMaxSize = j;
    }
}
