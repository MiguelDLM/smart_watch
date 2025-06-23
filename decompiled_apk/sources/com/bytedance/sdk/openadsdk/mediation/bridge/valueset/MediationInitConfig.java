package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class MediationInitConfig {

    /* renamed from: a, reason: collision with root package name */
    private ValueSet f10865a;
    private ValueSet b;
    private ValueSet c;

    private MediationInitConfig(ValueSet valueSet) {
        this.f10865a = valueSet;
        if (valueSet != null) {
            this.c = (ValueSet) valueSet.objectValue(8457, ValueSet.class);
            this.b = (ValueSet) this.f10865a.objectValue(8475, ValueSet.class);
        }
        a();
    }

    private void c() {
        MediationApiLog.i("---------  sdk 初始化信息 start ----");
        MediationApiLog.i("isDebug：" + isDebug());
        MediationApiLog.i("getClassName：" + getClassName());
        MediationApiLog.i("getAppId：" + getAppId());
        MediationApiLog.i("getAppName：" + getAppName());
        MediationApiLog.i("getADNName：" + getADNName());
        MediationApiLog.i("getAppKey：" + getAppKey());
        MediationApiLog.i("getInitCallback：" + getInitCallback());
        MediationApiLog.i("getAgeGroup：" + getAgeGroup());
        MediationApiLog.i("isCustom：" + isCustom());
        MediationApiLog.i("getCustomInitConfig：" + getCustomInitConfig());
        MediationApiLog.i("getCustomInitMap：" + getCustomInitMap());
        MediationApiLog.i("getCustomGMConfiguration：" + getCustomGMConfiguration());
        MediationApiLog.i("getKsAdapterVersion：" + getKsAdapterVersion());
        MediationApiLog.i("getGromoreVersion：" + getGromoreVersion());
        MediationApiLog.i("getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        MediationApiLog.i("getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        MediationApiLog.i("getGdtAdapterVersion：" + getGdtAdapterVersion());
        MediationApiLog.i("getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        MediationApiLog.i("getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        MediationApiLog.i("getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        MediationApiLog.i("getUnityAdapterVersion：" + getUnityAdapterVersion());
        MediationApiLog.i("getMap：" + getInitAdnMap());
        MediationApiLog.i("---------  sdk 初始化信息 end ----");
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    private void d() {
        MediationApiLog.i("---------  sdk 隐私设置 start ----");
        MediationApiLog.i("isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        MediationApiLog.i("getLocation：" + location);
        if (location != null) {
            MediationApiLog.i("getLocation getLatitude：" + location.getLatitude());
            MediationApiLog.i("getLocation getLongitude：" + location.getLongitude());
        }
        MediationApiLog.i("appList：" + appList());
        MediationApiLog.i("isCanUsePhoneState：" + isCanUsePhoneState());
        MediationApiLog.i("isLimitPersonalAds：" + isLimitPersonalAds());
        MediationApiLog.i("getDevImei：" + getDevImei());
        MediationApiLog.i("isCanUseWifiState：" + isCanUseWifiState());
        MediationApiLog.i("getMacAddress：" + getMacAddress());
        MediationApiLog.i("isCanUseWriteExternal：" + isCanUseWriteExternal());
        MediationApiLog.i("isCanUseAndroidId：" + isCanUseAndroidId());
        MediationApiLog.i("getAndroidId：" + getAndroidId());
        List<String> appList = getAppList();
        MediationApiLog.i("getAppList：" + appList);
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                MediationApiLog.i("getAppList item: " + it.next());
            }
        }
        List<String> devImeis = getDevImeis();
        MediationApiLog.i("getDevImeis：" + devImeis);
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                MediationApiLog.i("getDevImeis item: " + it2.next());
            }
        }
        MediationApiLog.i("getDevOaid：" + getDevOaid());
        MediationApiLog.i("isCanUseOaid：" + isCanUseOaid());
        MediationApiLog.i("isCanUseMacAddress：" + isCanUseMacAddress());
        MediationApiLog.i("isProgrammaticRecommend：" + isProgrammaticRecommend());
        MediationApiLog.i("isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        MediationApiLog.i("---------  sdk 隐私设置 end ----");
    }

    private boolean e() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null && !valueSet.isEmpty()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double f() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.b;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) != null && (values = bridge.values()) != null) {
            return values.doubleValue(8481);
        }
        return -1.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double g() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.b;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8312, Bridge.class)) != null && (values = bridge.values()) != null) {
            return values.doubleValue(8482);
        }
        return -1.0d;
    }

    public boolean appList() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public String getADNName() {
        if (e()) {
            return this.f10865a.stringValue(8003);
        }
        return "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.stringValue(8412);
        }
        return "";
    }

    public int getAgeGroup() {
        if (e()) {
            return this.f10865a.intValue(7);
        }
        return 0;
    }

    public String getAndroidId() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.stringValue(8485);
        }
        return "";
    }

    public String getAppId() {
        if (e()) {
            return this.f10865a.stringValue(3);
        }
        return null;
    }

    public String getAppKey() {
        if (e()) {
            return this.f10865a.stringValue(8005);
        }
        return "";
    }

    public List<String> getAppList() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.b;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8476, List.class);
        }
        return new LinkedList();
    }

    public String getAppName() {
        if (e()) {
            return this.f10865a.stringValue(8);
        }
        return "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.stringValue(8413);
        }
        return "";
    }

    public String getClassName() {
        if (e()) {
            return this.f10865a.stringValue(8010);
        }
        return "";
    }

    public Bridge getCustomGMConfiguration() {
        if (e()) {
            return (Bridge) this.f10865a.objectValue(8401, Bridge.class);
        }
        return null;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (e()) {
            return (MediationCustomInitConfig) this.f10865a.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (e()) {
            return (ValueSet) this.f10865a.objectValue(8545, ValueSet.class);
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (e()) {
            return (Map) this.f10865a.objectValue(8400, Map.class);
        }
        return null;
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.stringValue(8484);
        }
        return "";
    }

    public List<String> getDevImeis() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.b;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return (List) values.objectValue(8477, List.class);
        }
        return new LinkedList();
    }

    public String getDevOaid() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.stringValue(8486);
        }
        return "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.stringValue(8414);
        }
        return "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.stringValue(8411);
        }
        return "";
    }

    public boolean getHttps() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public Bridge getInitCallback() {
        if (e()) {
            return (Bridge) this.f10865a.objectValue(8300, Bridge.class);
        }
        return null;
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.stringValue(8415);
        }
        return "";
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.stringValue(8410);
        }
        return "";
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public IMediationLocation getLocation() {
        if (f() != -1.0d && f() != -1.0d) {
            return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
                @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                public double getLatitude() {
                    return MediationInitConfig.this.f();
                }

                @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                public double getLongitude() {
                    return MediationInitConfig.this.g();
                }
            };
        }
        return null;
    }

    public String getMacAddress() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.stringValue(8487);
        }
        return "";
    }

    public Bridge getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return (Bridge) valueSet.objectValue(8310, Bridge.class);
        }
        return null;
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.stringValue(8416);
        }
        return "";
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return valueSet.stringValue(8464);
        }
        return "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return valueSet.stringValue(8460);
        }
        return "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.stringValue(8417);
        }
        return "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.stringValue(8418);
        }
        return "";
    }

    public ValueSet getValueSet() {
        return this.f10865a;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return valueSet.stringValue(8459);
        }
        return "";
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseOaid() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.b;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return values.booleanValue(8478);
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.b;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean isCustom() {
        if (e()) {
            return this.f10865a.booleanValue(8098);
        }
        return false;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.f10865a;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.b;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return values.booleanValue(8027);
        }
        return false;
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        Bridge bridge;
        ValueSet values;
        ValueSet valueSet = this.b;
        if (valueSet != null && (bridge = (Bridge) valueSet.objectValue(8311, Bridge.class)) != null && (values = bridge.values()) != null) {
            return values.booleanValue(8028);
        }
        return true;
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.c;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.b = valueSet;
        d();
    }

    private void a() {
        MediationApiLog.setDebug(Boolean.valueOf(isDebug()));
        c();
        d();
        b();
    }

    private void b() {
        MediationApiLog.i("---------  sdk 聚合信息 start ----");
        MediationApiLog.i("getHttps：" + getHttps());
        MediationApiLog.i("getWxAppId：" + getWxAppId());
        MediationApiLog.i("getPublisherDid：" + getPublisherDid());
        MediationApiLog.i("isOpenAdnTest：" + isOpenAdnTest());
        MediationApiLog.i("getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        MediationApiLog.i("getLocalExtra：" + getLocalExtra());
        MediationApiLog.i("getCustomLocalConfig：" + getCustomLocalConfig());
        MediationApiLog.i("getOpensdkVer：" + getOpensdkVer());
        MediationApiLog.i("isWxInstalled：" + isWxInstalled());
        MediationApiLog.i("isSupportH265：" + isSupportH265());
        MediationApiLog.i("isSupportSplashZoomout：" + isSupportSplashZoomout());
        MediationApiLog.i("---------  sdk 聚合信息 end ----");
    }
}
