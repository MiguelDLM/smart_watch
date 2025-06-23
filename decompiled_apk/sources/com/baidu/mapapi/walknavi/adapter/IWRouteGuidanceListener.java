package com.baidu.mapapi.walknavi.adapter;

import android.graphics.drawable.Drawable;
import android.os.Message;
import com.baidu.mapapi.walknavi.model.IWRouteIconInfo;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;

/* loaded from: classes7.dex */
public interface IWRouteGuidanceListener {
    void onArriveDest();

    void onFinalEnd(Message message);

    void onGpsStatusChange(CharSequence charSequence, Drawable drawable);

    void onIndoorEnd(Message message);

    void onReRouteComplete();

    void onRemainDistanceUpdate(CharSequence charSequence);

    void onRemainTimeUpdate(CharSequence charSequence);

    void onRoadGuideTextUpdate(CharSequence charSequence, CharSequence charSequence2);

    void onRouteFarAway(CharSequence charSequence, Drawable drawable);

    void onRouteGuideIconInfoUpdate(IWRouteIconInfo iWRouteIconInfo);

    void onRouteGuideIconUpdate(Drawable drawable);

    void onRouteGuideKind(RouteGuideKind routeGuideKind);

    void onRoutePlanYawing(CharSequence charSequence, Drawable drawable);

    void onVibrate();
}
