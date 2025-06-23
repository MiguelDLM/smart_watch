package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class Stage {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ Stage[] $VALUES;
    private final int stage;
    public static final Stage WARM_UP = new Stage("WARM_UP", 0, 0);
    public static final Stage GO_FOR = new Stage("GO_FOR", 1, 1);
    public static final Stage RECOVERY = new Stage("RECOVERY", 2, 2);
    public static final Stage REST_FOR = new Stage("REST_FOR", 3, 3);
    public static final Stage COOL_DOWN = new Stage("COOL_DOWN", 4, 4);
    public static final Stage OTHER = new Stage(oOoIIO0.oIX0oI.f32055oI0IIXIo, 5, 255);

    private static final /* synthetic */ Stage[] $values() {
        return new Stage[]{WARM_UP, GO_FOR, RECOVERY, REST_FOR, COOL_DOWN, OTHER};
    }

    static {
        Stage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private Stage(String str, int i, int i2) {
        this.stage = i2;
    }

    @OOXIXo
    public static oIX0oI<Stage> getEntries() {
        return $ENTRIES;
    }

    public static Stage valueOf(String str) {
        return (Stage) Enum.valueOf(Stage.class, str);
    }

    public static Stage[] values() {
        return (Stage[]) $VALUES.clone();
    }

    public final int getStage() {
        return this.stage;
    }
}
