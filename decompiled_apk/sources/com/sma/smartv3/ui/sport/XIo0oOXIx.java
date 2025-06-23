package com.sma.smartv3.ui.sport;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.sma.smartv3.db.entity.Location;

/* loaded from: classes12.dex */
public final class XIo0oOXIx {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XIo0oOXIx f23889oIX0oI = new XIo0oOXIx();

    public final int I0Io(int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        return (int) ((i / 1000.0f) / (i2 / 3600.0f));
    }

    public final int II0XooXoX(int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        return (int) ((i / i2) * 60.0f);
    }

    public final int II0xO0(int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        return (int) ((i / i2) * 1000.0f);
    }

    public final int Oxx0IOOO(float f, int i) {
        return (int) (((48 * f) * i) / 10000.0f);
    }

    public final int X0o0xo(@OXOo.OOXIXo Location location, @OXOo.OOXIXo Location location2) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(location, "location");
        kotlin.jvm.internal.IIX0o.x0xO0oo(location2, "location2");
        int distance = (int) DistanceUtil.getDistance(new LatLng(location.getMLatitude(), location.getMLongitude()), new LatLng(location2.getMLatitude(), location2.getMLongitude()));
        if (distance < 0) {
            return 0;
        }
        return distance;
    }

    public final int XO(int i, float f, int i2) {
        if (i2 < 0 || f < 0.0f) {
            return 0;
        }
        return (int) (((((i == 1 ? 55 : 46) * f) * i2) / 10) / 10000);
    }

    public final int oIX0oI(float f, int i) {
        if (i < 0 || f < 0.0f) {
            return 0;
        }
        return (int) (((f * i) * 0.8d) / 1000);
    }

    public final float oxoX(int i, int i2) {
        if (i2 == 0) {
            return 0.0f;
        }
        return (i / 1000.0f) / (i2 / 3600.0f);
    }

    public final long xxIXOIIO(long j) {
        long j2 = 60000;
        return (j / j2) * j2;
    }
}
