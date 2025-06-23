package kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

@XO0OX.xxIXOIIO(name = "TuplesKt")
/* loaded from: classes6.dex */
public final class Xo0 {
    @OXOo.OOXIXo
    public static final <T> List<T> I0Io(@OXOo.OOXIXo Triple<? extends T, ? extends T, ? extends T> triple) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(triple, "<this>");
        return CollectionsKt__CollectionsKt.X00IoxXI(triple.getFirst(), triple.getSecond(), triple.getThird());
    }

    @OXOo.OOXIXo
    public static final <T> List<T> II0xO0(@OXOo.OOXIXo Pair<? extends T, ? extends T> pair) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(pair, "<this>");
        return CollectionsKt__CollectionsKt.X00IoxXI(pair.getFirst(), pair.getSecond());
    }

    @OXOo.OOXIXo
    public static final <A, B> Pair<A, B> oIX0oI(A a2, B b) {
        return new Pair<>(a2, b);
    }
}
