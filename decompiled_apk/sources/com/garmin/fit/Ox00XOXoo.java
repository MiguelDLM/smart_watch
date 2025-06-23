package com.garmin.fit;

import com.garmin.fit.Profile;
import com.huawei.hms.ads.jsb.constant.Constant;

/* loaded from: classes9.dex */
public class Ox00XOXoo extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12894II0XooXoX = 0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12895OOXIXo = 3;

    /* renamed from: Oo, reason: collision with root package name */
    public static final oIXoXx0 f12896Oo;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12897oO = 7;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12898oOoXoXO = 4;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12899ooOOo0oXI = 5;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12900x0XOIxOo = 6;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f12901x0xO0oo = 8;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12902xoIox = 2;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12903xxIXOIIO = 1;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("segment_id", 148);
        f12896Oo = oixoxx0;
        Profile.Type type = Profile.Type.STRING;
        oixoxx0.xxIXOIIO(new X0xII0I("name", 0, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(Constant.MAP_KEY_UUID, 1, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("sport", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SPORT));
        oixoxx0.xxIXOIIO(new X0xII0I("enabled", 3, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BOOL));
        Profile.Type type2 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("user_profile_primary_key", 4, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("device_id", 5, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("default_race_leader", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
        oixoxx0.xxIXOIIO(new X0xII0I("delete_status", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SEGMENT_DELETE_STATUS));
        oixoxx0.xxIXOIIO(new X0xII0I("selection_type", 8, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SEGMENT_SELECTION_TYPE));
    }

    public Ox00XOXoo() {
        super(x0OxxIOxX.XO(148));
    }

    public void IxX00(Sport sport) {
        X0xxXX0(2, 0, Short.valueOf(sport.value), 65535);
    }

    public void O00(Long l) {
        X0xxXX0(5, 0, l, 65535);
    }

    public void O0xxXxI(String str) {
        X0xxXX0(0, 0, str, 65535);
    }

    public String OIx00oxx() {
        return XIXIX(1, 0, 65535);
    }

    public Sport OO0() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Sport.getByValue(XI0oooXX2);
    }

    public SegmentDeleteStatus OX() {
        Short XI0oooXX2 = XI0oooXX(7, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SegmentDeleteStatus.getByValue(XI0oooXX2);
    }

    public Long OooI() {
        return x0xO(4, 0, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(6, 0, 65535);
    }

    public void XO0o(Long l) {
        X0xxXX0(4, 0, l, 65535);
    }

    public SegmentSelectionType XoIxOXIXo() {
        Short XI0oooXX2 = XI0oooXX(8, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SegmentSelectionType.getByValue(XI0oooXX2);
    }

    public Bool o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Bool.getByValue(XI0oooXX2);
    }

    public void oX0I0O(String str) {
        X0xxXX0(1, 0, str, 65535);
    }

    public Long oXIoO() {
        return x0xO(5, 0, 65535);
    }

    public void oxOXxoXII(SegmentSelectionType segmentSelectionType) {
        X0xxXX0(8, 0, Short.valueOf(segmentSelectionType.value), 65535);
    }

    @Override // com.garmin.fit.oIXoXx0
    public String x0OIX00oO() {
        return XIXIX(0, 0, 65535);
    }

    public void xIXX(Short sh) {
        X0xxXX0(6, 0, sh, 65535);
    }

    public void xOOxIO(Bool bool) {
        X0xxXX0(3, 0, Short.valueOf(bool.value), 65535);
    }

    public void xxxI(SegmentDeleteStatus segmentDeleteStatus) {
        X0xxXX0(7, 0, Short.valueOf(segmentDeleteStatus.value), 65535);
    }

    public Ox00XOXoo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
