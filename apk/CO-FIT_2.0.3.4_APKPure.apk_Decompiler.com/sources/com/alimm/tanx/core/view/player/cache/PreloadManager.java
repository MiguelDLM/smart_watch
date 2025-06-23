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

public class PreloadManager {
    public static final int PRELOAD_LENGTH = 1048576;
    private static final String TAG = "PreloadManager";
    private static PreloadManager sPreloadManager;
    private final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    private HttpProxyCacheServer mHttpProxyCacheServer;
    private boolean mIsStartPreload = true;
    private final LinkedHashMap<String, PreloadTask> mPreloadTasks = new LinkedHashMap<>();

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
                } catch (Throwable th) {
                    throw th;
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
        for (Map.Entry<String, PreloadTask> value : this.mPreloadTasks.entrySet()) {
            PreloadTask preloadTask = (PreloadTask) value.getValue();
            if (z) {
                if (preloadTask.mPosition < i && !isPreloaded(preloadTask.mRawUrl)) {
                    preloadTask.executeOn(this.mExecutorService);
                }
            } else if (preloadTask.mPosition > i && !isPreloaded(preloadTask.mRawUrl)) {
                preloadTask.executeOn(this.mExecutorService);
            }
        }
    }

    public boolean deleteCacheFile(String str) {
        try {
            File cacheFile = ProxyCacheManager.getCacheFile(str);
            if (!cacheFile.exists()) {
                return true;
            }
            cacheFile.delete();
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
        if (!cacheFile.exists()) {
            File tempCacheFile = ProxyCacheManager.getTempCacheFile(str);
            if (!tempCacheFile.exists() || tempCacheFile.length() < 1048576) {
                return false;
            }
            return true;
        } else if (cacheFile.length() >= 1024) {
            return true;
        } else {
            cacheFile.delete();
            return false;
        }
    }

    public void pauseAll() {
        LogUtils.d(TAG, "pauseAll");
        for (Map.Entry<String, PreloadTask> value : this.mPreloadTasks.entrySet()) {
            PreloadTask preloadTask = (PreloadTask) value.getValue();
            if (!isPreloaded(preloadTask.mRawUrl)) {
                preloadTask.cancel();
            }
        }
    }

    public void pausePreload(int i, boolean z) {
        LogUtils.d(TAG, "pausePreload：" + i + " isReverseScroll: " + z);
        this.mIsStartPreload = false;
        for (Map.Entry<String, PreloadTask> value : this.mPreloadTasks.entrySet()) {
            PreloadTask preloadTask = (PreloadTask) value.getValue();
            if (z) {
                if (preloadTask.mPosition >= i) {
                    preloadTask.cancel();
                }
            } else if (preloadTask.mPosition <= i) {
                preloadTask.cancel();
            }
        }
    }

    public void removeAllPreloadTask() {
        Iterator<Map.Entry<String, PreloadTask>> it = this.mPreloadTasks.entrySet().iterator();
        while (it.hasNext()) {
            ((PreloadTask) it.next().getValue()).cancel();
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
        for (Map.Entry<String, PreloadTask> value : this.mPreloadTasks.entrySet()) {
            PreloadTask preloadTask = (PreloadTask) value.getValue();
            isPreloaded(preloadTask.mRawUrl);
            preloadTask.executeOn(this.mExecutorService);
        }
    }

    public void resumePreload(int i, boolean z) {
        LogUtils.d(TAG, "resumePreload：" + i + " isReverseScroll: " + z);
        this.mIsStartPreload = true;
        for (Map.Entry<String, PreloadTask> value : this.mPreloadTasks.entrySet()) {
            PreloadTask preloadTask = (PreloadTask) value.getValue();
            if (z) {
                if (preloadTask.mPosition < i) {
                    isPreloaded(preloadTask.mRawUrl);
                    preloadTask.executeOn(this.mExecutorService);
                }
            } else if (preloadTask.mPosition > i) {
                isPreloaded(preloadTask.mRawUrl);
                preloadTask.executeOn(this.mExecutorService);
            }
        }
    }

    public void stopAllPreloadTask() {
        for (Map.Entry<String, PreloadTask> value : this.mPreloadTasks.entrySet()) {
            ((PreloadTask) value.getValue()).cancel();
        }
    }

    public void addPreloadTask(String str, int i, int i2, boolean z, PreloadListener preloadListener) {
        if (this.mHttpProxyCacheServer == null) {
            LogUtils.e(TAG, "addPreloadTask-mHttpProxyCacheServer为空");
        } else if (!isPreloaded(str)) {
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
        } else if (preloadListener != null) {
            preloadListener.onCached(str);
        }
    }
}
