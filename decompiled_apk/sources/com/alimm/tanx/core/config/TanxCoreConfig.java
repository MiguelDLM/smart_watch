package com.alimm.tanx.core.config;

import android.util.Log;
import com.alimm.tanx.core.ad.listener.ut.ITanxUserTracker;
import com.alimm.tanx.core.net.INetWork;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.utils.DeviceIdGetUtil;
import com.alimm.tanx.core.utils.LogStatus;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import x0oxIIIX.oIX0oI;

/* loaded from: classes.dex */
public class TanxCoreConfig implements Serializable {
    private static final String TAG = "AdSdkConfig";
    private String clientId;
    private String guid;
    private Boolean idAllSwitch;
    private boolean imeiSwitch;
    private String mAppId;
    private String mAppKey;
    private String mAppName;
    private String mAppSecret;
    private String mChannel;
    private String mImei;
    private INetWork mNetWork;
    private String mOaid;
    private ITanxUserTracker mTanxUserTracker;
    private oIX0oI mUserTracker;
    private boolean oaidSwitch;
    private String pseudoId;
    private Map<String, List<String>> userTag;
    private String widevineId;
    private boolean mDebugMode = false;
    private boolean netDebug = false;
    private LogStatus logStatus = null;

    public static String getTAG() {
        return TAG;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getGuid() {
        return this.guid;
    }

    public String getImei() {
        return this.mImei;
    }

    public LogStatus getLogStatus() {
        return this.logStatus;
    }

    public String getOaid() {
        return this.mOaid;
    }

    public String getPseudoId() {
        return this.pseudoId;
    }

    public Map<String, List<String>> getUserTag() {
        return this.userTag;
    }

    public String getWidevineId() {
        return this.widevineId;
    }

    public boolean isDebugMode() {
        return this.mDebugMode;
    }

    public Boolean isIdAllSwitch() {
        return this.idAllSwitch;
    }

    public boolean isImeiSwitch() {
        return this.imeiSwitch;
    }

    public boolean isNetDebug() {
        return this.netDebug;
    }

    public boolean isOaidSwitch() {
        return this.oaidSwitch;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public void setAppSecret(String str) {
        this.mAppSecret = str;
    }

    public void setChannel(String str) {
        this.mChannel = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setDebugMode(boolean z) {
        this.mDebugMode = z;
        Log.i(TAG, "setDebugMode: debugMode = " + z);
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setHttpImpl(INetWork iNetWork) {
        if (iNetWork != null) {
            NetWorkManager.getInstance().setINetWork(iNetWork);
        }
    }

    public void setIdAllSwitch(Boolean bool) {
        if (bool != null) {
            this.imeiSwitch = bool.booleanValue();
            this.oaidSwitch = bool.booleanValue();
            this.idAllSwitch = bool;
        }
    }

    public void setImei(String str) {
        this.mImei = str;
        DeviceIdGetUtil.getInstance().setImei(this.mImei);
    }

    public void setImeiSwitch(boolean z) {
        this.imeiSwitch = z;
    }

    public void setLogStatus(LogStatus logStatus) {
        this.logStatus = logStatus;
    }

    public void setNetDebug(boolean z) {
        this.netDebug = z;
    }

    public void setOaidSwitch(boolean z) {
        this.oaidSwitch = z;
    }

    public void setPseudoId(String str) {
        this.pseudoId = str;
    }

    public void setUserTag(Map<String, List<String>> map) {
        this.userTag = map;
    }

    public void setWidevineId(String str) {
        this.widevineId = str;
    }

    public void setmOaid(String str) {
        this.mOaid = str;
        DeviceIdGetUtil.getInstance().setImei(this.mOaid);
    }
}
