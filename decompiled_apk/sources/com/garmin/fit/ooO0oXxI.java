package com.garmin.fit;

import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class ooO0oXxI extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14958II0XooXoX = 253;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final oIXoXx0 f14959IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14960OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14961Oo = 8;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14962oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14963oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14964ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14965x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14966x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14967xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14968xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("jump", 285);
        f14959IXxxXO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        Profile.Type type = Profile.Type.FLOAT32;
        oixoxx0.xxIXOIIO(new X0xII0I(xOxOoo.f15470o00, 0, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("height", 1, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "m", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("rotations", 2, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("hang_time", 3, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("score", 4, 136, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type2 = Profile.Type.SINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("position_lat", 5, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("position_long", 6, 133, 1.0d, XIXIX.OOXIXo.f3760XO, "semicircles", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I(RouteGuideParams.RGKey.AssistInfo.Speed, 7, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, Profile.Type.UINT16));
        oixoxx0.f14429oxoX.get(8).f13537xoIox.add(new oXX0IoI(8, false, 16, 1000.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_speed", 8, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, Profile.Type.UINT32));
    }

    public ooO0oXxI() {
        super(x0OxxIOxX.XO(285));
    }

    public void IxX00(Integer num) {
        X0xxXX0(6, 0, num, 65535);
    }

    public void O00(Float f) {
        X0xxXX0(8, 0, f, 65535);
    }

    public void O0xxXxI(Float f) {
        X0xxXX0(1, 0, f, 65535);
    }

    public Float OIx00oxx() {
        return XX(4, 0, 65535);
    }

    public Integer OO0() {
        return oX(6, 0, 65535);
    }

    public Float OX() {
        return XX(8, 0, 65535);
    }

    public Short OooI() {
        return XI0oooXX(2, 0, 65535);
    }

    public Float Oxx() {
        return XX(0, 0, 65535);
    }

    public void XO0o(Short sh) {
        X0xxXX0(2, 0, sh, 65535);
    }

    public Integer XoIxOXIXo() {
        return oX(5, 0, 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o0IXXIx() {
        return XX(1, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX0I0O(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public Float oXIoO() {
        return XX(3, 0, 65535);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(5, 0, num, 65535);
    }

    public void x00IOx(Float f) {
        X0xxXX0(7, 0, f, 65535);
    }

    public Float xIXX() {
        return XX(7, 0, 65535);
    }

    public void xOOxIO(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public void xxxI(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public ooO0oXxI(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
