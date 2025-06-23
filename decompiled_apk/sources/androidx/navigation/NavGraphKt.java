package androidx.navigation;

import OXOo.OOXIXo;
import androidx.annotation.IdRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.serialization.RouteSerializerKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oOXoIIIo;
import kotlin.reflect.oxoX;
import kotlinx.serialization.OxxIIOOXO;

@XX({"SMAP\nNavGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavGraph.kt\nandroidx/navigation/NavGraphKt\n+ 2 NavGraph.kt\nandroidx/navigation/NavGraph\n*L\n1#1,677:1\n306#2:678\n306#2:679\n*S KotlinDebug\n*F\n+ 1 NavGraph.kt\nandroidx/navigation/NavGraphKt\n*L\n621#1:678\n642#1:679\n*E\n"})
/* loaded from: classes.dex */
public final class NavGraphKt {
    public static final boolean contains(@OOXIXo NavGraph navGraph, @IdRes int i) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        return navGraph.findNode(i) != null;
    }

    @OOXIXo
    public static final NavDestination get(@OOXIXo NavGraph navGraph, @IdRes int i) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        NavDestination findNode = navGraph.findNode(i);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + i + " was found in " + navGraph);
    }

    public static final void minusAssign(@OOXIXo NavGraph navGraph, @OOXIXo NavDestination node) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(node, "node");
        navGraph.remove(node);
    }

    public static final void plusAssign(@OOXIXo NavGraph navGraph, @OOXIXo NavDestination node) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(node, "node");
        navGraph.addDestination(node);
    }

    public static final boolean contains(@OOXIXo NavGraph navGraph, @OOXIXo String route) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(route, "route");
        return navGraph.findNode(route) != null;
    }

    @OOXIXo
    public static final NavDestination get(@OOXIXo NavGraph navGraph, @OOXIXo String route) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(route, "route");
        NavDestination findNode = navGraph.findNode(route);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + route + " was found in " + navGraph);
    }

    public static final void plusAssign(@OOXIXo NavGraph navGraph, @OOXIXo NavGraph other) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(other, "other");
        navGraph.addAll(other);
    }

    public static final <T> boolean contains(@OOXIXo NavGraph navGraph, @OOXIXo T route) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(route, "route");
        return navGraph.findNode((NavGraph) route) != null;
    }

    public static final /* synthetic */ <T> boolean contains(NavGraph navGraph, oxoX<T> route) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(route, "route");
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        return navGraph.findNode(RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO(null))) != null;
    }

    @OOXIXo
    public static final <T> NavDestination get(@OOXIXo NavGraph navGraph, @OOXIXo T route) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(route, "route");
        NavDestination findNode = navGraph.findNode((NavGraph) route);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + route + " was found in " + navGraph);
    }

    public static final /* synthetic */ <T> NavDestination get(NavGraph navGraph, oxoX<T> route) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(route, "route");
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        NavDestination findNode = navGraph.findNode(RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO(null)));
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + route + " was found in " + navGraph);
    }
}
