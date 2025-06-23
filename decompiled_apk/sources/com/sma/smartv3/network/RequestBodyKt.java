package com.sma.smartv3.network;

import O0xxXxI.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import com.kuaishou.weapon.p0.bq;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.model.BGEMUser;
import com.sma.smartv3.model.FirmwareVersion;
import com.sma.smartv3.model.JobV2Extra;
import com.sma.smartv3.util.UtilsKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.szabh.smable3.BleKey;
import com.szabh.smable3.component.BleCache;
import com.szabh.smable3.entity.BleLanguagePackVersion;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nRequestBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestBody.kt\ncom/sma/smartv3/network/RequestBodyKt\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,912:1\n15#2:913\n*S KotlinDebug\n*F\n+ 1 RequestBody.kt\ncom/sma/smartv3/network/RequestBodyKt\n*L\n175#1:913\n*E\n"})
/* loaded from: classes12.dex */
public final class RequestBodyKt {

    @OOXIXo
    public static final String PROJECT_ID = "2";

    @OOXIXo
    public static final HashMap<String, String> aigcCreateJobBody(@OOXIXo String query, @OOXIXo String style, int i) {
        IIX0o.x0xO0oo(query, "query");
        IIX0o.x0xO0oo(style, "style");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("query", query);
        hashMap.put("bleName", BleCache.INSTANCE.getMBleName());
        hashMap.put("style", style);
        hashMap.put("imageCount", String.valueOf(i));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, Object> aigcCreateJobBodyV2(@OOXIXo String query, @OOXIXo String model, @OOXIXo JobV2Extra extra) {
        IIX0o.x0xO0oo(query, "query");
        IIX0o.x0xO0oo(model, "model");
        IIX0o.x0xO0oo(extra, "extra");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("text", query);
        hashMap.put("extra", extra);
        hashMap.put("model", model);
        hashMap.put(AICreateJobV2.AI_Stream, Boolean.TRUE);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> aigcFindJobBody(@OOXIXo String jobId) {
        IIX0o.x0xO0oo(jobId, "jobId");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("jobId", jobId);
        hashMap.put("bleName", BleCache.INSTANCE.getMBleName());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> deleteAccountOrderBody(@OOXIXo String identity, @OOXIXo String orderNum) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(orderNum, "orderNum");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("orderNum", orderNum);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getAccountDetails(@OOXIXo String identity, int i) {
        IIX0o.x0xO0oo(identity, "identity");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("pageNum", String.valueOf(i));
        hashMap.put("pageSize", "100");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getAccountOrderSelectList(@OOXIXo String identity, @OOXIXo String orderType, int i) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(orderType, "orderType");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("orderType", orderType);
        hashMap.put("pageNum", String.valueOf(i));
        hashMap.put("pageSize", "100");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getAddUserWatchDownloadRecordBody(@OOXIXo String identity, @OOXIXo String wid) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(wid, "wid");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("wid", wid);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getAppConfigInfoBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getAppDeductionConfigBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getAppStoreFileListBody(@OOXIXo String appModuleId) {
        IIX0o.x0xO0oo(appModuleId, "appModuleId");
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put(AppStoreFileListSearch.APP_MODULE_ID, appModuleId);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getBGEMUserBody(@OOXIXo BGEMUser user) {
        IIX0o.x0xO0oo(user, "user");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("age", String.valueOf(user.getAge()));
        hashMap.put("gender", user.getGender().toString());
        hashMap.put("weight", String.valueOf(user.getWeight()));
        hashMap.put("height", String.valueOf(user.getHeight()));
        hashMap.put("family_history", String.valueOf(user.getFamily_history()));
        hashMap.put("high_cholesterol", String.valueOf(user.getHigh_cholesterol()));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getBleFirmwareAllListBody(@OOXIXo String filter) {
        IIX0o.x0xO0oo(filter, "filter");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("filter", filter);
        hashMap.put("page", "1");
        hashMap.put("limit", "200");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getBleFirmwareVersionListBody(@OOXIXo String firmwareId) {
        IIX0o.x0xO0oo(firmwareId, "firmwareId");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("firmwareId", firmwareId);
        hashMap.put("page", "1");
        hashMap.put("limit", "200");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getChangeDeviceStateBody(int i) {
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("macAddress", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        hashMap.put("state", String.valueOf(i));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getCheckAppFirmwareBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("projectId", "2");
        hashMap.put("platform", "Android");
        hashMap.put("version", AppUtils.getAppVersionName());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getCheckAppVersionBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appName", AppUtils.getAppName());
        hashMap.put("platform", "Android");
        hashMap.put("version", AppUtils.getAppVersionName());
        hashMap.put("projectId", "2");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getCheckExtraPackVersionBody() {
        String str;
        FirmwareVersion firmwareVersion = (FirmwareVersion) new Gson().fromJson(Xo0.f24349oIX0oI.II0xO0().getString(FirmwareVersion.class.getName()), FirmwareVersion.class);
        String str2 = null;
        if (firmwareVersion != null) {
            str = firmwareVersion.getVersion2();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            if (firmwareVersion != null) {
                str2 = firmwareVersion.getVersion();
            }
        } else if (firmwareVersion != null) {
            str2 = firmwareVersion.getVersion2();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        if (str2 == null) {
            str2 = BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null);
        }
        hashMap.put("firmwareVersion", str2);
        hashMap.put("uiPackVersion", BleCache.getString$default(bleCache, BleKey.UI_PACK_VERSION, bq.e, null, 4, null));
        BleLanguagePackVersion bleLanguagePackVersion = (BleLanguagePackVersion) BleCache.getObjectNotNull$default(bleCache, BleKey.LANGUAGE_PACK_VERSION, BleLanguagePackVersion.class, null, null, 12, null);
        hashMap.put("languagePackVersion", bleLanguagePackVersion.getMVersion());
        hashMap.put("languageCode", String.valueOf(bleLanguagePackVersion.getMLanguageCode()));
        hashMap.put("gpsPackVersion", BleCache.getString$default(bleCache, BleKey.GPS_FIRMWARE_VERSION, bq.e, null, 4, null));
        hashMap.put("networkPackVersion", BleCache.getString$default(bleCache, BleKey.NETWORK_FIRMWARE_VERSION, bq.e, null, 4, null));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getCheckFirmwareVersionBody(@oOoXoXO String str, @OOXIXo String valid, @OOXIXo String bleName, @OOXIXo String flag) {
        IIX0o.x0xO0oo(valid, "valid");
        IIX0o.x0xO0oo(bleName, "bleName");
        IIX0o.x0xO0oo(flag, "flag");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bleName", bleName);
        hashMap.put("flag", flag);
        if (str == null) {
            str = BleCache.getString$default(BleCache.INSTANCE, BleKey.FIRMWARE_VERSION, null, null, 6, null);
        }
        hashMap.put("version", str);
        hashMap.put("androidVersion", AppUtils.getAppVersionName());
        hashMap.put("appPlatform", "0");
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("macAddress", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        hashMap.put("projectId", "2");
        hashMap.put("uiPackVersion", BleCache.getString$default(bleCache, BleKey.UI_PACK_VERSION, bq.e, null, 4, null));
        hashMap.put("valid", valid);
        return hashMap;
    }

    public static /* synthetic */ HashMap getCheckFirmwareVersionBody$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = Api.Y;
        }
        if ((i & 4) != 0) {
            str3 = BleCache.INSTANCE.getMBleName();
        }
        if ((i & 8) != 0) {
            str4 = BleCache.INSTANCE.getMFirmwareFlag();
        }
        return getCheckFirmwareVersionBody(str, str2, str3, str4);
    }

    @OOXIXo
    public static final HashMap<String, String> getCheckOrderBody(@OOXIXo String packageName, @OOXIXo String applicationName, @OOXIXo String productId, @OOXIXo String purchaseToken, @OOXIXo String orderNum) {
        IIX0o.x0xO0oo(packageName, "packageName");
        IIX0o.x0xO0oo(applicationName, "applicationName");
        IIX0o.x0xO0oo(productId, "productId");
        IIX0o.x0xO0oo(purchaseToken, "purchaseToken");
        IIX0o.x0xO0oo(orderNum, "orderNum");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("packageName", packageName);
        hashMap.put(GetGooglePayCheckOrder.APPLICATION_NAME, applicationName);
        hashMap.put(GetGooglePayCheckOrder.PRODUCT_IT, productId);
        hashMap.put("purchaseToken", purchaseToken);
        hashMap.put("orderNum", orderNum);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getChoicenessSearchListBody(@OOXIXo String type) {
        IIX0o.x0xO0oo(type, "type");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("recommendType", type);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getCourSelectByTypeBody(@OOXIXo String type) {
        IIX0o.x0xO0oo(type, "type");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("type", type);
        return hashMap;
    }

    public static /* synthetic */ HashMap getCourSelectByTypeBody$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = GetCourSelectByType.COURSE_DIFF;
        }
        return getCourSelectByTypeBody(str);
    }

    @OOXIXo
    public static final HashMap<String, String> getCourseBody(@oOoXoXO String str, @oOoXoXO String str2, @oOoXoXO String str3, @oOoXoXO String str4) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str != null && str.length() != 0) {
            hashMap.put(GetCourseList.COURSE_TYPE, str);
        }
        if (str2 != null && str2.length() != 0) {
            hashMap.put(GetCourseList.COURSE_DIFF, str2);
        }
        if (str3 != null && str3.length() != 0) {
            hashMap.put(GetCourseList.COURSE_PART, str3);
        }
        return hashMap;
    }

    public static /* synthetic */ HashMap getCourseBody$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        return getCourseBody(str, str2, str3, str4);
    }

    @OOXIXo
    public static final HashMap<String, String> getCourseCollectBody(@OOXIXo String cid, @OOXIXo String uid, @OOXIXo String collectFlag) {
        IIX0o.x0xO0oo(cid, "cid");
        IIX0o.x0xO0oo(uid, "uid");
        IIX0o.x0xO0oo(collectFlag, "collectFlag");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("cid", cid);
        hashMap.put("uid", uid);
        hashMap.put(CourseCollect.COLLECT_FLAG, collectFlag);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getCourseCollectList(@OOXIXo String uid) {
        IIX0o.x0xO0oo(uid, "uid");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("uid", uid);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getCourseDetailsBody(@OOXIXo String id, @OOXIXo String uid) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(uid, "uid");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put("uid", uid);
        return hashMap;
    }

    public static /* synthetic */ HashMap getCourseDetailsBody$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getCourseDetailsBody(str, str2);
    }

    @OOXIXo
    public static final HashMap<String, String> getCourseTypeListBody(@OOXIXo String type) {
        IIX0o.x0xO0oo(type, "type");
        return new HashMap<>();
    }

    public static /* synthetic */ HashMap getCourseTypeListBody$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "course_type";
        }
        return getCourseTypeListBody(str);
    }

    @OOXIXo
    public static final HashMap<String, String> getCreateOrder(@OOXIXo String identity, @OOXIXo String orderType, @OOXIXo String eleId, @OOXIXo String internalFlag) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(orderType, "orderType");
        IIX0o.x0xO0oo(eleId, "eleId");
        IIX0o.x0xO0oo(internalFlag, "internalFlag");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("orderType", orderType);
        hashMap.put("eleId", eleId);
        hashMap.put("projectId", "2");
        hashMap.put("internalFlag", internalFlag);
        return hashMap;
    }

    public static /* synthetic */ HashMap getCreateOrder$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            if (ProjectManager.f19822oIX0oI.Oxx0xo()) {
                str4 = "1";
            } else {
                str4 = "0";
            }
        }
        return getCreateOrder(str, str2, str3, str4);
    }

    @OOXIXo
    public static final HashMap<String, String> getDcsTokenBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appVersion", AppUtils.getAppVersionName());
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put(GetDcsToken.FIRMWARE_VERSION, BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        hashMap.put("projectId", "2");
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("macAddress", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getDeviceInfoBody(@OOXIXo String projectId, @OOXIXo String mBleName, @OOXIXo String mFirmwareFlag) {
        IIX0o.x0xO0oo(projectId, "projectId");
        IIX0o.x0xO0oo(mBleName, "mBleName");
        IIX0o.x0xO0oo(mFirmwareFlag, "mFirmwareFlag");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", projectId);
        hashMap.put("bleName", mBleName);
        hashMap.put("flag", mFirmwareFlag);
        return hashMap;
    }

    public static /* synthetic */ HashMap getDeviceInfoBody$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = String.valueOf(ProjectManager.f19822oIX0oI.x0xO0oo());
        }
        if ((i & 2) != 0) {
            str2 = BleCache.INSTANCE.getMBleName();
        }
        if ((i & 4) != 0) {
            str3 = BleCache.INSTANCE.getMFirmwareFlag();
        }
        return getDeviceInfoBody(str, str2, str3);
    }

    @OOXIXo
    public static final HashMap<String, String> getDeviceListBody(@OOXIXo String projectId) {
        IIX0o.x0xO0oo(projectId, "projectId");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", projectId);
        return hashMap;
    }

    public static /* synthetic */ HashMap getDeviceListBody$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = String.valueOf(ProjectManager.f19822oIX0oI.x0xO0oo());
        }
        return getDeviceListBody(str);
    }

