package androidx.core.graphics;

import OXOo.OOXIXo;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nRect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,365:1\n344#1,3:366\n344#1,3:369\n257#1,6:372\n122#1,3:378\n132#1,3:381\n344#1,3:384\n344#1,3:387\n344#1,3:390\n1#2:393\n*S KotlinDebug\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n191#1:366,3\n192#1:369,3\n251#1:372,6\n268#1:378,3\n273#1:381,3\n313#1:384,3\n314#1:387,3\n358#1:390,3\n*E\n"})
public final class RectKt {
    @SuppressLint({"CheckResult"})
    @OOXIXo
    public static final Rect and(@OOXIXo Rect rect, @OOXIXo Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(@OOXIXo Rect rect) {
        return rect.left;
    }

    public static final int component2(@OOXIXo Rect rect) {
        return rect.top;
    }

    public static final int component3(@OOXIXo Rect rect) {
        return rect.right;
    }

    public static final int component4(@OOXIXo Rect rect) {
        return rect.bottom;
    }

    public static final boolean contains(@OOXIXo Rect rect, @OOXIXo Point point) {
        return rect.contains(point.x, point.y);
    }

    @OOXIXo
    public static final Region minus(@OOXIXo Rect rect, @OOXIXo Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @OOXIXo
    public static final Rect or(@OOXIXo Rect rect, @OOXIXo Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @OOXIXo
    public static final Rect plus(@OOXIXo Rect rect, @OOXIXo Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @OOXIXo
    public static final Rect times(@OOXIXo Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        rect2.top *= i;
        rect2.left *= i;
        rect2.right *= i;
        rect2.bottom *= i;
        return rect2;
    }

    @OOXIXo
    public static final Rect toRect(@OOXIXo RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @OOXIXo
    public static final RectF toRectF(@OOXIXo Rect rect) {
        return new RectF(rect);
    }

    @OOXIXo
    public static final Region toRegion(@OOXIXo Rect rect) {
        return new Region(rect);
    }

    @OOXIXo
    public static final RectF transform(@OOXIXo RectF rectF, @OOXIXo Matrix matrix) {
        matrix.mapRect(rectF);
        return rectF;
    }

    @OOXIXo
    public static final Region xor(@OOXIXo Rect rect, @OOXIXo Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(@OOXIXo RectF rectF) {
        return rectF.left;
    }

    public static final float component2(@OOXIXo RectF rectF) {
        return rectF.top;
    }

    public static final float component3(@OOXIXo RectF rectF) {
        return rectF.right;
    }

    public static final float component4(@OOXIXo RectF rectF) {
        return rectF.bottom;
    }

    public static final boolean contains(@OOXIXo RectF rectF, @OOXIXo PointF pointF) {
        return rectF.contains(pointF.x, pointF.y);
    }

    @OOXIXo
    public static final Region toRegion(@OOXIXo RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    @OOXIXo
    public static final RectF and(@OOXIXo RectF rectF, @OOXIXo RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    @OOXIXo
    public static final Region minus(@OOXIXo RectF rectF, @OOXIXo RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @OOXIXo
    public static final RectF or(@OOXIXo RectF rectF, @OOXIXo RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @OOXIXo
    public static final RectF plus(@OOXIXo RectF rectF, @OOXIXo RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @OOXIXo
    public static final Region xor(@OOXIXo RectF rectF, @OOXIXo RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @OOXIXo
    public static final Rect plus(@OOXIXo Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        rect2.offset(i, i);
        return rect2;
    }

    @OOXIXo
    public static final RectF times(@OOXIXo RectF rectF, float f) {
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    @OOXIXo
    public static final RectF plus(@OOXIXo RectF rectF, float f) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f, f);
        return rectF2;
    }

    @OOXIXo
    public static final Rect plus(@OOXIXo Rect rect, @OOXIXo Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    @OOXIXo
    public static final Rect minus(@OOXIXo Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        int i2 = -i;
        rect2.offset(i2, i2);
        return rect2;
    }

    @OOXIXo
    public static final RectF plus(@OOXIXo RectF rectF, @OOXIXo PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    @OOXIXo
    public static final RectF times(@OOXIXo RectF rectF, int i) {
        float f = (float) i;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    @OOXIXo
    public static final RectF minus(@OOXIXo RectF rectF, float f) {
        RectF rectF2 = new RectF(rectF);
        float f2 = -f;
        rectF2.offset(f2, f2);
        return rectF2;
    }

    @OOXIXo
    public static final Rect minus(@OOXIXo Rect rect, @OOXIXo Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    @OOXIXo
    public static final RectF minus(@OOXIXo RectF rectF, @OOXIXo PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }
}
