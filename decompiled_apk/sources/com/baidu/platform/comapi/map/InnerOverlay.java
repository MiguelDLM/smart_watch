package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;

/* loaded from: classes8.dex */
public abstract class InnerOverlay extends Overlay {

    /* renamed from: a, reason: collision with root package name */
    private boolean f9608a;
    protected String b;
    protected Bundle c;
    public AppBaseMap mBaseMap;

    public InnerOverlay() {
        this.mBaseMap = null;
        this.b = null;
        this.c = null;
        this.f9608a = true;
    }

    public boolean IsOverlayShow() {
        AppBaseMap appBaseMap;
        if (this.mLayerID != 0 && (appBaseMap = this.mBaseMap) != null && appBaseMap.GetId() != 0 && this.mBaseMap.LayersIsShow(this.mLayerID)) {
            return true;
        }
        return false;
    }

    public void SetMapParam(long j, AppBaseMap appBaseMap) {
        this.mLayerID = j;
        this.mBaseMap = appBaseMap;
    }

    public void SetOverlayShow(boolean z) {
        AppBaseMap appBaseMap;
        long j = 0;
        if (this.mLayerID != 0 && (appBaseMap = this.mBaseMap) != null && appBaseMap.GetId() != 0) {
            if (y.f9677a) {
                j = System.currentTimeMillis();
            }
            this.mBaseMap.ShowLayers(this.mLayerID, z);
            if (y.f9677a) {
                y.a("InnerOverlay", "ShowLayer:" + this.mLayerID + ":" + z + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - j) + "ms]");
            }
        }
    }

    public void UpdateOverlay() {
        AppBaseMap appBaseMap;
        long j = 0;
        if (this.mLayerID != 0 && (appBaseMap = this.mBaseMap) != null && appBaseMap.GetId() != 0) {
            if (y.f9677a) {
                j = System.currentTimeMillis();
            }
            this.mBaseMap.UpdateLayers(this.mLayerID);
            if (y.f9677a) {
                y.a("InnerOverlay", "UpdateLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - j) + "ms]");
            }
        }
    }

    public boolean addedToMapView() {
        long j;
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap != null && appBaseMap.GetId() != 0) {
            if (y.f9677a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            this.mLayerID = this.mBaseMap.AddLayer(getUpdateType(), getUpdateTimeInterval(), getLayerTag());
            if (y.f9677a) {
                y.a("InnerOverlay", "AddLayer:" + this.mLayerID + " type:" + this.mType + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - j) + "ms]");
            }
            long j2 = this.mLayerID;
            if (j2 != 0) {
                this.mBaseMap.SetLayersClickable(j2, this.f9608a);
                SetOverlayShow(getDefaultShowStatus());
                return true;
            }
        }
        return false;
    }

    public void clear() {
        long j;
        if (y.f9677a) {
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        if (!TextUtils.isEmpty(this.b)) {
            this.b = null;
            AppBaseMap appBaseMap = this.mBaseMap;
            if (appBaseMap != null) {
                appBaseMap.ClearLayer(this.mLayerID);
            }
        }
        if (y.f9677a) {
            y.a("InnerOverlay", "ClearLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - j) + "ms]");
        }
    }

    public String getData() {
        return this.b;
    }

    public boolean getDefaultShowStatus() {
        return false;
    }

    public String getLayerTag() {
        return "default";
    }

    public Bundle getParam() {
        return this.c;
    }

    public int getType() {
        return this.mType;
    }

    public int getUpdateTimeInterval() {
        return 0;
    }

    public int getUpdateType() {
        return 0;
    }

    public void setClickAble(boolean z) {
        this.f9608a = z;
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap != null && appBaseMap.GetId() != 0) {
            long j = this.mLayerID;
            if (j != 0) {
                this.mBaseMap.SetLayersClickable(j, z);
            }
        }
    }

    public void setData(String str) {
        if (str != null) {
            this.b = str;
        }
    }

    public void setFocus(int i, boolean z, String str) {
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap == null || appBaseMap.GetId() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("uid", str);
        }
        this.mBaseMap.SetFocus(this.mLayerID, i, z, bundle);
    }

    public void setParam(Bundle bundle) {
        this.c = bundle;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public InnerOverlay(int i) {
        this.mBaseMap = null;
        this.b = null;
        this.c = null;
        this.f9608a = true;
        setType(i);
    }

    public void setFocus(int i, boolean z) {
        setFocus(i, z, null);
    }

    public InnerOverlay(int i, AppBaseMap appBaseMap) {
        this.mBaseMap = null;
        this.b = null;
        this.c = null;
        this.f9608a = true;
        setType(i);
        this.mBaseMap = appBaseMap;
    }
}
