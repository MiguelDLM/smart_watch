package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BDLocationPoint {
    private int direction;
    private double height;
    private double latitude;
    private long loc_time;
    private double longitude;
    private double radius;
    private double speed;

    @OOXIXo
    private String entity_name = "";

    @OOXIXo
    private String coord_type_input = "wgs84";

    @OOXIXo
    public final String getCoord_type_input() {
        return this.coord_type_input;
    }

    public final int getDirection() {
        return this.direction;
    }

    @OOXIXo
    public final String getEntity_name() {
        return this.entity_name;
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

    public final void setCoord_type_input(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.coord_type_input = str;
    }

    public final void setDirection(int i) {
        this.direction = i;
    }

    public final void setEntity_name(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.entity_name = str;
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
        return "BDLocationPoint(entity_name='" + this.entity_name + "', loc_time=" + this.loc_time + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", coord_type_input='" + this.coord_type_input + "', speed=" + this.speed + ", direction=" + this.direction + ", height=" + this.height + ", radius=" + this.radius + HexStringBuilder.COMMENT_END_CHAR;
    }
}
