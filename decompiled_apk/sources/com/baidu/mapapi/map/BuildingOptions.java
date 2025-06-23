package com.baidu.mapapi.map;

import com.baidu.mapapi.map.Prism;
import com.baidu.mapapi.search.core.BuildingInfo;

/* loaded from: classes7.dex */
public class BuildingOptions extends PrismOptions {
    private int e;
    private BitmapDescriptor f;
    private BuildingInfo h;
    private int i;
    private float c = 0.0f;
    private boolean d = false;
    private Prism.AnimateType g = Prism.AnimateType.AnimateNormal;
    private boolean j = true;

    /* renamed from: a, reason: collision with root package name */
    boolean f5796a = true;

    @Override // com.baidu.mapapi.map.PrismOptions, com.baidu.mapapi.map.OverlayOptions
    public Overlay a() {
        Building building = new Building();
        building.M = this.f5796a;
        building.o = getCustomSideImage();
        building.k = getHeight();
        building.n = getSideFaceColor();
        building.m = getTopFaceColor();
        building.j = this.j;
        building.i = this.i;
        building.f5794a = this.h;
        building.f = this.d;
        building.b = this.c;
        building.e = this.e;
        building.g = this.f;
        building.h = this.g;
        return building;
    }

    public Prism.AnimateType getBuildingFloorAnimateType() {
        return this.g;
    }

    public BuildingInfo getBuildingInfo() {
        return this.h;
    }

    public int getFloorColor() {
        return this.e;
    }

    public float getFloorHeight() {
        return this.c;
    }

    public BitmapDescriptor getFloorSideTextureImage() {
        return this.f;
    }

    public int getShowLevel() {
        return this.i;
    }

    public boolean isAnimation() {
        return this.j;
    }

    public BuildingOptions setAnimation(boolean z) {
        this.j = z;
        return this;
    }

    public BuildingOptions setBuildingFloorAnimateType(Prism.AnimateType animateType) {
        this.g = animateType;
        return this;
    }

    public BuildingOptions setBuildingInfo(BuildingInfo buildingInfo) {
        this.h = buildingInfo;
        return this;
    }

    public BuildingOptions setFloorColor(int i) {
        this.d = true;
        this.e = i;
        return this;
    }

    public BuildingOptions setFloorHeight(float f) {
        BuildingInfo buildingInfo = this.h;
        if (buildingInfo == null) {
            return this;
        }
        if (f < 0.0f) {
            this.c = 0.0f;
            return this;
        }
        if (f > buildingInfo.getHeight()) {
            this.c = this.h.getHeight();
            return this;
        }
        this.c = f;
        return this;
    }

    public BuildingOptions setFloorSideTextureImage(BitmapDescriptor bitmapDescriptor) {
        this.d = true;
        this.f = bitmapDescriptor;
        return this;
    }

    public BuildingOptions setShowLevel(int i) {
        this.i = i;
        return this;
    }
}
