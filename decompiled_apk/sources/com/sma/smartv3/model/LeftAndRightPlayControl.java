package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class LeftAndRightPlayControl {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ LeftAndRightPlayControl[] $VALUES;
    private final int model;
    public static final LeftAndRightPlayControl LEFT = new LeftAndRightPlayControl("LEFT", 0, 1);
    public static final LeftAndRightPlayControl RIGHT = new LeftAndRightPlayControl("RIGHT", 1, 2);
    public static final LeftAndRightPlayControl LEFT_AND_RIGHT = new LeftAndRightPlayControl("LEFT_AND_RIGHT", 2, 3);

    private static final /* synthetic */ LeftAndRightPlayControl[] $values() {
        return new LeftAndRightPlayControl[]{LEFT, RIGHT, LEFT_AND_RIGHT};
    }

    static {
        LeftAndRightPlayControl[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private LeftAndRightPlayControl(String str, int i, int i2) {
        this.model = i2;
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<LeftAndRightPlayControl> getEntries() {
        return $ENTRIES;
    }

    public static LeftAndRightPlayControl valueOf(String str) {
        return (LeftAndRightPlayControl) Enum.valueOf(LeftAndRightPlayControl.class, str);
    }

    public static LeftAndRightPlayControl[] values() {
        return (LeftAndRightPlayControl[]) $VALUES.clone();
    }

    public final int getModel() {
        return this.model;
    }
}
