package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BDFindLocationResponse {
    private double distance;
    private int size;
    private int status;
    private double toll_distance;
    private int total;

    @OOXIXo
    private String message = "";

    @OOXIXo
    private Point start_point = new Point();

    @OOXIXo
    private Point end_point = new Point();

    @OOXIXo
    private ArrayList<Points> points = new ArrayList<>();

    public final double getDistance() {
        return this.distance;
    }

    @OOXIXo
    public final Point getEnd_point() {
        return this.end_point;
    }

    @OOXIXo
    public final String getMessage() {
        return this.message;
    }

    @OOXIXo
    public final ArrayList<Points> getPoints() {
        return this.points;
    }

    public final int getSize() {
        return this.size;
    }

    @OOXIXo
    public final Point getStart_point() {
        return this.start_point;
    }

    public final int getStatus() {
        return this.status;
    }

    public final double getToll_distance() {
        return this.toll_distance;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setDistance(double d) {
        this.distance = d;
    }

    public final void setEnd_point(@OOXIXo Point point) {
        IIX0o.x0xO0oo(point, "<set-?>");
        this.end_point = point;
    }

    public final void setMessage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.message = str;
    }

    public final void setPoints(@OOXIXo ArrayList<Points> arrayList) {
        IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.points = arrayList;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final void setStart_point(@OOXIXo Point point) {
        IIX0o.x0xO0oo(point, "<set-?>");
        this.start_point = point;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setToll_distance(double d) {
        this.toll_distance = d;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    @OOXIXo
    public String toString() {
        return "BDFindLocationResponse(status=" + this.status + ", message='" + this.message + "', total=" + this.total + ", size=" + this.size + ", distance=" + this.distance + ", toll_distance=" + this.toll_distance + ", start_point=" + this.start_point + ", end_point=" + this.end_point + ", points=" + this.points + HexStringBuilder.COMMENT_END_CHAR;
    }
}
