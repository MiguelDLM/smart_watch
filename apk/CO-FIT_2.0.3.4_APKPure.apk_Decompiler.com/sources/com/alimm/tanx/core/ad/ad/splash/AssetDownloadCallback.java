package com.alimm.tanx.core.ad.ad.splash;

import java.io.File;

public interface AssetDownloadCallback {
    void onFail(int i, String str);

    void onSuccess(File file);
}
