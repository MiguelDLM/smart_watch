package com.alimm.tanx.core.view.player.cache;

import android.os.Handler;
import android.os.Looper;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import com.alimm.tanx.core.view.player.cache.videocache.PreloadListener;
import java.util.concurrent.ExecutorService;

public class PreloadTask implements Runnable {
    private static final String TAG = "PreloadTask";
    private Handler handler;
    public HttpProxyCacheServer mCacheServer;
    private boolean mIsCanceled;
    private boolean mIsExecuted;
    public int mPosition;
    public int mPreloadLimit = -1;
    public PreloadListener mPreloadListener;
    public String mRawUrl;

    private void onComplete(final Exception exc) {
        if (this.mPreloadListener != null) {
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            this.handler.post(new Runnable() {
                public void run() {
                    Exception exc = exc;
                    if (exc != null) {
                        PreloadTask preloadTask = PreloadTask.this;
                        preloadTask.mPreloadListener.onError(preloadTask.mRawUrl, exc);
                        return;
                    }
                    PreloadTask preloadTask2 = PreloadTask.this;
                    preloadTask2.mPreloadListener.onCached(preloadTask2.mRawUrl);
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        com.alimm.tanx.core.utils.LogUtils.i(TAG, "结束预加载：" + r9.mPosition);
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void start() {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "开始预加载："
            r0.append(r1)
            int r1 = r9.mPosition
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PreloadTask"
            com.alimm.tanx.core.utils.LogUtils.i((java.lang.String) r1, (java.lang.String) r0)
            r0 = 0
            com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer r2 = r9.mCacheServer     // Catch:{ Exception -> 0x00b7, all -> 0x00b3 }
            java.lang.String r3 = r9.mRawUrl     // Catch:{ Exception -> 0x00b7, all -> 0x00b3 }
            java.lang.String r2 = r2.getProxyUrl(r3)     // Catch:{ Exception -> 0x00b7, all -> 0x00b3 }
            java.lang.String r3 = "预加载的路径："
            com.alimm.tanx.core.utils.LogUtils.e((java.lang.String) r3, (java.lang.String) r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b3 }
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00b7, all -> 0x00b3 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b3 }
            java.net.URLConnection r2 = r3.openConnection()     // Catch:{ Exception -> 0x00b7, all -> 0x00b3 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00b7, all -> 0x00b3 }
            r3 = 10000(0x2710, float:1.4013E-41)
            r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x005f }
            r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x005f }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x005f }
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ Exception -> 0x005f }
            r3.<init>(r4)     // Catch:{ Exception -> 0x005f }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x005f }
            r5 = -1
            r6 = -1
        L_0x004a:
            int r7 = r3.read(r4)     // Catch:{ Exception -> 0x005f }
            if (r7 == r5) goto L_0x0078
            int r6 = r6 + r7
            boolean r7 = r9.mIsCanceled     // Catch:{ Exception -> 0x005f }
            if (r7 != 0) goto L_0x0061
            int r7 = r9.mPreloadLimit     // Catch:{ Exception -> 0x005f }
            if (r7 == r5) goto L_0x004a
            if (r6 < r7) goto L_0x004a
            goto L_0x0061
        L_0x005c:
            r0 = move-exception
            goto L_0x00f9
        L_0x005f:
            r0 = move-exception
            goto L_0x00bb
        L_0x0061:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f }
            r3.<init>()     // Catch:{ Exception -> 0x005f }
            java.lang.String r4 = "结束预加载："
            r3.append(r4)     // Catch:{ Exception -> 0x005f }
            int r4 = r9.mPosition     // Catch:{ Exception -> 0x005f }
            r3.append(r4)     // Catch:{ Exception -> 0x005f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x005f }
            com.alimm.tanx.core.utils.LogUtils.i((java.lang.String) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x005f }
        L_0x0078:
            if (r6 != r5) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f }
            r0.<init>()     // Catch:{ Exception -> 0x005f }
            java.lang.String r3 = "预加载失败："
            r0.append(r3)     // Catch:{ Exception -> 0x005f }
            int r3 = r9.mPosition     // Catch:{ Exception -> 0x005f }
            r0.append(r3)     // Catch:{ Exception -> 0x005f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x005f }
            com.alimm.tanx.core.utils.LogUtils.i((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x005f }
            java.lang.String r0 = r9.mRawUrl     // Catch:{ Exception -> 0x005f }
            java.io.File r0 = com.alimm.tanx.core.view.player.cache.ProxyCacheManager.getCacheFile(r0)     // Catch:{ Exception -> 0x005f }
            boolean r3 = r0.exists()     // Catch:{ Exception -> 0x005f }
            if (r3 == 0) goto L_0x00a0
            r0.delete()     // Catch:{ Exception -> 0x005f }
        L_0x00a0:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x005f }
            java.lang.String r3 = "预加载失败"
            r0.<init>(r3)     // Catch:{ Exception -> 0x005f }
            r9.onComplete(r0)     // Catch:{ Exception -> 0x005f }
            goto L_0x00af
        L_0x00ac:
            r9.onComplete(r0)     // Catch:{ Exception -> 0x005f }
        L_0x00af:
            r2.disconnect()
            goto L_0x00f8
        L_0x00b3:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x00f9
        L_0x00b7:
            r2 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
        L_0x00bb:
            r0.printStackTrace()     // Catch:{ all -> 0x005c }
            r9.onComplete(r0)     // Catch:{ all -> 0x005c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005c }
            r3.<init>()     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "异常结束预加载："
            r3.append(r4)     // Catch:{ all -> 0x005c }
            int r4 = r9.mPosition     // Catch:{ all -> 0x005c }
            r3.append(r4)     // Catch:{ all -> 0x005c }
            java.lang.String r4 = "|"
            r3.append(r4)     // Catch:{ all -> 0x005c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x005c }
            r3.append(r0)     // Catch:{ all -> 0x005c }
            java.lang.String r0 = "\n"
            r3.append(r0)     // Catch:{ all -> 0x005c }
            com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer r0 = r9.mCacheServer     // Catch:{ all -> 0x005c }
            java.lang.String r4 = r9.mRawUrl     // Catch:{ all -> 0x005c }
            java.lang.String r0 = r0.getProxyUrl(r4)     // Catch:{ all -> 0x005c }
            r3.append(r0)     // Catch:{ all -> 0x005c }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x005c }
            com.alimm.tanx.core.utils.LogUtils.i((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x00f8
            goto L_0x00af
        L_0x00f8:
            return
        L_0x00f9:
            if (r2 == 0) goto L_0x00fe
            r2.disconnect()
        L_0x00fe:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.view.player.cache.PreloadTask.start():void");
    }

    public void cancel() {
        if (this.mIsExecuted) {
            this.mIsCanceled = true;
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    public void executeOn(ExecutorService executorService) {
        if (!this.mIsExecuted) {
            this.mIsExecuted = true;
            executorService.submit(this);
        }
    }

    public void run() {
        LogUtils.i(TAG, "mIsCanceled：" + this.mIsCanceled);
        if (!this.mIsCanceled) {
            start();
        }
        this.mIsExecuted = false;
        this.mIsCanceled = false;
    }
}
