package com.garmin.fit;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public class o0I0O0oXX {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f14221I0Io = 2;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f14222II0XooXoX = 7;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f14223II0xO0 = 1;

    /* renamed from: IIX0o, reason: collision with root package name */
    public static final Map<Integer, String> f14224IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f14225IIXOooo = 21;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f14226IXxxXO = 17;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f14227O0xOxO = 25;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final int f14228OOXIXo = 10;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f14229Oo = 16;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f14230OxI = 24;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f14231Oxx0IOOO = 6;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f14232Oxx0xo = 18;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f14233OxxIIOOXO = 20;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f14234X0IIOO = 26;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f14235X0o0xo = 4;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final int f14236XI0IXoo = 27;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f14237XIxXXX0x0 = 28;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f14238XO = 5;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public static final int f14239XxX0x0xxx = 30;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f14240o00 = 23;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f14241oI0IIXIo = 19;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f14242oIX0oI = 0;

    /* renamed from: oO, reason: collision with root package name */
    public static final int f14243oO = 14;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f14244oOoXoXO = 11;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final int f14245ooOOo0oXI = 12;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f14246oxoX = 3;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final int f14247x0XOIxOo = 13;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f14248x0xO0oo = 15;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public static final int f14249xXxxox0I = Fit.f11195Xo0.intValue();

    /* renamed from: xoIox, reason: collision with root package name */
    public static final int f14250xoIox = 9;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f14251xoXoI = 22;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final int f14252xxIXOIIO = 8;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f14253xxX = 29;

    static {
        HashMap hashMap = new HashMap();
        f14224IIX0o = hashMap;
        hashMap.put(0, "QUADRUPED_ROCKING");
        hashMap.put(1, "NECK_TILTS");
        hashMap.put(2, "ANKLE_CIRCLES");
        hashMap.put(3, "ANKLE_DORSIFLEXION_WITH_BAND");
        hashMap.put(4, "ANKLE_INTERNAL_ROTATION");
        hashMap.put(5, "ARM_CIRCLES");
        hashMap.put(6, "BENT_OVER_REACH_TO_SKY");
        hashMap.put(7, "CAT_CAMEL");
        hashMap.put(8, "ELBOW_TO_FOOT_LUNGE");
        hashMap.put(9, "FORWARD_AND_BACKWARD_LEG_SWINGS");
        hashMap.put(10, "GROINERS");
        hashMap.put(11, "INVERTED_HAMSTRING_STRETCH");
        hashMap.put(12, "LATERAL_DUCK_UNDER");
        hashMap.put(13, "NECK_ROTATIONS");
        hashMap.put(14, "OPPOSITE_ARM_AND_LEG_BALANCE");
        hashMap.put(15, "REACH_ROLL_AND_LIFT");
        hashMap.put(16, "SCORPION");
        hashMap.put(17, "SHOULDER_CIRCLES");
        hashMap.put(18, "SIDE_TO_SIDE_LEG_SWINGS");
        hashMap.put(19, "SLEEPER_STRETCH");
        hashMap.put(20, "SLIDE_OUT");
        hashMap.put(21, "SWISS_BALL_HIP_CROSSOVER");
        hashMap.put(22, "SWISS_BALL_REACH_ROLL_AND_LIFT");
        hashMap.put(23, "SWISS_BALL_WINDSHIELD_WIPERS");
        hashMap.put(24, "THORACIC_ROTATION");
        hashMap.put(25, "WALKING_HIGH_KICKS");
        hashMap.put(26, "WALKING_HIGH_KNEES");
        hashMap.put(27, "WALKING_KNEE_HUGS");
        hashMap.put(28, "WALKING_LEG_CRADLES");
        hashMap.put(29, "WALKOUT");
        hashMap.put(30, "WALKOUT_FROM_PUSH_UP_POSITION");
    }

    public static Integer II0xO0(String str) {
        for (Map.Entry<Integer, String> entry : f14224IIX0o.entrySet()) {
            if (entry.getValue().equals(str)) {
                return entry.getKey();
            }
        }
        return Integer.valueOf(f14249xXxxox0I);
    }

    public static String oIX0oI(Integer num) {
        Map<Integer, String> map = f14224IIX0o;
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return "";
    }
}
