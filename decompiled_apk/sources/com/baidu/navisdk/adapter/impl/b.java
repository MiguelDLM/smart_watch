package com.baidu.navisdk.adapter.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.navisdk.adapter.IBNOuterSettingManager;
import com.baidu.navisdk.adapter.IBNOuterSettingParams;
import com.baidu.navisdk.adapter.impl.base.BNaviAuthManager;
import com.baidu.navisdk.adapter.struct.BNChargingPreferInfo;
import com.baidu.navisdk.adapter.struct.BNMotorInfo;
import com.baidu.navisdk.adapter.struct.BNTruckInfo;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.control.l;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.e0;
import com.baidu.navisdk.util.common.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class b implements IBNOuterSettingManager {

    /* renamed from: a, reason: collision with root package name */
    private static C0158b f6488a;
    private static d b;
    private static e c;
    private static c d;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6489a;

        static {
            int[] iArr = new int[IBNOuterSettingParams.BNavSettingItem.values().length];
            f6489a = iArr;
            try {
                iArr[IBNOuterSettingParams.BNavSettingItem.FUNC_NAVI_ANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6489a[IBNOuterSettingParams.BNavSettingItem.FUNC_DAY_NIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6489a[IBNOuterSettingParams.BNavSettingItem.FUNC_NAVI_SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6489a[IBNOuterSettingParams.BNavSettingItem.FUNC_VOICE_SELECTOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6489a[IBNOuterSettingParams.BNavSettingItem.FUNC_DIY_SPEAK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6489a[IBNOuterSettingParams.BNavSettingItem.FUNC_ROUTE_PREFER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6489a[IBNOuterSettingParams.BNavSettingItem.FUNC_GROUP_SHORTCUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6489a[IBNOuterSettingParams.BNavSettingItem.FUNC_ROAD_CONDITION_SWITCH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6489a[IBNOuterSettingParams.BNavSettingItem.FUNC_BLUETOOTH_SOUND.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6489a[IBNOuterSettingParams.BNavSettingItem.FUNC_HD_NAVI_SETTING_ITEM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* renamed from: com.baidu.navisdk.adapter.impl.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0158b implements IBNOuterSettingManager.IBNCommonSetting {
        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public boolean clearDIYImage(int i) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "clearDIYImage --> init is failed.");
                return false;
            }
            return BNMapController.getInstance().getSDKMapController().a(i);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public int getRouteSortMode() {
            return com.baidu.navisdk.h.b();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public boolean isMultiRouteEnable() {
            return BNSettingManager.isMultiRouteEnable();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public boolean isNodeClick() {
            return BNSettingManager.isNodeClick();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public boolean set3DCarImageToMap(List<Bitmap> list) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "set3DCarImageToMap --> init is failed.");
                return false;
            }
            return BNMapController.getInstance().set3DCarToMap(list);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setCarNum(String str) {
            BNSettingManager.setCarPlateToLocal(str);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setChargingPreferInfo(BNChargingPreferInfo bNChargingPreferInfo) {
            com.baidu.navisdk.module.routepreference.h a2 = com.baidu.navisdk.module.routepreference.h.a("", BNSettingManager.getLocalChargingPrefer());
            a2.b = bNChargingPreferInfo.getChargeStart();
            a2.c = bNChargingPreferInfo.getChargeEnd();
            a2.f7484a = bNChargingPreferInfo.getMileage();
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (bNChargingPreferInfo.getPileList() != null) {
                for (int i = 0; i < bNChargingPreferInfo.getPileList().size(); i++) {
                    arrayList.add(Integer.valueOf(bNChargingPreferInfo.getPileList().get(i).getValue()));
                }
                a2.d = arrayList;
            }
            BNSettingManager.setLocalChargingPrefer(com.baidu.navisdk.module.routepreference.h.a(a2));
            BNSettingManager.setNewEnergyRemainMileage(bNChargingPreferInfo.getRemainMileage());
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public boolean setDIYImageStatus(boolean z, int i) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "setDIYImageStatus --> init is failed.");
                return false;
            }
            return BNMapController.getInstance().getSDKMapController().a(z, i);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public boolean setDIYImageToMap(Bitmap bitmap, int i) {
            if (com.baidu.navisdk.module.init.a.a() && BNMapController.getInstance().getSDKMapController() != null) {
                return BNMapController.getInstance().getSDKMapController().a(bitmap, i);
            }
            LogUtil.out("BNOuterSettingManager", "setDIYImageToMap --> init is failed.");
            return false;
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setEnergyDefaultPlate(String str) {
            BNSettingManager.setEnergyDefaultPlate(str);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setForceSwitch(boolean z) {
            BNCommSettingManager.getInstance().setForceSwitch(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setMotorInfo(BNMotorInfo bNMotorInfo) {
            com.baidu.navisdk.module.motorbike.preferences.a.u0().a(bNMotorInfo.getPlate(), bNMotorInfo.getPlateType(), bNMotorInfo.getMotorType(), bNMotorInfo.getDisplacement());
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setMultiRouteEnable(boolean z) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "setMultiRouteEnable --> init is failed.");
                return;
            }
            BNSettingManager.setMultiRouteEnable(z);
            BNRoutePlaner.getInstance().n(JNIGuidanceControl.getInstance().getSelectRouteIdx());
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setNodeClick(boolean z) {
            BNSettingManager.setNodeClick(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public boolean setRouteSortMode(int i) {
            LogUtil.out("BNOuterSettingManager", "setRouteSortMode() mode=" + i);
            if (com.baidu.navisdk.ui.routeguide.c.g().f()) {
                LogUtil.out("BNOuterSettingManager", "setRouteSortMode() return for car freedom.");
                return false;
            }
            s.T().a(false, false, false);
            if ((com.baidu.navisdk.module.routepreference.d.j().f() & 32) != 0) {
                i |= 32;
            }
            com.baidu.navisdk.h.c(i);
            com.baidu.navisdk.module.routepreference.d.j().f(i);
            x.b().u1();
            l.l().i();
            return true;
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setTestEnvironment(boolean z, String str) {
            BNSettingManager.setTestEnvironment(z, str);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setTruckInfo(BNTruckInfo bNTruckInfo) {
            String vehicleInfoJsonStr = bNTruckInfo.getVehicleInfoJsonStr();
            if (LogUtil.LOGGABLE) {
                LogUtil.out("BNOuterSettingManager", "setPlateToLocal-> " + vehicleInfoJsonStr);
            }
            ((com.baidu.navisdk.module.trucknavi.logic.plate.c) com.baidu.navisdk.module.trucknavi.logic.plate.c.g()).a(vehicleInfoJsonStr);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setTruckLimitSwitch(boolean z) {
            com.baidu.navisdk.module.trucknavi.logic.plate.c.g().b(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setTruckWeightLimitSwitch(boolean z) {
            com.baidu.navisdk.module.trucknavi.logic.plate.c.g().a(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setViaPointCount(int i) {
            if (i >= 4 && i <= 18) {
                BNSettingManager.setViaPointCount(i);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setYawingUseUserData(int i) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "setYawingUseUserData --> init is failed.");
                return;
            }
            com.baidu.navisdk.util.common.g.OPEN_SDK.f("BNOuterSettingManager", "setYawingUseUserData = " + i);
            int[] iArr = {i};
            BNCommSettingManager.getInstance().setYawingUseMode(i);
            JNIGuidanceControl.getInstance().setMultiRoutePlanUserSetting(BNCommSettingManager.getInstance().getForceSwitch(1), new int[]{1}, new int[]{3}, iArr);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public boolean updateLayer(int i) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "updateLayer --> init is failed.");
                return false;
            }
            return BNMapController.getInstance().updateLayer(i);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public void setCarNum(String str, int i) {
            BNSettingManager.setCarPlateToLocal(str);
            BNSettingManager.setCarPowerTypeToLocal(i);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNCommonSetting
        public boolean setDIYImageToMap(List<Bitmap> list, int[] iArr) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "setDIYImageToMap --> init is failed.");
                return false;
            }
            return BNMapController.getInstance().setDIYImageToMap(list, iArr);
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements IBNOuterSettingManager.IBNLightNaviSetting {
        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNLightNaviSetting
        public boolean isLightQuite() {
            return BNSettingManager.isLightQuietEnabled();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNLightNaviSetting
        public void setCarIconOffsetForLightNavi(int i, int i2) {
            com.baidu.navisdk.ui.routeguide.c.g().a(i, i2);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNLightNaviSetting
        public void setLightQuiet(boolean z) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "setLightQuiet --> init is failed.");
                return;
            }
            BNSettingManager.setLightQuiet(z);
            if (z) {
                BNRouteGuider.getInstance().setVoiceMode(2);
            } else {
                BNRouteGuider.getInstance().setVoiceMode(3);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNLightNaviSetting
        public void setRouteMargin(int i, int i2, int i3, int i4) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "setRouteMargin --> init is failed.");
                return;
            }
            BNSettingManager.setLightNaviRouteMargin(i, i2, i3, i4);
            int screenHeight = BNMapController.getInstance().getScreenHeight() - i4;
            BNMapController.getInstance().setMapShowScreenRect(i, i2, BNMapController.getInstance().getScreenWidth() - i3, screenHeight);
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements IBNOuterSettingManager.IBNProfessionalNaviSetting {
        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void enableBottomBarOpen(boolean z) {
            BNSettingManager.enableBottomBarOpen(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void enableMoreSettings(boolean z) {
            com.baidu.navisdk.function.b.FUNC_SETTING_MORE.b(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void enableRouteSearch(boolean z) {
            com.baidu.navisdk.function.b.FUNC_SETTING_ROUTE_SEARCH.b(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void enableRouteSort(boolean z) {
            com.baidu.navisdk.function.b.FUNC_SETTING_ROUTE_SORT.b(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public int getDayNightMode(int i) {
            if (i == 2) {
                return com.baidu.navisdk.module.motorbike.preferences.a.u0().q();
            }
            if (i == 3) {
                return com.baidu.navisdk.module.trucknavi.preferences.a.r0().p();
            }
            return BNSettingManager.getNaviDayAndNightMode();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public int getFullViewMode(int i) {
            if (i == 2) {
                return com.baidu.navisdk.module.motorbike.preferences.a.u0().m();
            }
            if (i == 3) {
                return com.baidu.navisdk.module.trucknavi.preferences.a.r0().m();
            }
            return BNSettingManager.getIsShowMapSwitch();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public int getGuideViewMode(int i) {
            if (i == 2) {
                return com.baidu.navisdk.module.motorbike.preferences.a.u0().o();
            }
            if (i == 3) {
                return com.baidu.navisdk.module.trucknavi.preferences.a.r0().o();
            }
            return BNSettingManager.getMapMode();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public int getVoiceMode(int i) {
            if (i == 2) {
                return com.baidu.navisdk.module.motorbike.preferences.a.u0().K();
            }
            if (i == 3) {
                return com.baidu.navisdk.module.trucknavi.preferences.a.r0().H();
            }
            return BNSettingManager.getVoiceMode();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isAnalogQuitButtonVisible() {
            return BNSettingManager.isAnalogQuitButtonVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isAnalogSpeedButtonVisible() {
            return BNSettingManager.isAnalogSpeedButtonVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isAnalogSwitchButtonVisible() {
            return BNSettingManager.isAnalogSwitchButtonVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isAutoQuitWhenArrived() {
            return BNSettingManager.isAutoQuitWhenArrived();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isAutoScale(int i) {
            if (i == 2) {
                return com.baidu.navisdk.module.motorbike.preferences.a.u0().L();
            }
            if (i == 3) {
                return com.baidu.navisdk.module.trucknavi.preferences.a.r0().I();
            }
            return BNSettingManager.isAutoLevelMode();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isAvoidanceNotificationVisible() {
            return BNSettingManager.isAvoidanceNotificationVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isAvoidanceReminderVisible() {
            return BNSettingManager.isAvoidanceReminderVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isBottomBarOpen() {
            return BNSettingManager.isBottomBarOpen();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isHighwayEnable() {
            return BNCommSettingManager.getInstance().isShowHighSpeedPanel();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isLaneLineEnable() {
            return BNCommSettingManager.getInstance().isShowLaneLine();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isMeasurementEnable() {
            return BNSettingManager.isMeasurementEnable();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isQuitNaviEnable() {
            return BNSettingManager.isQuitNaviEnable();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isRealRoadConditionOpen(int i) {
            if (i == 2) {
                return com.baidu.navisdk.module.motorbike.preferences.a.u0().c0();
            }
            if (i == 3) {
                return com.baidu.navisdk.module.trucknavi.preferences.a.r0().Z();
            }
            return BNSettingManager.isRoadCondOnOrOff();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isRefreshButtonVisible() {
            return BNSettingManager.isRefreshButtonVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isRoadConditionButtonVisible() {
            return BNSettingManager.isRoadConditionButtonVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isRoadNameEnable() {
            return BNSettingManager.isRoadNameEnable();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isSettingButtonVisible() {
            return BNSettingManager.isSettingButtonVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isShowCarLogoToEndRedLine(int i) {
            if (i == 2) {
                return com.baidu.navisdk.module.motorbike.preferences.a.u0().G();
            }
            if (i == 3) {
                return com.baidu.navisdk.module.trucknavi.preferences.a.r0().B();
            }
            return BNSettingManager.getShowCarLogoToEnd();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isShowMainAuxiliaryOrBridge() {
            return BNSettingManager.isMainAuxiliaryOrBridgeEnable();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isShowRemindDialog() {
            boolean isShowRemindDialog = BNSettingManager.isShowRemindDialog();
            LogUtil.out("BNOuterSettingManager", "isShowRemindDialog = " + isShowRemindDialog);
            return isShowRemindDialog;
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isShowRoadEnlargeView(int i) {
            if (i == 2) {
                return com.baidu.navisdk.module.motorbike.preferences.a.u0().z();
            }
            if (i == 3) {
                return com.baidu.navisdk.module.trucknavi.preferences.a.r0().v();
            }
            return BNSettingManager.getPrefRealEnlargementNavi();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isUseOldSetting() {
            return BNSettingManager.isUseOldSetting();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isVoiceButtonVisible() {
            return BNSettingManager.isVoiceButtonVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public boolean isZoomButtonVisible() {
            return BNSettingManager.isZoomButtonVisible();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setAnalogQuitButtonVisible(boolean z) {
            BNSettingManager.setAnalogQuitButtonVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setAnalogSpeedButtonVisible(boolean z) {
            BNSettingManager.setAnalogSpeedButtonVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setAnalogSwitchButtonVisible(boolean z) {
            BNSettingManager.setAnalogSwitchButtonVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setAutoScale(boolean z, int i) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "setAutoScale --> init is failed.");
                return;
            }
            if (i == 2) {
                com.baidu.navisdk.module.motorbike.preferences.a.u0().a(z);
            } else if (i == 3) {
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().a(z);
            } else {
                BNSettingManager.setAutoLevelMode(z);
            }
            BNMapController.getInstance().getMapController().m(z);
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.f(z);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setAvoidanceNotificationVisible(boolean z) {
            BNSettingManager.setAvoidanceNotificationVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setAvoidanceReminderVisible(boolean z) {
            BNSettingManager.setAvoidanceReminderVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setBottomMoreBtnEnable(boolean z) {
            com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR.b(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setCarIconOffsetForNavi(int i, int i2) {
            BNSettingManager.userSetCarIconOffsetForNavi(i, i2);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setDayNightMode(int i, int i2) {
            if (i2 == 2) {
                com.baidu.navisdk.module.motorbike.preferences.a.u0().k(i);
            } else if (i2 == 3) {
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().k(i);
            } else {
                BNSettingManager.setNaviDayAndNightMode(i);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setFullViewMarginSize(int i, int i2, int i3, int i4) {
            BNSettingManager.setProfessionalNaviRouteMargin(i, i2, i3, i4);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setFullViewMode(int i, int i2) {
            if (i2 == 2) {
                com.baidu.navisdk.module.motorbike.preferences.a.u0().h(i);
            } else if (i2 == 3) {
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().h(i);
            } else {
                BNSettingManager.setIsShowMapSwitch(i);
            }
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.i(i);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setGuideViewMode(int i, int i2) {
            if (i2 == 2) {
                if (getGuideViewMode(i2) != 1 && getGuideViewMode(i2) != 3) {
                    if (getGuideViewMode(i2) == 2) {
                        RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.Car3D);
                    }
                } else {
                    RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.North2D);
                }
                com.baidu.navisdk.module.motorbike.preferences.a.u0().j(i);
            } else if (i2 == 3) {
                if (getGuideViewMode(i2) != 1 && getGuideViewMode(i2) != 3) {
                    if (getGuideViewMode(i2) == 2) {
                        RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.Car3D);
                    }
                } else {
                    RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.North2D);
                }
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().j(i);
            } else {
                if (getGuideViewMode(i2) != 1 && getGuideViewMode(i2) != 3) {
                    if (getGuideViewMode(i2) == 2) {
                        RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.Car3D);
                    }
                } else {
                    RouteGuideFSM.getInstance().cacheBackMapState(RGFSMTable.FsmState.North2D);
                }
                BNSettingManager.setMapMode(i);
            }
            com.baidu.navisdk.ui.routeguide.b.V().r().l();
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.c(i);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setHighwayEnable(boolean z) {
            BNCommSettingManager.getInstance().putIsShowHighSpeedPanel(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setIsAutoQuitWhenArrived(boolean z) {
            BNSettingManager.setIsAutoQuitWhenArrived(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setLaneLineEnable(boolean z) {
            BNCommSettingManager.getInstance().putIsShowLaneLine(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setMeasurementEnable(boolean z) {
            BNSettingManager.setMeasurementEnable(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setQuitNaviEnable(boolean z) {
            BNSettingManager.setQuitNaviEnable(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setRealRoadCondition(boolean z) {
            com.baidu.navisdk.ui.routeguide.b.V().l().a(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setRefreshButtonVisible(boolean z) {
            BNSettingManager.setRefreshButtonVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setRoadConditionButtonVisible(boolean z) {
            BNSettingManager.setRoadConditionButtonVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setRoadConditionUgcEnable(boolean z, boolean z2) {
            BNSettingManager.setRoadConditionShowAvoid(z);
            BNSettingManager.setRoadConditionAllowClick(z2);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setRoadNameEnable(boolean z) {
            BNSettingManager.setRoadNameEnable(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setSettingButtonVisible(boolean z) {
            BNSettingManager.setSettingButtonVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setSettingPageItemVisible(Map<IBNOuterSettingParams.BNavSettingItem, Boolean> map) {
            if (map == null) {
                return;
            }
            for (IBNOuterSettingParams.BNavSettingItem bNavSettingItem : map.keySet()) {
                b.b(bNavSettingItem, Boolean.TRUE.equals(map.get(bNavSettingItem)));
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setShowCarLogoToEndRedLine(boolean z, int i) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "setShowCarLogoToEndRedLine --> init is failed.");
                return;
            }
            if (i == 2) {
                com.baidu.navisdk.module.motorbike.preferences.a.u0().v(z);
            } else if (i == 3) {
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().t(z);
            } else {
                BNSettingManager.setShowCarLogoToEnd(z);
            }
            BNMapController.getInstance().setRedLineRender(z);
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.h(z);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setShowMainAuxiliaryOrBridge(boolean z) {
            BNSettingManager.setMainAuxiliaryOrBridgeEnable(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setShowRemindDialog(boolean z) {
            LogUtil.out("BNOuterSettingManager", "setShowRemindDialog = " + z);
            BNSettingManager.setShowRemindDialog(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setShowRoadEnlargeView(boolean z, int i) {
            if (i == 2) {
                com.baidu.navisdk.module.motorbike.preferences.a.u0().r(z);
            } else if (i == 3) {
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().p(z);
            } else {
                BNSettingManager.setPrefRealEnlargementNavi(z);
            }
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.d(z);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setStartByFullView(boolean z) {
            BNSettingManager.enableStartByFullView(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setUgcButtonEnable(boolean z) {
            BNSettingManager.setUgcButtonEnable(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setVoiceButtonVisible(boolean z) {
            BNSettingManager.setVoiceButtonVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setVoiceMode(int i, int i2) {
            if (i2 == 2) {
                com.baidu.navisdk.module.motorbike.preferences.a.u0().t(i);
            } else if (i2 == 3) {
                com.baidu.navisdk.module.trucknavi.preferences.a.r0().u(i);
            } else {
                BNSettingManager.setVoiceMode(i);
            }
            BNRouteGuider.getInstance().setVoiceMode(i);
            if (i == 0) {
                BNSettingManager.setDiyVoiceMode(1);
            } else if (i == 1) {
                BNSettingManager.setDiyVoiceMode(7);
            }
            k k = com.baidu.navisdk.framework.interfaces.c.p().k();
            if (k != null) {
                k.d(i);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setYawSoundEnable(boolean z) {
            TTSPlayerControl.setYawSoundEnable(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void setZoomButtonVisible(boolean z) {
            BNSettingManager.setZoomButtonVisible(z);
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNProfessionalNaviSetting
        public void useOldSetting(boolean z) {
            BNSettingManager.useOldSetting(z);
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements IBNOuterSettingManager.IBNRouteResultSetting {

        /* renamed from: a, reason: collision with root package name */
        private Rect f6490a;

        public Rect a() {
            return this.f6490a;
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNRouteResultSetting
        public boolean isRealRoadConditionOpen() {
            return BNSettingManager.isIpoRoadCondOnOrOff();
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNRouteResultSetting
        public void setRealRoadCondition(Context context, boolean z) {
            if (!com.baidu.navisdk.module.init.a.a()) {
                LogUtil.out("BNOuterSettingManager", "setRealRoadCondition --> init is failed.");
                return;
            }
            if (context != null) {
                com.baidu.navisdk.util.statistic.userop.b.r().b("4.2");
                if (z) {
                    if (e0.a(context).a(SettingParams.Key.NAVI_REAL_HISTORY_ITS, true)) {
                        if (BNSettingManager.isFirstItsOn()) {
                            BNSettingManager.setFirstItsOn(false);
                        }
                        if (y.d(context)) {
                            BNMapController.getInstance().switchITSMode(true);
                            BNMapController.getInstance().showTrafficMap(true);
                            BNSettingManager.setIpoRoadCondOnOff(true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                BNMapController.getInstance().showTrafficMap(false);
                BNSettingManager.setIpoRoadCondOnOff(false);
            }
        }

        @Override // com.baidu.navisdk.adapter.IBNOuterSettingManager.IBNRouteResultSetting
        public void setRouteMargin(int i, int i2, int i3, int i4) {
            if (this.f6490a == null) {
                this.f6490a = new Rect();
            }
            Rect rect = this.f6490a;
            rect.left = i;
            rect.top = i2;
            rect.right = i3;
            rect.bottom = i4;
        }
    }

    public static c b() {
        if (d == null) {
            d = new c();
        }
        return d;
    }

    public static d c() {
        if (b == null) {
            b = new d();
        }
        return b;
    }

    public static e d() {
        if (c == null) {
            c = new e();
        }
        return c;
    }

    public static C0158b a() {
        if (f6488a == null) {
            f6488a = new C0158b();
        }
        return f6488a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(IBNOuterSettingParams.BNavSettingItem bNavSettingItem, boolean z) {
        switch (a.f6489a[bNavSettingItem.ordinal()]) {
            case 1:
                com.baidu.navisdk.function.b.FUNC_NAVI_ANGLE.a(z);
                return;
            case 2:
                com.baidu.navisdk.function.b.FUNC_DAY_NIGHT.a(z);
                return;
            case 3:
                com.baidu.navisdk.function.b.FUNC_NAVI_SCALE.a(z);
                return;
            case 4:
                com.baidu.navisdk.function.b.FUNC_VOICE_SELECTOR.a(z);
                return;
            case 5:
                com.baidu.navisdk.function.b.FUNC_DIY_SPEAK.a(z);
                return;
            case 6:
                com.baidu.navisdk.function.b.FUNC_ROUTE_PREFER.a(z);
                return;
            case 7:
                com.baidu.navisdk.function.b.FUNC_GROUP_SHORTCUT.a(z);
                return;
            case 8:
                com.baidu.navisdk.function.b.FUNC_ROAD_CONDITION_SWITCH.a(z);
                return;
            case 9:
                com.baidu.navisdk.function.b.FUNC_BLUETOOTH_SOUND.a(z);
                return;
            case 10:
                if (BNaviAuthManager.getInstance().hasHdNaviPermission()) {
                    com.baidu.navisdk.function.b.FUNC_HD_NAVI_SETTING_ITEM.a(z);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
