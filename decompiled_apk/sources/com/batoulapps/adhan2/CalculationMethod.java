package com.batoulapps.adhan2;

import OXOo.OOXIXo;
import com.batoulapps.adhan2.model.Rounding;
import com.sma.smartv3.ble.ProductManager;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class CalculationMethod {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ CalculationMethod[] $VALUES;
    public static final CalculationMethod MUSLIM_WORLD_LEAGUE = new CalculationMethod("MUSLIM_WORLD_LEAGUE", 0);
    public static final CalculationMethod EGYPTIAN = new CalculationMethod("EGYPTIAN", 1);
    public static final CalculationMethod KARACHI = new CalculationMethod("KARACHI", 2);
    public static final CalculationMethod UMM_AL_QURA = new CalculationMethod("UMM_AL_QURA", 3);
    public static final CalculationMethod DUBAI = new CalculationMethod(ProductManager.f20389O0, 4);
    public static final CalculationMethod MOON_SIGHTING_COMMITTEE = new CalculationMethod("MOON_SIGHTING_COMMITTEE", 5);
    public static final CalculationMethod NORTH_AMERICA = new CalculationMethod("NORTH_AMERICA", 6);
    public static final CalculationMethod KUWAIT = new CalculationMethod("KUWAIT", 7);
    public static final CalculationMethod QATAR = new CalculationMethod("QATAR", 8);
    public static final CalculationMethod SINGAPORE = new CalculationMethod("SINGAPORE", 9);
    public static final CalculationMethod TURKEY = new CalculationMethod("TURKEY", 10);
    public static final CalculationMethod OTHER = new CalculationMethod(oOoIIO0.oIX0oI.f32055oI0IIXIo, 11);

    /* loaded from: classes8.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f10289oIX0oI;

        static {
            int[] iArr = new int[CalculationMethod.values().length];
            try {
                iArr[CalculationMethod.MUSLIM_WORLD_LEAGUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CalculationMethod.EGYPTIAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CalculationMethod.KARACHI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CalculationMethod.UMM_AL_QURA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CalculationMethod.DUBAI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CalculationMethod.MOON_SIGHTING_COMMITTEE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CalculationMethod.NORTH_AMERICA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CalculationMethod.KUWAIT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[CalculationMethod.QATAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[CalculationMethod.SINGAPORE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[CalculationMethod.TURKEY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[CalculationMethod.OTHER.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            f10289oIX0oI = iArr;
        }
    }

    private static final /* synthetic */ CalculationMethod[] $values() {
        return new CalculationMethod[]{MUSLIM_WORLD_LEAGUE, EGYPTIAN, KARACHI, UMM_AL_QURA, DUBAI, MOON_SIGHTING_COMMITTEE, NORTH_AMERICA, KUWAIT, QATAR, SINGAPORE, TURKEY, OTHER};
    }

    static {
        CalculationMethod[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private CalculationMethod(String str, int i) {
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<CalculationMethod> getEntries() {
        return $ENTRIES;
    }

    public static CalculationMethod valueOf(String str) {
        return (CalculationMethod) Enum.valueOf(CalculationMethod.class, str);
    }

    public static CalculationMethod[] values() {
        return (CalculationMethod[]) $VALUES.clone();
    }

    @OOXIXo
    public final com.batoulapps.adhan2.oIX0oI getParameters() {
        switch (oIX0oI.f10289oIX0oI[ordinal()]) {
            case 1:
                return new com.batoulapps.adhan2.oIX0oI(18.0d, 17.0d, 0, this, null, null, null, new ooXIXxIX.I0Io(0, 0, 1, 0, 0, 0, 59, null), null, null, 884, null);
            case 2:
                return new com.batoulapps.adhan2.oIX0oI(19.5d, 17.5d, 0, this, null, null, null, new ooXIXxIX.I0Io(0, 0, 1, 0, 0, 0, 59, null), null, null, 884, null);
            case 3:
                return new com.batoulapps.adhan2.oIX0oI(18.0d, 18.0d, 0, this, null, null, null, new ooXIXxIX.I0Io(0, 0, 1, 0, 0, 0, 59, null), null, null, 884, null);
            case 4:
                return new com.batoulapps.adhan2.oIX0oI(18.5d, XIXIX.OOXIXo.f3760XO, 90, this, null, null, null, null, null, null, 1010, null);
            case 5:
                return new com.batoulapps.adhan2.oIX0oI(18.2d, 18.2d, 0, this, null, null, null, new ooXIXxIX.I0Io(0, -3, 3, 3, 3, 0, 33, null), null, null, 884, null);
            case 6:
                return new com.batoulapps.adhan2.oIX0oI(18.0d, 18.0d, 0, this, null, null, null, new ooXIXxIX.I0Io(0, 0, 5, 0, 3, 0, 43, null), null, null, 884, null);
            case 7:
                return new com.batoulapps.adhan2.oIX0oI(15.0d, 15.0d, 0, this, null, null, null, new ooXIXxIX.I0Io(0, 0, 1, 0, 0, 0, 59, null), null, null, 884, null);
            case 8:
                return new com.batoulapps.adhan2.oIX0oI(18.0d, 17.5d, 0, this, null, null, null, null, null, null, 1012, null);
            case 9:
                return new com.batoulapps.adhan2.oIX0oI(18.0d, XIXIX.OOXIXo.f3760XO, 90, this, null, null, null, null, null, null, 1010, null);
            case 10:
                return new com.batoulapps.adhan2.oIX0oI(20.0d, 18.0d, 0, this, null, null, null, new ooXIXxIX.I0Io(0, 0, 1, 0, 0, 0, 59, null), Rounding.UP, null, 628, null);
            case 11:
                return new com.batoulapps.adhan2.oIX0oI(18.0d, 17.0d, 0, this, null, null, null, new ooXIXxIX.I0Io(0, -7, 5, 4, 7, 0, 33, null), null, null, 884, null);
            case 12:
                return new com.batoulapps.adhan2.oIX0oI(XIXIX.OOXIXo.f3760XO, XIXIX.OOXIXo.f3760XO, 0, this, null, null, null, null, null, null, 1012, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
