package com.garmin.fit;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.ar.constants.HttpConstants;
import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class XIXIX extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f13807II0XooXoX = 253;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f13808IIXOooo = 21;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f13809IXxxXO = 11;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f13810O0xOxO = 32;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f13811OOXIXo = 2;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f13812Oo = 10;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f13813OxI = 27;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f13814Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f13815OxxIIOOXO = 20;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final oIXoXx0 f13816X0IIOO;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f13817o00 = 25;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f13818oI0IIXIo = 19;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f13819oO = 6;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f13820oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f13821ooOOo0oXI = 4;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f13822x0XOIxOo = 5;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f13823x0xO0oo = 7;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f13824xoIox = 1;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f13825xoXoI = 22;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f13826xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("device_info", 23);
        f13816X0IIOO = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("timestamp", 253, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.DATE_TIME));
        oixoxx0.xxIXOIIO(new X0xII0I("device_index", 0, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.DEVICE_INDEX));
        Profile.Type type = Profile.Type.UINT8;
        oixoxx0.xxIXOIIO(new X0xII0I(HttpConstants.DEVICE_TYPE, 1, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("ble_device_type", 2, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(0).II0xO0(25, 3L);
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("antplus_device_type", 2, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(1).II0xO0(25, 1L);
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("ant_device_type", 2, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(2).II0xO0(25, 0L);
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.add(new xxOoXO("local_device_type", 2, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(2).f13530OOXIXo.get(3).II0xO0(25, 5L);
        oixoxx0.xxIXOIIO(new X0xII0I(HttpConstants.HTTP_MANUFACTURER, 2, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MANUFACTURER));
        oixoxx0.xxIXOIIO(new X0xII0I("serial_number", 3, 140, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT32Z));
        Profile.Type type2 = Profile.Type.UINT16;
        oixoxx0.xxIXOIIO(new X0xII0I("product", 4, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.f14429oxoX.get(5).f13530OOXIXo.add(new xxOoXO("favero_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(5).f13530OOXIXo.get(0).II0xO0(2, 263L);
        oixoxx0.f14429oxoX.get(5).f13530OOXIXo.add(new xxOoXO("garmin_product", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(5).f13530OOXIXo.get(1).II0xO0(2, 1L);
        oixoxx0.f14429oxoX.get(5).f13530OOXIXo.get(1).II0xO0(2, 15L);
        oixoxx0.f14429oxoX.get(5).f13530OOXIXo.get(1).II0xO0(2, 13L);
        oixoxx0.f14429oxoX.get(5).f13530OOXIXo.get(1).II0xO0(2, 89L);
        oixoxx0.xxIXOIIO(new X0xII0I("software_version", 5, 132, 100.0d, XIXIX.OOXIXo.f3760XO, "", false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("hardware_version", 6, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type));
        oixoxx0.xxIXOIIO(new X0xII0I("cum_operating_time", 7, 134, 1.0d, XIXIX.OOXIXo.f3760XO, "s", false, Profile.Type.UINT32));
        oixoxx0.xxIXOIIO(new X0xII0I("battery_voltage", 10, 132, 256.0d, XIXIX.OOXIXo.f3760XO, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, false, type2));
        oixoxx0.xxIXOIIO(new X0xII0I("battery_status", 11, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BATTERY_STATUS));
        oixoxx0.xxIXOIIO(new X0xII0I("sensor_position", 18, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.BODY_LOCATION));
        Profile.Type type3 = Profile.Type.STRING;
        oixoxx0.xxIXOIIO(new X0xII0I("descriptor", 19, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("ant_transmission_type", 20, 10, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT8Z));
        oixoxx0.xxIXOIIO(new X0xII0I("ant_device_number", 21, 139, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16Z));
        oixoxx0.xxIXOIIO(new X0xII0I("ant_network", 22, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.ANT_NETWORK));
        oixoxx0.xxIXOIIO(new X0xII0I("source_type", 25, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.SOURCE_TYPE));
        oixoxx0.xxIXOIIO(new X0xII0I("product_name", 27, 7, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, type3));
        oixoxx0.xxIXOIIO(new X0xII0I("battery_level", 32, 2, 1.0d, XIXIX.OOXIXo.f3760XO, "%", false, type));
    }

    public XIXIX() {
        super(x0OxxIOxX.XO(23));
    }

    public void IIOIX(Short sh) {
        X0xxXX0(1, 0, sh, 3);
    }

    public void IxIo(Long l) {
        X0xxXX0(3, 0, l, 65535);
    }

    public Integer IxX00() {
        return oX(4, 0, 1);
    }

    public String O00() {
        return XIXIX(19, 0, 65535);
    }

    public Short O0xxXxI() {
        return XI0oooXX(1, 0, 65535);
    }

    public Float OIx00oxx() {
        return XX(10, 0, 65535);
    }

    public Short OO0() {
        return XI0oooXX(32, 0, 65535);
    }

    public void OOIXx0x(Long l) {
        X0xxXX0(7, 0, l, 65535);
    }

    public Float OOOI() {
        return XX(5, 0, 65535);
    }

    public void OOxOI(Short sh) {
        X0xxXX0(32, 0, sh, 65535);
    }

    public Short OX() {
        return XI0oooXX(1, 0, 2);
    }

    public void OXXoIoXI(Float f) {
        X0xxXX0(10, 0, f, 65535);
    }

    public Short OooI() {
        return XI0oooXX(11, 0, 65535);
    }

    public void OxO(Short sh) {
        X0xxXX0(1, 0, sh, 2);
    }

    public Long OxXXx0X() {
        return x0xO(3, 0, 65535);
    }

    public Integer Oxx() {
        return oX(21, 0, 65535);
    }

    public void X00xOoXI(Short sh) {
        X0xxXX0(1, 0, sh, 1);
    }

    public void X0O0I0(Integer num) {
        X0xxXX0(21, 0, num, 65535);
    }

    public void X0ooXIooI(Integer num) {
        X0xxXX0(4, 0, num, 65535);
    }

    public void XO00XOO(Short sh) {
        X0xxXX0(11, 0, sh, 65535);
    }

    public Short XO0o() {
        return XI0oooXX(6, 0, 65535);
    }

    public void XOxoX(SourceType sourceType) {
        X0xxXX0(25, 0, Short.valueOf(sourceType.value), 65535);
    }

    public void Xo(Integer num) {
        X0xxXX0(4, 0, num, 1);
    }

    public Short XoIxOXIXo() {
        return XI0oooXX(1, 0, 1);
    }

    public void XoOxI0ox(Integer num) {
        X0xxXX0(2, 0, num, 65535);
    }

    public void XooIO0oo0(Short sh) {
        X0xxXX0(1, 0, sh, 0);
    }

    public o0xxxXXxX getTimestamp() {
        return oXX0IoI(x0xO(253, 0, 65535));
    }

    public Short o0IXXIx() {
        return XI0oooXX(20, 0, 65535);
    }

    public void o0Xo(Short sh) {
        X0xxXX0(20, 0, sh, 65535);
    }

    public SourceType o0oxo0oI() {
        Short XI0oooXX2 = XI0oooXX(25, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return SourceType.getByValue(XI0oooXX2);
    }

    public void oIX0oI(o0xxxXXxX o0xxxxxxx) {
        X0xxXX0(253, 0, o0xxxxxxx.x0xO0oo(), 65535);
    }

    public void oX000x(String str) {
        X0xxXX0(27, 0, str, 65535);
    }

    public Short oX0I0O() {
        return XI0oooXX(1, 0, 3);
    }

    public String oX0ooo0I0() {
        return XIXIX(27, 0, 65535);
    }

    public AntNetwork oXIoO() {
        Short XI0oooXX2 = XI0oooXX(22, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return AntNetwork.getByValue(XI0oooXX2);
    }

    public void oXO0oOx0(Short sh) {
        X0xxXX0(6, 0, sh, 65535);
    }

    public void oXxx000(Short sh) {
        X0xxXX0(0, 0, sh, 65535);
    }

    public BodyLocation oo00() {
        Short XI0oooXX2 = XI0oooXX(18, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return BodyLocation.getByValue(XI0oooXX2);
    }

    public Integer oxOXxoXII() {
        return oX(4, 0, 0);
    }

    public Integer x00IOx() {
        return oX(2, 0, 65535);
    }

    public void x0oxIIIX(Float f) {
        X0xxXX0(5, 0, f, 65535);
    }

    public void xIOXX(BodyLocation bodyLocation) {
        X0xxXX0(18, 0, Short.valueOf(bodyLocation.value), 65535);
    }

    public Short xIXX() {
        return XI0oooXX(1, 0, 0);
    }

    public void xIx(Integer num) {
        X0xxXX0(4, 0, num, 0);
    }

    public void xIx0XO(String str) {
        X0xxXX0(19, 0, str, 65535);
    }

    public void xOOxI(Short sh) {
        X0xxXX0(1, 0, sh, 65535);
    }

    public Short xOOxIO() {
        return XI0oooXX(0, 0, 65535);
    }

    public Integer xX() {
        return oX(4, 0, 65535);
    }

    public void xxx00(AntNetwork antNetwork) {
        X0xxXX0(22, 0, Short.valueOf(antNetwork.value), 65535);
    }

    public Long xxxI() {
        return x0xO(7, 0, 65535);
    }

    public XIXIX(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
