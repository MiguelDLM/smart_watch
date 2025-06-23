package com.sma.smartv3.util;

import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.model.CustomLatLng;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes12.dex */
public final class I0Io {
    @OXOo.OOXIXo
    public static final LatLng I0Io(@OXOo.OOXIXo List<CustomLatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        Pair<CustomLatLng, CustomLatLng> I0Io2 = xI.I0Io(points);
        CustomLatLng component1 = I0Io2.component1();
        CustomLatLng component2 = I0Io2.component2();
        double d = 2;
        double latitude = component1.getLatitude() + ((component2.getLatitude() - component1.getLatitude()) / d);
        double longitude = component1.getLongitude() + ((component2.getLongitude() - component1.getLongitude()) / d);
        StringBuilder sb = new StringBuilder();
        sb.append(latitude);
        sb.append(TokenParser.SP);
        sb.append(longitude);
        LogUtils.d(sb.toString());
        return new LatLng(latitude, longitude);
    }

    @OXOo.OOXIXo
    public static final MapStatusUpdate II0xO0(@OXOo.OOXIXo List<CustomLatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        Pair<CustomLatLng, CustomLatLng> I0Io2 = xI.I0Io(points);
        CustomLatLng component1 = I0Io2.component1();
        CustomLatLng component2 = I0Io2.component2();
        double d = 2;
        double latitude = component1.getLatitude() + ((component2.getLatitude() - component1.getLatitude()) / d);
        double longitude = component1.getLongitude() + ((component2.getLongitude() - component1.getLongitude()) / d);
        StringBuilder sb = new StringBuilder();
        sb.append(latitude);
        sb.append(TokenParser.SP);
        sb.append(longitude);
        LogUtils.d(sb.toString());
        MapStatusUpdate newLatLng = MapStatusUpdateFactory.newLatLng(new LatLng(latitude, longitude));
        kotlin.jvm.internal.IIX0o.oO(newLatLng, "newLatLng(...)");
        return newLatLng;
    }

    @OXOo.OOXIXo
    public static final MapStatusUpdate X0o0xo(@OXOo.OOXIXo List<CustomLatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        Pair<CustomLatLng, CustomLatLng> I0Io2 = xI.I0Io(points);
        CustomLatLng component1 = I0Io2.component1();
        CustomLatLng component2 = I0Io2.component2();
        MapStatusUpdate newLatLng = MapStatusUpdateFactory.newLatLng(new LatLng(component1.getLatitude() + (((component2.getLatitude() - component1.getLatitude()) * 2) / 3), component1.getLongitude() + ((component2.getLongitude() - component1.getLongitude()) / 10)));
        kotlin.jvm.internal.IIX0o.oO(newLatLng, "newLatLng(...)");
        return newLatLng;
    }

    @OXOo.OOXIXo
    public static final LatLngBounds oIX0oI(@OXOo.OOXIXo List<CustomLatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        Pair<CustomLatLng, CustomLatLng> I0Io2 = xI.I0Io(points);
        CustomLatLng component1 = I0Io2.component1();
        CustomLatLng component2 = I0Io2.component2();
        LatLngBounds build = new LatLngBounds.Builder().include(new LatLng(component2.getLatitude(), component2.getLongitude())).include(new LatLng(component1.getLatitude(), component1.getLongitude())).build();
        kotlin.jvm.internal.IIX0o.oO(build, "build(...)");
        return build;
    }

    @OXOo.OOXIXo
    public static final MapStatusUpdate oxoX(@OXOo.OOXIXo List<CustomLatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        Pair<CustomLatLng, CustomLatLng> I0Io2 = xI.I0Io(points);
        CustomLatLng component1 = I0Io2.component1();
        CustomLatLng component2 = I0Io2.component2();
        MapStatusUpdate newLatLng = MapStatusUpdateFactory.newLatLng(new LatLng(component1.getLatitude() + (((component2.getLatitude() - component1.getLatitude()) * 4) / 5), component1.getLongitude() + (component2.getLongitude() - component1.getLongitude())));
        kotlin.jvm.internal.IIX0o.oO(newLatLng, "newLatLng(...)");
        return newLatLng;
    }
}
