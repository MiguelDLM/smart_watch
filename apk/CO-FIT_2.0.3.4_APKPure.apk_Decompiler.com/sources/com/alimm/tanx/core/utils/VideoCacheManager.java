package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.view.player.cache.PreloadManager;
import com.alimm.tanx.core.view.player.cache.VideoGetSizeManager;
import com.alimm.tanx.core.view.player.cache.videocache.PreloadListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VideoCacheManager implements NotConfused {
    private static final int CACHED_WEB_VIEW_MAX_NUM = 10;
    static final String TAG = "VideoCacheManager";
    private static VideoCacheManager instance = null;
    /* access modifiers changed from: private */
    public static boolean isOnlyWifiCache = false;
    public static LinkedHashMap<String, ITanxAd> mCachedVideoMap = new LinkedHashMap<String, ITanxAd>(10) {
        public boolean removeEldestEntry(Map.Entry<String, ITanxAd> entry) {
            if (VideoCacheManager.mCachedVideoMap.size() > 10) {
                return true;
            }
            return false;
        }
    };

    public static VideoCacheManager getInstance() {
        if (instance == null) {
            synchronized (VideoCacheManager.class) {
                try {
                    if (instance == null) {
                        instance = new VideoCacheManager();
                        NetWorkUtil.registerReceiver(new NetWorkUtil.NetStateChangeListener() {
                            public void onDisconnect() {
                                LogUtils.d(VideoCacheManager.TAG, "onDisconnect");
                            }

                            public void onMobileConnect() {
                                if (VideoCacheManager.isOnlyWifiCache) {
                                    PreloadManager.getInstance(TanxCoreSdk.getApplication()).pauseAll();
                                }
                                LogUtils.d(VideoCacheManager.TAG, "onMobileConnect");
                            }

                            public void onWifiConnect() {
                                LogUtils.d(VideoCacheManager.TAG, "onWifiConnect");
                                PreloadManager.getInstance(TanxCoreSdk.getApplication()).resumeAll();
                            }
                        });
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private void pushCache(String str, ITanxAd iTanxAd) {
        LogUtils.d("video pushCache", new String[0]);
        mCachedVideoMap.put(str, iTanxAd);
    }

    public void clearThis(ITanxAd iTanxAd) {
        if (iTanxAd != null && iTanxAd.getBidInfo() != null && iTanxAd.getBidInfo().getCreativeItem() != null && !TextUtils.isEmpty(iTanxAd.getBidInfo().getCreativeItem().getVideo())) {
            clearThis(iTanxAd.getBidInfo().getCreativeItem().getVideo());
        }
    }

    public ITanxAd getVideoCacheSuccAd(String str) {
        LinkedHashMap<String, ITanxAd> linkedHashMap = mCachedVideoMap;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            return null;
        }
        return mCachedVideoMap.get(str);
    }

    public void preload(ITanxAd iTanxAd, boolean z, PreloadListener preloadListener) {
        isOnlyWifiCache = z;
        if (iTanxAd != null && iTanxAd.getBidInfo() != null && iTanxAd.getBidInfo().getCreativeItem() != null && !TextUtils.isEmpty(iTanxAd.getBidInfo().getCreativeItem().getVideo())) {
            if (preloadListener != null) {
                preloadListener.onStartCached(iTanxAd);
            }
            pushCache(iTanxAd.getBidInfo().getCreativeItem().getVideo(), iTanxAd);
            PreloadManager.getInstance(TanxCoreSdk.getApplication()).addPreloadTask(iTanxAd.getBidInfo().getCreativeItem().getVideo(), z, preloadListener);
            VideoGetSizeManager.getInstance(TanxCoreSdk.getApplication()).getVideoSize(iTanxAd);
        }
    }

    public void clearThis(String str) {
        try {
            Iterator<String> it = mCachedVideoMap.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(str)) {
                    it.remove();
                    return;
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    public void preload(List<ITanxAd> list, boolean z, PreloadListener preloadListener) {
        isOnlyWifiCache = z;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                preload(list.get(i), z, preloadListener);
            }
        }
    }
}
