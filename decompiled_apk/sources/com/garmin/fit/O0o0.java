package com.garmin.fit;

import androidx.core.app.NotificationCompat;
import com.garmin.fit.Profile;
import com.sma.smartv3.network.BaiDu;

/* loaded from: classes9.dex */
public class O0o0 extends oIXoXx0 implements XIxO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f12383II0XooXoX = 254;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f12384IIXOooo = 18;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f12385IXxxXO = 9;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f12386O0xOxO = 22;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f12387OOXIXo = 1;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f12388Oo = 7;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f12389OxI = 21;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f12390Oxx0xo = 10;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f12391OxxIIOOXO = 12;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f12392X0IIOO = 23;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f12393XI0IXoo = 24;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f12394XIxXXX0x0 = 25;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f12395o00 = 20;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f12396oI0IIXIo = 11;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f12397oO = 5;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f12398oOoXoXO = 2;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f12399ooOOo0oXI = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f12400x0XOIxOo = 4;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f12401x0xO0oo = 6;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f12402xoIox = 0;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f12403xoXoI = 19;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f12404xxIXOIIO = 253;

    /* renamed from: xxX, reason: collision with root package name */
    public static final oIXoXx0 f12405xxX;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("length", 101);
        f12405xxX = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        Profile.Type type = Profile.Type.DATE_TIME;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I(NotificationCompat.CATEGORY_EVENT, 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT));
        oixoxx0.xxIXOIIO(new X0xII0I("event_type", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I(BaiDu.START_TIME, 2, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        Profile.Type type2 = Profile.Type.UINT32;
        oixoxx0.xxIXOIIO(new X0xII0I("total_elapsed_time", 3, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("total_timer_time", 4, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, type2));
        Profile.Type type3 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("total_strokes", 5, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "strokes", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_speed", 6, 132, 1000.0d, XIXIX.OOXIXo.f3760XO, "m/s", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("swim_stroke", 7, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "swim_stroke", false, Profile.Type.SWIM_STROKE));
        Profile.Type type4 = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I("avg_swimming_cadence", 9, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "strokes/min", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("event_group", 10, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.xxIXOIIO(new X0xII0I("total_calories", 11, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "kcal", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("length_type", 12, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LENGTH_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("player_score", 18, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("opponent_score", 19, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("stroke_count", 20, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("zone_count", 21, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "counts", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_avg_respiration_rate", 22, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "Breaths/min", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("enhanced_max_respiration_rate", 23, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "Breaths/min", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("avg_respiration_rate", 24, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.f14429oxoX.get(20).f13537xoIox.add(new oXX0IoI(22, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
        oixoxx0.xxIXOIIO(new X0xII0I("max_respiration_rate", 25, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type4));
        oixoxx0.f14429oxoX.get(21).f13537xoIox.add(new oXX0IoI(23, false, 8, 1.0d, XIXIX.OOXIXo.f3760XO));
    }

    public O0o0() {
        super(x0OxxIOxX.XO(101));
    }

    @Override // com.garmin.fit.XIxO
    public Short I0Io() {
        return XI0oooXX(10, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public Event II0xO0() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Event.getByValue(XI0oooXX2);
    }

    public Integer[] IxX00() {
        return xoxXI(20, 65535);
    }

    public Integer O00() {
        return oX(19, 0, 65535);
    }

    public o0xxxXXxX O0xxXxI() {
        return oXX0IoI(x0xO(2, 0, 65535));
    }

    public Integer OIx00oxx() {
        return oX(254, 0, 65535);
    }

    public LengthType OO0() {
        Short XI0oooXX2 = XI0oooXX(12, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return LengthType.getByValue(XI0oooXX2);
    }

    public void OOIXx0x(int i, Integer num) {
        X0xxXX0(20, i, num, 65535);
    }

    public void OOOI(Short sh) {
        X0xxXX0(24, 0, sh, 65535);
    }

    public void OOxOI(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public Float OX() {
        return XX(6, 0, 65535);
    }

    public void OXXoIoXI(Integer num) {
        X0xxXX0(18, 0, num, 65535);
    }

    public Short OooI() {
        return XI0oooXX(25, 0, 65535);
    }

    public void OxO(Float f) {
        X0xxXX0(22, 0, f, 65535);
    }

    public Integer[] OxXXx0X() {
        return xoxXI(21, 65535);
    }

    public Short Oxx() {
        return XI0oooXX(24, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void Oxx0IOOO(Short sh) {
        X0xxXX0(10, 0, sh, 65535);
    }

    public void X00xOoXI(Short sh) {
        X0xxXX0(25, 0, sh, 65535);
    }

    public void X0O0I0(Short sh) {
        X0xxXX0(9, 0, sh, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public EventType X0o0xo() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return EventType.getByValue(XI0oooXX2);
    }

    @Override // com.garmin.fit.XIxO
    public void XO(EventType eventType) {
        X0xxXX0(1, 0, Short.valueOf(eventType.value), 65535);
    }

    public void XO00XOO(Integer num) {
        X0xxXX0(19, 0, num, 65535);
    }

    public SwimStroke XO0o() {
        Short XI0oooXX2 = XI0oooXX(7, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SwimStroke.getByValue(XI0oooXX2);
    }

    public void Xo(Float f) {
        X0xxXX0(4, 0, f, 65535);
    }

    public Float XoIxOXIXo() {
        return XX(23, 0, 65535);
    }

    public void XooIO0oo0(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(2, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    @Override // com.garmin.fit.XIxO
    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Float o0IXXIx() {
        return XX(22, 0, 65535);
    }

    public void o0Xo(LengthType lengthType) {
        X0xxXX0(12, 0, Short.valueOf(lengthType.value), 65535);
    }

    public void o0oxo0oI(Float f) {
        X0xxXX0(6, 0, f, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Integer oX0I0O() {
        return oX(11, 0, 65535);
    }

    public Float oX0ooo0I0() {
        return XX(4, 0, 65535);
    }

    public Short oXIoO() {
        return XI0oooXX(9, 0, 65535);
    }

    public void oXO0oOx0(int i, Integer num) {
        X0xxXX0(21, i, num, 65535);
    }

    public void oXxx000(Integer num) {
        X0xxXX0(11, 0, num, 65535);
    }

    public Integer oo00(int i) {
        return oX(21, i, 65535);
    }

    public Integer oxOXxoXII(int i) {
        return oX(20, i, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void oxoX(Event event) {
        X0xxXX0(0, 0, Short.valueOf(event.value), 65535);
    }

    public Float x00IOx() {
        return XX(3, 0, 65535);
    }

    public int xIXX() {
        return oOoIIO0(20, 65535);
    }

    public void xIx(Integer num) {
        X0xxXX0(5, 0, num, 65535);
    }

    public void xIx0XO(SwimStroke swimStroke) {
        X0xxXX0(7, 0, Short.valueOf(swimStroke.value), 65535);
    }

    public void xOOxI(Float f) {
        X0xxXX0(3, 0, f, 65535);
    }

    public Integer xOOxIO() {
        return oX(18, 0, 65535);
    }

    public Integer xX() {
        return oX(5, 0, 65535);
    }

    public void xxx00(Float f) {
        X0xxXX0(23, 0, f, 65535);
    }

    public int xxxI() {
        return oOoIIO0(21, 65535);
    }

    public O0o0(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
