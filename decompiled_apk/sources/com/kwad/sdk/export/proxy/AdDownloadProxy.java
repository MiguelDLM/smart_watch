package com.kwad.sdk.export.proxy;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DownloadParams;

/* loaded from: classes11.dex */
public interface AdDownloadProxy {
    void cancelDownload(Context context, String str, DownloadParams downloadParams);

    @Nullable
    String getDownloadFilePath(DownloadParams downloadParams);

    void pauseDownload(Context context, String str, DownloadParams downloadParams);

    void startDownload(Context context, String str, DownloadParams downloadParams);
}
