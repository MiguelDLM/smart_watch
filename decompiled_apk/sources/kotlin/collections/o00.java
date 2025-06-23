package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.DeprecationLevel;
import kotlin.NotImplementedError;

/* loaded from: classes6.dex */
public class o00 extends xoXoI {
    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T> void I0oOIX(List<T> list, T t) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        Collections.fill(list, t);
    }

    public static <T extends Comparable<? super T>> void IoOoo(@OXOo.OOXIXo List<T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T> void OO(List<T> list, Random random) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(random, "random");
        Collections.shuffle(list, random);
    }

    public static <T> void OO0x0xX(@OXOo.OOXIXo List<T> list, @OXOo.OOXIXo Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @kotlin.XX(expression = "this.sortWith(comparator)", imports = {}))
    @xx0o0O.XO
    public static final <T> void x0xO(List<T> list, Comparator<? super T> comparator) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparator, "comparator");
        throw new NotImplementedError(null, 1, null);
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @kotlin.XX(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    @xx0o0O.XO
    public static final <T> void xoIxX(List<T> list, Oox.x0xO0oo<? super T, ? super T, Integer> comparison) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(comparison, "comparison");
        throw new NotImplementedError(null, 1, null);
    }

    @xx0o0O.XO
    @kotlin.oxxXoxO(version = "1.2")
    public static final <T> void xoxXI(List<T> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(list, "<this>");
        Collections.shuffle(list);
    }
}
