package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class SegmentActivity {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ SegmentActivity[] $VALUES;
    private final int activity;
    public static final SegmentActivity TIMER = new SegmentActivity("TIMER", 0, 0);
    public static final SegmentActivity RUN = new SegmentActivity("RUN", 1, 1);
    public static final SegmentActivity JUMP_JACKS = new SegmentActivity("JUMP_JACKS", 2, 2);
    public static final SegmentActivity PUSH_UP = new SegmentActivity("PUSH_UP", 3, 3);
    public static final SegmentActivity DISTANCE = new SegmentActivity("DISTANCE", 4, 4);
    public static final SegmentActivity RUN_FAST = new SegmentActivity("RUN_FAST", 5, 5);
    public static final SegmentActivity WALK = new SegmentActivity("WALK", 6, 6);
    public static final SegmentActivity SWIM = new SegmentActivity("SWIM", 7, 7);
    public static final SegmentActivity BICYCLE = new SegmentActivity("BICYCLE", 8, 8);
    public static final SegmentActivity WORKOUT = new SegmentActivity("WORKOUT", 9, 9);
    public static final SegmentActivity REST = new SegmentActivity("REST", 10, 10);
    public static final SegmentActivity STRETCH = new SegmentActivity("STRETCH", 11, 11);
    public static final SegmentActivity SPINNING = new SegmentActivity("SPINNING", 12, 12);
    public static final SegmentActivity SIT_UP = new SegmentActivity("SIT_UP", 13, 15);
    public static final SegmentActivity WARM_UP = new SegmentActivity("WARM_UP", 14, 16);
    public static final SegmentActivity COOL_DOWN = new SegmentActivity("COOL_DOWN", 15, 17);

    private static final /* synthetic */ SegmentActivity[] $values() {
        return new SegmentActivity[]{TIMER, RUN, JUMP_JACKS, PUSH_UP, DISTANCE, RUN_FAST, WALK, SWIM, BICYCLE, WORKOUT, REST, STRETCH, SPINNING, SIT_UP, WARM_UP, COOL_DOWN};
    }

    static {
        SegmentActivity[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private SegmentActivity(String str, int i, int i2) {
        this.activity = i2;
    }

    @OOXIXo
    public static oIX0oI<SegmentActivity> getEntries() {
        return $ENTRIES;
    }

    public static SegmentActivity valueOf(String str) {
        return (SegmentActivity) Enum.valueOf(SegmentActivity.class, str);
    }

    public static SegmentActivity[] values() {
        return (SegmentActivity[]) $VALUES.clone();
    }

    public final int getActivity() {
        return this.activity;
    }
}
