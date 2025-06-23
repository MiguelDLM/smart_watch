package com.baidu.location;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.iflytek.sparkchain.utils.constants.ErrorCode;
import com.sifli.siflidfu.constants.Timeout;

/* loaded from: classes7.dex */
public final class LocationClientOption {
    public static final int FUZZY_MODE = 4;
    public static final int GPS_FIRST = 1;
    public static final int GPS_ONLY = 2;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NETWORK_FIRST = 3;

    /* renamed from: a, reason: collision with root package name */
    protected LocationMode f5605a;
    public String addrType;
    public float autoNotifyLocSensitivity;
    public int autoNotifyMaxInterval;
    public int autoNotifyMinDistance;
    public int autoNotifyMinTimeInterval;
    public String coorType;
    public boolean disableLocCache;
    public boolean enableSimulateGps;
    public FirstLocType firstLocType;
    public boolean isEnableBeidouMode;
    public boolean isIgnoreCacheException;
    public boolean isIgnoreKillProcess;
    public boolean isNeedAltitude;
    public boolean isNeedAptag;
    public boolean isNeedAptagd;
    public boolean isNeedNewVersionRgc;
    public boolean isNeedPoiRegion;
    public boolean isNeedRegular;
    public boolean isOnceLocation;
    public int locLegalStatus;
    public boolean location_change_notify;
    public boolean mIsNeedDeviceDirect;
    public String mPassword;
    public String mProxyHost;
    public int mProxyPort;
    public String mUsername;
    public boolean openGps;
    public int priority;
    public String prodName;
    public int scanSpan;
    public String serviceName;
    public int timeOut;
    public int wifiCacheTimeOut;

    /* loaded from: classes7.dex */
    public enum BDLocationPurpose {
        SignIn,
        Sport,
        Transport
    }

    /* loaded from: classes7.dex */
    public enum FirstLocType {
        SPEED_IN_FIRST_LOC,
        ACCURACY_IN_FIRST_LOC
    }

    /* loaded from: classes7.dex */
    public enum LocationMode {
        Hight_Accuracy,
        Battery_Saving,
        Device_Sensors,
        Fuzzy_Locating
    }

    public LocationClientOption() {
        this.coorType = "gcj02";
        this.addrType = "noaddr";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = ErrorCode.MSP_ERROR_HTTP_BASE;
        this.prodName = "SDK6.0";
        this.priority = 1;
        this.location_change_notify = false;
        this.disableLocCache = true;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = true;
        this.isIgnoreKillProcess = true;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.isNeedNewVersionRgc = true;
        this.isOnceLocation = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = Integer.MAX_VALUE;
        this.locLegalStatus = 1;
        this.isEnableBeidouMode = false;
        this.firstLocType = FirstLocType.SPEED_IN_FIRST_LOC;
        this.mProxyHost = null;
        this.mProxyPort = -1;
        this.mUsername = null;
        this.mPassword = null;
    }

    public void SetIgnoreCacheException(boolean z) {
        this.isIgnoreCacheException = z;
    }

    public int a() {
        return this.autoNotifyMaxInterval;
    }

    public float b() {
        return this.autoNotifyLocSensitivity;
    }

    public void disableCache(boolean z) {
        this.disableLocCache = z;
    }

    public String getAddrType() {
        return this.addrType;
    }

    public int getAutoNotifyMinDistance() {
        return this.autoNotifyMinDistance;
    }

    public int getAutoNotifyMinTimeInterval() {
        return this.autoNotifyMinTimeInterval;
    }

    public String getCoorType() {
        return this.coorType;
    }

