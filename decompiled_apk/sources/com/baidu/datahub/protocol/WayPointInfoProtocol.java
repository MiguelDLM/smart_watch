package com.baidu.datahub.protocol;

import com.baidu.mapapi.CoordType;

/* loaded from: classes7.dex */
public class WayPointInfoProtocol {
    protected CoordType coordType;
    protected boolean isArrive;
    protected RoutePlanNodeProtocol node;
    protected String orderId;
    protected String type;

    /* loaded from: classes7.dex */
    public static class WayPointType {
        public static final String END_TYPE = "end";
        public static final String START_TYPE = "start";
        public static final String WAYP_TYPE = "wp";
    }

    public WayPointInfoProtocol(String str, String str2, RoutePlanNodeProtocol routePlanNodeProtocol) {
        this.orderId = null;
        this.type = "start";
        this.node = null;
        this.isArrive = false;
        this.coordType = CoordType.BD09LL;
        this.orderId = str;
        this.type = str2;
        this.node = routePlanNodeProtocol;
    }

    public CoordType getCoordType() {
        return this.coordType;
    }

    public RoutePlanNodeProtocol getNode() {
        return this.node;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getType() {
        return this.type;
    }

    public boolean isArrive() {
        return this.isArrive;
    }

    public void setArrive(boolean z) {
        this.isArrive = z;
    }

    public void setCoordType(CoordType coordType) {
        this.coordType = coordType;
    }

    public void setNode(RoutePlanNodeProtocol routePlanNodeProtocol) {
        this.node = routePlanNodeProtocol;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PassNode{\norderId=");
        String str = this.orderId;
        String str2 = "null";
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append('\n');
        sb.append(", type=");
        sb.append(this.type);
        sb.append('\n');
        sb.append(", node =");
        RoutePlanNodeProtocol routePlanNodeProtocol = this.node;
        if (routePlanNodeProtocol != null) {
            str2 = routePlanNodeProtocol.toString();
        }
        sb.append(str2);
        return sb.toString();
    }

    public WayPointInfoProtocol(String str, String str2, RoutePlanNodeProtocol routePlanNodeProtocol, CoordType coordType) {
        this.orderId = null;
        this.type = "start";
        this.node = null;
        this.isArrive = false;
        CoordType coordType2 = CoordType.BD09LL;
        this.orderId = str;
        this.type = str2;
        this.node = routePlanNodeProtocol;
        this.coordType = coordType;
    }

    public WayPointInfoProtocol(String str, String str2, RoutePlanNodeProtocol routePlanNodeProtocol, boolean z) {
        this.orderId = null;
        this.type = "start";
        this.node = null;
        this.isArrive = false;
        this.coordType = CoordType.BD09LL;
        this.orderId = str;
        this.type = str2;
        this.node = routePlanNodeProtocol;
        this.isArrive = z;
    }
}
