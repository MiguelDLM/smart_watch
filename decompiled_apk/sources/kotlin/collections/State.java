package kotlin.collections;

import com.facebook.internal.AnalyticsEvents;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
final class State {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ State[] $VALUES;
    public static final State Ready = new State("Ready", 0);
    public static final State NotReady = new State("NotReady", 1);
    public static final State Done = new State("Done", 2);
    public static final State Failed = new State(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, 3);

    private static final /* synthetic */ State[] $values() {
        return new State[]{Ready, NotReady, Done, Failed};
    }

    static {
        State[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.I0Io.I0Io($values);
    }

    private State(String str, int i) {
    }

    @OXOo.OOXIXo
    public static kotlin.enums.oIX0oI<State> getEntries() {
        return $ENTRIES;
    }

    public static State valueOf(String str) {
        return (State) Enum.valueOf(State.class, str);
    }

    public static State[] values() {
        return (State[]) $VALUES.clone();
    }
}
