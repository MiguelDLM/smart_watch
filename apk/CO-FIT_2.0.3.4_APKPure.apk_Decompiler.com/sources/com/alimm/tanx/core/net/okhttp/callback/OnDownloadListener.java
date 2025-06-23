package com.alimm.tanx.core.net.okhttp.callback;

import java.io.File;

public interface OnDownloadListener {
    void onDownLoadTotal(long j);

    void onDownloadFailed(int i, String str);

    void onDownloadSuccess(File file);

    void onDownloading(int i);
}
