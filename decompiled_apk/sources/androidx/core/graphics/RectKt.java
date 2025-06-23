package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nRect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,365:1\n344#1,3:366\n344#1,3:369\n257#1,6:372\n122#1,3:378\n132#1,3:381\n344#1,3:384\n344#1,3:387\n344#1,3:390\n1#2:393\n*S KotlinDebug\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n191#1:366,3\n192#1:369,3\n251#1:372,6\n268#1:378,3\n273#1:381,3\n313#1:384,3\n314#1:387,3\n358#1:390,3\n*E\n"})
/* loaded from: classes.dex */
public final class RectKt {
    @OXOo.OOXIXo
    @SuppressLint({"CheckResult"})
    public static final Rect and(@OXOo.OOXIXo Rect rect, @OXOo.OOXIXo Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(@OXOo.OOXIXo Rect rect) {
        return rect.left;
    }

    public static final int component2(@OXOo.OOXIXo Rect rect) {
        return rect.top;
    }

    public static final int component3(@OXOo.OOXIXo Rect rect) {
        return rect.right;
    }

    public static final int component4(@OXOo.OOXIXo Rect rect) {
        return rect.bottom;
    }

    public static final boolean contains(@OXOo.OOXIXo Rect rect, @OXOo.OOXIXo Point point) {
        return rect.contains(point.x, point.y);
    }

    @OXOo.OOXIXo
    public static final Region minus(@OXOo.OOXIXo Rect rect, @OXOo.OOXIXo Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @OXOo.OOXIXo
    public static final Rect or(@OXOo.OOXIXo Rect rect, @OXOo.OOXIXo Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @OXOo.OOXIXo
    public static final Rect plus(@OXOo.OOXIXo Rect rect, @OXOo.OOXIXo Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @OXOo.OOXIXo
    public static final Rect times(@OXOo.OOXIXo Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        rect2.top *= i;
        rect2.left *= i;
        rect2.right *= i;
        rect2.bottom *= i;
        return rect2;
    }

    @OXOo.OOXIXo
    public static final Rect toRect(@OXOo.OOXIXo RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @OXOo.OOXIXo
    public static final RectF toRectF(@OXOo.OOXIXo Rect rect) {
        return new RectF(rect);
    }

    @OXOo.OOXIXo
    public static final Region toRegion(@OXOo.OOXIXo Rect rect) {
        return new Region(rect);
    }

    @OXOo.OOXIXo
    public static final RectF transform(@OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo Matrix matrix) {
        matrix.mapRect(rectF);
        return rectF;
    }

    @OXOo.OOXIXo
    public static final Region xor(@OXOo.OOXIXo Rect rect, @OXOo.OOXIXo Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(@OXOo.OOXIXo RectF rectF) {
        return rectF.left;
    }

    public static final float component2(@OXOo.OOXIXo RectF rectF) {
        return rectF.top;
    }

    public static final float component3(@OXOo.OOXIXo RectF rectF) {
        return rectF.right;
    }

    public static final float component4(@OXOo.OOXIXo RectF rectF) {
        return rectF.bottom;
    }

    public static final boolean contains(@OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo PointF pointF) {
        return rectF.contains(pointF.x, pointF.y);
    }

    @OXOo.OOXIXo
    public static final Region toRegion(@OXOo.OOXIXo RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @OXOo.OOXIXo
    @SuppressLint({"CheckResult"})
    public static final RectF and(@OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    @OXOo.OOXIXo
    public static final Region minus(@OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @OXOo.OOXIXo
    public static final RectF or(@OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @OXOo.OOXIXo
    public static final RectF plus(@OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @OXOo.OOXIXo
    public static final Region xor(@OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @OXOo.OOXIXo
    public static final Rect plus(@OXOo.OOXIXo Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        rect2.offset(i, i);
        return rect2;
    }

    @OXOo.OOXIXo
    public static final RectF times(@OXOo.OOXIXo RectF rectF, float f) {
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    @OXOo.OOXIXo
    public static final RectF plus(@OXOo.OOXIXo RectF rectF, float f) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f, f);
        return rectF2;
    }

    @OXOo.OOXIXo
    public static final Rect plus(@OXOo.OOXIXo Rect rect, @OXOo.OOXIXo Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    @OXOo.OOXIXo
    public static final Rect minus(@OXOo.OOXIXo Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        int i2 = -i;
        rect2.offset(i2, i2);
        return rect2;
    }

    @OXOo.OOXIXo
    public static final RectF plus(@OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    @OXOo.OOXIXo
    public static final RectF times(@OXOo.OOXIXo RectF rectF, int i) {
        float f = i;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    @OXOo.OOXIXo
    public static final RectF minus(@OXOo.OOXIXo RectF rectF, float f) {
        RectF rectF2 = new RectF(rectF);
        float f2 = -f;
        rectF2.offset(f2, f2);
        return rectF2;
    }

    @OXOo.OOXIXo
    public static final Rect minus(@OXOo.OOXIXo Rect rect, @OXOo.OOXIXo Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    @OXOo.OOXIXo
    public static final RectF minus(@OXOo.OOXIXo RectF rectF, @OXOo.OOXIXo PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }
}
