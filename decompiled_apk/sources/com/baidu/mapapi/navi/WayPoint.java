package com.baidu.mapapi.navi;

import java.util.List;

/* loaded from: classes7.dex */
public class WayPoint {

    /* renamed from: a, reason: collision with root package name */
    private List<WayPointInfo> f5927a;

    public WayPoint(List<WayPointInfo> list) {
        if (list == null) {
            return;
        }
        this.f5927a = list;
    }

    public List<WayPointInfo> getViaPoints() {
        return this.f5927a;
    }
}
