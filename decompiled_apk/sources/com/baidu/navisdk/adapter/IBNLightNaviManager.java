package com.baidu.navisdk.adapter;

import android.app.Activity;
import android.view.View;
import com.baidu.navisdk.adapter.struct.BNRoutePlanItem;
import java.util.List;

/* loaded from: classes7.dex */
public interface IBNLightNaviManager {

    /* loaded from: classes7.dex */
    public interface IRouteClickedListener {
        void routeClicked(int i);
    }

    void backLocation();

    void fullView();

    List<BNRoutePlanItem> getRemainRouteInfo();

    int getSelectRouteIndex();

    @Deprecated
    boolean isIpoRoadCondOnOrOff();

    boolean isRoadConditionOpen();

    View onCreate(Activity activity);

    void onDestroy(boolean z);

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void selectRoute(int i);

    void setLightNaviListener(BNLightNaviListener bNLightNaviListener);

    void setRoadCondition(boolean z);

    void setRouteClickedListener(IRouteClickedListener iRouteClickedListener);

    void setViewSegmentStatus(boolean z);

    void showRoute(boolean z);

    boolean startLightNavi();

    boolean startProfessionalNavi();

    void stopLightNavi(boolean z);

    @Deprecated
    void switchIpoRoadCondition();

    void zoomInMap();

    void zoomOutMap();
}
