package com.sma.smartv3.util;

import com.blankj.utilcode.util.LogUtils;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.model.CustomLatLng;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes12.dex */
public final class IIXOooo {
    @OXOo.OOXIXo
    public static final LatLng II0xO0(@OXOo.OOXIXo List<CustomLatLng> points) {
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
    public static final LatLngBounds oIX0oI(@OXOo.OOXIXo List<CustomLatLng> points) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
        Pair<CustomLatLng, CustomLatLng> I0Io2 = xI.I0Io(points);
        CustomLatLng component1 = I0Io2.component1();
        CustomLatLng component2 = I0Io2.component2();
        LatLngBounds build = new LatLngBounds.Builder().include(new LatLng(component2.getLatitude(), component2.getLongitude())).include(new LatLng(component1.getLatitude(), component1.getLongitude())).build();
        kotlin.jvm.internal.IIX0o.oO(build, "build(...)");
        return build;
    }
}
