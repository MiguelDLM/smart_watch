package com.garmin.fit;

import com.garmin.fit.Profile;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: classes9.dex */
public class OIxOIX0II extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12500II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12501OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final oIXoXx0 f12502oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12503oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12504ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12505x0XOIxOo = 5;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12506xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12507xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("segment_leaderboard_entry", 149);
        f12502oO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.STRING;
        oixoxx0.xxIXOIIO(new X0xII0I("name", 0, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("type", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SEGMENT_LEADERBOARD_TYPE));
        Profile.Type type2 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("group_primary_key", 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, 3, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("segment_time", 4, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("activity_id_string", 5, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
    }

    public OIxOIX0II() {
        super(x0OxxIOxX.XO(149));
    }

    public void O00(String str) {
        X0xxXX0(0, 0, str, 65535);
    }

    public void O0xxXxI(SegmentLeaderboardType segmentLeaderboardType) {
        X0xxXX0(1, 0, Short.valueOf(segmentLeaderboardType.value), 65535);
    }

    public void OIx00oxx(String str) {
        X0xxXX0(5, 0, str, 65535);
    }

    public SegmentLeaderboardType OO0() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SegmentLeaderboardType.getByValue(XI0oooXX2);
    }

    public String OX() {
        return XIXIX(5, 0, 65535);
    }

    public void OooI(Long l) {
        X0xxXX0(3, 0, l, 65535);
    }

    public Long Oxx() {
        return x0xO(3, 0, 65535);
    }

    public Float XoIxOXIXo() {
        return XX(4, 0, 65535);
    }

    public Integer o0IXXIx() {
        return oX(254, 0, 65535);
    }

    public Long oXIoO() {
        return x0xO(2, 0, 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(0, 0, 65535);
    }

    public void xIXX(Long l) {
        X0xxXX0(2, 0, l, 65535);
    }

    public void xOOxIO(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public void xxxI(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public OIxOIX0II(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
