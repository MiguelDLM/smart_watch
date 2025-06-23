package com.baidu.ar.arplay.core.engine;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class ARPScriptEnvironment {
    public static final String KEY_AR_KEY = "ar_key";
    public static final String KEY_AR_TYPE = "ar_type";
    public static final String KEY_DATA_CAMERA_POSITION = "camera_position";
    public static final String KEY_DATA_PIP_IMU = "imu";
    public static final String KEY_DATA_PIP_SLAM = "slam";
    public static final String KEY_DATA_PIP_TRACK = "track";
    private static ARPScriptEnvironment mInstance;
    private Map mEnvironment = new HashMap();
    private Map mDataPip = new HashMap();
    private Lock mLock = new ReentrantLock();

    public static ARPScriptEnvironment getInstance() {
        ARPScriptEnvironment aRPScriptEnvironment;
        ARPScriptEnvironment aRPScriptEnvironment2 = mInstance;
        if (aRPScriptEnvironment2 != null) {
            return aRPScriptEnvironment2;
        }
        synchronized (ARPScriptEnvironment.class) {
            try {
                if (mInstance == null) {
                    mInstance = new ARPScriptEnvironment();
                }
                aRPScriptEnvironment = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aRPScriptEnvironment;
    }

    public static native Object nativeGetSharedEnvironment();

    public static native void nativeSetDataPip(Object obj);

    public static native void nativeSetSharedEnvironment(Object obj);

    public static void setSharedEnvironment(Map map) {
        if (map == null) {
            return;
        }
        nativeSetSharedEnvironment(map);
    }

    public Object getSharedEnvironmentValue(String str) {
        Object obj;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mLock.lock();
        try {
            try {
                obj = nativeGetSharedEnvironment();
            } catch (Exception e) {
                e.printStackTrace();
                this.mLock.unlock();
                obj = null;
            }
            if (obj instanceof HashMap) {
                return ((HashMap) obj).get(str);
            }
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    public void release() {
        Map map = this.mEnvironment;
        if (map != null) {
            map.clear();
        }
        Map map2 = this.mDataPip;
        if (map2 != null) {
            map2.clear();
        }
    }

    public void setDataPipKV(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (obj == null) {
            this.mDataPip.remove(str);
        }
        this.mDataPip.put(str, obj);
        nativeSetDataPip(this.mDataPip);
    }

    public void setLocalEnvironmentKV(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (obj == null) {
            this.mEnvironment.remove(str);
        }
        this.mEnvironment.put(str, obj);
    }

    public void setSharedEnvironmentKV(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLock.lock();
        try {
            if (obj == null) {
                try {
                    this.mEnvironment.remove(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mEnvironment.put(str, obj);
            nativeSetSharedEnvironment(this.mEnvironment);
            this.mLock.unlock();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void syncSharedEnvironmentData() {
        this.mLock.lock();
        try {
            try {
                nativeSetSharedEnvironment(this.mEnvironment);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void testEnvironmentData() {
        nativeGetSharedEnvironment();
        Log.e("ARPScriptEnvironment", "getSharedEnvironmentValue(KEY_AR_KEY) :" + getSharedEnvironmentValue("ar_key"));
        getSharedEnvironmentValue("test");
        Log.e("ARPScriptEnvironment", "end");
    }
}
