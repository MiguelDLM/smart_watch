package com.alimm.tanx.core.utils;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.feed.FeedVideoManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PlayerListManager implements NotConfused {
    private static final int PLAYER_MAX_NUM = 20;
    static final String TAG = "PlayerListManager";
    private static PlayerListManager instance;
    public static LinkedHashMap<String, FeedVideoManager> mPlayerMap = new LinkedHashMap<String, FeedVideoManager>(20) { // from class: com.alimm.tanx.core.utils.PlayerListManager.1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, FeedVideoManager> entry) {
            boolean z;
            if (PlayerListManager.mPlayerMap.size() > 20) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                LogUtils.d(PlayerListManager.TAG, "FeedVideoManager 缓存超出20个，回收:" + entry.getKey());
                PlayerListManager.destroy(entry);
            }
            return z;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroy(Map.Entry<String, FeedVideoManager> entry) {
        if (entry != null && entry.getValue() != null) {
            entry.getValue().destroy();
        }
    }

    public static PlayerListManager getInstance() {
        if (instance == null) {
            synchronized (PlayerListManager.class) {
                try {
                    if (instance == null) {
                        instance = new PlayerListManager();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private boolean isITanxAdNull(ITanxAd iTanxAd) {
        if (iTanxAd != null && iTanxAd.getBidInfo() != null && !TextUtils.isEmpty(iTanxAd.getBidInfo().getSessionId())) {
            return false;
        }
        return true;
    }

    private static void pause(Map.Entry<String, FeedVideoManager> entry) {
        if (entry != null && entry.getValue() != null) {
            LogUtils.d(TAG, "暂停sessionId：" + entry.getValue().getSessionId());
            entry.getValue().pause();
        }
    }

    public void clearAll() {
        try {
            LinkedHashMap<String, FeedVideoManager> linkedHashMap = mPlayerMap;
            if (linkedHashMap != null && linkedHashMap.size() > 0) {
                Iterator<Map.Entry<String, FeedVideoManager>> it = mPlayerMap.entrySet().iterator();
                if (it.hasNext()) {
                    destroy(it.next());
                    it.remove();
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    public void clearOtherPlayer(ITanxAd iTanxAd) {
        try {
            if (!isITanxAdNull(iTanxAd)) {
                Iterator<Map.Entry<String, FeedVideoManager>> it = mPlayerMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, FeedVideoManager> next = it.next();
                    if (!next.getKey().equals(iTanxAd.getBidInfo().getSessionId())) {
                        destroy(next);
                        it.remove();
                        return;
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    public void clearThis(ITanxAd iTanxAd) {
        if (!isITanxAdNull(iTanxAd)) {
            clearThis(iTanxAd.getBidInfo().getSessionId());
        } else {
            LogUtils.d("clearThis error  iTanxAd  == null", new String[0]);
        }
    }

    public FeedVideoManager getFeedVideoManager4SessionId(ITanxAd iTanxAd) {
        LinkedHashMap<String, FeedVideoManager> linkedHashMap;
        if (!isITanxAdNull(iTanxAd) && (linkedHashMap = mPlayerMap) != null && linkedHashMap.size() > 0) {
            return mPlayerMap.get(iTanxAd.getBidInfo().getSessionId());
        }
        return null;
    }

    public void putFeedVideoManager(ITanxAd iTanxAd, FeedVideoManager feedVideoManager) {
        if (isITanxAdNull(iTanxAd)) {
            LogUtils.d("putFeedVideoManager error iTanxAd == null", new String[0]);
            return;
        }
        LogUtils.d("putFeedVideoManager push sessionId:" + iTanxAd.getBidInfo().getSessionId(), new String[0]);
        mPlayerMap.put(iTanxAd.getBidInfo().getSessionId(), feedVideoManager);
    }

    public void stopOtherPlayer(ITanxAd iTanxAd) {
        try {
            if (!isITanxAdNull(iTanxAd)) {
                for (Map.Entry<String, FeedVideoManager> entry : mPlayerMap.entrySet()) {
                    LogUtils.d(TAG, "stopOtherPlayer: 循环：" + entry.getKey() + " 当前广告id：" + iTanxAd.getBidInfo().getSessionId());
                    if (!entry.getKey().equals(iTanxAd.getBidInfo().getSessionId())) {
                        pause(entry);
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    private void clearThis(String str) {
        try {
            Iterator<Map.Entry<String, FeedVideoManager>> it = mPlayerMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, FeedVideoManager> next = it.next();
                if (next.getKey().equals(str)) {
                    destroy(next);
                    it.remove();
                    return;
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }
}
