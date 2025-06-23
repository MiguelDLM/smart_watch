package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Objects;

/* loaded from: classes6.dex */
public class oIX0oI {

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final oIX0oI f32915II0xO0 = new oIX0oI(Calendar.getInstance());

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Calendar f32916oIX0oI;

    public oIX0oI(Calendar calendar) {
        Objects.requireNonNull(calendar, "calendar");
        this.f32916oIX0oI = calendar;
    }

    public int I0Io() {
        return this.f32916oIX0oI.get(1);
    }

    public int II0xO0() {
        return this.f32916oIX0oI.get(2);
    }

    public int oIX0oI() {
        return this.f32916oIX0oI.get(5);
    }
}
