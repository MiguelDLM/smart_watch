package com.alimm.tanx.core.ut.bean;

import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import com.alimm.tanx.core.config.TanxConfig;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.DeviceIdGetUtil;
import com.alimm.tanx.core.utils.NetWorkUtil;

/* loaded from: classes.dex */
public class BaseUtBean extends BaseBean {
    public String androidId;
    public String appId;
    public String appKey;
    public String appName;
    public String appVersion;
    public String brand;
    public int deviceType = 0;
    public int height;
    public String idfa;
    public String imei;
    public String model;
    public int network;
    public String oaid;
    public int operator;
    public int orientation;
    public String os;
    public String osv;
    public String packageName;
    public int pixelRatio;
    public String sdkVersion;
    public String userAgent;
    public String utdid;
    public int width;

    public BaseUtBean() {
        TanxConfig config = TanxCoreSdk.getConfig();
        RequestBaseBean.AdDeviceBean utDeviceBean = AndroidUtils.getUtDeviceBean();
        if (config != null) {
            this.appKey = config.getAppKey();
            this.appId = config.getAppId();
            this.appName = config.getAppName();
            if (utDeviceBean != null) {
                this.userAgent = utDeviceBean.user_agent;
                this.androidId = utDeviceBean.android_id;
                this.brand = utDeviceBean.brand;
                this.model = utDeviceBean.model;
                this.os = utDeviceBean.os;
                this.osv = utDeviceBean.osv;
                this.operator = NetWorkUtil.getOperatorType(TanxCoreSdk.getApplication());
                this.width = utDeviceBean.width;
                this.height = utDeviceBean.height;
                this.pixelRatio = utDeviceBean.pixel_ratio;
            }
            this.imei = DeviceIdGetUtil.getInstance().getImei(true);
            this.oaid = DeviceIdGetUtil.getInstance().getOaid(true);
            this.sdkVersion = SdkConstant.getSdkVersion();
        }
        this.packageName = AndroidUtils.getPackageName(TanxCoreSdk.getApplication());
        this.appVersion = AndroidUtils.getAppVersion(TanxCoreSdk.getApplication(), this.packageName);
        this.network = NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey();
        this.orientation = AndroidUtils.getScreenOrientation(TanxCoreSdk.getApplication());
    }

    public String toString() {
        return "BaseUtBean{appKey='" + this.appKey + "', appId='" + this.appId + "', appName='" + this.appName + "', appVersion='" + this.appVersion + "', packageName='" + this.packageName + "', userAgent='" + this.userAgent + "', network=" + this.network + ", orientation=" + this.orientation + ", imei='" + this.imei + "', oaid='" + this.oaid + "', androidId='" + this.androidId + "', deviceType=" + this.deviceType + ", brand='" + this.brand + "', model='" + this.model + "', os='" + this.os + "', osv='" + this.osv + "', operator=" + this.operator + ", width=" + this.width + ", height=" + this.height + ", pixelRatio=" + this.pixelRatio + ", sdkVersion='" + this.sdkVersion + "'} " + super.toString();
    }
}
