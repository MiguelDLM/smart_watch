package com.tenmeter.smlibrary.utils;

import android.os.AsyncTask;
import com.tenmeter.smlibrary.listener.IDownloadLister;

/* loaded from: classes13.dex */
public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {
    private DownloadThread[] downloadThreads;
    private String downloadUrl;
    private IDownloadLister listener;
    private String savePath;
    private int threadNum;
    private boolean isCanceled = false;
    private boolean isPaused = false;
    private long downloadedSize = 0;
    private float old = 0.0f;
    private long fileTotalSize = 0;
    private Object object = new Object();

    /* loaded from: classes13.dex */
    public class DownloadThread extends Thread {
        private int endPos;
        private boolean isFinished = false;
        private int startPos;
        private int threadId;

        public DownloadThread(int i, int i2, int i3) {
            this.threadId = i;
            this.startPos = i2;
            this.endPos = i3;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x0166 A[Catch: IOException -> 0x0162, TryCatch #5 {IOException -> 0x0162, blocks: (B:62:0x015e, B:53:0x0166, B:55:0x016b), top: B:61:0x015e }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x016b A[Catch: IOException -> 0x0162, TRY_LEAVE, TryCatch #5 {IOException -> 0x0162, blocks: (B:62:0x015e, B:53:0x0166, B:55:0x016b), top: B:61:0x015e }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 371
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tenmeter.smlibrary.utils.DownloadTask.DownloadThread.run():void");
        }
    }

    public DownloadTask(String str, String str2, int i, IDownloadLister iDownloadLister) {
        this.downloadUrl = str;
        this.savePath = str2;
        this.threadNum = i;
        this.downloadThreads = new DownloadThread[i];
        this.listener = iDownloadLister;
    }

    public static /* synthetic */ long access$514(DownloadTask downloadTask, long j) {
        long j2 = downloadTask.downloadedSize + j;
        downloadTask.downloadedSize = j2;
        return j2;
    }

    public void cancelDownload() {
        this.isCanceled = true;
    }

    public long getDownloadedSize() {
        return this.downloadedSize;
    }

    public void pauseDownload() {
        this.isPaused = true;
    }

    public void resumeDownload() {
        this.isPaused = false;
        synchronized (this) {
            notify();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x009c, code lost:
    
        r11 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e3 A[Catch: IOException -> 0x00df, TRY_LEAVE, TryCatch #8 {IOException -> 0x00df, blocks: (B:94:0x00db, B:87:0x00e3), top: B:93:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Boolean doInBackground(java.lang.Void... r11) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tenmeter.smlibrary.utils.DownloadTask.doInBackground(java.lang.Void[]):java.lang.Boolean");
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Boolean bool) {
        super.onPostExecute((DownloadTask) bool);
        if (bool.booleanValue()) {
            this.listener.onFinish(this.savePath);
        } else {
            this.listener.onError("Error");
        }
    }

    @Override // android.os.AsyncTask
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate((Object[]) numArr);
        this.listener.onProgress(this.fileTotalSize, numArr[0].intValue());
        KLog.a("onProgressUpdate===" + this.fileTotalSize + "--------onProgressUpdate====" + this.downloadedSize);
    }
}
