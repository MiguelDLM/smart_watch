package com.baidu.datahub.protocol;

/* loaded from: classes7.dex */
public class ShareETAInfoProtocol {
    public long leftTime = 0;
    public long pastTime = 0;
    public long leftDist = 0;
    public long pastDist = 0;
    public String orderId = "";
    public String etaType = "";
    public String routeID = "";

    /* loaded from: classes7.dex */
    public static class ETAType {
        public static final String ETA_END = "end";
        public static final String ETA_START = "start";
        public static final String ETA_WAY = "wp";
    }

    public String toString() {
        return "ShareETAInfoProtocol{leftTime=" + this.leftTime + ", pastTime=" + this.pastTime + ", leftDist=" + this.leftDist + ", pastDist=" + this.pastDist + ", orderId=" + this.orderId + ", etaType=" + this.etaType + '}';
    }
}
