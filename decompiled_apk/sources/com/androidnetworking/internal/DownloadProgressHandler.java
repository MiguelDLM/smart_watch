package com.androidnetworking.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.androidnetworking.interfaces.DownloadProgressListener;
import com.androidnetworking.model.Progress;

/* loaded from: classes.dex */
public class DownloadProgressHandler extends Handler {
    private final DownloadProgressListener mDownloadProgressListener;

    public DownloadProgressHandler(DownloadProgressListener downloadProgressListener) {
        super(Looper.getMainLooper());
        this.mDownloadProgressListener = downloadProgressListener;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
            return;
        }
        DownloadProgressListener downloadProgressListener = this.mDownloadProgressListener;
        if (downloadProgressListener != null) {
            Progress progress = (Progress) message.obj;
            downloadProgressListener.onProgress(progress.currentBytes, progress.totalBytes);
        }
    }
}
