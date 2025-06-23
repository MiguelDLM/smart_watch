package com.baidu.navisdk.adapter;

import android.content.Context;
import com.baidu.navisdk.adapter.struct.BNaviInitConfig;

/* loaded from: classes7.dex */
public interface IBaiduNaviManager {

    /* loaded from: classes7.dex */
    public interface INaviInitListener {
        void initFailed(int i);

        void initStart();

        void initSuccess();

        void onAuthResult(int i, String str);
    }

    void enableOutLog(boolean z);

    void externalLocation(boolean z);

    String getCUID();

    String getSDKVersion();

    void init(Context context, BNaviInitConfig bNaviInitConfig);

    void initSensor();

    boolean isInited();

    void setGpsNeverClose(boolean z);

    void setVdrEnable(boolean z);

    void startLocationMonitor();

    void stopLocationMonitor();

    void unInitSensor();
}
