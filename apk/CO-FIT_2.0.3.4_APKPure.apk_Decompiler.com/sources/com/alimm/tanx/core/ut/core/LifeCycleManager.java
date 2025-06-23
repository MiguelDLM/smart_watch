package com.alimm.tanx.core.ut.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LifeCycleManager {
    private static final String TAG = "LifeCycleManager";
    private static volatile LifeCycleManager instance;
    private ActivityLifeCycle activityLifeCycle;
    /* access modifiers changed from: private */
    public volatile ConcurrentHashMap<String, Integer> activityVisibleMap = new ConcurrentHashMap<>(1000);
    private ConcurrentHashMap<String, AppVisibleCallBack> appVisibleCallBacks = new ConcurrentHashMap<>();
    private boolean nowBackground = false;
    private boolean secondUp = false;

    public class ActivityLifeCycle implements Application.ActivityLifecycleCallbacks {
        private ActivityLifeCycle() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            LogUtils.d(LifeCycleManager.TAG, "onActivityCreated ，activity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
            LogUtils.d(LifeCycleManager.TAG, "onActivityPaused，activity.");
            try {
                LogUtils.d(LifeCycleManager.TAG, "onActivityPaused，activity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
                String name = activity.getClass().getName();
                if (LifeCycleManager.this.activityVisibleMap != null && LifeCycleManager.this.activityVisibleMap.get(name) != null) {
                    int intValue = ((Integer) LifeCycleManager.this.activityVisibleMap.get(name)).intValue();
                    if (intValue > 1) {
                        LifeCycleManager.this.activityVisibleMap.put(name, Integer.valueOf(intValue - 1));
                    } else {
                        LifeCycleManager.this.activityVisibleMap.remove(name);
                    }
                }
            } catch (Exception e) {
                LogUtils.e(LifeCycleManager.TAG, e);
            }
        }

        public void onActivityResumed(Activity activity) {
            try {
                String name = activity.getClass().getName();
                if (LifeCycleManager.this.activityVisibleMap.get(activity.getClass().getName()) == null) {
                    LifeCycleManager.this.activityVisibleMap.put(name, 1);
                } else {
                    LifeCycleManager.this.activityVisibleMap.put(activity.getClass().getName(), Integer.valueOf(((Integer) LifeCycleManager.this.activityVisibleMap.get(activity.getClass().getName())).intValue() + 1));
                }
                LogUtils.d(LifeCycleManager.TAG, "onActivityResumed ，activity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
                LifeCycleManager.this.setStatus();
                LifeCycleManager.this.appVisibleExecute();
            } catch (Exception e) {
                LogUtils.e(LifeCycleManager.TAG, e);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            LogUtils.d(LifeCycleManager.TAG, "onActivityStarted :，activity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
        }

        public void onActivityStopped(Activity activity) {
            LogUtils.d(LifeCycleManager.TAG, "onActivityStoppedactivity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
            LifeCycleManager.this.setStatus();
            LifeCycleManager.this.appBackgroundExecute();
        }
    }

    public interface AppVisibleCallBack {
        void appVisibleCallBack(boolean z, boolean z2);
    }

    /* access modifiers changed from: private */
    public void appBackgroundExecute() {
        notice();
    }

    /* access modifiers changed from: private */
    public void appVisibleExecute() {
        notice();
    }

    public static LifeCycleManager getInstance() {
        if (instance == null) {
            synchronized (LifeCycleManager.class) {
                try {
                    if (instance == null) {
                        instance = new LifeCycleManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private void notice() {
        ConcurrentHashMap<String, AppVisibleCallBack> concurrentHashMap = this.appVisibleCallBacks;
        if (concurrentHashMap != null) {
            for (Map.Entry next : concurrentHashMap.entrySet()) {
                if (next.getValue() != null) {
                    ((AppVisibleCallBack) next.getValue()).appVisibleCallBack(this.nowBackground, this.secondUp);
                } else {
                    unRegister((String) next.getKey());
                }
            }
        }
    }

    public void init() {
        this.activityLifeCycle = new ActivityLifeCycle();
        TanxCoreSdk.getApplication().registerActivityLifecycleCallbacks(this.activityLifeCycle);
    }

    public void register(String str, AppVisibleCallBack appVisibleCallBack) {
        if (this.appVisibleCallBacks == null) {
            this.appVisibleCallBacks = new ConcurrentHashMap<>();
        }
        this.appVisibleCallBacks.put(str, appVisibleCallBack);
    }

    public boolean setStatus() {
        String str;
        boolean z = false;
        if (!this.nowBackground || this.activityVisibleMap.size() <= 0) {
            this.secondUp = false;
        } else {
            this.secondUp = true;
        }
        if (this.activityVisibleMap.size() <= 0) {
            z = true;
        }
        this.nowBackground = z;
        StringBuilder sb = new StringBuilder();
        sb.append("UserReport :当前前后台状态：->");
        if (this.nowBackground) {
            str = "后台";
        } else {
            str = "前台";
        }
        sb.append(str);
        LogUtils.d(TAG, sb.toString());
        LogUtils.d(TAG, "UserReport :activityVisibleMap：->" + this.activityVisibleMap.toString());
        return this.nowBackground;
    }

    public void unRegister(String str) {
        ConcurrentHashMap<String, AppVisibleCallBack> concurrentHashMap;
        try {
            if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.appVisibleCallBacks) != null) {
                Iterator<Map.Entry<String, AppVisibleCallBack>> it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (((String) it.next().getKey()).equals(str)) {
                        it.remove();
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.e(e);
        }
    }

    public void unRegisterAll() {
        ConcurrentHashMap<String, AppVisibleCallBack> concurrentHashMap = this.appVisibleCallBacks;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }
}
