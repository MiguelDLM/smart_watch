package com.baidu.navisdk.adapter.struct;

/* loaded from: classes7.dex */
public class BNHighwayInfo {
    public String directionText;
    public String exitCode;
    public String exitName;
    public int exitRemainDist;
    public String gateName;
    public int gateRemainDist;
    public String highWayName;
    public String service2Name;
    public int service2RemainDist;
    public String serviceName;
    public int serviceRemainDist;

    public String toString() {
        return this.highWayName + this.directionText + this.gateName + this.gateRemainDist + this.exitName + this.exitCode + this.exitRemainDist + this.serviceName + this.serviceRemainDist;
    }
}
