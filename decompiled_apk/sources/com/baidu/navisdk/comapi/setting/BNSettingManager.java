package com.baidu.navisdk.comapi.setting;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.navisdk.comapi.commontool.BNPowerSaver;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.framework.b;
import com.baidu.navisdk.j;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.module.cloudconfig.a;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.module.pronavi.model.i;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.x;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class BNSettingManager {
    public static int SIMPLE_GUIDE_MODE = -1;
    private static final String TAG = "BNSettingManager";
    public static int TTS_PLAY_MODE = -1;
    private static boolean isFirstGetNeRemainMileage = true;
    private static e0 mPreferenceHelper;

    public static void SetTTSDataPath(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_VOICE_TTS_DATA_PATH, str);
    }

    public static void add3DCarLogoBubbleTimes() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        mPreferenceHelper.b(SettingParams.Key.SHOW_3D_CARLOGO_BUBBLE_TIMES, e0Var.a(SettingParams.Key.SHOW_3D_CARLOGO_BUBBLE_TIMES, 0) + 1);
    }

    public static boolean addNaviSafeYellowBarDisplayCount(int i) {
        if (mPreferenceHelper == null) {
            return false;
        }
        return mPreferenceHelper.b(SettingParams.Key.NAVI_SAFE_YELLOW_BAR_DISPLAY_COUNT, getNaviSafeYellowBarDisplayCount() + i);
    }

    public static void addOrientationChangedDialogShow() {
        if (mPreferenceHelper == null) {
            return;
        }
        mPreferenceHelper.b(SettingParams.Key.NAVI_ORIENTATIOJN_CHANGED_DIALOG_SHOW_COUNT, getOrientationChangedDialogShowCount() + 1);
    }

    public static boolean canAutoEnterMossNavi() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.COMMUTE_GUIDE_SETTING_AUTO_ENTER_NAVI, true);
    }

    public static boolean canShowCommuteEntrance() {
        return getBoolean(SettingParams.Key.COMMUTE_FUN, true);
    }

    public static boolean containsIsShowRGZoomInBtnKey() {
        if (mPreferenceHelper == null) {
            return false;
        }
        return containsKey(SettingParams.Key.RG_ZOOM_IN_BTN_SHOW);
    }

    public static boolean containsKey(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(str);
    }

    public static boolean deviceSupportPipMode() {
        if (!j.d()) {
            g gVar = g.MAP;
            if (gVar.d()) {
                gVar.e(TAG, "sdk no");
            }
            return false;
        }
        if (!a.b().a("pip_open", true)) {
            g gVar2 = g.MAP;
            if (gVar2.d()) {
                gVar2.e("kpkkikkpk", "cloud no");
            }
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return com.baidu.navisdk.framework.a.c().a().getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    public static void enableBottomBarOpen(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_SETTING_BOTTOM_BAR, z);
    }

    public static void enableLeak(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.LEAK_CANARY_FUNCTION_STATUS, z);
    }

    public static void enableStartByFullView(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVING_START_BY_FULLVIEW, z);
    }

    public static boolean enableVDRMockForDebug(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.VDR_MOCK_FOR_DEBUG, z);
    }

    public static void enableVDRg(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.VDR_FUNCTION_STATUS, z);
    }

    public static int get3DCarLogoBubbleTimes() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.SHOW_3D_CARLOGO_BUBBLE_TIMES, 0);
    }

    public static String get3DCarLogoFilePath(String str, String str2) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return str2;
        }
        return e0Var.a(str, str2);
    }

    public static int getArNavOrientation() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 2;
        }
        return e0Var.a(SettingParams.Key.AR_NAV_ORIENTATION, 2);
    }

    public static int getArNavState() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 2;
        }
        return e0Var.a(SettingParams.Key.AR_NAV_STATE, 2);
    }

    public static boolean getAsrCloseWakeUpPowerSave() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.CLOSE_ASR_WAKEUP_POWER_SAVE, false);
    }

    public static int getAsrUploadAddress() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 2;
        }
        return e0Var.a(SettingParams.Key.HAS_UPLOAD_ADDRESS, 0);
    }

    public static boolean getAutoEnterLightNavi() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_AUTO_ENTER_LIGHT_NAVI, true);
    }

    public static String getBlueToothName() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAVI_BLUE_TOOTH_NAME, "");
    }

    public static int getBluetoothChannelMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_BLUETOOTH_CHANNEL_MODE, 0);
    }

    public static boolean getBoolean(String str, boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return z;
        }
        return e0Var.a(str, z);
    }

    public static int getBrandId() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_BRAND_ID, 0);
    }

    public static String getCarIcon() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_ICON, "");
    }

    public static int[] getCarIconOffsetForLightNavi() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return new int[]{0, 0};
        }
        return parseStringToIntArray(e0Var.a(SettingParams.Key.LIGHT_NAV_ROUTE_VIEW_SIZE, "0:0"), 2);
    }

    public static int[] getCarIconOffsetForNavi() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return new int[]{0, 0};
        }
        return parseStringToIntArray(e0Var.a(SettingParams.Key.PROFESSIONAL_NAV_CAR_ICON_OFFSET, "0:0"), 2);
    }

    public static String getCarKey(String str) {
        return str;
    }

    public static String getCarPassportIds() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_PASSPORT_IDS, "");
    }

    public static boolean getCarRouteUseCarOwnerPlate() {
        return mPreferenceHelper.a(SettingParams.Key.ROUTE_USE_CAROWNER_PLATE, true);
    }

    public static int getChargeAreaTipDisplayCount() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_CHARGE_AREA_TIP_DISPLAY_COUNT, 0);
    }

    public static long getChargeAreaTipDisplayTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.NAVI_CHARGE_AREA_TIP_DISPLAY_TIME, 0L);
    }

    public static boolean getColladaStatus() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.COLLADA_SWITCH, true);
    }

    public static boolean getCruiseSafeGuardShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.CRUISE_SAFE_GUARD_SHOW, true);
    }

    public static int getCurrentUsingMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a(SettingParams.Key.SP_USING_MODE, 1);
    }

    public static String getDebugModeCalcRoadVersion() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "0";
        }
        return e0Var.a(SettingParams.Key.DEBUG_MODE_CALC_ROAD_VERSION, "0");
    }

    public static String getDebugModeRouteGuideVersion() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "0";
        }
        return e0Var.a(SettingParams.Key.DEBUG_MODE_ROUTE_GUIDE_VERSION, "0");
    }

    public static int getDefaultDayAndNightModeFromCloud() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_DEFAULT_MODE_DAY_AND_NIGHT_FROM_CLOUD, 0);
    }

    public static int getDefaultLaunchMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_DEFAULT_LAUNCH_MODE, 0);
    }

    public static int getDefaultRouteSort() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a(SettingParams.Key.NAVI_DEFAULT_ROUTE_SORT, 1);
    }

    public static int getDispatchTag() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 10000;
        }
        return e0Var.a(SettingParams.Key.NAV_DISPATCH_TAG, 10000);
    }

    public static int getDistrictId() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 131;
        }
        return e0Var.a(SettingParams.Key.SEARCH_DISTRICT_ID, 131);
    }

    public static String getDistrictName() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "北京";
        }
        return e0Var.a(SettingParams.Key.SEARCH_DISTRICT_NAME, "北京");
    }

    public static long getDiyCustomModeValue() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.NAVI_DIY_CUSTOM_MODE_VALUE, 0L);
    }

    public static int getDiySpeakAutoChangAidCancelCount() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_DIY_VOICE_AUTO_CHANGE_AID_CANCEL, 0);
    }

    public static int getDiySpeakMusicAidCount() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_DIY_VOICE_MUSIC_AID_COUNT, 0);
    }

    public static int getDiySwitchGuideShowTimes() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 2;
        }
        return e0Var.a(SettingParams.Key.DIY_SWITCH_GUIDE_SHOW_TIMES_IN_NAVI, 0);
    }

    @Deprecated
    public static int getDiyVoiceMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_DIY_VOICE_MODE, 0);
    }

    public static boolean getDiyVoiceModeOpen() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_DIY_VOICE_MODE_OPEN, false);
    }

    public static boolean getDynaPreload() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.DYNA_UI_PRELOAD, true);
    }

    public static RoutePlanNode getEndNode() {
        if (mPreferenceHelper == null) {
            return null;
        }
        RoutePlanNode routePlanNode = new RoutePlanNode();
        routePlanNode.mName = mPreferenceHelper.a("mName", "");
        String[] split = mPreferenceHelper.a("location", "").split(",");
        if (split != null && split.length == 2) {
            routePlanNode.setGeoPoint(new GeoPoint(Integer.parseInt(split[1]), Integer.parseInt(split[0])));
        }
        return routePlanNode;
    }

    public static String getEnergyDefaultPlate() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        try {
            return new String(Base64.decode(e0Var.a(SettingParams.Key.NAV_ENERGY_DEFAULT_PLATE_NEW, ""), 0), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getEngBrandId() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_ENG_BRAND_ID, 0);
    }

    public static String getEngCarIcon() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAV_ENG_ICON, "");
    }

    public static int getEngEtcClass() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_ENG_ETC_CLASS, -1);
    }

    public static int getEngEtcColor() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_ENG_ETC_COLOR, -1);
    }

    public static int getEngIsEtc() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_ENG_IS_ETC, -1);
    }

    public static String getEngPassportIds() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAV_ENG_PASSPORT_IDS, "");
    }

    public static int getEtcClass() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_ETC_CLASS, -1);
    }

    public static int getEtcColor() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_ETC_COLOR, -1);
    }

    public static int getFellowCity() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 131;
        }
        return e0Var.a(SettingParams.Key.FELLOW_DEBUG_CITY_NAME, 131);
    }

    public static boolean getFellowSupport() {
        return false;
    }

    public static boolean getFellowSwitchStatus() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.FELLOW_SWITCH, true);
    }

    public static int getFellowTipsTTSPlayCount() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.FELLOW_PREFER_TIPS_TTS_COUNT, 0);
    }

    public static String getFellowTipsTTSStr() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.FELLOW_PREFER_TIPS_TTS_KEY, "");
    }

    public static boolean getFirsCarLogoGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_FIRST_CAR_LOGO_GUIDE, false);
    }

    public static boolean getFirstGuide(String str, boolean z) {
        LogUtil.e(TAG, "getFirstGuide-> key: " + str + ", defaultValue: " + z);
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            LogUtil.e(TAG, "getFirstGuide-> mPreferenceHelper == null, return false!");
            return z;
        }
        String trim = e0Var.a(SettingParams.Key.BN_FIRST_GUIDE, "").trim();
        if (l0.c(trim)) {
            return z;
        }
        try {
            boolean optBoolean = new JSONObject(trim).optBoolean(str, z);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "getFirstGuide-> firstGuideStr= " + trim + ", value= " + optBoolean + ", defaultValue= " + z);
            }
            return optBoolean;
        } catch (JSONException e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("getFirstGuide", e);
            }
            return z;
        }
    }

    public static boolean getFirstGuideModeChecked() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_FIRST_GUIDE_MODE_GUIDE, true);
    }

    public static boolean getFirstHolidayShow(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.HOLIDAY_RED_GIFT + i, true);
    }

    public static boolean getFirstMoreMenuGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_FIRST_MORE_MENU_GUIDE, false);
    }

    public static int getFirstRCStyleGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.FIRST_GUIDE_PANEL_MODE_GUIDE_SHOW, 0);
    }

    public static boolean getFirstRoutePlanTag() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.FIRST_ROUTE_PLAN, true);
    }

    public static boolean getFirstVoiceGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_FIRST_VOICE_GUIDE, false);
    }

    public static boolean getFirstVoiceNotifyGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.FIRST_VOICE_NOTIFY_GUIDE, true);
    }

    public static int getFloatMode() {
        if (!BNCommSettingManager.getInstance().deviceSupportPipMode()) {
            return 1;
        }
        return getInt(SettingParams.Key.RG_FLOAT_MODE, 0);
    }

    public static boolean getFristBlueToothChannelGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_FIRST_BLUE_TOOTH_CHANNEL_GUIDE, false);
    }

    public static boolean getFristMenuGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_FIRST_MENU_GUIDE, false);
    }

    public static String getFutureTripEtaDebugUrl() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAVI_FUTURE_TRIP_ETA_URL, "");
    }

    public static String getFutureTripInfo(String str) {
        return getString(SettingParams.Key.ROUTE_FUTURE_TRIP_INFO, str);
    }

    public static boolean getGPSHotStart() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_GPS_HOT_STAST, false);
    }

    public static int getGpsCloseVdrFunctionNormal() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.GPS_CLOSE_VDR_FUNCTION_NORMAL, 0);
    }

    private static int getHDDefaultMode() {
        int i = 0;
        if (containsKey(SettingParams.Key.HD_NAVI_DEFAULT_MODE)) {
            return mPreferenceHelper.a(SettingParams.Key.HD_NAVI_DEFAULT_MODE, 0);
        }
        try {
            if (ScreenUtil.getInstance().getHeightPixels() / (ScreenUtil.getInstance().getWidthPixels() * 1.0f) <= 1.78d) {
                i = 2;
                g gVar = g.COMMON;
                if (gVar.d()) {
                    gVar.e(TAG, "getHDDefaultMode:HD_FULL: " + ScreenUtil.getInstance().getHeightPixels() + "," + ScreenUtil.getInstance().getWidthPixels());
                }
            }
        } catch (Exception unused) {
        }
        e0 e0Var = mPreferenceHelper;
        if (e0Var != null) {
            e0Var.b(SettingParams.Key.HD_NAVI_DEFAULT_MODE, i);
        }
        return i;
    }

    public static int getHUDSDKSwitch() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a(SettingParams.Key.HUD_SDK_SWITCH, 1);
    }

    public static boolean getHasRouteSortCardGuideShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ROUTE_SORT_CAR_RESULT_CARD_GUIDE, false);
    }

    public static boolean getHasRouteSortSettingGuideShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ROUTE_SORT_SETTING_PAGE_GUIDE, false);
    }

    public static boolean getHasShowUserGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.USER_GUIDE_STATE, false);
    }

    public static boolean getHasVoiceRecommendClicked() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_VOICE_RECOMMEN_HAS_CLICKED, false);
    }

    public static int getHdScreenMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return getHDDefaultMode();
        }
        return e0Var.a(SettingParams.Key.HD_NAVI_SCREEN_MODE, getHDDefaultMode());
    }

    public static boolean getHudMirroShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.HUD_MIRRO_SHOW, false);
    }

    public static long getICBCCommercializeYellowBannerTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.YELLOW_BANNE_ICBC_COMMERCIALIZE_TIME, 0L);
    }

    public static int getIPOGuideShowTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 2;
        }
        return e0Var.a(SettingParams.Key.IPO_GUIDE_SHOW_TIME, 2);
    }

    public static int getIPOLockGuideTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.IPO_NAVI_LOCK_GUIDE, 2);
    }

    public static boolean getInitCloudCfg() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_INIT_CLOUD_CFG, false);
    }

    public static String getInitCloudCfgUrl() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "https://cq02-map-naviapp00.cq02.baidu.com:8320/mop/naviinit";
        }
        return e0Var.a(SettingParams.Key.NAVI_INIT_CLOUD_CFG_URL, "https://cq02-map-naviapp00.cq02.baidu.com:8320/mop/naviinit");
    }

    public static int getInt(String str, int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return i;
        }
        return e0Var.a(str, i);
    }

    public static int getIsEtc() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_IS_ETC, -1);
    }

    public static int getIsNewEnergyCar() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_IS_NEW_ENERGY, 0);
    }

    public static int getIsPickUp() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_IS_PICKUP, 0);
    }

    private static int getIsShowMapSwitch(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 1;
        }
        if (e0Var.a(SettingParams.Key.NAVI_SHOW_NEW_MAP_SWITCH)) {
            return mPreferenceHelper.a(SettingParams.Key.NAVI_SHOW_NEW_MAP_SWITCH, 3);
        }
        int a2 = mPreferenceHelper.a(SettingParams.Key.NAVI_SHOW_MAP_SWITCH, 1);
        return a.b().a("NAVI_SUPPORT_DEFAULT_ARC_CONDITION", true) ? a2 == 0 ? 0 : 3 : a2;
    }

    public static String getLast3DCarLogoBubbleText() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return null;
        }
        return e0Var.a(SettingParams.Key.LAST_SHOW_3D_CARLOGO_BUBBLE_TEXT, (String) null);
    }

    public static long getLast3DCarLogoBubbleTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.LAST_SHOW_3D_CARLOGO_BUBBLE_TIME, 0L);
    }

    public static long getLastAddressUploadTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.ADDRESS_LAST_UPLOAD_TIME, 0L);
    }

    public static int getLastCloseCarHomeDialogVersion() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.LAST_CLOSE_CAR_HOME_DIALOG_VERSION, Integer.MIN_VALUE);
    }

    public static int getLastCloseCarHomeTipVersion() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.LAST_CLOSE_CAR_HOME_TIP_VERSION, Integer.MIN_VALUE);
    }

    public static String getLastDrivingInfo() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return null;
        }
        return e0Var.a("driving_tool_info", (String) null);
    }

    public static int getLastQuiteMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 2;
        }
        return e0Var.a(SettingParams.Key.NAVI_LAST_QUIET_MODE, 2);
    }

    public static int getLastRouteSearchMCarPrefer() {
        return b.r();
    }

    public static int getLightCommutePreferMode() {
        return getInt(SettingParams.Key.COMMUTE_FUN_PREFER, 0);
    }

    public static int[] getLightNaviRouteMargin() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return new int[]{0, 0, 0, 0};
        }
        return parseStringToIntArray(e0Var.a(SettingParams.Key.LIGHT_NAV_ROUTE_VIEW_SIZE, "0:0:0:0"), 4);
    }

    public static boolean getLightUserGuideState() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.LIGHT_USER_GUIDE, false);
    }

    public static String getLocalChargingPrefer() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_NEW_ENERGY_CHARGE_PREFER, "");
    }

    public static long getLong(String str, long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return j;
        }
        return e0Var.a(str, j);
    }

    public static Boolean getMaiDouGuideIsShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(e0Var.a(SettingParams.Key.NAVI_VOICE_MAIDOU_GUIDE, false));
    }

    public static int getMapMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a(SettingParams.Key.NAVI_MAP_MODE, 1);
    }

    public static long getMapsStartTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.MAPS_INIT_TIME, 0L);
    }

    public static int getNavPreferMode() {
        return getInt(SettingParams.Key.NAV_MODE_PREFER, 0);
    }

    public static int getNaviDayAndNightMode() {
        e0 e0Var = mPreferenceHelper;
        int i = 1;
        if (e0Var == null) {
            if (!j.d()) {
                return 1;
            }
            return 2;
        }
        if (j.d()) {
            i = 2;
        }
        return e0Var.a(SettingParams.Key.NAVI_MODE_DAY_AND_NIGHT, i);
    }

    public static int getNaviSafeYellowBarDisplayCount() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 100;
        }
        return e0Var.a(SettingParams.Key.NAVI_SAFE_YELLOW_BAR_DISPLAY_COUNT, 0);
    }

    public static String getNewEnergyBrand() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_BRAND, "");
    }

    public static String getNewEnergyBrandModel() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_BRAND_MODEL, "");
    }

    public static String getNewEnergyBrandName() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_BRAND_NAME, "");
    }

    public static String getNewEnergyCarExt() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_NEW_ENERGY_EXT, "");
    }

    public static int getNewEnergyRemainMileage() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 300;
        }
        if (isFirstGetNeRemainMileage) {
            isFirstGetNeRemainMileage = false;
            int i = com.baidu.navisdk.module.routeresult.logic.plate.a.b().b(1).a().f7484a;
            setNewEnergyRemainMileage(i);
            return i;
        }
        return e0Var.a(SettingParams.Key.NAV_CAR_NEW_ENERGY_REMAIN_MILEAGE, 300);
    }

    public static int getNewEngRemainDist() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NEW_ENG_REMAIN_DISTANCE, 0);
    }

    public static String getNewVoiceTaskIds() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return null;
        }
        return e0Var.a(SettingParams.Key.NAVI_VOICE_NEW_VOICE_TASKIDS, "");
    }

    public static int getNormalBrightness() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 143;
        }
        return e0Var.a("normal_brightness", 143);
    }

    public static boolean getOfflineRPUseCar() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_RP_NET_MODE_OFFLINE_USE_CAR, false);
    }

    public static int getOrientationChangedDialogShowCount() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_ORIENTATIOJN_CHANGED_DIALOG_SHOW_COUNT, 0);
    }

    public static String getPlateFromLocal() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        try {
            return new String(Base64.decode(e0Var.a(SettingParams.Key.CAR_PLATE_NUM_NEW, ""), 0), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getPlayTTsVoiceMode() {
        int i = TTS_PLAY_MODE;
        if (i > -1) {
            return i;
        }
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        int a2 = e0Var.a(SettingParams.Key.NAVI_TTS_PLAY_MODE, 0);
        TTS_PLAY_MODE = a2;
        return a2;
    }

    public static String getPluginMD5() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return null;
        }
        return e0Var.a(SettingParams.Key.NAVI_PLUGIN_MD5, (String) null);
    }

    public static int getPoiListSortRuleType() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 1;
        }
        return e0Var.a(SettingParams.Key.POI_SORT_RULE_TYPE, 1);
    }

    public static int getPowerSaveMode() {
        int a2;
        if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a() || mPreferenceHelper == null) {
            return 2;
        }
        if (Build.VERSION.SDK_INT < 23) {
            a2 = mPreferenceHelper.a(SettingParams.Key.NAVI_POWER_SAVE_MODE, 0);
        } else {
            a2 = mPreferenceHelper.a(SettingParams.Key.NAVI_POWER_SAVE_MODE, 2);
        }
        if (a2 == 2) {
            return 2;
        }
        return 0;
    }

    public static int getPowerTypeFromLocal() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.CAR_POWER_TYPE, -1);
    }

    public static boolean getPrefFloatSwitch() {
        if (mPreferenceHelper == null) {
            return false;
        }
        if (getFloatMode() == 0) {
            if (!BNCommSettingManager.getInstance().hasPipPermission()) {
                return false;
            }
        } else if (!b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return getBoolean(SettingParams.Key.NAVI_PIP_SWITCH, false);
        }
        return getBoolean(SettingParams.Key.NAVI_PIP_SWITCH, true);
    }

    public static boolean getPrefParkSearch() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_PARK_SEARCH, false);
    }

    public static boolean getPrefRealEnlargementNavi() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.SP_SHOW_NAVING_REAL_ENLARGEMENT, true);
    }

    public static int getPrefRoutPlanMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 3;
        }
        return e0Var.a(SettingParams.Key.NAVI_RP_NET_MODE, 3);
    }

    public static int getPrefSearchMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 3;
        }
        return e0Var.a(SettingParams.Key.NAVI_SEARCH_NET_MODE, 3);
    }

    public static e0 getPreferenceHelper() {
        if (!isPreferenceInited()) {
            init(com.baidu.navisdk.framework.a.c().a());
        }
        return mPreferenceHelper;
    }

    public static int getPreferenceLocalCountTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a("local.count.time", 0);
    }

    public static boolean getPreferenceLocalRedPoint() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        if (!e0Var.a("local.red.point")) {
            mPreferenceHelper.b("local.red.point", true);
            return true;
        }
        return mPreferenceHelper.a("local.red.point", false);
    }

    public static String getPreferenceLocalSubTitle() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a("local.count.title", "");
    }

    public static int[] getProfessionalNaviRouteMargin() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return new int[]{0, 0, 0, 0};
        }
        return parseStringToIntArray(e0Var.a(SettingParams.Key.PROFESSIONAL_NAV_ROUTE_VIEW_SIZE, "0:0:0:0"), 4);
    }

    public static boolean getPushMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_PUSH_SERVICE, true);
    }

    public static boolean getQuitForExceptionInNaviMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.QUIT_FOR_EXCEPTION_IN_NAVIMODE, false);
    }

    public static int getRcPredictionBubbleShowTimes() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_RC_PREDICTION_BUBBLE_SHOW_TIMES, 0);
    }

    public static int getRecommend3DCarLogoId() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.RECOMMEND_3D_CARLOGO_ID, 0);
    }

    public static int getRememberPreferBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_REMEMBER_PREFER_BUBBLE, 0);
    }

    public static long getRookieEventOpStartTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.ROOKIE_EVENT_OP_START_TIME, 0L);
    }

    public static int getRouteChargePrefer() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.CHARGE_PREFER, 1);
    }

    public static int getRouteDetailGuideTextShowTimes() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return -1;
        }
        return e0Var.a(SettingParams.Key.ROUTE_DETAIL_GUIDE_SHOW_TIME, 3);
    }

    public static boolean getRouteGuideEnd() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_GUIDE_END, true);
    }

    public static int getRoutePlanResultPref() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_ROUTEPLAN_RESULT_PREF, 0);
    }

    public static int getRouteSortDrivingHabitValue() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_ROUTE_SORT_DRIVING_HABIT, 0);
    }

    public static boolean getSaveParkingSwitch() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_SAVE_PARKING_SWITCH, true);
    }

    public static int getSearchResultSortPref() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_SEARCH_RESULT_SORT_PREF, 0);
    }

    public static int getServiceAreaTipDisplayCount() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_SERVICE_AREA_TIP_DISPLAY_COUNT, 0);
    }

    public static boolean getShowCarLogoToEnd() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_SHOW_CAR_LOGO_TO_END, true);
    }

    public static int getShowNoHighWayBubbleTimes() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_SHOW_NO_HIGH_WAY_BUBBLE_TIMES, 0);
    }

    public static long getShowedFutureTripBubbleForeignLandTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_FOREIGN_LAND_TIME_MS, 0L);
    }

    public static long getShowedFutureTripBubbleLongDistanceTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_LONG_DISTANCE_TIME_MS, 0L);
    }

    public static long getShowedFutureTripBubbleStartNotMyLocTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_START_NOT_MY_LOC_TIME_MS, 0L);
    }

    public static long getShowedFutureTripBubbleTrafficOrViewpointTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_TRAFFIC_OR_VIEWPOINT_TIME_MS, 0L);
    }

    public static int getSimpleGuideMode() {
        int i = SIMPLE_GUIDE_MODE;
        if (i > -1) {
            return i;
        }
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        int a2 = e0Var.a(SettingParams.Key.SIMPLE_GUIDE_MODE, 0);
        SIMPLE_GUIDE_MODE = a2;
        return a2;
    }

    public static String getString(String str, String str2) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return str2;
        }
        return e0Var.a(str, str2);
    }

    public static long getTTSCopyTime() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0L;
        }
        return e0Var.a(SettingParams.Key.TTS_COPY_TIME, 0L);
    }

    public static String getTTSDataPath() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "";
        }
        return e0Var.a(SettingParams.Key.NAVI_VOICE_TTS_DATA_PATH, "");
    }

    public static int getTTSSpeedParam() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 5;
        }
        return e0Var.a(SettingParams.Key.NAVI_TTS_SPEED, 5);
    }

    public static String getTTSVocoderParam() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "0";
        }
        return e0Var.a(SettingParams.Key.NAVI_TTS_VOCODER, "0");
    }

    public static ArrayList<String> getToolboxMarkList() {
        String string = getString(SettingParams.Key.ROUTE_RESULT_TOOLBOX_ITEM_ARRAY, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String[] split = string.split(":");
        if (split.length == 0) {
            return null;
        }
        try {
            return new ArrayList<>(Arrays.asList(split));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getTtsAppId() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return "0";
        }
        return e0Var.a(SettingParams.Key.TTS_APP_ID, "0");
    }

    public static int[] getUserCarIconOffsetForNavi() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return new int[]{0, 0};
        }
        return parseStringToIntArray(e0Var.a(SettingParams.Key.PROFESSIONAL_NAV_CAR_ICON_OFFSET_USER_SET, "0:0"), 2);
    }

    public static String getVdrLowNotificationShowDate() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return null;
        }
        return e0Var.a(SettingParams.Key.NAVI_VDR_LOW_OPERABLE_NOTIFICATION_SHOW_DATE, (String) null);
    }

    public static boolean getVectorExpandMapVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.SP_SHOW_NAVING_VECTOR_EXPAND, true);
    }

    public static int getViaPointCount() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 15;
        }
        return e0Var.a(SettingParams.Key.NAVI_VIA_POINT_COUNT, 15);
    }

    public static int getVoiceMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_VOICE_MODE, 0);
    }

    public static int getVoiceRecommendNotificationShowCnt() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.NAVI_VOICE_RECOMMEN_SHOW_COUNT, 0);
    }

    public static int getXDInstructionCount(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return 0;
        }
        return e0Var.a(SettingParams.Key.XD_INSTRUCTION_PRE_SUFFIX + str, 0);
    }

    public static String grtTestEnvironmentUrl() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return null;
        }
        return e0Var.a(SettingParams.Key.NAVI_TEST_ENVIRONMENT_URL, (String) null);
    }

    public static boolean hasDestParkClicked() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_DEST_PARK_SWITCH_CLICKED, false);
    }

    public static boolean hasPipPermission() {
        AppOpsManager appOpsManager;
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (Build.VERSION.SDK_INT < 26 || (appOpsManager = (AppOpsManager) a2.getSystemService("appops")) == null || appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), a2.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public static void init(Context context) {
        if (mPreferenceHelper == null) {
            mPreferenceHelper = e0.a(context);
        }
        loadDefaultValue();
    }

    public static boolean isAlwaysBright() {
        return true;
    }

    public static boolean isAnalogQuitButtonVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.ANALOG_QUIT_BUTTON, true);
    }

    public static boolean isAnalogSpeedButtonVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.ANALOG_SPEED_BUTTON, true);
    }

    public static boolean isAnalogSwitchButtonVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.ANALOG_SWITCH_BUTTON, true);
    }

    public static boolean isAntiCheatOpen() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ANTI_CHEAT, true);
    }

    public static boolean isArMockEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAV_AR_MOCK, false);
    }

    public static boolean isArRecordEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAV_AR_RECORD, false);
    }

    public static boolean isAsrFirstUse() {
        return false;
    }

    public static boolean isAutoLevelMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_AUTO_LEVEL, true);
    }

    public static boolean isAutoQuitWhenArrived() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAV_AUTO_QUIT_ARRIVE, true);
    }

    public static boolean isAutoUpdateNewData() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_AUTO_UPDATE_NEW_DATA, false);
    }

    public static boolean isAvoidanceNotificationVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_AVOIDANCE_NOTIFICATION, true);
    }

    public static boolean isAvoidanceReminderVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_AVOIDANCE_REMINDER, true);
    }

    public static boolean isBlueToothPhoneChannel() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_BLUE_TOOTH_PHONE_CHANNEL, false);
    }

    public static boolean isBluetoothGuideShowed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_BT_GUIDE_SHOWED, false);
    }

    public static boolean isBottomBarOpen() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_SETTING_BOTTOM_BAR, true);
    }

    public static boolean isClickRoutePreferGuid() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ROUTE_PREFER_GUID_IS_CLICK, false);
    }

    public static boolean isClickedSettingItemInToolBox() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.IS_CLICKED_TOOLBOX_SETTING_ITEM, false);
    }

    public static boolean isClickedSettingPageNaviSettingItem() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.IS_CLICKED_SETTING_PAGE_NAVI_SETTING_ITEM, false);
    }

    @Deprecated
    public static boolean isCommuteEnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.COMMUTE_FUN, true);
    }

    public static boolean isCommuteRouteTabConcernRoadGuidViewNeverShown() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.COMMUTE_ROUTE_TAB_CONCERN_GUIDE, true);
    }

    public static boolean isCommuteSoundEnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.COMMUTE_GUIDE_SETTING_SOUND, true);
    }

    public static boolean isDayNightGuideHasShowed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.DAY_NIGHT_GUIDE_HAS_SHOW, false);
    }

    public static boolean isDisclaimerShow(String str) {
        if (mPreferenceHelper != null && !TextUtils.isEmpty(str)) {
            return mPreferenceHelper.a(str, true);
        }
        return false;
    }

    public static boolean isDiySpeakAutoChangeInMusic() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_DIY_VOICE_AUTO_CHANGE_IN_MUSIC, false);
    }

    public static boolean isDiyVoiceSwitchGuideHasShowed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_DIY_VOICE_MODE_SWITCH_GUIDE, false);
    }

    public static boolean isDragFavoriteButton() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_DRAG_FAVORITE_ROUTE_BUTTON, false);
    }

    public static boolean isElecCameraSpeakEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.Navi_ElecCamera_Speak, true);
    }

    public static boolean isEnable(String str) {
        if (mPreferenceHelper == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return mPreferenceHelper.a(str, false);
    }

    public static boolean isEnteredAdditionSettingPage() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ADDITION_PAGE_VISITED, false);
    }

    public static boolean isEnteredBroadcastContentSettingPage() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_ENTERED_BROADCAST_CONTENT_PAGE, false);
    }

    public static boolean isEnteredNaviVoiceSettingPage() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.IS_ENTERED_NAVI_VOICE_SETTING_PAGE, false);
    }

    public static boolean isEnteredNavingSettingPage() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVING_SETTING_VISITED, false);
    }

    public static boolean isExecutedCarForceToNewEng() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_CAR_FORCE_TO_NEW_ENG, false);
    }

    public static boolean isFellowButtonClick() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.FELLOW_IS_BUTTON_CLICK, false);
    }

    public static boolean isFellowDebug() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_FELLOW_DEBUG, false);
    }

    public static boolean isFellowTipsShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.FELLOW_TIPS_SHOW, true);
    }

    public static boolean isFirstClickChangePrefer() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("NAVI_XD_SCENE_AID_CHANGE_PREFER", true);
    }

    public static boolean isFirstClickDayNight() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_XD_SCENE_AID_DAYNIGHT, true);
    }

    public static boolean isFirstClickUgcUpload() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_XD_SCENE_AID_UGC_UPLOAD, true);
    }

    public static boolean isFirstClickVoiceMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_XD_SCENE_AID_VOICE_MODE, true);
    }

    public static boolean isFirstItsOn() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.FIRST_ITS_ON, true);
    }

    public static boolean isFirstRefeshRoute() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_XD_SCENE_AID_REFRESH_ROUTE, true);
    }

    public static boolean isFirstSwitchRoute() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_XD_SCENE_AID_SWITCH_ROUTE, true);
    }

    public static boolean isFistUseLightNaviPowerMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.IS_LIGHT_POWER_MODE_FIRST_ENABLE, true);
    }

    public static boolean isGPSDebug() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_GPS_DEBUG, false);
    }

    public static boolean isGpsNeverClose() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_NEVER_CLOSE_GPS, false);
    }

    public static boolean isHWSimpleBoardEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.HIGHWAY_SIMPLE_BOARD, true);
    }

    public static boolean isIPOGuideFirstShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.IS_IPO_GUIDE_FIRST_SHOW, true);
    }

    public static boolean isIpoRoadCondOnOrOff() {
        if (mPreferenceHelper == null) {
            return false;
        }
        if (!j.d()) {
            return mPreferenceHelper.a(SettingParams.Key.NAVI_ROADCOND_ON_OFF, false);
        }
        return mPreferenceHelper.a(SettingParams.Key.NAVI_IPO_ROADCOND_ON_OFF, false);
    }

    public static boolean isJamRoadGuideShown() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.JAM_ROAD_GUIDE_IS_SHOWN, false);
    }

    public static boolean isLaneLineDebugEnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_USE_LANELINE_DEBUG, false);
    }

    public static boolean isLeakEnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.LEAK_CANARY_FUNCTION_STATUS, false);
    }

    public static boolean isLightQuietEnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.LIGHT_NAVI_QUIET, false);
    }

    public static boolean isLightRedPointEverShown() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.LIGHT_RED_POINT, false);
    }

    public static boolean isLightSavePowerEnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.LIGHT_NAVI_SAVE_POWER, false);
    }

    public static boolean isLocationShareBtnNeedNewTag() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_SHOW_LOCATION_SHARE_BTN_NEW_TAG, true);
    }

    public static boolean isLocationShareOnline() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_LOCATION_SHARE_FUNC_ONLINE, true);
    }

    public static boolean isLocationShareOpen() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_LOCATION_SHARE_FUNC_OPEN, true);
    }

    public static boolean isLocationShareUsing() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_LOCATION_SHARE_FUNC_USING, false);
    }

    public static boolean isMainAuxiliaryOrBridgeEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_MAIN_AUXILIARY_OR_BRIDGE, true);
    }

    public static boolean isMeasurementEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_MEASUREMENT_ENABLE, true);
    }

    public static boolean isMonkey() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_MONKEY, false);
    }

    public static boolean isMoreBtnNeedNewTag() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_SHOW_MORE_BTN_NEW_TAG, false);
    }

    public static boolean isMultiRouteEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_OPEN_MULTI_ROUTE, true);
    }

    public static boolean isNavEndYellowBannerFirstClick() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_END_YELLOW_BANNER_CLICK, true);
    }

    public static boolean isNavEndYellowBannerFirstShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_END_YELLOW_BANNER_SHOW, true);
    }

    public static boolean isNaviAutoCheckNewData() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_AUTO_CHECK_NEW_DATA, true);
    }

    public static boolean isNaviDisclaimerShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_SHOW_DISCLAIMER, true);
    }

    public static boolean isNaviRealHistoryITS() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_REAL_HISTORY_ITS, true);
    }

    public static boolean isNaviSafeTipsShowed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_SAFEGUARD_TIPS_SHOWED, false);
    }

    public static boolean isNodeClick() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_OPEN_NODE_CLICK, true);
    }

    public static boolean isNoviceMode() {
        if (getNavPreferMode() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isOpenRememberRoutePrefer() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ROUTE_PREFER_REMEMBER_IS_OPEN, false);
    }

    public static boolean isOrientationBtnNeedNewTag() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ORITATION_BTN_NEW_TAG, true);
    }

    public static boolean isOrientationLandscapeByUser() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ORIENTATION_LANDSCAPE_BY_USER, false);
    }

    public static boolean isPhoneStateDeclareShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_SHOW_PHONE_STATE_DECLARE, true);
    }

    public static boolean isPlayBackgroundSpeak() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVI_PLAY_BACKGROUND_SPEAK, true);
    }

    public static boolean isPlayVoiceWhenCalling() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_PLAY_VOICE_WHEN_CALLING, false);
    }

    public static boolean isPreferenceInited() {
        boolean z = true;
        if (mPreferenceHelper != null) {
            return true;
        }
        synchronized (BNSettingManager.class) {
            if (mPreferenceHelper == null) {
                z = false;
            }
        }
        return z;
    }

    public static boolean isQuitNaviEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_UGC_BUTTON_ENABLE, true);
    }

    public static boolean isRGFloatOpenGuideHasShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.RG_FLOAT_OPEN_GUIDE_SHOW, false);
    }

    public static boolean isRecordingHighDefinition() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("video_high_definition", true);
    }

    public static boolean isRefreshButtonVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_REFRESH_BUTTON, true);
    }

    public static boolean isRememberLaunchMode() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_REMEMBER_LAUNCH_MODE, false);
    }

    public static boolean isRoadBarStyle() {
        if (getIsShowMapSwitch() != 0) {
            return true;
        }
        return false;
    }

    public static boolean isRoadCondOnOrOff() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ROADCOND_ON_OFF, false);
    }

    public static boolean isRoadConditionAllowClick() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.RC_IS_ALLOW_CLICK, true);
    }

    public static boolean isRoadConditionButtonVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_ROAD_CONDITION_BUTTON, true);
    }

    public static boolean isRoadConditionShowAvoid() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.RC_IS_SHOW_AVOID, true);
    }

    public static boolean isRoadConditionSpeakEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.Navi_RoadCondition_Speak, true);
    }

    public static boolean isRoadNameEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_ROAD_NAME_ENABLE, true);
    }

    public static boolean isRootScreenOpen() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ROOT_SCREEN, false);
    }

    public static boolean isRootScreenshotPermitted() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a("screenshot_root_user_permission", true);
    }

    public static boolean isSaftyDriveSpeakEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.Navi_SaftyDrive_Speak, true);
    }

    public static boolean isScenicBroadcastOpen() {
        if (mPreferenceHelper == null) {
            return false;
        }
        if (!f.c().c.H) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "scenic_broadcast cloud close");
            }
            return false;
        }
        return mPreferenceHelper.a(SettingParams.Key.BN_SCENIC_BROADCAST_OPEN, true);
    }

    public static boolean isSensorCheckDebugEnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_SENSOR_CHECK_DEBUG, true);
    }

    public static boolean isSettingButtonVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_SETTING_BUTTON, true);
    }

    public static boolean isShowJavaLog() {
        if (mPreferenceHelper == null) {
            return false;
        }
        if (j.d()) {
            return mPreferenceHelper.a(SettingParams.Key.NAVI_SHOW_JAVA_LOG, false);
        }
        return LogUtil.LOGGABLE;
    }

    public static boolean isShowNativeLog() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_SHOW_NATIVE_LOG, false);
    }

    public static boolean isShowNaviAsr() {
        return true;
    }

    public static boolean isShowNaviWeatherTips() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_WEATHER_BTN_TIPS_HAS_SHOW, false);
    }

    public static boolean isShowNoHighWayBubbleLast() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_LAST_IS_SHOW_NO_HIGH_WAY_BUBBLE, false);
    }

    public static boolean isShowPersonalizeVoiceGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.VOICE_PERSONALIZE_VOICE_GUIDE, true);
    }

    public static boolean isShowRGZoomInBtn() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.RG_ZOOM_IN_BTN_SHOW, true);
    }

    public static boolean isShowRemindDialog() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_REMIND_DIALOG, true);
    }

    public static boolean isShowRouteResultAvoidJamBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_SHOW_AVOID_JAM_BUBBLE, false);
    }

    public static boolean isShowRouteResultCancelFavoriteBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_SHOW_CANCEL_FAVORITE_BUBBLE, false);
    }

    public static boolean isShowRouteResultFavoriteBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_SHOW_FAVORITE_BUBBLE, false);
    }

    public static boolean isShowRouteResultNearbySearchChargeBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_SHOW_NEARBY_SEARCH_CHARGE_BUBBLE, false);
    }

    public static boolean isShowRouteResultToOnlineBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_SHOW_TO_ONLINE_BUBBLE, false);
    }

    public static boolean isShowRouteResultWeatherGuideBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_SHOW_WEATHER_GUIDE_BUBBLE, false);
    }

    public static boolean isShowedBroadcastContentBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_SHOW_BROADCAST_CONTENT_BUBBLE_IN_RR, false);
    }

    public static boolean isShowedDrivingHabitEnter() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_ROUTE_SORT__IS_SHOW_DRIVING_HABIT, false);
    }

    public static boolean isShowedLessChargeBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_SHOW_LESS_CHARGE_BUBBLE, false);
    }

    public static boolean isShowedLightNaviBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_IS_SHOW_LIGHT_NAVI_BUBBLE, false);
    }

    public static boolean isShowedRouteResultFavoriteGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_FAVORITE_GUIDE, false);
    }

    public static boolean isShowedRouteResultFutureTripGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_FUTURE_TRIP_GUIDE, false);
    }

    public static boolean isShowedRouteResultIntelliDriveGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_INTELLI_DRIVE_GUIDE, false);
    }

    public static boolean isShowedRouteResultPickUpLimitGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_PICKUP_LIMIT_GUIDE, false);
    }

    public static boolean isShowedRouteResultRcPredictionGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_RC_PREDICTION_GUIDE, false);
    }

    public static boolean isShowedRouteResultRefreshGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_REFRESH_GUIDE, false);
    }

    public static boolean isShowedRouteResultTruckGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_APPROACH_GUIDE, false);
    }

    public static boolean isShowedRouteResultWeatherAndDownloadGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_WEATHER_AND_DOWNLOAD_GUIDE, false);
    }

    public static boolean isShowedTruckProPlateGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.TRUCK_PRO_PLATE_GUIDE, false);
    }

    public static boolean isShowedTruckProUseGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.TRUCK_PRO_USE_GUIDE, false);
    }

    public static boolean isShowingDrivingTool() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a("showing_driving_tool", false);
    }

    public static boolean isSpeedCameraSpeakEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.Navi_SpeedCamera_Speak, true);
    }

    public static boolean isStartByFullView() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAVING_START_BY_FULLVIEW, true);
    }

    public static boolean isStraightDirectSpeakEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.Navi_StraightDirect_Speak, true);
    }

    public static boolean isTestEnvironment() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_TEST_ENVIRONMENT, false);
    }

    public static boolean isToolboxChargingMoveToBack() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.ROUTE_RESULT_TOOLBOX_CHARGING_MOVE_TO_BACK, false);
    }

    public static boolean isTrackLocateGuide() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.SP_TRACK_LOCATE_GUIDE, false);
    }

    public static boolean isUgcButtonEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_UGC_BUTTON_ENABLE, true);
    }

    public static boolean isUseHttpsOfflineURL() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_USE_HTTPS_OFFLINE_URL, false);
    }

    public static boolean isUseOldSetting() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.USE_OLD_SETTING, false);
    }

    public static boolean isUseTextureViewDebugEnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_USE_TEXTUREVIEW_DEBUG, false);
    }

    public static boolean isUserAccountOnline() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.SP_ACCOUNT_ONLINE, true);
    }

    public static boolean isUsingMapMode() {
        if (mPreferenceHelper == null || getCurrentUsingMode() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isVDREnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.VDR_FUNCTION_STATUS, true);
    }

    public static boolean isVDRMockForDebugEnabled() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.VDR_MOCK_FOR_DEBUG, false);
    }

    public static boolean isViaPreferRoutePlanEnable() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_VIA_PREFER_ROUTE_PLAN, false);
    }

    public static boolean isVoiceBtnNeedNewTag() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_VOICE_BTN_NEW_TAG, false);
    }

    public static boolean isVoiceBtnTipsPlayed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_VOICE_BTN_TIPS_PLAYED, false);
    }

    public static boolean isVoiceBtnTipsShowed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_VOICE_BTN_TIPS_SHOWED, false);
    }

    public static boolean isVoiceButtonVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_VOICE_BUTTON, true);
    }

    public static boolean isXDAwakened() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.NAVI_XD_AWAKEND, false);
    }

    public static boolean isZoomButtonVisible() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.a(SettingParams.Key.NAV_ZOOM_BUTTON, true);
    }

    private static void loadDefaultValue() {
        mPreferenceHelper.b(SettingParams.Key.FIRST_INSTALL_USER, a0.g(com.baidu.navisdk.framework.a.c().a()));
        if (!containsKey(SettingParams.Key.NAVI_DIY_VOICE_MODE)) {
            int voiceMode = getVoiceMode();
            if (voiceMode != 0 && voiceMode != 1) {
                if (j.c()) {
                    setDiyVoiceMode(1);
                    return;
                } else {
                    setDiyVoiceMode(0);
                    return;
                }
            }
            setDiyVoiceMode(voiceMode);
        }
    }

    private static int[] parseStringToIntArray(String str, int i) {
        int[] iArr = new int[i];
        String[] split = str.split(":");
        if (split != null && split.length == i) {
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    iArr[i2] = Integer.parseInt(split[i2]);
                } catch (NumberFormatException unused) {
                    LogUtil.e("BNSettingMananger", "parseStringToIntArray = " + str + ", can not format to int[]");
                    return new int[i];
                }
            }
            return iArr;
        }
        return new int[i];
    }

    public static boolean putBoolean(String str, boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(str, z);
    }

    public static boolean putFloat(String str, float f) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(str, f);
    }

    public static boolean putInt(String str, int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(str, i);
    }

    public static boolean putLightCommutePreferMode(int i) {
        return putInt(SettingParams.Key.COMMUTE_FUN_PREFER, i);
    }

    public static boolean putLong(String str, long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(str, j);
    }

    public static boolean putNavPreferMode(int i) {
        if (i == 0) {
            if (mPreferenceHelper.a(SettingParams.Key.ENTER_NAVI_BY_ROOKIE_MODE)) {
                com.baidu.navisdk.util.statistic.userop.b.r().d("13.2.0", "1");
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().d("13.2.0", "0");
            }
        } else {
            mPreferenceHelper.b(SettingParams.Key.HAS_TURN_ON_ROOKIE_MODE, true);
        }
        return putInt(SettingParams.Key.NAV_MODE_PREFER, i);
    }

    public static void putRookieEventOpStartTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROOKIE_EVENT_OP_START_TIME, j);
    }

    public static boolean putString(String str, String str2) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(str, str2);
    }

    public static void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.a(onSharedPreferenceChangeListener);
    }

    public static void removeKey(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.c(str);
    }

    public static boolean saveFirstGuide(String str, boolean z) {
        JSONObject jSONObject;
        LogUtil.e(TAG, "saveFirstGuide-> key: " + str + ", value: " + z);
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            LogUtil.e(TAG, "saveFirstGuide-> mPreferenceHelper == null, return false!");
            return false;
        }
        String trim = e0Var.a(SettingParams.Key.BN_FIRST_GUIDE, "").trim();
        try {
            if (l0.c(trim)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(trim);
            }
            jSONObject.put(str, z);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "saveFirstGuide-> firstGuideStr= " + trim + ", mJsonObj= " + jSONObject);
            }
            mPreferenceHelper.b(SettingParams.Key.BN_FIRST_GUIDE, jSONObject.toString());
            return true;
        } catch (JSONException e) {
            if (LogUtil.LOGGABLE) {
                e.printStackTrace();
                LogUtil.printException("saveFirstGuide", e);
            }
            return false;
        }
    }

    public static boolean saveLocalPreferenceLocal(int i, String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b("local.count.time", i);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return mPreferenceHelper.b("local.count.title", str);
    }

    public static void set3DCarLogoBubbleTimes(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.SHOW_3D_CARLOGO_BUBBLE_TIMES, i);
    }

    public static boolean set3DCarLogoFilePath(String str, String str2) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(str, str2);
    }

    public static void setAddressUploadTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ADDRESS_LAST_UPLOAD_TIME, j);
    }

    public static void setAlwaysBright(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ALWAYS_BRIGHT, z);
    }

    public static void setAnalogQuitButtonVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ANALOG_QUIT_BUTTON, z);
    }

    public static void setAnalogSpeedButtonVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ANALOG_SPEED_BUTTON, z);
    }

    public static void setAnalogSwitchButtonVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ANALOG_SWITCH_BUTTON, z);
    }

    public static void setAntiCheatOpen(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ANTI_CHEAT, z);
    }

    public static boolean setArMock(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_AR_MOCK, z);
    }

    public static boolean setArNavOrientation(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.AR_NAV_ORIENTATION, i);
    }

    public static boolean setArNavState(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.AR_NAV_STATE, i);
    }

    public static boolean setArRecord(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_AR_RECORD, z);
    }

    public static void setAsrFirstUse(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ASR_FIRST_USE, z);
    }

    public static void setAutoEnterLightNavi(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_AUTO_ENTER_LIGHT_NAVI, z);
    }

    public static void setAutoLevelMode(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_AUTO_LEVEL, z);
    }

    public static void setAutoUpdateNewData(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_AUTO_UPDATE_NEW_DATA, z);
    }

    public static void setAvoidanceNotificationVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_AVOIDANCE_NOTIFICATION, z);
    }

    public static void setAvoidanceReminderVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_AVOIDANCE_REMINDER, z);
    }

    public static void setBlueToothName(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_BLUE_TOOTH_NAME, str);
    }

    public static void setBlueToothPhoneChannel(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_BLUE_TOOTH_PHONE_CHANNEL, z);
    }

    public static void setBluetoothChannelMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_BLUETOOTH_CHANNEL_MODE, i);
    }

    public static void setBluetoothGuideShowed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_BT_GUIDE_SHOWED, true);
    }

    public static boolean setBrandId(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_BRAND_ID, i);
    }

    public static boolean setCanShowCommuteEntrance(boolean z) {
        return putBoolean(SettingParams.Key.COMMUTE_FUN, z);
    }

    public static boolean setCarIcon(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_ICON, str);
    }

    public static void setCarIconOffsetForLightNavi(int i, int i2) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.LIGHT_NAV_CAR_ICON_OFFSET, i + ":" + i2);
    }

    public static void setCarIconOffsetForNavi(int i, int i2) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.PROFESSIONAL_NAV_CAR_ICON_OFFSET, i + ":" + i2);
    }

    public static boolean setCarPassportIds(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_PASSPORT_IDS, str);
    }

    public static void setCarPlateToLocal(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var != null && str != null) {
            e0Var.b(SettingParams.Key.CAR_PLATE_NUM);
            mPreferenceHelper.b(SettingParams.Key.CAR_PLATE_NUM_NEW, Base64.encodeToString(str.getBytes(), 0));
        }
    }

    public static void setCarPowerTypeToLocal(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.CAR_POWER_TYPE, i);
    }

    public static void setCarRouteUseCarOwnerPlate(boolean z) {
        mPreferenceHelper.b(SettingParams.Key.ROUTE_USE_CAROWNER_PLATE, z);
    }

    public static boolean setChargeAreaTipDisplay(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAVI_CHARGE_AREA_TIP_DISPLAY_COUNT, i);
    }

    public static boolean setChargeAreaTipTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAVI_CHARGE_AREA_TIP_DISPLAY_TIME, j);
    }

    public static void setCloseAsrWakeUpPowerSave(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.CLOSE_ASR_WAKEUP_POWER_SAVE, z);
    }

    public static void setColladaStatus(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.COLLADA_SWITCH, z);
        try {
            JNIBaseMap.ColladaEnable(z);
        } catch (Throwable unused) {
        }
    }

    public static boolean setCommuteRouteTabConcernRoadGuidCanShowState(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.COMMUTE_ROUTE_TAB_CONCERN_GUIDE, z);
    }

    public static void setCruiseSafeGuardShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.CRUISE_SAFE_GUARD_SHOW, z);
    }

    public static void setCurrentUsingMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        if (i == 1 || i == 2) {
            e0Var.b(SettingParams.Key.SP_USING_MODE, i);
        }
    }

    public static void setDayNightGuideHasShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.DAY_NIGHT_GUIDE_HAS_SHOW, true);
    }

    public static void setDebugModeCalcRoadVersion(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.DEBUG_MODE_CALC_ROAD_VERSION, str);
    }

    public static void setDebugModeRouteGuideVersion(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.DEBUG_MODE_ROUTE_GUIDE_VERSION, str);
    }

    public static void setDefaultDayAndNightModeFromCloud(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DEFAULT_MODE_DAY_AND_NIGHT_FROM_CLOUD, i);
    }

    public static void setDefaultLaunchMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        if (i == 0 || i == 1 || i == 2) {
            e0Var.b(SettingParams.Key.NAVI_DEFAULT_LAUNCH_MODE, i);
        }
    }

    public static void setDefaultRouteSort(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DEFAULT_ROUTE_SORT, i);
    }

    public static void setDestParkClicked() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DEST_PARK_SWITCH_CLICKED, true);
    }

    public static void setDisclaimerShow(String str, boolean z) {
        if (mPreferenceHelper != null && !TextUtils.isEmpty(str)) {
            mPreferenceHelper.b(str, z);
        }
    }

    public static void setDispatchTag(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_DISPATCH_TAG, i);
    }

    public static void setDistrictId(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.SEARCH_DISTRICT_ID, i);
    }

    public static void setDistrictName(String str) {
        if (mPreferenceHelper != null && !TextUtils.isEmpty(str)) {
            mPreferenceHelper.b(SettingParams.Key.SEARCH_DISTRICT_NAME, str);
        }
    }

    public static void setDiyCustomModeValue(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DIY_CUSTOM_MODE_VALUE, j);
    }

    public static void setDiySpeakAutoChangeAidCancelCount(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DIY_VOICE_AUTO_CHANGE_AID_CANCEL, i);
    }

    public static void setDiySpeakAutoChangeInMusic(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DIY_VOICE_AUTO_CHANGE_IN_MUSIC, z);
    }

    public static void setDiySpeakMusicAidCount(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DIY_VOICE_MUSIC_AID_COUNT, i);
    }

    public static boolean setDiySwitchGuideShowTimes(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.DIY_SWITCH_GUIDE_SHOW_TIMES_IN_NAVI, i);
    }

    public static void setDiyVoiceMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DIY_VOICE_MODE, i);
    }

    public static void setDiyVoiceModeOpen(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DIY_VOICE_MODE_OPEN, z);
    }

    public static void setDiyVoiceSwitchGuideShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_DIY_VOICE_MODE_SWITCH_GUIDE, true);
    }

    public static void setDragFavoriteButton() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_DRAG_FAVORITE_ROUTE_BUTTON, true);
    }

    public static void setDynaPreload(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.DYNA_UI_PRELOAD, z);
    }

    public static void setElecCameraSpeakEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.Navi_ElecCamera_Speak, z);
    }

    public static boolean setEnable(String str, boolean z) {
        if (mPreferenceHelper != null && !TextUtils.isEmpty(str)) {
            return mPreferenceHelper.b(str, z);
        }
        return false;
    }

    public static void setEndNode(RoutePlanNode routePlanNode) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b("mName", routePlanNode.getName());
        if (routePlanNode.getGeoPoint() != null) {
            mPreferenceHelper.b("location", routePlanNode.getLatitudeE6() + "," + routePlanNode.getLongitudeE6());
        }
    }

    public static boolean setEnergyDefaultPlate(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null || str == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.NAV_ENERGY_DEFAULT_PLATE);
        return mPreferenceHelper.b(SettingParams.Key.NAV_ENERGY_DEFAULT_PLATE_NEW, Base64.encodeToString(str.getBytes(), 0));
    }

    public static boolean setEngBrandId(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_ENG_BRAND_ID, i);
    }

    public static boolean setEngCarIcon(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_ENG_ICON, str);
    }

    public static boolean setEngEtcClass(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_ENG_ETC_CLASS, i);
    }

    public static boolean setEngEtcColor(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_ENG_ETC_COLOR, i);
    }

    public static boolean setEngIsEtc(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_ENG_IS_ETC, i);
    }

    public static boolean setEngPassportIds(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_ENG_PASSPORT_IDS, str);
    }

    public static boolean setEtcClass(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_ETC_CLASS, i);
    }

    public static boolean setEtcColor(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_ETC_COLOR, i);
    }

    public static void setExecutedCarForceToNewEng(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_CAR_FORCE_TO_NEW_ENG, z);
    }

    public static void setFellowButtonClick(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FELLOW_IS_BUTTON_CLICK, z);
    }

    public static void setFellowCity(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FELLOW_DEBUG_CITY_NAME, i);
    }

    public static void setFellowDebug(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_FELLOW_DEBUG, z);
    }

    public static void setFellowSupport(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FELLOW_SUPPORT, z);
    }

    public static void setFellowSwitchStatus(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FELLOW_SWITCH, z);
    }

    public static void setFellowTipsShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FELLOW_TIPS_SHOW, z);
    }

    public static void setFellowTipsTTSPlayCount(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FELLOW_PREFER_TIPS_TTS_COUNT, i);
    }

    public static void setFellowTipsTTSStr(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FELLOW_PREFER_TIPS_TTS_KEY, str);
    }

    public static void setFirstCarLogoGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_FIRST_CAR_LOGO_GUIDE, z);
    }

    public static void setFirstClickChangePrefer(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b("NAVI_XD_SCENE_AID_CHANGE_PREFER", z);
    }

    public static void setFirstClickDayNight(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_XD_SCENE_AID_DAYNIGHT, z);
    }

    public static void setFirstClickUgcUpload(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_XD_SCENE_AID_UGC_UPLOAD, z);
    }

    public static void setFirstClickVoiceMode(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_XD_SCENE_AID_VOICE_MODE, z);
    }

    public static void setFirstGuideModeChecked(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_FIRST_GUIDE_MODE_GUIDE, z);
    }

    public static void setFirstHolidayShow(int i, boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.HOLIDAY_RED_GIFT + i, z);
    }

    public static void setFirstItsOn(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FIRST_ITS_ON, z);
    }

    public static void setFirstMoreMenuGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_FIRST_MORE_MENU_GUIDE, z);
    }

    public static void setFirstRCStyleGuide(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FIRST_GUIDE_PANEL_MODE_GUIDE_SHOW, i);
    }

    public static void setFirstRefreshRoute(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_XD_SCENE_AID_REFRESH_ROUTE, z);
    }

    public static void setFirstRoutePlanTag(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FIRST_ROUTE_PLAN, z);
    }

    public static void setFirstSwitchRoute(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_XD_SCENE_AID_SWITCH_ROUTE, z);
    }

    public static void setFirstUseLightNaviPowerMode(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.IS_LIGHT_POWER_MODE_FIRST_ENABLE, z);
    }

    public static void setFirstVoiceGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_FIRST_VOICE_GUIDE, z);
    }

    public static void setFirstVoiceNotifyGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.FIRST_VOICE_NOTIFY_GUIDE, z);
    }

    public static void setFloatMode(int i) {
        putInt(SettingParams.Key.RG_FLOAT_MODE, i);
    }

    public static void setFristBlueToothChannelGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_FIRST_BLUE_TOOTH_CHANNEL_GUIDE, z);
    }

    public static void setFristMenuGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_FIRST_MENU_GUIDE, z);
    }

    public static boolean setFutureTripEtaDebugUrl(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAVI_FUTURE_TRIP_ETA_URL, str);
    }

    public static boolean setFutureTripInfo(String str) {
        return putString(SettingParams.Key.ROUTE_FUTURE_TRIP_INFO, str);
    }

    public static void setGPSDebug(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_GPS_DEBUG, z);
    }

    public static void setGPSHotStart(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_GPS_HOT_STAST, z);
    }

    public static void setGpsCloseVdrFunctionNormal(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.GPS_CLOSE_VDR_FUNCTION_NORMAL, i);
    }

    public static void setGpsNeverClose(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_NEVER_CLOSE_GPS, z);
    }

    public static void setHUDSDKSwitch(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.HUD_SDK_SWITCH, i);
    }

    public static void setHWSimpleBoardEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.HIGHWAY_SIMPLE_BOARD, z);
    }

    public static void setHasAsrUploadAddress(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.HAS_UPLOAD_ADDRESS, i);
    }

    public static void setHasRouteSortCardGuideShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ROUTE_SORT_CAR_RESULT_CARD_GUIDE, z);
    }

    public static void setHasRouteSortSettingGuideShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ROUTE_SORT_SETTING_PAGE_GUIDE, z);
    }

    public static void setHasShowUserGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.USER_GUIDE_STATE, z);
    }

    public static void setHasVoiceRecommendClicked(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_VOICE_RECOMMEN_HAS_CLICKED, z);
    }

    public static void setHdScreenMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.HD_NAVI_SCREEN_MODE, i);
    }

    public static void setHudMirroShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.HUD_MIRRO_SHOW, z);
    }

    public static void setICBCCommercializeYellowBannerTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.YELLOW_BANNE_ICBC_COMMERCIALIZE_TIME, j);
    }

    public static void setIPOGuideFirstShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.IS_IPO_GUIDE_FIRST_SHOW, z);
    }

    public static void setIPOGuideShowTime(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.IPO_GUIDE_SHOW_TIME, i);
    }

    public static void setIPOLockGuideTime(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.IPO_NAVI_LOCK_GUIDE, i);
    }

    public static void setInitCloudCfg(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_INIT_CLOUD_CFG, z);
    }

    public static void setInitCloudCfgUrl(String str) {
        if (mPreferenceHelper != null && !TextUtils.isEmpty(str)) {
            mPreferenceHelper.b(SettingParams.Key.NAVI_INIT_CLOUD_CFG_URL, str);
        }
    }

    public static void setIpoRoadCondOnOff(boolean z) {
        if (mPreferenceHelper == null) {
            return;
        }
        if (!j.d()) {
            mPreferenceHelper.b(SettingParams.Key.NAVI_ROADCOND_ON_OFF, z);
        } else {
            mPreferenceHelper.b(SettingParams.Key.NAVI_IPO_ROADCOND_ON_OFF, z);
        }
    }

    public static void setIsAutoQuitWhenArrived(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_AUTO_QUIT_ARRIVE, z);
    }

    public static boolean setIsBroadcastContentBubbleShown(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_SHOW_BROADCAST_CONTENT_BUBBLE_IN_RR, z);
    }

    public static void setIsClickRoutePreferGuid(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ROUTE_PREFER_GUID_IS_CLICK, z);
    }

    public static boolean setIsClickedSettingItemInToolBox(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.IS_CLICKED_TOOLBOX_SETTING_ITEM, z);
    }

    public static boolean setIsClickedSettingPageNaviSettingItem(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.IS_CLICKED_SETTING_PAGE_NAVI_SETTING_ITEM, z);
    }

    public static boolean setIsEnteredAdditionSettingPage(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.ADDITION_PAGE_VISITED, z);
    }

    public static boolean setIsEnteredBroadcastContentSettingPage(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_ENTERED_BROADCAST_CONTENT_PAGE, z);
    }

    public static boolean setIsEnteredNaviVoiceSettingPage(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.IS_ENTERED_NAVI_VOICE_SETTING_PAGE, z);
    }

    public static boolean setIsEnteredNavingSettingPage(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAVING_SETTING_VISITED, z);
    }

    public static boolean setIsEtc(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_IS_ETC, i);
    }

    public static boolean setIsNewEnergyCar(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_IS_NEW_ENERGY, i);
    }

    public static void setIsOpenRememberRoutePrefer(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ROUTE_PREFER_REMEMBER_IS_OPEN, z);
    }

    public static boolean setIsPickUp(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_IS_PICKUP, i);
    }

    public static void setIsShowMapSwitch(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SHOW_NEW_MAP_SWITCH, i);
    }

    public static void setIsShowRGZoomInBtn(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.RG_ZOOM_IN_BTN_SHOW, z);
    }

    public static boolean setIsShowedDrivingHabitEnter(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.NAVI_ROUTE_SORT__IS_SHOW_DRIVING_HABIT, z);
        return true;
    }

    public static boolean setIsShowedLessChargeBubble(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_SHOW_LESS_CHARGE_BUBBLE, z);
        return true;
    }

    public static boolean setIsShowedLightNaviBubble(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_SHOW_LIGHT_NAVI_BUBBLE, z);
        return true;
    }

    public static void setJamRoadGuideIsShown(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.JAM_ROAD_GUIDE_IS_SHOWN, z);
    }

    public static boolean setLaneLineDebugEnabled(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAVI_USE_LANELINE_DEBUG, z);
    }

    public static void setLast3DCarLogoBubbleText(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.LAST_SHOW_3D_CARLOGO_BUBBLE_TEXT, str);
    }

    public static void setLast3DCarLogoBubbleTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.LAST_SHOW_3D_CARLOGO_BUBBLE_TIME, j);
    }

    public static void setLastCloseCarHomeDialogVersion(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.LAST_CLOSE_CAR_HOME_DIALOG_VERSION, i);
    }

    public static void setLastCloseCarHomeTipVersion(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.LAST_CLOSE_CAR_HOME_TIP_VERSION, i);
    }

    public static void setLastDrivingInfo(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b("driving_tool_info", str);
    }

    public static void setLastQuietMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        if (i == 2 || i == 3) {
            e0Var.b(SettingParams.Key.NAVI_LAST_QUIET_MODE, i);
        }
    }

    public static void setLastRouteSearchMCarPrefer(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("", "routesort setLastRouteSearchMCarPrefer " + i);
        }
        b.i(i);
    }

    public static void setLightNaviRouteMargin(int i, int i2, int i3, int i4) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.LIGHT_NAV_ROUTE_VIEW_SIZE, i + ":" + i2 + ":" + i3 + ":" + i4);
    }

    public static void setLightQuiet(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.LIGHT_NAVI_QUIET, z);
    }

    public static boolean setLightRedPointEverShown(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.LIGHT_RED_POINT, z);
    }

    public static void setLightSavePowerState(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.LIGHT_NAVI_SAVE_POWER, z);
    }

    public static boolean setLightUserGuideState(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.LIGHT_USER_GUIDE, z);
        return true;
    }

    public static boolean setLocalChargingPrefer(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_NEW_ENERGY_CHARGE_PREFER, str);
    }

    public static void setLocationShareBtnNeedNewTag(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SHOW_LOCATION_SHARE_BTN_NEW_TAG, z);
    }

    public static void setLocationShareOnline(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_LOCATION_SHARE_FUNC_ONLINE, z);
    }

    public static void setLocationShareOpen(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_LOCATION_SHARE_FUNC_OPEN, z);
    }

    public static void setLocationShareUsing(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_LOCATION_SHARE_FUNC_USING, z);
    }

    public static Boolean setMaiDouGuideIsShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return Boolean.FALSE;
        }
        return Boolean.valueOf(e0Var.b(SettingParams.Key.NAVI_VOICE_MAIDOU_GUIDE, z));
    }

    public static void setMainAuxiliaryOrBridgeEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_MAIN_AUXILIARY_OR_BRIDGE, z);
    }

    public static void setMapMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_MAP_MODE, i);
    }

    public static void setMapsStartTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.MAPS_INIT_TIME, j);
    }

    public static void setMeasurementEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_MEASUREMENT_ENABLE, z);
    }

    public static void setMonkey(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_MONKEY, z);
    }

    public static void setMoreBtnNeedNewTag(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SHOW_MORE_BTN_NEW_TAG, z);
    }

    public static void setMultiRouteEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_OPEN_MULTI_ROUTE, z);
        i.f().d();
    }

    public static void setNavEndYellowBannerFirstClick(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_END_YELLOW_BANNER_CLICK, z);
    }

    public static void setNavEndYellowBannerFirstShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_END_YELLOW_BANNER_SHOW, z);
    }

    public static void setNaviAutoCheckNewData(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_AUTO_CHECK_NEW_DATA, z);
    }

    public static void setNaviDayAndNightMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        if (1 == i || 2 == i || 3 == i) {
            e0Var.b(SettingParams.Key.NAVI_MODE_DAY_AND_NIGHT, i);
            com.baidu.navisdk.comapi.commontool.a.getInstance().c(i);
        }
    }

    public static void setNaviDisclaimerShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SHOW_DISCLAIMER, z);
    }

    public static void setNaviSafeTipsShowed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SAFEGUARD_TIPS_SHOWED, true);
    }

    public static boolean setNewEnergyBrand(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_BRAND, str);
    }

    public static boolean setNewEnergyBrandModel(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_BRAND_MODEL, str);
    }

    public static boolean setNewEnergyBrandName(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_BRAND_NAME, str);
    }

    public static boolean setNewEnergyCarExt(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_NEW_ENERGY_EXT, str);
    }

    public static boolean setNewEnergyRemainMileage(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAV_CAR_NEW_ENERGY_REMAIN_MILEAGE, i);
    }

    public static void setNewEngRemainDist(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NEW_ENG_REMAIN_DISTANCE, i);
    }

    public static void setNewVoiceTaskIds(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_VOICE_NEW_VOICE_TASKIDS, str);
    }

    public static void setNodeClick(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_OPEN_NODE_CLICK, z);
    }

    public static void setNormalBrightness(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b("normal_brightness", i);
    }

    public static void setOfflineRPUseCar(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_RP_NET_MODE_OFFLINE_USE_CAR, z);
    }

    public static void setOrientationBtnNeedNewTag() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ORITATION_BTN_NEW_TAG, false);
    }

    public static void setOrientationLandscapeByUser(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ORIENTATION_LANDSCAPE_BY_USER, z);
    }

    public static void setPhoneStateDeclareShow(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SHOW_PHONE_STATE_DECLARE, z);
    }

    public static boolean setPlateLimitOpen(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b("plate_limit_open", z);
        if (!z) {
            saveLocalPreferenceLocal(0, "");
            return true;
        }
        return true;
    }

    public static void setPlayBackgroundSpeak(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_PLAY_BACKGROUND_SPEAK, z);
    }

    public static boolean setPlayTTsVoiceMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        if (e0Var.b(SettingParams.Key.NAVI_TTS_PLAY_MODE, i)) {
            TTS_PLAY_MODE = i;
            return true;
        }
        return true;
    }

    public static void setPlayVoiceWhenCalling(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_PLAY_VOICE_WHEN_CALLING, z);
    }

    public static void setPluginMD5(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var != null && str != null) {
            e0Var.b(SettingParams.Key.NAVI_PLUGIN_MD5, str);
        }
    }

    public static void setPoiListSortRuleType(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.POI_SORT_RULE_TYPE, i);
    }

    public static void setPowerSaveMode(int i) {
        if (mPreferenceHelper == null) {
            return;
        }
        if (i == 0 || 1 == i || 2 == i) {
            if (!com.baidu.navisdk.function.b.FUNC_POWER_SAVE_MODE.a()) {
                mPreferenceHelper.b(SettingParams.Key.NAVI_POWER_SAVE_MODE, 2);
            } else {
                mPreferenceHelper.b(SettingParams.Key.NAVI_POWER_SAVE_MODE, i);
            }
            BNPowerSaver.getInstance().a(i);
            com.baidu.navisdk.module.powersavemode.f.o().a(i);
        }
    }

    public static void setPrefFloatSwitch(boolean z) {
        putBoolean(SettingParams.Key.NAVI_PIP_SWITCH, z);
    }

    public static void setPrefParkSearch(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_PARK_SEARCH, z);
    }

    public static boolean setPrefRealEnlargementNavi(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.b(SettingParams.Key.SP_SHOW_NAVING_REAL_ENLARGEMENT, z);
    }

    public static void setPrefRoutePlanMode(int i) {
        if (!com.baidu.navisdk.module.init.a.a()) {
            LogUtil.out(TAG, "setPrefRoutePlanMode --> init is failed.");
            return;
        }
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        if (i != 2 && i != 0) {
            if (i == 3 || i == 1) {
                i = 3;
            }
        } else {
            i = 2;
        }
        if (i == 2 || i == 3) {
            e0Var.b(SettingParams.Key.NAVI_RP_NET_MODE, i);
            int[] iArr = {1};
            int[] iArr2 = {i};
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "setPrefRoutePlanMode set vehicles: " + Arrays.toString(iArr) + ", netModes:" + Arrays.toString(iArr2));
            }
            JNIGuidanceControl.getInstance().setMultiRoutePlanUserSetting(BNCommSettingManager.getInstance().getForceSwitch(1), iArr2, iArr, BNCommSettingManager.getInstance().getYawingUseMode(1));
        }
    }

    public static void setPrefSearchMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        if (i != 2 && i != 0) {
            if (i != 3 && i != 1) {
                return;
            }
            e0Var.b(SettingParams.Key.NAVI_SEARCH_NET_MODE, 3);
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SEARCH_NET_MODE, 2);
    }

    public static boolean setPreferenceLocalRedPoint(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b("local.red.point", z);
    }

    public static void setProfessionalNaviRouteMargin(int i, int i2, int i3, int i4) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.PROFESSIONAL_NAV_ROUTE_VIEW_SIZE, i + ":" + i2 + ":" + i3 + ":" + i4);
    }

    public static void setPushMode(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_PUSH_SERVICE, z);
    }

    public static void setQuitForExceptionInNaviMode(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.QUIT_FOR_EXCEPTION_IN_NAVIMODE, z);
    }

    public static void setQuitNaviEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_UGC_BUTTON_ENABLE, z);
    }

    public static void setRGFloatOpenGuideHasShow() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.RG_FLOAT_OPEN_GUIDE_SHOW, true);
    }

    public static void setRPNetMode(boolean z) {
        int i;
        if (z) {
            i = 2;
        } else {
            i = 3;
        }
        setPrefRoutePlanMode(i);
    }

    public static void setRcPredictionBubbleShowTimes(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_RC_PREDICTION_BUBBLE_SHOW_TIMES, i);
    }

    public static void setRecommend3DCarLogoId(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.RECOMMEND_3D_CARLOGO_ID, i);
    }

    public static void setRecordingHighDefinition(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b("video_high_definition", z);
    }

    public static void setRefreshButtonVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_REFRESH_BUTTON, z);
    }

    public static void setRememberLaunchMode(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_REMEMBER_LAUNCH_MODE, z);
    }

    public static void setRememberPreferBubble(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_REMEMBER_PREFER_BUBBLE, i);
    }

    public static void setRoadCondOnOff(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ROADCOND_ON_OFF, z);
    }

    public static void setRoadConditionAllowClick(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.RC_IS_ALLOW_CLICK, z);
    }

    public static void setRoadConditionButtonVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_ROAD_CONDITION_BUTTON, z);
    }

    public static void setRoadConditionShowAvoid(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.RC_IS_SHOW_AVOID, z);
    }

    public static void setRoadConditionpeakEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.Navi_RoadCondition_Speak, z);
    }

    public static void setRoadNameEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_ROAD_NAME_ENABLE, z);
    }

    public static void setRootScreenOpen(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ROOT_SCREEN, z);
    }

    public static void setRootScreenshotState(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b("screenshot_root_user_permission", z);
    }

    public static void setRouteChargePrefer(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.CHARGE_PREFER, i);
    }

    public static void setRouteDetailGuideTextShowTimes(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_DETAIL_GUIDE_SHOW_TIME, i);
    }

    public static void setRouteGuideEnd(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_GUIDE_END, z);
    }

    public static void setRoutePlanResultPref(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        if (i == 0 || i == 1 || i == 2) {
            e0Var.b(SettingParams.Key.NAVI_ROUTEPLAN_RESULT_PREF, i);
        }
    }

    public static void setRouteSortDrivingHabitValue(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ROUTE_SORT_DRIVING_HABIT, i);
    }

    public static void setSaftyDriveSpeakEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.Navi_SaftyDrive_Speak, z);
    }

    public static void setSaveParkingSwitch(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SAVE_PARKING_SWITCH, z);
    }

    public static void setScenicBroadcastOpen(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.BN_SCENIC_BROADCAST_OPEN, z);
    }

    public static void setSearchResultSortPref(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        if (i == 0 || i == 1) {
            e0Var.b(SettingParams.Key.NAVI_SEARCH_RESULT_SORT_PREF, i);
        }
    }

    public static boolean setSensorCheckDebugEnabled(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAVI_SENSOR_CHECK_DEBUG, z);
    }

    public static boolean setServiceAreaTipDisplay() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return mPreferenceHelper.b(SettingParams.Key.NAVI_SERVICE_AREA_TIP_DISPLAY_COUNT, e0Var.a(SettingParams.Key.NAVI_SERVICE_AREA_TIP_DISPLAY_COUNT, 0) + 1);
    }

    public static void setSettingButtonVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_SETTING_BUTTON, z);
    }

    public static void setShowCarLogoToEnd(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SHOW_CAR_LOGO_TO_END, z);
    }

    public static boolean setShowFutureTripBubbleForeignLandTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_FOREIGN_LAND_TIME_MS, j);
        return true;
    }

    public static boolean setShowFutureTripBubbleLongDistanceTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_LONG_DISTANCE_TIME_MS, j);
        return true;
    }

    public static boolean setShowFutureTripBubbleStartNotMyLocTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_START_NOT_MY_LOC_TIME_MS, j);
        return true;
    }

    public static boolean setShowFutureTripBubbleTrafficOrViewpointTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_SHOW_FUTURE_TRIP_BUBBLE_TRAFFIC_OR_VIEWPOINT_TIME_MS, j);
        return true;
    }

    public static void setShowJavaLog(boolean z) {
        if (mPreferenceHelper == null) {
            return;
        }
        LogUtil.setLoggable(z);
        g.b(z);
        mPreferenceHelper.b(SettingParams.Key.NAVI_SHOW_JAVA_LOG, z);
    }

    public static void setShowNativeLog(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_SHOW_NATIVE_LOG, z);
    }

    public static void setShowNaviAsr(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_ASR_SHOW, z);
    }

    public static void setShowNaviWeatherTips() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_WEATHER_BTN_TIPS_HAS_SHOW, true);
    }

    public static void setShowNoHighWayBubble(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_LAST_IS_SHOW_NO_HIGH_WAY_BUBBLE, z);
    }

    public static void setShowPersonalizeVoiceGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.VOICE_PERSONALIZE_VOICE_GUIDE, z);
    }

    public static void setShowRemindDialog(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_REMIND_DIALOG, z);
    }

    public static void setShowRouteResultAvoidJamBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_SHOW_AVOID_JAM_BUBBLE, true);
    }

    public static void setShowRouteResultCancelFavoriteBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_SHOW_CANCEL_FAVORITE_BUBBLE, true);
    }

    public static void setShowRouteResultFavoriteBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_SHOW_FAVORITE_BUBBLE, true);
    }

    public static void setShowRouteResultNearbySearchChargeBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_SHOW_NEARBY_SEARCH_CHARGE_BUBBLE, true);
    }

    public static void setShowRouteResultToOnlineBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_SHOW_TO_ONLINE_BUBBLE, true);
    }

    public static void setShowRouteResultWeatherGuideBubble() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_IS_SHOW_WEATHER_GUIDE_BUBBLE, true);
    }

    public static boolean setShowedNoHighWayBubbleTimes(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_SHOW_NO_HIGH_WAY_BUBBLE_TIMES, i);
        return true;
    }

    public static boolean setShowedRouteResultFavoriteGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_FAVORITE_GUIDE, z);
        return true;
    }

    public static boolean setShowedRouteResultFutureTripGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_FUTURE_TRIP_GUIDE, z);
        return true;
    }

    public static boolean setShowedRouteResultIntelliDriveGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_INTELLI_DRIVE_GUIDE, z);
        return true;
    }

    public static boolean setShowedRouteResultPickUpLimitGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_PICKUP_LIMIT_GUIDE, z);
        return true;
    }

    public static boolean setShowedRouteResultRcPredictionGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_RC_PREDICTION_GUIDE, z);
        return true;
    }

    public static boolean setShowedRouteResultRefreshGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_REFRESH_GUIDE, z);
        return true;
    }

    public static boolean setShowedRouteResultTruckGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_APPROACH_GUIDE, z);
        return true;
    }

    public static boolean setShowedRouteResultWeatherAndDownloadGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_WEATHER_AND_DOWNLOAD_GUIDE, z);
        return true;
    }

    public static void setShowedTruckProPlateGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.TRUCK_PRO_PLATE_GUIDE, z);
    }

    public static void setShowedTruckProUseGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.TRUCK_PRO_USE_GUIDE, z);
    }

    public static void setShowingDrivingTool(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b("showing_driving_tool", z);
    }

    public static boolean setSimpleGuideMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        boolean b = e0Var.b(SettingParams.Key.SIMPLE_GUIDE_MODE, i);
        if (b) {
            SIMPLE_GUIDE_MODE = i;
            if (getFirstGuideModeChecked()) {
                setFirstGuideModeChecked(false);
            }
        }
        return b;
    }

    public static void setSpeedCameraSpeakEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.Navi_SpeedCamera_Speak, z);
    }

    public static void setStraightDirectSpeakEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.Navi_StraightDirect_Speak, z);
    }

    public static boolean setSupportBD(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.LOCATION_SUPPORT_BD, z);
    }

    public static void setTTSCopyTime(long j) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.TTS_COPY_TIME, j);
    }

    public static void setTTSSpeedParam(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_TTS_SPEED, i);
    }

    public static void setTTSVocoderParam(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_TTS_VOCODER, str);
    }

    public static void setTestEnvironment(boolean z, String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_TEST_ENVIRONMENT, z);
        mPreferenceHelper.b(SettingParams.Key.NAVI_TEST_ENVIRONMENT_URL, str);
    }

    public static void setToolboxChargeClicked() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.RR_NEARBY_SEARCH_CHARGE_RED_POINT_SHOW, false);
    }

    public static void setToolboxChargingMoveToBack(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.ROUTE_RESULT_TOOLBOX_CHARGING_MOVE_TO_BACK, z);
    }

    public static void setToolboxFutureTripClicked() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.RR_FUTURE_TRIP_RED_POINT_SHOW, false);
    }

    public static void setToolboxMarkList(ArrayList<String> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                if (i != arrayList.size() - 1) {
                    sb.append(arrayList.get(i));
                    sb.append(":");
                } else {
                    sb.append(arrayList.get(i));
                }
            }
            mPreferenceHelper.b(SettingParams.Key.ROUTE_RESULT_TOOLBOX_ITEM_ARRAY, sb.toString());
        }
    }

    public static void setTrackLocateGuide(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.SP_TRACK_LOCATE_GUIDE, z);
    }

    public static void setTtsAppId(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.TTS_APP_ID, str);
    }

    public static void setUgcButtonEnable(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_UGC_BUTTON_ENABLE, z);
    }

    public static void setUseHttpsOfflineURL(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_USE_HTTPS_OFFLINE_URL, z);
    }

    public static boolean setUseTextureViewDebugEnabled(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.b(SettingParams.Key.NAVI_USE_TEXTUREVIEW_DEBUG, z);
    }

    public static void setUserAccountOnline(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.SP_ACCOUNT_ONLINE, z);
    }

    public static void setVdrLowNotificationShowDate(String str) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var != null) {
            e0Var.b(SettingParams.Key.NAVI_VDR_LOW_OPERABLE_NOTIFICATION_SHOW_DATE, str);
        }
    }

    public static boolean setVectorExpandMapVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return true;
        }
        return e0Var.b(SettingParams.Key.SP_SHOW_NAVING_VECTOR_EXPAND, z);
    }

    public static void setViaPointCount(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_VIA_POINT_COUNT, i);
    }

    public static void setViaPreferRoutePlanEnable(boolean z) {
        if (mPreferenceHelper == null) {
            return;
        }
        com.baidu.navisdk.function.b.FUNC_SETTING_ROUTE_SORT.b(!z);
        mPreferenceHelper.b(SettingParams.Key.NAVI_VIA_PREFER_ROUTE_PLAN, z);
    }

    public static void setVoiceBtnNeedNewTag(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_VOICE_BTN_NEW_TAG, z);
    }

    public static void setVoiceBtnTipsPlayed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_VOICE_BTN_TIPS_PLAYED, true);
    }

    public static void setVoiceBtnTipsShowed() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_VOICE_BTN_TIPS_SHOWED, true);
    }

    public static void setVoiceButtonVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_VOICE_BUTTON, z);
    }

    public static void setVoiceMode(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        if (i == 0 || i == 2 || i == 1 || i == 3) {
            e0Var.b(SettingParams.Key.NAVI_VOICE_MODE, i);
        }
    }

    public static void setVoiceRecommendNotificationShowCnt(int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_VOICE_RECOMMEN_SHOW_COUNT, i);
    }

    public static void setXDAwakened() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_XD_AWAKEND, true);
    }

    public static void setXDInstructionCount(String str, int i) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.XD_INSTRUCTION_PRE_SUFFIX + str, i);
    }

    public static void setZoomButtonVisible(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAV_ZOOM_BUTTON, z);
    }

    public static void setsNaviRealHistoryITS(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.NAVI_REAL_HISTORY_ITS, z);
    }

    public static boolean showToolboxChargeRedPoint() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.RR_NEARBY_SEARCH_CHARGE_RED_POINT_SHOW, true);
    }

    public static boolean showToolboxFutureTripRedPoint() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.RR_FUTURE_TRIP_RED_POINT_SHOW, true);
    }

    public static boolean supportBD() {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return false;
        }
        return e0Var.a(SettingParams.Key.LOCATION_SUPPORT_BD, false);
    }

    public static void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(onSharedPreferenceChangeListener);
    }

    public static void useOldSetting(boolean z) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.USE_OLD_SETTING, z);
    }

    public static void userSetCarIconOffsetForNavi(int i, int i2) {
        e0 e0Var = mPreferenceHelper;
        if (e0Var == null) {
            return;
        }
        e0Var.b(SettingParams.Key.PROFESSIONAL_NAV_CAR_ICON_OFFSET_USER_SET, i + ":" + i2);
    }

    public static int getIsShowMapSwitch() {
        boolean w = x.w();
        int isShowMapSwitch = getIsShowMapSwitch(w);
        if (!(w && j.d()) && isShowMapSwitch == 3) {
            return 1;
        }
        return isShowMapSwitch;
    }
}
