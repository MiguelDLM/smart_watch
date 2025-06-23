package kotlin.collections;

import java.util.List;

/* loaded from: classes6.dex */
public class O0xOxO extends OxI {
    @OXOo.OOXIXo
    public static <T> List<T> IXO(@OXOo.OOXIXo List<? extends T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return new xXOx(list);
    }

    public static final int IoXIXo(List<?> list, int i) {
        if (new X0.oOoXoXO(0, list.size()).xxIXOIIO(i)) {
            return list.size() - i;
        }
        throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new X0.oOoXoXO(0, list.size()) + "].");
    }

    public static final int Ix00oIoI(List<?> list, int i) {
        if (new X0.oOoXoXO(0, CollectionsKt__CollectionsKt.oo0xXOI0I(list)).xxIXOIIO(i)) {
            return CollectionsKt__CollectionsKt.oo0xXOI0I(list) - i;
        }
        throw new IndexOutOfBoundsException("Element index " + i + " must be in range [" + new X0.oOoXoXO(0, CollectionsKt__CollectionsKt.oo0xXOI0I(list)) + "].");
    }

    public static final int O0IxXx(List<?> list, int i) {
        return CollectionsKt__CollectionsKt.oo0xXOI0I(list) - i;
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "asReversedMutable")
    public static final <T> List<T> oI(@OXOo.OOXIXo List<T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        return new xo0x(list);
    }
}
