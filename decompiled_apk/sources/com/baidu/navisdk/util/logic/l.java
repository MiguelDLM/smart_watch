package com.baidu.navisdk.util.logic;

import OXOo.oOoXoXO;
import XIXIX.OOXIXo;
import android.os.Build;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private final Object f9336a;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    static {
        new a(null);
    }

    public l(@oOoXoXO Object obj) {
        this.f9336a = obj;
    }

    @IntRange(from = 0)
    public final int a() {
        int satelliteCount;
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        Object obj = this.f9336a;
        if (!oxoX.oIX0oI(obj)) {
            return 0;
        }
        satelliteCount = androidx.core.location.oxoX.oIX0oI(obj).getSatelliteCount();
        return satelliteCount;
    }

    @FloatRange(from = OOXIXo.f3760XO, to = 360.0d)
    public final float b(@IntRange(from = 0) int i) {
        float azimuthDegrees;
        if (Build.VERSION.SDK_INT >= 24) {
            Object obj = this.f9336a;
            if (oxoX.oIX0oI(obj)) {
                azimuthDegrees = androidx.core.location.oxoX.oIX0oI(obj).getAzimuthDegrees(i);
                return azimuthDegrees;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    @FloatRange(from = OOXIXo.f3760XO, to = 63.0d)
    public final float c(@IntRange(from = 0) int i) {
        float cn0DbHz;
        if (Build.VERSION.SDK_INT >= 24) {
            Object obj = this.f9336a;
            if (oxoX.oIX0oI(obj)) {
                cn0DbHz = androidx.core.location.oxoX.oIX0oI(obj).getCn0DbHz(i);
                return cn0DbHz;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    public final int d(@IntRange(from = 0) int i) {
        int constellationType;
        if (Build.VERSION.SDK_INT >= 24) {
            Object obj = this.f9336a;
            if (oxoX.oIX0oI(obj)) {
                constellationType = androidx.core.location.oxoX.oIX0oI(obj).getConstellationType(i);
                return constellationType;
            }
            return 0;
        }
        return 0;
    }

    @FloatRange(from = -90.0d, to = 90.0d)
    public final float e(@IntRange(from = 0) int i) {
        float elevationDegrees;
        if (Build.VERSION.SDK_INT >= 24) {
            Object obj = this.f9336a;
            if (oxoX.oIX0oI(obj)) {
                elevationDegrees = androidx.core.location.oxoX.oIX0oI(obj).getElevationDegrees(i);
                return elevationDegrees;
            }
            return 0.0f;
        }
        return 0.0f;
    }

    public final boolean f(@IntRange(from = 0) int i) {
        boolean hasAlmanacData;
        if (Build.VERSION.SDK_INT >= 24) {
            Object obj = this.f9336a;
            if (oxoX.oIX0oI(obj)) {
                hasAlmanacData = androidx.core.location.oxoX.oIX0oI(obj).hasAlmanacData(i);
                return hasAlmanacData;
            }
            return false;
        }
        return false;
    }

    public final boolean g(@IntRange(from = 0) int i) {
        boolean hasEphemerisData;
        if (Build.VERSION.SDK_INT >= 24) {
            Object obj = this.f9336a;
            if (oxoX.oIX0oI(obj)) {
                hasEphemerisData = androidx.core.location.oxoX.oIX0oI(obj).hasEphemerisData(i);
                return hasEphemerisData;
            }
            return false;
        }
        return false;
    }

    public final boolean h(@IntRange(from = 0) int i) {
        boolean usedInFix;
        if (Build.VERSION.SDK_INT >= 24) {
            Object obj = this.f9336a;
            if (oxoX.oIX0oI(obj)) {
                usedInFix = androidx.core.location.oxoX.oIX0oI(obj).usedInFix(i);
                return usedInFix;
            }
            return false;
        }
        return false;
    }

    @OXOo.OOXIXo
    public final String a(int i) {
        switch (i) {
            case 0:
                return "UNKNOWN";
            case 1:
                return "GPS";
            case 2:
                return "SBAS";
            case 3:
                return "GLONASS";
            case 4:
                return "QZSS";
            case 5:
                return "BEIDOU";
            case 6:
                return "GALILEO";
            case 7:
                return "IRNSS";
            default:
                return String.valueOf(i);
        }
    }
}
