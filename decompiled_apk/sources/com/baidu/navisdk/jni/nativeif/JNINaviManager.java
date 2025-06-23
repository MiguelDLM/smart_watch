package com.baidu.navisdk.jni.nativeif;

import android.os.Bundle;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class JNINaviManager {
    private static final String TAG = "JNINaviManager";
    public static JNINaviManager sInstance = new JNINaviManager();
    private int initState = -1;
    private JNICloudDataInterface mCloudDataInterface;

    /* loaded from: classes7.dex */
    public interface GetConfigType {
        public static final int CORE_STATISTIC = 3;
        public static final int Invalid = 0;
        public static final int LIMIT_FRAME = 2;
        public static final int POLYPHONE = 1;
    }

    /* loaded from: classes7.dex */
    public interface LogPathType {
        public static final int INIT_LOG = 0;
        public static final int RP_LOG = 1;
    }

    /* loaded from: classes7.dex */
    public interface RetEnum {
        public static final int ACTIVATE_FAIL = 2;
        public static final int DATA_FORMAT_ERROR = 3;
        public static final int FAIL = 1;
        public static final int INVALID = -1;
        public static final int SUCCESS = 0;
    }

    private JNINaviManager() {
    }

    private native int initNaviManager(Object obj);

    private native int uninitNaviManager();

    public native boolean getABTestResultById(int i, Bundle bundle);

    public JNICloudDataInterface getCloudDataInterface() {
        return this.mCloudDataInterface;
    }

    public native boolean getConfigParamFromEngine(int i, Bundle bundle);

    public native String getIPByHost(String str);

    public native String getInitLogPath(int i);

    public synchronized int init(Object obj) {
        try {
            this.initState = initNaviManager(obj);
            g gVar = g.F_BASE;
            if (gVar.d()) {
                gVar.e(TAG, "int ret:" + this.initState);
            }
            int i = this.initState;
            if (i == 0) {
                this.mCloudDataInterface = new JNICloudDataInterface(i);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.initState;
    }

    public native void initNaviStatistics(int i);

    public native int initSubSystem(int i);

    public native int reInitSearchEngine(int i, Object obj);

    public native int reloadNaviManager(int i, String str);

    public native boolean setABTestBuffer(String str);

    public synchronized int unInit() {
        int uninitNaviManager;
        uninitNaviManager = uninitNaviManager();
        this.initState = -1;
        g gVar = g.F_BASE;
        if (gVar.d()) {
            gVar.e(TAG, "unInit ret:" + uninitNaviManager);
        }
        return uninitNaviManager;
    }

    public native void uninitNaviStatistics();

    public native void uninitSubSystem(int i);

    public native int updateAppSource(int i);
}
