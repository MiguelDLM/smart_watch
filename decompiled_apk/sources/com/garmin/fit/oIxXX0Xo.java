package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class oIxXX0Xo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14442II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final oIXoXx0 f14443OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14444xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14445xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("video_frame", 169);
        f14443OOXIXo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("frame_number", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32));
    }

    public oIxXX0Xo() {
        super(x0OxxIOxX.XO(169));
    }

    public Integer OX() {
        return oX(0, 0, 65535);
    }

    public Long Oxx() {
        return x0xO(1, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public void o0IXXIx(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oXIoO(Long l) {
        X0xxXX0(1, 0, l, 65535);
    }

    public oIxXX0Xo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
