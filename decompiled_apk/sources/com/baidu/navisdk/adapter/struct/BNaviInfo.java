package com.baidu.navisdk.adapter.struct;

import android.graphics.Bitmap;

/* loaded from: classes7.dex */
public class BNaviInfo {
    public int distance;
    public String roadName;
    public Bitmap turnIcon;
    public String turnIconName;

    public int getDistance() {
        return this.distance;
    }

    public String getRoadName() {
        return this.roadName;
    }

    public Bitmap getTurnIcon() {
        return this.turnIcon;
    }

    public String getTurnIconName() {
        return this.turnIconName;
    }

    public String toString() {
        return "到下个路口进入——" + this.roadName + " 还有 " + this.distance + "m";
    }
}
