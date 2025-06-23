package com.bytedance.pangle.download;

import androidx.annotation.Keep;
import java.util.List;

@Keep
/* loaded from: classes8.dex */
public class PluginDownloadBean {
    public List<String> mBackupUrlList;
    public int mFlag;
    public long mFollowId;
    public String mMd5;
    public String mPackageName;
    public String mUrl;
    public int mVersionCode;
    public int mApiVersionMin = 0;
    public int mApiVersionMax = Integer.MAX_VALUE;

    public boolean isRevert() {
        if (this.mFlag == 3) {
            return true;
        }
        return false;
    }

    public boolean isUnInstall() {
        if (this.mFlag == 1) {
            return true;
        }
        return false;
    }
}
