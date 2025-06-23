package ooXIXxIX;

import kotlin.jvm.internal.XX;

@XX({"SMAP\nCoordinates.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Coordinates.kt\ncom/batoulapps/adhan2/Coordinates\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,16:1\n1#2:17\n*E\n"})
/* loaded from: classes8.dex */
public final class II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final double f32454II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final double f32455oIX0oI;

    public II0xO0(double d, double d2) {
        this.f32455oIX0oI = d;
        this.f32454II0xO0 = d2;
        if (-90.0d <= d && d <= 90.0d) {
            if (-180.0d <= d2 && d2 <= 180.0d) {
                return;
            } else {
                throw new IllegalArgumentException("Longitude must be between -180 and 180 degrees");
            }
        }
        throw new IllegalArgumentException("Latitude must be between -90 and 90 degrees");
    }

    public final double II0xO0() {
        return this.f32454II0xO0;
    }

    public final double oIX0oI() {
        return this.f32455oIX0oI;
    }
}
