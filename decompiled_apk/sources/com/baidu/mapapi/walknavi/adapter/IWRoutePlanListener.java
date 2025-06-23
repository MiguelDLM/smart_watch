package com.baidu.mapapi.walknavi.adapter;

import com.baidu.mapapi.walknavi.model.WalkRoutePlanError;

/* loaded from: classes7.dex */
public interface IWRoutePlanListener {
    void onRoutePlanFail(WalkRoutePlanError walkRoutePlanError);

    void onRoutePlanStart();

    void onRoutePlanSuccess();
}
