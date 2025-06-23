package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.Prism;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BuildingInfo;
import java.util.List;

/* loaded from: classes7.dex */
public class Building extends Prism {

    /* renamed from: a, reason: collision with root package name */
    BuildingInfo f5794a;
    int d;
    BitmapDescriptor g;
    int i;
    boolean j;
    float b = 0.0f;
    float c = 0.0f;
    int e = 0;
    boolean f = false;
    Prism.AnimateType h = Prism.AnimateType.AnimateNormal;

    /* loaded from: classes7.dex */
    public enum AnimateType {
        AnimateSlow,
        AnimateNormal,
        AnimateFast
    }

    public Building() {
        this.type = com.baidu.mapsdkplatform.comapi.map.h.prism;
    }

    @Override // com.baidu.mapapi.map.Prism, com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        int i;
        super.a(bundle);
        if (this.f5794a != null) {
            bundle.putDouble("m_height", r0.getHeight());
            bundle.putString("encodedPoints", this.f5794a.getGeom());
            bundle.putInt("encodePointType", EncodePointType.BUILDINGINFO.ordinal());
            bundle.putInt("m_showLevel", this.i);
            bundle.putInt("m_isAnimation", this.j ? 1 : 0);
            bundle.putInt("m_has_floor", this.f ? 1 : 0);
            bundle.putFloat("m_floor_height", this.b);
            bundle.putFloat("m_last_floor_height", this.c);
            Overlay.b(this.e, bundle);
            if (this.g != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("image_info", this.g.b());
                bundle.putBundle("m_floor_image", bundle2);
            }
            bundle.putInt("m_buildingFloorAnimateType", this.h.ordinal());
        }
        if (this.f5794a != null) {
            i = 1;
        } else {
            i = 0;
        }
        bundle.putInt("m_isBuilding", i);
        int hashCode = hashCode();
        this.d = hashCode;
        bundle.putInt("buildingId", hashCode);
        return bundle;
    }

    public Prism.AnimateType getBuildingFloorAnimateType() {
        return this.h;
    }

    public int getBuildingId() {
        return this.d;
    }

    public BuildingInfo getBuildingInfo() {
        return this.f5794a;
    }

    public int getFloorColor() {
        return this.e;
    }

    public float getFloorHeight() {
        return this.b;
    }

    public BitmapDescriptor getFloorSideTextureImage() {
        return this.g;
    }

    @Override // com.baidu.mapapi.map.Prism
    public float getHeight() {
        return this.k;
    }

    @Override // com.baidu.mapapi.map.Prism
    public List<LatLng> getPoints() {
        return this.l;
    }

    public int getShowLevel() {
        return this.i;
    }

    @Override // com.baidu.mapapi.map.Prism
    public int getSideFaceColor() {
        return this.n;
    }

    @Override // com.baidu.mapapi.map.Prism
    public int getTopFaceColor() {
        return this.m;
    }

    public boolean isAnimation() {
        return this.j;
    }

    public void setAnimation(boolean z) {
        this.j = z;
    }

    public void setBuildingFloorAnimateType(Prism.AnimateType animateType) {
        this.h = animateType;
        this.listener.c(this);
    }

    public void setBuildingInfo(BuildingInfo buildingInfo) {
        this.f5794a = buildingInfo;
        this.listener.c(this);
    }

    public void setFloorColor(int i) {
        this.f = true;
        this.e = i;
        this.listener.c(this);
    }

    public void setFloorHeight(float f) {
        BuildingInfo buildingInfo = this.f5794a;
        if (buildingInfo == null) {
            return;
        }
        if (f < 0.0f) {
            this.c = this.b;
            this.b = 0.0f;
        } else if (f > buildingInfo.getHeight()) {
            this.c = this.b;
            this.b = this.f5794a.getHeight();
        } else {
            this.c = this.b;
            this.b = f;
            this.listener.c(this);
        }
    }

    public void setFloorSideTextureImage(BitmapDescriptor bitmapDescriptor) {
        this.g = bitmapDescriptor;
        this.f = true;
        this.listener.c(this);
    }

    public void setShowLevel(int i) {
        this.i = i;
    }
}
