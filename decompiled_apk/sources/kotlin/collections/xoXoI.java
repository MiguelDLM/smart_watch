package kotlin.collections;

import java.util.Iterator;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public class xoXoI extends IIXOooo {
    @OXOo.OOXIXo
    public static final <T> Iterator<xI<T>> O0Xx(@OXOo.OOXIXo Iterator<? extends T> it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "<this>");
        return new IoOoX(it);
    }

    public static final <T> void Xo0(@OXOo.OOXIXo Iterator<? extends T> it, @OXOo.OOXIXo Oox.oOoXoXO<? super T, oXIO0o0XI> operation) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(operation, "operation");
        while (it.hasNext()) {
            operation.invoke(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @xx0o0O.XO
    public static final <T> Iterator<T> XoI0Ixx0(Iterator<? extends T> it) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(it, "<this>");
        return it;
    }
}
