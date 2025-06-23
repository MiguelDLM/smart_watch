package com.baidu.navisdk.adapter;

import com.baidu.navisdk.adapter.struct.BNaviInfo;

/* loaded from: classes7.dex */
public interface IBNLightNaviListener {
    void onArriveDest();

    void onMainRouteChanged();

    void onRemainInfoUpdate(int i, int i2);

    void onRoadNameUpdate(String str);

    void onStartYawing();

    void updateGuideInfo(BNaviInfo bNaviInfo);
}
