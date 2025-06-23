package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* loaded from: classes7.dex */
public class ParticleOptions {

    /* renamed from: a, reason: collision with root package name */
    private List<BitmapDescriptor> f5845a;
    private LatLng b;

    public List<BitmapDescriptor> getParticleImgs() {
        return this.f5845a;
    }

    public LatLng getParticlePos() {
        return this.b;
    }

    public void setParticleImgs(List<BitmapDescriptor> list) {
        this.f5845a = list;
    }

    public void setParticlePos(LatLng latLng) {
        this.b = latLng;
    }
}
