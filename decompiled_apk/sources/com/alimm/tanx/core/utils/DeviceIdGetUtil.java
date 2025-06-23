package com.alimm.tanx.core.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import xo.X0o0xo;
import xo.XO;

/* loaded from: classes.dex */
public class DeviceIdGetUtil implements NotConfused {
    private static final int DEVICE_ID_GET_MAX_COUNT = 3;
    private static final String TAG = "DeviceIdGetUtil-";
    private static DeviceIdGetUtil instance;
    private volatile int imeiGetNowCount = 0;
    private volatile int oaidGetNowCount = 0;
    private volatile String oaid = "";
    private volatile String imei = "";

    private DeviceIdGetUtil() {
    }

    private void getImei4OnlyId(Context context, boolean z) {
        if (!TextUtils.isEmpty(this.imei)) {
            return;
        }
        String imei = TanxCoreSdk.getConfig().getImei();
        if (!TextUtils.isEmpty(imei)) {
            this.imei = imei;
        }
        if (context == null) {
            LogUtils.e(TAG, "getImei4OnlyId 设备id工具类未初始化，或入参context为空");
            return;
        }
        if (z) {
            this.oaid = X0o0xo.II0XooXoX().Oxx0IOOO(context, z);
            return;
        }
        if (TanxCoreSdk.getConfig().isImeiSwitch()) {
            if (this.imeiGetNowCount >= 3) {
                return;
            }
            LogUtils.d(TAG, "通过api调用获取imei");
            String XO2 = X0o0xo.II0XooXoX().XO(context);
            if (!TextUtils.isEmpty(XO2)) {
                this.imei = XO2;
            }
            this.imeiGetNowCount++;
        }
        LogUtils.d("DeviceIdGetUtil-imeiGet", this.imei);
    }

    public static DeviceIdGetUtil getInstance() {
        if (instance == null) {
            synchronized (X0o0xo.class) {
                try {
                    if (instance == null) {
                        instance = new DeviceIdGetUtil();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    private void getOaid4OnlyId(Context context, boolean z) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(this.oaid)) {
            return;
        }
        String oaid = TanxCoreSdk.getConfig().getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            this.oaid = oaid;
        }
        if (context == null) {
            LogUtils.e(TAG, "getOaid4OnlyId 设备id工具类未初始化，或入参context为空");
            return;
        }
        if (z) {
            this.oaid = X0o0xo.II0XooXoX().xoIox(context, z);
        } else {
            if (!TanxCoreSdk.getConfig().isOaidSwitch() || this.oaidGetNowCount >= 3) {
                return;
            }
            LogUtils.d(TAG, "通过api调用获取oaid");
            X0o0xo.II0XooXoX().OOXIXo(context, false, new XO() { // from class: com.alimm.tanx.core.utils.DeviceIdGetUtil.1
                @Override // xo.XO
                public void oaidError(Exception exc) {
                    LogUtils.e("DeviceIdGetUtil-oaidGet", exc);
                    if (Build.VERSION.SDK_INT >= 29) {
                        TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "DeviceIdGetUtil-oaidGet", LogUtils.getStackTraceMessage(exc), "");
                    }
                }

                @Override // xo.XO
                public void oaidSucc(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        DeviceIdGetUtil.this.oaid = str;
                    }
                    LogUtils.d("DeviceIdGetUtil-oaidGet", str + "\ntime-> " + (System.currentTimeMillis() - currentTimeMillis));
                }
            });
            this.oaidGetNowCount++;
        }
    }

    public void getAllIdOnlyCache() {
        try {
            LogUtils.d(TAG, "getAllIdOnlyCache");
            getImei(true);
            getOaid(true);
        } catch (Exception e) {
            LogUtils.e("DeviceIdGetUtil-getAllIdOnlyCache", e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "DeviceIdGetUtil-getAllIdOnlyCache", LogUtils.getStackTraceMessage(e), "");
        }
    }

    public String getImei() {
        return getImei(false);
    }

    public String getOaid() {
        return getOaid(false);
    }

    public void init(Application application) {
        LogUtils.d(TAG, "init");
        X0o0xo.II0XooXoX().x0XOIxOo(application);
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public String getImei(boolean z) {
        return getImei(TanxCoreSdk.getApplication(), z);
    }

    public String getOaid(boolean z) {
        return getOaid(TanxCoreSdk.getApplication(), z);
    }

    public String getImei(Context context, boolean z) {
        getImei4OnlyId(context, z);
        return this.imei;
    }

    public String getOaid(Context context, boolean z) {
        getOaid4OnlyId(context, z);
        return this.oaid;
    }
}
