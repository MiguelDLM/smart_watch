package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XIxoOo0oI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13860II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13861OOXIXo = 3;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f13862oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13863oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f13864ooOOo0oXI = 6;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f13865x0XOIxOo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13866xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13867xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("video_clip", 187);
        f13862oO = oixoxx0;
        Profile.Type type = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("clip_number", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type2 = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("start_timestamp", 1, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("start_timestamp_ms", 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("end_timestamp", 3, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("end_timestamp_ms", 4, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type3 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("clip_start", 6, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("clip_end", 7, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, type3));
    }

    public XIxoOo0oI() {
        super(x0OxxIOxX.XO(187));
    }

    public void O00(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(3, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void O0xxXxI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(1, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void OIx00oxx(Long l) {
        X0xxXX0(7, 0, l, 65535);
    }

    public o0xxxXXxX OO0() {
        return oXX0IoI(x0xO(1, 0, 65535));
    }

    public Integer OX() {
        return oX(0, 0, 65535);
    }

    public Integer OooI() {
        return oX(2, 0, 65535);
    }

    public Long Oxx() {
        return x0xO(7, 0, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(4, 0, 65535);
    }

    public o0xxxXXxX o0IXXIx() {
        return oXX0IoI(x0xO(3, 0, 65535));
    }

    public Long oXIoO() {
        return x0xO(6, 0, 65535);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void xIXX(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void xOOxIO(Integer num) {
        X0xxXX0(4, 0, num, 65535);
    }

    public void xxxI(Long l) {
        X0xxXX0(6, 0, l, 65535);
    }

    public XIxoOo0oI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
