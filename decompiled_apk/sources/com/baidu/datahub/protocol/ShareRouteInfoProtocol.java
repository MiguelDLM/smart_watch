package com.baidu.datahub.protocol;

import java.util.List;

/* loaded from: classes7.dex */
public class ShareRouteInfoProtocol {
    public List<? extends WayPointInfoProtocol> wayPointInfos;
    public List<? extends OrderInfoProtocol> orderInfos = null;
    public String sessionId = null;
    public String curRouteMD5 = null;
    public String mrsl = null;
    public String startNode = null;
    public String endNode = null;
    public int preference = 1;
    public RoutePlanNodeProtocol endNodeInfo = null;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShareRouteInfoProtocol{, sessionId='");
        sb.append(this.sessionId);
        String str = this.sessionId;
        String str2 = "null";
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append('\'');
        sb.append(", curRouteMD5='");
        sb.append(this.curRouteMD5);
        sb.append(this.curRouteMD5);
        String str3 = this.curRouteMD5;
        if (str3 != null) {
            str2 = str3;
        }
        sb.append(str2);
        sb.append('\'');
        sb.append(", wayPointInfos=");
        sb.append(this.wayPointInfos.toString());
        sb.append('}');
        return sb.toString();
    }
}
