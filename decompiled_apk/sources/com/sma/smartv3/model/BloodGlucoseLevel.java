package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.jvm.internal.IIXOooo;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class BloodGlucoseLevel {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ BloodGlucoseLevel[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final float mValue;
    public static final BloodGlucoseLevel UNKNOWN = new BloodGlucoseLevel("UNKNOWN", 0, 0.0f);
    public static final BloodGlucoseLevel START = new BloodGlucoseLevel("START", 1, 3.4f);
    public static final BloodGlucoseLevel NORMAL = new BloodGlucoseLevel("NORMAL", 2, 6.1f);
    public static final BloodGlucoseLevel PREDIABETES = new BloodGlucoseLevel("PREDIABETES", 3, 6.9f);
    public static final BloodGlucoseLevel DIABETES = new BloodGlucoseLevel("DIABETES", 4, 8.1f);

    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BloodGlucoseLevel getBloodGlucoseLevel(float f) {
            BloodGlucoseLevel bloodGlucoseLevel = BloodGlucoseLevel.NORMAL;
            if (f >= bloodGlucoseLevel.getMValue()) {
                BloodGlucoseLevel bloodGlucoseLevel2 = BloodGlucoseLevel.PREDIABETES;
                if (f > bloodGlucoseLevel2.getMValue()) {
                    BloodGlucoseLevel bloodGlucoseLevel3 = BloodGlucoseLevel.DIABETES;
                    if (f <= bloodGlucoseLevel3.getMValue()) {
                        return BloodGlucoseLevel.UNKNOWN;
                    }
                    return bloodGlucoseLevel3;
                }
                return bloodGlucoseLevel2;
            }
            return bloodGlucoseLevel;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BloodGlucoseLevel[] $values() {
        return new BloodGlucoseLevel[]{UNKNOWN, START, NORMAL, PREDIABETES, DIABETES};
    }

    static {
        BloodGlucoseLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private BloodGlucoseLevel(String str, int i, float f) {
        this.mValue = f;
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<BloodGlucoseLevel> getEntries() {
        return $ENTRIES;
    }

    public static BloodGlucoseLevel valueOf(String str) {
        return (BloodGlucoseLevel) Enum.valueOf(BloodGlucoseLevel.class, str);
    }

    public static BloodGlucoseLevel[] values() {
        return (BloodGlucoseLevel[]) $VALUES.clone();
    }

    public final float getMValue() {
        return this.mValue;
    }
}