    @OOXIXo
    public static final HashMap<String, String> getDeviceListObjectBody(@OOXIXo String projectId) {
        IIX0o.x0xO0oo(projectId, "projectId");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", projectId);
        return hashMap;
    }

    public static /* synthetic */ HashMap getDeviceListObjectBody$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = String.valueOf(ProjectManager.f19822oIX0oI.x0xO0oo());
        }
        return getDeviceListObjectBody(str);
    }

    @OOXIXo
    public static final HashMap<String, String> getDeviceStateBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("macAddress", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        hashMap.put("version", BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        hashMap.put("androidVersion", AppUtils.getAppVersionName());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getExtraPackVersionFontBody(@OOXIXo String valid) {
        IIX0o.x0xO0oo(valid, "valid");
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("firmwareVersion", BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        hashMap.put("valid", valid);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getExtraPackVersionGPSFirmwareBody(@oOoXoXO String str, @OOXIXo String valid) {
        String str2;
        IIX0o.x0xO0oo(valid, "valid");
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("firmwareVersion", BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        hashMap.put("appVersion", AppUtils.getAppVersionName());
        hashMap.put("appPlatform", "0");
        hashMap.put("mac", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        hashMap.put("pid", "2");
        if (str == null) {
            str2 = BleCache.getString$default(bleCache, BleKey.GPS_FIRMWARE_VERSION, bq.e, null, 4, null);
        } else {
            str2 = str;
        }
        hashMap.put(BleExtraPackVersionGPSFirmware.GPS_PACK_VERSION, str2);
        hashMap.put("valid", valid);
        return hashMap;
    }

    public static /* synthetic */ HashMap getExtraPackVersionGPSFirmwareBody$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = Api.Y;
        }
        return getExtraPackVersionGPSFirmwareBody(str, str2);
    }

    @OOXIXo
    public static final HashMap<String, String> getExtraPackVersionLanguageBody(@OOXIXo String valid) {
        IIX0o.x0xO0oo(valid, "valid");
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("firmwareVersion", BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        hashMap.put("valid", valid);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getExtraPackVersionUIBody(@OOXIXo String valid) {
        IIX0o.x0xO0oo(valid, "valid");
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("firmwareVersion", BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        hashMap.put("valid", valid);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getFeedbackBody(@OOXIXo Context context, @OOXIXo String contactWay, @OOXIXo String content) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(contactWay, "contactWay");
        IIX0o.x0xO0oo(content, "content");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("contactWay", contactWay);
        hashMap.put("content", content);
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(R.string.app_name));
        sb.append(',');
        sb.append(AppUtils.getAppVersionName());
        sb.append(',');
        BleCache bleCache = BleCache.INSTANCE;
        sb.append(bleCache.getMBleName());
        sb.append(',');
        sb.append(bleCache.getMFirmwareFlag());
        sb.append(',');
        sb.append(BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        sb.append(',');
        sb.append(Locale.getDefault().getCountry());
        sb.append(',');
        sb.append(Build.MANUFACTURER);
        sb.append(',');
        sb.append(Build.MODEL);
        sb.append(',');
        sb.append(Build.VERSION.RELEASE);
        sb.append(',');
        sb.append(Build.VERSION.SDK_INT);
        hashMap.put("extraInfo", sb.toString());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getFreePointsBody(@OOXIXo String identity) {
        IIX0o.x0xO0oo(identity, "identity");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getGomoreAuthKeyBody(@OOXIXo String uuid, int i) {
        IIX0o.x0xO0oo(uuid, "uuid");
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("mac", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        hashMap.put(GetGomoreAuthKey.DEVICE_ID, uuid);
        hashMap.put(GetGomoreAuthKey.TYPE, String.valueOf(i));
        hashMap.put("platform", String.valueOf(UtilsKt.Oo()));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getInternalTeraBoxRefreshTokenBody(@OOXIXo String token) {
        IIX0o.x0xO0oo(token, "token");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("token", token);
        hashMap.put("projectId", "2");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getInternalTeraBoxTokenBody(@OOXIXo String code, @OOXIXo String redirect_uri) {
        IIX0o.x0xO0oo(code, "code");
        IIX0o.x0xO0oo(redirect_uri, "redirect_uri");
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("mac", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        hashMap.put("projectId", "2");
        hashMap.put("code", code);
        hashMap.put("redirect_uri", redirect_uri);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getLoginByCodeBody(@OOXIXo String email, @OOXIXo String verificationCode) {
        IIX0o.x0xO0oo(email, "email");
        IIX0o.x0xO0oo(verificationCode, "verificationCode");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("userName", email);
        hashMap.put("verificationCode", verificationCode);
        hashMap.put("country", Utils.getApp().getResources().getConfiguration().locale.getCountry());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getLoginByPasswordBody(@OOXIXo String email, @OOXIXo String password) {
        IIX0o.x0xO0oo(email, "email");
        IIX0o.x0xO0oo(password, "password");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("userName", email);
        hashMap.put("password", password);
        hashMap.put("country", Utils.getApp().getResources().getConfiguration().locale.getCountry());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getMicrosoftBody(@OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key", key);
        return hashMap;
    }

    public static /* synthetic */ HashMap getMicrosoftBody$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "sma-speech-key";
        }
        return getMicrosoftBody(str);
    }

    @OOXIXo
    public static final HashMap<String, String> getNewDeviceListObjectBody(@OOXIXo String projectId) {
        IIX0o.x0xO0oo(projectId, "projectId");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", projectId);
        return hashMap;
    }

    public static /* synthetic */ HashMap getNewDeviceListObjectBody$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = String.valueOf(ProjectManager.f19822oIX0oI.Oo());
        }
        return getNewDeviceListObjectBody(str);
    }

    @OOXIXo
    public static final HashMap<String, Object> getOnLinWatchFace(@OOXIXo String id, boolean z) {
        IIX0o.x0xO0oo(id, "id");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("identity", id);
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put(GetOnLinWatchFaceList.TYP_GROUP_FLAG, Boolean.valueOf(z));
        return hashMap;
    }

    public static /* synthetic */ HashMap getOnLinWatchFace$default(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ProjectManager.f19822oIX0oI.ooXIXxIX();
        }
        return getOnLinWatchFace(str, z);
    }

    @OOXIXo
    public static final HashMap<String, String> getOrderStatusBody(@OOXIXo String identity, @OOXIXo String orderNum, @OOXIXo String orderType) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(orderNum, "orderNum");
        IIX0o.x0xO0oo(orderType, "orderType");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("orderNum", orderNum);
        hashMap.put("orderType", orderType);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getPayMacAddressBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("version", BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        hashMap.put("oldMacAddress", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        hashMap.put("androidVersion", AppUtils.getAppVersionName());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getPointsPackBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getPurchaseHistoryWatchFace(@OOXIXo String id) {
        IIX0o.x0xO0oo(id, "id");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", id);
        return hashMap;
    }

    public static /* synthetic */ HashMap getPurchaseHistoryWatchFace$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ProjectManager.f19822oIX0oI.ooXIXxIX();
        }
        return getPurchaseHistoryWatchFace(str);
    }

    @OOXIXo
    public static final HashMap<String, String> getRegisterVerificationCodeBody(@OOXIXo String userName, @OOXIXo String password, @OOXIXo String verificationCode, @OOXIXo String verifyPassword, @OOXIXo String nickname) {
        IIX0o.x0xO0oo(userName, "userName");
        IIX0o.x0xO0oo(password, "password");
        IIX0o.x0xO0oo(verificationCode, "verificationCode");
        IIX0o.x0xO0oo(verifyPassword, "verifyPassword");
        IIX0o.x0xO0oo(nickname, "nickname");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("userName", userName);
        hashMap.put("password", password);
        hashMap.put("verificationCode", verificationCode);
        hashMap.put("verifyPassword", verifyPassword);
        if (nickname.length() > 0) {
            hashMap.put("nickName", nickname);
        }
        return hashMap;
    }

    public static /* synthetic */ HashMap getRegisterVerificationCodeBody$default(String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = "";
        }
        return getRegisterVerificationCodeBody(str, str2, str3, str4, str5);
    }

    @OOXIXo
    public static final HashMap<String, String> getResetPasswordBody(@OOXIXo String email, @OOXIXo String newPassword, @OOXIXo String verificationCode) {
        IIX0o.x0xO0oo(email, "email");
        IIX0o.x0xO0oo(newPassword, "newPassword");
        IIX0o.x0xO0oo(verificationCode, "verificationCode");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("userName", email);
        hashMap.put("password", newPassword);
        hashMap.put("verificationCode", verificationCode);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getSetEmailBody(@OOXIXo String identity, @OOXIXo String email, @OOXIXo String verificationCode) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(email, "email");
        IIX0o.x0xO0oo(verificationCode, "verificationCode");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("email", email);
        hashMap.put("verificationCode", verificationCode);
        hashMap.put("country", Utils.getApp().getResources().getConfiguration().locale.getCountry());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getSetReceivePhoneBody(@OOXIXo String identity, @OOXIXo String receivePhone) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(receivePhone, "receivePhone");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put(SetReceivePhone.RECEIVE_PHONE, receivePhone);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getSparkAuthorizeBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("mac", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getStockAddBody(@OOXIXo String identity, int i) {
        IIX0o.x0xO0oo(identity, "identity");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("projectId", "2");
        hashMap.put("stockId", String.valueOf(i));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getStockListBody(@OOXIXo String identity) {
        IIX0o.x0xO0oo(identity, "identity");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("projectId", "2");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getStockRemoveBody(@OOXIXo String identity, int i) {
        IIX0o.x0xO0oo(identity, "identity");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("stockId", String.valueOf(i));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getStockSearchBody(@OOXIXo String identity, @OOXIXo String queryKey) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(queryKey, "queryKey");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("projectId", "2");
        hashMap.put("queryKey", queryKey);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getTempSignedPutUrlBody(@OOXIXo String identity, @OOXIXo String uploadOSSFilePath) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(uploadOSSFilePath, "uploadOSSFilePath");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put(GetTempSignedPutUrl.UPLOAD_OSSFILEPATH, uploadOSSFilePath);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getTeraBoxRefreshTokenBody(@OOXIXo String token) {
        IIX0o.x0xO0oo(token, "token");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("token", token);
        hashMap.put("projectId", "2");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getTeraBoxTokenBody(@OOXIXo String code) {
        IIX0o.x0xO0oo(code, "code");
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        hashMap.put("mac", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        hashMap.put("projectId", "2");
        hashMap.put("code", code);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getTeraBoxTokenInfoBody(@OOXIXo String token) {
        IIX0o.x0xO0oo(token, "token");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("token", token);
        hashMap.put("projectId", "2");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getThirdPartyBody(@OOXIXo String platform, @OOXIXo String openId, @OOXIXo String accessToken, @OOXIXo String extInfo) {
        IIX0o.x0xO0oo(platform, "platform");
        IIX0o.x0xO0oo(openId, "openId");
        IIX0o.x0xO0oo(accessToken, "accessToken");
        IIX0o.x0xO0oo(extInfo, "extInfo");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("platform", platform);
        hashMap.put("openId", openId);
        hashMap.put("accessToken", accessToken);
        if (ProjectManager.f19822oIX0oI.xxx00() && IIX0o.Oxx0IOOO(StringsKt__StringsKt.oIoIXxIO(platform).toString(), StringsKt__StringsKt.oIoIXxIO(oIX0oI.f1499II0xO0).toString())) {
            hashMap.put("extInfo", extInfo);
            String string = Xo0.f24349oIX0oI.oIX0oI().getString(XoI0Ixx0.f24438o0oxo0oI, "");
            hashMap.put("phoneIdentity", UtilsKt.O0xOxO());
            hashMap.put("oldOpenId", string);
        }
        hashMap.put("country", Utils.getApp().getResources().getConfiguration().locale.getCountry());
        return hashMap;
    }

    public static /* synthetic */ HashMap getThirdPartyBody$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = "";
        }
        return getThirdPartyBody(str, str2, str3, str4);
    }

    @OOXIXo
    public static final HashMap<String, String> getTranslatorTextBody(@OOXIXo String text, @OOXIXo String translationLanguage) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(translationLanguage, "translationLanguage");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ToTranslatorText.FLAG_TEXT_FORM, text);
        hashMap.put(ToTranslatorText.FLAG_TRANSLATION_LANGUAGE, translationLanguage);
        hashMap.put("source", "microsoft");
        hashMap.put(ToTranslatorText.FLAG_ORIGINAL_LANGUAGE, "auto");
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getUpdateDeviceInfoBody(@OOXIXo AppUser appUser) {
        IIX0o.x0xO0oo(appUser, "appUser");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", appUser.getIdentity());
        hashMap.put("projectId", String.valueOf(appUser.getProjectId()));
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("name", bleCache.getMBleName());
        hashMap.put("address", OxI.IIOIX(bleCache.getMBleAddress(), ":", "", false, 4, null));
        hashMap.put("platform", bleCache.getMPlatform());
        hashMap.put("prototype", bleCache.getMPrototype());
        hashMap.put("firmwareFlag", bleCache.getMFirmwareFlag());
        hashMap.put("agpsType", String.valueOf(bleCache.getMAGpsType()));
        hashMap.put("version", BleCache.getString$default(bleCache, BleKey.FIRMWARE_VERSION, null, null, 6, null));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getUploadNoLoginUserInfo(@OOXIXo AppUser mAppUser) {
        IIX0o.x0xO0oo(mAppUser, "mAppUser");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("nickname", mAppUser.getNickname());
        hashMap.put("birthday", mAppUser.getBirthday());
        hashMap.put("gender", String.valueOf(mAppUser.getGender()));
        hashMap.put("unit", String.valueOf(mAppUser.getUnit()));
        hashMap.put("height", String.valueOf(mAppUser.getHeight()));
        hashMap.put("weight", String.valueOf(mAppUser.getWeight()));
        hashMap.put("extraInfo", mAppUser.getExtraInfo());
        hashMap.put("country", mAppUser.getCountry());
        hashMap.put("city", mAppUser.getCity());
        hashMap.put("longitude", String.valueOf(mAppUser.getLongitude()));
        hashMap.put("latitude", String.valueOf(mAppUser.getLatitude()));
        hashMap.put("server", String.valueOf(mAppUser.getServer()));
        hashMap.put("phoneOs", String.valueOf(mAppUser.getPhoneOs()));
        hashMap.put("osVersion", mAppUser.getOsVersion());
        hashMap.put("phoneModel", mAppUser.getPhoneModel());
        hashMap.put("phoneIdentity", mAppUser.getPhoneIdentity());
        hashMap.put("settings", mAppUser.getSettings());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getUserGameDetailBody(@OOXIXo String gid) {
        IIX0o.x0xO0oo(gid, "gid");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(GetGameDetail.GAME_ID, gid);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getUserIdentityBody(@OOXIXo AppUser mAppUser) {
        IIX0o.x0xO0oo(mAppUser, "mAppUser");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", mAppUser.getIdentity());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getUserInfoBody(@OOXIXo AppUser mAppUser) {
        IIX0o.x0xO0oo(mAppUser, "mAppUser");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", mAppUser.getIdentity());
        hashMap.put("nickname", mAppUser.getNickname());
        hashMap.put("birthday", mAppUser.getBirthday());
        hashMap.put("gender", String.valueOf(mAppUser.getGender()));
        hashMap.put("height", String.valueOf(mAppUser.getHeight()));
        hashMap.put("weight", String.valueOf(mAppUser.getWeight()));
        hashMap.put("extraInfo", mAppUser.getExtraInfo());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getUserPointsMemberBody(@OOXIXo String identity) {
        IIX0o.x0xO0oo(identity, "identity");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getVerificationCodeBody(@OOXIXo String email, int i) {
        IIX0o.x0xO0oo(email, "email");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("userName", email);
        hashMap.put("language", Utils.getApp().getResources().getConfiguration().locale.getLanguage());
        hashMap.put("verificationType", String.valueOf(i));
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getVerificationCodeCheckBody(@OOXIXo String email, @OOXIXo String verificationCode) {
        IIX0o.x0xO0oo(email, "email");
        IIX0o.x0xO0oo(verificationCode, "verificationCode");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("userName", email);
        hashMap.put("verificationCode", verificationCode);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getWatchFaceBannerBody() {
        HashMap<String, String> hashMap = new HashMap<>();
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getWatchFaceDetails(@OOXIXo String identity, @OOXIXo String id) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(id, "id");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("id", id);
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getWatchFaceDetailsList(@OOXIXo String identity, @OOXIXo String id) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(id, "id");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("wid", id);
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getWeatherForecastBody(double d, double d2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("lon", String.valueOf(d));
        hashMap.put("lat", String.valueOf(d2));
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> getWeatherRealtimeBody(double d, double d2) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectId", "2");
        hashMap.put("lon", String.valueOf(d));
        hashMap.put("lat", String.valueOf(d2));
        BleCache bleCache = BleCache.INSTANCE;
        hashMap.put("bleName", bleCache.getMBleName());
        hashMap.put("flag", bleCache.getMFirmwareFlag());
        return hashMap;
    }

    @OOXIXo
    public static final HashMap<String, String> userMigrateBody(@OOXIXo String identity, @OOXIXo String goalService) {
        IIX0o.x0xO0oo(identity, "identity");
        IIX0o.x0xO0oo(goalService, "goalService");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("identity", identity);
        hashMap.put("goalServer", goalService);
        return hashMap;
    }
}
