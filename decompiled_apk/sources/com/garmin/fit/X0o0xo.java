package com.garmin.fit;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class X0o0xo extends oIXoXx0 implements XIxO {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13514II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13515OOXIXo = 2;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f13516oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13517oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f13518ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f13519x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final oIXoXx0 f13520x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13521xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13522xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0(TTDownloadField.TT_ACTIVITY, 34);
        f13520x0xO0oo = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("total_timer_time", 0, 134, 1000.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("num_sessions", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("type", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ACTIVITY));
        oixoxx0.xxIXOIIO(new X0xII0I(NotificationCompat.CATEGORY_EVENT, 3, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT));
        oixoxx0.xxIXOIIO(new X0xII0I("event_type", 4, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.EVENT_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("local_timestamp", 5, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.LOCAL_DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("event_group", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8));
    }

    public X0o0xo() {
        super(x0OxxIOxX.XO(34));
    }

    @Override // com.garmin.fit.XIxO
    public Short I0Io() {
        return XI0oooXX(6, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public Event II0xO0() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Event.getByValue(XI0oooXX2);
    }

    public void OIx00oxx(Activity activity) {
        X0xxXX0(2, 0, Short.valueOf(activity.value), 65535);
    }

    public void OO0(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public Integer OX() {
        return oX(1, 0, 65535);
    }

    public void OooI(Float f) {
        X0xxXX0(0, 0, f, 65535);
    }

    public Long Oxx() {
        return x0xO(5, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void Oxx0IOOO(Short sh) {
        X0xxXX0(6, 0, sh, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public EventType X0o0xo() {
        Short XI0oooXX2 = XI0oooXX(4, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return EventType.getByValue(XI0oooXX2);
    }

    @Override // com.garmin.fit.XIxO
    public void XO(EventType eventType) {
        X0xxXX0(4, 0, Short.valueOf(eventType.value), 65535);
    }

    public void XoIxOXIXo(Long l) {
        X0xxXX0(5, 0, l, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Activity o0IXXIx() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return Activity.getByValue(XI0oooXX2);
    }

    @Override // com.garmin.fit.XIxO
    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public Float oXIoO() {
        return XX(0, 0, 65535);
    }

    @Override // com.garmin.fit.XIxO
    public void oxoX(Event event) {
        X0xxXX0(3, 0, Short.valueOf(event.value), 65535);
    }

    public X0o0xo(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
