package kotlin.reflect;

import kotlin.oxxXoxO;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@oxxXoxO(version = "1.1")
/* loaded from: classes6.dex */
public final class KVariance {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ KVariance[] $VALUES;
    public static final KVariance INVARIANT = new KVariance("INVARIANT", 0);
    public static final KVariance IN = new KVariance("IN", 1);
    public static final KVariance OUT = new KVariance("OUT", 2);

    private static final /* synthetic */ KVariance[] $values() {
        return new KVariance[]{INVARIANT, IN, OUT};
    }

    static {
        KVariance[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.I0Io.I0Io($values);
    }

    private KVariance(String str, int i) {
    }

    @OXOo.OOXIXo
    public static kotlin.enums.oIX0oI<KVariance> getEntries() {
        return $ENTRIES;
    }

    public static KVariance valueOf(String str) {
        return (KVariance) Enum.valueOf(KVariance.class, str);
    }

    public static KVariance[] values() {
        return (KVariance[]) $VALUES.clone();
    }
}
