package kotlin.collections.builders;

import OXOo.OOXIXo;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
/* loaded from: classes6.dex */
public final class II0xO0 {
    public static final <T> boolean II0XooXoX(T[] tArr, int i, int i2, List<?> list) {
        if (i2 != list.size()) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (!IIX0o.Oxx0IOOO(tArr[i + i3], list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final <E> void Oxx0IOOO(@OOXIXo E[] eArr, int i, int i2) {
        IIX0o.x0xO0oo(eArr, "<this>");
        while (i < i2) {
            XO(eArr, i);
            i++;
        }
    }

    @OOXIXo
    public static final <T> T[] X0o0xo(@OOXIXo T[] tArr, int i) {
        IIX0o.x0xO0oo(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i);
        IIX0o.oO(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <E> void XO(@OOXIXo E[] eArr, int i) {
        IIX0o.x0xO0oo(eArr, "<this>");
        eArr[i] = null;
    }

    @OOXIXo
    public static final <E> E[] oxoX(int i) {
        if (i >= 0) {
            return (E[]) new Object[i];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final <T> String xoIox(T[] tArr, int i, int i2, Collection<? extends T> collection) {
        StringBuilder sb = new StringBuilder((i2 * 3) + 2);
        sb.append("[");
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            T t = tArr[i + i3];
            if (t == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(t);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "toString(...)");
        return sb2;
    }

    public static final <T> int xxIXOIIO(T[] tArr, int i, int i2) {
        int i3;
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            T t = tArr[i + i5];
            int i6 = i4 * 31;
            if (t != null) {
                i3 = t.hashCode();
            } else {
                i3 = 0;
            }
            i4 = i6 + i3;
        }
        return i4;
    }
}
