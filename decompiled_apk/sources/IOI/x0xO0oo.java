package IOI;

import java.time.DayOfWeek;

/* loaded from: classes6.dex */
public final class x0xO0oo {

    /* loaded from: classes6.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ kotlin.enums.oIX0oI<DayOfWeek> f512oIX0oI;

        static {
            DayOfWeek[] values;
            values = DayOfWeek.values();
            f512oIX0oI = kotlin.enums.I0Io.I0Io(values);
        }
    }

    public static final int II0xO0(@OXOo.OOXIXo DayOfWeek dayOfWeek) {
        int ordinal;
        kotlin.jvm.internal.IIX0o.x0xO0oo(dayOfWeek, "<this>");
        ordinal = dayOfWeek.ordinal();
        return ordinal + 1;
    }

    @OXOo.OOXIXo
    public static final DayOfWeek oIX0oI(int i) {
        if (1 <= i && i < 8) {
            return x0XOIxOo.oIX0oI(oIX0oI.f512oIX0oI.get(i - 1));
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}
