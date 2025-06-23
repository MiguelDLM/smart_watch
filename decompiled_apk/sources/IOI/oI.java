package IOI;

import java.time.Month;

/* loaded from: classes6.dex */
public final class oI {

    /* loaded from: classes6.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ kotlin.enums.oIX0oI<Month> f488oIX0oI;

        static {
            Month[] values;
            values = Month.values();
            f488oIX0oI = kotlin.enums.I0Io.I0Io(values);
        }
    }

    public static final int II0xO0(@OXOo.OOXIXo Month month) {
        int ordinal;
        kotlin.jvm.internal.IIX0o.x0xO0oo(month, "<this>");
        ordinal = month.ordinal();
        return ordinal + 1;
    }

    @OXOo.OOXIXo
    public static final Month oIX0oI(int i) {
        if (1 <= i && i < 13) {
            return oOoIIO0.oIX0oI(oIX0oI.f488oIX0oI.get(i - 1));
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}
