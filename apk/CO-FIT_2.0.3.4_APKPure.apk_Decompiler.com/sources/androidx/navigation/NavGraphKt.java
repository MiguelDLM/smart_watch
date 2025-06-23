package androidx.navigation;

import OXOo.OOXIXo;
import androidx.annotation.IdRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.serialization.RouteSerializerKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oOXoIIIo;
import kotlin.reflect.Oxx0xo;
import kotlin.reflect.oxoX;
import kotlinx.serialization.OxxIIOOXO;

@XX({"SMAP\nNavGraph.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NavGraph.kt\nandroidx/navigation/NavGraphKt\n+ 2 NavGraph.kt\nandroidx/navigation/NavGraph\n*L\n1#1,677:1\n306#2:678\n306#2:679\n*S KotlinDebug\n*F\n+ 1 NavGraph.kt\nandroidx/navigation/NavGraphKt\n*L\n621#1:678\n642#1:679\n*E\n"})
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

    public static final void minusAssign(@OOXIXo NavGraph navGraph, @OOXIXo NavDestination navDestination) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(navDestination, "node");
        navGraph.remove(navDestination);
    }

    public static final void plusAssign(@OOXIXo NavGraph navGraph, @OOXIXo NavDestination navDestination) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(navDestination, "node");
        navGraph.addDestination(navDestination);
    }

    public static final boolean contains(@OOXIXo NavGraph navGraph, @OOXIXo String str) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(str, "route");
        return navGraph.findNode(str) != null;
    }

    @OOXIXo
    public static final NavDestination get(@OOXIXo NavGraph navGraph, @OOXIXo String str) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(str, "route");
        NavDestination findNode = navGraph.findNode(str);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + str + " was found in " + navGraph);
    }

    public static final void plusAssign(@OOXIXo NavGraph navGraph, @OOXIXo NavGraph navGraph2) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(navGraph2, "other");
        navGraph.addAll(navGraph2);
    }

    public static final <T> boolean contains(@OOXIXo NavGraph navGraph, @OOXIXo T t) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(t, "route");
        return navGraph.findNode(t) != null;
    }

    public static final /* synthetic */ <T> boolean contains(NavGraph navGraph, oxoX<T> oxox) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(oxox, "route");
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        return navGraph.findNode(RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO((Oxx0xo) null))) != null;
    }

    @OOXIXo
    public static final <T> NavDestination get(@OOXIXo NavGraph navGraph, @OOXIXo T t) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(t, "route");
        NavDestination findNode = navGraph.findNode(t);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + t + " was found in " + navGraph);
    }

    public static final /* synthetic */ <T> NavDestination get(NavGraph navGraph, oxoX<T> oxox) {
        IIX0o.x0xO0oo(navGraph, "<this>");
        IIX0o.x0xO0oo(oxox, "route");
        IIX0o.OxI(6, ExifInterface.GPS_DIRECTION_TRUE);
        oOXoIIIo.x0XOIxOo("kotlinx.serialization.serializer.simple");
        NavDestination findNode = navGraph.findNode(RouteSerializerKt.generateHashCode(OxxIIOOXO.xxIXOIIO((Oxx0xo) null)));
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + oxox + " was found in " + navGraph);
    }
}
