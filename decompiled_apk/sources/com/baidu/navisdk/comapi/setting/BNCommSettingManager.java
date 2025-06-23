package com.baidu.navisdk.comapi.setting;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.Nullable;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.framework.interfaces.c;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.j;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.module.motorbike.preferences.a;
import com.baidu.navisdk.module.vehiclemanager.b;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.x;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class BNCommSettingManager {
    private static final String TAG = "BNCommSettingManager";

    /* loaded from: classes7.dex */
    public static final class SingleHolder {
        private static final BNCommSettingManager INSTANCE = new BNCommSettingManager();

        private SingleHolder() {
        }
    }

    private boolean getBoolean(String str, boolean z) {
        if (isMotor()) {
            return a.u0().a(str, z);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(str, z);
        }
        return BNSettingManager.getBoolean(str, z);
    }

    public static BNCommSettingManager getInstance() {
        return SingleHolder.INSTANCE;
    }

    private int getInt(int i, String str, int i2) {
        if (i == 2) {
            return a.u0().a(str, i2);
        }
        if (i == 3) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(str, i2);
        }
        return BNSettingManager.getInt(str, i2);
    }

    private String getString(String str, String str2) {
        if (isMotor()) {
            return a.u0().a(str, str2);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(str, str2);
        }
        return BNSettingManager.getString(str, str2);
    }

    private boolean isMotor() {
        return b.i().d();
    }

    private boolean isTruck() {
        return b.i().h();
    }

    private boolean putBoolean(String str, boolean z) {
        if (isMotor()) {
            return a.u0().c(str, z);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().c(str, z);
        }
        return BNSettingManager.putBoolean(str, z);
    }

    private boolean putInt(String str, int i) {
        if (isMotor()) {
            return a.u0().b(str, i);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().b(str, i);
        }
        return BNSettingManager.putInt(str, i);
    }

    private boolean putString(String str, String str2) {
        if (isMotor()) {
            return a.u0().b(str, str2);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().b(str, str2);
        }
        return BNSettingManager.putString(str, str2);
    }

    public void addOrientationChangedDialogShow() {
        if (isMotor()) {
            a.u0().a();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().a();
        } else {
            BNSettingManager.addOrientationChangedDialogShow();
        }
    }

    public boolean containsKey(String str) {
        if (isMotor()) {
            return a.u0().a(str);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(str);
        }
        return BNSettingManager.containsKey(str);
    }

    public boolean deviceSupportPipMode() {
        if (!com.baidu.navisdk.module.cloudconfig.a.b().a("pip_open", true)) {
            g gVar = g.MAP;
            if (gVar.d()) {
                gVar.e("kpkkikkpk", "cloud no");
            }
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return com.baidu.navisdk.framework.a.c().a().getPackageManager().hasSystemFeature("android.software.picture_in_picture");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public int getBluetoothChannelMode() {
        if (isMotor()) {
            return a.u0().b();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().b();
        }
        return BNSettingManager.getBluetoothChannelMode();
    }

    public long getDiyCustomModeValue() {
        if (isMotor()) {
            return a.u0().d();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().d();
        }
        return BNSettingManager.getDiyCustomModeValue();
    }

    public int getDiySpeakAutoChangAidCancelCount() {
        if (isMotor()) {
            return a.u0().e();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().e();
        }
        return BNSettingManager.getDiySpeakAutoChangAidCancelCount();
    }

    public int getDiySpeakMusicAidCount() {
        if (isMotor()) {
            return a.u0().f();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().f();
        }
        return BNSettingManager.getDiySpeakMusicAidCount();
    }

    @Deprecated
    public int getDiyVoiceMode() {
        if (isMotor()) {
            return a.u0().g();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().g();
        }
        return BNSettingManager.getDiyVoiceMode();
    }

    public boolean getDiyVoiceModeOpen() {
        if (isMotor()) {
            return a.u0().h();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().h();
        }
        return BNSettingManager.getDiyVoiceModeOpen();
    }

    public boolean getFirstGuide(String str, boolean z) {
        if (isMotor()) {
            return a.u0().b(str, z);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().b(str, z);
        }
        return BNSettingManager.getFirstGuide(str, z);
    }

    public boolean getFirstVoiceGuide() {
        if (isMotor()) {
            return a.u0().i();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().i();
        }
        return BNSettingManager.getFirstVoiceGuide();
    }

    public boolean getFirstVoiceNotifyGuide() {
        if (isMotor()) {
            return a.u0().j();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().j();
        }
        return BNSettingManager.getFirstVoiceNotifyGuide();
    }

    public int getFloatMode() {
        if (deviceSupportPipMode() && j.d()) {
            return getInt(SettingParams.Key.RG_FLOAT_MODE, 0);
        }
        return 1;
    }

    public boolean getForceSwitch() {
        return BNSettingManager.getBoolean(SettingParams.Key.RP_IS_FORCE_SWITCH_CLOSE, false);
    }

    public boolean getHasVoiceRecommendClicked() {
        if (isMotor()) {
            return a.u0().l();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().l();
        }
        return BNSettingManager.getHasVoiceRecommendClicked();
    }

    public int getIsShowMapSwitch() {
        if (x.s()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "getIsShowMapSwitch NE_Locate_Mode_RouteDemoGPS");
                return 1;
            }
            return 1;
        }
        if (isMotor()) {
            return a.u0().m();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().m();
        }
        return BNSettingManager.getIsShowMapSwitch();
    }

    public String getKeyByVehicle(String str) {
        if (isMotor()) {
            return a.u0().b(str);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().b(str);
        }
        return BNSettingManager.getCarKey(str);
    }

    public int getLastQuiteMode() {
        if (isMotor()) {
            return a.u0().n();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().n();
        }
        return BNSettingManager.getLastQuiteMode();
    }

    public int getMapMode() {
        if (isMotor()) {
            return a.u0().o();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().o();
        }
        return BNSettingManager.getMapMode();
    }

    public int getNaviDayAndNightMode() {
        if (isMotor()) {
            return a.u0().q();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().p();
        }
        return BNSettingManager.getNaviDayAndNightMode();
    }

    public int getOrientationChangedDialogShowCount() {
        if (isMotor()) {
            return a.u0().r();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().q();
        }
        return BNSettingManager.getOrientationChangedDialogShowCount();
    }

    public int getPlayTTsVoiceMode() {
        if (isMotor()) {
            return a.u0().v();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().r();
        }
        return BNSettingManager.getPlayTTsVoiceMode();
    }

    public int getPowerSaveMode() {
        if (isMotor()) {
            return a.u0().w();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().s();
        }
        return BNSettingManager.getPowerSaveMode();
    }

    public boolean getPrefFloatSwitch() {
        if (getFloatMode() == 0) {
            if (!hasPipPermission()) {
                return false;
            }
        } else if (!com.baidu.navisdk.framework.b.f("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return getBoolean(SettingParams.Key.NAVI_PIP_SWITCH, false);
        }
        return getBoolean(SettingParams.Key.NAVI_PIP_SWITCH, true);
    }

    public boolean getPrefParkSearch() {
        if (isMotor() || isTruck()) {
            return false;
        }
        return BNSettingManager.getPrefParkSearch();
    }

    public boolean getPrefRealEnlargementNavi() {
        if (isMotor()) {
            return a.u0().z();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().v();
        }
        return BNSettingManager.getPrefRealEnlargementNavi();
    }

    public int getPrefRoutPlanMode() {
        if (isMotor()) {
            return a.u0().A();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().w();
        }
        return BNSettingManager.getPrefRoutPlanMode();
    }

    public int getPrefSearchMode() {
        if (isMotor()) {
            return a.u0().B();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().x();
        }
        return BNSettingManager.getPrefSearchMode();
    }

    @Nullable
    public String getProCustomShortcutFun(String str) {
        return getString(SettingParams.Key.NAVI_PRO_SHORTCUT_FUN, str);
    }

    @Nullable
    public String getProSettingGroupRank() {
        return getString(SettingParams.Key.NAVI_PRO_SETTING_GROUP_RANK, null);
    }

    public int getRGSettingBubbleShowTimes() {
        return getInt(SettingParams.Key.RG_SETTING_BUBBLE_SHOW_TIMES, 0);
    }

    public int getRouteChargePrefer() {
        int routeChargePrefer;
        if (isMotor()) {
            routeChargePrefer = a.u0().D();
        } else if (isTruck()) {
            routeChargePrefer = com.baidu.navisdk.module.trucknavi.preferences.a.r0().z();
        } else {
            routeChargePrefer = BNSettingManager.getRouteChargePrefer();
        }
        if (f.c().R.a(routeChargePrefer) == null) {
            return 1;
        }
        return routeChargePrefer;
    }

    @SettingParams.ScreenOrientation
    public int getScreenOrientationMode() {
        return getInt(SettingParams.Key.RG_SCREEN_ORIENTATION, 0);
    }

    public int getServiceAreaTipDisplayCount() {
        if (isMotor()) {
            return a.u0().F();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().A();
        }
        return BNSettingManager.getServiceAreaTipDisplayCount();
    }

    public boolean getShowCarLogoToEnd() {
        if (isMotor()) {
            return a.u0().G();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().B();
        }
        return BNSettingManager.getShowCarLogoToEnd();
    }

    public int getSimpleGuideMode() {
        if (isMotor()) {
            return a.u0().H();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().C();
        }
        return BNSettingManager.getSimpleGuideMode();
    }

    public String getVdrLowNotificationShowDate() {
        if (isMotor()) {
            return a.u0().I();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().F();
        }
        return BNSettingManager.getVdrLowNotificationShowDate();
    }

    public boolean getVectorExpandMapVisible() {
        if (isMotor()) {
            return a.u0().J();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().G();
        }
        return BNSettingManager.getVectorExpandMapVisible();
    }

    public int getVehicle() {
        return b.i().b();
    }

    public int getVoiceMode() {
        if (isMotor()) {
            return a.u0().K();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().H();
        }
        return BNSettingManager.getVoiceMode();
    }

    public int getYawingUseMode() {
        return BNSettingManager.getInt(SettingParams.Key.RP_YAWING_USE_DATA, 0);
    }

    public boolean hasPipPermission() {
        AppOpsManager appOpsManager;
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (Build.VERSION.SDK_INT < 26 || (appOpsManager = (AppOpsManager) a2.getSystemService("appops")) == null || appOpsManager.checkOpNoThrow("android:picture_in_picture", Process.myUid(), a2.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    public boolean isAutoLevelMode() {
        if (isMotor()) {
            return a.u0().L();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().I();
        }
        return BNSettingManager.isAutoLevelMode();
    }

    public boolean isBluetoothGuideShowed() {
        if (isMotor()) {
            return a.u0().M();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().J();
        }
        return BNSettingManager.isBluetoothGuideShowed();
    }

    public boolean isClickedSettingItemInToolBox() {
        if (isMotor()) {
            return a.u0().N();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().K();
        }
        return BNSettingManager.isClickedSettingItemInToolBox();
    }

    public boolean isDayNightGuideHasShowed() {
        if (isMotor()) {
            return a.u0().O();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().L();
        }
        return BNSettingManager.isDayNightGuideHasShowed();
    }

    public boolean isDiySpeakAutoChangeInMusic() {
        if (isMotor()) {
            return a.u0().P();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().M();
        }
        return BNSettingManager.isDiySpeakAutoChangeInMusic();
    }

    public boolean isDiyVoiceSwitchGuideHasShowed() {
        if (isMotor()) {
            return a.u0().Q();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().N();
        }
        return BNSettingManager.isDiyVoiceSwitchGuideHasShowed();
    }

    public boolean isFirstItsOn() {
        if (isMotor()) {
            return a.u0().R();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().O();
        }
        return BNSettingManager.isFirstItsOn();
    }

    public boolean isHdNaviEnable() {
        return getBoolean(SettingParams.Key.HD_NAVI_ENABLE, f.c().I.b);
    }

    public boolean isLocationShareBtnNeedNewTag() {
        if (isMotor()) {
            return a.u0().S();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().P();
        }
        return BNSettingManager.isLocationShareBtnNeedNewTag();
    }

    public boolean isMoreBtnNeedNewTag() {
        if (isMotor()) {
            return a.u0().T();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().Q();
        }
        return BNSettingManager.isMoreBtnNeedNewTag();
    }

    public boolean isNaviRealHistoryITS() {
        if (isMotor()) {
            return a.u0().U();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().R();
        }
        return BNSettingManager.isNaviRealHistoryITS();
    }

    public boolean isNaviSafeTipsShowed() {
        return BNSettingManager.isNaviSafeTipsShowed();
    }

    public boolean isNeedShowHDCloseConfirmPanel() {
        return getBoolean(SettingParams.Key.HD_CLOSE_CONFIRM_PANEL_SHOWED, true);
    }

    public boolean isNormalHdNaviEnable() {
        return getBoolean(SettingParams.Key.NORMAL_HD_NAVI_ENABLE, f.c().U.f7121a);
    }

    public boolean isNormalHdNaviEnableVerifyPanel() {
        return getBoolean(SettingParams.Key.NORMAL_HD_NAVI_VERIFY_PANEL, true);
    }

    public boolean isNoviceMode() {
        if (isMotor() || isTruck()) {
            return false;
        }
        return BNSettingManager.isNoviceMode();
    }

    public boolean isOrientationBtnNeedNewTag() {
        if (isMotor()) {
            return a.u0().X();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().U();
        }
        return BNSettingManager.isOrientationBtnNeedNewTag();
    }

    public boolean isPhoneStateDeclareShow(int i) {
        if (i == 2) {
            return a.u0().Y();
        }
        if (i == 3) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().V();
        }
        return BNSettingManager.isPhoneStateDeclareShow();
    }

    public boolean isPlayBackgroundSpeak() {
        if (isMotor()) {
            return a.u0().Z();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().W();
        }
        return BNSettingManager.isPlayBackgroundSpeak();
    }

    public boolean isPlayVoiceWhenCalling() {
        if (isMotor()) {
            return a.u0().a0();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().X();
        }
        return BNSettingManager.isPlayVoiceWhenCalling();
    }

    public boolean isRGFloatOpenGuideHasShow() {
        if (isMotor()) {
            return a.u0().b0();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().Y();
        }
        return BNSettingManager.isRGFloatOpenGuideHasShow();
    }

    public boolean isRoadCondOnOrOff() {
        if (j.d()) {
            if (isMotor()) {
                return a.u0().c0();
            }
            if (isTruck()) {
                return com.baidu.navisdk.module.trucknavi.preferences.a.r0().Z();
            }
            return BNSettingManager.isRoadCondOnOrOff();
        }
        return BNSettingManager.isRoadCondOnOrOff();
    }

    public boolean isScenicBroadcastOpen() {
        if (isMotor()) {
            return a.u0().d0();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().a0();
        }
        return BNSettingManager.isScenicBroadcastOpen();
    }

    public boolean isShowCarDirCompass() {
        if (!x.v()) {
            return true;
        }
        return getBoolean(SettingParams.Key.RG_IS_SHOW_CAR_DIRE_COMPASS, true);
    }

    public boolean isShowCurrentRoad() {
        if (!x.v()) {
            return true;
        }
        return getBoolean(SettingParams.Key.RG_IS_SHOW_CURRENT_ROAD, true);
    }

    public boolean isShowHdNaviBubble() {
        return getBoolean(SettingParams.Key.OPEN_HD_NAVI_BUBBLE_SHOWED, false);
    }

    public boolean isShowHighSpeedPanel() {
        if (!x.v()) {
            return true;
        }
        return getBoolean(SettingParams.Key.RG_IS_SHOW_HIGH_PANEL, true);
    }

    public boolean isShowLaneLine() {
        if (!x.v()) {
            return true;
        }
        return getBoolean(SettingParams.Key.RG_IS_SHOW_LANE_LINE, true);
    }

    public boolean isShowNaviWeatherTips() {
        if (isMotor()) {
            return a.u0().e0();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().b0();
        }
        return BNSettingManager.isShowNaviWeatherTips();
    }

    public boolean isShowSpeedClock() {
        if (!x.v()) {
            return true;
        }
        return getBoolean(SettingParams.Key.RG_IS_SHOW_SPEED_CLOCK, true);
    }

    public boolean isShowXiaoDu() {
        if (!x.v()) {
            return true;
        }
        return getBoolean(SettingParams.Key.RG_IS_SHOW_XIAODU, true);
    }

    public boolean isVoiceBtnNeedNewTag() {
        if (isMotor()) {
            return a.u0().g0();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().d0();
        }
        return BNSettingManager.isVoiceBtnNeedNewTag();
    }

    public boolean isVoiceBtnTipsPlayed() {
        if (isMotor()) {
            return a.u0().h0();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().e0();
        }
        return BNSettingManager.isVoiceBtnTipsPlayed();
    }

    public boolean isVoiceBtnTipsShowed() {
        if (isMotor()) {
            return a.u0().i0();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().f0();
        }
        return BNSettingManager.isVoiceBtnTipsShowed();
    }

    public boolean isXDAwakened() {
        if (isMotor()) {
            return a.u0().j0();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().g0();
        }
        return BNSettingManager.isXDAwakened();
    }

    public void putIsShowCarDirCompass(boolean z) {
        putBoolean(SettingParams.Key.RG_IS_SHOW_CAR_DIRE_COMPASS, z);
    }

    public void putIsShowCurrentRoad(boolean z) {
        putBoolean(SettingParams.Key.RG_IS_SHOW_CURRENT_ROAD, z);
    }

    public void putIsShowHighSpeedPanel(boolean z) {
        putBoolean(SettingParams.Key.RG_IS_SHOW_HIGH_PANEL, z);
    }

    public void putIsShowLaneLine(boolean z) {
        putBoolean(SettingParams.Key.RG_IS_SHOW_LANE_LINE, z);
    }

    public void putIsShowSpeedClock(boolean z) {
        putBoolean(SettingParams.Key.RG_IS_SHOW_SPEED_CLOCK, z);
    }

    public void putIsShowXiaoDu(boolean z) {
        putBoolean(SettingParams.Key.RG_IS_SHOW_XIAODU, z);
    }

    public void putRGSettingBubbleShowTimes(int i) {
        putInt(SettingParams.Key.RG_SETTING_BUBBLE_SHOW_TIMES, i);
    }

    public void putScreenOrientationMode(@SettingParams.ScreenOrientation int i) {
        putInt(SettingParams.Key.RG_SCREEN_ORIENTATION, i);
    }

    public boolean saveFirstGuide(String str, boolean z) {
        if (isMotor()) {
            return a.u0().d(str, z);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().d(str, z);
        }
        return BNSettingManager.saveFirstGuide(str, z);
    }

    public void saveProCustomShortcutFun(String str) {
        putString(SettingParams.Key.NAVI_PRO_SHORTCUT_FUN, str);
    }

    public void saveProSettingGroupRank(String str) {
        putString(SettingParams.Key.NAVI_PRO_SETTING_GROUP_RANK, str);
    }

    public void setAutoLevelMode(boolean z) {
        if (isMotor()) {
            a.u0().a(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(z);
        } else {
            BNSettingManager.setAutoLevelMode(z);
        }
    }

    public void setBluetoothChannelMode(int i) {
        if (isMotor()) {
            a.u0().b(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().b(i);
        } else {
            BNSettingManager.setBluetoothChannelMode(i);
        }
    }

    public void setBluetoothGuideShowed() {
        if (isMotor()) {
            a.u0().k0();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().h0();
        } else {
            BNSettingManager.setBluetoothGuideShowed();
        }
    }

    public void setDayNightGuideHasShow() {
        if (isMotor()) {
            a.u0().l0();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().i0();
        } else {
            BNSettingManager.setDayNightGuideHasShow();
        }
    }

    public void setDiyCustomModeValue(long j) {
        if (isMotor()) {
            a.u0().a(j);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(j);
        } else {
            BNSettingManager.setDiyCustomModeValue(j);
        }
    }

    public void setDiySpeakAutoChangeAidCancelCount(int i) {
        if (isMotor()) {
            a.u0().d(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().d(i);
        } else {
            BNSettingManager.setDiySpeakAutoChangeAidCancelCount(i);
        }
    }

    public void setDiySpeakAutoChangeInMusic(boolean z) {
        if (isMotor()) {
            a.u0().b(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().b(z);
        } else {
            BNSettingManager.setDiySpeakAutoChangeInMusic(z);
        }
    }

    public void setDiySpeakMusicAidCount(int i) {
        if (isMotor()) {
            a.u0().e(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().e(i);
        } else {
            BNSettingManager.setDiySpeakMusicAidCount(i);
        }
    }

    public void setDiyVoiceMode(int i) {
        if (isMotor()) {
            a.u0().f(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().f(i);
        } else {
            BNSettingManager.setDiyVoiceMode(i);
        }
        k k = c.p().k();
        if (k != null) {
            k.d(i);
        }
    }

    public void setDiyVoiceModeOpen(boolean z) {
        if (isMotor()) {
            a.u0().c(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().c(z);
        } else {
            BNSettingManager.setDiyVoiceModeOpen(z);
        }
    }

    public void setDiyVoiceSwitchGuideShow() {
        if (isMotor()) {
            a.u0().m0();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().j0();
        } else {
            BNSettingManager.setDiyVoiceSwitchGuideShow();
        }
    }

    public void setFirstItsOn(boolean z) {
        if (isMotor()) {
            a.u0().d(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().d(z);
        } else {
            BNSettingManager.setFirstItsOn(z);
        }
    }

    public void setFirstVoiceGuide(boolean z) {
        if (isMotor()) {
            a.u0().e(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().e(z);
        } else {
            BNSettingManager.setFirstVoiceGuide(z);
        }
    }

    public void setFirstVoiceNotifyGuide(boolean z) {
        if (isMotor()) {
            a.u0().f(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().f(z);
        } else {
            BNSettingManager.setFirstVoiceNotifyGuide(z);
        }
    }

    public void setFloatMode(int i) {
        putInt(SettingParams.Key.RG_FLOAT_MODE, i);
    }

    public boolean setForceSwitch(boolean z) {
        if (!BNSettingManager.putBoolean(SettingParams.Key.RP_IS_FORCE_SWITCH_CLOSE, z)) {
            return false;
        }
        int prefRoutPlanMode = BNSettingManager.getPrefRoutPlanMode();
        if (prefRoutPlanMode != 2) {
            prefRoutPlanMode = 3;
        }
        int[] iArr = {3};
        int[] iArr2 = {prefRoutPlanMode};
        int[] forceSwitch = getInstance().getForceSwitch(1);
        if (LogUtil.LOGGABLE) {
            LogUtil.e(TAG, "setForceSwitch: " + Arrays.toString(iArr) + ", netModes:" + Arrays.toString(iArr2) + ", forceSwitch:" + Arrays.toString(forceSwitch));
        }
        JNIGuidanceControl.getInstance().setMultiRoutePlanUserSetting(forceSwitch, iArr2, iArr, getYawingUseMode(1));
        return true;
    }

    public void setHasVoiceRecommendClicked(boolean z) {
        if (isMotor()) {
            a.u0().g(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().h0();
        } else {
            BNSettingManager.setHasVoiceRecommendClicked(z);
        }
    }

    public boolean setHdNaviEnable(boolean z) {
        return putBoolean(SettingParams.Key.HD_NAVI_ENABLE, z);
    }

    public boolean setHdNaviShowedBubble(boolean z) {
        return putBoolean(SettingParams.Key.OPEN_HD_NAVI_BUBBLE_SHOWED, z);
    }

    public void setIsShowMapSwitch(int i) {
        if (isMotor()) {
            a.u0().h(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().h(i);
        } else {
            BNSettingManager.setIsShowMapSwitch(i);
        }
    }

    public void setLastQuietMode(int i) {
        if (isMotor()) {
            a.u0().i(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().i(i);
        } else {
            BNSettingManager.setLastQuietMode(i);
        }
    }

    public void setLocationShareBtnNeedNewTag(boolean z) {
        if (isMotor()) {
            a.u0().j(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().h(z);
        } else {
            BNSettingManager.setLocationShareBtnNeedNewTag(z);
        }
    }

    public void setMapMode(int i) {
        if (isMotor()) {
            a.u0().j(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().j(i);
        } else {
            BNSettingManager.setMapMode(i);
        }
        if (i == 3) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("bShow", true);
            BNMapController.getInstance().setMapFuncInfoMapStrategy(6, bundle);
        }
    }

    public void setMoreBtnNeedNewTag(boolean z) {
        if (isMotor()) {
            a.u0().k(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().i(z);
        } else {
            BNSettingManager.setMoreBtnNeedNewTag(z);
        }
    }

    public void setNaviDayAndNightMode(int i) {
        if (isMotor()) {
            a.u0().k(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().k(i);
        } else {
            BNSettingManager.setNaviDayAndNightMode(i);
        }
    }

    public void setNaviSafeTipsShowed() {
        BNSettingManager.setNaviSafeTipsShowed();
    }

    public boolean setNeedShowHDCloseConfirmPanel(boolean z) {
        return putBoolean(SettingParams.Key.HD_CLOSE_CONFIRM_PANEL_SHOWED, z);
    }

    public boolean setNormalHdNaviEnable(boolean z) {
        return putBoolean(SettingParams.Key.NORMAL_HD_NAVI_ENABLE, z);
    }

    public boolean setNormalHdNaviEnableVerifyPanel(boolean z) {
        return putBoolean(SettingParams.Key.NORMAL_HD_NAVI_VERIFY_PANEL, z);
    }

    public void setOrientationBtnNeedNewTag() {
        if (isMotor()) {
            a.u0().n0();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().k0();
        } else {
            BNSettingManager.setOrientationBtnNeedNewTag();
        }
    }

    public void setPhoneStateDeclareShow(boolean z) {
        if (isMotor()) {
            a.u0().l(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().j(z);
        } else {
            BNSettingManager.setPhoneStateDeclareShow(z);
        }
    }

    public void setPlayBackgroundSpeak(boolean z) {
        if (isMotor()) {
            a.u0().n(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().l(z);
        } else {
            BNSettingManager.setPlayBackgroundSpeak(z);
        }
    }

    public boolean setPlayTTsVoiceMode(int i) {
        if (isMotor()) {
            return a.u0().m(i);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().l(i);
        }
        return BNSettingManager.setPlayTTsVoiceMode(i);
    }

    public void setPlayVoiceWhenCalling(boolean z) {
        if (isMotor()) {
            a.u0().o(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().m(z);
        } else {
            BNSettingManager.setPlayVoiceWhenCalling(z);
        }
    }

    public void setPowerSaveMode(int i) {
        if (isMotor()) {
            a.u0().n(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().m(i);
        } else {
            BNSettingManager.setPowerSaveMode(i);
        }
    }

    public void setPrefFloatSwitch(boolean z) {
        putBoolean(SettingParams.Key.NAVI_PIP_SWITCH, z);
    }

    public void setPrefParkSearch(boolean z) {
        if (isMotor()) {
            a.u0().q(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().o(z);
        } else {
            BNSettingManager.setPrefParkSearch(z);
        }
    }

    public boolean setPrefRealEnlargementNavi(boolean z) {
        if (isMotor()) {
            return a.u0().r(z);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().p(z);
        }
        return BNSettingManager.setPrefRealEnlargementNavi(z);
    }

    public void setPrefRoutePlanMode(int i) {
        if (isMotor()) {
            a.u0().o(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().n(i);
        } else {
            BNSettingManager.setPrefRoutePlanMode(i);
        }
    }

    public void setRGFloatOpenGuideHasShow() {
        if (isMotor()) {
            a.u0().o0();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().l0();
        } else {
            BNSettingManager.setRGFloatOpenGuideHasShow();
        }
    }

    public void setRPNetMode(boolean z) {
        if (isMotor()) {
            a.u0().s(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().q(z);
        } else {
            BNSettingManager.setRPNetMode(z);
        }
    }

    public void setRoadCondOnOff(boolean z) {
        if (j.d()) {
            if (isMotor()) {
                a.u0().t(z);
                return;
            } else if (isTruck()) {
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().r(z);
                return;
            } else {
                BNSettingManager.setRoadCondOnOff(z);
                return;
            }
        }
        BNSettingManager.setRoadCondOnOff(z);
    }

    public void setRouteChargePrefer(int i) {
        if (isMotor()) {
            a.u0().q(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().p(i);
        } else {
            BNSettingManager.setRouteChargePrefer(i);
        }
    }

    public void setScenicBroadcastOpen(boolean z) {
        if (isMotor()) {
            a.u0().u(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().s(z);
        } else {
            BNSettingManager.setScenicBroadcastOpen(z);
        }
    }

    public boolean setServiceAreaTipDisplay() {
        if (isMotor()) {
            return a.u0().p0();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().m0();
        }
        return BNSettingManager.setServiceAreaTipDisplay();
    }

    public void setShowCarLogoToEnd(boolean z) {
        if (isMotor()) {
            a.u0().v(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().t(z);
        } else {
            BNSettingManager.setShowCarLogoToEnd(z);
        }
    }

    public void setShowNaviWeatherTips() {
        if (isMotor()) {
            a.u0().q0();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().n0();
        } else {
            BNSettingManager.setShowNaviWeatherTips();
        }
    }

    public boolean setSimpleGuideMode(int i) {
        if (isMotor()) {
            if (!a.u0().s(i)) {
                return false;
            }
            k k = c.p().k();
            if (k != null) {
                k.h(i);
            }
            return true;
        }
        if (isTruck()) {
            if (!com.baidu.navisdk.module.trucknavi.preferences.a.r0().r(i)) {
                return false;
            }
            k k2 = c.p().k();
            if (k2 != null) {
                k2.h(i);
            }
            return true;
        }
        if (!BNSettingManager.setSimpleGuideMode(i)) {
            return false;
        }
        k k3 = c.p().k();
        if (k3 != null) {
            k3.h(i);
        }
        return true;
    }

    public void setVdrLowNotificationShowDate(String str) {
        if (isMotor()) {
            a.u0().d(str);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().d(str);
        } else {
            BNSettingManager.setVdrLowNotificationShowDate(str);
        }
    }

    public boolean setVectorExpandMapVisible(boolean z) {
        if (isMotor()) {
            return a.u0().x(z);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().v(z);
        }
        return BNSettingManager.setVectorExpandMapVisible(z);
    }

    public void setVoiceBtnNeedNewTag(boolean z) {
        if (isMotor()) {
            a.u0().y(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().w(z);
        } else {
            BNSettingManager.setVoiceBtnNeedNewTag(z);
        }
    }

    public void setVoiceBtnTipsPlayed() {
        if (isMotor()) {
            a.u0().r0();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().o0();
        } else {
            BNSettingManager.setVoiceBtnTipsPlayed();
        }
    }

    public void setVoiceBtnTipsShowed() {
        if (isMotor()) {
            a.u0().s0();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().p0();
        } else {
            BNSettingManager.setVoiceBtnTipsShowed();
        }
    }

    public void setVoiceMode(int i) {
        if (isMotor()) {
            a.u0().t(i);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().u(i);
        } else {
            BNSettingManager.setVoiceMode(i);
        }
        k k = c.p().k();
        if (k != null) {
            k.m(i);
        }
    }

    public void setXDAwakened() {
        if (isMotor()) {
            a.u0().t0();
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().q0();
        } else {
            BNSettingManager.setXDAwakened();
        }
    }

    public boolean setYawingUseMode(int i) {
        return BNSettingManager.putInt(SettingParams.Key.RP_YAWING_USE_DATA, i);
    }

    public void setsNaviRealHistoryITS(boolean z) {
        if (isMotor()) {
            a.u0().z(z);
        } else if (isTruck()) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().x(z);
        } else {
            BNSettingManager.setsNaviRealHistoryITS(z);
        }
    }

    private BNCommSettingManager() {
    }

    public int[] getForceSwitch(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = getInstance().getForceSwitch() ? 1 : 0;
        }
        return iArr;
    }

    @SettingParams.ScreenOrientation
    public int getScreenOrientationMode(int i) {
        return getInt(i, SettingParams.Key.RG_SCREEN_ORIENTATION, 0);
    }

    public int[] getYawingUseMode(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = getInstance().getYawingUseMode();
        }
        return iArr;
    }

    private int getInt(String str, int i) {
        if (isMotor()) {
            return a.u0().a(str, i);
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(str, i);
        }
        return BNSettingManager.getInt(str, i);
    }

    public boolean isPhoneStateDeclareShow() {
        if (isMotor()) {
            return a.u0().Y();
        }
        if (isTruck()) {
            return com.baidu.navisdk.module.trucknavi.preferences.a.r0().V();
        }
        return BNSettingManager.isPhoneStateDeclareShow();
    }

    public void setPhoneStateDeclareShow(int i, boolean z) {
        if (i == 2) {
            a.u0().l(z);
        } else if (i == 3) {
            com.baidu.navisdk.module.trucknavi.preferences.a.r0().j(z);
        } else {
            BNSettingManager.setPhoneStateDeclareShow(z);
        }
    }
}
