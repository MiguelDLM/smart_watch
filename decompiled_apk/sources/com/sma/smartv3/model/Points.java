package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class Points {

    @OOXIXo
    private String create_time = "";
    private int direction;
    private double height;
    private double latitude;
    private long loc_time;
    private double longitude;
    private double radius;
    private double speed;

    @OOXIXo
    public final String getCreate_time() {
        return this.create_time;
    }

    public final int getDirection() {
        return this.direction;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final long getLoc_time() {
        return this.loc_time;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final double getRadius() {
        return this.radius;
    }

    public final double getSpeed() {
        return this.speed;
    }

    public final void setCreate_time(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.create_time = str;
    }

    public final void setDirection(int i) {
        this.direction = i;
    }

    public final void setHeight(double d) {
        this.height = d;
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

    public final void setRadius(double d) {
        this.radius = d;
    }

    public final void setSpeed(double d) {
        this.speed = d;
    }

    @OOXIXo
    public String toString() {
        return "Points(longitude=" + this.longitude + ", latitude=" + this.latitude + ", loc_time=" + this.loc_time + ", create_time='" + this.create_time + "', direction=" + this.direction + ", height=" + this.height + ", radius=" + this.radius + ", speed=" + this.speed + HexStringBuilder.COMMENT_END_CHAR;
    }
}
