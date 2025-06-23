package com.baidu.navisdk.adapter.struct;

import com.baidu.navisdk.adapter.BNRoutePlanNode;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;

/* loaded from: classes7.dex */
public class BNRoutePlanInfo {
    public BNRoutePlanNode routePlanNode;
    public int routePlanNodeIndex;

    public BNRoutePlanInfo(BNRoutePlanNode bNRoutePlanNode, int i) {
        this.routePlanNode = bNRoutePlanNode;
        this.routePlanNodeIndex = i;
    }

    public BNRoutePlanNode getRoutePlanNode() {
        return this.routePlanNode;
    }

    public int getRoutePlanNodeIndex() {
        return this.routePlanNodeIndex;
    }

    public void setRoutePlanNode(BNRoutePlanNode bNRoutePlanNode) {
        this.routePlanNode = bNRoutePlanNode;
    }

    public void setRoutePlanNodeIndex(int i) {
        this.routePlanNodeIndex = i;
    }

    public String toString() {
        return "途径点=" + this.routePlanNode + ", index= " + this.routePlanNodeIndex;
    }

    public BNRoutePlanInfo(RoutePlanNode routePlanNode, int i) {
        if (routePlanNode != null) {
            this.routePlanNode = new BNRoutePlanNode.Builder().latitude(routePlanNode.mGeoPoint.getLatitudeE6()).longitude(routePlanNode.mGeoPoint.getLongitudeE6()).name(routePlanNode.mName).build();
        }
        this.routePlanNodeIndex = i;
    }
}
