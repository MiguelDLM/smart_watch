package com.garmin.fit;

import com.garmin.fit.Profile;

/* loaded from: classes9.dex */
public class xX0ox extends oIXoXx0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f15522II0XooXoX = 254;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f15523OOXIXo = 2;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f15524oOoXoXO = 3;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final oIXoXx0 f15525ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f15526xoIox = 1;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f15527xxIXOIIO = 0;

    static {
        oIXoXx0 oixoxx0 = new oIXoXx0("mesg_capabilities", 38);
        f15525ooOOo0oXI = oixoxx0;
        oixoxx0.xxIXOIIO(new X0xII0I("message_index", 254, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESSAGE_INDEX));
        oixoxx0.xxIXOIIO(new X0xII0I("file", 0, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.FILE));
        oixoxx0.xxIXOIIO(new X0xII0I("mesg_num", 1, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESG_NUM));
        oixoxx0.xxIXOIIO(new X0xII0I("count_type", 2, 0, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.MESG_COUNT));
        oixoxx0.xxIXOIIO(new X0xII0I("count", 3, 132, 1.0d, XIXIX.OOXIXo.f3760XO, "", false, Profile.Type.UINT16));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("num_per_file", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(0).II0xO0(2, 0L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("max_per_file", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(1).II0xO0(2, 1L);
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.add(new xxOoXO("max_per_file_type", 132, 1.0d, XIXIX.OOXIXo.f3760XO, ""));
        oixoxx0.f14429oxoX.get(4).f13530OOXIXo.get(2).II0xO0(2, 2L);
    }

    public xX0ox() {
        super(x0OxxIOxX.XO(38));
    }

    public void IxX00(Integer num) {
        X0xxXX0(254, 0, num, 65535);
    }

    public void O00(File file) {
        X0xxXX0(0, 0, Short.valueOf(file.value), 65535);
    }

    public void O0xxXxI(Integer num) {
        X0xxXX0(3, 0, num, 2);
    }

    public Integer OIx00oxx() {
        return oX(3, 0, 0);
    }

    public Integer OO0() {
        return oX(1, 0, 65535);
    }

    public MesgCount OX() {
        Short XI0oooXX2 = XI0oooXX(2, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return MesgCount.getByValue(XI0oooXX2);
    }

    public Integer OooI() {
        return oX(254, 0, 65535);
    }

    public Integer Oxx() {
        return oX(3, 0, 65535);
    }

    public void XO0o(Integer num) {
        X0xxXX0(3, 0, num, 0);
    }

    public Integer XoIxOXIXo() {
        return oX(3, 0, 2);
    }

    public Integer o0IXXIx() {
        return oX(3, 0, 1);
    }

    public File oXIoO() {
        Short XI0oooXX2 = XI0oooXX(0, 0, 65535);
        if (XI0oooXX2 == null) {
            return null;
        }
        return File.getByValue(XI0oooXX2);
    }

    public void oxOXxoXII(Integer num) {
        X0xxXX0(1, 0, num, 65535);
    }

    public void xIXX(Integer num) {
        X0xxXX0(3, 0, num, 65535);
    }

    public void xOOxIO(Integer num) {
        X0xxXX0(3, 0, num, 1);
    }

    public void xxxI(MesgCount mesgCount) {
        X0xxXX0(2, 0, Short.valueOf(mesgCount.value), 65535);
    }

    public xX0ox(oIXoXx0 oixoxx0) {
        super(oixoxx0);
    }
}
