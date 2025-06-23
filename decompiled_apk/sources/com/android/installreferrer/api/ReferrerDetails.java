package com.android.installreferrer.api;

import android.os.Bundle;

/* loaded from: classes.dex */
public class ReferrerDetails {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final String f5171I0Io = "referrer_click_timestamp_seconds";

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final String f5172II0xO0 = "install_referrer";

    /* renamed from: oxoX, reason: collision with root package name */
    public static final String f5173oxoX = "install_begin_timestamp_seconds";

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Bundle f5174oIX0oI;

    public ReferrerDetails(Bundle bundle) {
        this.f5174oIX0oI = bundle;
    }

    public long I0Io() {
        return this.f5174oIX0oI.getLong(f5171I0Io);
    }

    public String II0xO0() {
        return this.f5174oIX0oI.getString(f5172II0xO0);
    }

    public long oIX0oI() {
        return this.f5174oIX0oI.getLong(f5173oxoX);
    }
}
