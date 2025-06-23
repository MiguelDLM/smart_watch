package com.alimm.tanx.core.view.player.cache;

import android.content.Context;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.core.thread.VideoSizeThreadPool;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class VideoGetSizeManager {
    private static final int CACHED_VIDEO_SIZE_MAX_NUM = 50;
    private static final String TAG = "VideoGetSizeManager";
    public static LinkedHashMap<String, Long> mCachedVideoSizeMap = new LinkedHashMap<String, Long>(50) { // from class: com.alimm.tanx.core.view.player.cache.VideoGetSizeManager.1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
            if (VideoGetSizeManager.mCachedVideoSizeMap.size() > 50) {
                return true;
            }
            return false;
        }
    };
    private static VideoGetSizeManager sPreloadManager;
    long tempSize = 50;

    private VideoGetSizeManager(Context context) {
    }

    public static VideoGetSizeManager getInstance(Context context) {
        if (sPreloadManager == null) {
            synchronized (VideoGetSizeManager.class) {
                try {
                    if (sPreloadManager == null) {
                        sPreloadManager = new VideoGetSizeManager(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return sPreloadManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVideoSize$13(String str, ITanxAd iTanxAd) {
        int i;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            long contentLength = httpURLConnection.getContentLength();
            if (contentLength > 0) {
                mCachedVideoSizeMap.put(str, Long.valueOf(contentLength));
                if (OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) > -1) {
                    this.tempSize = OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) * 1048576;
                }
                if (contentLength > this.tempSize) {
                    i = 1;
                } else {
                    i = 0;
                }
                TanxCommonUt.fileSizeCheck(iTanxAd, contentLength, i, System.currentTimeMillis() - currentTimeMillis);
            }
            LogUtils.d(TAG, "视频:" + str + " 长度：" + httpURLConnection.getContentLength() + " 时间：" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e(TAG, e);
        }
    }

    public void getVideoSize(final ITanxAd iTanxAd) {
        LogUtils.d(TAG, "getVideoSize");
        final String video = iTanxAd.getBidInfo().getCreativeItem().getVideo();
        if (isPreloaded(video)) {
            return;
        }
        VideoSizeThreadPool.post(new Runnable() { // from class: com.alimm.tanx.core.view.player.cache.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                VideoGetSizeManager.this.lambda$getVideoSize$13(video, iTanxAd);
            }
        });
    }

    public boolean isPreloaded(String str) {
        if (mCachedVideoSizeMap.get(str) != null) {
            return true;
        }
        return false;
    }
}
