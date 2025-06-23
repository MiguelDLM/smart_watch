package com.kwad.sdk.core.download;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import java.io.Serializable;

@KsJson
/* loaded from: classes11.dex */
public class DownloadParams extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -4966891183505507851L;
    public boolean downloadEnablePause = false;
    public int downloadPlace = 1;
    public String filePath;
    public String mAppIcon;
    public String mAppName;
    public long mAppSize;
    public String mDownloadid;
    public String mFileMd5;
    public String mFileUrl;
    public String mPkgname;
    public String mShortDesc;
    public int mTaskId;
    public String mVersion;
    public String mVersionCode;
    public boolean requestInstallPermission;

    public static DownloadParams transform(AdInfo adInfo) {
        DownloadParams downloadParams = new DownloadParams();
        downloadParams.mDownloadid = adInfo.downloadId;
        AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
        downloadParams.mAppName = adBaseInfo.appName;
        downloadParams.mPkgname = adBaseInfo.appPackageName;
        downloadParams.mFileUrl = adInfo.adConversionInfo.appDownloadUrl;
        downloadParams.mAppIcon = adBaseInfo.appIconUrl;
        downloadParams.mShortDesc = adBaseInfo.adDescription;
        downloadParams.downloadEnablePause = adInfo.downloadSafeInfo.downloadPauseEnable;
        return downloadParams;
    }
}