    public LocationMode getLocationMode() {
        return this.f5605a;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getProdName() {
        return this.prodName;
    }

    public int getScanSpan() {
        return this.scanSpan;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public boolean isDisableCache() {
        return this.disableLocCache;
    }

    public boolean isLocationNotify() {
        return this.location_change_notify;
    }

    public boolean isOnceLocation() {
        return this.isOnceLocation;
    }

    public boolean isOpenGnss() {
        return this.openGps;
    }

    @Deprecated
    public boolean isOpenGps() {
        return this.openGps;
    }

    public boolean optionEquals(LocationClientOption locationClientOption) {
        return this.coorType.equals(locationClientOption.coorType) && this.addrType.equals(locationClientOption.addrType) && this.openGps == locationClientOption.openGps && this.scanSpan == locationClientOption.scanSpan && this.timeOut == locationClientOption.timeOut && this.prodName.equals(locationClientOption.prodName) && this.location_change_notify == locationClientOption.location_change_notify && this.priority == locationClientOption.priority && this.disableLocCache == locationClientOption.disableLocCache && this.isIgnoreCacheException == locationClientOption.isIgnoreCacheException && this.isNeedNewVersionRgc == locationClientOption.isNeedNewVersionRgc && this.isIgnoreKillProcess == locationClientOption.isIgnoreKillProcess && this.isNeedAptag == locationClientOption.isNeedAptag && this.isNeedAptagd == locationClientOption.isNeedAptagd && this.isNeedPoiRegion == locationClientOption.isNeedPoiRegion && this.isNeedRegular == locationClientOption.isNeedRegular && this.mIsNeedDeviceDirect == locationClientOption.mIsNeedDeviceDirect && this.autoNotifyMaxInterval == locationClientOption.autoNotifyMaxInterval && this.autoNotifyLocSensitivity == locationClientOption.autoNotifyLocSensitivity && this.autoNotifyMinTimeInterval == locationClientOption.autoNotifyMinTimeInterval && this.autoNotifyMinDistance == locationClientOption.autoNotifyMinDistance && this.wifiCacheTimeOut == locationClientOption.wifiCacheTimeOut && this.isOnceLocation == locationClientOption.isOnceLocation && this.locLegalStatus == locationClientOption.locLegalStatus && this.isEnableBeidouMode == locationClientOption.isEnableBeidouMode && this.isNeedAltitude == locationClientOption.isNeedAltitude && this.f5605a == locationClientOption.f5605a && this.enableSimulateGps == locationClientOption.enableSimulateGps && this.firstLocType == locationClientOption.firstLocType;
    }

    @Deprecated
    public void setAddrType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setIsNeedAddress(TtmlNode.COMBINE_ALL.equals(str));
    }

    public void setCoorType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
            this.coorType = lowerCase;
        }
    }

    public void setEnableSimulateGnss(boolean z) {
        this.enableSimulateGps = z;
    }

    @Deprecated
    public void setEnableSimulateGps(boolean z) {
        this.enableSimulateGps = z;
    }

    public void setFirstLocType(FirstLocType firstLocType) {
        this.firstLocType = firstLocType;
    }

    public void setHttpProxyUsernameAndPassword(String str, String str2) {
        this.mUsername = str;
        this.mPassword = str2;
    }

    public void setIgnoreKillProcess(boolean z) {
        this.isIgnoreKillProcess = z;
    }

    public void setIsEnableBeidouMode(boolean z) {
        this.isEnableBeidouMode = z;
    }

    public void setIsNeedAddress(boolean z) {
        this.addrType = z ? TtmlNode.COMBINE_ALL : "noaddr";
    }

    public void setIsNeedAltitude(boolean z) {
        this.isNeedAltitude = z;
    }

    public void setIsNeedLocationDescribe(boolean z) {
        this.isNeedAptag = z;
    }

    public void setIsNeedLocationPoiList(boolean z) {
        this.isNeedAptagd = z;
    }

    public void setLocStatus(boolean z) {
        this.locLegalStatus = z ? 1 : !z ? -2 : 0;
    }

    public void setLocationMode(LocationMode locationMode) {
        int i = e.f5719a[locationMode.ordinal()];
        if (i == 1) {
            this.openGps = true;
            this.priority = 1;
        } else if (i == 2) {
            this.openGps = false;
            this.priority = 3;
        } else if (i == 3) {
            this.priority = 2;
            this.openGps = true;
        } else {
            if (i != 4) {
                throw new IllegalArgumentException("Illegal this mode : " + locationMode);
            }
            this.priority = 4;
            this.openGps = false;
        }
        this.f5605a = locationMode;
    }

    public void setLocationNotify(boolean z) {
        this.location_change_notify = z;
    }

    public void setLocationPurpose(BDLocationPurpose bDLocationPurpose) {
        if (bDLocationPurpose != null) {
            if (bDLocationPurpose == BDLocationPurpose.SignIn) {
                setLocationMode(LocationMode.Hight_Accuracy);
                setLocationNotify(false);
                setScanSpan(0);
                setNeedNewVersionRgc(true);
                setIsNeedAddress(true);
                setIsNeedLocationPoiList(true);
                setIsNeedAltitude(true);
                setIsNeedLocationDescribe(true);
                setWifiCacheTimeOut(10000);
                return;
            }
            if (bDLocationPurpose == BDLocationPurpose.Sport) {
                setLocationMode(LocationMode.Hight_Accuracy);
                setLocationNotify(true);
                setScanSpan(3000);
            } else {
                if (bDLocationPurpose != BDLocationPurpose.Transport) {
                    return;
                }
                setLocationMode(LocationMode.Hight_Accuracy);
                setLocationNotify(true);
                setScanSpan(1000);
            }
            setNeedNewVersionRgc(true);
            setIsNeedAddress(true);
            setIsNeedLocationPoiList(false);
            setIsNeedAltitude(true);
            setIsNeedLocationDescribe(false);
            setWifiCacheTimeOut(1000);
        }
    }

    public void setNeedDeviceDirect(boolean z) {
        this.mIsNeedDeviceDirect = z;
    }

    public void setNeedNewVersionRgc(boolean z) {
        this.isNeedNewVersionRgc = z;
    }

    public void setOnceLocation(boolean z) {
        this.isOnceLocation = z;
    }

    public void setOpenAutoNotifyMode() {
        setOpenAutoNotifyMode(0, 0, 1);
    }

    public void setOpenGnss(boolean z) {
        this.openGps = z;
    }

    @Deprecated
    public void setOpenGps(boolean z) {
        this.openGps = z;
    }

    @Deprecated
    public void setPriority(int i) {
        if (i == 1 || i == 3) {
            this.priority = i;
        }
    }

    public void setProdName(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.prodName = str;
    }

    public void setProxy(String str, int i) {
        this.mProxyHost = str;
        this.mProxyPort = i;
    }

    public void setScanSpan(int i) {
        if (i >= 0) {
            this.scanSpan = i;
        }
    }

    @Deprecated
    public void setSema(boolean z, boolean z2, boolean z3) {
        this.isNeedAptag = z;
        this.isNeedPoiRegion = z2;
        this.isNeedRegular = z3;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setTimeOut(int i) {
        this.timeOut = i;
    }

    public void setWifiCacheTimeOut(int i) {
        if (i >= 10000) {
            this.wifiCacheTimeOut = i;
        }
    }

    public LocationClientOption(LocationClientOption locationClientOption) {
        this.coorType = "gcj02";
        this.addrType = "noaddr";
        this.openGps = false;
        this.scanSpan = 0;
        this.timeOut = ErrorCode.MSP_ERROR_HTTP_BASE;
        this.prodName = "SDK6.0";
        this.priority = 1;
        this.location_change_notify = false;
        this.disableLocCache = true;
        this.enableSimulateGps = false;
        this.serviceName = "com.baidu.location.service_v2.9";
        this.isIgnoreCacheException = true;
        this.isIgnoreKillProcess = true;
        this.mIsNeedDeviceDirect = false;
        this.isNeedAptag = false;
        this.isNeedAptagd = false;
        this.isNeedPoiRegion = false;
        this.isNeedRegular = false;
        this.isNeedAltitude = false;
        this.isNeedNewVersionRgc = true;
        this.isOnceLocation = false;
        this.autoNotifyMaxInterval = 0;
        this.autoNotifyLocSensitivity = 0.5f;
        this.autoNotifyMinTimeInterval = 0;
        this.autoNotifyMinDistance = 0;
        this.wifiCacheTimeOut = Integer.MAX_VALUE;
        this.locLegalStatus = 1;
        this.isEnableBeidouMode = false;
        this.firstLocType = FirstLocType.SPEED_IN_FIRST_LOC;
        this.mProxyHost = null;
        this.mProxyPort = -1;
        this.mUsername = null;
        this.mPassword = null;
        this.coorType = locationClientOption.coorType;
        this.addrType = locationClientOption.addrType;
        this.openGps = locationClientOption.openGps;
        this.scanSpan = locationClientOption.scanSpan;
        this.timeOut = locationClientOption.timeOut;
        this.prodName = locationClientOption.prodName;
        this.priority = locationClientOption.priority;
        this.location_change_notify = locationClientOption.location_change_notify;
        this.serviceName = locationClientOption.serviceName;
        this.disableLocCache = locationClientOption.disableLocCache;
        this.isIgnoreCacheException = locationClientOption.isIgnoreCacheException;
        this.isIgnoreKillProcess = locationClientOption.isIgnoreKillProcess;
        this.enableSimulateGps = locationClientOption.enableSimulateGps;
        this.f5605a = locationClientOption.f5605a;
        this.isNeedAptag = locationClientOption.isNeedAptag;
        this.isNeedAptagd = locationClientOption.isNeedAptagd;
        this.isNeedPoiRegion = locationClientOption.isNeedPoiRegion;
        this.isNeedRegular = locationClientOption.isNeedRegular;
        this.mIsNeedDeviceDirect = locationClientOption.mIsNeedDeviceDirect;
        this.isNeedAltitude = locationClientOption.isNeedAltitude;
        this.autoNotifyMaxInterval = locationClientOption.autoNotifyMaxInterval;
        this.autoNotifyLocSensitivity = locationClientOption.autoNotifyLocSensitivity;
        this.autoNotifyMinTimeInterval = locationClientOption.autoNotifyMinTimeInterval;
        this.autoNotifyMinDistance = locationClientOption.autoNotifyMinDistance;
        this.wifiCacheTimeOut = locationClientOption.wifiCacheTimeOut;
        this.isNeedNewVersionRgc = locationClientOption.isNeedNewVersionRgc;
        this.isOnceLocation = locationClientOption.isOnceLocation;
        this.locLegalStatus = locationClientOption.locLegalStatus;
        this.isEnableBeidouMode = locationClientOption.isEnableBeidouMode;
        this.firstLocType = locationClientOption.firstLocType;
        this.mProxyHost = locationClientOption.mProxyHost;
        this.mProxyPort = locationClientOption.mProxyPort;
        this.mUsername = locationClientOption.mUsername;
        this.mPassword = locationClientOption.mPassword;
    }

    public void setOpenAutoNotifyMode(int i, int i2, int i3) {
        float f;
        int i4 = Timeout.SIFLI_DFU_ERASE_TIMEOUT;
        if (i > 180000) {
            i4 = i + 1000;
        }
        if (i4 < 10000) {
            throw new IllegalArgumentException("Illegal this maxLocInterval : " + i4 + " , maxLocInterval must >= 10000");
        }
        if (i3 == 1) {
            f = 0.5f;
        } else if (i3 == 2) {
            f = 0.3f;
        } else {
            if (i3 != 3) {
                throw new IllegalArgumentException("Illegal this locSensitivity : " + i3);
            }
            f = 0.1f;
        }
        this.autoNotifyLocSensitivity = f;
        this.autoNotifyMaxInterval = i4;
        this.autoNotifyMinTimeInterval = i;
        this.autoNotifyMinDistance = i2;
    }
}
