package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class IOo0 extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f11641II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f11642OOXIXo = 4;

    /* renamed from: Oo, reason: collision with root package name */
    public static final oIXoXx0 f11643Oo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f11644oO = 10;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f11645oOoXoXO = 7;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f11646ooOOo0oXI = 8;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f11647x0XOIxOo = 9;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f11648x0xO0oo = 11;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f11649xoIox = 3;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f11650xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("segment_file", 151);
        f11643Oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.STRING;
        oixoxx0.xxIXOIIO(new X0xII0I("file_uuid", 1, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("enabled", 3, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BOOL));
        Profile.Type type2 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("user_profile_primary_key", 4, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("leader_type", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SEGMENT_LEADERBOARD_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("leader_group_primary_key", 8, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("leader_activity_id", 9, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("leader_activity_id_string", 10, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("default_race_leader", 11, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
    }

    public IOo0() {
        super(x0OxxIOxX.XO(151));
    }

    public int IxX00() {
        return oOoIIO0(8, 65535);
    }

    public SegmentLeaderboardType[] O00() {
        Short[] xoO0xx02 = xoO0xx0(7, 65535);
        SegmentLeaderboardType[] segmentLeaderboardTypeArr = new SegmentLeaderboardType[xoO0xx02.length];
        for (int i = 0; i < xoO0xx02.length; i++) {
            segmentLeaderboardTypeArr[i] = SegmentLeaderboardType.getByValue(xoO0xx02[i]);
        }
        return segmentLeaderboardTypeArr;
    }

    public int O0xxXxI() {
        return oOoIIO0(9, 65535);
    }

    public Long OIx00oxx(int i) {
        return x0xO(8, i, 65535);
    }

    public String OO0(int i) {
        return XIXIX(10, i, 65535);
    }

    public void OOOI(int i, Long l) {
        X0xxXX0(8, i, l, 65535);
    }

    public Bool OX() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public String[] OooI() {
        return xOoOIoI(10, 65535);
    }

    public void OxO(Long l) {
        X0xxXX0(4, 0, l, 65535);
    }

    public void OxXXx0X(int i, String str) {
        X0xxXX0(10, i, str, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(11, 0, 65535);
    }

    public void X0O0I0(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public int XO0o() {
        return oOoIIO0(7, 65535);
    }

    public Long[] XoIxOXIXo() {
        return XX0xXo(9, 65535);
    }

    public Long o0IXXIx(int i) {
        return x0xO(9, i, 65535);
    }

    public void o0oxo0oI(int i, SegmentLeaderboardType segmentLeaderboardType) {
        X0xxXX0(7, i, Short.valueOf(segmentLeaderboardType.value), 65535);
    }

    public Long oX0I0O() {
        return x0xO(4, 0, 65535);
    }

    public void oX0ooo0I0(String str) {
        X0xxXX0(1, 0, str, 65535);
    }

    public String oXIoO() {
        return XIXIX(1, 0, 65535);
    }

    public void oo00(int i, Long l) {
        X0xxXX0(9, i, l, 65535);
    }

    public int oxOXxoXII() {
        return oOoIIO0(10, 65535);
    }

    public void x00IOx(Short sh) {
        X0xxXX0(11, 0, sh, 65535);
    }

    public Long[] xIXX() {
        return XX0xXo(8, 65535);
    }

    public Integer xOOxIO() {
        return oX(254, 0, 65535);
    }

    public void xX(Bool bool) {
        X0xxXX0(3, 0, Short.valueOf(bool.value), 65535);
    }

    public SegmentLeaderboardType xxxI(int i) {
        Short XI0oooXX2 = XI0oooXX(7, i, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SegmentLeaderboardType.getByValue(XI0oooXX2);
    }

    public IOo0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
