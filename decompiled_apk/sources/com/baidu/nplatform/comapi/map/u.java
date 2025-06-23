package com.baidu.nplatform.comapi.map;

import com.baidu.nplatform.comapi.MapItem;

/* loaded from: classes8.dex */
public interface u {
    void onClickDestNodeBubble(MapItem mapItem);

    void onClickIndoorParkspace(MapItem mapItem);

    void onClickedBackground(int i, int i2);

    void onClickedBaseLayer();

    void onClickedBasePOILayer(MapItem mapItem);

    void onClickedCarLogo(MapItem mapItem);

    void onClickedCompassLayer();

    void onClickedEndLayer(MapItem mapItem, int i, int i2);

    void onClickedFavPoiLayer(MapItem mapItem);

    void onClickedMgData(MapItem mapItem);

    void onClickedPOIBkgLayer(MapItem mapItem);

    void onClickedPOILayer(MapItem mapItem);

    void onClickedPopupLayer();

    void onClickedRcPredictionElement(MapItem mapItem);

    void onClickedRoute(MapItem mapItem);

    void onClickedRouteAroundElement(MapItem mapItem);

    void onClickedRoutePanItem(MapItem mapItem);

    void onClickedRouteSpecLayer(MapItem mapItem);

    void onClickedRouteUgcItem(MapItem mapItem);

    void onClickedStartLayer(MapItem mapItem, int i, int i2);

    void onClickedThroughNodeLayer(MapItem mapItem, int i, int i2);

    void onClickedTrafficLightItem(MapItem mapItem);

    void onClickedUgcItem(MapItem mapItem);

    void onDoubleFingerZoom();

    void onMapAnimationFinish();

    void onMapNetworkingChanged(boolean z);
}
