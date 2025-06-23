package com.alimm.tanx.core.ad.ad.splash;

import java.io.File;

/* loaded from: classes.dex */
public interface AssetDownloadCallback {
    void onFail(int i, String str);

    void onSuccess(File file);
}
