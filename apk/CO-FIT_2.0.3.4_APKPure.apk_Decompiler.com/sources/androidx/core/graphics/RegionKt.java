package androidx.core.graphics;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nRegion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n1#1,158:1\n71#1,3:159\n35#1,3:162\n44#1,3:165\n*S KotlinDebug\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n79#1:159,3\n84#1:162,3\n89#1:165,3\n*E\n"})
public final class RegionKt {
    @OOXIXo
    public static final Region and(@OOXIXo Region region, @OOXIXo Rect rect) {
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(@OOXIXo Region region, @OOXIXo Point point) {
        return region.contains(point.x, point.y);
    }

    public static final void forEach(@OOXIXo Region region, @OOXIXo oOoXoXO<? super Rect, oXIO0o0XI> oooxoxo) {
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (regionIterator.next(rect)) {
                oooxoxo.invoke(rect);
            } else {
                return;
            }
        }
    }

    @OOXIXo
    public static final Iterator<Rect> iterator(@OOXIXo Region region) {
        return new RegionKt$iterator$1(region);
    }

    @OOXIXo
    public static final Region minus(@OOXIXo Region region, @OOXIXo Rect rect) {
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    @OOXIXo
    public static final Region not(@OOXIXo Region region) {
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @OOXIXo
    public static final Region or(@OOXIXo Region region, @OOXIXo Rect rect) {
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @OOXIXo
    public static final Region plus(@OOXIXo Region region, @OOXIXo Rect rect) {
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @OOXIXo
    public static final Region unaryMinus(@OOXIXo Region region) {
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @OOXIXo
    public static final Region xor(@OOXIXo Region region, @OOXIXo Rect rect) {
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    @OOXIXo
    public static final Region and(@OOXIXo Region region, @OOXIXo Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    @OOXIXo
    public static final Region minus(@OOXIXo Region region, @OOXIXo Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    @OOXIXo
    public static final Region or(@OOXIXo Region region, @OOXIXo Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @OOXIXo
    public static final Region plus(@OOXIXo Region region, @OOXIXo Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @OOXIXo
    public static final Region xor(@OOXIXo Region region, @OOXIXo Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
