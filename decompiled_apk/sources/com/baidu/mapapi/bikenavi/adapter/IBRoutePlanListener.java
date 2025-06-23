package com.baidu.mapapi.bikenavi.adapter;

import com.baidu.mapapi.bikenavi.model.BikeRoutePlanError;

/* loaded from: classes7.dex */
public interface IBRoutePlanListener {
    void onRoutePlanFail(BikeRoutePlanError bikeRoutePlanError);

    void onRoutePlanStart();

    void onRoutePlanSuccess();
}
