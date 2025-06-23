package com.alimm.tanx.core.view.player.cache;

import android.content.Context;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import com.alimm.tanx.core.view.player.cache.videocache.PreloadListener;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class PreloadManager {
    public static final int PRELOAD_LENGTH = 1048576;
    private static final String TAG = "PreloadManager";
    private static PreloadManager sPreloadManager;
    private HttpProxyCacheServer mHttpProxyCacheServer;
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private final LinkedHashMap<String, PreloadTask> mPreloadTasks = new LinkedHashMap<>();
    private boolean mIsStartPreload = true;

    private PreloadManager(Context context) {
        try {
            this.mHttpProxyCacheServer = ProxyCacheManager.getProxy(context);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        }
    }

    public static PreloadManager getInstance(Context context) {
        if (sPreloadManager == null) {
            synchronized (PreloadManager.class) {
                try {
                    if (sPreloadManager == null) {
                        sPreloadManager = new PreloadManager(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return sPreloadManager;
    }

    public void addPreloadTask(String str, boolean z, PreloadListener preloadListener) {
        addPreloadTask(str, 0, -1, z, preloadListener);
    }

    public void continuePreLoad(int i, boolean z) {
        LogUtils.d(TAG, "resumePreload：" + i + " isReverseScroll: " + z);
        this.mIsStartPreload = true;
        Iterator<Map.Entry<String, PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            PreloadTask value = it.next().getValue();
            if (z) {
                if (value.mPosition < i && !isPreloaded(value.mRawUrl)) {
                    value.executeOn(this.mExecutorService);
                }
            } else if (value.mPosition > i && !isPreloaded(value.mRawUrl)) {
                value.executeOn(this.mExecutorService);
            }
        }
    }

    public boolean deleteCacheFile(String str) {
        try {
            File cacheFile = ProxyCacheManager.getCacheFile(str);
            if (cacheFile.exists()) {
                cacheFile.delete();
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String getPlayUrl(String str) {
        PreloadTask preloadTask = this.mPreloadTasks.get(str);
        if (preloadTask != null) {
            preloadTask.cancel();
        }
        if (isPreloaded(str)) {
            HttpProxyCacheServer httpProxyCacheServer = this.mHttpProxyCacheServer;
            if (httpProxyCacheServer != null) {
                return httpProxyCacheServer.getProxyUrl(str);
            }
            LogUtils.e(TAG, "getPlayUrl mHttpProxyCacheServer为空");
        }
        return str;
    }

    public boolean isPreloaded(String str) {
        File cacheFile = ProxyCacheManager.getCacheFile(str);
        if (cacheFile.exists()) {
            if (cacheFile.length() >= 1024) {
                return true;
            }
            cacheFile.delete();
            return false;
        }
        File tempCacheFile = ProxyCacheManager.getTempCacheFile(str);
        if (tempCacheFile.exists() && tempCacheFile.length() >= 1048576) {
            return true;
        }
        return false;
    }

    public void pauseAll() {
        LogUtils.d(TAG, "pauseAll");
        Iterator<Map.Entry<String, PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            PreloadTask value = it.next().getValue();
            if (!isPreloaded(value.mRawUrl)) {
                value.cancel();
            }
        }
    }

    public void pausePreload(int i, boolean z) {
        LogUtils.d(TAG, "pausePreload：" + i + " isReverseScroll: " + z);
        this.mIsStartPreload = false;
        Iterator<Map.Entry<String, PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            PreloadTask value = it.next().getValue();
            if (z) {
                if (value.mPosition >= i) {
                    value.cancel();
                }
            } else if (value.mPosition <= i) {
                value.cancel();
            }
        }
    }

    public void removeAllPreloadTask() {
        Iterator<Map.Entry<String, PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cancel();
            it.remove();
        }
    }

    public void removePreloadTask(String str) {
        PreloadTask preloadTask = this.mPreloadTasks.get(str);
        if (preloadTask != null) {
            preloadTask.cancel();
            this.mPreloadTasks.remove(str);
        }
    }

    public void resumeAll() {
        LogUtils.d(TAG, "resumeAll");
        this.mIsStartPreload = true;
        Iterator<Map.Entry<String, PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            PreloadTask value = it.next().getValue();
            isPreloaded(value.mRawUrl);
            value.executeOn(this.mExecutorService);
        }
    }

    public void resumePreload(int i, boolean z) {
        LogUtils.d(TAG, "resumePreload：" + i + " isReverseScroll: " + z);
        this.mIsStartPreload = true;
        Iterator<Map.Entry<String, PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            PreloadTask value = it.next().getValue();
            if (z) {
                if (value.mPosition < i) {
                    isPreloaded(value.mRawUrl);
                    value.executeOn(this.mExecutorService);
                }
            } else if (value.mPosition > i) {
                isPreloaded(value.mRawUrl);
                value.executeOn(this.mExecutorService);
            }
        }
    }

    public void stopAllPreloadTask() {
        Iterator<Map.Entry<String, PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().cancel();
        }
    }

    public void addPreloadTask(String str, int i, int i2, boolean z, PreloadListener preloadListener) {
        if (this.mHttpProxyCacheServer == null) {
            LogUtils.e(TAG, "addPreloadTask-mHttpProxyCacheServer为空");
            return;
        }
        if (isPreloaded(str)) {
            if (preloadListener != null) {
                preloadListener.onCached(str);
                return;
            }
            return;
        }
        PreloadTask preloadTask = new PreloadTask();
        preloadTask.mRawUrl = str;
        preloadTask.mPosition = i;
        preloadTask.mPreloadLimit = i2;
        preloadTask.mPreloadListener = preloadListener;
        preloadTask.mCacheServer = this.mHttpProxyCacheServer;
        LogUtils.i(TAG, "addPreloadTask: " + i);
        this.mPreloadTasks.put(str, preloadTask);
        if (this.mIsStartPreload) {
            if (!z) {
                preloadTask.executeOn(this.mExecutorService);
            } else if (NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey() == 1) {
                preloadTask.executeOn(this.mExecutorService);
            }
            LogUtils.d(TAG, "task.executeOn");
        }
    }
}
