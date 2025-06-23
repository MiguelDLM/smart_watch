package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class x0XOIxOo {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final short f15206I0Io = 12;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final short f15207II0XooXoX = 19;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final short f15208II0xO0 = 11;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final short f15209IIXOooo = 121;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final short f15210IXxxXO = 40;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final short f15211O0xOxO = Fit.f11224oxxXoxO.shortValue();

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final short f15212OOXIXo = 26;

    /* renamed from: Oo, reason: collision with root package name */
    public static final short f15213Oo = 38;

    /* renamed from: OxI, reason: collision with root package name */
    public static final short f15214OxI = 124;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final short f15215Oxx0IOOO = 18;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final short f15216Oxx0xo = 46;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final short f15217OxxIIOOXO = 120;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final Map<Short, String> f15218X0IIOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final short f15219X0o0xo = 16;

    /* renamed from: XO, reason: collision with root package name */
    public static final short f15220XO = 17;

    /* renamed from: o00, reason: collision with root package name */
    public static final short f15221o00 = 123;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final short f15222oI0IIXIo = 119;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final short f15223oIX0oI = 1;

    /* renamed from: oO, reason: collision with root package name */
    public static final short f15224oO = 35;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final short f15225oOoXoXO = 27;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final short f15226ooOOo0oXI = 31;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final short f15227oxoX = 15;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final short f15228x0XOIxOo = 34;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final short f15229x0xO0oo = 36;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final short f15230xoIox = 25;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final short f15231xoXoI = 122;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final short f15232xxIXOIIO = 20;

    static {
        HashMap hashMap = new HashMap();
        f15218X0IIOO = hashMap;
        hashMap.put((short) 1, "ANTFS");
        hashMap.put((short) 11, "BIKE_POWER");
        hashMap.put((short) 12, "ENVIRONMENT_SENSOR_LEGACY");
        hashMap.put((short) 15, "MULTI_SPORT_SPEED_DISTANCE");
        hashMap.put((short) 16, "CONTROL");
        hashMap.put((short) 17, "FITNESS_EQUIPMENT");
        hashMap.put((short) 18, "BLOOD_PRESSURE");
        hashMap.put((short) 19, "GEOCACHE_NODE");
        hashMap.put((short) 20, "LIGHT_ELECTRIC_VEHICLE");
        hashMap.put((short) 25, "ENV_SENSOR");
        hashMap.put((short) 26, "RACQUET");
        hashMap.put((short) 27, "CONTROL_HUB");
        hashMap.put((short) 31, "MUSCLE_OXYGEN");
        hashMap.put((short) 34, "SHIFTING");
        hashMap.put((short) 35, "BIKE_LIGHT_MAIN");
        hashMap.put((short) 36, "BIKE_LIGHT_SHARED");
        hashMap.put((short) 38, "EXD");
        hashMap.put((short) 40, "BIKE_RADAR");
        hashMap.put((short) 46, "BIKE_AERO");
        hashMap.put(Short.valueOf(f15222oI0IIXIo), "WEIGHT_SCALE");
        hashMap.put(Short.valueOf(f15217OxxIIOOXO), "HEART_RATE");
        hashMap.put(Short.valueOf(f15209IIXOooo), "BIKE_SPEED_CADENCE");
        hashMap.put(Short.valueOf(f15231xoXoI), "BIKE_CADENCE");
        hashMap.put(Short.valueOf(f15221o00), "BIKE_SPEED");
        hashMap.put(Short.valueOf(f15214OxI), "STRIDE_SPEED_DISTANCE");
    }

    public static Short II0xO0(String str) {
        for (Map.Entry<Short, String> entry : f15218X0IIOO.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Short.valueOf(f15211O0xOxO);
    }

    public static String oIX0oI(Short sh) {
        Map<Short, String> map = f15218X0IIOO;
        if (map.containsKey(sh)) {
            return map.get(sh);
        }
        return "";
    }
}
