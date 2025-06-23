package androidx.core.graphics;

import OXOo.OOXIXo;
import android.graphics.Point;
import android.graphics.PointF;

public final class PointKt {
    public static final int component1(@OOXIXo Point point) {
        return point.x;
    }

    public static final int component2(@OOXIXo Point point) {
        return point.y;
    }

    @OOXIXo
    public static final Point div(@OOXIXo Point point, float f) {
        return new Point(Math.round(((float) point.x) / f), Math.round(((float) point.y) / f));
    }

    @OOXIXo
    public static final Point minus(@OOXIXo Point point, @OOXIXo Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    @OOXIXo
    public static final Point plus(@OOXIXo Point point, @OOXIXo Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    @OOXIXo
    public static final Point times(@OOXIXo Point point, float f) {
        return new Point(Math.round(((float) point.x) * f), Math.round(((float) point.y) * f));
    }

    @OOXIXo
    public static final Point toPoint(@OOXIXo PointF pointF) {
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @OOXIXo
    public static final PointF toPointF(@OOXIXo Point point) {
        return new PointF(point);
    }

    @OOXIXo
    public static final Point unaryMinus(@OOXIXo Point point) {
        return new Point(-point.x, -point.y);
    }

    public static final float component1(@OOXIXo PointF pointF) {
        return pointF.x;
    }

    public static final float component2(@OOXIXo PointF pointF) {
        return pointF.y;
    }

    @OOXIXo
    public static final PointF div(@OOXIXo PointF pointF, float f) {
        return new PointF(pointF.x / f, pointF.y / f);
    }

    @OOXIXo
    public static final PointF times(@OOXIXo PointF pointF, float f) {
        return new PointF(pointF.x * f, pointF.y * f);
    }

    @OOXIXo
    public static final PointF unaryMinus(@OOXIXo PointF pointF) {
        return new PointF(-pointF.x, -pointF.y);
    }

    @OOXIXo
    public static final PointF minus(@OOXIXo PointF pointF, @OOXIXo PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    @OOXIXo
    public static final PointF plus(@OOXIXo PointF pointF, @OOXIXo PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    @OOXIXo
    public static final Point minus(@OOXIXo Point point, int i) {
        Point point2 = new Point(point.x, point.y);
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    @OOXIXo
    public static final Point plus(@OOXIXo Point point, int i) {
        Point point2 = new Point(point.x, point.y);
        point2.offset(i, i);
        return point2;
    }

    @OOXIXo
    public static final PointF minus(@OOXIXo PointF pointF, float f) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    @OOXIXo
    public static final PointF plus(@OOXIXo PointF pointF, float f) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }
}
