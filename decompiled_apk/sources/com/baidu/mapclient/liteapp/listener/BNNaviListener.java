package com.baidu.mapclient.liteapp.listener;

import com.baidu.navisdk.adapter.IBNaviListener;
import com.baidu.navisdk.adapter.struct.BNHighwayInfo;
import com.baidu.navisdk.adapter.struct.BNRoadCondition;
import com.baidu.navisdk.adapter.struct.BNaviLocation;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class BNNaviListener extends IBNaviListener {
    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onArriveDestination() {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onArrivedWayPoint(int i) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onDayNightChanged(IBNaviListener.DayNightMode dayNightMode) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onFastExitWayInfoUpdate(IBNaviListener.Action action, String str, int i, String str2) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onHeavyTraffic() {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onHighWayInfoUpdate(IBNaviListener.Action action, BNHighwayInfo bNHighwayInfo) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onLocationChange(BNaviLocation bNaviLocation) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onMainSideBridgeUpdate(int i) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onMapStateChange(IBNaviListener.MapStateMode mapStateMode) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onNaviGuideEnd() {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onNotificationShow(String str) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onOverSpeed(int i, int i2) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onPreferChanged(int i) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onRemainInfoUpdate(int i, int i2) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onRoadConditionInfoUpdate(double d, List<BNRoadCondition> list) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onRoadNameUpdate(String str) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onSpeedUpdate(int i, int i2) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onStartYawing(String str) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onYawingArriveViaPoint(int i) {
    }

    @Override // com.baidu.navisdk.adapter.IBNaviListener
    public void onYawingSuccess() {
    }
}
