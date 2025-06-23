package com.baidu.datahub.protocol;

import XIXIX.OOXIXo;
import java.util.List;

/* loaded from: classes7.dex */
public class ShareLocationInfoProtocol {
    public List<? extends OrderInfoProtocol> orderInfos = null;
    public String cuid = null;
    public double gpsLongitude = OOXIXo.f3760XO;
    public double gpsLatitude = OOXIXo.f3760XO;
    public long gpsTime = 0;
    public float gpsSpeed = 0.0f;
    public float gpsDirection = 0.0f;
    public double postLongitude = OOXIXo.f3760XO;
    public double postLatitude = OOXIXo.f3760XO;
    public float postDirection = 0.0f;

    public String toString() {
        return "ShareLocationInfoProtocol{, cuid='" + this.cuid + "', gpsLongitude=" + this.gpsLongitude + ", gpsLatitude=" + this.gpsLatitude + ", gpsTime=" + this.gpsTime + ", gpsSpeed=" + this.gpsSpeed + ", gpsDirection=" + this.gpsDirection + ", postLongitude=" + this.postLongitude + ", postLatitude=" + this.postLatitude + ", postDirection=" + this.postDirection + '}';
    }
}
