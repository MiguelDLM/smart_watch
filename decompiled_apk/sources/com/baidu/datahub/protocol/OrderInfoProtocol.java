package com.baidu.datahub.protocol;

/* loaded from: classes7.dex */
public class OrderInfoProtocol {
    protected String orderId = null;
    public String preOrderId = null;
    public String companyServerId = null;
    public String driverId = null;
    public int orderState = 0;
    public RoutePlanNodeProtocol startNode = null;
    public RoutePlanNodeProtocol curLocationNode = null;
    public RoutePlanNodeProtocol pickupNode = null;
    public RoutePlanNodeProtocol endNode = null;
    public String cuid = "";
    public int orderType = 0;

    /* loaded from: classes7.dex */
    public static class OrderType {
        public static final int CAR_POOL_ORDER = 1;
        public static final int NORMAL_ORDER = 0;
    }

    public RoutePlanNodeProtocol getCurLocationNode() {
        return this.curLocationNode;
    }

    public RoutePlanNodeProtocol getEndNode() {
        return this.endNode;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public RoutePlanNodeProtocol getPickupNode() {
        return this.pickupNode;
    }

    public RoutePlanNodeProtocol getStartNode() {
        return this.startNode;
    }

    public void setCurLocationNode(RoutePlanNodeProtocol routePlanNodeProtocol) {
        this.curLocationNode = routePlanNodeProtocol;
    }

    public void setEndNode(RoutePlanNodeProtocol routePlanNodeProtocol) {
        this.endNode = routePlanNodeProtocol;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPickupNode(RoutePlanNodeProtocol routePlanNodeProtocol) {
        this.pickupNode = routePlanNodeProtocol;
    }

    public void setStartNode(RoutePlanNodeProtocol routePlanNodeProtocol) {
        this.startNode = routePlanNodeProtocol;
    }
}
