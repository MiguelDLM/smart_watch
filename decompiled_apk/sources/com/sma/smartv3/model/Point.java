package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes12.dex */
public final class Point {
    private double latitude;
    private long loc_time;
    private double longitude;

    public final double getLatitude() {
        return this.latitude;
    }

    public final long getLoc_time() {
        return this.loc_time;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final void setLatitude(double d) {
        this.latitude = d;
    }

    public final void setLoc_time(long j) {
        this.loc_time = j;
    }

    public final void setLongitude(double d) {
        this.longitude = d;
    }

    @OOXIXo
    public String toString() {
        return "Point(longitude=" + this.longitude + ", latitude=" + this.latitude + ", loc_time=" + this.loc_time + HexStringBuilder.COMMENT_END_CHAR;
    }
}
