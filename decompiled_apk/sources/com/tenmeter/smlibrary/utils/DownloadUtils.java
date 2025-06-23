package com.tenmeter.smlibrary.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;

/* loaded from: classes13.dex */
public class DownloadUtils {
    private static final String TAG = "DownloadUtils";
    public static boolean isStop = false;
    private static Context mContext;
    private static DownloadUtils mDownloadUtils;
    private static ThreadUtils mThreadUtils;
    private String mDownloadUrl;
    private String mDriPath;
    private String mFileName;

    /* loaded from: classes13.dex */
    public interface OnDownloadListener {
        void onError(String str);

        void onFinish(File file);

        void onProgress(int i, int i2);

        void onStart();
    }

    /* loaded from: classes13.dex */
    public static class ThreadUtils {
        private Handler mHandler;

        private ThreadUtils() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        public boolean isMainThread() {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return true;
            }
            return false;
        }

        public void runOnSubThread(Runnable runnable) {
            new Thread(runnable).start();
        }

        public void runOnUiThread(Runnable runnable) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.mHandler.post(runnable);
            }
        }
    }

    private DownloadUtils() {
    }

    public static DownloadUtils getInstance() {
        if (mThreadUtils == null) {
            mThreadUtils = new ThreadUtils();
        }
        if (mDownloadUtils == null) {
            mDownloadUtils = new DownloadUtils();
        }
        return mDownloadUtils;
    }

    public Thread downLoadFile(final String str, final String str2, final String str3, final OnDownloadListener onDownloadListener) {
        Thread thread = new Thread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.DownloadUtils.1

            /* renamed from: com.tenmeter.smlibrary.utils.DownloadUtils$1$3, reason: invalid class name */
            /* loaded from: classes13.dex */
            public class AnonymousClass3 implements Runnable {
                public AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    onDownloadListener.onError("无法创建文件");
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:79:0x01dc A[Catch: Exception -> 0x01d8, TryCatch #9 {Exception -> 0x01d8, blocks: (B:88:0x01d4, B:79:0x01dc, B:81:0x01e1), top: B:87:0x01d4 }] */
            /* JADX WARN: Removed duplicated region for block: B:81:0x01e1 A[Catch: Exception -> 0x01d8, TRY_LEAVE, TryCatch #9 {Exception -> 0x01d8, blocks: (B:88:0x01d4, B:79:0x01dc, B:81:0x01e1), top: B:87:0x01d4 }] */
            /* JADX WARN: Removed duplicated region for block: B:87:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 530
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tenmeter.smlibrary.utils.DownloadUtils.AnonymousClass1.run():void");
            }
        });
        thread.start();
        return thread;
    }

    public DownloadUtils setDirPath(String str) {
        if (str != null) {
            this.mDriPath = str;
            return mDownloadUtils;
        }
        throw new NullPointerException("dirPath is a null");
    }

    public DownloadUtils setFileName(String str) {
        if (str != null) {
            this.mFileName = str;
            return mDownloadUtils;
        }
        throw new NullPointerException("fileName is a null");
    }

    public void setOnDownloadListener(OnDownloadListener onDownloadListener) {
        if (onDownloadListener != null) {
            downLoadFile(this.mDownloadUrl, this.mDriPath, this.mFileName, onDownloadListener);
            return;
        }
        throw new NullPointerException("OnDownloadListener is a null");
    }

    public Thread setOnDownloadListener1(OnDownloadListener onDownloadListener) {
        if (onDownloadListener != null) {
            return downLoadFile(this.mDownloadUrl, this.mDriPath, this.mFileName, onDownloadListener);
        }
        throw new NullPointerException("OnDownloadListener is a null");
    }

    public DownloadUtils setUrl(String str) {
        if (str != null) {
            this.mDownloadUrl = str;
            return mDownloadUtils;
        }
        throw new NullPointerException("url is a null");
    }
}
