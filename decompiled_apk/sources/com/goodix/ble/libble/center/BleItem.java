package com.goodix.ble.libble.center;

import com.goodix.ble.libble.v2.gb.GBRemoteDevice;
import com.goodix.ble.libble.v2.gb.gatt.profile.GBGattProfile;
import com.goodix.ble.libcomx.logger.RingLogger;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class BleItem {

    /* renamed from: a, reason: collision with root package name */
    private Object f16142a;
    protected GBRemoteDevice gatt;
    protected RingLogger logger;
    protected HashMap<String, Object> moduleMap = null;
    protected int refCounter = 0;

    public void a(GBRemoteDevice gBRemoteDevice) {
        this.gatt = gBRemoteDevice;
    }

    public <T> T getDeviceModel() {
        try {
            return (T) this.f16142a;
        } catch (Exception e) {
            e.printStackTrace();
            RingLogger ringLogger = this.logger;
            if (ringLogger == null) {
                return null;
            }
            ringLogger.w(BleItem.class.getSimpleName(), e.getMessage());
            return null;
        }
    }

    public GBRemoteDevice getGatt() {
        return this.gatt;
    }

    public RingLogger getLogger() {
        return this.logger;
    }

    public <T> T getModule(Class<T> cls) {
        return (T) getModule(cls.getName());
    }

    public synchronized void release() {
        int i = this.refCounter;
        if (i > 0) {
            int i2 = i - 1;
            this.refCounter = i2;
            if (i2 == 0) {
                BleCenter.get().remove(this);
            }
        }
    }

    public <T extends GBGattProfile> T requireProfile(Class<T> cls) {
        Throwable e;
        T t;
        T t2 = (T) getModule(cls.getName());
        if (t2 != null) {
            return t2;
        }
        try {
            t = cls.newInstance();
            try {
                setModule(t);
                t.bindTo(this.gatt);
            } catch (IllegalAccessException e2) {
                e = e2;
                e.printStackTrace();
                return t;
            } catch (InstantiationException e3) {
                e = e3;
                e.printStackTrace();
                return t;
            }
        } catch (IllegalAccessException | InstantiationException e4) {
            e = e4;
            t = t2;
        }
        return t;
    }

    public synchronized void retain() {
        this.refCounter++;
    }

    public void setLogger(RingLogger ringLogger) {
        this.logger = ringLogger;
        GBRemoteDevice gBRemoteDevice = this.gatt;
        if (gBRemoteDevice != null) {
            gBRemoteDevice.setLogger(ringLogger);
        }
    }

    public BleItem setModule(Object obj) {
        return setModule(obj.getClass().getName(), obj);
    }

    public void a(Object obj) {
        this.f16142a = obj;
    }

    public <T> T getModule(String str) {
        T t;
        HashMap<String, Object> hashMap = this.moduleMap;
        if (hashMap == null) {
            return null;
        }
        synchronized (this) {
            try {
                try {
                    t = (T) hashMap.get(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    public BleItem setModule(String str, Object obj) {
        synchronized (this) {
            try {
                if (this.moduleMap == null) {
                    this.moduleMap = new HashMap<>();
                }
                this.moduleMap.put(str, obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return this;
    }
}
