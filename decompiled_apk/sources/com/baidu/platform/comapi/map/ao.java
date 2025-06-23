package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

/* loaded from: classes8.dex */
public class ao extends InnerOverlay {
    public ao() {
        super(30);
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public boolean addedToMapView() {
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap == null) {
            return false;
        }
        long AddLayer = appBaseMap.AddLayer(2, 0, "streetpopup");
        this.mLayerID = AddLayer;
        if (AddLayer == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(AddLayer, true);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
    }
}
