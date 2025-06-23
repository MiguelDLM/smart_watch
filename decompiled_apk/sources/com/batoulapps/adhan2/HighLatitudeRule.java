package com.batoulapps.adhan2;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class HighLatitudeRule {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ HighLatitudeRule[] $VALUES;

    @OOXIXo
    public static final oIX0oI Companion;
    public static final HighLatitudeRule MIDDLE_OF_THE_NIGHT = new HighLatitudeRule("MIDDLE_OF_THE_NIGHT", 0);
    public static final HighLatitudeRule SEVENTH_OF_THE_NIGHT = new HighLatitudeRule("SEVENTH_OF_THE_NIGHT", 1);
    public static final HighLatitudeRule TWILIGHT_ANGLE = new HighLatitudeRule("TWILIGHT_ANGLE", 2);

    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final HighLatitudeRule oIX0oI(@OOXIXo ooXIXxIX.II0xO0 coordinates) {
            IIX0o.x0xO0oo(coordinates, "coordinates");
            if (coordinates.oIX0oI() > 48.0d) {
                return HighLatitudeRule.SEVENTH_OF_THE_NIGHT;
            }
            return HighLatitudeRule.MIDDLE_OF_THE_NIGHT;
        }

        public oIX0oI() {
        }
    }

    private static final /* synthetic */ HighLatitudeRule[] $values() {
        return new HighLatitudeRule[]{MIDDLE_OF_THE_NIGHT, SEVENTH_OF_THE_NIGHT, TWILIGHT_ANGLE};
    }

    static {
        HighLatitudeRule[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new oIX0oI(null);
    }

    private HighLatitudeRule(String str, int i) {
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<HighLatitudeRule> getEntries() {
        return $ENTRIES;
    }

    public static HighLatitudeRule valueOf(String str) {
        return (HighLatitudeRule) Enum.valueOf(HighLatitudeRule.class, str);
    }

    public static HighLatitudeRule[] values() {
        return (HighLatitudeRule[]) $VALUES.clone();
    }
}
