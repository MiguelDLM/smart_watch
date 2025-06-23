package com.baidu.navisdk.adapter.struct;

/* loaded from: classes7.dex */
public class RoadEventItem {
    public double latitude;
    public double longitude;
    public int roadEventType;
    public String roadEventTypeStr;

    public RoadEventItem() {
    }

    public RoadEventItem(int i, String str, double d, double d2) {
        this.roadEventType = i;
        this.roadEventTypeStr = str;
        this.longitude = d;
        this.latitude = d2;
    }
}
