package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XOxIOxOx extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13911II0XooXoX = 253;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13912OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13913oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f13914ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13915xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13916xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("camera_event", 161);
        f13914ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp_ms", 0, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "ms", false, Profile.Type.UINT16));
        oixoxx0.xxIXOIIO(new X0xII0I("camera_event_type", 1, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.CAMERA_EVENT_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("camera_file_uuid", 2, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.STRING));
        oixoxx0.xxIXOIIO(new X0xII0I("camera_orientation", 3, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.CAMERA_ORIENTATION_TYPE));
    }

    public XOxIOxOx() {
        super(x0OxxIOxX.XO(161));
    }

    public void OIx00oxx(Integer num) {
        X0xxXX0(0, 0, num, 65535);
    }

    public void OO0(String str) {
        X0xxXX0(2, 0, str, 65535);
    }

    public String OX() {
        return XIXIX(2, 0, 65535);
    }

    public void OooI(CameraOrientationType cameraOrientationType) {
        X0xxXX0(3, 0, Short.valueOf(cameraOrientationType.value), 65535);
    }

    public CameraEventType Oxx() {
        Short XI0oooXX2 = XI0oooXX(1, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return CameraEventType.getByValue(XI0oooXX2);
    }

    public void XoIxOXIXo(CameraEventType cameraEventType) {
        X0xxXX0(1, 0, Short.valueOf(cameraEventType.value), 65535);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Integer o0IXXIx() {
        return oX(0, 0, 65535);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public CameraOrientationType oXIoO() {
        Short XI0oooXX2 = XI0oooXX(3, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return CameraOrientationType.getByValue(XI0oooXX2);
    }

    public XOxIOxOx(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
