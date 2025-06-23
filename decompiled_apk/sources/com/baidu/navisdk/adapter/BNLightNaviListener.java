package com.baidu.navisdk.adapter;

import com.baidu.navisdk.adapter.struct.BNaviInfo;

/* loaded from: classes7.dex */
public abstract class BNLightNaviListener implements IBNLightNaviListener {
    @Override // com.baidu.navisdk.adapter.IBNLightNaviListener
    public void onArriveDest() {
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviListener
    public void onMainRouteChanged() {
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviListener
    public void onRemainInfoUpdate(int i, int i2) {
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviListener
    public void onRoadNameUpdate(String str) {
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviListener
    public void onStartYawing() {
    }

    @Override // com.baidu.navisdk.adapter.IBNLightNaviListener
    public void updateGuideInfo(BNaviInfo bNaviInfo) {
    }
}
