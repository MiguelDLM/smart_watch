package com.baidu.navisdk.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.navisdk.adapter.IBNOuterSettingParams;
import com.baidu.navisdk.adapter.struct.BNChargingPreferInfo;
import com.baidu.navisdk.adapter.struct.BNMotorInfo;
import com.baidu.navisdk.adapter.struct.BNTruckInfo;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public interface IBNOuterSettingManager extends IBNOuterSettingParams {

    /* loaded from: classes7.dex */
    public interface IBNCommonSetting {
        boolean clearDIYImage(int i);

        int getRouteSortMode();

        boolean isMultiRouteEnable();

        boolean isNodeClick();

        boolean set3DCarImageToMap(List<Bitmap> list);

        void setCarNum(String str);

        void setCarNum(String str, int i);

        void setChargingPreferInfo(BNChargingPreferInfo bNChargingPreferInfo);

        boolean setDIYImageStatus(boolean z, int i);

        boolean setDIYImageToMap(Bitmap bitmap, int i);

        boolean setDIYImageToMap(List<Bitmap> list, int[] iArr);

        void setEnergyDefaultPlate(String str);

        void setForceSwitch(boolean z);

        void setMotorInfo(BNMotorInfo bNMotorInfo);

        void setMultiRouteEnable(boolean z);

        void setNodeClick(boolean z);

        boolean setRouteSortMode(int i);

        void setTestEnvironment(boolean z, String str);

        void setTruckInfo(BNTruckInfo bNTruckInfo);

        void setTruckLimitSwitch(boolean z);

        void setTruckWeightLimitSwitch(boolean z);

        void setViaPointCount(int i);

        void setYawingUseUserData(int i);

        boolean updateLayer(int i);
    }

    /* loaded from: classes7.dex */
    public interface IBNLightNaviSetting {
        boolean isLightQuite();

        void setCarIconOffsetForLightNavi(int i, int i2);

        void setLightQuiet(boolean z);

        void setRouteMargin(int i, int i2, int i3, int i4);
    }

    /* loaded from: classes7.dex */
    public interface IBNProfessionalNaviSetting {
        void enableBottomBarOpen(boolean z);

        void enableMoreSettings(boolean z);

        void enableRouteSearch(boolean z);

        void enableRouteSort(boolean z);

        int getDayNightMode(int i);

        int getFullViewMode(int i);

        int getGuideViewMode(int i);

        int getVoiceMode(int i);

        boolean isAnalogQuitButtonVisible();

        boolean isAnalogSpeedButtonVisible();

        boolean isAnalogSwitchButtonVisible();

        boolean isAutoQuitWhenArrived();

        boolean isAutoScale(int i);

        boolean isAvoidanceNotificationVisible();

        boolean isAvoidanceReminderVisible();

        boolean isBottomBarOpen();

        boolean isHighwayEnable();

        boolean isLaneLineEnable();

        boolean isMeasurementEnable();

        boolean isQuitNaviEnable();

        boolean isRealRoadConditionOpen(int i);

        boolean isRefreshButtonVisible();

        boolean isRoadConditionButtonVisible();

        boolean isRoadNameEnable();

        boolean isSettingButtonVisible();

        boolean isShowCarLogoToEndRedLine(int i);

        boolean isShowMainAuxiliaryOrBridge();

        boolean isShowRemindDialog();

        boolean isShowRoadEnlargeView(int i);

        boolean isUseOldSetting();

        boolean isVoiceButtonVisible();

        boolean isZoomButtonVisible();

        void setAnalogQuitButtonVisible(boolean z);

        void setAnalogSpeedButtonVisible(boolean z);

        void setAnalogSwitchButtonVisible(boolean z);

        void setAutoScale(boolean z, int i);

        void setAvoidanceNotificationVisible(boolean z);

        void setAvoidanceReminderVisible(boolean z);

        void setBottomMoreBtnEnable(boolean z);

        void setCarIconOffsetForNavi(int i, int i2);

        void setDayNightMode(int i, int i2);

        void setFullViewMarginSize(int i, int i2, int i3, int i4);

        void setFullViewMode(int i, int i2);

        void setGuideViewMode(int i, int i2);

        void setHighwayEnable(boolean z);

        void setIsAutoQuitWhenArrived(boolean z);

        void setLaneLineEnable(boolean z);

        void setMeasurementEnable(boolean z);

        void setQuitNaviEnable(boolean z);

        void setRealRoadCondition(boolean z);

        void setRefreshButtonVisible(boolean z);

        void setRoadConditionButtonVisible(boolean z);

        void setRoadConditionUgcEnable(boolean z, boolean z2);

        void setRoadNameEnable(boolean z);

        void setSettingButtonVisible(boolean z);

        void setSettingPageItemVisible(Map<IBNOuterSettingParams.BNavSettingItem, Boolean> map);

        void setShowCarLogoToEndRedLine(boolean z, int i);

        void setShowMainAuxiliaryOrBridge(boolean z);

        void setShowRemindDialog(boolean z);

        void setShowRoadEnlargeView(boolean z, int i);

        void setStartByFullView(boolean z);

        void setUgcButtonEnable(boolean z);

        void setVoiceButtonVisible(boolean z);

        void setVoiceMode(int i, int i2);

        void setYawSoundEnable(boolean z);

        void setZoomButtonVisible(boolean z);

        void useOldSetting(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface IBNRouteResultSetting {
        boolean isRealRoadConditionOpen();

        void setRealRoadCondition(Context context, boolean z);

        void setRouteMargin(int i, int i2, int i3, int i4);
    }
}
