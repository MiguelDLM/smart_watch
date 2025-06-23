package com.baidu.navisdk.adapter;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import com.baidu.navisdk.adapter.struct.BNHighwayInfo;
import com.baidu.navisdk.adapter.struct.BNRoadCondition;
import com.baidu.navisdk.adapter.struct.BNavLineItem;
import com.baidu.navisdk.adapter.struct.BNaviInfo;
import com.baidu.navisdk.adapter.struct.BNaviLocation;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class IBNaviListener {

    /* loaded from: classes7.dex */
    public enum Action {
        SHOW,
        UPDATE,
        HIDE
    }

    /* loaded from: classes7.dex */
    public enum DayNightMode {
        DAY,
        NIGHT
    }

    /* loaded from: classes7.dex */
    public enum MapStateMode {
        BROWSE,
        NAVING
    }

    public void onArriveDestination() {
    }

    public void onArrivedWayPoint(int i) {
    }

    public void onAutoScaleChanged(boolean z) {
    }

    public void onCarLogoToEndRedLineChanged(boolean z) {
    }

    public void onDayNightChanged(DayNightMode dayNightMode) {
    }

    public void onDiyVoiceModeChanged(int i) {
    }

    public void onEnlargeMapUpdate(Action action, View view, String str, int i, String str2, Bitmap bitmap) {
    }

    public void onFastExitWayInfoUpdate(Action action, String str, int i, String str2) {
    }

    public void onFullViewModeChanged(int i) {
    }

    public void onGuideInfoUpdate(BNaviInfo bNaviInfo) {
    }

    public void onGuideModeChanged(int i) {
    }

    public void onGuideViewModeChanged(int i) {
    }

    public void onHeavyTraffic() {
    }

    public void onHighWayInfoUpdate(Action action, BNHighwayInfo bNHighwayInfo) {
    }

    public void onLaneInfoUpdate(Action action, List<BNavLineItem> list) {
    }

    public void onLocationChange(BNaviLocation bNaviLocation) {
    }

    public void onMainRouteChange(int i) {
    }

    public void onMainSideBridgeUpdate(int i) {
    }

    public void onMapStateChange(MapStateMode mapStateMode) {
    }

    public void onNaviGuideEnd() {
    }

    public void onNotificationShow(String str) {
    }

    public void onOverSpeed(int i, int i2) {
    }

    public void onPreferChanged(int i) {
    }

    public void onRemainInfoUpdate(int i, int i2) {
    }

    public void onRoadConditionInfoUpdate(double d, List<BNRoadCondition> list) {
    }

    public void onRoadEnlargeViewChanged(boolean z) {
    }

    public void onRoadNameUpdate(String str) {
    }

    public void onRouteForceSwitch(String str, long j, int i, BNaviLocation bNaviLocation) {
    }

    public void onSpeedUpdate(int i, int i2) {
    }

    public void onStartYawing(String str) {
    }

    public void onViaListRemainInfoUpdate(Message message) {
    }

    public void onVoiceModeChanged(int i) {
    }

    public void onYawingArriveViaPoint(int i) {
    }

    public void onYawingSuccess() {
    }
}
