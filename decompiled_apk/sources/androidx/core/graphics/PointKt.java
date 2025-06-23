package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;

/* loaded from: classes.dex */
public final class PointKt {
    public static final int component1(@OXOo.OOXIXo Point point) {
        return point.x;
    }

    public static final int component2(@OXOo.OOXIXo Point point) {
        return point.y;
    }

    @OXOo.OOXIXo
    public static final Point div(@OXOo.OOXIXo Point point, float f) {
        return new Point(Math.round(point.x / f), Math.round(point.y / f));
    }

    @OXOo.OOXIXo
    public static final Point minus(@OXOo.OOXIXo Point point, @OXOo.OOXIXo Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    @OXOo.OOXIXo
    public static final Point plus(@OXOo.OOXIXo Point point, @OXOo.OOXIXo Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    @OXOo.OOXIXo
    public static final Point times(@OXOo.OOXIXo Point point, float f) {
        return new Point(Math.round(point.x * f), Math.round(point.y * f));
    }

    @OXOo.OOXIXo
    public static final Point toPoint(@OXOo.OOXIXo PointF pointF) {
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @OXOo.OOXIXo
    public static final PointF toPointF(@OXOo.OOXIXo Point point) {
        return new PointF(point);
    }

    @OXOo.OOXIXo
    public static final Point unaryMinus(@OXOo.OOXIXo Point point) {
        return new Point(-point.x, -point.y);
    }

    public static final float component1(@OXOo.OOXIXo PointF pointF) {
        return pointF.x;
    }

    public static final float component2(@OXOo.OOXIXo PointF pointF) {
        return pointF.y;
    }

    @OXOo.OOXIXo
    public static final PointF div(@OXOo.OOXIXo PointF pointF, float f) {
        return new PointF(pointF.x / f, pointF.y / f);
    }

    @OXOo.OOXIXo
    public static final PointF times(@OXOo.OOXIXo PointF pointF, float f) {
        return new PointF(pointF.x * f, pointF.y * f);
    }

    @OXOo.OOXIXo
    public static final PointF unaryMinus(@OXOo.OOXIXo PointF pointF) {
        return new PointF(-pointF.x, -pointF.y);
    }

    @OXOo.OOXIXo
    public static final PointF minus(@OXOo.OOXIXo PointF pointF, @OXOo.OOXIXo PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    @OXOo.OOXIXo
    public static final PointF plus(@OXOo.OOXIXo PointF pointF, @OXOo.OOXIXo PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    @OXOo.OOXIXo
    public static final Point minus(@OXOo.OOXIXo Point point, int i) {
        Point point2 = new Point(point.x, point.y);
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    @OXOo.OOXIXo
    public static final Point plus(@OXOo.OOXIXo Point point, int i) {
        Point point2 = new Point(point.x, point.y);
        point2.offset(i, i);
        return point2;
    }

    @OXOo.OOXIXo
    public static final PointF minus(@OXOo.OOXIXo PointF pointF, float f) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    @OXOo.OOXIXo
    public static final PointF plus(@OXOo.OOXIXo PointF pointF, float f) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }
}
