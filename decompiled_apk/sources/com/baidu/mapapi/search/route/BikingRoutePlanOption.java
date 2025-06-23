package com.baidu.mapapi.search.route;

import java.util.List;

/* loaded from: classes7.dex */
public class BikingRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;

    /* renamed from: a, reason: collision with root package name */
    private List<PlanNode> f5975a = null;
    public int mRidingType = 0;

    public BikingRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public List<PlanNode> getWayPoints() {
        return this.f5975a;
    }

    public BikingRoutePlanOption passBy(List<PlanNode> list) {
        this.f5975a = list;
        return this;
    }

    public BikingRoutePlanOption ridingType(int i) {
        this.mRidingType = i;
        return this;
    }

    public BikingRoutePlanOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
